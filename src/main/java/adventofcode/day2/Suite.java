package adventofcode.day2;

public record Suite(int game, int red, int green, int blue) {
  public boolean pass(Suite rule) {
    return red <= rule.red() && green <= rule.green() && blue <= rule.blue();
  }
}
