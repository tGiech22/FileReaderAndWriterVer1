package cs3500.pa01;

// takes in your user input
// where the program runs

// imports
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * This is the main driver of this project.
 */
public class Driver {

  static Path userInput;
  static String formatOrder;
  static Path whereUserWantsOutput;

  /**
   * main method where entry point is
   *
   * @param args accepts user input from command line
   * @throws IOException throws exception if input isn't valid into filewriter
   */
  public static void main(String[] args) throws IOException {
    userInput = Path.of(args[0]);
    formatOrder = args[1];
    whereUserWantsOutput = Path.of(args[2]);

    // checking if user input is valid
    if (!Files.exists(userInput) || !Files.isDirectory(userInput)) {
      throw new IllegalArgumentException("Please type in a valid directory.");
    }
    if (formatOrder.isEmpty()) {
      throw new IllegalArgumentException("Please type in a valid format order.");
    }
    if (!Files.isRegularFile(whereUserWantsOutput)) {
      throw new IllegalArgumentException("Please type in a valid directory/file.");
    }

    // calls FileMdWriter where it will take user input and create the output file
    FileMdWriter f = new FileMdWriter(userInput.toString(),
        formatOrder, whereUserWantsOutput.toString());
  }
}