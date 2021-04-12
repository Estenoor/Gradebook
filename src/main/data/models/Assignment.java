/*
 * Course:
 *  2020
 * Lab  -
 * Name: SamzF
 * Created: 12/8/2020
 */
package main.data.models;

import org.json.simple.JSONObject;

import java.util.UUID;

/**
 * Course:
 * 2020
 * Assignment purpose: Contains all pertinent information about an assignment and it's grade
 *
 * @author SamzF
 * @version created on 12/8/2020 at 11:50 AM
 */
public class Assignment {
    private final UUID id;
    private String name;
    private String type;
    private double earnedPoints;
    private double possiblePoints;

    public Assignment(String name, String type, double possiblePoints) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.type = type;
        this.earnedPoints = 0;
        this.possiblePoints = possiblePoints;
    }

    public Assignment(UUID id, String name, String type, double earnedPoints, double possiblePoints) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.earnedPoints = earnedPoints;
        this.possiblePoints = possiblePoints;
    }

    public UUID getID() {
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

    public JSONObject toJSONObject() {
        JSONObject output = new JSONObject();
        output.put("ID", this.id.toString());
        output.put("Name", this.name);
        output.put("Type", this.type);
        output.put("earnedPoints", this.earnedPoints);
        output.put("possiblePoints", this.possiblePoints);
        return output;
    }

    public static Assignment fromJSONObject(JSONObject o) {
        UUID tempID = UUID.fromString((String)o.get("ID"));
        String tempName = (String)o.get("Name");
        String tempType = (String)o.get("Type");
        double earnedPoints = ((Number)o.get("earnedPoints")).doubleValue();
        double possiblePoints = ((Number)o.get("possiblePoints")).doubleValue();
        return new Assignment(tempID, tempName, tempType, earnedPoints, possiblePoints);
    }
}