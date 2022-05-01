package commands;

import delete.DeleteFile;

public class DeleteCommand implements MenuCommand {

  @Override
  public void execute() {
    new DeleteFile();
  }
}
