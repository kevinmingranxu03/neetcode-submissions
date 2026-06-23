class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean rows = true;
        boolean cols = true;
        boolean grids = true;
        for (int i = 0; i < board[0].length; i++) {
            rows = rows && checkRows(board, i);
            cols = cols && checkCols(board, i);
        }
        for (int i = 0; i < board[0].length; i+=3) {
            for (int j = 0; j < board.length; j+=3) {
                grids = grids && checkGrids(board, i, j);
            }
        }
        return grids && rows && cols;
    }

    private boolean checkRows(char[][] board, int i) {
        Set<Character> set = new HashSet<>();
        for (int j = 0; j < board[i].length; j++) {
            if (Character.isDigit(board[i][j]) && set.contains(board[i][j])) {
                return false;
            }
            set.add(board[i][j]);
        }
        return true;
    }

    private boolean checkCols(char[][] board, int i) {
        Set<Character> set = new HashSet<>();
        for (int j = 0; j < board.length; j++) {
            if (Character.isDigit(board[j][i]) && set.contains(board[j][i])) {
                return false;
            }
            set.add(board[j][i]);
        }
        return true;
    }

    private boolean checkGrids(char[][] board, int i, int j) {
        Set<Character> set = new HashSet<>();
        for (int r = i; r < i + 3; r++) {
            for (int c = j; c < j + 3; c++) {
                if (set.contains(board[r][c]) && Character.isDigit(board[r][c])) {
                    return false;
                }
                set.add(board[r][c]);
            }
        }
        return true;
    }
}
