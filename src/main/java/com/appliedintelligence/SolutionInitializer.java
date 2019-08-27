package com.appliedintelligence;
import com.appliedintelligence.domain.Hobby;
import com.appliedintelligence.domain.Member;
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

    //TODO: Initialize members and their attributes
    private static List<String> readData(String path) throws IOException {
        ArrayList<String> data = new ArrayList<>();
        try (
                Reader reader = Files.newBufferedReader(Paths.get(path), StandardCharsets.UTF_8);
                CSVReader csvReader = new CSVReader(reader)
        ){
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                // skip column headers
                if (nextRecord[0].contains("name") | nextRecord[1].contains("hobbies_Reading") |
                        nextRecord[2].contains("hobbies_Volunteering")){
                    System.out.println("Skipping column headers...");
                }else {
                    data.add(nextRecord[0]);
//                    System.out.println(nextRecord[0]+' '+nextRecord[1]+' '+nextRecord[2]);
                    Member member = new Member();
                    member.setName(nextRecord[0]);

                    if(nextRecord[1].equalsIgnoreCase("1")){
                        Hobby hobby = Hobby.READING;
                        member.setHobby(hobby);
                    }
                    else if (nextRecord[2].equalsIgnoreCase("1")){
//                        Hobby hobby = Hobby.VOLUNTEERING;
//                        member.setHobby(hobby);
//                        TODO: Redesign domain model to accommodate multiple hobbies, interests and activities
                    }
                    System.out.println(member);
                }
            }
        }
        return data;
    }

    public static void main(String[] args) throws IOException{
        List<String> output = readData(dataPath);
    }

}
