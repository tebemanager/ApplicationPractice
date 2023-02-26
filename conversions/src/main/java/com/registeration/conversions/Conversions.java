package com.registeration.conversions;

import java.util.ArrayList;

public class Conversions {


    public static void main(String[] args){

        Conversions conversions = new Conversions();
        conversions.loopIng();
    }

    public void loopIng(){
        int[] levelOne = new int[]{3,4,5,6,7,2,3,4,5,6,7};
        ArrayList<Integer> original = new ArrayList();
        ArrayList<Integer> duplicate = new ArrayList();
        for (int i=levelOne.length-1;i>=0;i--){
            if (original.contains(levelOne[i])){
                if (!duplicate.contains(levelOne[i])) duplicate.add(levelOne[i]);
            }else {
                original.add(levelOne[i]);
            }
        }
        System.out.println(duplicate.toString());
    }
}