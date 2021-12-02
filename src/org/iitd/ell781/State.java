package org.iitd.ell781;

import java.util.Objects;

public class State {
    public void printState() {
        System.out.println("("+ this.person + ", " + this.wolf + ", " + this.goat + ", " + this.cabbage + ", " + this.boatPosition + ")");
    }

    enum BoatPosition{
        LEFT, RIGHT
    }
    public final boolean person;
    public final boolean wolf;
    public final boolean goat;
    public final boolean cabbage;
    public final BoatPosition boatPosition;

    public State(boolean person, boolean wolf, boolean goat, boolean cabbage, BoatPosition boatPosition){

        this.person = person;
        this.wolf = wolf;
        this.goat = goat;
        this.cabbage = cabbage;
        this.boatPosition = boatPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        return person == state.person && wolf == state.wolf && goat == state.goat && cabbage == state.cabbage && boatPosition == state.boatPosition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(person, wolf, goat, cabbage, boatPosition);
    }
}
