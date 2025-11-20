package it.unibo.mvc;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

/**
 * 
 *
 */
public final class SimpleController implements Controller {
    private List<String> list = new ArrayList<>();
    private String currentString;

    @Override
    public void nextStringToPrint(String string) { 
        this.currentString = Objects.requireNonNull(string);
        list.add(string);
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
        try {
            System.out.println(currentString);
        } catch (IllegalStateException e){
            throw new IllegalStateException("Can not print the current string");
        }
    }

}
