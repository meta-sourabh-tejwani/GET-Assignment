class QueenProblem {

	public boolean nQueen(int board[][], int row, int dimension) {
		if (solveQueen(board, 0, dimension) == false) {
			return false;
		}
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println(" ");
		}
		return true;
	}

	public boolean solveQueen(int board[][], int column, int n) {
		if (column >= n) {
			return true;
		}
		for (int i = 0; i < n; i++) {
			if (safe(board, i, column, n) == true) {
				board[i][column] = 1;
				if (solveQueen(board, column + 1, n) == true) {
					return true;
				}
				board[i][column] = 0;
			}
		}
		return false;
	}

	public boolean safe(int board[][], int row, int column, int n) {
		for (int i = 0; i < column; i++) {
			if (board[row][i] == 1) {
				return false;
			}
		}
		int i, j = column;
		for (i = row; i >= 0 && j >= 0; i--) {
			if (board[i][j--] == 1) {
				return false;
			}
		}
		j = column;
		for (i = row; i < n && j >= 0; i++) {
			if (board[i][j--] == 1) {
				return false;
			}
		}

		return true;
	}
}
