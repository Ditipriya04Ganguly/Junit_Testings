package DiseaseTest;


import model.Patient;
import model.PatientDisease;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieSession;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class DTest {
    public static void main(String[] args){
        try {
            KieSession ksession = KieServices.Factory.get().getKieClasspathContainer().newKieSession("diseaserules");
            Set<String> ICD10= new HashSet<>();


//
//            Set<String> icdcode= new HashSet<String>();
//            icdcode.add("R13.1");
//            icdcode.add("R63.4");


            /*Patient p= new Patient(1,"R13.1", "Active", LocalDate.of(2022,06,30) );
            Patient p3= new Patient(1,"R63.4", "Active", LocalDate.of(2022,06,30) );
            Patient pp1= new Patient(2, "E46", "Active", LocalDate.of(2021, 05,01));
            Patient pp2= new Patient(3,"E46","inactive", LocalDate.of(2022,04,01));
            Patient pp3= new Patient(4,"E11","Active", LocalDate.of(2022,03,10));
            Patient pp6= new Patient(6,"K21.0","Active", LocalDate.of(2022,03,10));
            Patient pp4= new Patient(6,"K40","Active", LocalDate.of(2022,02,25));
            Patient pp5= new Patient(6,"E66.9","Active", LocalDate.of(2022,02,25));
            Patient pp8= new Patient(7,"K40","Active", LocalDate.of(2022,02,25));
            Patient pp9= new Patient(7,"K21.9","Active", LocalDate.of(2022,02,25));

            Patient pp10= new Patient(9,"Z72.0","Active", LocalDate.of(2022,02,25));*/

            //Patient p= new Patient(1,"K21.0", "Active", LocalDate.of(2022,06,30),LocalDate.of(1960,06,16));
            //Patient pe1= new Patient(1,"E66.9", "Active", LocalDate.of(2022,06,30),LocalDate.of(1960,06,16));
            Patient pp= new Patient(3,"R13.1", "Active", LocalDate.of(2021,06,30),LocalDate.of(1960,06,22));
            Patient pp1= new Patient(3,"K21.0", "Active", LocalDate.of(2022,06,30),LocalDate.of(1960,06,22));
            //Patient pp2= new Patient(3,"K40", "Active", LocalDate.of(2022,06,30),LocalDate.of(1960,06,22));
            //Patient pp3= new Patient(3,"K66.9", "Active", LocalDate.of(2022,06,30),LocalDate.of(1960,06,22));






            //pp10.setSmokingStatus("Positive");




            PatientDisease patientDisease= new PatientDisease();

            ksession.insert(pp);
            ksession.insert(pp1);
            //ksession.insert(pp1);
            //ksession.insert(pp2);
            //ksession.insert(pp3);
            /*ksession.insert(p3);
            ksession.insert(pp1);
            ksession.insert(pp2);
            ksession.insert(pp3);
            ksession.insert(pp4);
            ksession.insert(pp5);
            ksession.insert(pp6);
            ksession.insert(pp8);
            ksession.insert(pp9);
            ksession.insert(pp10);*/
            //ksession.insert(pe1);
            //ksession.insert(pp);
            ksession.insert(LocalDate.now());
            ksession.insert(patientDisease);
            ksession.fireAllRules();
            ksession.dispose();
            //System.out.println(p);

            for(Patient p1: patientDisease.getMaplist().keySet())
            {
                System.out.print("patient with id "+p1.getId()+" has disease ");
                System.out.println(patientDisease.getMaplist().get(p1));
                System.out.println("Prefill value: "+ p1.getPreFill());
                System.out.println("Multiple value: "+p1.getMultiple());
                System.out.println("Multiple Risk prefill: "+p1.getMultipleG());
                System.out.println("Risk Factor: "+p1.getRisk());
            }



        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

}

