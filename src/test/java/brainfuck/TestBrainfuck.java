package brainfuck;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class TestBrainfuck {
    @Test
    void testLongString() {
        String input = "++++[++++>---<]>-.---[----->+<]>-.+++[->+++<]>++.+++++" +
                "+++.+++++.--------.-[--->+<]>--.+[->+++<]>+.++++++++.-[++>---" +
                "<]>+.-[--->++<]>-.++++++++++.+[---->+<]>+++.[->+++<]>+.++++++" +
                "+++++++.-[->+++++<]>-.+[->+++<]>++.[--->+<]>----.----.+++++.+" +
                "++[->+++<]>.+++++++++++++.---------.------.[--->+<]>-.[-->+++" +
                "++++<]>.++.---.--------.+++++++++++.+++[->+++<]>++.++++++++++" +
                "++..----.+++++.-------.-[--->+<]>--.++[--->++<]>.-----------." +
                "+++++++++++++.-------.--[--->+<]>--.[->+++<]>++.++++++.--.";
        String result = "Brainfuck is an esoteric programming language";
        Compiler.execute(input);
        Assertions.assertEquals(result, Output.getOutput());
        Output.clearOutput();
    }

    @Test
    void testSymbols() {
        String input = "[]+++++++++++[>>+>+>++++++[<<+<+++>>>-]<<<<-]\\\"A*$\\\";" +
                "?@![#>>+<<]>[>>]<<<<[>++<[-]]>.";
        String result = "O";
        Compiler.execute(input);
        Assertions.assertEquals(result, Output.getOutput());
        Output.clearOutput();
    }

    @Test
    void testLoop() {
        String input = "++++++++[->-[->-[->-[-]<]<]<]>++++++++[<++++++++++>-]<[>+>+<<-]>-.>-----.>";
        String result = "OK";
        Compiler.execute(input);
        Assertions.assertEquals(result, Output.getOutput());
        Output.clearOutput();
    }

    @Test
    void testObjects() {
        List<Command> obj = new ArrayList<>();
        List<Command> loop = new ArrayList<>();
        String strCommands = "-[----->+<]>--.";
        String outputObj;
        String outputStr;

        obj.add(new DecrementData());
        loop.add(new DecrementData());
        loop.add(new DecrementData());
        loop.add(new DecrementData());
        loop.add(new DecrementData());
        loop.add(new DecrementData());
        loop.add(new IncrementPointer());
        loop.add(new IncrementData());
        loop.add(new DecrementPointer());
        obj.add(new Loop(loop));
        obj.add(new IncrementPointer());
        obj.add(new DecrementData());
        obj.add(new DecrementData());
        obj.add(new Output());

        Compiler.execute(obj);
        outputObj = Output.getOutput();
        Output.clearOutput();

        Compiler.execute(strCommands);
        outputStr = Output.getOutput();

        Assertions.assertEquals(outputObj, outputStr);
        Output.clearOutput();
    }
}
