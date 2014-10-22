package gameOfLife;

/**
 * Created by fbarbedette on 10/22/14.
 */
public class GameGrid {

    public static GameLivingCell at(int x, int y) {
        return new GameLivingCell(x, y);
    }

}
