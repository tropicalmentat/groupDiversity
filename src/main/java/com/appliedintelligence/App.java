package com.appliedintelligence;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.appliedintelligence.domain.Group;
import com.appliedintelligence.domain.Member;
import com.opencsv.CSVReader;

public class App {

    private static final String dataPath  = "C:\\Users\\jose.luigi.s.torres\\Desktop\\trulyhuman_grouper\\data\\data_th_heart_melted.csv";

    public static void setUp(List<String> members){
        ArrayList<Member> memberList = new ArrayList<>();
        ArrayList<Group> groupList = new ArrayList<>();

        // create groups
        for (int i=0;i<=7;i++){
            Group group = new Group();
            group.setGroupIndex(i);
            groupList.add(group);
        }
        System.out.println(groupList);

        // create list of members
        for (String memberName:members){
            Member member = new Member();
            System.out.println(memberName);
            member.setName(memberName);
            memberList.add(member);
        }
        System.out.println(memberList);

    }
    public void assignMember(){

    }

    private static List<String> readData(String path) throws IOException{
        ArrayList<String> data = new ArrayList<>();
        try (
                Reader reader = Files.newBufferedReader(Paths.get(path), StandardCharsets.UTF_8);
                CSVReader csvReader = new CSVReader(reader)
        ){
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                if (nextRecord[0].contains("name")){
                    System.out.println("Skipping column headers...");
                }else {
                    data.add(nextRecord[0]);
//                    System.out.println(nextRecord[0]);
                }

            }

        }
        return data;
    }

    public static void main(String[] args) throws IOException {
        List<String> memberNames = readData(dataPath);
        setUp(memberNames);

    }
}
