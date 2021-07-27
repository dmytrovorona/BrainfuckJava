package brainfuck;

public class DecrementData implements Command {
    public void execute() {
        Memory.setCurrentCell((byte) (Memory.getCurrentCell() - 1));
    }
}
