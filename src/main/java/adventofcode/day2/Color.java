package adventofcode.day2;

public enum Color {
  RED,
  GREEN,
  BLUE;

  public static Color from(String color) {
    return switch (color) {
      case "red" -> RED;
      case "green" -> GREEN;
      case "blue" -> BLUE;
      default -> throw new IllegalArgumentException("Unknown color: " + color);
    };
  }
}
