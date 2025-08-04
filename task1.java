import java.io.*;
import java.util.Scanner;

public class task1 {

    static final String FILE_NAME = "example.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== File Handling Menu =====");
            System.out.println("1. Write to File");
            System.out.println("2. Read from File");
            System.out.println("3. Modify File");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");
            choice = sc.nextInt();
            sc.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    writeToFile(sc);
                    break;
                case 2:
                    readFromFile();
                    break;
                case 3:
                    modifyFile(sc);
                    break;
                case 4:
                    System.out.println("Exiting program. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 4);

        sc.close();
    }

    // WRITE operation
    private static void writeToFile(Scanner sc) {
        try {
            FileWriter writer = new FileWriter(FILE_NAME);
            System.out.println("Enter text to write to file (type 'end' to stop):");

            while (true) {
                String line = sc.nextLine();
                if (line.equalsIgnoreCase("end")) break;
                writer.write(line + System.lineSeparator());
            }

            writer.close();
            System.out.println("Data written to file successfully.");

        } catch (IOException e) {
            System.out.println("An error occurred while writing to file.");
            e.printStackTrace();
        }
    }

    // READ operation
    private static void readFromFile() {
        try {
            File file = new File(FILE_NAME);
            Scanner reader = new Scanner(file);

            System.out.println("\n--- File Content ---");
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                System.out.println(line);
            }
            reader.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found. Write to the file first.");
        }
    }

    // MODIFY operation (append at the end)
    private static void modifyFile(Scanner sc) {
        try {
            FileWriter writer = new FileWriter(FILE_NAME, true); // true = append mode
            System.out.println("Enter text to append (type 'end' to stop):");

            while (true) {
                String line = sc.nextLine();
                if (line.equalsIgnoreCase("end")) break;
                writer.write(line + System.lineSeparator());
            }

            writer.close();
            System.out.println("File modified successfully.");

        } catch (IOException e) {
            System.out.println("An error occurred while modifying the file.");
            e.printStackTrace();
        }
    }
}
