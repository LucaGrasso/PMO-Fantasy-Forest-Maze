package application.models;

import java.util.ArrayList;

import javafx.scene.image.Image;

/**
 * @author lgras  on  29/05/2022
 *
 * Class Singleton with Thread Save
 */

public class CharacterModel {

    //Class Singleton

    private static volatile CharacterModel instance; // Variable for principal memory Singleton

    private final String url_Character;
    private final String headNameFile;
    private final String bodyNameFile;
    private String headNameID;
    private String bodyNameID;
    private final int totCharacter;
    private int currentCharacter_Int;
    private final ArrayList<String> imageName = new ArrayList<>();
    private final ArrayList<String> pathName = new ArrayList<>();

    private final ArrayList<Image> array_Image = new ArrayList<>();

    private CharacterModel() {
        Setup init = new Setup();
        this.url_Character = init.getUrl_character();
        this.totCharacter = init.getTotChar();
        this.currentCharacter_Int = 1;
        this.headNameFile = init.getHead_File_Name();
        this.bodyNameFile = init.getBody_File_Name();
        this.bodyNameID = this.bodyNameFile + "1";
        this.headNameID = this.headNameFile + "1";
        fill_Arrays(currentCharacter_Int);
    }

    // Singleton with Thread Save
    public static CharacterModel getInstance() {
        if(instance == null) {
            synchronized (CharacterModel.class) {
                if (instance == null)
                    instance = new CharacterModel();
            }
        }
        return instance;
    }

    private void  fill_Arrays(int character) {
        for (int i = 0; i < 3; i++) {
            imageName.add(headNameFile + (i + 1));
            pathName.add(url_Character + character + headNameFile + (i + 1) + ".png");
            array_Image.add(new Image(url_Character + character + headNameFile + (i + 1) + ".png"));
        }
        for (int i = 0; i < 3; i++) {
            imageName.add(bodyNameFile + (i + 1));
            pathName.add(url_Character + character + bodyNameFile + (i + 1) + ".png");
            array_Image.add(new Image(url_Character + character + bodyNameFile + (i + 1) + ".png"));
        }
    }


    // Setter Sections

    public void setCurrentCharacter(int currentCharacter){
        this.currentCharacter_Int = currentCharacter;
        if (!pathName.isEmpty()) pathName.clear();
        if (!imageName.isEmpty()) imageName.clear();
        if (!array_Image.isEmpty()) array_Image.clear();
        fill_Arrays(currentCharacter);
    }

    public void setBodyNameID(String bodyNameID) {

        this.bodyNameID = bodyNameID;
    }

    public void setHeadNameID(String headNameID) {

        this.headNameID = headNameID;
    }


    // Getter Section

    public ArrayList<String> getImageName() {

        return imageName;
    }

    public ArrayList<String> getPathName() {
        return pathName;
    }

    public int getTotInt_Character() {

        return totCharacter;
    }

    public int getCurrentInt_Character(){
        return this.currentCharacter_Int;

    }

    public String getCurrent_Combination_Character() {
        return headNameID + bodyNameID;

    }

    public Image getCurrentImage_Character() {
        return new Image(url_Character + currentCharacter_Int + "character" + headNameID + bodyNameID + ".png");
    }

    public String getURL_Character_Selected() {
        return (url_Character + currentCharacter_Int + "character" + headNameID + bodyNameID + ".png");
    }

    public Image getRandomImage_Character() {
        int randomInt = (int) (Math.random() * ((totCharacter + 1) - 1)) + 1;
        int headInt = (int) (Math.random() * (4 - 1)) + 1;
        int bodyInt = (int) (Math.random() * (4 - 1)) + 1;

        return new Image(url_Character + randomInt + "character" + headNameFile + (headInt) + bodyNameFile + (bodyInt) + ".png");
    }

    // Array first 3 element Head last 3 Body
    public ArrayList<Image> getImage_Character(){
        return this.array_Image;
    }




}
