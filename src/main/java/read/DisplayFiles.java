package read;

import java.io.File;

public class DisplayFiles {

  public static void displayFiles(File[] fileList) {
    System.out.println(generateFileList(fileList));
  }

  private static String generateFileList(File[] fileList) {
    String result = "Files in directory:\n";
    for (int i = 0; i < fileList.length; i++) {
      result += fileList[i].getName() + "\t-\t" + generateFileSize(fileList[i]) + "\n";
    }
    result += "++++++++++++++++++++\n";
    return result;
  }

  private static String generateFileSize(File file) {
    return String.format("%.1f MB", file.length() / 1024.0);
  }
}
