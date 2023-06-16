package game;

import jplay.Sound;

public class VirtualZoo {
    private Cage cages[] = new Cage[8];

    public VirtualZoo(){
        this.cages[0] = new Cage();
        this.cages[1] = new Cage();
        this.cages[2] = new Cage();
        this.cages[3] = new Cage();
        this.cages[4] = new Cage();
        this.cages[5] = new Cage();
        this.cages[6] = new Cage();
        this.cages[7] = new Cage();
    }
    
    public void sendSound(VirtualPet pet){
        new Sound("src/recursos/audios/" + pet.getPetName().toLowerCase() + ".wav").play();
    }

    public Cage[] getCages() {
        return this.cages;
    }

    public Cage getCages(int index) {
        return this.cages[index];
    }
    
    public void setCages(int index, Cage cage) {
        this.cages[index] = cage;
    }
}
