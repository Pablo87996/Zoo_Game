package game;

import game.Animals.Bird;
import game.Animals.Chameleon;
import game.Animals.Chicken;
import game.Animals.Cow;
import game.Animals.Dino;
import game.Animals.Duck;
import game.Animals.Pig;
import game.Animals.Rino;
import game.Foods.Apple;
import game.Foods.IcreCream;
import game.Foods.Sushi;
import game.GUI.ButtonExit;
import game.GUI.Card;
import game.GUI.GUI;
import game.GUI.Inventory;
import jplay.Mouse;
import jplay.Scene;
import jplay.Window;
import jplay.URL;

public class Scenery{
    private Window window;
    private Scene scene = new Scene();
    private Store store = new Store(400, 250);

    private GUI gui = new GUI();
    private ButtonExit exit = new ButtonExit(885, 105);
    
    private boolean oppened;
    private VirtualZoo zoo = new VirtualZoo();
    private Inventory inventory = new Inventory(910, 250, this.zoo);
    
    private Card chickenCard = new Card(150, 300, "chicken-card.png");
    private Card birdCard = new Card(260, 300, "bird-card.png");
    private Card rinoCard = new Card(370, 300, "rino-card.png");
    private Card pigCard = new Card(480, 300, "pig-card.png");
    private Card duckCard = new Card(150, 410, "duck-card.png");
    private Card chameleonCard = new Card(260, 410, "chameleon-card.png");
    private Card dinoCard = new Card(370, 410, "dino-card.png");
    private Card cowCard = new Card(480, 410, "cow-card.png");

    private Card appleCard = new Card(775, 300, "apple-card.png");
    private Card sushiCard = new Card(775, 410, "sushi-card.png");
    private Card iceCreamCard = new Card(665, 410, "iceCream-card.png");
    
    private MouseEvents mouseEvents;
    private boolean mouseClick = false;
    private Mouse mouse;

    public Scenery(Window window) {
        this.window = window;
        this.mouseEvents = new MouseEvents(window);
        this.mouse = window.getMouse();
        this.scene.loadFromFile(URL.scenario("scenery1.scn"));

        run();
    }
    
