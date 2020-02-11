package it.matteoponzini.cli;

import it.matteoponzini.board.Board;
import it.matteoponzini.exception.CommandNotExistException;
import it.matteoponzini.exception.PlayerAlredyExistExeptionException;
import it.matteoponzini.exception.PlayerNotExistException;
import it.matteoponzini.game.Player;
import it.matteoponzini.utils.MovePlayer;

import java.lang.reflect.InvocationTargetException;

//TODO: add javadoc
public class MoveCommand implements Command<Board> {
    //TODO: add javadoc
    @Override
    public void execute(Object[] args, Board board) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, PlayerAlredyExistExeptionException, PlayerNotExistException, CommandNotExistException {
        if(args == null || board == null){
            throw new IllegalArgumentException("argument cannot be null");
        }
        if(args.length == 1){
            throw new CommandNotExistException("Missing the argument in the command you typed");
        }
        board.movePlayer(new Player((String) args[1]));
    }
}
