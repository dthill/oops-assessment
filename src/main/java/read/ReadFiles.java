package read;

import java.io.File;

public class ReadFiles {

  private File workingDirectory;

  public ReadFiles() {
    workingDirectory = new File(".");
  }

  public String[] getFiles() {
    if (workingDirectory.isDirectory()) {
      return workingDirectory.list();
    }
    return {};
  }

}
