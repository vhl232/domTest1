import calc.Calc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException, IOException {
        Calc c = new Calc();

        String expression = "1 + 2 - (3*2 - 7) + 7";
        c.parse(expression);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.print("Enter the expression you want to calculate or empty string if you're done: ");
            expression = reader.readLine();
            if (expression == null || expression.length() < 1) break;
            System.out.println("Your result is: " + c.parse(expression) + "\n");
        }
        System.out.println("Thank you and good bye!");
    }

        //System.out.println(" -12.254 ".matches("^\\s*-?[0-9]*\\.?[0-9]+\\s*$"));

        /*
        * double parsing: \s*-?[0-9]*\.?[0-9]+\s*
        *
        * \s* 0 or more space symbols at the beginning of the string. then
        * -? could be one - char, or could not be at all. then
        * [0-9]* 0 or more numeric symbols. then
        * \.? a dot symbol escaped with / or no dot at all. then
        * [0-9]+ one or more numeric symbols. then
        * \s* 0 or more space symbols at the end of the string.
        * */

        //System.out.println("10 + 15 - 12 / 3 * 8".replaceAll("\\s", "").matches("\\d+([-*+/]\\d+)*"));

        /*
        * operations parsing: \d+([-*+/]\d+)*
        * \d+ one or more numbers. then
        * ([-*+/]\d+)* the group of actions, that could be repeated 0 or more times:
        *   [-*+/] some symbol from a group. then
        *   \d+ one or more numbers.
        * */
}

