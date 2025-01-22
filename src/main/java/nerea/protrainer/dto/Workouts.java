package nerea.protrainer.dto;

import java.util.*;

/**
 * @author Nerea
 */
public class Workouts {

    private int id;
    private String ForDate;
    private String Comments;
    private int userId;
    private List<Exercicis> exercises;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getForDate() {
        return ForDate;
    }

    public void setForDate(String ForDate) {
        this.ForDate = ForDate;
    }

    public String getComments() {
        return Comments;
    }

    public void setComments(String Comments) {
        this.Comments = Comments;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return this.userId;
    }
}
