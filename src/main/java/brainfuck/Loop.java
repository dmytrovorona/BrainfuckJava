package brainfuck;

import java.util.ArrayList;
import java.util.List;

public class Loop implements Command {
    private final List<Command> innerLoopCommands;
    public Loop(List<Command> commandsList) {
        innerLoopCommands = new ArrayList<>(commandsList);
    }

    public void execute(Memory m) {
        // Loop commands execute while current cell data is not zero.
        while (m.getCurrentCell() != 0) {
            for (Command innerLoopCommand : innerLoopCommands) {
                innerLoopCommand.execute(m);
            }
        }
    }
}