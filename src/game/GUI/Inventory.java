package game.GUI;

import java.util.ArrayList;
import game.Food;
import game.VirtualPet;
import game.VirtualZoo;
import jplay.Mouse;
import jplay.Sprite;
import jplay.URL;

public class Inventory extends Sprite{
    private ArrayList<String> freeSlots = new ArrayList<>();
    private ArrayList<Item> slots = new ArrayList<>();
    private VirtualZoo zoo;
    private boolean selected;
    private int fullSlots = 0;
    private int selectedSlot;

    public Inventory(int x, int y, VirtualZoo zoo) {
        super(URL.sprite("slots.png"), 5);
        this.x = x;
        this.y = y;

        this.setCurrFrame(0);
        this.zoo = zoo;

        this.freeSlots.add("0");
        this.freeSlots.add("1");
        this.freeSlots.add("2");
        this.freeSlots.add("3");
    }
    
    public void addToSlot(String sprite, Sprite obj){
        this.verifySlots(sprite);
        this.slots.get(getFullSlots()-1).setItem(obj);
    }

    private void verifySlots(String sprite){
        int slot = 5;

        for(int i=0; i<freeSlots.size(); i++){
            if(Integer.parseInt(this.freeSlots.get(i)) < slot){
                slot = Integer.parseInt(this.freeSlots.get(i));
            }
        }

        switch(slot){
            case 0:
                this.slots.add(new Item(930, 270, sprite, 0));
                this.fullSlots++;
                break;
            case 1:
                this.slots.add(new Item(930, 350, sprite, 1));
                this.fullSlots++;
                break;
            case 2:
                this.slots.add(new Item(930, 430, sprite, 2));
                this.fullSlots++;
                break;
            case 3:
                this.slots.add(new Item(930, 510, sprite, 3));
                this.fullSlots++;
                break;
            case 4:
                System.out.println("The inventory is full.");            
                break;
        }

        for(int i=0; i<this.getFullSlots(); i++){
            for(int j=0; j<4; j++){
                if(this.getSlots().get(i).getSlot() == j){
                    this.freeSlots.remove(this.slots.get(i).getSlot() + "");
                }
            }
        }
    }

    public void selectItem(int index, Mouse mouse){
        this.setCurrFrame(getSlots().get(index).getSlot()+1);
        this.setSelectedSlot(index);
        this.selected = true;
        
        this.slots.get(index).setX(mouse.getPosition().getX()-35);
        this.slots.get(index).setY(mouse.getPosition().getY()-35);
    }

