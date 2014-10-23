package gameOfLife;

import java.awt.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by fbarbedette on 10/22/14.
 */
public class GameGrid {

    private final Set<GameLivingCell> gridLivingCells;

    public GameGrid() {
        gridLivingCells = new HashSet<GameLivingCell>();
    }

    public GameGrid(GameLivingCell... livingCells) {
        gridLivingCells = new HashSet<GameLivingCell>(Arrays.asList(livingCells));
    }

    /**
     * Method to get the number of neighbours of a GridLivingCell on the vertical line
     * @param livingCell - the gridLivingCell from which the neighbours number is calculated
     * @return 0
     */
    public int neighbours(GameLivingCell livingCell) {
        int neighboursNumber = 0;
        for (int y = -1; y <= 1; y++) {
            for (int x = -1; x <= 1; x++) {
                if (gridLivingCells.contains(at(livingCell.getPositionX() + x, livingCell.getPositionY() + y)) && !(y == 0 && x == 0)) {
                    neighboursNumber++;
                }
            }
        }
        return neighboursNumber;
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

    /**
     * Method to get the state of the next generation of the game grid
     * @return the game grid next generation
     */
    public GameGrid next() {
        GameGrid next = new GameGrid();
        int neighboursNumber = -1;
        for (GameLivingCell cell : gridLivingCells) {
            for (int y = -1; y <= 1; y++) {
                for (int x = -1; x <= 1; x++) {
                    GameLivingCell tmp = at(cell.getPositionX() + x, cell.getPositionY() + y);
                    neighboursNumber = neighbours(tmp);
                    if ((gridLivingCells.contains(tmp) && neighboursNumber == 2) || neighboursNumber == 3) {
                        next.gridLivingCells.add(tmp);
                    }
                }
            }
        }
        return next;
    }

    /**
     * Method to get the max point of the grid game
     * @return the grid max point
     */
    public Point getGridMaxPoint() {

        Iterator<GameLivingCell> it = gridLivingCells.iterator();
        int maxPosX = 0;
        int maxPosY = 0;
        while (it.hasNext()) {
            GameLivingCell tmp = it.next();
            if (tmp.getPositionX() > maxPosX )
                maxPosX = tmp.getPositionX();
            if(tmp.getPositionY() > maxPosY)
                maxPosY = tmp.getPositionY();
        }
        Point max = new Point(maxPosX, maxPosY);
        return max;
    }

    /**
     * Method to get the min point of the grid game
     * @return the grid min point
     */
    public Point getGridMinPoint() {

        Iterator<GameLivingCell> it = gridLivingCells.iterator();
        int minPosX = 0;
        int minPosY = 0;
        while (it.hasNext()) {
            GameLivingCell tmp = it.next();
            if (tmp.getPositionX() < minPosX )
                minPosX = tmp.getPositionX();
            if(tmp.getPositionY() < minPosY)
                minPosY = tmp.getPositionY();
        }
        Point max = new Point(minPosX, minPosY);
        return max;
    }

    public Set<GameLivingCell> getGridLivingCells() {
        return gridLivingCells;
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
