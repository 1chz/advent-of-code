package adventofcode.day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Launcher {
  public static void main(String[] args) {
    Part1 part1 = new Part1();

    try (var lines = Files.lines(Path.of("src/main/resources/day1/input.txt"))) {
      System.out.println(lines.mapToInt(part1::solve).sum());

    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }
}
