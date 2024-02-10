package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    /* Multi-platform standards programming */
    private static final String HOME = System.getProperty("user.home");
    private static final String DEFAULT_FILE  = "output.txt";
    private File destFile = new File(HOME + File.separator + DEFAULT_FILE);

    /**
     * Returns the current file.
     * 
     * @return the current file
     */
    public File getCurrentFile(){
        return destFile;
    }

    /**
     * Returns the current file path.
     *
     * @return the current file path
     */
    public String getCurrentFilePath(){
        return destFile.getPath();
    }

    /**
     * Sets a new destination file.
     *
     * @param file
     *            the file where to write
     */
    public setDestination(final File newFile){
        final File parent = newFile.getParentFile();
        if (parent.exists()){
            destFile = newFile;
        }
        else{
            throw new IllegalArgumentException("Cannot save in a non-existing folder");
        }
    }

    /**
     * Sets a new destination file.
     *
     * @param file
     *            the file where to write
     */
    public setDestination(final String newStringFile){
        setDestination(new File(newStringFile));
    }
    

    /**
     * Saves some text on the designed file.
     * 
     * @param text
     *            the text to save
     * @throws IOException
     *             if the writing fails
     */
    public save(String someText) throws IOException{
        try(PrintStream stream = new PrintStream(destFile, StandardCharsets.UTF_8)){
            System.out.println(someText);
        }
    }
}
