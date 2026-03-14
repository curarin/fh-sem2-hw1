package org.lecture.service;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Menu {

    /**
     * Intro main menu > used to welcome new players to a wonderful gaming session.
     */
    public void mainMenu() {
        log.trace("mainMenu()");
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
        log.trace("choiceMenu()");
        String choiceMenu = """
                Please choose your pick:
                 - (R)ock
                 - (P)aper
                 - (S)cissors
                """;
        System.out.println(choiceMenu);
    }

    /**
     * Menu which is used to get input of a player. Prompts the user to either play or load.
     */
    public void gameActionPlayOrLoad() {
        log.trace("gameActionPlayOrLoad()");
        String choiceMenu = """
                Do you want to:
                 - (P)lay?
                 - (L)oad existing game safe?
                """;
        System.out.println(choiceMenu);
    }

    /**
     * Menu which is used to get input of a player. Prompts the user to either play or safe.
     */
    public void gameActionPlayOrSafe() {
        log.trace("gameActionPlayOrSafe()");
        String choiceMenu = """
                Do you want to:
                 - (P)lay?
                 - (S)afe current game?
                """;
        System.out.println(choiceMenu);
    }

}
