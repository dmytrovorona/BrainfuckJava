package brainfuck;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class TestBrainfuck {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Test
    void testLongString() {
        Memory memory = new Memory();
        Compiler compiler = new Compiler();
        CommandsMap cm = new CommandsMap();
        System.setOut(new PrintStream(outputStreamCaptor));
        String input = "++++[++++>---<]>-.---[----->+<]>-.+++[->+++<]>++.+++++" +
                "+++.+++++.--------.-[--->+<]>--.+[->+++<]>+.++++++++.-[++>---" +
                "<]>+.-[--->++<]>-.++++++++++.+[---->+<]>+++.[->+++<]>+.++++++" +
                "+++++++.-[->+++++<]>-.+[->+++<]>++.[--->+<]>----.----.+++++.+" +
                "++[->+++<]>.+++++++++++++.---------.------.[--->+<]>-.[-->+++" +
                "++++<]>.++.---.--------.+++++++++++.+++[->+++<]>++.++++++++++" +
                "++..----.+++++.-------.-[--->+<]>--.++[--->++<]>.-----------." +
                "+++++++++++++.-------.--[--->+<]>--.[->+++<]>++.++++++.--.";
        String result = "Brainfuck is an esoteric programming language";
        compiler.execute(memory, cm, input);
        Assertions.assertEquals(result, outputStreamCaptor.toString());
    }

    @Test
    void testSymbols() {
        Memory memory = new Memory();
        Compiler compiler = new Compiler();
        CommandsMap cm = new CommandsMap();
        System.setOut(new PrintStream(outputStreamCaptor));
        String input = "[]+++++++++++[>>+>+>++++++[<<+<+++>>>-]<<<<-]\\\"A*$\\\";" +
                "?@![#>>+<<]>[>>]<<<<[>++<[-]]>.";
        String result = "O";
        compiler.execute(memory, cm, input);
        Assertions.assertEquals(result, outputStreamCaptor.toString());
    }

    @Test
    void testLoop() {
        Memory memory = new Memory();
        Compiler compiler = new Compiler();
        CommandsMap cm = new CommandsMap();
        System.setOut(new PrintStream(outputStreamCaptor));
        String input = "++++++++[->-[->-[->-[-]<]<]<]>++++++++[<++++++++++>-]<[>+>+<<-]>-.>-----.>";
        String result = "OK";
        compiler.execute(memory, cm, input);
        Assertions.assertEquals(result, outputStreamCaptor.toString());
    }

    @Test
    void testObjects() {
        Memory memoryObj = new Memory();
        Memory memoryStr = new Memory();
        Compiler compiler = new Compiler();
        CommandsMap cm = new CommandsMap();
        String resObj;
        String resStr;
        ArrayDeque<Object> obj = new ArrayDeque<>();
        List<Command> loop = new ArrayList<>();
        String strCommands = "-[----->+<]>--.";
        System.setOut(new PrintStream(outputStreamCaptor));

        obj.push(new DecrementData());
        loop.add(new DecrementData());
        loop.add(new DecrementData());
        loop.add(new DecrementData());
        loop.add(new DecrementData());
        loop.add(new DecrementData());
        loop.add(new IncrementPointer());
        loop.add(new IncrementData());
        loop.add(new DecrementPointer());
        obj.push(new Loop(loop));
        obj.push(new IncrementPointer());
        obj.push(new DecrementData());
        obj.push(new DecrementData());
        obj.push(new Output());

        compiler.execute(memoryObj, obj);
        resObj = outputStreamCaptor.toString();
        outputStreamCaptor.reset();
        compiler.execute(memoryStr, cm, strCommands);
        resStr = outputStreamCaptor.toString();
        Assertions.assertEquals(resObj, resStr);
    }

    @Test
    void testAddCommand() {
        Memory memory = new Memory();
        Compiler compiler = new Compiler();
        CommandsMap cm = new CommandsMap();
        cm.addCommand('=', new TestZeroCommand());
        String input = "+++++--++=.";
        byte result = 0;
        compiler.execute(memory, cm, input);
        Assertions.assertEquals(result, memory.getCurrentCell());
    }
}
