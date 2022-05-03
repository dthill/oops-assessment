package delete;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class DeleteFile {

  public DeleteFile() {
    Scanner scanner = new Scanner(System.in);
    System.out.println(
        "Please provide the filename which you would like to delete from the directory");
    String input = scanner.nextLine().toLowerCase();
    try {
      Path filePath = Paths.get(input);
      Files.delete(filePath);
      System.out.println("File deleted successfully");
      System.out.println("+++++++++++++++++++++++++");
    } catch (NoSuchFileException e) {
      System.out.println("The file was not found and could not be deleted");
      System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
    } catch (IOException e) {
      System.out.println(
          "An error occurred please try again and make sure you have enough access rights.");
      System.out.println(
          "+++++++++++++++++++++++++");
    }
  }
}
