package it.matteoponzini.cli;

import it.matteoponzini.board.Board;
import it.matteoponzini.game.Player;

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
        //TODO: controlare che esiste almeno un nome spazio multi giocatri ciclare se è maggiore di uno e aggiungere
        board.addPlayer(new Player((String) args[1]));

    }

}
