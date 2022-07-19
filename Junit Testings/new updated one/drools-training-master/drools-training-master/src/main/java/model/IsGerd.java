package model;

import java.util.HashMap;
import java.util.Objects;

public class IsGerd {
    private Patient patient;

    public IsGerd(Patient patient) {
        this.patient = patient;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "IsGerd{" +
                "patient=" + patient +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IsGerd)) return false;
        IsGerd isGerd = (IsGerd) o;
        return patient.equals(isGerd.patient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patient);
    }

    public boolean checkGerd(Patient p){
       return this.patient.getId()== p.getId();
    }
}
