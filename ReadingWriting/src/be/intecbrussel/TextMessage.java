package be.intecbrussel;

import java.nio.file.Path;
import java.nio.file.Files;
import java.io.*;

public class TextMessage {

    public static void main(String[] args) {

        Path path = Path.of("../../FromKubraToPearl/Message.txt");

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


        try (BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(path.toString())
        )) {

            bufferedWriter.write("TEMEL and DURSUN \n" +

                    "Dursun has made a lot of money in the USA and tells his beloved friend Temel \n" +
                    "to join him in LA. He tells him there are so many opportunities for him to earn his living here,\n" +
                    "going even further to say he’d be rich even if he picks up the money people throw/drop \n" +
                    "on the streets. So Temel jumps on the first plane and travels to the US; \n" +
                    "and with his first step he sees a $10 note on the floor.\n" +
                    "But he decides not to take it, saying: “I’m not going to start working on the first day!“:D");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (BufferedReader bufferedReader =
                     new BufferedReader(new FileReader("../../FromKubraToPearl/Message.txt"))) {
            String text;
            while ((text = bufferedReader.readLine()) != null) {
                System.out.println(text);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
