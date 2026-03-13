package org.lecture.service;

public class Menu {

    /**
     * Intro main menu > used to welcome new players to a wonderful gaming session.
     */
    public void mainMenu() {
        String mainMenu = """
                ###################################
                Welcome to ROCK - PAPER - SCISSORS
                ###################################
                """;
        System.out.println(mainMenu);
    }

    /**
     * Menu which is used to get input of a player. Prompts the user to type in r, p or s.
     */
    public void choiceMenu() {
        String choiceMenu = """
                Please choose your pick:
                 - (R)ock
                 - (P)aper
                 - (S)cissors
                """;
        System.out.println(choiceMenu);
    }

}
