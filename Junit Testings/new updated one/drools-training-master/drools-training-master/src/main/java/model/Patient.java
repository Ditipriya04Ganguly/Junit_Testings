package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Patient {

    private int id;
    private String ICD10;
    private String status;
    private LocalDate timeframe;
    private String preFill;

    private String multiple;

    private Set<String> risk= new HashSet<>();

    private String multipleG;

    private LocalDate dob;

    private String race;

    private String gender;

    private String smokingStatus;

    public Patient(int id, String ICD10, String status, LocalDate timeframe, LocalDate dob) {
        this.id = id;
        this.ICD10 = ICD10;
        this.status = status;
        this.timeframe = timeframe;
        this.dob = dob;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getICD10() {
        return ICD10;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getTimeframe() {
        return timeframe;
    }


    public void setICD10(String ICD10) {
        this.ICD10 = ICD10;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTimeframe(LocalDate timeframe) {
        this.timeframe = timeframe;
    }

    public String getMultiple() {
        return multiple;
    }

    public void setMultiple(String multiple) {
        this.multiple = multiple;
    }


    public String getPreFill() {
        return preFill;
    }

    public void setPreFill(String preFill) {
        this.preFill = preFill;
    }

    public Set<String> getRisk() {
        return risk;
    }

    public void setRisk(Set<String> risk) {
        this.risk = risk;
    }

    public String getMultipleG() {
        return multipleG;
    }

    public void setMultipleG(String multipleG) {
        this.multipleG = multipleG;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getSmokingStatus() {
        return smokingStatus;
    }

    public void setSmokingStatus(String smokingStatus) {
        this.smokingStatus = smokingStatus;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return id == patient.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", ICD10='" + ICD10 + '\'' +
                ", status='" + status + '\'' +
                ", timeframe=" + timeframe +
                ", preFill='" + preFill + '\'' +
                '}';
    }

    public void addRisk(String risk){
        Set<String> r= new HashSet<>();
        if (this.risk.isEmpty()){
            this.risk.add(risk);
        }
        else{
            r=getRisk();
            r.add(risk);
            this.risk=r;
        }
    }
}
