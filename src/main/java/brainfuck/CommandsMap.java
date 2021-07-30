package brainfuck;

import java.util.HashMap;

public class CommandsMap {
    private final HashMap<Character, Command> commandMap = new HashMap<>(100);

    private void setStandardCommands() {
        commandMap.put('>', new IncrementPointer());
        commandMap.put('<', new DecrementPointer());
        commandMap.put('+', new IncrementData());
        commandMap.put('-', new DecrementData());
        commandMap.put('.', new Output());
    }
    
    public void addCommand(Character bfString, Command bfCommand) {
        commandMap.put(bfString, bfCommand);
    }
    
    public HashMap<Character, Command> getCommandMap() {
        setStandardCommands();
        return commandMap;
    }
}
