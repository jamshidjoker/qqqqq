package uz.micro.star.lesson_3;

/**
 * Created by Sherzodbek on 26.04.2018 in Lesson3ICT4.
 */
public class Coordinate {
    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void update(Coordinate coordinate) {
        x = coordinate.x;
        y = coordinate.y;
    }
}
