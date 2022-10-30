package br.com.letscode.bejv002.desafios.classes;

import java.util.Arrays;

public class SortedArray {

    public int compareStrings(String word1, String word2)
    {
        for(int i = 0; i < Math.min(word1.length(), word2.length()); i++)
        {
            if((int)word1.charAt(i) != (int)word2.charAt(i))//comparing unicode values
                return (int)word1.charAt(i) - (int)word2.charAt(i);
        }
        if(word1.length() != word2.length())//smaller word is occurs at the beginning of the larger word
            return word1.length() - word2.length();
        else
            return 0;
    }
    public String[] stringArraySort(String[] words)
    {
        for(int i = 0; i < words.length - 1; i++)
        {
            for(int j = i+1; j < words.length; j++)
            {
                if(compareStrings(words[i], words[j]) > 0)//words[i] is greater than words[j]
                {
                    String temp = words[i];
                    words[i] = words[j];
                    words[j] = temp;
                }
            }
        }
        return words;
    }

    public String[] putAlphabeticOrder(String[] arrToSort){
        String[] vector = new String[arrToSort.length];
        char[] ch;
        for(int i = 0; i < arrToSort.length; i++)
        {
            String str = arrToSort[i];
            ch = new char[str.length()];
            for (int j = 0; j < str.length(); j++) {
                ch[j] = str.charAt(j);
            }
            Arrays.sort(ch);

            for (int k = 0; k < ch.length; ++k) {
                if (vector[i] == null){
                    vector[i] = String.valueOf(ch[k]);
                }else {
                    vector[i] += ch[k];
                }
            }
        }

        return vector;
    }

    public void print(String[] sortedArr){
        System.out.println("========== RESULT SORTED ARRAY ========== ");
        System.out.println("");
        System.out.println("==> inline");
        for(int i = 0; i < sortedArr.length; i++) {
            if (i == (sortedArr.length - 1)) {
                System.out.print(sortedArr[i] + "");
            } else {
                System.out.print(sortedArr[i] + ", ");
            }
        }

        System.out.println("\n");
        System.out.println("==> block");
        for(int i = 0; i < sortedArr.length; i++) {
            if (i == (sortedArr.length - 1)) {
                System.out.print(sortedArr[i] + "");
            } else {
                System.out.print(sortedArr[i] + ", \n");
            }
        }
    }

    public String substring(String[] input) {
        String longestSequence = "";
        String sequence = "";
        for (String s : input) {
            for (int i = 0; i < s.length(); i++) {
                sequence = extracted(s.charAt(i), s.substring(i+1));
                if (sequence.length() > longestSequence.length()) {
                    longestSequence = sequence;
                }
            }
        }
        return longestSequence;
    }

    private String extracted(char c, String s) {
        if (s.isEmpty() || c > s.charAt(0)) {
            return c+"";
        }
        return c + extracted(s.charAt(0), s.substring(1));
    }
}
