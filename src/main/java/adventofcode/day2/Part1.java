package adventofcode.day2;

public class Part1 {
  public Suite solve(String input) {
    int colon = input.indexOf(":");

    int game = Integer.parseInt(input.substring(5, colon));
    int red = 0;
    int green = 0;
    int blue = 0;

    for (String suites : input.substring(colon + 1).split(";")) {
      for (String suite : suites.split(",")) {

        var parts = suite.strip().split(" ");
        var count = Integer.parseInt(parts[0]);
        var color = Color.from(parts[1]);

        switch (color) {
          case RED -> red = Math.max(red, count);
          case GREEN -> green = Math.max(green, count);
          case BLUE -> blue = Math.max(blue, count);
        }
      }
    }

    return new Suite(game, red, green, blue);
  }
}