    public void dropItem(Mouse mouse){
        if(this.slots.get(selectedSlot).getItem().getClass().getPackageName() == "game.Foods"){
            Food food = (Food) this.slots.get(selectedSlot).getItem();

            if(mouse.isOverArea(75, 84, 257, 193)){
                this.removeFood(food, mouse);
                food.setCageNumber(0);
                food.setCage(this.zoo.getCages(0));
            }else if(mouse.isOverArea(395, 84, 576, 193)){
                this.removeFood(food, mouse);
                food.setCageNumber(1);
                food.setCage(this.zoo.getCages(1));
            }else if(mouse.isOverArea(714, 84, 897, 193)){
                this.removeFood(food, mouse);
                food.setCageNumber(2);
                food.setCage(this.zoo.getCages(2));
            }else if(mouse.isOverArea(75, 341, 256, 450)){
                this.removeFood(food, mouse);
                food.setCageNumber(3);
                food.setCage(this.zoo.getCages(3));
            }else if(mouse.isOverArea(714, 341, 897, 450)){
                this.removeFood(food, mouse);
                food.setCageNumber(4);
                food.setCage(this.zoo.getCages(4));
            }else if(mouse.isOverArea(75, 596, 256, 706)){
                this.removeFood(food, mouse);
                food.setCageNumber(5);
                food.setCage(this.zoo.getCages(5));
            }else if(mouse.isOverArea(395, 596, 576, 706)){
                this.removeFood(food, mouse);
                food.setCageNumber(6);
                food.setCage(this.zoo.getCages(6));
            }else if(mouse.isOverArea(714, 596, 897, 706)){
                this.removeFood(food, mouse);
                food.setCageNumber(7);
                food.setCage(this.zoo.getCages(7));
            }else{
                System.out.println("Invalid position!");
            }

            if(food.getCage() != null){
                food.getCage().getFoods().add(food);

                for(int i=0; i<8; i++){
                    for(int j=0; j<this.zoo.getCages(i).getPets().size(); j++){
                        VirtualPet pet = this.zoo.getCages(i).getPets().get(j);

                        if(pet.getHungryLvl() == 0){
                            pet.setPreHungry(pet.getPreHungry() + 1);
                            pet.preHungry();
                        }
                    }
                }
            }
        }else{
            VirtualPet pet = (VirtualPet) this.getSlots().get(selectedSlot).getItem();

            if(mouse.isOverArea(75, 84, 257, 193)){
                this.removePet(pet, mouse, 130, 65);
                pet.setCageNumber(0);
                pet.setCage(this.zoo.getCages(0));
            }else if(mouse.isOverArea(395, 84, 576, 193)){
                this.removePet(pet, mouse, 450, 60);
                pet.setCageNumber(1);
                pet.setCage(this.zoo.getCages(1));
            }else if(mouse.isOverArea(714, 84, 897, 193)){
                this.removePet(pet, mouse, 760, 62);
                pet.setCageNumber(2);
                pet.setCage(this.zoo.getCages(2));
            }else if(mouse.isOverArea(75, 341, 256, 450)){
                this.removePet(pet, mouse, 150, 320);
                pet.setCageNumber(3);
                pet.setCage(this.zoo.getCages(3));
            }else if(mouse.isOverArea(714, 341, 897, 450)){
                this.removePet(pet, mouse, 780, 320);
                pet.setCageNumber(4);
                pet.setCage(this.zoo.getCages(4));
            }else if(mouse.isOverArea(75, 596, 256, 706)){
                this.removePet(pet, mouse, 140, 570);
                pet.setCageNumber(5);
                pet.setCage(this.zoo.getCages(5));
            }else if(mouse.isOverArea(395, 596, 576, 706)){
                this.removePet(pet, mouse, 440, 575);
                pet.setCageNumber(6);
                pet.setCage(this.zoo.getCages(6));
            }else if(mouse.isOverArea(714, 596, 897, 706)){
                this.removePet(pet, mouse, 720, 568);
                pet.setCageNumber(7);
                pet.setCage(this.zoo.getCages(7));
            }else{
                System.out.println("Invalid position!");
            }

            if(pet.getCage() != null){
                pet.getCage().getPets().add(pet);
            }
        }
    }
    
    private void removeFood(Food food, Mouse mouse) {
        food.setX(mouse.getPosition().getX()-35);
        food.setY(mouse.getPosition().getY()-35);
    
        this.setSelected(false);
        this.setCurrFrame(0);
        
        this.freeSlots.add(this.getSlots().get(getSelectedSlot()).getSlot() + "");
        this.slots.remove(getSelectedSlot());
        this.fullSlots--;
    }

    private void removePet(VirtualPet pet, Mouse mouse, int x, int y) {
        pet.setX(x);
        pet.setY(y);
    
        this.setSelected(false);
        this.setCurrFrame(0);
        
        this.freeSlots.add(this.getSlots().get(getSelectedSlot()).getSlot() + "");
        this.slots.remove(getSelectedSlot());
        this.fullSlots--;
    }

    public int getFullSlots() {
        return this.fullSlots;
    }
    
    public void setFullSlots(int fullSlots) {
        this.fullSlots = fullSlots;
    }

    public boolean getSelected() {
        return this.selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
    
    public int getSelectedSlot() {
        return this.selectedSlot;
    }

    public void setSelectedSlot(int selectedSlot) {
        this.selectedSlot = selectedSlot;
    }

    public ArrayList<Item> getSlots() {
        return this.slots;
    }

    public void setSlots(ArrayList<Item> slots) {
        this.slots = slots;
    }

    public VirtualZoo getZoo() {
        return this.zoo;
    }

    public void setZoo(VirtualZoo zoo) {
        this.zoo = zoo;
    }
}
    