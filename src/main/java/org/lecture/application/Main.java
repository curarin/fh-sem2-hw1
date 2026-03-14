package org.lecture.application;

import org.lecture.service.GameSimulation;

public class Main {
    public static void main(String[] args) {
        GameSimulation gameSimulation = new GameSimulation();
        gameSimulation.runSimulation();
    }
}