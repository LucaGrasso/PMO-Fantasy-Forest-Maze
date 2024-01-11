package it.lucagrasso.views.controller;

/**
 * @author lgras  on  25/10/2023
 * @project fantasy-forest-maze
 */


import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Window;
import javafx.stage.Stage;
import it.lucagrasso.models.dao.DatabaseConnectionSingleton;
import it.lucagrasso.models.dao.PlayerDAO;
import java.io.IOException;
import java.sql.SQLException;

public class LoginFormController extends GeneralController{
    @FXML
    private TextField userField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private RadioButton registrationOption;
    @FXML
    private Button submitButton;
    @FXML
    private Rectangle serverStatus;
    @FXML
    private Label serverStatusText;
    @FXML
    private GridPane gridLogin;

    // Sesso del nuovo registrato
    private String gender;


    private void setServerStatusAndDisableFields(boolean condition) {
        this.serverStatus.setId(condition ? "isOnRectangle" : "isOffRectangle");
        this.serverStatusText.setText(condition ? "Server OnLine" : "OFFLINE");
        this.userField.setDisable(!condition);
        this.passwordField.setDisable(!condition);
        this.registrationOption.setDisable(!condition);
    }

    @FXML
    private void initialize() {
        try {
            boolean isOnDB = DatabaseConnectionSingleton.getInstance().getDbOnline();
            setServerStatusAndDisableFields(isOnDB);
            registrationOption.setOnAction(actionEvent -> this.addRegistrationLayer());
        } catch (Exception e) {
            setServerStatusAndDisableFields(false);
        }
    }

    private void createAndConfigureRadioButton(ToggleGroup group, String text, String id, String genderValue) {
        RadioButton radioButton = new RadioButton();
        radioButton.setText(text);
        radioButton.setId(id);
        radioButton.setToggleGroup(group);
        radioButton.setOnAction(actionEvent -> this.gender = genderValue);
        gridLogin.add(radioButton, id.equals("maleRbtn") ? 1 : id.equals("femaleRbtn") ? 2 : 3, 5);
    }


    @FXML
    private void addRegistrationLayer() {
        if (registrationOption.isSelected()) {
            final ToggleGroup group = new ToggleGroup();
            createAndConfigureRadioButton(group, "Male", "maleRbtn", "M");
            createAndConfigureRadioButton(group, "Female", "femaleRbtn", "F");
            createAndConfigureRadioButton(group, "Gender X", "fluidRbtn", "X");
        } else {
            gridLogin.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 5);
        }
    }
    @FXML
    protected void handleSubmitButtonAction() throws Exception {

        Window owner = submitButton.getScene().getWindow();

        // Verifica se il server è online e se è possibile connettersi al database
        // Se non è possibile connettersi al database, mi connetto al gioco in modalità offline o in modalità demo



        // Verifica se i campi sono vuoti
        if (userField.getText().isEmpty() || passwordField.getText().isEmpty() || userField.getText().length() < 3) {
            showAlert(Alert.AlertType.ERROR, owner, "Data Error!",
                    "Please enter your name");
            return;
        }

        // Verifica se la password è valida
        if (passwordField.getText().length() < 4 && passwordField.getText().length() > 20) {
            showAlert(Alert.AlertType.ERROR, owner, "Password Error!",
                    "Please enter a password with at least 8 characters and at most 20 characters");
            return;
        }



        PlayerDAO player = new PlayerDAO(userField.getText(), passwordField.getText());

        if (!registrationOption.isSelected() && player.getIsPlayerUniquePresent()) {
            Login();
            return;
        }

        if (registrationOption.isSelected() && player.getIsPlayerUniquePresent()) {
            infoBox("User già presente", null, "Failed");
        } else {
            player.setRegistrationPlayer(this.gender);
            Login();
        }
    }

    private void Login() throws IOException {
        Stage stage;
        stage = (Stage) submitButton.getScene().getWindow();
        new SceneController("02_LaunchPage", stage, 800, 600);
    }

    public static void infoBox(String infoMessage, String headerText, String title) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }

    public static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }


    // TODO da valutare in futuro
//    private void loadScene (String nameScene) throws IOException {
//
//        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/views/" + nameScene + ".fxml")));
//        Stage windows = new Stage();
//        windows.setScene(new Scene(root, 800, 600));
//    }

}







