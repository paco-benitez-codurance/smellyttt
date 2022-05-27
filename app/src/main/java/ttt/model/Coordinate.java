package ttt.model;

import java.util.function.Consumer;

public record Coordinate(int x, int y) {
  public static Coordinate coord(int x, int y) {
    return new Coordinate(x, y);
  }

  public static void giveMeAllCoordinates(Consumer<Coordinate> coordinateConsumer) {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        coordinateConsumer.accept(coord(i, j));
      }
    }
  }
}
