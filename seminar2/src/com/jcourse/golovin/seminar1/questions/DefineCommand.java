package com.jcourse.golovin.seminar1.questions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

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

class ConsoleParser implements Parser {
    @Override
    public List<Command> getCommands() {
        return null;
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
        try {
            double variableValue = Double.parseDouble(arguments[1]);
            String variableName = arguments[0];
            variables.put(variableName, variableValue); //положить элемент в Map
            variables.get(variableName); // достать элемент из Map
            stack.push(0.5); //положить элемент
            stack.pop(); //извлечь элемент
            stack.peek(); //посмотреть первый элемент на стеке не извлекая его
        } catch (Exception e) {

        }
    }
}
