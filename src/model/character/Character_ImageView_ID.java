package model.character;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * @author lgras  on  29/05/2022
 * @project interactive-maze
 */

public class Character_ImageView_ID extends ImageView {
    private final String nameId;

    public Character_ImageView_ID(Image image, String nameId) {
        super(image);
        this.nameId = nameId;
    }

    public String getNameId() {
        return nameId;
    }
}