    private void run() {
        while(true){
            this.scene.draw();
            this.scene.addOverlay(inventory);
            this.scene.addOverlay(store);

            try {
                for(int i=0; i<8; i++){
                    for(int j=0; j<this.zoo.getCages(i).getPets().size(); j++){
                        this.zoo.getCages(i).getPets().get(j).draw();
                        this.zoo.getCages(i).getPets().get(j).animation();
                        this.zoo.getCages(i).getPets().get(j).hungryLvl();
                        this.zoo.getCages(i).getPets().get(j).calorieBarPosition();
                        this.zoo.getCages(i).getPets().get(j).getCalorieBar().draw();
                        this.zoo.getCages(i).getPets().get(j).eat();
    
                        //sendSound
                        if(this.mouseEvents.mouseClick(this.mouseClick, this.zoo.getCages(i).getPets().get(j))){
                            this.zoo.sendSound(this.zoo.getCages(i).getPets().get(j));
                        }

                        if(this.zoo.getCages(i).getPets().size() > 0 && this.zoo.getCages(i).getFoods().size() > 0){
                            this.zoo.getCages(i).getPets().get(j).eat(this.zoo.getCages(i).getFoods().get(0));
                            this.zoo.getCages(i).getPets().get(j).die();
                        }
                    }
    
                    for(int j=0; j<this.zoo.getCages(i).getFoods().size(); j++){
                        this.zoo.getCages(i).getFoods().get(j).draw();
                    }
                }
            }catch(Exception e) {
                // Error
            }
            
            if(this.mouse.isLeftButtonPressed()){
                this.mouseClick = true;
            }else{
                this.mouseClick = false;
            }

            if(this.mouseEvents.mouseClick(this.mouseClick, store)){
                this.oppened = true;
            }
            
            //Draw the inventory items
            for(int i=0; i<this.inventory.getFullSlots(); i++){
                this.inventory.getSlots().get(i).draw();
                
                if(this.mouseEvents.mouseClick(this.mouseClick, this.inventory.getSlots().get(i))){
                    this.inventory.selectItem(i, this.mouse);
                    this.mouseClick = false;
                }
            }

            while(this.inventory.getSelected()){
                this.scene.draw();

                for(int i=0; i<8; i++){
                    for(int j=0; j<this.zoo.getCages(i).getPets().size(); j++){
                        this.zoo.getCages(i).getPets().get(j).draw();
                        this.zoo.getCages(i).getPets().get(j).animation();
                        this.zoo.getCages(i).getPets().get(j).calorieBarPosition();
                        this.zoo.getCages(i).getPets().get(j).getCalorieBar().draw();
                        this.zoo.getCages(i).getPets().get(j).eat();
                        
                        if(this.zoo.getCages(i).getPets().size() > 0 && this.zoo.getCages(i).getFoods().size() > 0){
                            this.zoo.getCages(i).getPets().get(j).eat(this.zoo.getCages(i).getFoods().get(0));
                            this.zoo.getCages(i).getPets().get(j).die();
                        }
                    }

                    for(int j=0; j<this.zoo.getCages(i).getFoods().size(); j++){
                        this.zoo.getCages(i).getFoods().get(j).draw();
                    }
                }

                this.inventory.selectItem(this.inventory.getSelectedSlot(), this.mouse);

                if(this.mouse.isLeftButtonPressed()){
                    this.mouseClick = true;
                }else{
                    this.mouseClick = false;
                }

                for(int i=0; i<this.inventory.getFullSlots(); i++){
                    this.inventory.getSlots().get(i).draw();
                }

                if(this.mouse.isRightButtonPressed()){
                    this.inventory.dropItem(mouse);

                    for(int i=0; i<8; i++){
                        for(int j=0; j<this.zoo.getCages(i).getPets().size(); j++){
                            if(this.zoo.getCages(i).getPets().get(j).getIdle() == false){
                                this.zoo.getCages(i).getPets().get(j).setIdle(true);
                            }
                        }
                    }
                }
                
                this.window.update();
            }

            while(this.oppened == true){
                this.scene.draw();

                for(int i=0; i<8; i++){
                    for(int j=0; j<this.zoo.getCages(i).getPets().size(); j++){
                        this.zoo.getCages(i).getPets().get(j).draw();
                        this.zoo.getCages(i).getPets().get(j).animation();
                        this.zoo.getCages(i).getPets().get(j).calorieBarPosition();
                        this.zoo.getCages(i).getPets().get(j).getCalorieBar().draw();
                        this.zoo.getCages(i).getPets().get(j).eat();
                        
                        if(this.zoo.getCages(i).getPets().size() > 0 && this.zoo.getCages(i).getFoods().size() > 0){
                            this.zoo.getCages(i).getPets().get(j).eat(this.zoo.getCages(i).getFoods().get(0));
                            this.zoo.getCages(i).getPets().get(j).die();
                        }
                    }

                    for(int j=0; j<this.zoo.getCages(i).getFoods().size(); j++){
                        this.zoo.getCages(i).getFoods().get(j).draw();
                    }
                }

                this.gui.draw();
                this.exit.draw();
                this.chickenCard.draw();
                this.birdCard.draw();
                this.rinoCard.draw();
                this.pigCard.draw();
                this.duckCard.draw();
                this.chameleonCard.draw();
                this.dinoCard.draw();
                this.cowCard.draw();

                this.appleCard.draw();
                this.sushiCard.draw();
                this.iceCreamCard.draw();

                if(this.mouse.isLeftButtonPressed()){
                    this.mouseClick = true;
                }else{
                    this.mouseClick = false;
                }
                
                if(this.mouseEvents.mouseClick(this.mouseClick, this.exit)){
                    this.oppened = false;
                }

                //VirtualPets and Foods
                if(this.inventory.getFullSlots() < 4){
                    if(mouseEvents.mouseClick(this.mouseClick, this.birdCard)){
                        this.inventory.addToSlot("bird-item.png", new Bird(0, -200, zoo));
                    }else if(mouseEvents.mouseClick(this.mouseClick, this.chameleonCard)){
                        this.inventory.addToSlot("chameleon-item.png", new Chameleon(0, -200, zoo));
                    }else if(mouseEvents.mouseClick(this.mouseClick, this.chickenCard)){
                        this.inventory.addToSlot("chicken-item.png", new Chicken(0, -200, zoo));
                    }else if(mouseEvents.mouseClick(this.mouseClick, this.cowCard)){
                        this.inventory.addToSlot("cow-item.png", new Cow(0, -200, zoo));
                    }else if(mouseEvents.mouseClick(this.mouseClick, this.dinoCard)){
                        this.inventory.addToSlot("dino-item.png", new Dino(0, -200, zoo));
                    }else if(mouseEvents.mouseClick(this.mouseClick, this.duckCard)){
                        this.inventory.addToSlot("duck-item.png", new Duck(0, -200, zoo));
                    }else if(mouseEvents.mouseClick(this.mouseClick, this.pigCard)){
                        this.inventory.addToSlot("pig-item.png", new Pig(0, -200, zoo));
                    }else if(mouseEvents.mouseClick(this.mouseClick, this.rinoCard)){
                        this.inventory.addToSlot("rino-item.png", new Rino(0, -200, zoo));
                    }else if(mouseEvents.mouseClick(this.mouseClick, this.appleCard)){
                        this.inventory.addToSlot("apple.png", new Apple(0, -200));
                    }else if(mouseEvents.mouseClick(this.mouseClick, this.iceCreamCard)){
                        this.inventory.addToSlot("iceCream.png", new IcreCream(0, -200));
                    }else if(mouseEvents.mouseClick(this.mouseClick, this.sushiCard)){
                        this.inventory.addToSlot("sushi.png", new Sushi(0, -200));
                    }
                }

                //Draw the this.inventory items
                for(int i=0; i<this.inventory.getFullSlots(); i++){
                    this.inventory.getSlots().get(i).draw();
                }
                
                this.window.update();
            }
                
            this.window.update();
        }
    }
}
