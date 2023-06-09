package org.server.command;

import java.util.List;
import org.server.collection.MusicBandCollection;
import org.server.collection.builder.MusicBandBuilder;

public class AddCommand extends CollectionCommand {
  public AddCommand(MusicBandCollection collection, CommandManager manager) {
    super(collection, manager);
  }

  @Override
  public void execute(List<String> args) {
    MusicBandBuilder builder =
        new MusicBandBuilder(
            manager.getInputChannel(), manager.getOutputChannel(), !args.contains("-nousermode"));
    collection.add(builder.getElement());
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
