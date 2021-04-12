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
    private String name;
    private double unweightedGrade;
    private double weightedGrade;

    private List<String> assignmentTypes;
    private HashMap<String, Double> gradeWeights;
    private HashMap<String, List<Assignment>> assignments;

    public Course(String name) {
        this.name = name;
        this.unweightedGrade = 0;
        this.weightedGrade = 0;
        this.assignmentTypes = new ArrayList<String>();
        this.gradeWeights = new HashMap<>();
        this.assignments = new HashMap<>();
    }
}