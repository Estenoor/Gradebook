/*
 * Course:
 *  2020
 * Lab  -
 * Name: SamzF
 * Created: 12/8/2020
 */
package main.data.models;

/**
 * Course:
 * 2020
 * Assignment purpose: Contains all pertinent information about an assignment and it's grade
 *
 * @author SamzF
 * @version created on 12/8/2020 at 11:50 AM
 */
public class Assignment {
    private String name;
    private String type;
    private double earnedPoints;
    private double possiblePoints;


    public Assignment(String name, String type, double possiblePoints) {
        this.name = name;
        this.type = type;
        this.earnedPoints = 0;
        this.possiblePoints = possiblePoints;
    }

    public double getAssignmentGrade() {
        return (earnedPoints / possiblePoints);
    }

    public String getName() {
        return name;
    }

    public String gettype() {
        return type;
    }
}