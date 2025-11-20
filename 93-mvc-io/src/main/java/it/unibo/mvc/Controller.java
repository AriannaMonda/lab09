package it.unibo.mvc;

import java.awt.List;

/**
 *
 */
public interface Controller {
    void nextStringToPrint(String string);
    String geString();
    List getHistory();
    void printCurrentString() throws IllegalStateException;

}
