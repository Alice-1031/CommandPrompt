/**
 * This class interprets the DishIt-math commands input by user on the stack
 * 
 * @author Shreya_Jaiswal
 */
public class InterpreterMath extends Interpreter {
    /**
     * * Method to evaluate user inputs. * @param string statement input by user.
     * * @return boolean true for valid commands and false for invalid commands
     */
    public boolean eval(String statement) {

        if (statement.equals("OP_ADD")) {
            if (theStack.size() >= 2) {
                int one = Integer.parseInt(theStack.pop());
                int two = Integer.parseInt(theStack.pop());

                int sum = one + two;
                theStack.push("" + sum);
                System.out.println("adding...");
                return true;
            } else {
                System.out.println("Error:stack has less than two values");
                return false;
            }
        }

        if (statement.equals("OP_MULT")) {
            if (theStack.size() >= 2) {
                int one = Integer.parseInt(theStack.pop());
                int two = Integer.parseInt(theStack.pop());
                int product = one * two;
                theStack.push("" + product);
                System.out.println("multiplying...");
                return true;

            } else {
                System.out.println("Error:stack has less than two values");
                return false;
            }
        }

        if (statement.equals("OP_SUB")) {
            if (theStack.size() >= 2) {
                int one = Integer.parseInt(theStack.pop());
                int two = Integer.parseInt(theStack.pop());
                int difference = one - two;
                theStack.push("" + difference);
                System.out.println("subtracting...");
                return true;

            } else {
                System.out.println("Error:stack has less than two values");
                return false;
            }
        }

        if (statement.equals("OP_DIV")) {
            if (theStack.size() >= 2) {
                int one = Integer.parseInt(theStack.pop());
                int two = Integer.parseInt(theStack.pop());
                int quotient = Math.floorDiv(one, two);
                theStack.push("" + quotient);
                System.out.println("dividing...");
                return true;

            } else {
                System.out.println("Error:stack has less than two values");
                return false;
            }

        }

        return super.eval(statement);

    }
}
