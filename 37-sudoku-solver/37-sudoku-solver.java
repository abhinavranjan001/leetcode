class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    public boolean solve(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.'){
                    for(char c = '1'; c <= '9'; c++){
                        if(isValid(board, i, j, c)){
                            board[i][j] = c;

                            if(solve(board))
                                return true;
                            else
                                board[i][j] = '.';
                        }
                    }

                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValid(char[][] board, int i, int j, char ch) {
        for (int k = 0; k < 9; k++) if (board[i][k] == ch) return false;
        for (int k = 0; k < 9; k++) if (board[k][j] == ch) return false;

        int smi = i / 3 * 3;
        int smj = j / 3 * 3;
        for (int I = 0; I < 3; I++) {
            for (int J = 0; J < 3; J++) if (board[I + smi][J + smj] == ch) return false;
        }

        return true;
    }

}