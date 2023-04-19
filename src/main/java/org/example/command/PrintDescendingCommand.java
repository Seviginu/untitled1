package org.example.command;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.example.collection.MusicBandCollection;
import org.example.collection.element.MusicBand;

public class PrintDescendingCommand extends CollectionCommand {
  public PrintDescendingCommand(MusicBandCollection collection, CommandManager manager) {
    super(collection, manager);
  }

  @Override
  public void execute(List<String> args) {
    ArrayList<MusicBand> bands = new ArrayList<>(collection.getListOfElements());
    bands.sort(Comparator.comparing(MusicBand::getName));
    for (int i = bands.size() - 1; i >= 0; i--) {
      manager.getOutputChannel().sendString(bands.get(i).toString());
    }
  }

  @Override
  public String getDescription() {
    return "Выводит элементы коллекции в порядке убывания(лексикографически по имени группы)";
  }

  @Override
  public String getName() {
    return "print_descending";
  }
}
