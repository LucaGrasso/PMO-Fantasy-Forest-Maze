package it.lucagrasso.utilities;

import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

/**
 * @author lgras  on  15/10/2023
 * @project PMO-Fantasy-Forest-Maze

    - Creazione di una Classe Singleton, per la gestione di un logger Gestore degli errori.
    - Il logger copia eventuali Errori o Warning in un File di Testo.
    - Se ho un eccezione qualsiasi a livello di IO con la gestione del File, Si apre una finestra
    - che mi indica questo errore.

 */

public class ExceptionLogger {
    private static ExceptionLogger instance;
    private FileWriter logFile;

    private ExceptionLogger() {
        try {
            logFile = new FileWriter("error.log", true);
        } catch (IOException e) {
            // Se non riusciamo a creare  il file, mostriamo una finestra di errore
            showErrorDialog("Errore durante l'inizializzazione del registro.", e);
        }
    }


    public static ExceptionLogger getInstance() {
        if (instance == null) {
            instance = new ExceptionLogger();
        }
        return instance;
    }
    public void logException(String customMessage, Exception e) {
        try {
            logFile.write(new Date() + ": ");
            logFile.write(customMessage + " - " + e.toString());  // Aggiunge la stringa di errore
            logFile.write(System.lineSeparator());
            logFile.flush();
        } catch (IOException ioException) {
            // Se non riusciamo a creare  il file, mostriamo una finestra di errore
            showErrorDialog("Errore durante l'inizializzazione del registro.", ioException);
        }
    }

    // solo chiudendo il file finisce il Singleton
    public void closeLogFile() {
        try {
            logFile.close();
        } catch (IOException ex) {
            // Se non riusciamo a creare  il file, mostriamo una finestra di errore
            showErrorDialog("Errore durante l'inizializzazione del registro.", ex);
        }
    }
    // Metodo per mostrare una finestra di errore
    private void showErrorDialog(String message, Exception e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Errore");
        alert.setHeaderText("Si è verificato un errore");
        alert.setContentText(message);

        // Aggiungiamo la traccia dell'eccezione come dettaglio
        if (e != null) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            String exceptionText = sw.toString();
            TextArea textArea = new TextArea(exceptionText);
            alert.getDialogPane().setExpandableContent(textArea);
        }

        alert.showAndWait();
    }


}
