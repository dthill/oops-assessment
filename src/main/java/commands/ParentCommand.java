package commands;

import menu.Menu;

public class ParentCommand implements MenuCommand{
    private Menu parentMenu;

    public ParentCommand(Menu parentMenu) {
        this.parentMenu = parentMenu;
    }

    @Override
    public void execute() {
        System.out.println("===================================");
        this.parentMenu.runCommand();
    }
}
