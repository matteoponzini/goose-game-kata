package it.matteoponzini.cli;

import it.matteoponzini.board.Board;
//TODO: add javadoc
public class HelpCommand implements Command<Board> {
    //TODO: add javadoc
    @Override
    public void execute(Object[] args, Board optionalArgument) {
        if(args == null || optionalArgument == null){
            throw new IllegalArgumentException("argument cannot be null");
        }
        System.out.println("add <name player> - add a user to the game");
        System.out.println("move <name player> - move the player in the game");
        System.out.println("help - help to see commands");
    }
}
