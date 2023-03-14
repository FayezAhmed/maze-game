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

    public void setNodes(int startCol, int startRow, int goalCol, int goalRow) {

        resetNodes();

        // set start and goal node
        startNode = node[startCol][startRow];
        currentNode = startNode;
        goalNode = node[goalCol][goalRow];
        openList.add(currentNode);

        int col = 0;
        int row = 0;
        
        while (col < gp.maxScreenCol && row < gp.maxScreenRow) {
            
            // set solid node
            // check tiles
            int tileNum = gp.tm.mapArr[col][row];
            if (gp.tm.tiles.get(tileNum).collision == true) {
                node[col][row].solid = true;
            }

            // set cost
            getCost(node[col][row]);

            col++;
            if (col == gp.maxScreenCol) {
                col = 0;
                row++;
            }
        }

    }

    public void getCost(Node node) {
        
        // G cost
        int xDist = Math.abs(node.col - startNode.col);
        int yDist = Math.abs(node.row - startNode.row);
        node.gCost = xDist + yDist;
        
        // H cost
        xDist = Math.abs(node.col - goalNode.col);
        yDist = Math.abs(node.row - goalNode.row);
        node.hCost = xDist + yDist;
        
        // F cost
        node.fCost = node.gCost + node.hCost;
        
    }
}
