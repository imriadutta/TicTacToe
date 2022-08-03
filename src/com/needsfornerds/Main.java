package com.needsfornerds;

public class Main {

    public static void main(String[] args) {

        callGame();
    }

    public static void callGame() {

        Game game = new Game();
        game.createGUI();
    }
}
