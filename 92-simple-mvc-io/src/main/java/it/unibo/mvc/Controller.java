package it.unibo.mvc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private static final String sep = System.getProperty("file.separator");
    public static final String FILE_NAME = System.getProperty("user.home") + sep + "output.txt";
    private File currentFile;
    public Controller() {
        this.currentFile = new File(FILE_NAME);
    }

    public void setFile(final File file) {
        this.currentFile = file;
    }

    public File getFile() {
        return this.currentFile;
    }

    public String getFilePath() {
        return this.currentFile.getPath();
    }

    public void writeContent(final String content) throws IOException {
        try (FileWriter writer = new FileWriter(this.currentFile.getPath())) {
            writer.write(content);
        }// try-with-resources NON necessita il catch, non gestisco direttamente l'eccezione
    }
}
