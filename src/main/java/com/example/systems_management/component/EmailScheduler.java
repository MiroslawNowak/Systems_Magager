package com.example.systems_management.component;

import com.example.systems_management.entities.Inspection;
import com.example.systems_management.service.InspectionService;
import com.example.systems_management.service.email.EmailService;
import jakarta.mail.MessagingException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.List;

@Component
public class EmailScheduler {

    private final InspectionService inspectionService;
    private final EmailService emailService;

    public EmailScheduler(InspectionService inspectionService, EmailService emailService) {
        this.inspectionService = inspectionService;
        this.emailService = emailService;
    }

    @Scheduled(fixedDelay = 86399999)
    public void scheduleEmailSending() throws MessagingException {
        LocalDate dateNow = LocalDate.now();
        List<Inspection> inspections = inspectionService.findAll();
        for(Inspection inspection : inspections) {
            long daysDifference = dateNow.until(inspection.getInspectionDate().toLocalDate()).getDays();
            if (daysDifference == 15) {
                System.out.println("wysłano wiadomość");
                emailService.sendMail(
                    inspection.getInspectionEmail(),
                    "Nadchodzący przegląd okresowy",
                      "<b>Użytkowniku! </b><br><b>Zbliża się przegląd okresowy urządzenia: " +
                            inspection.getDevice().getName() + "<br>" +
                            "<b>Data przeglądu: " + inspection.getInspectionDate() + "<b>",
                    true
                );
            }
        }
    }
}
