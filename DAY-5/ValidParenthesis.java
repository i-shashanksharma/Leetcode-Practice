import java.util.Stack;

class ValidParenthesis {
    public boolean isValid(String s) {
        Stack<Character> st1 = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st1.push(')');
            } else if (s.charAt(i) == '{') {
                st1.push('}');
            } else if (s.charAt(i) == '[') {
                st1.push(']');
            } else if (!st1.isEmpty() && (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']')) {
                if (st1.peek() == s.charAt(i)) {
                    st1.pop();
                } else return false;
            } else return false;
        }
        return st1.isEmpty();
    }

    public static void main(String[] args) {
        ValidParenthesis obj = new ValidParenthesis();
        String s1 = "()";
        String s2 = "()[]{}";
        String s3 = "(]";
        String s4 = "([)]";
        String s5 = "{[]}";
        System.out.println(obj.isValid(s1));
        System.out.println(obj.isValid(s2));
        System.out.println(obj.isValid(s3));
        System.out.println(obj.isValid(s4));
        System.out.println(obj.isValid(s5));
    }
}