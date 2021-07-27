package brainfuck;

public class IncrementPointer implements Command {
    public void execute() {
        if (Memory.getPointer() == Memory.getMaxMemory() - 1) { // If memory is full
            // reset pointer to zero.
            Memory.setPointer(0);
        } else {
            Memory.setPointer(Memory.getPointer() + 1);
        }
    }
}
