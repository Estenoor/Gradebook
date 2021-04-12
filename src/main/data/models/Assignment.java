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
    private final int id;
    private String name;
    private String type;
    private double earnedPoints;
    private double possiblePoints;
    private static int nextID = 0;

    public Assignment(String name, String type, double possiblePoints) {
        this.id = nextID;
        this.nextID++;
        this.name = name;
        this.type = type;
        this.earnedPoints = 0;
        this.possiblePoints = possiblePoints;
    }

    public Assignment(int id, String name, String type, double earnedPoints, double possiblePoints) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.earnedPoints = earnedPoints;
        this.possiblePoints = possiblePoints;
    }

    public int getID() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getEarnedPoints() {
        return earnedPoints;
    }

    public void setEarnedPoints(double earnedPoints) {
        this.earnedPoints = earnedPoints;
    }

    public double getPossiblePoints() {
        return possiblePoints;
    }

    public void setPossiblePoints(double possiblePoints) {
        this.possiblePoints = possiblePoints;
    }

    public double calculateGrade() {
        return this.earnedPoints / this.possiblePoints;
    }

    public boolean equals(Assignment a) {
        return this.id == a.getID();
    }
}