package menu;

import commands.DeleteCommand;
import commands.ReadCommand;
import commands.SearchCommand;

public class MainMenuFactory {

  public static Menu createMainMenu() {
    Menu menu = new Menu();
    menu.addTitle("Main Menu")
        .addHeader(
            new MenuHeader(
                "Company Lockers App",
                "Damien Thill",
                "developer@email.com"
            ))
        .addMenuOption(createReadOption()).addMenuOption(createEditAndSearchOptionMenu(menu))
        .addExitOption();
    return menu;
  }


  private static Menu createEditAndSearchOptionMenu(Menu parent) {
    return new Menu().addTitle("Edit and Search Submenu").addMenuOption(createDeleteOption())
        .addMenuOption(createSearchOption()).addParent(parent).addExitOption();
  }

  private static Menu createReadOption() {
    return new Menu().addCommand(new ReadCommand()).addTitle("Read files");
  }

  private static Menu createDeleteOption() {
    return new Menu().addCommand(new DeleteCommand()).addTitle("Delete File");
  }

  private static Menu createSearchOption() {
    return new Menu().addCommand(new SearchCommand()).addTitle("Search File");
  }

}
