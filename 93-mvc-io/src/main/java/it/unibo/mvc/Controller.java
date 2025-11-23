package it.unibo.mvc;

import java.util.List;

/**
 * Controller.
 */
public interface Controller {
    /**
     * @param string the string to be set as the next one to print
     */

    void nextStringToPrint(String string);
    /**
     * @return the current string, or {@code null} if none has been set
     */

    String getString();
    /**
     * @return a list containing the history of strings
     */

    List<String> getHistory();
    /**
     * Prints the current string.
     * The actual printing behavior depends on the implementation.
     */

    void printCurrentString();
}
