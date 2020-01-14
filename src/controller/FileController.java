package controller;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class FileController {
    private static File file;
    private static ArrayList<String> fileContent;
    private static Path configFilePath;

    public FileController(String filePath) {
        configFilePath = Paths.get(filePath);
        fileContent = new ArrayList<>();
    }
    public static void fileRead() {
        try (Stream<String> stream = Files.lines(configFilePath)) {
            stream.forEach(line -> fileContent.add(line));
            System.out.println(fileContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void fileSave() {
        try {
            Files.write(configFilePath,fileContent, Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<String> getFileContent() {
        return fileContent;
    }
}
