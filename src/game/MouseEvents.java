package game;

import jplay.GameObject;
import jplay.Mouse;
import jplay.Window;

public class MouseEvents {
    private Mouse mouse;

    public MouseEvents(Window window){
        this.mouse = window.getMouse();
    }

    public boolean mouseClick(boolean mouseClick, GameObject obj){ 
        if(mouseClick == true && this.mouse.isOverObject(obj)){
            return true;
        }
        
        return false;
    }
}
