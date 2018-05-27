import java.util.ArrayList;
import java.util.LinkedList;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        ArrayList<Integer> stack = new ArrayList<>();
        for (String token : tokens) {

            int n1, n2;
            switch (token) {
                case "+":
                    n1 = pop(stack);
                    n2 = pop(stack);
                    push(stack, n1+n2);
                    break;
                case "-":
                    n1 = pop(stack);
                    n2 = pop(stack);
                    push(stack, n2-n1);
                    break;
                case "*":
                    n1 = pop(stack);
                    n2 = pop(stack);
                    push(stack, n1*n2);
                    break;
                case "/":
                    n1 = pop(stack);
                    n2 = pop(stack);
                    push(stack, n2/n1);
                    break;
                default:
                    stack.add(Integer.valueOf(token));
                    break;

            }

        }
        return stack.get(0);
    }

    private int pop(ArrayList<Integer> stack) {
        return stack.remove(stack.size()-1);
    }

    private void push(ArrayList<Integer> stack, int num) {
        stack.add(num);
    }

    //还可以通过递归方法实现


    public static void main(String[] args) {
    }
}
