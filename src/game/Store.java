package game;

import jplay.Sprite;
import jplay.URL;

public class Store extends Sprite{
    public Store(int x, int y) {
        super(URL.sprite("store2.png"), 1);
        this.x = x;
        this.y = y;
    }
}
