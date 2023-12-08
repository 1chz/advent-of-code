package adventofcode.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Part2Test {
  Part2 sut = new Part2();

  @ParameterizedTest
  @CsvSource({
    "rtqoneighthxpg5tb4, 14",
    "bvtwone8vninezhkkbvpscqfive6jczrlrgcn, 26",
    "brbeightwo6cxnblxgskmxxxtwo, 82",
    "two1nine, 29",
    "eightwothree, 83",
    "abcone2threexyz, 13",
    "xtwone3four, 24",
    "4nineeightseven2, 42",
    "zoneight234, 14",
    "7pqrstsixteen, 76",
  })
  void calibrationValues(String input, int expected) {
    int actual = sut.solve(input);
    assertEquals(expected, actual);
  }
}
