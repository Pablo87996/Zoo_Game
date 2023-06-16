package game;

import jplay.Sprite;

public class Food extends Sprite{
    private String name;
    private Cage cage;
    private int calories;
    private int cageNumber;

    public Food(int x, int y, String sprite, int numFrames, int calories, String name) {
        super(sprite, numFrames);
        this.x = x;
        this.y = y;
        this.calories = calories;
        this.name = name;
    }
    
    public Integer getCalories(){
        return this.calories;
    }

    public void setCalories(int calories){
        this.calories = calories;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setName(String name){
        this.name = name;
    }

    public int getCageNumber() {
        return this.cageNumber;
    }

    public void setCageNumber(int cageNumber) {
        this.cageNumber = cageNumber;
    }

    public Cage getCage() {
        return this.cage;
    }

    public void setCage(Cage cage) {
        this.cage = cage;
    }
}
