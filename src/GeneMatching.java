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

    String xAligned;
    String yAligned;

    public void align(String x, String y){
        int[][] table = new int[x.length()+1][y.length()+1];
        for (int i = 0; i < x.length()+1; i++ ){
            table[i][0] = GAPCOST * i;
        }
        for (int i = 0; i < y.length()+1; i++ ){
            table[0][i] = GAPCOST * i;
        }
        for (int i = 1; i < table.length; i++){
            for (int j = 1; j < table[0].length; j++){
                table[i][j] = findMax(table, x, y, i, j);
            }
        }
        //printTable(table);
        findAlignment(table, x, y);
        System.out.println(xAligned);
        System.out.println(yAligned);
    }

    /**
     * Takes in the filled table and creates the aligned strings
     */
    public void findAlignment(int[][] table, String x, String y){
        int i = table.length-1;
        int j = table[0].length-1;
        String from;
        StringBuilder newX = new StringBuilder();
        StringBuilder newY = new StringBuilder();
        while (i != 0 && j != 0){
            if (i > 0 && j > 0) {
                if (table[i - 1][j] > table[i][j - 1]) {
                    if (table[i - 1][j] > table[i - 1][j - 1]) {
                        from = "down";
                        newX.insert(0, x.charAt(i-1));
                        newY.insert(0, ' ');
                        i--;
                    } else {
                        from = "diagonal";
                        newX.insert(0, x.charAt(i-1));
                        newY.insert(0, y.charAt(j-1));
                        i--;
                        j--;
                    }
                }
                else if (table[i][j - 1] > table[i - 1][j - 1]) {
                        from = "left";
                        newX.insert(0, ' ');
                        newY.insert(0, y.charAt(j-1));
                        j--;
                }
                else {
                    from = "diagonal";
                    newX.insert(0, x.charAt(i - 1));
                    newY.insert(0, y.charAt(j - 1));
                    i--;
                    j--;
                }
            }
            else if (j == 0){ //path had to have gone upwards therefore, we move down
                from = "down";
                newX.insert(0,x.charAt(i-1));
                newY.insert(0,' ');
                i--;
            }
            else if (j == 0) { //path had to have gone rightwards therefore, we move left
                from = "left";
                newX.insert(0,' ');
                newY.insert(0,y.charAt(j-1));
                j--;
            }
        }
        xAligned = newX.toString();
        yAligned = newY.toString();
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

    public void printTable(int[][] table){
        for (int i = 0; i < table.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < table[0].length; j++) {
                sb.append(" "+Integer.toString(table[i][j])+" ");
            }
            System.out.println(sb.toString() + '\n');
        }
    }


    public static void main(String[] args){
        GeneMatching gm = new GeneMatching();
        StringGenerator sg = new StringGenerator();
        gm.align(sg.randomStr(10, 15), sg.randomStr(10, 15));
    }
}
