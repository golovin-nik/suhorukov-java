package com.jcourse.golovin;

import java.util.Arrays;
import java.util.Map;
import java.util.Stack;

class PushCommand implements Command {

    @Inject(arg = ArgType.STACK)
    private Stack<Double> stack;

    @Inject(arg = ArgType.VARIABLES)
    private Map<String, Double> variables;

    @Inject(arg = ArgType.ARGUMENTS)
    private String[] arguments;

    public PushCommand() {
    }

    @Override
    public void execute() {
        System.out.println("stack = " + stack);
        System.out.println("variables = " + variables);
        System.out.println("arguments = " + Arrays.toString(arguments));
    }
}
