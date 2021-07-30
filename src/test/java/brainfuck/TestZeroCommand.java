package brainfuck;

public class TestZeroCommand implements Command{
    public void execute (Memory m) {
        // Test command that sets current memory cell to zero.
        m.setCurrentCell((byte) 0);
    }
}
