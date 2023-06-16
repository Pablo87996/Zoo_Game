package game.GUI;

import jplay.GameImage;
import jplay.URL;

public class Card extends GameImage{
    public Card(int x, int y, String sprite) {
        super(URL.sprite(sprite));
        this.x = x;
        this.y = y;
    }
}
