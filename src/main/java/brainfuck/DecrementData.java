package brainfuck;

public class DecrementData implements Command {
    public void execute(Memory m) {
        m.setCurrentCell((byte) (m.getCurrentCell() - 1));
    }
}
