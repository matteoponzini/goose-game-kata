package it.matteoponzini.cli;

import it.matteoponzini.board.Board;
import it.matteoponzini.exception.CommandNotExistException;
import it.matteoponzini.exception.PlayerAlredyExistExeptionException;
import it.matteoponzini.exception.PlayerNotExistException;
import it.matteoponzini.game.Player;

public class AddCommand implements Command<Board> {
    //TODO: add javadoc
    @Override
    public void execute(Object[] args, final Board board) throws CommandNotExistException {
        if(args == null || board== null){
            throw new NullPointerException("argument cannot be null");
        }
        if(args.length <= 0){
            throw new IllegalArgumentException("argument must be greater than zero");
        }
        if(args.length == 1){
            throw new CommandNotExistException("Missing the argument in the command you typed");
        }
        try {
            board.addPlayer(new Player((String) args[1]));
        } catch (PlayerAlredyExistExeptionException | PlayerNotExistException e) {
            System.out.println(e.getMessage());
        }

    }

}
