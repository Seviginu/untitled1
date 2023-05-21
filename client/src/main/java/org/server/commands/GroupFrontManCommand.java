package org.server.commands;

import collection.element.MusicBand;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import org.server.serverIO.RequestManager;

public class GroupFrontManCommand extends CollectionCommand {
  public GroupFrontManCommand(RequestManager requestManager, CommandManager manager) {
    super(requestManager, manager);
  }

  @Override
  public void execute(List<String> args) {
    ArrayList<MusicBand> bandsList;
    try {
      bandsList = new ArrayList<>(requestManager.getCollection().getListOfElements());
    } catch (IOException e) {
      e.printStackTrace();
      return;
    }
    bandsList.sort(Comparator.comparing(o -> o.getFrontMan().getName()));
    if (bandsList.size() == 0) return;
    int countOfGroups = 0;
    String frontManName = bandsList.get(0).getFrontMan().getName();
    for (MusicBand band : bandsList) {
      if (!Objects.equals(band.getFrontMan().getName(), frontManName)) {
        manager.getOutputChannel().sendStringLine(frontManName + ": " + countOfGroups + "\n");
        countOfGroups = 0;
        frontManName = band.getFrontMan().getName();
      }
      countOfGroups++;
      manager.getOutputChannel().sendStringLine(band.toString());
    }
    manager.getOutputChannel().sendStringLine(frontManName + ": " + countOfGroups + "\n");
  }

  @Override
  public String getDescription() {
    return "Группирует элементы коллекции по значению frontMan, выводит количество элементов в каждой группе";
  }

  @Override
  public String getName() {
    return "group_counting_by_front_man";
  }
}
