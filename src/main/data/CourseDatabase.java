/*
 * Course: N/A
 * N/A 2020
 * Lab N/A - N/A
 * Name: SamzF
 * Created: 12/8/2020
 */
package main.data;

import main.data.models.Course;

import java.util.List;

/**
 * Course: N/A
 * N/A 2020
 * CourseList purpose: Contains All Courses that are being managed with this application
 *
 * @author SamzF
 * @version created on 12/8/2020 at 11:45 AM
 */
public class CourseDatabase {
    private List<Course> courseList;
    private static CourseDatabase instance;

    private CourseDatabase() {
        importData();
    }

    public static CourseDatabase instance() {
        if(instance == null) {
            instance = new CourseDatabase();
        }
        return instance;
    }

    public static void close() {
        if(instance != null) {
            instance.exportData();
            instance = null;
        }
    }


    private void importData() {

    }

    private void exportData() {

    }
}