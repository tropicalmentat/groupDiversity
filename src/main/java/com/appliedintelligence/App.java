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

//    static GroupAssignmentSolution groupAssignment = new GroupAssignmentSolution();

    public static void setUp(List<String> members){
        ArrayList<Member> memberList = new ArrayList<>();
        Group group = new Group();
        group.setMemberList(memberList);
        int memberCount = 0;

        for (String memberName:members){
            Member member = new Member();
            System.out.println(memberName);
            member.setName(memberName);
            memberList.add(member);
            memberCount++;
        }

        System.out.println(memberList);
        System.out.println(memberCount);
        System.out.println(group.getMemberList());

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
