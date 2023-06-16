package game.Animals;

import game.VirtualPet;
import game.VirtualZoo;

public class Rino extends VirtualPet{
    public Rino(int x, int y, VirtualZoo zoo) {
        super(x, y, "rino.png", 11, "Rino", "Mamífero", 100, zoo);
    }
}
