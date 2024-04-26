package com.example.systems_management.controllers;

import com.example.systems_management.entities.Device;
import com.example.systems_management.entities.InspectionCompany;
import com.example.systems_management.entities.Technician;
import com.example.systems_management.service.DeviceService;
import com.example.systems_management.service.InspectionCompanyService;
import com.example.systems_management.service.TechnicianService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/company")

public class InspectionCompanyController {

    private final InspectionCompanyService inspCompService;
    private final TechnicianService technicianService;
    private final DeviceService deviceService;

    public InspectionCompanyController(InspectionCompanyService inspCompService, TechnicianService technicianService, DeviceService deviceService) {
        this.inspCompService = inspCompService;
        this.technicianService = technicianService;
        this.deviceService = deviceService;
    }

    @GetMapping("/admin/form")
    public String addInspectionCompanyForm(Model m) {
        InspectionCompany inspectionCompany = new InspectionCompany();
        m.addAttribute("inspComp", inspectionCompany);
        return "inspectionCompany/form";
    }

    @PostMapping("/admin/form")
    public String addInspectionCompany(@ModelAttribute(name="inspComp") InspectionCompany inspectionCompany) {
        inspCompService.add(inspectionCompany);
        return "redirect:/manager/all";
    }

    @GetMapping("/list")
    public String inspectionCompanyDetails(Model m, @RequestParam(name = "inspectionCompanyId") Long id) {
        List<Technician> technicians = technicianService.getTechniciansByInspCompId(id);
        List<Device> devices = deviceService.getDevicesByInspCompId(id);
        InspectionCompany inspectionCompany = inspCompService.readById(id);

        m.addAttribute("inspectionCompany", inspectionCompany);
        m.addAttribute("technicians", technicians);
        m.addAttribute("devices", devices);
        return "inspectionCompany/list";
    }

}
