package it.matteoponzini;

import it.matteoponzini.board.Board;
import it.matteoponzini.cli.AddCommand;
import it.matteoponzini.cli.Command;
import it.matteoponzini.cli.CommandFactory;
import it.matteoponzini.exception.CommandNotExistException;
import it.matteoponzini.exception.PlayerAlredyExistExeptionException;
import it.matteoponzini.exception.PlayerNotExistException;
import it.matteoponzini.game.Dice;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Scanner;

public class Start {
    public static void main(String[] args) throws NoSuchMethodException, PlayerAlredyExistExeptionException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Scanner scanner = new Scanner(System.in);
        Board board = new Board();
        CommandFactory commandFactory = new CommandFactory();
        while (true){
            System.out.print("Insert command: ");
            String userInput = scanner.nextLine();
            String[] splitedInput = userInput.split("[ ]+");
            Command<Board> command = CommandFactory.getTypeCommand(splitedInput[0]);
            try {
                command.execute(splitedInput, board);
            } catch (InvocationTargetException | NoSuchMethodException | InstantiationException | IllegalAccessException | PlayerNotExistException | CommandNotExistException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
