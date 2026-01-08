import java.io.*;
import java.nio.file.*;

public class FileHandlingUtility {
    
    public static void writeFile(String filename, String content) {
        try {
            Files.write(Paths.get(filename), content.getBytes());
            System.out.println("File written successfully: " + filename);
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }
    
    public static String readFile(String filename) {
        try {
            String content = Files.readString(Paths.get(filename));
            System.out.println("File read successfully: " + filename);
            return content;
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return null;
        }
    }
    
    public static void appendToFile(String filename, String content) {
        try {
            Files.write(Paths.get(filename), content.getBytes(), StandardOpenOption.APPEND);
            System.out.println("Content appended to: " + filename);
        } catch (IOException e) {
            System.err.println("Error appending to file: " + e.getMessage());
        }
    }
    
    public static void modifyFile(String filename, String oldText, String newText) {
        try {
            String content = Files.readString(Paths.get(filename));
            String modifiedContent = content.replace(oldText, newText);
            Files.write(Paths.get(filename), modifiedContent.getBytes());
            System.out.println("File modified successfully: " + filename);
        } catch (IOException e) {
            System.err.println("Error modifying file: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        String filename = "sample.txt";
        
        System.out.println("FILE HANDLING UTILITY DEMO");
        
        writeFile(filename, "Hello World!\nThis is line 2.\nThis is line 3.");
        
        String content = readFile(filename);
        System.out.println("Content:\n" + content);
        
        appendToFile(filename, "\nThis is an appended line.");
        
        content = readFile(filename);
        System.out.println("Updated Content:\n" + content);
        
        modifyFile(filename, "Hello World!", "Hello Java!");
        
        content = readFile(filename);
        System.out.println("Final Content:\n" + content);
        
        System.out.println("DEMO COMPLETED");
    }
}