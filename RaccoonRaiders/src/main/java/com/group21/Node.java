package com.group21;

/**
 * Node class used for pathfinding algorithm
 */
public class Node {
    
    Node parent;
    public int col;
    public int row;
    int gCost;
    int hCost;
    int fCost;
    boolean solid;
    boolean open;
    boolean checked;

    /**
     * Constructor.
     * 
     * @param col the tile column position
     * @param row the tile row position
     */
    public Node(int col, int row) {
        this.col = col;
        this.row = row;
    }
}
