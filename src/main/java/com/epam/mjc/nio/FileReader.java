package com.epam.mjc.nio;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReader {

    public Profile getDataFromFile(File file) {
        Path path = Paths.get("src/main/resources/Profile.txt");
        StringBuilder content = new StringBuilder();
        try (Stream<String> lines = Files.lines(path)){
            lines.forEach(s -> content.append(s).append("--"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String dataProfile = content.toString();
        String[] dataProfileSeparate = dataProfile.split("--");
        String name = dataProfileSeparate[0].replaceFirst("Name: ", "");
        int age = Integer.parseInt(dataProfileSeparate[1].replaceFirst("Age: ", ""));
        String email = dataProfileSeparate[2].replaceFirst("Email: ", "");
        long phone = Long.parseLong(dataProfileSeparate[3].replaceFirst("Phone: ", ""));

        return new Profile(name, age, email, phone);
    }
}
