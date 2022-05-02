package app;

import menu.MainMenuFactory;

public class App {

  public static void main(String[] args) {
    MainMenuFactory.createMainMenu().runCommand();
  }
}
