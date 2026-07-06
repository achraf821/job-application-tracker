package dev.laaziziachraf.jobtracker.repository;

import dev.laaziziachraf.jobtracker.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
}