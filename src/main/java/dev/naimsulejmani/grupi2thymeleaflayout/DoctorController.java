package dev.naimsulejmani.grupi2thymeleaflayout;

import dev.naimsulejmani.grupi2thymeleaflayout.models.Doctor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
//http://localhost:8080/doctors
@RequestMapping("/doctors")
public class DoctorController {

    private final List<Doctor> doctors = new ArrayList<>();

    public DoctorController() {
        doctors.add(new Doctor(1, "John", "Doe", "555-555-5551", "123 Main St", "Cardiologist"));
        doctors.add(new Doctor(2, "Jane", "Doe", "555-555-5552", "123 Main St", "Dermatologist"));
        doctors.add(new Doctor(3, "Bob", "Doe", "555-555-5553", "123 Main St", "Neurologist"));
    }

    @GetMapping("")
    public String findAllDoctors(Model model, @RequestParam(value = "search", required = false) String search) {

        model.addAttribute("search", search);

        if (search == null) {
            model.addAttribute("doctors", doctors);
        } else {
            var searchResult = doctors.stream()
                    .filter(doctor -> doctor.getName().trim().toLowerCase().contains(search.trim().toLowerCase()))
                    .toList();
            model.addAttribute("doctors", searchResult);
        }

        System.out.println("search = " + search);
        return "doctors";
    }

}











