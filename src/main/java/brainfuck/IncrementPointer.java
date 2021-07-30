package brainfuck;

public class IncrementPointer implements Command {
    public void execute(Memory m) {
        if (m.getPointer() == m.getMaxMemory() - 1) { // If memory is full
            // reset pointer to zero.
            m.setPointer(0);
        } else {
            m.setPointer(m.getPointer() + 1);
        }
    }
}
