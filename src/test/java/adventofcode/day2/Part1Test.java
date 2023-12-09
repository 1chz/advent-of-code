package adventofcode.day2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Part1Test {
  Part1 sut = new Part1();

  @MethodSource
  @ParameterizedTest
  void shouldReturnSuite(String input, Suite expected) {
    Suite actual = sut.solve(input);
    assertEquals(expected, actual);
  }

  static Stream<Arguments> shouldReturnSuite() {
    return Stream.of(
        Arguments.of(
            "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green", new Suite(1, 4, 2, 6)),
        Arguments.of(
            "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue",
            new Suite(2, 1, 3, 4)),
        Arguments.of(
            "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red",
            new Suite(3, 20, 13, 6)),
        Arguments.of(
            "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red",
            new Suite(4, 14, 3, 15)),
        Arguments.of(
            "Game 15: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green", new Suite(15, 6, 3, 2)));
  }
}
