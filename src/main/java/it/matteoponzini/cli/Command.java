package it.matteoponzini.cli;

import it.matteoponzini.board.Board;

//TODO: add javadoc
public interface Command <T> {
    //TODO: add javadoc
    void execute(Object[] args, T optionalArgument);
}
