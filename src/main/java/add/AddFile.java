package add;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class AddFile {

  public AddFile() {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.println(
          "Please provide the filename which you would like to add to the directory");
      String input = scanner.nextLine().toLowerCase();
      try {
        Path filePath = Paths.get(input);
        Files.createFile(filePath);
        System.out.println("File created successfully");
        System.out.println("+++++++++++++++++++++++++");
        break;
      } catch (FileAlreadyExistsException e) {
        System.out.println("This file already exists.");
      } catch (IOException e) {
        System.out.println(
            "An error occured please try a different filename and make sure you have enough disk space and access rights to create files.");
      }
    }

  }
}
