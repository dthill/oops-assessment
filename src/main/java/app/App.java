package app;

import menu.MainMenuFactory;
import menu.Menu;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        while (true){
            MainMenuFactory.createMainMenu().runCommand();
        }
    }


}
