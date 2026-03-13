package org.lecture.service;

public class Menu {

    public void mainMenu() {
        String mainMenu = """
                ###################################
                Welcome to ROCK - PAPER - SCISSORS
                ###################################
                """;
        System.out.println(mainMenu);
    }

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
