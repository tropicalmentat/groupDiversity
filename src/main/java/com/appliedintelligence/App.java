package com.appliedintelligence;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import java.io.File;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import com.appliedintelligence.domain.Group;
import com.appliedintelligence.domain.Member;
import com.appliedintelligence.domain.MemberAssignment;
import com.appliedintelligence.domain.MemberAssignmentSolution;
import com.opencsv.CSVReader;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;

public class App {

    private static final String dataPath  = "C:\\Users\\jose.luigi.s.torres\\Desktop\\trulyhuman_grouper\\data\\data_th_heart_melted.csv";
    private static final String configPath = "C:\\Users\\jose.luigi.s.torres\\Desktop\\trulyhuman_grouper\\src\\main\\resources\\com.appliedintelligence\\solver\\SolverConfiguration.xml";

    static MemberAssignmentSolution unsolvedAssignment = new MemberAssignmentSolution();

    public static void initializeSolution(List<String> members){
        ArrayList<Member> memberList = new ArrayList<>();
        ArrayList<Group> groupList = new ArrayList<>();

        // create groups
        for (int i=0;i<=7;i++){
            Group group = new Group();
            group.setGroupIndex(i);
            groupList.add(group);
        }
//        System.out.println(groupList);

        // create list of members
        for (String memberName:members){
            Member member = new Member();
//            System.out.println(memberName);
            member.setName(memberName);
            memberList.add(member);
        }
//        System.out.println(memberList);

        unsolvedAssignment.getMemberList().addAll(memberList);
        unsolvedAssignment.getGroupList().addAll(groupList);
//        assignMember(groupList,memberList);

    }
    public static void assignMember(List<Group> groupList, List<Member> memberList){

        ArrayList<MemberAssignment> assignmentList = new ArrayList<>();
        HashSet<String> assignedMember = new HashSet<>();

        for (Group group:groupList){

            for (Member member:memberList){

                String assignment = member.getName()+":"+group.getGroupIndex();

                if (assignedMember.contains(member.getName())){
                    System.out.println(member.getName() + " is already assigned to a group!");
                }
                else if (group.getMemberCapacity()>=1) {

                    MemberAssignment memberAssignment = new MemberAssignment(assignment);
                    memberAssignment.setGroup(group);
                    memberAssignment.setMember(member);
                    assignedMember.add(member.getName());
                    assignmentList.add(memberAssignment);
                    group.setMemberCapacity(group.getMemberCapacity() - 1);
                    System.out.println(group.getGroupIndex() + " has " + group.getMemberCapacity() + " capacity");

                }
            }
        }
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

    public static void CustomJavaSolver(File solverConfigFile){

        SolverFactory<MemberAssignmentSolution> solverFactory = SolverFactory.
                createFromXmlFile(solverConfigFile);
        Solver<MemberAssignmentSolution> solver = solverFactory.buildSolver();

    }

    public static void main(String[] args) throws IOException {
        File solverConfig = new File(configPath);
        List<String> memberNames = readData(dataPath);
        initializeSolution(memberNames);
        CustomJavaSolver(solverConfig);

    }
}
