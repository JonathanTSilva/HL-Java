package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Program {
    public static void main(String[] args) {
        
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("Atividade de leitura de arquivo");
        System.out.println();

        String path1 = "/tmp/testfile.AW5Hga";

        try (BufferedReader br = new BufferedReader(new FileReader(path1))) {
            String line = br.readLine();
            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("Atividade de escrita em arquivo");
        System.out.println();
        
        
        String[] lines = new String[] {"Good morning", "Good afternoon", "Good night"};
        
        String path2 = "/tmp/out.txt";
        
        // O parâmetro true indica que não quer que recrie o arquivo. Semelhante ao >> do bash
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path2, true))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}