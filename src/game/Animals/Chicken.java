package game.Animals;

import game.VirtualPet;
import game.VirtualZoo;

public class Chicken extends VirtualPet{
    public Chicken(int x, int y, VirtualZoo zoo) {
        super(x, y, "chicken.png", 13, "Chicken", "Ave", 15, zoo);
    }
}
