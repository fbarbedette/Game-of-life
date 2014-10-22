package gameOfLife;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by fbarbedette on 10/22/14.
 */
public class GameGrid {

    private final Set<GameLivingCell> gridLivingCells;

    public GameGrid(GameLivingCell... livingCells) {
        gridLivingCells = new HashSet<GameLivingCell>(Arrays.asList(livingCells));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GameGrid)) return false;

        GameGrid gameGrid = (GameGrid) o;

        if (gridLivingCells != null ? !gridLivingCells.equals(gameGrid.gridLivingCells) : gameGrid.gridLivingCells != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return gridLivingCells != null ? gridLivingCells.hashCode() : 0;
    }

    public static GameLivingCell at(int x, int y) {
        return new GameLivingCell(x, y);
    }
}
