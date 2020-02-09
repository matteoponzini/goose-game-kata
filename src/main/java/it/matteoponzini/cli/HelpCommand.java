package it.matteoponzini.cli;

import it.matteoponzini.board.Board;
//TODO: add javadoc
public class HelpCommand implements Command<Board> {
    //TODO: add javadoc
    @Override
    public void execute(Object[] args, Board optionalArgument) {
        System.out.println("HELP");
    }
}
