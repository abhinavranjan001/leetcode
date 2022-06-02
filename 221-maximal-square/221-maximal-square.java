class Solution {
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        
        int[][] m = new int[matrix.length][matrix[0].length];
          for(int i=0; i<matrix.length; i++)
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] == 49) max = 1;
                m[i][j] = matrix[i][j]-48;
            }

        
        for(int i=1; i<m.length; i++){
            for(int j=1; j<m[0].length; j++){
                if(m[i][j] == 1){
                    m[i][j] = 1 + Math.min(m[i-1][j], Math.min(m[i][j-1], m[i-1][j-1]));
                    max = Math.max(max, m[i][j]);
                }
            }
        }
        
        return max*max;
    }
}