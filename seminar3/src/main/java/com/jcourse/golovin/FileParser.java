package com.jcourse.golovin;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Stack;

class FileParser implements Parser {
    InputStream stream;
    Stack<Double> stack;
    Map<String, Double> variables;

    public FileParser(InputStream stream, Stack<Double> stack, Map<String, Double> variables) {
        this.stream = stream;
        this.stack = stack;
        this.variables = variables;
    }

    public List<Command> getCommands(InputStream stream) {
        return null;
    }
}
