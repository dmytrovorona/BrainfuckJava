package brainfuck;

public class IncrementData implements Command {
    public void execute() {
        Memory.setCurrentCell((byte) (Memory.getCurrentCell() + 1));
    }
}
