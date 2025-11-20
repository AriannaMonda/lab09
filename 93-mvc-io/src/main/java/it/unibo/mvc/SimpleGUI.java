package it.unibo.mvc;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A very simple program using a graphical interface.
 *
 */
public final class SimpleGUI {
    private static final int PROPORTION = 5;
    private final JFrame frame = new JFrame();
    private final SimpleController controller = new SimpleController();
    /**
     * SimpleGUIWithFileChooser.
     */

    public SimpleGUI() {

        final JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());
        final JPanel panel = new JPanel();
        final JPanel panelB = new JPanel();
        final JTextField field = new JTextField();
        final JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        panel.setLayout(new BorderLayout());
        panelB.setLayout(new BorderLayout());
        canvas.add(panel, BorderLayout.NORTH);
        canvas.add(panelB, BorderLayout.SOUTH);
        panel.add(field, BorderLayout.NORTH);
        canvas.add(textArea, BorderLayout.CENTER);
        final JButton printButton = new JButton("Print");
        final JButton historyButton = new JButton("Show history");
        panelB.add(printButton, BorderLayout.WEST);
        panelB.add(historyButton, BorderLayout.EAST);
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        printButton.addActionListener(new ActionListener() {
            /**
             * Invoked when the button is pressed.
             *
             * @param e the action event triggered by the button
             * 
             */
            @Override
            public void actionPerformed(final ActionEvent e) {
                final String toPrint = field.getText();
                controller.nextStringToPrint(toPrint);
                controller.printCurrentString();
            }
        });

        historyButton.addActionListener(new ActionListener() {
            /**
             * Invoked when the button is pressed.
             *
             * @param e the action event triggered by the button
             * 
             */
            @Override
            public void actionPerformed(final ActionEvent e) {
                textArea.setText(controller.getHistory().toString());
            }
        });
    }
    /**
     * Displays the application window.
     * The size of the window is based on the screen size and the PROPORTION constant.
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
     * @param args command-line arguments (not used)
     */

    public static void main(final String... args) {
        new SimpleGUI().display();
    }
}
