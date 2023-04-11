package org.example.command;

import org.example.collection.MusicBandCollection;

public class ClearCommand extends CollectionCommand{
    public ClearCommand(MusicBandCollection collection, CommandManager manager) {
        super(collection, manager);
    }

    @Override
    public void execute(String[] args) {
        collection.clear();
    }

    @Override
    public String getDescription() {
        return "Удаляет все элементы из коллекции.";
    }

    @Override
    public String getName() {
        return "clear";
    }
}