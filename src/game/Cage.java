package game;

import java.util.ArrayList;

public class Cage {
    private ArrayList<VirtualPet> pets = new ArrayList<>();
    private ArrayList<Food> foods = new ArrayList<>();
    private int Cagenumber;
    
    public int getCageNumber() {
        return this.Cagenumber;
    }
    public void setCageNumber(int Cagenumber) {
        this.Cagenumber = Cagenumber;
    }
    public ArrayList<VirtualPet> getPets() {
        return this.pets;
    }
    public void setPets(ArrayList<VirtualPet> pets) {
        this.pets = pets;
    }
    public ArrayList<Food> getFoods() {
        return this.foods;
    }
    public void setFoods(ArrayList<Food> foods) {
        this.foods = foods;
    }
}
