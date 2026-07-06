package dev.laaziziachraf.jobtracker.service;

import dev.laaziziachraf.jobtracker.model.Application;
import dev.laaziziachraf.jobtracker.repository.ApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {

    private final ApplicationRepository repository;

    public ApplicationService(ApplicationRepository repository) {
        this.repository = repository;
    }

    public List<Application> findAll() {
        return repository.findAll();
    }

    public Application findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Candidature introuvable : id=" + id));
    }

    public Application create(Application application) {
        return repository.save(application);
    }

    public Application update(Long id, Application updated) {
        Application existing = findById(id);
        existing.setCompany(updated.getCompany());
        existing.setPosition(updated.getPosition());
        existing.setStatus(updated.getStatus());
        existing.setAppliedAt(updated.getAppliedAt());
        existing.setNotes(updated.getNotes());
        return repository.save(existing);
    }

    public void delete(Long id) {
        findById(id);  // vérifie l'existence, sinon exception
        repository.deleteById(id);
    }
}