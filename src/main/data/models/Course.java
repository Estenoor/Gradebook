/*
 * Course:
 *  2020
 * Lab  -
 * Name: SamzF
 * Created: 12/8/2020
 */
package main.data.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Course:
 * 2020
 * Course purpose: Contains All Data Pertaining to the a Course
 *
 * @author SamzF
 * @version created on 12/8/2020 at 11:46 AM
 */
public class Course {
    private String code;
    private String name;
    private double unweightedGrade;
    private double weightedGrade;

    private List<String> assignmentTypes;
    private HashMap<String, Double> gradeWeights;
    private HashMap<String, List<Assignment>> assignments;

    public Course(String name, String code) {
        this.code = code;
        this.name = name;
        this.unweightedGrade = 0;
        this.weightedGrade = 0;
        this.assignmentTypes = new ArrayList<String>();
        this.gradeWeights = new HashMap<>();
        this.assignments = new HashMap<>();
    }

    public void addAssignment(Assignment assignment) {
        if(!assignments.containsKey(assignment.getName())) {
            assignments.put(assignment.getName(), new LinkedList<>());
        }
        assignments.get(assignment.getName()).add(assignment);
        calculateUnweightedGrade();
        calculateWeightedGrade();
    }

    public void addMultipleAssignments(List<Assignment> newAssignments) {
        newAssignments.stream().forEach((Assignment a) -> {
            if(!assignments.containsKey(a.getName())) {
                assignments.put(a.getName(), new LinkedList<>());
            }
            assignments.get(a.getName()).add(a);
        });
        calculateUnweightedGrade();
        calculateWeightedGrade();
    }

    private void calculateUnweightedGrade() {
       unweightedGrade = assignments.values()
               .stream()
               .flatMapToDouble( l -> l.stream().mapToDouble(Assignment::calculateGrade))
               .average()
               .getAsDouble();
    }

    private void calculateWeightedGrade() {
        weightedGrade = 0;
        assignmentTypes.stream()
                .mapToDouble((key) -> gradeWeights.get(key).doubleValue() * assignments.get(key)
                                                                        .stream()
                                                                        .mapToDouble(Assignment::calculateGrade)
                                                                        .average()
                                                                        .getAsDouble())
                .sum();
    }

    public double getUnweightedGrade() {
        return unweightedGrade;
    }

}