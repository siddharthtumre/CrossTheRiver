package org.iitd.ell781;

public class State {
    enum BoatPosition{
        LEFT, Right
    }
    private final boolean person;
    private final boolean wolf;
    private final boolean goat;
    private final boolean cabbage;
    private final BoatPosition boatPosition;

    public State(boolean person, boolean wolf, boolean goat, boolean cabbage, BoatPosition boatPosition){

        this.person = person;
        this.wolf = wolf;
        this.goat = goat;
        this.cabbage = cabbage;
        this.boatPosition = boatPosition;
    }
}
