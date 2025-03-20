package nerea.protrainer.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Nerea
 */
public class Workouts {

    private int id;
    private String forDate;
    private String comments;
    private int userId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getForDate() {
        if (forDate == null || forDate.isEmpty()) {
            return "";
        }

        SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat outputDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        try {
            Date date = inputDateFormat.parse(forDate);
            return outputDateFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return forDate;
        }
    }

    public void setForDate(String forDate) {
        this.forDate = forDate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return this.userId;
    }
    
    @Override
    public String toString(){
        return getForDate() + " " + getComments();
    }
    
}
