package gameOfLife;

import org.junit.Test;

import static gameOfLife.GameGrid.at;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by fbarbedette on 10/22/14.
 */
public class GameOfLifeTest {

    @Test
    public void gameLivingCellPositionMustBeEqual() {
        assertEquals(at(0, 1), at(0, 1));
    }

    @Test
    public void gameGridMustBeEqual() {
        assertEquals(new GameGrid(at(0, 1)), new GameGrid(at(0, 1)));
    }

    @Test
    public void neighboursNumberMustBeZeroWithoutNeighbours() {
        assertEquals(0, new GameGrid(at(0, 1)).neighbours(at(0, 1)));
    }

    @Test
    public void neighboursNumberMustCountVerticalCells() {
        assertEquals(1, new GameGrid(at(0, 0), at(0, 1)).neighbours(at(0, 1)));
    }

    @Test
    public void neighboursNumberMustNotCountItself() {
        assertEquals(0, new GameGrid(at(0, 0)).neighbours(at(0, 0)));
    }
}
