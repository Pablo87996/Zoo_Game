package game.GUI;

import jplay.GameImage;
import jplay.URL;

public class ButtonExit extends GameImage{

    public ButtonExit(int x, int y) {
        super(URL.sprite("button-exit.png"));
        this.x = x;
        this.y = y;
    }
}
