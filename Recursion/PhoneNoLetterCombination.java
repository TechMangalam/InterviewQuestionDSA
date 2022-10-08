package backtracking.hashTable;

import java.util.List;

public class PhoneNoLetterCombination {

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new java.util.ArrayList<>();
        }
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new java.util.ArrayList<>();
        backtrack(result, digits, "", 0, mapping);
        return result;
    }

    private void backtrack(List<String> result, String digits, String combination, int index, String[] mapping) {
        if (index == digits.length()) {
            result.add(combination);
        } else {
            String letters = mapping[digits.charAt(index) - '0'];
            for (int i = 0; i < letters.length(); i++) {
                backtrack(result, digits, combination + letters.charAt(i), index + 1, mapping);
            }
        }
    }
    public static void main(String[] args) {
        PhoneNoLetterCombination p = new PhoneNoLetterCombination();
        System.out.println(p.letterCombinations("23"));
    }


}
