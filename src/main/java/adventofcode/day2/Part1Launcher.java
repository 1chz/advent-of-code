package adventofcode.day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Part1Launcher {
  public static void main(String[] args) {
    var part1 = new Part1();

    var rule = new Suite(-1, 12, 13, 14);

    try (var lines = Files.lines(Path.of("src/main/resources/day2/input.txt"))) {
      System.out.println(
          lines.map(part1::solve).filter(suite -> suite.pass(rule)).mapToInt(Suite::game).sum());

    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }
}
