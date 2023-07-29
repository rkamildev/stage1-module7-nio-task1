package com.epam.mjc.nio;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FileReader {

    public Profile getDataFromFile(File file) {
        Path path = Paths.get(String.valueOf(file));
        Profile profile = new Profile();
        String line;
        try (BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"))) {
            while ( (line = reader.readLine()) != null) {
                String[] str = line.split(":\\s+");
                if (str[0].equals("Name"))
                    profile.setName(str[1]);
                if (str[0].equals("Age"))
                    profile.setAge(Integer.parseInt(str[1]));
                if (str[0].equals("Email"))
                    profile.setEmail(str[1]);
                if (str[0].equals("Phone"))
                    profile.setPhone(Long.parseLong(str[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return profile;
    }
}
