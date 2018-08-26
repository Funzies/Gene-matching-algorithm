/***
 * Jack Huang
 * Comp361 Assignment 2
 *
 * Implementation of the gene matching algorithm
 */

public class GeneMatching {
    final int GAPCOST = -2;
    final int MISMATCH = -1;
    final int MATCH = 1;

    public void align(String x, String y){
        int[][] table = new int[x.length()][y.length()];
        for (int i = 0; i < x.length(); i++ ){
            table[i][0] = GAPCOST * i;
        }
        for (int i = 0; i < y.length(); i++ ){
            table[0][i] = GAPCOST * i;
        }
        for (int i = 1; i < x.length(); i++){
            for (int j = 1; j < y.length(); j++){
                table[i][j] = findMax(table, x, y, i, j);
            }
        }
    }

    public int findMax(int[][] table, String x, String y, int i, int j){
        int n =  Math.max(getValue(x.charAt(i-1), y.charAt(j-1)) + table[i-1][j-1],
                GAPCOST + table[i-1][j] );

        return Math.max(n, GAPCOST + table[i][j-1]);
    }


    public int getValue(Character x, Character y){
        if (x.equals(y)){
            return MATCH;
        }
        else {
            return MISMATCH;
        }
    }


    public static void main(String[] args){
        GeneMatching gm = new GeneMatching();
        StringGenerator sg = new StringGenerator();
        gm.align(" mean", " name");
    }
}
