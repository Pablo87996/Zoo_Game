package game.Animals;

import game.VirtualPet;
import game.VirtualZoo;

public class Duck extends VirtualPet{
    public Duck(int x, int y, VirtualZoo zoo) {
        super(x, y, "duck.png", 10, "Duck", "Ave", 15, zoo);
    }
}
