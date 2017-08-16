package Robots;

/* Autor: Paulo Vieira*/

import Common.Coordinate;
import Common.Direction;

public class Rover {

    private Coordinate coordinate; //coordenadas
    private Direction direction; // direção
    private Coordinate maxCoordinate; // coordenadas maxima
    private String errorDirection = "Rover Direction is null!";

    //Construtor1 (coordenadas + direção)
    public Rover(int x, int y, Direction direction) {
        this.coordinate = new Coordinate(x, y);
        this.direction = direction;
    }

    //Construtor2 (construtor1 + maxcoordenadas)
    public Rover(int x, int y, Direction direction, Coordinate maxCoordinate) {
        this(x, y, direction);
        this.maxCoordinate = maxCoordinate;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public Direction getDirection() {
        return direction;
    }

    //Metodo MOVE + exceções
    public void move() {
        String errorLimit = "Illegal instruction! The rover can't move because exceeded the limit!";

        if (this.direction == Direction.EAST) {
            if ((this.maxCoordinate != null) && (this.coordinate.x >= this.maxCoordinate.x))
                throw new IllegalArgumentException(errorLimit);
            this.coordinate.x += 1;

        } else if (this.direction == Direction.WEST) {
            if ((this.maxCoordinate != null) && (this.coordinate.x <= 1))
                throw new IllegalArgumentException(errorLimit);
            this.coordinate.x -= 1;

        } else if (this.direction == Direction.NORTH) {
            if ((this.maxCoordinate != null) && (this.coordinate.y >= this.maxCoordinate.y))
                throw new IllegalArgumentException(errorLimit);
            this.coordinate.y += 1;

        } else if (this.direction == Direction.SOUTH) {
            if ((this.maxCoordinate != null) && (this.coordinate.y <= 1))
                throw new IllegalArgumentException(errorLimit);
            this.coordinate.y -= 1;

        } else {
            throw new NullPointerException(errorDirection);
        }
    }

    //metodo virar1
    public void turnLeft() {
        if (this.direction == Direction.EAST) {
            this.direction = Direction.NORTH;

        } else if (this.direction == Direction.WEST) {
            this.direction = Direction.SOUTH;

        } else if (this.direction == Direction.NORTH) {
            this.direction = Direction.WEST;

        } else if (this.direction == Direction.SOUTH) {
            this.direction = Direction.EAST;

        } else {
            throw new NullPointerException(errorDirection);
        }
    }

    //metodo virar2
    public void turnRight() {
        if (this.direction == Direction.EAST) {
            this.direction = Direction.SOUTH;

        } else if (this.direction == Direction.WEST) {
            this.direction = Direction.NORTH;

        } else if (this.direction == Direction.NORTH) {
            this.direction = Direction.EAST;

        } else if (this.direction == Direction.SOUTH) {
            this.direction = Direction.WEST;

        } else {
            throw new NullPointerException(errorDirection);
        }
    }

    //to string com parametros + string fixas
    public String toString() {
        return this.direction.toString() + " " + this.coordinate.x + " " + this.coordinate.y;
    }

}
