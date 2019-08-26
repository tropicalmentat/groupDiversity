package com.appliedintelligence;
import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SolutionInitializer {

    private static final String dataPath  = "C:\\Users\\jose.luigi.s.torres\\" +
            "Desktop\\trulyhuman_grouper\\data\\sample_hobbies.csv";

    //TODO: 
    private static List<String> readData(String path) throws IOException {
        ArrayList<String> data = new ArrayList<>();
        try (
                Reader reader = Files.newBufferedReader(Paths.get(path), StandardCharsets.UTF_8);
                CSVReader csvReader = new CSVReader(reader)
        ){
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                if (nextRecord[1].contains("hobbies_Reading")){
                    System.out.println("Skipping column headers...");
                }else {
                    data.add(nextRecord[1]);
                    System.out.println(nextRecord[1]);
                }
            }
        }
        return data;
    }

    public static void main(String[] args) throws IOException{
        List<String> output = readData(dataPath);
    }

}
