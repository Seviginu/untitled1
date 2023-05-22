package org.server.command;

import collection.MusicBandCollection;
import collection.element.MusicBand;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import org.server.cli.NetworkUserChannel;
import org.server.cli.UserInputChannel;
import org.server.cli.UserOutputChannel;
import org.server.command.commands.*;
import org.server.command.exceptions.CommandNotFoundException;
import org.server.request.RequestManager;
import parser.FileManager;
import request.CommandPackage;

public class CommandManager {

  private final HashMap<String, Command> commandsHashMap = new HashMap<>();
  private UserInputChannel inputChannel;
  private final RequestManager requestManager;
  private UserOutputChannel outputChannel;
  private final List<String> commandsHistory = new ArrayList<>();

  public static void registerAllCommands(
      CommandManager commandManager,
      MusicBandCollection collectionManager,
      FileManager fileManager) {
    commandManager.registerCommand(new ClearCommand(collectionManager, commandManager));
    commandManager.registerCommand(new RemoveHeadCommand(collectionManager, commandManager));
    commandManager.registerCommand(new RemoveByIdCommand(collectionManager, commandManager));
    commandManager.registerCommand(new AddCommand(collectionManager, commandManager));
    commandManager.registerCommand(new SaveCommand(collectionManager, fileManager, commandManager));
    commandManager.registerCommand(new UpdateCommand(collectionManager, commandManager));
    commandManager.registerCommand(new AddIfMaxCommand(collectionManager, commandManager));
    commandManager.registerCommand(new GetCollectionCommand(collectionManager, commandManager));
  }

  public CommandManager(RequestManager channel) {
    this.requestManager = channel;
    this.outputChannel = new NetworkUserChannel(channel);
  }

  public UserOutputChannel getOutputChannel() {
    return outputChannel;
  }

  public RequestManager getRequestManager() {
    return requestManager;
  }

  public UserInputChannel getInputChannel() {
    return inputChannel;
  }

  public void setOutputChannel(UserOutputChannel outputChannel) {
    this.outputChannel = outputChannel;
  }

  public void setInputChannel(UserInputChannel inputChannel) {
    this.inputChannel = inputChannel;
  }

  public void registerCommand(Command command) {
    commandsHashMap.put(command.getName(), command);
  }

  public void executeCommand(String commandName, List<String> args)
      throws CommandNotFoundException {
    if (!commandsHashMap.containsKey(commandName)) throw new CommandNotFoundException();
    commandsHashMap.get(commandName).execute(args);
    commandsHistory.add(commandName);
  }

  public void executeCommand(String commandName) throws CommandNotFoundException {
    executeCommand(commandName, new ArrayList<>());
  }

  public void executeCommand(CommandPackage commandPackage) {
    Command command = commandsHashMap.get(commandPackage.commandName());
    if (command instanceof ElementCommand) {
      ((ElementCommand) command).setElement((MusicBand) commandPackage.args()[0]);
      if (commandPackage.args().length >= 2)
        command.execute(List.of((String[]) commandPackage.args()[1]));
      else command.execute(new ArrayList<>());
      return;
    }
    if (commandPackage.args() == null || commandPackage.args().length == 0)
      command.execute(new ArrayList<>());
    else command.execute(List.of((String[]) commandPackage.args()[0]));
  }

  public List<String> getCommandsHistory() {
    return commandsHistory;
  }

  public Collection<Command> getListOfCommands() {
    return commandsHashMap.values();
  }
}
