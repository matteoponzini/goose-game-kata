package it.matteoponzini.cli;

import it.matteoponzini.board.Board;

public class ExitCommand implements Command<Board> {
    //TODO: add javadoc
    @Override
    public void execute(Object[] args, Board optionalArgument) {
        System.out.println("EXIT");
        //TODO: create exception for exit
    }
}
