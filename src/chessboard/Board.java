package chessboard;

import javax.swing.JOptionPane;

public class Board {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int SIZEBOARD = 8;
		final int horsePosition[] = {4, 3};
		int board[][] = new int[SIZEBOARD][SIZEBOARD];
		int moveHorsePosition[] = entryPosition();
		
		
		System.out.println(validateMoveHorse(horsePosition, moveHorsePosition[0], moveHorsePosition[1]));
		
	}

	/**
	 * Funcion que permite ingresar la posicion a la que se desea mover el caballo
	 * 
	 * @return arreglo con la posicion de la fila y la columna
	 */
	public static int[] entryPosition() {
		int positionHorse[] = new int[2];
		int row, column;
		row = Integer.parseInt(JOptionPane.showInputDialog("Por favor ingresar la posición de la fila"));
		column = Integer.parseInt(JOptionPane.showInputDialog("Por favor ingresar la posición de la columna"));

		if ((row <= 7 && row >= 0) && (column <= 7 && column >= 0)) {
			positionHorse[0] = row;
			positionHorse[1] = column;
			JOptionPane.showMessageDialog(null,
					"La posición ingresada es: (" + positionHorse[0] + ", " + positionHorse[1] + ")");
			return positionHorse;
		} else {
			JOptionPane.showMessageDialog(null, "La posición ingresada no es válida");
			return positionHorse;
		}
	}

	public static boolean validateMoveHorse(int horsePosition[], int row, int column) {
		
		System.out.println("Posicion inicial caballo:(" + horsePosition[0] + "," + horsePosition[1]+")");
		
		if ((horsePosition[0] + 1 <= 7 && horsePosition[0] + 1 >= 0)
				|| (horsePosition[0] - 1 <= 7 && horsePosition[0] - 1 >= 0)) {
			if (horsePosition[0] + 1 == row || horsePosition[0] - 1 == row) {
				if ((horsePosition[1] + 2 == column && (horsePosition[1] + 2 <= 7 && horsePosition[1] + 2 >= 0))
						|| (horsePosition[1] - 2 == column
								&& (horsePosition[1] + 2 <= 7 && horsePosition[1] + 2 >= 0))) {
					//Retorna Verdadero
					JOptionPane.showMessageDialog(null, "El movimiento ("+ row + "," + column + ") es válido");
					return true;
				}
			}
		}
		
		if ((horsePosition[0] + 2 <= 7 && horsePosition[0] + 2 >= 0)
				|| (horsePosition[0] - 2 <= 7 && horsePosition[0] - 2 >= 0)) {
			if (horsePosition[0] + 2 == row || horsePosition[0] - 2 == row) {
				if ((horsePosition[1] + 1 == column && (horsePosition[1] + 1 <= 7 && horsePosition[1] + 1 >= 0))
						|| (horsePosition[1] - 1 == column
								&& (horsePosition[1] + 1 <= 7 && horsePosition[1] + 1 >= 0))) {
					//Retorna Verdadero
					JOptionPane.showMessageDialog(null, "El movimiento es válido");
					return true;
				}
			}
		}
		
		JOptionPane.showMessageDialog(null, "El movimiento NO es válido");
		return false;
		
	}
}
