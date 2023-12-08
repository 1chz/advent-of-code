package adventofcode.day1;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;

public class Part2 {
  private final Part1 part1 = new Part1();
  private final List<Map.Entry<String, String>> replacements =
      List.of(
          new AbstractMap.SimpleEntry<>("oneight", "18"),
          new AbstractMap.SimpleEntry<>("twone", "21"),
          new AbstractMap.SimpleEntry<>("eightwo", "82"),
          new AbstractMap.SimpleEntry<>("one", "1"),
          new AbstractMap.SimpleEntry<>("two", "2"),
          new AbstractMap.SimpleEntry<>("three", "3"),
          new AbstractMap.SimpleEntry<>("four", "4"),
          new AbstractMap.SimpleEntry<>("five", "5"),
          new AbstractMap.SimpleEntry<>("six", "6"),
          new AbstractMap.SimpleEntry<>("seven", "7"),
          new AbstractMap.SimpleEntry<>("eight", "8"),
          new AbstractMap.SimpleEntry<>("nine", "9"));

  public int solve(String input) {
    input = this.recursivelyReplace(input);
    return this.part1.solve(input);
  }

  private String recursivelyReplace(String input) {
    var replacements =
        this.replacements.stream()
            .map(replacement -> new Replacement(input.indexOf(replacement.getKey()), replacement))
            .filter(it -> it.indexOf != -1) // indexOf() returns -1 if not found
            .sorted() // find the first match
            .toList();

    // no more replacements
    if (replacements.isEmpty()) {
      return input;
    }

    // recursively replace the first match
    var replacement = replacements.getFirst();
    return this.recursivelyReplace(replacement.first(input));
  }

  private record Replacement(int indexOf, String str, String replacement)
      implements Comparable<Replacement> {
    private Replacement(int indexOf, Map.Entry<String, String> entry) {
      this(indexOf, entry.getKey(), entry.getValue());
    }

    private String first(String input) {
      return input.replaceFirst(str, replacement);
    }

    @Override
    public int compareTo(Replacement o) {
      return Integer.compare(indexOf, o.indexOf);
    }
  }
}
