class Solution {
    public boolean isValidSudoku(char[][] board) {
        /*. My Tougths 
          1. just we need to check for if duplicate present in a every Row , Cloumn , Square
        
        */


        //rows
        for(int i=0; i<9; i++){
            Set<Character> set  =  new HashSet<>();
            for(int j=0; j<9; j++){
                if(board[i][j] == '.') continue;
                if(set.contains(board[i][j])) return false;
                set.add(board[i][j]);
            }
        }

        //columns
        for(int i=0; i<9; i++){
            Set<Character> set  =  new HashSet<>();
            for(int j=0; j<9; j++){
                if(board[j][i] == '.') continue;
                if(set.contains(board[j][i])) return false;
                set.add(board[j][i]);
            }
        }

        //square:
        for (int square = 0; square < 9; square++) {
            Set<Character> seen = new HashSet<>();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int row = (square / 3) * 3 + i;
                    int col = (square % 3) * 3 + j;
                    if (board[row][col] == '.') continue;
                    if (seen.contains(board[row][col])) return false;
                    seen.add(board[row][col]);
                }
            }
        }

        return true;


    }
}
