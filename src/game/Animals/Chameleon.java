package game.Animals;

import game.VirtualPet;
import game.VirtualZoo;

public class Chameleon extends VirtualPet{
    public Chameleon(int x, int y, VirtualZoo zoo) {
        super(x, y, "chameleon.png", 13, "Chameleon", "Réptil", 20, zoo);
    }
}
