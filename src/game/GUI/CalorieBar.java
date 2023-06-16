package game.GUI;

import jplay.Sprite;
import jplay.URL;

public class CalorieBar extends Sprite{

    public CalorieBar(double x, double y) {
        super(URL.sprite("calories.png"), 4);
        this.x = x;
        this.y = y;
    }
}
