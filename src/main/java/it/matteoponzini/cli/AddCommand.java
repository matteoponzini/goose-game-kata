package it.matteoponzini.cli;

import it.matteoponzini.board.Board;

public class AddCommand implements Command<Board> {
    //TODO: add javadoc
    @Override
    public void execute(Object[] args, final Board board) {
        if(args == null){
            throw new NullPointerException("argument cannot be null");
        }
        if(board == null){
            throw new NullPointerException("argument cannot be null");
        }
        if(args.length <= 0){
            throw new IllegalArgumentException("argument must be greater than zero");
        }
        System.out.println("ADD");
    }

}
