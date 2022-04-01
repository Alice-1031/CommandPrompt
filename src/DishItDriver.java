
import java.util.Scanner;

/**
 * This class is the driver for the program DishItDriver
 * 
 * <p>
 * Bugs: program crashes if user inputs values in incorrect format.
 * 
 * @author Shreya_Jaiswal
 */
public class DishItDriver {

    /**
     * main method that drives the program
     * 
     * @param args
     */
    public static void main(String[] args) {

        Interpreter interpret;
        Scanner userInput = new Scanner(System.in);
        System.out.println("Would you like DishIt or DishIt-math: ");
        String input = userInput.nextLine();

        if (input.equals("DishIt")) {

            interpret = new Interpreter();

        } else if (input.equals("DishIt-math")) {
            interpret = new InterpreterMath();
        } else {
            return;
        }
       
        while (true) {

            System.out.print(">> ");
            String statement;
            String[] statementArray;

            
            statement = userInput.nextLine();
            if(statement.equals(":exit")) {break;}
            statementArray = statement.split(";");

            for (int i = 0; i < statementArray.length; i++) {
                statementArray[i] = statementArray[i].trim();

            }

            interpret.evalMultiple(statementArray);

        }
    }
}