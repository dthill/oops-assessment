package search;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SearchFile {

  private static final int LARGE_PRIME = 9973;
  private static final int RADIX = 256;
  private String fileText;
  private String searchPattern;

  public SearchFile() {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.println("Please provide the filename that you would like to search");
      String fileInput = scanner.nextLine();
      try {
        this.fileText = Files.readString(Paths.get(fileInput));
        break;
      } catch (OutOfMemoryError e) {
        System.out.println("The provided file is to big. Try another file.");
      } catch (IOException e) {
        System.out.println("An error occurred. Try another file.");
      }
    }
    System.out.println("Search text");
    this.searchPattern = scanner.nextLine();
    this.search();

  }

  private void search() {
    System.out.println(
        "Search pattern found at the following indexes: " + this.findPatternUsingHashing());
    System.out.println("++++++++++++++++++++++");
  }

  private List<Integer> findPatternUsingHashing() {
    List<Integer> result = new LinkedList<>();
    int patternHash = getHashFor(this.searchPattern);
    int textRollingHash = getHashFor(this.fileText.substring(0, searchPattern.length()));
    for (int i = 0; i < fileText.length() - searchPattern.length(); i++) {
      if (patternHash == textRollingHash &&
          fileText.substring(i, i + searchPattern.length()).equalsIgnoreCase(searchPattern)) {
        result.add(i);
      }
      textRollingHash = getHashFor(fileText.substring(i, i + searchPattern.length()));
    }
    return result;
  }

  private int getHashFor(String text) {
    int hash = 0;
    for (int i = 0; i < searchPattern.length(); i++) {
      int polyBase = (int) (Math.pow(RADIX, searchPattern.length() - 1 - i) % LARGE_PRIME);
      hash = (hash + (polyBase * searchPattern.charAt(i)) % LARGE_PRIME) % LARGE_PRIME;
    }
    return hash;
  }
}
