import java.io.*;
import java.util.Scanner;

public class toDo {
    public static void main(String[] args) throws IOException {
        final String FILENAME = "tasks.txt";
        Scanner scanner = new Scanner(System.in);
        String newTask = "";

        getTasks(FILENAME);

        while (true) {
            System.out.println("Enter a new task:");

            newTask = scanner.nextLine();

            if (newTask.equals("exit")) {
                break;
            } else {
                writeFile(FILENAME, newTask);
            }
        }
    }

    private static void writeFile(String filename, String data) throws IOException {
        FileWriter writer = new FileWriter(filename, true);
        writer.write(data + "\n");
        writer.close();
    }

    private static void getTasks(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));

        String str;
        int i = 0;
        while ((str = br.readLine()) != null) {
            System.out.println(i+1 + ".- " + str);
            i++;
        }
    }
}
