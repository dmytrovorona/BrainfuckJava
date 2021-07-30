package brainfuck;

public class DecrementPointer implements Command {
    public void execute(Memory m) {
        if (m.getPointer() == 0) { // If pointer is zero
            // then reset pointer to rightmost memory position.
            m.setPointer(m.getMaxMemory() - 1);
        } else {
            m.setPointer(m.getPointer() - 1);
        }
    }
}
