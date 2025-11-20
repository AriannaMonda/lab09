package it.unibo.mvc;

import java.util.List;

/**
 * Controller.
 */
public interface Controller {
    /**
     * Sets the next string that will be processed and printed.
     *
     * @param string the string to be set as the next one to print
     */

    void nextStringToPrint(String string);
    /**
     * Returns the current string set for printing.
     *
     * @return the current string, or {@code null} if none has been set
     */

    String geString();
    /**
     * Returns the history of all strings that have been processed.
     *
     * @return a list containing the history of strings
     */

    List<String> getHistory();
    /**
     * Prints the current string.
     * The actual printing behavior depends on the implementation.
     */

    void printCurrentString();
}
