package com.cazallau.managers;

import com.cazallau.model.Command;

/**
 * Created by gemabeltran on 26/1/17.
 */
public class CommandParser {
    public static String detectedParameter;

    public static Command parse(String text) {
        if (text.equalsIgnoreCase("quit") || text.equalsIgnoreCase("q")) {
            return Command.QUIT;
        }
        if (text.equalsIgnoreCase("help") || text.equalsIgnoreCase("h")) {
            return Command.HELP;
        }
        if (text.equalsIgnoreCase("add") || text.equalsIgnoreCase("a")) {
            return Command.ADD;
        }
        if (text.equalsIgnoreCase("delete") || text.equalsIgnoreCase("d")) {
            return Command.DELETE;
        }
        if (text.equalsIgnoreCase("list") || text.equalsIgnoreCase("l")) {
            return Command.LIST;
        }
        return Command.UNKNOW;
    }

}
