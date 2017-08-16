package Robots;
//importar classes de direção e coordenadas
import Common.Coordinate;
import Common.Direction;

public class Rover {
	
	private Coordinate coordinate; //coordenadas
	private Direction direction; // direção
	private Coordinate maxCoordinate; // coordenadas maxima 
	//Construtor1 (coordenadas + direção)
	public Rover(int x, int y, Direction direction){
		this.coordinate = new Coordinate(x, y);
		this.direction = direction;
	}
	//Construtor2 (construtor1 + maxcoordenadas)
	public Rover(int x, int y, Direction direction, Coordinate maxCoordinate){
		this(x, y, direction);
		this.maxCoordinate = maxCoordinate;
	}
	//metodo get para coordenada
	public Coordinate getCoordinate() {
		return coordinate;
	}
	//metodo get para direção
	public Direction getDirection() {
		return direction;
	}
	
	//Metodo MOVE + exceções
	public void move(){
		if (this.direction == Direction.EAST){
			if ((this.maxCoordinate != null) && (this.coordinate.x >= this.maxCoordinate.x))
				throw new IllegalArgumentException("Illegal instruction! The rover can't move because exceeded the limit!");
			this.coordinate.x += 1;
		}else if (this.direction == Direction.WEST){
			if ((this.maxCoordinate != null) && (this.coordinate.x <= 1))
				throw new IllegalArgumentException("Illegal instruction! The rover can't move because exceeded the limit!");
			this.coordinate.x -= 1;
		}else if (this.direction == Direction.NORTH){
			if ((this.maxCoordinate != null) && (this.coordinate.y >= this.maxCoordinate.y))
				throw new IllegalArgumentException("Illegal instruction! The rover can't move because exceeded the limit!");
			this.coordinate.y += 1;
		}else if (this.direction == Direction.SOUTH){
			if ((this.maxCoordinate != null) && (this.coordinate.y <= 1))
				throw new IllegalArgumentException("Illegal instruction! The rover can't move because exceeded the limit!");
			this.coordinate.y -= 1;
		}else{
			throw new NullPointerException("Rover Direction is null!");
		}		
	}
	//metodo virar1
	public void turnLeft(){
		if (this.direction == Direction.EAST){
			this.direction = Direction.NORTH;
		}else if (this.direction == Direction.WEST){
			this.direction = Direction.SOUTH;
		}else if (this.direction == Direction.NORTH){
			this.direction = Direction.WEST;
		}else if (this.direction == Direction.SOUTH){
			this.direction = Direction.EAST;
		}else{
			throw new NullPointerException("Rover Direction is null!");
		}	
	}
	//metodo virar2
	public void turnRight(){
		if (this.direction == Direction.EAST){
			this.direction = Direction.SOUTH;
		}else if (this.direction == Direction.WEST){
			this.direction = Direction.NORTH;
		}else if (this.direction == Direction.NORTH){
			this.direction = Direction.EAST;
		}else if (this.direction == Direction.SOUTH){
			this.direction = Direction.WEST;
		}else{
			throw new NullPointerException("Rover Direction is null!");
		}	
	}
	//to string com parametros + string fixas
	public String toString() {
		return this.direction.toString() + " " + this.coordinate.x + " " + this.coordinate.y;
	}


}
