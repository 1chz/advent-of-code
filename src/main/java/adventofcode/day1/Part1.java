package adventofcode.day1;

import java.io.CharArrayWriter;

public class Part1 {
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
