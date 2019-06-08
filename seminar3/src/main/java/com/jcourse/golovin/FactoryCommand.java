package com.jcourse.golovin;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Stack;

//1. Создать файл commands.properties (заполнить его командами, имеющимся у вас)
//2. Привести команды к виду пустой конструктор, метод execute без параметров
//3. Создать аннотацию Inject + аргумент ArgType
//4. Пометить поля комманд соответствующими аннотациями
//5. Создать фабрику команд, загрузить commands.properties через класс Properties
//6. Получить в методе getCommand(String) имя комманды и загрузить класс комманды
//через Class.forName и properties
//7. Создать объект класса через метод Class.newInstance();
//8. Пройтись по всем полям (Class.getDeclaredFields) и проверить наличие аннотации
//Inject. Если есть, то установить значение в поле созданного объекта, ориентируясь
//на ArgType аннотации

class FactoryCommand {
    static Properties properties;
    static Map<String, Double> variables = new HashMap<>();
    static Stack<Double> stack = new Stack<>();

    static {
        try {
            properties = new Properties();
            InputStream stream = FactoryCommand.class
                    .getClassLoader()
                    .getResourceAsStream("commands.properties");
            properties.load(stream);
            System.out.println("properties = " + properties);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //на вход строка, например, DEFINE a 4 -> DefineCommand()
    static Command getCommand(String line) {
        try {
            String[] tokens = line.split(" ");
            String className = properties.getProperty(tokens[0]);
            Class<?> aClass = Class.forName(className);

            Object command = aClass.newInstance();

            Field[] fields = aClass.getDeclaredFields();
            for (Field field : fields) {
                Inject annotation = field.getAnnotation(Inject.class);
                if (annotation != null) {
                    field.setAccessible(true);
                    switch (annotation.arg()) {
                        case STACK:
                            field.set(command, stack);
                            break;
                        case ARGUMENTS:
                            field.set(command, tokens);
                            break;
                        case VARIABLES:
                            field.set(command, variables);
                            break;
                    }
                    field.setAccessible(false);
                }
            }

            return (Command) command;
        } catch (IllegalAccessException |
                InstantiationException |
                ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        Command command = FactoryCommand.getCommand("PUSH a");
        command.execute();
    }
}
