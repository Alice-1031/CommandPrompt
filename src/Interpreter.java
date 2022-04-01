/**
 * This class interprets the DishIt commands input by user on the stack
 * 
 * @author Shreya_Jaiswal
 */
public class Interpreter {
    /** Instantiate new stack */
    protected FancyStack theStack = new FancyStack();

    /**
     * * Method to evaluate multiple statements. * @param string array of statements
     * input by user. * @return boolean true for valid commands and false for
     * invalid commands
     */
    public boolean evalMultiple(String[] statements) {
        int i;
        boolean bool;
        for (i = 0; i < statements.length; i++) {
            bool = eval(statements[i]);
            if (bool == false) {
                break;
            }
        }
        return true;
    }

    /**
     * * Method to evaluate user inputs. * @param string statement input by user.
     * * @return boolean true for valid commands and false for invalid commands
     */
    public boolean eval(String statement) {

        if (statement.equals("OP_DUP")) {
            if (theStack.isEmpty() == false) {
                String item = theStack.pop();
                theStack.push(item);
                theStack.push(item);
                System.out.println("duplicating...");
                return true;

            } else {
                System.out.println("Error:empty stack");
                return false;
            }
        }
        if (statement.equals("OP_REVERSE")) {
            if (theStack.isEmpty() == false) {
                String item = theStack.pop();
                String reverse = "";

                for (int i = item.length() - 1; i >= 0; i--) {
                    reverse = reverse + item.charAt(i);

                }

                theStack.push(reverse);
                System.out.println("reversing...");
                return true;
            } else {
                System.out.println("Error:empty stack");
                return false;
            }
        }

        if (statement.equals("OP_CONCAT")) {
            if (theStack.size() >= 2) {
                String item1 = theStack.pop();
                String item2 = theStack.pop();

                String concat = item2 + item1;
                theStack.push(concat);
                System.out.println("concatenating...");
                return true;
            } else {
                System.out.println("Error:stack has less than two values");
                return false;
            }
        }

        if (statement.equals("OP_EQUAL")) {

            if (theStack.size() >= 2) {
                String item1 = theStack.pop();
                String item2 = theStack.pop();

                if (item1.equals(item2)) {
                    theStack.push("true");
                } else {
                    theStack.push("false");
                }
                System.out.println("checking equality...");
                return true;

            } else {
                System.out.println("Error:stack has less than two values");
                return false;
            }
        }

        if (statement.equals("OP_LOWER")) {
            if (theStack.isEmpty() == false) {
                String item = theStack.pop();
                String lowerCase = item.toLowerCase();
                theStack.push(lowerCase);
                System.out.println("converting to lower case");
                return true;

            } else {
                System.out.println("Error:empty stack");
                return false;
            }
        }

        if (statement.equals("OP_UPPER")) {
            if (theStack.isEmpty() == false) {
                String item = theStack.pop();
                String upperCase = item.toUpperCase();
                theStack.push(upperCase);
                System.out.println("converting to upper case");
                return true;

            } else {
                System.out.println("Error:empty stack");
                return false;
            }
        }
        if (statement.equals("OP_SWAP")) {
            if (theStack.size() >= 2) {
                String item1 = theStack.pop();
                String item2 = theStack.pop();
                theStack.push(item1);
                theStack.push(item2);
                System.out.println("swapping...");
                return true;
            } else {
                System.out.println("Error:stack has less than 2 values");
                return false;
            }
        }

        if (statement.equals("OP_DROP")) {
            if (theStack.isEmpty() == false) {
                theStack.pop();
                System.out.println("Dropping...");
                return true;
            } else {
                System.out.println("Error:empty stack");
                return false;
            }
        }

        if (statement.equals("OP_FINISH")) {
            if (theStack.isEmpty() == false) {
                String item = theStack.pop();
                System.out.println("Final answer: " + item);
                theStack.clear();
                return true;
            } else {
                System.out.println("Error:empty stack");
                return false;
            }
        }

        theStack.push(statement);
        System.out.println("Adding data to the stack...");
        return true;
    }
}
