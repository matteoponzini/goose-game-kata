package it.matteoponzini.cli;

import it.matteoponzini.board.Board;

public class ExitCommand implements Command<Board> {
    //TODO: add javadoc
    @Override
    public void execute(Object[] args, Board optionalArgument) {
        if(args == null || optionalArgument == null){
            throw new IllegalArgumentException("argument cannot be null");
        }
        System.exit(-1);
    }
}
