package collection.element;

import collection.Printable;
import java.util.Objects;

public class Coordinates extends Printable {
  private Double x; // Поле не может быть null
  private Double y; // Поле не может быть null

  public void setX(Double x) {
    this.x = x;
  }

  public double getX() {
    return x;
  }

  public void setY(Double y) {
    this.y = y;
  }

  public double getY() {
    return y;
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }
}
