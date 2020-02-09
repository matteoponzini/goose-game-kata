package it.matteoponzini.cli;

import javax.lang.model.element.TypeElement;

//TODO: add javadoc
public enum TypeCommand {
    ADD,
    MOVE,
    EXIT,
    HELP;

    static public  TypeCommand getTypeCommand(String value) {
        try {
            return  TypeCommand.valueOf(value);
        } catch (IllegalArgumentException ex) {
            return HELP;
        }
    }
}
