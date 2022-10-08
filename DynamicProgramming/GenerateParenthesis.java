package DyanamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) return result;
        StringBuilder sb = new StringBuilder();
        generateParenthesis(n, n, sb, result);
        return result;
    }

    private void generateParenthesis(int left, int right, StringBuilder sb, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(sb.toString());
            return;
        }
        if (left > 0) {
            sb.append('(');
            generateParenthesis(left - 1, right, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right > left) {
            sb.append(')');
            generateParenthesis(left, right - 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        GenerateParenthesis gp = new GenerateParenthesis();
        System.out.println(gp.generateParenthesis(3));
    }

}
