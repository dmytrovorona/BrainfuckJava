package brainfuck;

public class DecrementPointer implements Command {
    public void execute() {
        if (Memory.getPointer() == 0) { // If pointer is zero
            // then reset pointer to rightmost memory position.
            Memory.setPointer(Memory.getMaxMemory() - 1);
        } else {
            Memory.setPointer(Memory.getPointer() - 1);
        }
    }
}
