package gameOfLife;

/**
 * Created by fbarbedette on 10/22/14.
 */
public class GameLivingCell {

    private int positionX;
    private int positionY;

    public GameLivingCell(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GameLivingCell)) return false;

        GameLivingCell that = (GameLivingCell) o;

        if (positionX != that.positionX) return false;
        if (positionY != that.positionY) return false;

        return true;
    }

    @Override
    public String toString() {
        return "("+ positionX +
                "," + positionY +
                ')';
    }

    @Override
    public int hashCode() {
        int result = positionX;
        result = 31 * result + positionY;
        return result;
    }
}
