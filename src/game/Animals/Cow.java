package game.Animals;

import game.VirtualPet;
import game.VirtualZoo;

public class Cow extends VirtualPet{
    public Cow(int x, int y, VirtualZoo zoo) {
        super(x, y, "cow-idle.png", 3, "Cow", "Mamífero", 50, zoo);
    }
}
