package Combinator1;

import config.Config;

import java.util.HashSet;
import java.util.Set;

public class CombinatorModel {
    protected int[][] matrix;
    protected Set<Integer> set = new HashSet<Integer>();


    CombinatorModel(){
        matrix = new int[4][Config.vectorLen];
    }

    void setMatrix(int[][] matrix){
        this.matrix = matrix;
    }
    void addSet(int i){
        set.add(i);
    }

    int[][] getMatrix(){
        return matrix;
    }

    Integer[] getMergedArray(){
        return set.toArray(new Integer[set.size()]);
    }



}
