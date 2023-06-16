package game.Animals;

import game.VirtualPet;
import game.VirtualZoo;

public class Dino extends VirtualPet{
    public Dino(int x, int y, VirtualZoo zoo) {
        super(x, y, "dino-idle.png", 4, "Dino", "Réptil", 500, zoo);
    }
}
