package com.example.systems_management.controllers;

import com.example.systems_management.entities.Device;
import com.example.systems_management.entities.InspectionCompany;
import com.example.systems_management.service.DeviceService;
import com.example.systems_management.service.InspectionCompanyService;
import com.example.systems_management.service.InspectionService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/manager")
public class DeviceController {
    private final DeviceService deviceService;
    private final InspectionCompanyService inspCompService;
    private final InspectionService inspService;

    public DeviceController(DeviceService deviceService, InspectionCompanyService inspCompService, InspectionService inspService) {
        this.deviceService = deviceService;
        this.inspCompService = inspCompService;
        this.inspService = inspService;
    }

    @ModelAttribute("inspection_companies")
    public List<InspectionCompany> inspCompanies() {
        return inspCompService.getAllInspCompanies();
    }

    @GetMapping("/all")
    public String showDevices(Model m) {
        List<Device> devices = deviceService.getDevices();
        m.addAttribute("devices", devices);
        return "device/list";
    }

    @GetMapping("/admin/form")
    public String crateDeviceForm(Model m) {
        Device device = new Device();
        m.addAttribute("device", device);
        return "device/form";
    }

    @PostMapping("/admin/form")
    public String createDevice (@ModelAttribute("device") Device device) {
        deviceService.add(device);
        return "redirect:/manager/all";
    }

    @GetMapping("/admin/edit")
    public String editDevice(Model m, @RequestParam(name = "deviceId") Long id) {
        Device device = deviceService.getDeviceById(id);
        m.addAttribute("device", device);
        return "device/form";
    }

    @PostMapping("/admin/edit")
    public String updateDevice(@ModelAttribute Device device) {
        deviceService.save(device);
        return "redirect:/manager/all";
    }

    @GetMapping("/admin/delete/confirm")
    public String confirmDelete(Model m, @RequestParam(name = "deviceId") Long id) {
        m.addAttribute("object", deviceService.getDeviceById(id));
        m.addAttribute("href", "/manager/admin/delete?deviceId=" + id);
        m.addAttribute("pageName", "Device");
        return "confirmation/confirm";
    }

    @GetMapping("/admin/delete")
    public String delete(@RequestParam(name = "deviceId") Long id) {
        deviceService.delete(id);
        return "redirect:/manager/all";
    }

}
