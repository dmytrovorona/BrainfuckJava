package brainfuck;

public class Memory {
    // Max memory limit.
    private final int MAX = 30000;
    // Array of byte cells.
    private byte[] cells = new byte[MAX];
    private int pointer;

    public int getMaxMemory() {
        return MAX;
    }

    public int getPointer() {
        return pointer;
    }

    public void setPointer(int value) {
        pointer = value;
    }

    public byte getCurrentCell() {
        return cells[pointer];
    }

    public void setCurrentCell(byte value) {
        cells[pointer] = value;
    }
}
