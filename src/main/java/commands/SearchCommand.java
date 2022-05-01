package commands;

import search.SearchFile;

public class SearchCommand implements MenuCommand {

  @Override
  public void execute() {
    new SearchFile();
  }
}
