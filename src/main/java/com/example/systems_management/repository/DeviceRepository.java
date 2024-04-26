package com.example.systems_management.repository;

import com.example.systems_management.entities.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {

    List<Device> getDevicesByInspectionCompanyId(Long id);

    Device getDevicesById(Long id);

}
