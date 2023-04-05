package com.group21;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class PathfinderTest {

    private GamePanel gp;
    private Pathfinder pf;
    @BeforeEach
    public void setUp() {
        gp = new GamePanel();
        pf = new Pathfinder(gp);
    }
    @Test
    public void InstantiationTest() {
        assertNotNull(pf.node);
        assertEquals(gp.maxScreenCol, pf.node.length);
        assertEquals(gp.maxScreenRow, pf.node[0].length);
    }

    @Test
    public void ResetNodesTest() {
        // Set some nodes as solid
        pf.node[1][1].solid = true;
        pf.node[2][2].solid = true;

        // Call resetNodes() method
        pf.resetNodes();

        // If all nodes are reset
        for (int col = 0; col < gp.maxScreenCol; col++) {
            for (int row = 0; row < gp.maxScreenRow; row++) {
                Node node = pf.node[col][row];
                assertFalse(node.open);
                assertFalse(node.checked);
                assertFalse(node.solid);
            }
        }

        assertTrue(pf.openList.isEmpty());
        assertTrue(pf.pathList.isEmpty());
        assertFalse(pf.goalReached);
        assertEquals(0, pf.step);
    }

    @Test
    public void SetNodesTest() {
        // Set start nodes
        pf.setNodes(0, 0, 4, 4);

        // Check that start nodes are set correctly
        assertEquals(0, pf.startNode.col);
        assertEquals(0, pf.startNode.row);
        assertEquals(4, pf.goalNode.col);
        assertEquals(4, pf.goalNode.row);

        // Check that openList contains startNode
        assertTrue(pf.openList.contains(pf.startNode));

        // Check that solid nodes are set correctly
        assertFalse(pf.node[0][0].solid);
        assertTrue(pf.node[1][1].solid);
        assertTrue(pf.node[2][2].solid);
    }

    @Test
    public void GetCostTest() {
        Node node = new Node(0, 0);

        // Call getCost() method
        pf.getCost(node);

        // Check that G, H, and F costs are set correctly
        assertEquals(0, node.gCost);
        assertEquals(0, node.hCost);
        assertEquals(0, node.fCost);

        pf.setNodes(0, 0, 4, 4);

        // Call getCost() method for a different node
        pf.getCost(pf.node[1][1]);

        // Check that G, H, and F costs are set correctly
        assertEquals(2, pf.node[1][1].gCost);
        assertEquals(6, pf.node[1][1].hCost);
        assertEquals(8, pf.node[1][1].fCost);
    }
}