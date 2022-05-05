package chessboard;

import javax.swing.JOptionPane;

/**
 * Clase que ejecuta un tablero de ajedrez y simula el movimiento de un caballo
 * 
 * @author JHONNY SIERRA PARRA
 * @version 2.0 Mayo 2022
 */
public class Board {

	public static void main(String[] args) {
		// Se indica el tamaño del tablero
		final int SIZEBOARD = 8;
		// Se crea un array que indica la posicion inicial del caballo
		final int horsePosition[] = { 0, 0 };
		// Se crea un arreglo que representa un tablero de ajedrez 8x8
		int board[][] = new int[SIZEBOARD][SIZEBOARD];
		// Se crea un arreglo con las coordenadas que indican la posicion en la que se quiere mover el caballo
		int moveHorsePosition[] = entryPosition();
		

		System.out.println(validateMoveHorse(horsePosition, moveHorsePosition[0], moveHorsePosition[1]));
	}

	/**
	 * Metodo que permite ingresar la posicion a la que se desea mover el caballo
	 * 
	 * @return arreglo con la posicion de la fila y la columna
	 */
	public static int[] entryPosition() {
		// Arreglo que almacenará la posicion del caballo (fila, columna)
		int positionHorse[] = new int[2];
		int row, column;
		
		JOptionPane.showMessageDialog(
				null, 
				"A continuación ingrese los datos de la posición a la que quiere mover el caballo", 
				"Información", 
				JOptionPane.WARNING_MESSAGE);
		
		
		// Se captura la posicion inicial (fila, columna)de la ficha en el tablero
		row = Integer.parseInt(JOptionPane.showInputDialog("Por favor ingresar la posición de la fila"));
		column = Integer.parseInt(JOptionPane.showInputDialog("Por favor ingresar la posición de la columna"));

		/*
		 * Se valida si el numero ingresado de fila y columna cumplen con la condicion
		 * de estar dentro del tablero
		 */
		if ((row <= 7 && row >= 0) && (column <= 7 && column >= 0)) {
			// Se asigna el valor de la variable row a la primer posicion del array
			positionHorse[0] = row;
			// Se asigna el valor de la variable column a la segunda posicion del array
			positionHorse[1] = column;
			JOptionPane.showMessageDialog(null,
					"La posición ingresada es: (" + positionHorse[0] + ", " + positionHorse[1] + ")");
			return positionHorse;
		} else {
			JOptionPane.showMessageDialog(null, "La posición ingresada no es válida");
			return positionHorse;
		}
	}

	/**
	 * Metodo que permite validar si el movimiento de un caballo es valido. Se tomo en cuenta
	 * que el caballo se puede mover una casilla en la fila y dos en columna o se puede mover
	 * dos casillas en fila y una en columna.
	 * 
	 * @param horsePosition Posicion inicial del caballo
	 * @param row           Posicion nueva de la fila
	 * @param column        Posicion nueva de la columna
	 * @return Verdadero si la nueva posicion es valida. Falso en caso contrario
	 */
	public static boolean validateMoveHorse(int horsePosition[], int row, int column) {
		/*
		 *  Se imprime la posicion actual del caballo. Esta se ingresa por defecto en 0,0
		 *  Si se desea cambiar la posicion incial debe indicarlo modificando
		 *  el arreglo horsePosition[]  
		 */
		System.out.println("Posición inicial caballo:(" + horsePosition[0] + "," + horsePosition[1] + ")");
		System.out.println("Posición movimiento caballo:(" + row + "," + column + ")");

		/*
		 * Este condicional valida el movimiento del caballo cuando se mueve una sola casilla
		 * en la fila
		 * 
		 * En el primer if se valida que si a la posicion actual del caballo se le suma
		 * un movimiento en la fila a la izquierda o a la derecha este no se salga de la
		 * dimension del tablero	
		 */
		if ((horsePosition[0] + 1 <= 7 && horsePosition[0] + 1 >= 0)
				|| (horsePosition[0] - 1 <= 7 && horsePosition[0] - 1 >= 0)) {
			/*
			 *  Se valida si el valor que trae la fila es igual a moverse una casilla en fila
			 *  a la izquierda o a la derecha. Si es asi se procede a validar que se haya movido
			 *  2 casillas en columna.
			 */
			if (horsePosition[0] + 1 == row || horsePosition[0] - 1 == row) {
				/*
				 *  Se valida que el movimiento en columna sea igual a 2 y que esta nueva posicion
				 *  se encuentre dentro de la dimension del tablero. 
				 */
				if ((horsePosition[1] + 2 == column && (horsePosition[1] + 2 <= 7 && horsePosition[1] + 2 >= 0))
						|| (horsePosition[1] - 2 == column
								&& (horsePosition[1] + 2 <= 7 && horsePosition[1] + 2 >= 0))) {
					// Retorna Verdadero indicando que le movimiento es valido.
					JOptionPane.showMessageDialog(null, "El movimiento (" + row + "," + column + ") es válido");
					return true;
				}
			}
		}

		/*
		 * Este condicional valida el movimiento del caballo cuando se mueve dos casillas
		 * en la fila
		 * 
		 * En el primer if se valida que si a la posicion actual del caballo se le suman
		 * 2 movimiento en la fila a la izquierda o a la derecha este no se salga de la
		 * dimension del tablero	
		 */
		if ((horsePosition[0] + 2 <= 7 && horsePosition[0] + 2 >= 0)
				|| (horsePosition[0] - 2 <= 7 && horsePosition[0] - 2 >= 0)) {
			/*
			 *  Se valida si el valor que trae la fila es igual a moverse dos casillas en fila
			 *  a la izquierda o a la derecha. Si es asi se procede a validar que se haya movido
			 *  1 casilla en la columna.
			 */
			if (horsePosition[0] + 2 == row || horsePosition[0] - 2 == row) {
				/*
				 *  Se valida que el valor en columna sea igual a 1 y que esta nueva posicion
				 *  se encuentre dentro de la dimension del tablero. 
				 */
				if ((horsePosition[1] + 1 == column && (horsePosition[1] + 1 <= 7 && horsePosition[1] + 1 >= 0))
						|| (horsePosition[1] - 1 == column
								&& (horsePosition[1] + 1 <= 7 && horsePosition[1] + 1 >= 0))) {
					// Retorna Verdadero indicando que le movimiento es valido.
					JOptionPane.showMessageDialog(null, "El movimiento es válido");
					return true;
				}
			}
		}
		
		// Si ninguna de las dos condiciones se cumple se retorna Falso indicando que el movimiento no es valido
		JOptionPane.showMessageDialog(null, "El movimiento NO es válido");
		return false;
	}
}
