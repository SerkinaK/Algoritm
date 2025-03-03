package Algorithms.Lesson3;

import java.io.*;
import java.util.Stack;

public class CorrectBracketSequence {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = reader.readLine();
        String result = CorrectBracket(s);

        writer.write(result);
        writer.newLine();
        writer.flush();

        reader.close();
        writer.close();
    }
    public static String CorrectBracket(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) {
                    return "no";
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                        (c == ']' && top != '[') ||
                        (c == '}' && top != '{')) {
                    return "no";
                }
            }
        }
        if (stack.isEmpty()) {
            return "yes";
        } else {
            return "no";
        }
    }
}


