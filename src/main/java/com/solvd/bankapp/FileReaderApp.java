package com.solvd.bankapp;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileReaderApp {
    public static void main(String[] args){
        File file = new File("src/main/resources/article.txt");
        String[] names = {"Jefferson", "Dobbs", "Hockenson"};

        try {
            // Read the entire contents of sample.txt
            String content = FileUtils.readFileToString(file, "UTF-8");
            for(String name : names){
                int numberOfOccurences = StringUtils.countMatches(content, name);
                String newLine = name + " = " + numberOfOccurences + '\n';
                FileUtils.write(new File("src/main/resources/filereaderoutput.txt"), newLine, "UTF-8", true);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
