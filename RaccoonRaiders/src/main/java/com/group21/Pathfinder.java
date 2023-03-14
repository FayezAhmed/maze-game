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

    public boolean search() {
        while (goalReached == false && step < 500) {

            int col = currentNode.col;
            int row = currentNode.row;

            // check the current node
            currentNode.checked = true;
            openList.remove(currentNode);

            // open the up node
            if (row - 1 >= 0) {
                openNode(node[col][row - 1]);
            }
            // open the left node
            if (col - 1 >= 0) {
                openNode(node[col - 1][row]);
            }
            // open the down node
            if (row + 1 < gp.maxScreenCol) {
                openNode(node[col][row + 1]);
            }
            // open the right node
            if (col + 1 < gp.maxScreenCol) {
                openNode(node[col + 1][row]);
            }

            // find the best node
            int bestNodeIndex = 0;
            int bestNodefCost = 999;

            for (int i = 0; i < openList.size(); i++) {

                //  check if this node's F cost is better
                if(openList.get(i).fCost < bestNodefCost) {
                    bestNodeIndex = i;
                    bestNodefCost = openList.get(i).fCost;
                }

                // if F cost is equal, check the G cost
                else if (openList.get(i).fCost == bestNodefCost) {
                    if(openList.get(i).gCost < openList.get(bestNodeIndex).gCost) {
                        bestNodeIndex = i;
                    }
                }
            }

            // if there is no node in openList, end the loop

            if (openList.size() == 0) {
                break;
            }

            // after the loop, openList[bestNodeIndex] is the next step 
            currentNode = openList.get(bestNodeIndex);

            if (currentNode == goalNode) {
                goalReached = true;
                trackThePath();
            }
            step++;
        }

        return goalReached;
    }

    public void openNode(Node node) {
        if(node.open == false && node.checked == false && node.solid == false) {
            
            node.open = true;
            node.parent = currentNode;
            openList.add(node);
        }
    }

    public void trackThePath() {
        Node current = goalNode;

        while(current != startNode) {

            pathList.add(0, current);
            current = current.parent;
        }
    }
}
