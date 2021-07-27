package brainfuck;

public class Output implements Command {
    private static StringBuilder outputString = new StringBuilder();

    public void execute() {
        // Outputing char result to console and adding it to string builder.
        outputString.append((char) Memory.getCurrentCell());
        System.out.print((char) Memory.getCurrentCell());
    }

    public static String getOutput() {
        return outputString.toString();
    }

    public static void clearOutput() {
        outputString = new StringBuilder();
    }
}
