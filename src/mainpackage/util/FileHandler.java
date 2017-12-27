package mainpackage.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    private String path;
    private File file;

    public FileHandler(String path) {
        this.path = path;
        loadFile();
    }
 
    public boolean isFileLoaded() {
        return this.file.exists();
    }
    
    public int[] extractNumbers() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        try {
            Scanner scanner = new Scanner(this.file);
            while(scanner.hasNextInt()){
                list.add(scanner.nextInt());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("file not found");
        }

        return list.stream().mapToInt(i -> i).toArray();
    }

    private void loadFile() {
        try {
            this.file = new File(this.path);
        } catch (NullPointerException ex) {
            System.out.println("Error with file loading");
        }
    }
}
