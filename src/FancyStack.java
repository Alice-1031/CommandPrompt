import java.util.ArrayList;

/**
 * This class is the extension for the class StringStack
 * <p>
 * 
 * @author Shreya_Jaiswal
 */
public class FancyStack extends StringStack {
    /**
     * * Method to tell if stack is empty. * @return boolean true for empty stack
     */
    public boolean isEmpty() {
        String item;
        item = pop();

        if (item == null) {
            return true;
        } else {
            push(item);
            return false;
        }
    }

    /**
     * * Method to clear the stack.
     */
    public void clear() {
        int i;
        for (i = 0; isEmpty() == false; i++) {
            pop();
        }
    }

    /**
     * * Method to get the size of current stack. * @return integer size
     */
    public int size() {
        int i;
        int count;
        if (isEmpty() == true) {
            return 0;
        }
        ArrayList<String> poppedItems;
        poppedItems = new ArrayList<String>();
        count = 0;
        for (i = 0; isEmpty() == false; i++) {
            String item = pop();
            poppedItems.add(item);
            count = count + 1;
        }

        for (i = poppedItems.size() - 1; i >= 0; i--) {
            push(poppedItems.get(i));
        }

        return count;
    }
}
