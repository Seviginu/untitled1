package org.example.command;

import org.example.collection.MusicBandCollection;
import org.example.parser.FileManager;

abstract public class FileCommand extends CollectionCommand{

    protected FileManager file;

    public FileCommand(MusicBandCollection collection, FileManager file, CommandManager manager){
        super(collection, manager);
        this.file = file;
    }
}
