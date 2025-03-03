package Algorithms.Lesson3;

import java.io.*;
import java.util.Stack;

public class PostfixNotation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = reader.readLine();
        int result = Postfix(line);

        writer.write(String.valueOf(result));
        writer.newLine();
        writer.flush();

        reader.close();
        writer.close();
    }
    public static int Postfix(String expression) {
        Stack<Integer> stack = new Stack<>();
        String[] tokens = expression.trim().split("\\s+");
        for (String token : tokens) {
            if (token.matches("-?\\d+")) {
                stack.push(Integer.parseInt(token));
            } else if (token.equals("+") || token.equals("-") || token.equals("*")) {
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Неверный постфикс");
                }
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = 0;
                switch (token) {
                    case "+":
                        result = operand1 + operand2;
                        break;
                    case "-":
                        result = operand1 - operand2;
                        break;
                    case "*":
                        result = operand1 * operand2;
                        break;
                }
                stack.push(result);
            } else if (!token.isEmpty()){
                throw new IllegalArgumentException("Неверный знак ");
            }
        }
        if (stack.size() != 1) {
            throw new IllegalArgumentException("Неверный постфикс");
        }
        return stack.pop();
    }
}


