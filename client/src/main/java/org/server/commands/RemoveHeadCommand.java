package org.server.commands;

import java.io.IOException;
import java.util.List;
import org.server.serverIO.RequestManager;

public class RemoveHeadCommand extends CollectionCommand {
  public RemoveHeadCommand(RequestManager requestManager, CommandManager manager) {
    super(requestManager, manager);
  }

  @Override
  public void execute(List<String> args) {
    try {
      manager.getOutputChannel().sendStringLine(requestManager.sendTextRequest(getName()));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public String getDescription() {
    return "Выводит первый элемент в коллекции и удаляет его";
  }

  @Override
  public String getName() {
    return "remove_head";
  }
}