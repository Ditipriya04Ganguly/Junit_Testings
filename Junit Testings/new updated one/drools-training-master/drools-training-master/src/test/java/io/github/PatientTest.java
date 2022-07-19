package io.github;

import model.Patient;
import model.PatientDisease;
import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieSession;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class PatientTest {
    List<Patient> patientDetails= new ArrayList<>();
    List<String> diseaseoutput= new ArrayList<>();
    List<String> prefill= new ArrayList<>();
    List<String> multiple= new ArrayList<>();
    List<String> multiplerisks= new ArrayList<>();
    List<String> risks= new ArrayList<>();

    public PatientTest(){
        patientDetails.add(new Patient(1,"R13.1", "Active",LocalDate.of(2022,06,30), LocalDate.of(2000,9,04)));
        patientDetails.add(new Patient(3,"R63.4", "Active",LocalDate.of(2022,05,30), LocalDate.of(1980,9,8)));
        patientDetails.add(new Patient(3,"K2", "Active",LocalDate.of(2022,04,30), LocalDate.of(1972,9,23)));
        patientDetails.add(new Patient(3,"K40", "Active",LocalDate.of(2022,04,01), LocalDate.of(1972,9,23)));

    }

    public void setDiseaseoutput(){
        diseaseoutput.add("Dysphagia"); diseaseoutput.add("Weight Loss"); diseaseoutput.add("GERD");
        prefill.add("Y");  prefill.add("Y");
        //risks.add("Hiatal Hernia");
        //multiple.add("Y");


    }


    @Test
    public void testForICD()
    {   int count=0;
        int countmultiple=0;
        PatientTest pt= new PatientTest();
        pt.setDiseaseoutput();
        PatientDisease patientDisease= new PatientDisease();
        KieSession ksession= KieServices.Factory.get().getKieClasspathContainer().newKieSession("diseaserules");
        for (Patient p:pt.patientDetails){
            ksession.insert(p);
        }

        ksession.insert(LocalDate.now());
        ksession.insert(patientDisease);
        ksession.fireAllRules();
        ksession.dispose();



        for (Patient patient:patientDisease.getMaplist().keySet()){
            assert (pt.diseaseoutput.containsAll(patientDisease.getMaplist().get(patient)));
            if (patient.getPreFill()!=null) {
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

        for(Patient p1: patientDisease.getMaplist().keySet())
        {
            System.out.print("patient with id "+p1.getId()+" has disease ");
            System.out.println(patientDisease.getMaplist().get(p1));
            System.out.println("Prefill value: "+ p1.getPreFill());
            System.out.println("Multiple value: "+p1.getMultiple());
            System.out.println("Multiple Risk prefill: "+p1.getMultipleG());
            System.out.println("Risk Factor: "+p1.getRisk());
        }

    }


}
