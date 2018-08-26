/***
 * Jack Huang
 * Comp361 Assignment 2
 *
 * Class for creating random strings of specified lengths
 */


import java.util.Random;
public class StringGenerator {

    public String randomStr(int size){
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<size; i++){
            sb.append(randGene());
        }
        return sb.toString();
    }

    private char randGene(){
        Random rand = new Random();
        int  n = rand.nextInt(4) + 1;

        if (n == 1){
            return 'A';
        }
        if (n == 2){
            return 'C';
        }
        if (n == 3){
            return 'G';
        }
        return 'T';
    }
}
