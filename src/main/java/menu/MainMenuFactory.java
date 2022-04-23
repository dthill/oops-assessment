package menu;

import commands.DeleteCommand;
import commands.ReadCommand;
import commands.SearchCommand;

import java.util.ArrayList;
import java.util.List;

public class MainMenuFactory {
    public static Menu createMainMenu() {
        Menu menu = new Menu();
        menu.addHeader("App name")
                .addTitle("Read Files")
                .addMenuOption(createReadOption())
                .addParent(menu)
                .addExitOption();
        return menu;
    }


    private static Menu createEditAndSearchOption() {
        return null;
    }

    private static Menu createReadOption() {
        return new Menu().addCommand(new ReadCommand()).addTitle("Read files");
    }

    private static Menu createDeleteOption() {
        return new Menu();
    }

    private static Menu createSearchOption() {
        return new Menu();
    }

}
