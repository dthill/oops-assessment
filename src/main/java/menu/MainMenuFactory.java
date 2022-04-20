package menu;

import commands.DeleteCommand;
import commands.ReadCommand;
import commands.SearchCommand;

import java.util.ArrayList;
import java.util.List;

public class MainMenuFactory {
    public static Menu createMainMenu(){
        List<Menu> menuOptions = createMainMenuOptions();
        return new Menu("App Title...", "Main Menu", menuOptions);
    }

    private static List<Menu> createMainMenuOptions(){
        List<Menu> menuOptions = new ArrayList<>();
        menuOptions.add(createReadOption());
        return menuOptions;
    }

    private static  Menu createEditAndSearchOption(){
       return null;
    }

    private static Menu createReadOption(){
        return new Menu("Display files", new ReadCommand());
    }

    private static Menu createDeleteOption(){
        return new Menu("Delete files", new DeleteCommand());
    }

    private static Menu createSearchOption(){
        return new Menu("Search file", new SearchCommand());
    }

}
