package org.server.command;

import java.util.List;
import org.server.collection.MusicBandCollection;

public class RemoveByIdCommand extends CollectionCommand {

  public RemoveByIdCommand(MusicBandCollection collection, CommandManager manager) {
    super(collection, manager);
  }

  @Override
  public void execute(List<String> args) {
    if (args.isEmpty()) {
      manager.getOutputChannel().sendStringLine("Не указан id");
      return;
    }
    try {
      if (collection.remove(Long.parseLong(args.get(0))))
        manager.getOutputChannel().sendStringLine("Элемент успешно удален");
      else manager.getOutputChannel().sendStringLine("Элемент с указанным id не найден");
    } catch (NumberFormatException e) {
      manager.getOutputChannel().sendStringLine("id должен быть числом");
    }
  }

  @Override
  public String getDescription() {
    return "Удаляет элемент по id";
  }

  @Override
  public String getName() {
    return "remove_by_id";
  }
}
