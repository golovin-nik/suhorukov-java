package com.jcourse.golovin.seminar1.questions;

import java.io.FileInputStream;
import java.io.FileReader;
import java.util.*;

interface Command {
    void execute();
}

interface Parser {
    List<Command> getCommands();
}

class FileParser implements Parser {
    public FileParser(String arg, String arg1) {

    }

    @Override
    public List<Command> getCommands() {
        return null;
    }
}


enum CommandName {
    PUSH, PLUS, MINUS, DEFINE
}

class ConsoleParser implements Parser {
    @Override
    public List<Command> getCommands() {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Command> commands = new ArrayList<>();
        Map<String, Double> variables = new HashMap<>();
        Stack<Double> stack = new Stack<>();

        while (true) {
            String s = scanner.nextLine(); //DEFINE a 4
            if ("exit".equals(s)) {
                break;
            }

            String[] arguments = s.split(" "); // [DEFINE, a, 4]
            CommandName commandName = CommandName.valueOf(
                    arguments[0].toUpperCase());
            String[] withoutCommandName =
                    Arrays.copyOfRange(arguments, 1, arguments.length);

            Command command;
            switch (commandName) {
                case DEFINE:
                    command = new DefineCommand(withoutCommandName, variables);
                    break;
                default:
                    throw new IllegalStateException("Неизвестная комманда");
            }
            commands.add(command);
        }
        return commands;
    }
}

class Calc {
    Parser parser;

    public Calc(Parser parser) {
        this.parser = parser;
    }

    void execute() {
        List<Command> commands = parser.getCommands();
        for (Command command : commands) {
            command.execute();
        }
    }

    public static void main(String[] args) {
        Parser parser;
        if (args.length == 0) {
            parser = new ConsoleParser();
        } else {
            parser = new FileParser(args[0], args[1]);
        }
        Calc calc = new Calc(parser);
        calc.execute();
    }
}

//DEFINE a 4
public class DefineCommand implements Command {
    String[] arguments;
    Map<String, Double> variables = new HashMap<>();
    Stack<Double> stack = new Stack<>();


    public DefineCommand(String[] arguments, Map<String, Double> variables) {
        this.arguments = arguments;
        this.variables = variables;
    }

    @Override
    public void execute() {
        //arguments - [a, 4]
        //DEFINE a 4
        try {
            double variableValue = Double.parseDouble(arguments[1]);
            String variableName = arguments[0];
            variables.put(variableName, variableValue); //положить элемент в Map
            Double value = variables.get(variableName);// достать элемент из Map
            stack.push(0.5); //положить элемент
            stack.pop(); //извлечь элемент
            stack.peek(); //посмотреть первый элемент на стеке не извлекая его
        } catch (Exception e) {

        }
    }
}


// 2 + 2 * 3 - не нужно
// PUSH 2
// PUSH 2
// +
// PRINT
// POP
// * - исключение пустой стек

