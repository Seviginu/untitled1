package org.server.command.commands;

import collection.MusicBandCollection;
import java.util.List;
import org.server.command.CommandManager;
import org.server.command.exceptions.CommandNotFoundException;
import utils.CommandNames;

public class ClearCommand extends CollectionCommand {
  public ClearCommand(MusicBandCollection collection, CommandManager manager) {
    super(collection, manager);
  }

  @Override
  public void execute(List<String> args) {
    collection.clear();
    manager.getOutputChannel().sendStringLine("Коллекция очищена");
  }

  @Override
  public String getDescription() {
    return "Удаляет все элементы из коллекции.";
  }

  @Override
  public String getName() {
    return CommandNames.CLEAR;
  }
}
