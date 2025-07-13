package game;

import jplay.Window;

public class Main{
    public static void main(String[] args) {
        Window window = new Window(1024, 768);
        new Scenery(window);
    }
}
