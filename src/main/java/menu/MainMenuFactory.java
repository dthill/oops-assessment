package menu;

import commands.AddCommand;
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
        .addMenuOption(createReadOption(menu))
        .addMenuOption(createEditAndSearchOptionMenu(menu))
        .addExitOption();
    return menu;
  }


  private static Menu createEditAndSearchOptionMenu(Menu parent) {
    Menu subMenu = new Menu();
    return subMenu
        .addTitle("Edit and Search Submenu")
        .addMenuOption(createAddOption(subMenu))
        .addMenuOption(createDeleteOption(subMenu))
        .addMenuOption(createSearchOption(subMenu))
        .addParent(parent)
        .addExitOption();
  }

  private static Menu createReadOption(Menu parent) {
    return new Menu().addCommand(new ReadCommand()).addTitle("Read files").addParent(parent);
  }

  private static Menu createAddOption(Menu parent) {
    return new Menu().addCommand(new AddCommand()).addTitle("Add file").addParent(parent);
  }


  private static Menu createDeleteOption(Menu parent) {
    return new Menu().addCommand(new DeleteCommand()).addTitle("Delete File").addParent(parent);
  }

  private static Menu createSearchOption(Menu parent) {
    return new Menu().addCommand(new SearchCommand()).addTitle("Search File").addParent(parent);
  }

}
