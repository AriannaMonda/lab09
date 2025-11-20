package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
/**
 * Application controller. Performs the I/O.
 */

public class Controller {

    private static final String FILE_SEPARATOR = System.getProperty("file.separator");
    public static final String FILE_NAME = System.getProperty("user.home") + FILE_SEPARATOR + "output.txt";
    private File currentFile;
    /**
     * Costructor.
     */

    public Controller() {
        this.currentFile = new File(FILE_NAME);
    }
    /**
     * Sets a new file for the controller.
     *
     * @param file the file to be set as current
     */

    public void setFile(final File file) {
        this.currentFile = file;
    }
    /**
     * Returns the file currently managed by the controller.
     *
     * @return the current File object
     */

    public File getFile() {
        return this.currentFile;
    }
    /**
     * Returns the path of the currently selected file.
     *
     * @return the file path as a String
     */

    public String getFilePath() {
        return this.currentFile.getPath();
    }
    /**
     * Writes the given content to the current file.
     * If the file already exists, it will be overwritten.
     *
     * @param content the text to write into the file
     * @throws IOException if an I/O error occurs while writing the file
     */

    public void writeContent(final String content) throws IOException {
        try (var writer = Files.newBufferedWriter(this.currentFile.toPath(), StandardCharsets.UTF_8)) {
            writer.write(content);
        } // try-with-resources NON necessita il catch, non gestisco direttamente l'eccezione
    }
}
