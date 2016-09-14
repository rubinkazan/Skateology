package Skate.Logic;

import javafx.beans.property.*;

public class TableLog {
    private final StringProperty date;
    private final StringProperty time;
    private final StringProperty sessionType;
    private final StringProperty trickName;
    private final DoubleProperty successRate;


    public TableLog(String date, String time, String sessionType, String trickName, Double successRate){
        this.date = new SimpleStringProperty(date);
        this.time = new SimpleStringProperty(time);
        this.sessionType = new SimpleStringProperty(sessionType);
        this.trickName = new SimpleStringProperty(trickName);
        this.successRate = new SimpleDoubleProperty(successRate);
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

    public String getTrickName() {
        return trickName.get();
    }

    public StringProperty trickNameProperty() {
        return trickName;
    }

    public void setTrickName(String trickName) {
        this.trickName.set(trickName);
    }

    public double getSuccessRate() {
        return successRate.get();
    }

    public DoubleProperty successRateProperty() {
        return successRate;
    }

    public void setSuccessRate(double successRate) {
        this.successRate.set(successRate);
    }

}
