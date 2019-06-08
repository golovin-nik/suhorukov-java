package com.jcourse.golovin;

import java.io.InputStream;
import java.util.List;

interface Parser {
    List<Command> getCommands(InputStream stream);
}
