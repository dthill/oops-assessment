package commands;

import exit.Exit;

public class ExitCommand implements MenuCommand {

  @Override
  public void execute() {
    new Exit();
  }
}
