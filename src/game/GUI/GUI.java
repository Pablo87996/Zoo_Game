package game.GUI;

import jplay.GameImage;
import jplay.URL;

public class GUI extends GameImage{
    public GUI(){
        super(URL.sprite("store-ui.png"));
        this.x = 110;
        this.y = 100;
    }
}
