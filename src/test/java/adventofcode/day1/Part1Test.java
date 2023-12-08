package adventofcode.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Part1Test {
  Part1 sut = new Part1();

  @ParameterizedTest
  @CsvSource({
    "1abc2, 12",
    "pqr3stu8vwx, 38",
    "a1b2c3d4e5f, 15",
    "treb7uchet, 77",
    "six9mnfjmtsf2kfmznkxntninesevenrpmfjfpgsk, 92",
  })
  void calibrationValues(String input, int expected) {
    int actual = sut.solve(input);
    assertEquals(expected, actual);
  }
}
