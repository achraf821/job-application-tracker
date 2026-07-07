package dev.laaziziachraf.jobtracker.service;

import dev.laaziziachraf.jobtracker.dto.ApplicationRequest;
import dev.laaziziachraf.jobtracker.exception.NotFoundException;
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
                .orElseThrow(() -> new NotFoundException(
                        "Candidature introuvable : id=" + id));
    }

    public Application create(ApplicationRequest request) {
        Application application = new Application(request.company(), request.position());
        if (request.status() != null) {
            application.setStatus(request.status());
        }
        application.setAppliedAt(request.appliedAt());
        application.setNotes(request.notes());
        return repository.save(application);
    }

    public Application update(Long id, ApplicationRequest request) {
        Application existing = findById(id);
        existing.setCompany(request.company());
        existing.setPosition(request.position());
        if (request.status() != null) {
            existing.setStatus(request.status());
        }
        existing.setAppliedAt(request.appliedAt());
        existing.setNotes(request.notes());
        return repository.save(existing);
    }

    public void delete(Long id) {
        findById(id);  // vérifie l'existence, sinon exception
        repository.deleteById(id);
    }
}