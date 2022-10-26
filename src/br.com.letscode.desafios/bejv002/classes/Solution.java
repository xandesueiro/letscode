package br.com.letscode.desafios.bejv002.classes;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args)
    {
        SortedArray sortedArray = new SortedArray();

        createMainStatement();

        String[] vector = {"acbda", "fasdlkh", "poiwqd", "zxcqwtop", "qfgophl"};
        String[] arrToSort = sortedArray.putAlphabeticOrder(vector);

        String[] sortedArr = sortedArray.stringArraySort(arrToSort);
        sortedArray.print(sortedArr);

    }

    public static void createMainStatement(){
        StringBuilder sb = new StringBuilder();

        sb.append("\n========== ENUNCIADO ==========");
        sb.append("\n\n");
        sb.append("Dada uma lista de Strings, determine qual a maior sequência de letras em ordem alfabética crescente.");
        sb.append("\n");
        sb.append("Entrada: \n");
        sb.append("acbda, fasdlkh, poiwqd, zxcqwtop, qfgophl \n");

        System.out.println(sb.toString());
    }
}
