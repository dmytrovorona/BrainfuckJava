package brainfuck;

public class Memory {
    // Max memory limit.
    private static final int MAX = 30000;
    // Array of byte cells.
    private static byte[] cells = new byte[MAX];
    private static int pointer;

    public static void reset() {
        cells = new byte[MAX];
        pointer = 0;
    }

    public static int getMaxMemory() {
        return MAX;
    }

    public static int getPointer() {
        return pointer;
    }

    public static void setPointer(int value) {
        pointer = value;
    }

    public static byte getCurrentCell() {
        return cells[pointer];
    }

    public static void setCurrentCell(byte value) {
        cells[pointer] = value;
    }
}
