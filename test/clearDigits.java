package test;

import java.util.Stack;

class solution {
    public static String clearDigits(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            final Character c1 = Character.isDigit(c) ? stack.pop() : stack.push(c);
        }
        StringBuilder stringBuilder = new StringBuilder();
        if(stack.isEmpty()) return "";
        Object[] ca = stack.toArray();
        for (Object o : ca) {
            stringBuilder.append(o);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {

        System.out.println(clearDigits("ccb32"));
    }
}