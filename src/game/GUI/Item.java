package game.GUI;

import jplay.Sprite;
import jplay.URL;

public class Item extends Sprite{
    private int slot;
    private Sprite item;

    public Item(int x, int y, String sprite, int slot) {
        super(URL.sprite(sprite));
        this.x = x;
        this.y = y;
        this.slot = slot;
    }
    
    public int getSlot() {
        return this.slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }
    
    public Sprite getItem() {
        return this.item;
    }

    public void setItem(Sprite item) {
        this.item = item;
    }
}
