package read;

import java.io.File;

public class DisplayFiles {

  public DisplayFiles(File[] fileList) {
    System.out.println(generateFileList(fileList));
  }

  private String generateFileList(File[] fileList) {
    String result = "Files in directory:\n";
    for (File file : fileList) {
      result += file.getName() + "\t-\t" + generateFileSize(file) + "\n";
    }
    result += "++++++++++++++++++++\n";
    return result;
  }

  private String generateFileSize(File file) {
    return String.format("%.1f MB", file.length() / 1024.0);
  }
}
