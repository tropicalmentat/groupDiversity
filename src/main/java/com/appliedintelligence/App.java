package com.appliedintelligence;

import java.io.File;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.appliedintelligence.domain.Group;
import com.appliedintelligence.domain.Member;
import com.appliedintelligence.domain.MemberAssignment;
import com.appliedintelligence.domain.MemberAssignmentSolution;
import com.opencsv.CSVReader;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;
import org.optaplanner.core.impl.score.director.ScoreDirector;
import org.optaplanner.core.impl.score.director.ScoreDirectorFactory;

public class App {

    private static final String dataPath  = "C:\\Users\\jose.luigi.s.torres\\Desktop\\" +
            "trulyhuman_grouper\\data\\data_th_heart_melted.csv";

    private static final String configPath = "C:\\Users\\jose.luigi.s.torres\\Desktop\\" +
            "trulyhuman_grouper\\src\\main\\resources\\com.appliedintelligence\\solver\\SolverConfiguration.xml";

    public static MemberAssignmentSolution unsolvedAssignment = new MemberAssignmentSolution();
    public static ScoreDirector scoreDirector;

    public static void initializeSolution(List<String> members){
        ArrayList<Member> memberList = new ArrayList<>();
        ArrayList<Group> groupList = new ArrayList<>();

        // create groups
        for (int i=0;i<=5;i++){
            Group group = new Group();
            group.setGroupIndex(i);
            groupList.add(group);
        }

        // create list of members
        for (String memberName:members){
            Member member = new Member();
//            System.out.println(memberName);
            member.setName(memberName);
            memberList.add(member);
        }

        unsolvedAssignment.getMemberList().addAll(memberList);
        unsolvedAssignment.getGroupList().addAll(groupList);
        List<MemberAssignment> assignmentList = assignMember(groupList,memberList);
        for (MemberAssignment assignment:assignmentList){
            unsolvedAssignment.getAssignmentList().add(assignment);
        }


    }
    public static List<MemberAssignment> assignMember(List<Group> groupList, List<Member> memberList){

        ArrayList<MemberAssignment> assignmentList = new ArrayList<>();
        HashSet<String> assignedMember = new HashSet<>();

        for (Group group:groupList){

            for (Member member:memberList){

                String assignment = member.getName()+":"+group.getGroupIndex();

                if (assignedMember.contains(member.getName())){
//                    System.out.println(member.getName() + " is already assigned to a group!");
                }
                /*
                Add all members to group 1 to create suboptimal initial solution
                 */
                else if (group.getMemberCapacity()>=1) {

                    MemberAssignment memberAssignment = new MemberAssignment();
                    memberAssignment.setGroup(group);
                    memberAssignment.setMember(member);
                    assignedMember.add(member.getName());
                    assignmentList.add(memberAssignment);
                    group.setMemberCapacity(group.getMemberCapacity() - 1);
//
//                    System.out.println(group.getGroupIndex() + " has " + group.getMemberCapacity() + " capacity");

                }
            }
        }
        return assignmentList;
    }
    // TODO: Make another class for reading data and creating entities
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

    public static void Solver(File solverConfigFile){

        System.out.println("Solving...");

        SolverFactory<MemberAssignmentSolution> solverFactory = SolverFactory.
                createFromXmlFile(solverConfigFile);
        Solver<MemberAssignmentSolution> solver = solverFactory.buildSolver();
        ScoreDirectorFactory scoreDirectorFactory = solver.getScoreDirectorFactory();
        scoreDirector = scoreDirectorFactory.buildScoreDirector();
        scoreDirector.setWorkingSolution(unsolvedAssignment);
        solver.solve(unsolvedAssignment);
        MemberAssignmentSolution bestAssignment = (MemberAssignmentSolution) solver.getBestSolution();
        bestAssignment.printMemberAssignment();

    }

    public static void main(String[] args) throws IOException {
        File solverConfig = new File(configPath);
        List<String> memberNames = readData(dataPath);
        initializeSolution(memberNames);
        Solver(solverConfig);

    }
}
