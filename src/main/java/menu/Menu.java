package menu;


import commands.ExitCommand;
import commands.MenuCommand;
import commands.ParentCommand;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

  private MenuHeader header;
  private String title;
  private MenuCommand command;
  private List<Menu> options;
  private Menu parent;

  public Menu addHeader(MenuHeader header) {
    this.header = header;
    return this;
  }

  public Menu addTitle(String title) {
    this.title = title;
    return this;
  }

  public Menu addCommand(MenuCommand command) {
    this.command = command;
    return this;
  }

  public Menu addMenuOption(Menu option) {
    if (this.options == null) {
      this.options = new ArrayList<>();
    }
    this.options.add(option);
    return this;
  }

  public Menu addParent(Menu parent) {
    this.parent = parent;
    return this.addMenuOption(
        new Menu()
            .addTitle("Parent menu")
            .addCommand(new ParentCommand(this.parent)));
  }

  public Menu addExitOption() {
    return this.addMenuOption(
        new Menu().addTitle("Exit application").addCommand(new ExitCommand())
    );
  }

  private String generateMenuText() {
    StringBuilder result = new StringBuilder();
    if (header != null) {
      result.append(header.generateHeader());
      result.append("------------------------------------------------\n");
    }
    if (title != null && !title.equals("")) {
      result.append(title).append("\n");
      result.append("================================================\n");
    }
    for (int i = 0; i < options.size(); i++) {
      result.append(this.generateMenuOptionText(i));
    }
    return result.toString();
  }

  private String generateMenuOptionText(int i) {
    return (i + 1) + ". " + options.get(i).title + "\n";
  }

  private void printMenu() {
    System.out.println(this.generateMenuText());
  }

  private Menu getUserSelectedMenu() {
    Scanner scanner = new Scanner(System.in);
    int selectedIndex;
    while (true) {
      String userInput = scanner.nextLine();
      try {
        selectedIndex = Integer.parseInt(userInput, 10) - 1;
        if (selectedIndex > options.size() || selectedIndex < 0) {
          throw new IndexOutOfBoundsException();
        } else {
          break;
        }
      } catch (IndexOutOfBoundsException e) {
        System.out.println(
            "There is no such option. Please select an option from 1 to " + options.size());
      } catch (NumberFormatException e) {
        System.out.println("This is not a valid option. Pleas provide a valid integer from 1 to "
            + options.size());
      }
    }
    return options.get(selectedIndex);
  }

  public void runCommand() {
    if (this.command != null) {
      this.command.execute();
      this.parent.runCommand();
    } else {
      this.printMenu();
      this.getUserSelectedMenu().runCommand();
    }
  }
}
