package com.example.systems_management.controllers;

import com.example.systems_management.entities.Device;
import com.example.systems_management.entities.Inspection;
import com.example.systems_management.service.DeviceService;
import com.example.systems_management.service.InspectionService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/inspection")
public class InspectionController {

    private final InspectionService inspService;
    private final DeviceService deviceService;

    public InspectionController(InspectionService inspService, DeviceService deviceService) {
        this.inspService = inspService;
        this.deviceService = deviceService;
    }

    @ModelAttribute("devices")
    public List<Device> devices() {
        return deviceService.getDevices();
    }

    @GetMapping("/admin/form")
    public String createDateForm(Model m) {
        Inspection inspection = new Inspection();
        m.addAttribute("inspection", inspection);
        return "inspDate/form";
    }

    @PostMapping("/admin/form")
    public String createDate(@Valid @ModelAttribute(name = "inspection") Inspection inspection, BindingResult br) {
        if (br.hasErrors()) {
            return "/inspDate/form";
        }
        inspService.save(inspection);
        return "redirect:/manager/all";
    }

    @GetMapping("/list")
    public String listOfInspections(Model m, @RequestParam(name = "deviceId") Long id) {
        List<Inspection> inspections = inspService.getAllByDeviceId(id);
        m.addAttribute("inspections", inspections);
        return "inspDate/list";
    }
}
