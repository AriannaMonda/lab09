package it.unibo.mvc;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

/**
 * 
 *
 */
public final class SimpleController implements Controller {
    private final List<String> list = new ArrayList<>();
    private String currentString;

    @Override
    public void nextStringToPrint(String string) { 
        this.currentString = Objects.requireNonNull(string);
    }

    @Override
    public String geString() {
        return this.currentString;
    }

    @Override
    public List<String> getHistory() {
        return this.list;
    }

    @Override
    public void printCurrentString() {
        if(this.currentString == null){
            throw new IllegalStateException("Cannot print the current string");
        }
        list.add(currentString);
        System.out.println(currentString);
    }

}
