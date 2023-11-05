public class NQueens {
    private int[] queens;
    private int N;
 
    public NQueens(int N) {
        queens = new int[N];
        this.N = N;
    }
 
    public void placeNQueens() {
        if (placeQueen(0)) {
            printQueens();
        } else {
            System.out.println("No solution found");
        }
    }
 
    private boolean placeQueen(int col) {
        if (col == N) {
            return true; // All queens are placed successfully
        }
 
        for (int row = 0; row < N; row++) {
            if (canPlace(row, col)) {
                queens[col] = row; // Place queen
                if (placeQueen(col + 1)) { // Recurse; move to next column
                    return true; // Found a valid placement
                }
                // If no valid placement found, unplace current queen and backtrack
            }
        }
 
        return false; // No valid placement found for current column
    }
 
    private boolean canPlace(int row, int col) {
        for (int i = 0; i < col; i++) {
            if (queens[i] == row || Math.abs(queens[i] - row) == Math.abs(i - col)) {
                return false; // Queen cannot be placed here
            }
        }
        return true; // It is safe to place the queen here
    }
 
    private void printQueens() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (queens[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }
 
    public static void main(String[] args) {
        NQueens nQueens = new NQueens(8);
        nQueens.placeNQueens();
    }
}