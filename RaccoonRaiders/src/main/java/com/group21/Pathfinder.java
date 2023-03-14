package com.group21;

import java.util.ArrayList;

public class PathFinder {
    
    GamePanel gp;
    Node[][] node;
    ArrayList<Node> openList = new ArrayList<>();
    public ArrayList<Node> pathList = new ArrayList<>();
    Node startNode, goalNode, currentNode;
    boolean goalReached = false;
    int step = 0;

    public PathFinder(GamePanel gp) {
        this.gp = gp;
        instantiateNode();
    }

    /*
     * Creates node for every tile on the map
     */
    public void instantiateNode() {
        node = new Node[gp.maxScreenCol][gp.maxScreenRow];

        int col = 0;
        int row = 0;

        while (col < gp.maxScreenCol && row < gp.maxScreenRow) {
            
            node[col][row] = new Node(col,row);

            col++;
            if (col == gp.maxScreenCol) {
                col = 0;
                row++;
            }
        }
    }

    /*
     * Resets nodes' status and all other settings.
     */
    public void resetNodes() {
        int col = 0;
        int row = 0;

        while (col < gp.maxScreenCol && row < gp.maxScreenRow) {
            
            node[col][row].open = false;
            node[col][row].checked = false;
            node[col][row].solid = false;

            node[col][row] = new Node(col,row);

            col++;
            if (col == gp.maxScreenCol) {
                col = 0;
                row++;
            }
        }

        // Reset other settings
        openList.clear();
        pathList.clear();
        goalReached = false;
        step = 0;
    }
}
