package menu;

public class ExitCommand implements MenuCommand{
    @Override
    public void execute() {
        System.out.println("\nExiting the application");
        System.exit(0);
    }
}
