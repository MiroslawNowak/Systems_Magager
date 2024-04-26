package com.example.systems_management.controllers;

import com.example.systems_management.entities.InspectionCompany;
import com.example.systems_management.entities.Technician;
import com.example.systems_management.service.InspectionCompanyService;
import com.example.systems_management.service.TechnicianService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/technician")
public class TechnicianController {

    private final TechnicianService technicianService;
    private final InspectionCompanyService inspCompService;

    public TechnicianController(TechnicianService technicianService, InspectionCompanyService inspCompService) {
        this.technicianService = technicianService;
        this.inspCompService = inspCompService;
    }

    @ModelAttribute("inspection_companies")
    public List<InspectionCompany> inspCompanies() {
        return inspCompService.getAllInspCompanies();
    }
    @GetMapping("/all")
    public String getAllTechnicians(Model m) {
        List<Technician> technicians = technicianService.getAllTechnicians();
        m.addAttribute("technicians", technicians);
        return "technician/list";
    }

    @GetMapping("/admin/form")
    public String createTechnicianForm(Model m) {
        Technician technician = new Technician();
        m.addAttribute("technician", technician);
        return "technician/form";
    }

    @PostMapping("/admin/form")
    public String createTechnician(@ModelAttribute(name="technician") Technician technician) {
        technicianService.save(technician);
        return "redirect:/technician/all";
    }
    @GetMapping("/admin/edit")
    public String editTechnician(Model m, @RequestParam(name = "technicianId") Long id) {
        Technician technician = technicianService.getTechnicianById(id);
        m.addAttribute("technician", technician);
        return "technician/form";
    }

    @PostMapping("/admin/edit")
    public String updateDevice(@ModelAttribute Technician technician) {
        technicianService.save(technician);
        return "redirect:/technician/all";
    }

    @GetMapping("/admin/delete/confirm")
    public String confirmDelete(Model m, @RequestParam(name = "technicianId") Long id) {
        m.addAttribute("object", technicianService.getTechnicianById(id));
        m.addAttribute("href", "/technician/admin/delete?technicianId=" + id);
        m.addAttribute("pageName", "Technician");
        return "confirmation/confirm";
    }

    @GetMapping("/admin/delete")
    public String delete(@RequestParam(name = "technicianId") Long id) {
        technicianService.delete(id);
        return "redirect:/technician/all";
    }
}
