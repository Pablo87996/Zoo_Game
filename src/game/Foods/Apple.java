package game.Foods;

import game.Food;
import jplay.URL;

public class Apple extends Food{
    private boolean wormInApple;
    private int wormNumber;
    
    public Apple(int x, int y) {
        super(x, y, URL.sprite("apple2.png"), 2, 10, "Apple");
        this.wormNumber = (int) Math.floor(Math.random() * 10);

        if(wormNumber == 1){
            this.wormInApple = true;
            this.setCurrFrame(1);
        }else{
            this.wormInApple = false;
            this.setCurrFrame(0);
        }
    }

    public boolean getWormInApple() {
        return this.wormInApple;
    }

    public void setWormInApple(boolean wormInApple) {
        this.wormInApple = wormInApple;
    }

    public int getWormNumber() {
        return this.wormNumber;
    }

    public void setWormNumber(int wormNumber) {
        this.wormNumber = wormNumber;
    }
}
