package dev.naimsulejmani.grupi2thymeleaflayout;

import dev.naimsulejmani.grupi2thymeleaflayout.models.Doctor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
//http://localhost:8080/doctors
@RequestMapping("/doctors")
public class DoctorController {
    private static int generateId = 0;
    private final List<Doctor> doctors = new ArrayList<>();

    public DoctorController() {
        doctors.add(new Doctor(1, "John", "Doe", "555-555-5551", "123 Main St", "Cardiologist"));
        doctors.add(new Doctor(2, "Jane", "Doe", "555-555-5552", "123 Main St", "Dermatologist"));
        doctors.add(new Doctor(3, "Bob", "Doe", "555-555-5553", "123 Main St", "Neurologist"));
        generateId = 3;
    }

    //    @RequestMapping(value = "", method = RequestMethod.GET)
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
        return "doctors/list";
    }

    //http://localhost:8080/doctors/1
    //http://localhost:8080/doctors/1123
    //http://localhost:8080/doctors/naim
    @GetMapping("/{id}/details")
    public String getDoctor(Model model, @PathVariable("id") int id) {
        var doctor = doctors.stream()
                .filter(d -> d.getId() == id)
                .findFirst()
                .orElse(null);
        model.addAttribute("doctor", doctor);
        return "doctors/details";
    }

//    public Doctor getDoctorById(int id) {
//        Doctor doctor = null;
//        for(Doctor doc: doctors) {
//            if(doc.getId()==id) {
//                doctor = doc;
//                break;
//            }
//        }
//        return doctor;
//    }

    @GetMapping("/{id}/edit")
    public String editDoctor(Model model, @PathVariable("id") int id) {
        var doctor = doctors.stream()
                .filter(d -> d.getId() == id)
                .findFirst()
                .orElse(null);
        model.addAttribute("doctor", doctor);
        return "doctors/edit";
    }

    //http://localhost:8080/doctors/1/delete
    @GetMapping("/{id}/delete")
    public String deleteDoctor(Model model, @PathVariable("id") int id) {
        // JAVA Stream API
        var doctor = doctors.stream()
                .filter(d -> d.getId() == id)
                .findFirst()
                .orElse(null);
        model.addAttribute("doctor", doctor);
        return "doctors/delete";
    }

    @GetMapping("/new")
    public String newDoctor(Model model) {
        model.addAttribute("doctor", new Doctor());
        return "doctors/new";
    }

    @PostMapping("/new")
    public String newDoctor(@ModelAttribute Doctor doctor) {
        doctor.setId(++generateId);
        doctors.add(doctor);
        return "redirect:/doctors";
    }

}











