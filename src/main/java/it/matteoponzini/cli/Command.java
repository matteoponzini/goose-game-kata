package it.matteoponzini.cli;

import it.matteoponzini.board.Board;

import java.lang.reflect.InvocationTargetException;

//TODO: add javadoc
public interface Command <T> {
    //TODO: add javadoc
    void execute(Object[] args, T optionalArgument) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;
}
