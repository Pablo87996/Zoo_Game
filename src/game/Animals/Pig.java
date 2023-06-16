package game.Animals;

import game.VirtualPet;
import game.VirtualZoo;

public class Pig extends VirtualPet{
    public Pig(int x, int y, VirtualZoo zoo) {
        super(x, y, "pig.png", 9, "Pig", "Mamífero", 30, zoo);
    }
}
