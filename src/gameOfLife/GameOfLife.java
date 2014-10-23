package gameOfLife;

import java.awt.*;

import static gameOfLife.GameGrid.at;

/**
 * Created by fbarbedette on 10/22/14.
 */
public class GameOfLife {

    private GameGrid gameGrid;

    private final static int GENERATIONS_NUMBER = 100;
    private final static int MIN_LINES = 14;
    private final static int MIN_COLUMNS = 38;

    public static void main (String[] args) {
        System.out.println("Start of the game");

        GameOfLife gameOfLife = initGameOfLife();

        launchGameOfLife(gameOfLife);
        System.out.println("End of the game");
    }

    private static void launchGameOfLife(GameOfLife gameOfLife) {
        for(int i = 0; i <= GENERATIONS_NUMBER ; i++) {
            System.out.println("Generation " + i + ":");
            display(gameOfLife);
            gameOfLife.gameGrid = gameOfLife.gameGrid.next();
        }
    }

    private static void display(GameOfLife gameOfLife) {
        Point min = gameOfLife.gameGrid.getGridMinPoint();
        Point max = gameOfLife.gameGrid.getGridMaxPoint();

        for(int y = min.y ; y <= (max.y-min.y < MIN_LINES ? MIN_LINES - min.y : max.y) ; y++) {
            for(int x = min.x ; x <= (max.x-min.x < MIN_COLUMNS ? MIN_COLUMNS - min.x : max.x) ; x++) {
                GameLivingCell tmp = at(x, y);
                if(gameOfLife.gameGrid.getGridLivingCells().contains(tmp)) {
                    System.out.print('x');
                } else {
                    System.out.print('_');
                }
            }
            System.out.println();
        }

    }

    private static GameOfLife initGameOfLife() {
        GameOfLife game = new GameOfLife();
        game.gameGrid = new GameGrid(
                at(1,5),
                at(1,6),
                at(2,5),
                at(2,6),
                at(3,5),
                at(3,6),
                at(4,6),
                at(5,5),
                at(5,7),
                at(6,5),
                at(6,7),
                at(7,6),
                at(10,3),
                at(10,4),
                at(10,8),
                at(10,9),
                at(11,3),
                at(11,5),
                at(11,7),
                at(11,9),
                at(12,4),
                at(12,5),
                at(12,6),
                at(12,7),
                at(12,8),
                at(13,5),
                at(13,6),
                at(13,7),
                at(14,6),
                at(21,7),
                at(21,9),
                at(22,8),
                at(22,9),
                at(23,8),
                at(26,3),
                at(26,4),
                at(26,5),
                at(27,2),
                at(27,6),
                at(28,1),
                at(28,7),
                at(29,2),
                at(29,6),
                at(30,3),
                at(30,4),
                at(30,5),
                at(31,3),
                at(31,4),
                at(31,5),
                at(35,3),
                at(35,4),
                at(36,3),
                at(36,4)
        );
        return game;
    }
}
