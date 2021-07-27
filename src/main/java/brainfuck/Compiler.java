package brainfuck;

import java.util.*;

public class Compiler {
    private static final Scanner sc = new Scanner(System.in);

    // Initializing array of lists for keeping commands.
    private static List<Command>[] initCommandList(int size) {
        List<Command>[] arr = new ArrayList[size];
        for (int i = 0; i < size; i++) {
            arr[i] = new ArrayList<>();
        }
        return arr;
    }

    private static List<Command> compile(String input) {
        List<Command>[] objCommands = initCommandList(100);
        char[] charCommands = input.toCharArray();
        int loopLevel = 0;

        for (char charCommand : charCommands) {
            switch (charCommand) {
                // Adding commands as classes to list.
                case ('>'):
                    objCommands[loopLevel].add(new IncrementPointer());
                    break;
                case ('<'):
                    objCommands[loopLevel].add(new DecrementPointer());
                    break;
                case ('+'):
                    objCommands[loopLevel].add(new IncrementData());
                    break;
                case ('-'):
                    objCommands[loopLevel].add(new DecrementData());
                    break;
                case ('.'):
                    objCommands[loopLevel].add(new Output());
                    break;
                case ('['):
                    loopLevel++;
                    break;
                case (']'):
                    if (loopLevel > 0) {
                        // Adding loop commands to upper loop level or main commands (0).
                        objCommands[loopLevel - 1].add(new Loop(objCommands[loopLevel]));
                        // Clearing loop list after adding it.
                        objCommands[loopLevel].clear();
                        loopLevel--;
                    }
                    break;
                default:
                    break;
            }
        }
        return objCommands[0];
    }

    // Two methods for executing commands
    // with string input (and compiling it to list of objects)
    // or pre-compiled list.
    public static void execute(String input) {
        for (Command objCommand : Compiler.compile(input)) {
            objCommand.execute();
        }
        Memory.reset();
    }

    public static void execute(List<Command> input) {
        for (Command objCommand : input) {
            objCommand.execute();
        }
        Memory.reset();
    }

    public static void main(String[] args) {
        System.out.println("Enter Brainfuck code:");
        Compiler.execute(sc.nextLine());
        System.out.println();
    }
}
