package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {
    private static final int PROPORTION = 5;
    private static final String TITLE = "My first java grahical interface";
    private final JFrame frame = new JFrame(TITLE);
    private final Controller controller = new Controller();
    /**
     * Creates the GUI and initializes all Swing components,
     * including the text area and the save button.
     */

    public SimpleGUI() {
        final JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JTextArea textArea = new JTextArea();
        canvas.add(textArea, BorderLayout.CENTER);
        final JButton button = new JButton("Save");
        canvas.add(button, BorderLayout.SOUTH);

        /*
        * Handlers
        */
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    controller.writeContent(textArea.getText());
                } catch (final IOException ex) {
                    throw new IllegalArgumentException("Error", ex);
                }
            }
        });
    }
    /**
     * Displays the application window on the screen.
     * The size is calculated as a fraction of the screen size.
     */

    private void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
    /**
     * Main method. Starts the application.
     * 
     * @param args for the argumenst
     */

    public static void main(final String... args) {
        new SimpleGUI().display();
    }
}
