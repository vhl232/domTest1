package calc;

import java.text.ParseException;

 public  class Calc {
    public double plus(double... values) {
        double result = 0;
        for (double v : values) {
            result += v;
        }
        return result;
    }

    double multiply(double... values) {
        double result = 1;
        for (double v : values) {
            result *= v;
        }
        return result;
    }

    double divide(double... values) {
        double result = 1;
        for (double v : values) {
            result /= v;
        }
        return result;
    }

    public double parse(String expression) throws ParseException {
        if (expression == null || expression.length() < 1) {
            throw new IllegalArgumentException("Expression string is empty");
        }

        if (expression.contains("(") || expression.contains(")")) {
            calculateParentheses(expression);
        }

        return calculate(expression.replaceAll("\\s", "").replaceAll(",", "."));
    }

    private double calculate(String e) throws ParseException {
        if (e.contains("(")) {
            int firsBracketIndex = e.indexOf('(');
            int lastBracketIndex = e.lastIndexOf(')') + 1;
            String beforeBrackets = e.substring(0, firsBracketIndex);
            String afterBrackets = e.substring(lastBracketIndex);

            return calculateSimpleExpression(beforeBrackets
                    + calculate(e.substring(firsBracketIndex + 1, lastBracketIndex - 1))
                    + afterBrackets);

        }

        return calculateSimpleExpression(e);

    }

    private double calculateSimpleExpression(String e) throws ParseException {
        if (e == null || e.length() < 1) throw new IllegalArgumentException("Expression string is empty");

        if (!e.matches("-?[0-9]*\\.?[0-9]+([-*+/]-?[0-9]*\\.?[0-9]+)*")) {
            throw new ParseException("Given expression is not matching mathematical pattern: " + e, 0);
        }

        String  value = findValue(e);
        double result = Double.parseDouble(value);

        while (e.length() > value.length()) {
            switch (e.charAt(value.length())) {
                case ('+'): {
                    e = e.replace(value + "+", "");
                    value = findValue(e);
                    result += Double.parseDouble(value);
                    break;
                }
                case ('-'): {
                    e = e.replace(value + "-", "");
                    value = findValue(e);
                    result -= Double.parseDouble(value);
                    break;
                }
                case ('*'): {
                    e = e.replace(value + "*", "");
                    value = findValue(e);
                    result *= Double.parseDouble(value);
                    break;
                }
                case ('/'): {
                    e = e.replace(value + "/", "");
                    value = findValue(e);
                    result /= Double.parseDouble(value);
                    break;
                }
            }
        }

        return result;
    }

    private String findValue(String s) {
        StringBuilder sb = new StringBuilder();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (c == '+' || c == '*' || c == '/') return sb.toString();
            if (c == '-' && i != 0) {
                return sb.toString();
            }
            sb.append(c);
        }
        return sb.toString();
    }

    private void calculateParentheses(String s) throws ParseException {
        int counter = 0;
        char[] charArray = s.toCharArray();
        for (int i = 0, charArrayLength = charArray.length; i < charArrayLength; i++) {
            if (charArray[i] == '(') counter++;
            if (charArray[i] == ')') {
                if (counter < 1) {
                    throw new ParseException("Closing bracket comes before opening one, " +
                            "or don't have corresponding opening bracket", i);
                }
                counter--;
            }
        }
        if (counter != 0) {
            throw new ParseException("The number of opening parentheses is not corresponding with closing ones", 0);
        }
    }
}
