package org.iitd.ell781;

import java.util.ArrayList;

import static org.iitd.ell781.State.BoatPosition.LEFT;
import static org.iitd.ell781.State.BoatPosition.RIGHT;


public class CrossTheRiver {

    public final State GOAL_STATE;
    public final State INITIAL_STATE; // Everyone is on the left of the river and the position of boat is on the left


    public CrossTheRiver() {
        INITIAL_STATE = new State(true, true, true, true, LEFT);
        GOAL_STATE = new State(false,false,false,false, RIGHT);
    }

    public ArrayList<State> getValidStates(State currentState) {
        ArrayList<State> validStates = new ArrayList<>();

        if (currentState == INITIAL_STATE){
            validStates.add(new State(false,true,false,true,RIGHT));
            return validStates;
        }
        else{
            ArrayList<State> allStates = getAllNextStates(currentState);
            allStates.removeIf(state -> !isStateValid(state));
            validStates = allStates;
        }
        return validStates;
    }

    private boolean isStateValid(State state) {
        if(state.person){
            if(!state.wolf && !state.goat && !state.cabbage){
                return false;
            }
            else if (!state.wolf && !state.goat){
                return false;
            }
            else if(!state.goat && !state.cabbage){
                return false;
            }
        }
        else{
            if(state.wolf && state.goat && state.cabbage){
                return false;
            }
            else if (state.wolf && state.goat){
                return false;
            }
            else if(state.goat && state.cabbage){
                return false;
            }
        }
        return true;
    }

    private ArrayList<State> getAllNextStates(State state) {
        ArrayList<State> allStates = new ArrayList<>();

        // Person crosses the River
        State temp = new State(!state.person, state.wolf, state.goat, state.cabbage, (state.boatPosition == LEFT ? RIGHT : LEFT));
        allStates.add(temp);

        // Person and wolf cross the river
        if (state.person == state.wolf){
            temp = new State(!state.person, !state.wolf, state.goat, state.cabbage, (state.boatPosition == LEFT ? RIGHT : LEFT));
            allStates.add(temp);
        }

        // Person and goat cross the river
        if (state.person == state.goat){
            temp = new State(!state.person, state.wolf, !state.goat, state.cabbage, (state.boatPosition == LEFT ? RIGHT : LEFT));
            allStates.add(temp);
        }

        // Person and cabbage cross the river
        if (state.person == state.cabbage){
            temp = new State(!state.person, state.wolf, state.goat, !state.cabbage, (state.boatPosition == LEFT ? RIGHT : LEFT));
            allStates.add(temp);
        }

        return allStates;
    }
}
