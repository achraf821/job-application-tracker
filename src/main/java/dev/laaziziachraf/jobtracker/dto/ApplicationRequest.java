package dev.laaziziachraf.jobtracker.dto;

import dev.laaziziachraf.jobtracker.model.ApplicationStatus;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;

public record ApplicationRequest(
        @NotBlank(message = "L'entreprise est obligatoire")
        String company,

        @NotBlank(message = "Le poste est obligatoire")
        String position,

        ApplicationStatus status,
        LocalDate appliedAt,
        String notes
) {}