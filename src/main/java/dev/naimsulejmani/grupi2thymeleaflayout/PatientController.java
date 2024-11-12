package dev.naimsulejmani.grupi2thymeleaflayout;

import dev.naimsulejmani.grupi2thymeleaflayout.models.Patient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
//http://localhost:8080/patients
@RequestMapping("/patients")
public class PatientController {
    private List<Patient> patients = new ArrayList<>();

    public PatientController() {
        patients.add(new Patient("John", "Doe", "555-555-5551", "123 Main St", true));
        patients.add(new Patient("Jane", "Doe", "555-555-5552", "123 Main St", false));
        patients.add(new Patient("Bob", "Doe", "555-555-5553", "123 Main St", true));
    }

    /**
     * Show all patients.
     *
     * @param model Spring MVC model
     * @return view name
     */
    @GetMapping("")
    public String patients(Model model) {
        model.addAttribute("patients", patients);
        model.addAttribute("number", new Random().nextInt(4));
        String[] array = {"student", "teacher", "doctor", "nurse"};
        model.addAttribute("name", array[new Random().nextInt(array.length)]);
        model.addAttribute("array", array);
        return "patients";
    }

    @GetMapping("/1")
    public ModelAndView patient1(ModelAndView mav) {

        mav.setViewName("patient");//emri i HTML (patient.html)
        mav.addObject("patient", patients.get(0));//objekti qe do te shfaqet ne HTML


        return mav;
    }

}










