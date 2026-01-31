import java.io.*;
import java.nio.file.*;
import java.util.*;

/**
 * INTERNSHIP TASK-1: FILE HANDLING UTILITY
 * Student: RUTUJA KUTHE - ENTC Engineering
 * Company: CODTECH IT SOLUTIONS
 * Java program to read, write, and modify text files
 */

public class Task1_FileHandlingUtility {
    
    private static final String SAMPLE_FILE = "sample_data.txt";
    private static final String OUTPUT_FILE = "output_data.txt";
    private static final String MODIFIED_FILE = "modified_data.txt";
    
    public static void main(String[] args) {
        System.out.println("=== FILE HANDLING UTILITY ===");
        System.out.println("Student: RUTUJA KUTHE - ENTC Engineering\n");
        
        Task1_FileHandlingUtility utility = new Task1_FileHandlingUtility();
        
        try {
            // Demonstrate all file operations
            utility.demonstrateFileOperations();
            
        } catch (Exception e) {
            System.err.println("Error during file operations: " + e.getMessage());
            e.printStackTrace();
        }
        
        System.out.println("\n=== FILE HANDLING COMPLETED ===");
    }
    
    public void demonstrateFileOperations() throws IOException {
        System.out.println("=== DEMONSTRATING FILE OPERATIONS ===\n");
        
        // 1. Create and write to file
        System.out.println("1. CREATING AND WRITING TO FILE");
        createSampleFile();
        
        // 2. Read from file
        System.out.println("\n2. READING FROM FILE");
        readFile(SAMPLE_FILE);
        
        // 3. Append to file
        System.out.println("\n3. APPENDING TO FILE");
        appendToFile(SAMPLE_FILE);
        
        // 4. Copy file
        System.out.println("\n4. COPYING FILE");
        copyFile(SAMPLE_FILE, OUTPUT_FILE);
        
        // 5. Modify file content
        System.out.println("\n5. MODIFYING FILE CONTENT");
        modifyFileContent(OUTPUT_FILE, MODIFIED_FILE);
        
        // 6. File information
        System.out.println("\n6. FILE INFORMATION");
        displayFileInfo(MODIFIED_FILE);
        
        // 7. Search in file
        System.out.println("\n7. SEARCHING IN FILE");
        searchInFile(MODIFIED_FILE, "Java");
        
        // 8. Count lines, words, characters
        System.out.println("\n8. FILE STATISTICS");
        displayFileStatistics(MODIFIED_FILE);
    }
    
    /**
     * Creates a sample file with initial content
     */
    public void createSampleFile() throws IOException {
        System.out.println("Creating sample file: " + SAMPLE_FILE);
        
        String[] sampleContent = {
            "Welcome to File Handling Utility",
            "This is a Java program for file operations",
            "Created by RUTUJA KUTHE",
            "CODTECH IT SOLUTIONS Internship",
            "Task-1: File Handling Operations",
            "",
            "Features demonstrated:",
            "- Reading files",
            "- Writing files", 
            "- Modifying files",
            "- File information retrieval"
        };
        
        try (PrintWriter writer = new PrintWriter(new FileWriter(SAMPLE_FILE))) {
            for (String line : sampleContent) {
                writer.println(line);
            }
        }
        
        System.out.println("✓ Sample file created successfully");
    }
    
    /**
     * Reads and displays content from a file
     */
    public void readFile(String filename) throws IOException {
        System.out.println("Reading file: " + filename);
        System.out.println("--- File Content ---");
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int lineNumber = 1;
            
            while ((line = reader.readLine()) != null) {
                System.out.printf("%2d: %s%n", lineNumber++, line);
            }
        }
        
