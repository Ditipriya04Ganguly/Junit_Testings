package io.github;


import model.Patient;
import model.PatientDisease;
import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieSession;

import java.time.LocalDate;
import java.util.*;

public class PatientTester {
    static Map<Integer,Patientd> map= new HashMap<>();

    static  {

        map.put(1,new Patientd(Arrays.asList(
                new Patient(1,"R13.1", "Active",LocalDate.of(2022,06,30), LocalDate.of(2000,9,04))),
                new MapCreator(Arrays.asList(new Pair(1, new HashSet<String>(Arrays.asList("Dysphagia"))))),
                new MapCreator(Arrays.asList(new Pair(1, new HashSet<String>())))));

        map.put(2,new Patientd(Arrays.asList(
                new Patient(2,"R63.4", "Active",LocalDate.of(2022,06,30), LocalDate.of(2000,9,04))),
                new MapCreator(Arrays.asList(new Pair(2, new HashSet<String>(Arrays.asList("Weight Loss"))))),
                new MapCreator(Arrays.asList(new Pair(2, new HashSet<String>())))));

        map.put(3,new Patientd(Arrays.asList(
                new Patient(3,"K21.0", "Active",LocalDate.of(2022,06,30), LocalDate.of(2000,9,04)),
                new Patient(3,"K40", "Active",LocalDate.of(2022,06,30), LocalDate.of(2000,9,04))),
                new MapCreator(Arrays.asList(new Pair(3, new HashSet<String>(Arrays.asList("GERD"))))),
                new MapCreator(Arrays.asList(new Pair(3, new HashSet<String>(Arrays.asList("Hiatal Hernia")))))));
    }

    @Test
    public void testForPatientDisease() {
        PatientTester pt= new PatientTester();
        PatientDisease patientDisease = new PatientDisease();
        KieSession kieSession = KieServices.Factory.get().getKieClasspathContainer().newKieSession("diseaserules");
        for (int tid : map.keySet()) {
            for(Patient p:map.get(tid).pt) {
                kieSession.insert(p);
            }
        }
        kieSession.insert(LocalDate.now());
        kieSession.insert(patientDisease);
        kieSession.fireAllRules();
        kieSession.dispose();
        for(int tid:map.keySet())
        {
            pt.validatorDisease(patientDisease, map.get(tid).dismp, map.get(tid).riskmp);
        }

    }

    public void validatorDisease(PatientDisease pd,MapCreator disease, MapCreator risk){

                  for(int pid:disease.map.keySet())
                  {
                      assert (pd.getMaplist().get(pd.getPatient(pid)).equals(disease.map.get(pid)));

                  }

                  for(int pid:risk.map.keySet())
                  {
                       assert (pd.getPatient(pid).getRisk().equals(risk.map.get(pid)));

                  }
    }
}
