package menu;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private String header;
    private String title;
    private MenuCommand command;
    private List<Menu> options;
    private Menu parent;

    public Menu(String header, String title, List<Menu> options, Menu parent, MenuCommand command) {
        this.header = header == null ? "" : header;
        this.title = title == null ? "" : title;
        this.parent = parent;
        this.command = command;
        if (options == null) {
            this.options = new ArrayList<>();
        } else {
            this.options = options;
        }
        if (this.parent != null) {
            this.options.add(this.generateParentMenuOption());
        }
        this.options.add(this.generateExitOption());
    }

    private Menu(String title, MenuCommand command){
        this.header = "";
        this.title = title;
        this.parent = null;
        this.options = new ArrayList<>();
        this.command = command;
    }

    private String generateMenu() {
        String result = "";
        if (header != "") {
            result += header + "\n";
            result += "------------------------------------------\n";
        }
        if (title != "") {
            result = title + "\n";
            result += "===========================================\n";
        }
        for (int i = 0; i < options.size(); i++) {
            result += this.generateMenuOptionText(i);
        }
        return result;
    }

    private String generateMenuOptionText(int i) {
        return (i+1) + ". " + options.get(i).title + "\n";
    }

    private void printMenu() {
        System.out.println(this.generateMenu());
    }

    private Menu generateExitOption() {
        return new Menu("Exit application",  new ExitCommand());
    }

    private Menu generateParentMenuOption() {
        return new Menu(parent.header, "Return to " + parent.title, parent.options, parent.parent, parent.command);
    }

    private Menu getUserSelectedMenu(){
        Scanner scanner = new Scanner(System.in);
        int selectedIndex;
        while(true){
            String userInput = scanner.nextLine();
            try{
                selectedIndex = Integer.parseInt(userInput, 10) -1;
                if(selectedIndex > options.size() || selectedIndex < 0){
                    throw new IndexOutOfBoundsException();
                } else {
                    break;
                }
            } catch(IndexOutOfBoundsException e){
                System.out.println("There is no such option. Please select an option from 1 to "+ options.size());
            } catch(NumberFormatException e){
                System.out.println("This is not a valid option. Pleas provide a valid integer from 1 to "+ options.size());
            }
        }
        return options.get(selectedIndex);
    }

    public void runCommand() {
        if (this.command != null) {
            this.command.execute();
            this.runCommand();
        } else {
            this.printMenu();
            this.getUserSelectedMenu().runCommand();
        }
    }
}
