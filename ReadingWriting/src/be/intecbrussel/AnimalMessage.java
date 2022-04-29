package be.intecbrussel;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class AnimalMessage {

    public static void main(String[] args) {

        Path path = Path.of("../../FromKubraToPearl/Animal.txt");

        Animal animal = new Animal("Cat MiMi", false);

        try {
            if (Files.notExists(path.getParent())) {
                Files.createDirectory(path.getParent());
            }

            if (Files.notExists(path)) {
                Files.createFile(path);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (BufferedReader bufferedReader =
                     new BufferedReader(new FileReader("../../FromKubraToPearl/Animal.txt"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(path.toString())
        )) {

            bufferedWriter.write(animal.toString());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
