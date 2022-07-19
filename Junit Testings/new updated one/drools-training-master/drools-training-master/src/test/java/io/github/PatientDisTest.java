package io.github;

import model.Patient;
import model.PatientDisease;
import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieSession;

import java.time.LocalDate;


public class PatientDisTest {
    @Test
    public void testPatient() {
        PatientDisease patientDisease = new PatientDisease();
        PatientTester patienttest = new PatientTester();
        KieSession ksession = KieServices.Factory.get().getKieClasspathContainer().newKieSession("diseaserules");
        for (int tid : patienttest.map.keySet()) {
            for (Patient p : patienttest.map.get(tid).pt) {
                ksession.insert(p);
            }
            ksession.insert(LocalDate.now());
            ksession.insert(patientDisease);
            ksession.fireAllRules();
            ksession.dispose();
            //validation(patientDisease, patienttest.map.get(tid));
        }


    }

    /*static void validation(PatientDisease pd, Patientd pt) {
        //System.out.println(pt.pt);
        int count = 0;
        int countmultiple=0;
        for (Patient patient : pd.getMaplist().keySet()) {
            assert (pt.disease.containsAll(pd.getMaplist().get(patient)));
            if (patient.getPreFill() != null) {
                if (patient.getPreFill().equals("Y")) {
                    count++;
                }
            }

            if (patient.getMultiple()!=null) {
                if (patient.getMultiple().equals("Y")) {
                    countmultiple++;
                }
            }
            if (patient.getRisk()!=null){
                assert (pt.risks.containsAll(patient.getRisk()));
            }
        }
        assert(count==pt.prefill.size());
        assert(countmultiple==pt.multiple.size());
        }*/


}
        /*for (Patient p1 : pd.getMaplist().keySet()) {
            System.out.print("patient with id " + p1.getId() + " has disease ");
            System.out.println(pd.getMaplist().get(p1));
            System.out.println("Prefill value: " + p1.getPreFill());
            System.out.println("Multiple value: " + p1.getMultiple());
            System.out.println("Multiple Risk prefill: " + p1.getMultipleG());
            System.out.println("Risk Factor: " + p1.getRisk());
        }}}*/






