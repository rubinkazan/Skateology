package Skate.Logic;

import javafx.beans.property.*;

import java.util.Date;

public class Session {
    private final StringProperty date;
    private final StringProperty time;
    private final StringProperty trickName;
    private final StringProperty sessionType;
    private final IntegerProperty sets;
    private final IntegerProperty reps;
    private final IntegerProperty landed;



    public Session(String date, String time, String sessionType, String trickName, int sets, int reps, int landed) {
        this.date = new SimpleStringProperty(date);
        this.time = new SimpleStringProperty(time);
        this.trickName = new SimpleStringProperty(trickName);
        this.sessionType = new SimpleStringProperty(sessionType);
        this.sets = new SimpleIntegerProperty(sets);
        this.reps = new SimpleIntegerProperty(reps);
        this.landed = new SimpleIntegerProperty(landed);
    }

    public String getTrickName() {
        return trickName.get();
    }

    public StringProperty trickProperty(){
        return trickName;
    }

    public void setTrickName(String trickName){
        this.trickName.set(trickName);
    }

    public String getDate() {
        return date.get();
    }

    public StringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public String getTime() {
        return time.get();
    }

    public StringProperty timeProperty() {
        return time;
    }

    public void setTime(String time) {
        this.time.set(time);
    }


    public String getSessionType() {
        return sessionType.get();
    }

    public StringProperty sessionTypeProperty() {
        return sessionType;
    }

    public void setSessionType(String sessionType) {
        this.sessionType.set(sessionType);
    }

    public int getReps() {
        return reps.get();
    }

    public IntegerProperty repsProperty() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps.set(reps);
    }

    public int getSets() {
        return sets.get();
    }

    public IntegerProperty setsProperty() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets.set(sets);
    }

    public int getLanded() {
        return landed.get();
    }

    public IntegerProperty landedProperty() {
        return landed;
    }

    public void setLanded(int landed) {
        this.landed.set(landed);
    }
}
