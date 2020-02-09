package it.matteoponzini;

import it.matteoponzini.game.Dice;

public class Start {
    public static void main(String[] args) {
        System.out.println(new Dice(6).roll());
    }
}
