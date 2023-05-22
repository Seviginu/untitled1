package org.server.command.commands;


import java.time.LocalDateTime;
import java.util.List;

import collection.MusicBandCollection;
import org.server.command.CommandManager;
import org.server.command.exceptions.CommandNotFoundException;

public class AddCommand extends ElementCommand {
  public AddCommand(MusicBandCollection collection, CommandManager manager) {
    super(collection, manager);
  }

  @Override
  public void execute(List<String> args) {
    element.setId(MusicBandCollection.generateId());
    element.setCreationDate(LocalDateTime.now());
    collection.add(element);
    try{
      manager.executeCommand("save");
    }
    catch (CommandNotFoundException ignore){ ignore.printStackTrace();}
    manager.getOutputChannel().sendStringLine("Элемент добавлен");
  }

  @Override
  public String getDescription() {
    return "Добавляет элемент в коллекцию";
  }

  @Override
  public String getName() {
    return "add";
  }
}
