package Core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import Common.Coordinate;
import Common.Direction;
import Robots.Rover;

public class Main {

	//ler e decodificar os bytes
	private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	private static Coordinate getMaxDimensionOfPlateau() throws Exception {
		System.out.print("Enter the maximum dimensions of plateau (example: X, Y): ");
		//string guardando os buffers
		String maxDimensions = bufferedReader.readLine();
		//dividir a string em letras - "espaço"
		String[] splitedString = maxDimensions.split(" ");
		//se comprimento diferente de 2
		if (splitedString.length != 2) {
			throw new Exception("Invalid Format!");
		}

		try {
			//armazenar na posição 0 para x, 1 para y
			int maxX = Integer.parseInt(splitedString[0]);
			int maxY = Integer.parseInt(splitedString[1]);
			//retornar novas coordenadas
			return new Coordinate(maxX, maxY);
		} catch (NumberFormatException e) {
			throw new Exception("Invalid Format!");
		}
	}

	public static void main(String[] args) throws IOException {
		//lista com robos - "vetor"
		ArrayList<Rover> rovers = new ArrayList<Rover>();

		try {
			Coordinate maxCoordinate = getMaxDimensionOfPlateau();

			String initialPosition = "";
			//enqanto diferente de END...
			while (!initialPosition.equals("END")) {

				try {
					//texto inicial
					System.out.println(
							"If you want close the application digit END, or enter a initial position for new rover (example: X, Y, DIRECTION).");
					System.out.println(" - The parameter DIRECTION can N, E, W or S");
					//armazenar a dimenssao 
					initialPosition = bufferedReader.readLine();

					if (initialPosition.equals("END"))
						break;

					String[] initialPositionSplited = initialPosition.split(" ");
					if (initialPositionSplited.length != 3)
						throw new IllegalArgumentException("Invalid Format, Retry!");

					try {
						int axisX = Integer.parseInt(initialPositionSplited[0]);
						int axisY = Integer.parseInt(initialPositionSplited[1]);

						if ((axisX > maxCoordinate.x) || (axisY > maxCoordinate.y))
							throw new IllegalArgumentException("Initial position invalid. Because exceeds limits!");

						String direction = initialPositionSplited[2];
						Rover rover = new Rover(axisX, axisY, Direction.fromString(direction));

						System.out
								.println("Enter series of instructions telling the rover how to explore the plateau: ");
						String instructions = bufferedReader.readLine();
						if (instructions.isEmpty())
							throw new IllegalArgumentException("Instructions is empty, retry!");

						for (int i = 0; i < instructions.length(); i++) {
							char command = instructions.charAt(i);
							switch (command) {
							case 'M':
								rover.move();
								break;
							case 'L':
								rover.turnLeft();
								break;
							case 'R':
								rover.turnRight();
								break;
							default:
								throw new IllegalArgumentException("Invalid instruction, retry!");
							}
						}
						rovers.add(rover);
						System.out.println("This rover position: " + rover.toString());

					} catch (IllegalArgumentException e) {
						System.err.println(e.getMessage() + "\nRetry!");
					}

				} catch (IllegalArgumentException e) {
					System.err.println(e.getMessage());
				}

			}

			if (rovers.size() > 0) {
				for (int i = 0; i < rovers.size(); i++) {
					System.out.println(rovers.get(i).toString());
				}
			} else {
				System.out.println("No result because don't have rovers!");
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

}
