package it.unibo.mvc;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

/**
 * SimpleController.
 */
public final class SimpleController implements Controller {
    private final List<String> list = new ArrayList<>();
    private String currentString;

    @Override
    public void nextStringToPrint(final String string) { 
        this.currentString = Objects.requireNonNull(string);
    }

    @Override
    public String getString() {
        return this.currentString;
    }

    @Override
    public List<String> getHistory() {
        return new ArrayList<>(this.list);
    }

    @Override
    public void printCurrentString() {
        if (this.currentString == null) {
            throw new IllegalStateException("Cannot print the current string");
        }
        list.add(currentString);
        System.out.println(currentString); //NOPMD
    }

}
