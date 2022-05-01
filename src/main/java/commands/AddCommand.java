package commands;

import add.AddFile;

public class AddCommand implements MenuCommand {

  @Override
  public void execute() {
    new AddFile();
  }
}
