package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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

public final class SimpleGUIWithFileChooser {

    private static final int PROPORTION = 5;
    private final JFrame frame = new JFrame();
    private Controller controller = new Controller();
    /**
     * SimpleGUIWithFileChooser.
     */

    public SimpleGUIWithFileChooser() {

        final JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());
        final JPanel panel = new JPanel();
        final JTextField field = new JTextField(controller.getFilePath());
        field.setEditable(false);
        panel.setLayout(new BorderLayout());
        canvas.add(panel, BorderLayout.NORTH);
        panel.add(field, BorderLayout.CENTER);
        final JButton browseButton = new JButton("Browse...");
        panel.add(browseButton, BorderLayout.LINE_END);
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /**
         * Event handler for the "Browse..." button.
         * Opens a file chooser and updates the text field with the selected file path.
         */

        browseButton.addActionListener(new ActionListener() {
            /**
             * Invoked when the button is pressed.
             *
             * @param e the action event triggered by the button
             * 
             */
            @Override
            public void actionPerformed(final ActionEvent e) {
                final JFileChooser fileChooser = new JFileChooser();
                final int result = fileChooser.showSaveDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    controller.setFile(fileChooser.getSelectedFile());
                    field.setText(controller.getFilePath());
                } else if (result == JFileChooser.CANCEL_OPTION) {
                } else {
                    JOptionPane.showMessageDialog(frame, "Error: ");
                }
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
        new SimpleGUIWithFileChooser().display();
    }
}

