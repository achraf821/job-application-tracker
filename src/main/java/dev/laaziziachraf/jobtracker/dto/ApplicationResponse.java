package dev.laaziziachraf.jobtracker.dto;

import dev.laaziziachraf.jobtracker.model.Application;
import dev.laaziziachraf.jobtracker.model.ApplicationStatus;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record ApplicationResponse(
        Long id,
        String company,
        String position,
        ApplicationStatus status,
        LocalDate appliedAt,
        String notes,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static ApplicationResponse from(Application app) {
        return new ApplicationResponse(
                app.getId(),
                app.getCompany(),
                app.getPosition(),
                app.getStatus(),
                app.getAppliedAt(),
                app.getNotes(),
                app.getCreatedAt(),
                app.getUpdatedAt()
        );
    }
}