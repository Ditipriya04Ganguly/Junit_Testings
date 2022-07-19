package io.github;

import model.Patient;

import java.util.*;

public class Patientd {
    List<Patient> pt;
    MapCreator dismp;
    MapCreator riskmp;


    public Patientd(List<Patient> pt, MapCreator dismp, MapCreator riskmp) {
        this.pt = pt;
        this.dismp = dismp;
        this.riskmp = riskmp;
    }
}
