package org.iitd.ell781;

import java.util.Objects;

public class Node {
    protected final State state;
    protected final Node parent;

    public Node(State state) {
        this.state = state;
        this.parent = null;
    }

    public Node(State state, Node parent) {
        this.state = state;
        this.parent = parent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return state.equals(node.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(state);
    }
}
