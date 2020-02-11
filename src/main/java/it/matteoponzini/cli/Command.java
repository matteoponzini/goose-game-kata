package it.matteoponzini.cli;

import it.matteoponzini.board.Board;
import it.matteoponzini.exception.CommandNotExistException;
import it.matteoponzini.exception.PlayerAlredyExistExeptionException;
import it.matteoponzini.exception.PlayerNotExistException;

import java.lang.reflect.InvocationTargetException;

//TODO: add javadoc
public interface Command <T> {
    //TODO: add javadoc
    void execute(Object[] args, T optionalArgument) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, PlayerAlredyExistExeptionException, PlayerNotExistException, CommandNotExistException;
}
