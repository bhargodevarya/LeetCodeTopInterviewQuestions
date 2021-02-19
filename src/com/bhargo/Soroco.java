package com.bhargo;

import java.util.*;

public class Soroco {

    public static void main(String[] args) {

        boolean similar;
        List<List<String>> matrix = new ArrayList<>();
        matrix.add(Arrays.asList("amazing", "fine"));
        matrix.add(Arrays.asList("fine", "good"));
        matrix.add(Arrays.asList("acting", "theatrics"));
        matrix.add(Arrays.asList("abilities", "talent"));
        similar = isSimilar(Arrays.asList("amazing", "acting", "abilities"), Arrays.asList("fine", "theatrics", "talent"), matrix);

        /*List<List<String>> matrix = new ArrayList<>();
        matrix.add(Arrays.asList("little", "small"));
        matrix.add(Arrays.asList("engine", "rail"));
        matrix.add(Arrays.asList("miniscule", "small"));
        matrix.add(Arrays.asList("miniscule", "t"));
        matrix.add(Arrays.asList("railway", "rail"));
        matrix.add(Arrays.asList("that", "which"));
        matrix.add(Arrays.asList("can", "could"));
        similar = isSimilar(Arrays.asList("little", "engine", "that", "can"), Arrays.asList("tiny", "railway", "which", "could"), matrix);*/
        System.out.println(similar);
    }

    public static boolean isSimilar(List<String> sentence_1, List<String> sentence_2, List<List<String>> similarity_matrix) {
        // Write your code here
        boolean finalResult = true;
        for (int i =0; i < sentence_1.size(); i++) {
            String wordfromSentence1 = sentence_1.get(i);
            String wordfromSentence2 = sentence_2.get(i);
            boolean result = find(null, wordfromSentence1, wordfromSentence2, 1, similarity_matrix);
            if (!result) {
                finalResult = false;
                break;
            }
        }
        return finalResult;
    }

    private static boolean doTheyMatch(String wordfromSentence1, String wordfromSentence2, List<List<String>> similarity_matrix) {
        boolean result = false, foundSynonym = false;

        Set<String> set = new HashSet<>();

        for (int i = 0; i < similarity_matrix.size(); i++) {
            List<String> strings = similarity_matrix.get(i);
            if (strings.get(0).equals(wordfromSentence1) && strings.get(1).equals(wordfromSentence2)) {
                result = true;
                break;
            }
            if (strings.get(1).equals(wordfromSentence1) && strings.get(0).equals(wordfromSentence2)) {
                result = true;
                break;
            }

        }
        if (result)
            return true;

        for (int i = 0; i < similarity_matrix.size(); i++) {
            if (similarity_matrix.get(i).contains(wordfromSentence1)) {
                set.add(similarity_matrix.get(i).get(0).equals(wordfromSentence1) ? similarity_matrix.get(i).get(1) : similarity_matrix.get(i).get(0));
            }
            if (similarity_matrix.get(i).contains(wordfromSentence2)&& !wordfromSentence1.equals(wordfromSentence2)) {
                if (!set.add(similarity_matrix.get(i).get(0).equals(wordfromSentence1) ? similarity_matrix.get(i).get(1) : similarity_matrix.get(i).get(0))) {
                    foundSynonym = true;
                    break;
                }
            }
        }

        if (foundSynonym){
            return true;
        }

        return false;
    }

    private static boolean find(String parent, String wordfromSentence1, String wordfromSentence2, int val, List<List<String>> similarity_matrix) {
        if (val == similarity_matrix.size()-1)
            return false;

        List<String> selected = null;
        for (List<String> list: similarity_matrix) {
            if (list.contains(wordfromSentence1) && !list.contains(parent)) {
                selected = list;
                break;
            }
        }

        if (selected != null) {
            for (int i =0; i <selected.size(); i++) {
                if (!selected.get(i).equals(wordfromSentence1) && selected.get(i).equals(wordfromSentence2)) {
                    return true;
                } else if (!selected.get(i).equals(wordfromSentence1)){
                    return find(wordfromSentence1, selected.get(i), wordfromSentence2, val+1, similarity_matrix);
                }
            }
        }
        return false;
    }

}
