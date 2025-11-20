package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {
    void nextStringToPrint(String string);
    String geString();
    List<String> getHistory();
    void printCurrentString();

}
