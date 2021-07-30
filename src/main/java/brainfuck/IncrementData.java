package brainfuck;

public class IncrementData implements Command {
    public void execute(Memory m) {
        m.setCurrentCell((byte) (m.getCurrentCell() + 1));
    }
}
