package com.mojafirma;

import java.io.*;
import java.util.ArrayList;

public class FileData {

    public static String getData() throws IOException {

        String path = "users.txt";
        BufferedReader reader = new BufferedReader(new FileReader(path));

        String line;
        String fileContent = "";
        try {
            while ((line = reader.readLine()) != null) {
                fileContent += line + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
        return fileContent;
    }

    public static void setData(ArrayList<User> users) throws IOException {

        String path = "users.txt";
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
            for (int i = 0; i < users.size(); i++) {
                bufferedWriter.write(users.get(i).getName());
                bufferedWriter.write(" ");
                bufferedWriter.write(users.get(i).getLastname());
                bufferedWriter.write(" ");
                bufferedWriter.write(users.get(i).getAge());
                bufferedWriter.write("\n");
            }
        }
    }
}



