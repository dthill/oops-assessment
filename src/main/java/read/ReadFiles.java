package read;

import java.io.File;

public class ReadFiles {

  private File workingDirectory;

  public ReadFiles() {
    workingDirectory = new File("./");
  }

  public File[] getFiles() {
    return SortFiles.sortByFileName(workingDirectory.listFiles());
  }

}
