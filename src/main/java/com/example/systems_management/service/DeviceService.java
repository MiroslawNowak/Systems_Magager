package com.example.systems_management.service;

import com.example.systems_management.entities.Device;
import com.example.systems_management.repository.DeviceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DeviceService {
    private final DeviceRepository deviceRepository;
    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public List<Device> getDevices() {
        return deviceRepository.findAll();
    }

    public List<Device> getDevicesByInspCompId(Long id) {
        return deviceRepository.getDevicesByInspectionCompanyId(id);
    }

    public Optional<Device> get(Long id) {
        return deviceRepository.findById(id);
    }

    public Device getDeviceById(Long id) {
        return deviceRepository.getDevicesById(id);
    }

    public void add(Device device) {
    deviceRepository.save(device);
    }

    public void delete(Long id) {
    deviceRepository.deleteById(id);
    }

    public void update(Device device) {
    deviceRepository.save(device);
    }

    public void save(Device device) {
        deviceRepository.save(device);
    }
}