        System.out.println("✓ File read successfully");
    }
    
    /**
     * Appends content to an existing file
     */
    public void appendToFile(String filename) throws IOException {
        System.out.println("Appending to file: " + filename);
        
        String[] additionalContent = {
            "",
            "--- APPENDED CONTENT ---",
            "Additional file operations:",
            "- Appending data",
            "- File copying",
            "- Content modification",
            "- Statistical analysis"
        };
        
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))) {
            for (String line : additionalContent) {
                writer.println(line);
            }
        }
        
        System.out.println("✓ Content appended successfully");
    }
    
    /**
     * Copies content from source file to destination file
     */
    public void copyFile(String sourceFile, String destFile) throws IOException {
        System.out.println("Copying file: " + sourceFile + " → " + destFile);
        
        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
             PrintWriter writer = new PrintWriter(new FileWriter(destFile))) {
            
            String line;
            while ((line = reader.readLine()) != null) {
                writer.println(line);
            }
        }
        
        System.out.println("✓ File copied successfully");
    }
    
    /**
     * Modifies file content by replacing specific text
     */
    public void modifyFileContent(String sourceFile, String destFile) throws IOException {
        System.out.println("Modifying file content: " + sourceFile + " → " + destFile);
        
        List<String> lines = new ArrayList<>();
        
        // Read all lines
        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Modify content - replace "Java" with "JAVA Programming"
                line = line.replace("Java", "JAVA Programming");
                // Add timestamp to first line
                if (lines.isEmpty()) {
                    line = line + " [Modified: " + new Date() + "]";
                }
                lines.add(line);
            }
        }
        
        // Write modified content
        try (PrintWriter writer = new PrintWriter(new FileWriter(destFile))) {
            for (String line : lines) {
                writer.println(line);
            }
        }
        
        System.out.println("✓ File content modified successfully");
        System.out.println("  - Replaced 'Java' with 'JAVA Programming'");
        System.out.println("  - Added timestamp to first line");
    }
    
    /**
     * Displays file information
     */
    public void displayFileInfo(String filename) throws IOException {
        System.out.println("File information for: " + filename);
        
        File file = new File(filename);
        Path path = Paths.get(filename);
        
        if (file.exists()) {
            System.out.println("  File name: " + file.getName());
            System.out.println("  File path: " + file.getAbsolutePath());
            System.out.println("  File size: " + file.length() + " bytes");
            System.out.println("  Last modified: " + new Date(file.lastModified()));
            System.out.println("  Readable: " + file.canRead());
            System.out.println("  Writable: " + file.canWrite());
            System.out.println("  Is file: " + file.isFile());
        } else {
            System.out.println("  File does not exist!");
        }
    }
    
    /**
     * Searches for specific text in file
     */
    public void searchInFile(String filename, String searchText) throws IOException {
        System.out.println("Searching for '" + searchText + "' in file: " + filename);
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int lineNumber = 1;
            int matchCount = 0;
            
            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains(searchText.toLowerCase())) {
                    System.out.printf("  Line %d: %s%n", lineNumber, line.trim());
                    matchCount++;
                }
                lineNumber++;
            }
            
            System.out.println("✓ Search completed. Found " + matchCount + " matches.");
        }
    }
    
    /**
     * Displays file statistics (lines, words, characters)
     */
    public void displayFileStatistics(String filename) throws IOException {
        System.out.println("File statistics for: " + filename);
        
        int lineCount = 0;
        int wordCount = 0;
        int charCount = 0;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            
            while ((line = reader.readLine()) != null) {
                lineCount++;
                charCount += line.length();
                
                // Count words (split by whitespace)
                String[] words = line.trim().split("\\s+");
                if (!line.trim().isEmpty()) {
                    wordCount += words.length;
                }
            }
        }
        
        System.out.println("  Lines: " + lineCount);
        System.out.println("  Words: " + wordCount);
        System.out.println("  Characters: " + charCount);
        System.out.println("✓ Statistics calculated successfully");
    }
    
    /**
     * Utility method to delete a file
     */
    public boolean deleteFile(String filename) {
        File file = new File(filename);
        if (file.exists()) {
            return file.delete();
        }
        return false;
    }
    
    /**
     * Utility method to check if file exists
     */
    public boolean fileExists(String filename) {
        return new File(filename).exists();
    }
    
    /**
     * Cleanup method to remove created files
     */
    public void cleanup() {
        System.out.println("\nCleaning up created files...");
        
        String[] filesToDelete = {SAMPLE_FILE, OUTPUT_FILE, MODIFIED_FILE};
        
        for (String filename : filesToDelete) {
            if (deleteFile(filename)) {
                System.out.println("✓ Deleted: " + filename);
            }
        }
    }
}