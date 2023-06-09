package collection.element;

import java.io.Serializable;

public enum Country implements Serializable {
  RUSSIA("Россия"),
  USA("США"),
  ITALY("Италия"),
  SOUTH_KOREA("Южная Корея"),
  JAPAN("Япония");

  private final String name;

  Country(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return name;
  }
}
