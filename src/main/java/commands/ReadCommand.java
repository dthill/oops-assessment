package commands;

import read.DisplayFiles;
import read.ReadFiles;

public class ReadCommand implements MenuCommand {

  @Override
  public void execute() {
    DisplayFiles.displayFiles(new ReadFiles().getFiles());
  }
}
