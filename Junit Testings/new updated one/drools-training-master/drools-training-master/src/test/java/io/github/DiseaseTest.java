package io.github;

import model.Patient;
import model.PatientDisease;
import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieSession;

import java.time.LocalDate;

public class DiseaseTest {


    /*@Test
    public void testForIcd()
    {
        KieSession ksession=KieServices.Factory.get().getKieClasspathContainer().newKieSession("diseaserules");
        Patient p= new Patient(1,"R13.1", "Active", LocalDate.of(2022,06,30) );
        PatientDisease patientDisease= new PatientDisease();
        ksession.insert(p);
        ksession.insert(patientDisease);
        ksession.fireAllRules();
        ksession.dispose();
        assert(patientDisease.getMaplist().get(p).contains("Dysphagia"));
    }

    @Test
    public void testForGerd()
    {
        Patient p= new Patient(2,"K21.0", "Active", LocalDate.of(2022,06,30) );
        PatientDisease patientDisease= new PatientDisease();
        KieSession ksession=KieServices.Factory.get().getKieClasspathContainer().newKieSession("diseaserules");
        ksession.insert(p);
        ksession.insert(patientDisease);
        ksession.fireAllRules();
        ksession.dispose();
        assert(patientDisease.getMaplist().get(p).contains("GERD"));

    }*/







}
