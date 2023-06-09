package collection.element;

import collection.Printable;
import java.time.LocalDateTime;
import java.util.Objects;

public class MusicBand extends Printable {
  @Pk
  private Long
      id; // Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно
  // быть уникальным, Значение этого поля должно генерироваться автоматически
  private String name; // Поле не может быть null, Строка не может быть пустой
  @Entity
  @Name(name="coordinates_id")
  private Coordinates coordinates; // Поле не может быть null

  private LocalDateTime
      creationDate; // Поле не может быть null, Значение этого поля должно генерироваться
  // автоматически

  private Integer
      numberOfParticipants; // Поле не может быть null, Значение поля должно быть больше 0

  private int albumsCount; // Значение поля должно быть больше 0
  private String description; // Поле может быть null
  @EnumString
  private MusicGenre genre; // Поле может быть null
  @Entity
  @Name(name="person_id")
  private Person frontMan; // Поле не может быть null

  public void setName(String name) {
    this.name = name;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setCreationDate(LocalDateTime date) {
    this.creationDate = date;
  }

  public void setFrontMan(Person person) {
    this.frontMan = person;
  }

  public void setCoordinates(Coordinates coordinates) {
    this.coordinates = coordinates;
  }

  public void setNumberOfParticipants(Integer numberOfParticipants) {
    this.numberOfParticipants = numberOfParticipants;
  }

  public void setAlbumsCount(int albumsCount) {
    this.albumsCount = albumsCount;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setGenre(MusicGenre genre) {
    this.genre = genre;
  }

  public String getName() {
    return name;
  }

  public Coordinates getCoordinates() {
    return coordinates;
  }

  public LocalDateTime getCreationDate() {
    return creationDate;
  }

  public Integer getNumberOfParticipants() {
    return numberOfParticipants;
  }

  public int getAlbumsCount() {
    return albumsCount;
  }

  public String getDescription() {
    return description;
  }

  public MusicGenre getGenre() {
    return genre;
  }

  public Person getFrontMan() {
    return frontMan;
  }

  public Long getId() {
    return id;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        id,
        name,
        coordinates,
        creationDate,
        numberOfParticipants,
        albumsCount,
        description,
        genre,
        frontMan);
  }
}
