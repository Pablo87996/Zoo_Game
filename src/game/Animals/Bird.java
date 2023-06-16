package game.Animals;

import game.VirtualPet;
import game.VirtualZoo;

public class Bird extends VirtualPet{
    public Bird(int x, int y, VirtualZoo zoo) {
        super(x, y, "bird.png", 8, "Bird", "Ave", 10, zoo);
    }
}
