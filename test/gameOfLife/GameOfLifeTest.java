package gameOfLife;

import org.junit.Test;

import static gameOfLife.GameGrid.at;
import static org.junit.Assert.assertEquals;

/**
 * Created by fbarbedette on 10/22/14.
 */
public class GameOfLifeTest {

    @Test
    public void gameLivingCellPositionMustBeEqual() {
        assertEquals(at(0, 1), at(0, 1));
    }
}
