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

    /**
     * Method to get the number of neighbours of a GridLivingCell
     * @param livingCell - the gridLivingCell from which the neighbours number is calculated
     * @return 0
     */
    public int neighbours(GameLivingCell livingCell) {
        return 0;
    }

    /**
     * Methdod to get a GameLivingCell with the specified position
     * @param x - position on X axis
     * @param y - position on Y axis
     * @return GameLivingCell object
     */
    public static GameLivingCell at(int x, int y) {
        return new GameLivingCell(x, y);
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

}
