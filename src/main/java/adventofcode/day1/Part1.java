package adventofcode.day1;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Part1 {
  public static void main(String[] args) {
    Part1 part1 = new Part1();

    try (var file = Files.lines(Path.of("src/main/resources/day1/input.txt"))) {
      System.out.println(file.mapToInt(part1::solve).sum());

    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }

  public int solve(String input) {
    Character first = null;
    Character last = null;

    for (int index = 0; index < input.length(); index++) {
      if (first != null && last != null) {
        break;
      }

      if (first == null) {
        char character = input.charAt(index);
        if (Character.isDigit(character)) {
          first = character;
        }
      }

      if (last == null) {
        char character = input.charAt(input.length() - 1 - index);
        if (Character.isDigit(character)) {
          last = character;
        }
      }
    }

    int sum = sum(first, last);
    int append = append(first, last);

    return Math.max(sum, append);
  }

  private int sum(Character first, Character last) {
    return Character.getNumericValue(first) + Character.getNumericValue(last);
  }

  private int append(Character first, Character last) {
    return Integer.parseInt(new CharArrayWriter().append(first).append(last).toString());
  }
}
