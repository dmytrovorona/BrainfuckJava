package brainfuck;

public class Output implements Command {
    public void execute(Memory m) {
        // Outputting char result to console.
        System.out.print((char) m.getCurrentCell());
    }
}
