package com.ivaaaak.client.util;


import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringJoiner;


public final class FileManager {

    public static final String FILE_PATH = System.getenv("LAB");

    private FileManager() {

    }

    public static String read(final String filePath) {

        StringJoiner fileData = new StringJoiner("\n");

        try (FileReader reader = new FileReader(filePath);
             Scanner scanner = new Scanner(reader)) {
            while (scanner.hasNextLine()) {
                fileData.add(scanner.nextLine());
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return fileData.toString();
    }


    public static void write(String data, final String filePath)  {

        try (OutputStream os = new FileOutputStream(filePath);
             OutputStreamWriter osw = new OutputStreamWriter(os)) {
            osw.write(data);
            osw.flush();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

}
