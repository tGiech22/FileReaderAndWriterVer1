package cs3500.pa01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;

/**
 * tests for the driver
 */
class DriverTest {
  /**
   * testing method
   *
   * @throws IOException when input into constructor for filewriter isn't valid
   */
  @Test
  public void testMain() throws IOException {

    String[] array = {"ForTests/", "filename", "SampleOutput/output2.md"};
    Driver.main(array);
    assertEquals(Driver.formatOrder, "filename");

    Path inputPath = Path.of("ForTests/");
    Path outputPath = Path.of("SampleOutput/output2.md");

    String[] array2 = {"ForTests/", "modified", "SampleOutput/output2.md"};
    Driver.main(array2);
    assertEquals(Driver.userInput, inputPath);
    assertEquals(Driver.whereUserWantsOutput, outputPath);
    assertEquals(Driver.formatOrder, "modified");
  }
}