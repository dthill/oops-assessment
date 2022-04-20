package app;

import menu.Menu;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        new App().createMainMenu().runCommand();
    }

    public Menu createMainMenu(){
        return new Menu("Main Locker app.\n Developed by: Santa", "Main Menu",new ArrayList<Menu>(),null,null);
    }
}
