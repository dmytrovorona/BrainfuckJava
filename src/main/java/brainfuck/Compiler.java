package brainfuck;

import java.util.*;

public class Compiler {
    private ArrayDeque<Object> compile(CommandsMap cm, String input) {
        ArrayDeque<Object> objCommands = new ArrayDeque<>(99999);
        HashMap<Character, Command> commandsMap = cm.getCommandMap();
        char[] charCommands = input.toCharArray();

        for (char charCommand : charCommands) {
            if (commandsMap.containsKey(charCommand)) {
                if (objCommands.peek() instanceof ArrayList) {
                    ((ArrayList<Object>) objCommands.peek())
                            .add(commandsMap.get(charCommand));
                } else {
                    objCommands.push(commandsMap.get(charCommand));
                }
            } else if (charCommand == '[') {
                objCommands.push(new ArrayList<>(99999));
            } else if (charCommand == ']') {
                Command loopCommand = new Loop((List<Command>) (objCommands.pop()));
                if (objCommands.peek() instanceof ArrayList) {
                    ((ArrayList<Object>) objCommands.peek())
                            .add(loopCommand);
                } else {
                    objCommands.push(loopCommand);
                }
            }
        }
        return objCommands;
    }

    // Two methods for executing commands
    // with string input (and compiling it to list of objects)
    // or pre-compiled list.
    public void execute(Memory m, CommandsMap cm, String input) {
        Compiler compiler = new Compiler();
        ArrayDeque<Object> commands = compiler.compile(cm, input);
        Iterator<Object> itr = commands.descendingIterator();
        while (itr.hasNext()) {
            ((Command) itr.next()).execute(m);
        }
    }

    public void execute(Memory m, Deque<Object> input) {
        Iterator<Object> itr = input.descendingIterator();
        while (itr.hasNext()) {
            ((Command) itr.next()).execute(m);
        }
    }
}