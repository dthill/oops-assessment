package search;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SearchFile {

  private static final int LARGE_PRIME = 2_147_483_647;
  private final String searchPattern;
  private String fileText;

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
    if (fileText == null || fileText.length() == 0 || searchPattern.length() > fileText.length()) {
      return result;
    }
    long patternHash = getHashFor(this.searchPattern);
    long textRollingHash = getHashFor(this.fileText.substring(0, searchPattern.length()));
    int i = 0;
    do {
      if (patternHash == textRollingHash &&
          fileText.substring(i, i + searchPattern.length()).equalsIgnoreCase(searchPattern)) {
        result.add(i);
      }
      if (i < fileText.length() - searchPattern.length()) {
        textRollingHash = getRollingHashFor(textRollingHash, fileText.charAt(i),
            fileText.charAt(i + searchPattern.length()));
      }
      i++;
    } while (i < fileText.length() - searchPattern.length());
    return result;
  }

  private long getHashFor(String text) {
    long hash = 0;
    for (int i = 0; i < text.length(); i++) {
      hash = (hash + text.charAt(i)) % LARGE_PRIME;
    }
    return hash;
  }

  private long getRollingHashFor(long currentHash, char toRemove, char toAdd) {
    return (currentHash - toRemove + toAdd) % LARGE_PRIME;
  }
}
