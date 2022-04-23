package menu;

import commands.DeleteCommand;
import commands.ReadCommand;
import commands.SearchCommand;

public class MainMenuFactory {
    public static Menu createMainMenu() {
        Menu menu = new Menu();
        menu.addHeader("App name")
                .addTitle("Read Files")
                .addMenuOption(createReadOption())
                .addMenuOption(createEditAndSearchOption(menu))
                .addExitOption();
        return menu;
    }


    private static Menu createEditAndSearchOption(Menu parent) {
        return new Menu()
                .addTitle("Edit and Search Submenu")
                .addMenuOption(createDeleteOption())
                .addMenuOption(createSearchOption())
                .addParent(parent)
                .addExitOption();
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
