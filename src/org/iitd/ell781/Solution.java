package org.iitd.ell781;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println("Let us cross the river safely");
        CrossTheRiver problem = new CrossTheRiver();
        ArrayList<Node> result = BreadthFirstSearch(problem);
        printAllPossibleWays(result);
    }

    private static void printAllPossibleWays(ArrayList<Node> result) {
        System.out.println("The tuple represents (Person, Wolf, Goat, Cabbage, Boat Position).");
        System.out.println("If a particular value in the tuple is true, it implies the person or thing is on the left of the bank and similarly false implies on the right.");
        System.out.println("The last value i.e., the Boat position is either LEFT or RIGHT.");
        for (int i = 0; i < result.size(); i++) {
            System.out.println("Path: " + (i+1));
            ArrayList<Node> path = new ArrayList<>();
            Node temp = result.get(i);
            while (temp != null){
                path.add(temp);
                temp = temp.parent;
            }
            Collections.reverse(path);
            printPath(path);
        }
    }

    private static void printPath(ArrayList<Node> path) {
        for (Node node :
                path) {
            node.state.printState();
        }
    }

    private static ArrayList BreadthFirstSearch(CrossTheRiver problem) {

        ArrayList<Node> answer = new ArrayList<>();

        Node root = new Node(problem.INITIAL_STATE);
        Queue<Node> open = new LinkedList<>();
        Queue<Node> closed = new LinkedList<>();

        open.add(root);
        while (open.size() != 0) {
            Node temp = open.remove();
            closed.add(temp);
            if (problem.GOAL_STATE.equals(temp.state)) {
                answer.add(temp);
            }
            else{
                ArrayList<State> validStates = problem.getValidStates(temp.state);
                for (State state :
                        validStates) {
                    Node newNode = new Node(state, temp);
                    boolean flag = true;
                    for (Node node :
                            closed) {
                        if (newNode.equals(node)){
                            flag = false;
                        }
                    }
                    if(flag) open.add(newNode);
                }
            }
        }
        return answer;
    }
}
