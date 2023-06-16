package game;

import jplay.Sprite;
import jplay.URL;
import game.Foods.Apple;
import game.GUI.CalorieBar;

public class VirtualPet extends Sprite{
    private CalorieBar calorieBar;
    private VirtualZoo zoo;
    private boolean animation = false;
    private boolean idle = true;
    private String petName;
    private String type;
    private Cage cage;
    private int currentCalories;
    private int fullCalories;
    private int hungryLvl = 0;
    private int cageNumber;
    private int d = 0;
    private int preHungry = 0;

    public VirtualPet(int x, int y, String sprite, int numFrames, String name, String type, int fullCalories, VirtualZoo zoo){
        super(URL.sprite(sprite), numFrames);
        this.x = x;
        this.y = y;
        this.petName = name;
        this.type = type;
        this.fullCalories = fullCalories;
        this.zoo = zoo;
        this.calorieBar = new CalorieBar(x, y);
        
        this.setTotalDuration(600);
        this.currentCalories();
    }

    public void calorieBarPosition(){
        this.calorieBar.setX(this.getX());
        this.calorieBar.setY(this.getY()-50);
    }

    public void animation(){
        if(!this.animation){
            update();
        }
    }
    
    public void walk(){
        this.moveX(0.05);
        this.moveY(0.05);
    }

    public void preHungry(){
        if(this.preHungry == 5){
            this.preHungry = 0;
            this.currentCalories = this.currentCalories - this.currentCalories/4;
        }
    }

    public void currentCalories(){
        int calories = (int) Math.floor(this.fullCalories/2 + Math.random() * this.fullCalories);

        if(calories <= this.fullCalories){
            this.currentCalories = calories;
        }else{
            this.currentCalories();
        }
    }

    public boolean eat(Food food){
        int e30[] = {0, 1, 2};
        int e60[] = {0, 1, 2, 3, 4, 5};
        
        if(this.idle){
            this.d = (int) Math.floor(Math.random() * 10);
        }

        if(this.hungryLvl == 1){
            for(int i=0; i<3; i++){
                if(d == e30[i]){
                    this.idle = this.moveToFood(food);
                }else{
                    this.idle = false;
                }
            }
        }else if(this.hungryLvl == 2){
            for(int i=0; i<6; i++){
                if(d == e60[i]){
                    this.idle = this.moveToFood(food);
                }else{
                    this.idle = false;
                }
            }
        }else if(this.hungryLvl == 3){
            this.idle = this.moveToFood(food);
            this.idle = this.eat();
        }
        
        return this.idle;
    }

    public boolean eat(){
        if(this.hungryLvl == 3){
            this.idle = moveToPet();
        }
        
        return this.idle;
    }

    private boolean moveToPet(){
        VirtualPet petFood;

        for(int i=0; i<this.cage.getPets().size(); i++) {
            if(this.cage.getPets().get(i) != this){
                petFood = this.cage.getPets().get(i);

                this.moveTo(petFood.getX(), petFood.getY(), 0.8);
        
                if(this.collided(petFood)){
                    this.currentCalories = this.currentCalories + petFood.getCurrentCalories();
                    this.cage.getPets().remove(petFood);

                    System.out.println(petFood.getPetName() + " is died.");
                    
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean moveToFood(Food food){
        if(this.getX() == food.getX()){
            this.moveTo(food.getX(), food.getY(), 0.5);
        }else{
            this.moveTo(food.getX(), this.getY(), 0.5);
        }
        
        if(this.collided(food)){
            this.cage.getFoods().remove(food);
            
            if(food.getClass().getName() == "game.Foods.Apple"){
                if(((Apple)food).getWormInApple()){
                    this.setCurrentCalories((int) Math.floor(this.currentCalories / 2));
                }else{
                    this.setCurrentCalories(this.currentCalories + food.getCalories());
                }
            }else{
                this.setCurrentCalories(this.currentCalories + food.getCalories());
            }
            
            return true;
        }
        
        return false;
    }

    public void die(){
        if(this.currentCalories <= 1){
            this.cage.getPets().remove(this);
            this.update();
            System.out.println(this.petName + " is died.");
        }
    }

    public void hungryLvl(){
        if(this.currentCalories == this.fullCalories){
            this.hungryLvl = 0;
            this.calorieBar.setCurrFrame(0);
        }else if(this.currentCalories >= (3 * this.fullCalories) / 4){
            this.hungryLvl = 1;
            this.calorieBar.setCurrFrame(1);
        }else if(this.currentCalories >= this.fullCalories / 2){
            this.hungryLvl = 2;
            this.calorieBar.setCurrFrame(2);
        }else{
            this.hungryLvl = 3;
            this.calorieBar.setCurrFrame(3);
        }
    }
    
    public String getPetName() {
        return this.petName;
    }
    
    public void setPetName(String petName) {
        this.petName = petName;
    }
    
    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public int getCurrentCalories() {
        return this.currentCalories;
    }
    
    public void setCurrentCalories(int currentCalories) {
        if(currentCalories <= this.fullCalories){
            this.currentCalories = currentCalories;
        }else if(this.currentCalories < this.fullCalories){
            this.currentCalories = this.fullCalories;
        }else{
            System.out.println("The maximum " + this.petName + "'s calories is " + this.fullCalories);
        }

        this.calorieBar.draw();
    }
    
    public int getHungryLvl() {
        return this.hungryLvl;
    }

    public void setHungryLvl(int hungryLvl) {
        if(hungryLvl >= 0 && hungryLvl <= 3){
            this.hungryLvl = hungryLvl;
        }else{
            System.out.println("The hungry level must be a number between 0 and 3.");
        }
    }

    public VirtualZoo getZoo() {
        return this.zoo;
    }
    
    public void setZoo(VirtualZoo zoo) {
        this.zoo = zoo;
    }
    
    public int getCageNumber() {
        return this.cageNumber;
    }
    
    public void setCageNumber(int cageNumber) {
        if(cageNumber <= 8){
            this.cageNumber = cageNumber;
        }else{
            System.out.println("The cageNumber must be under 9.");
        }
    }

    public Cage getCage() {
        return this.cage;
    }
    
    public void setCage(Cage cage) {
        this.cage = cage;
    }

    public int getFullCalories() {
        return this.fullCalories;
    }

    public void setFullCalories(int fullCalories) {
        if(fullCalories <= this.fullCalories){
            this.fullCalories = fullCalories;
        }else{
            System.out.println("The maximum " + this.petName + "'s calories is " + this.fullCalories);
        }
    }

    public boolean getIdle() {
        return this.idle;
    }

    public void setIdle(boolean idle) {
        this.idle = idle;
    }
    
    public int getPreHungry() {
        return this.preHungry;
    }

    public void setPreHungry(int preHungry) {
        this.preHungry = preHungry;
    }

    public CalorieBar getCalorieBar() {
        return this.calorieBar;
    }
}
