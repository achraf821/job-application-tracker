package dev.laaziziachraf.jobtracker.controller;

import jakarta.validation.Valid;
import dev.laaziziachraf.jobtracker.model.Application;
import dev.laaziziachraf.jobtracker.service.ApplicationService;
import org.springframework.http.HttpStatus;
import dev.laaziziachraf.jobtracker.dto.ApplicationRequest;
import dev.laaziziachraf.jobtracker.dto.ApplicationResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    private final ApplicationService service;

    public ApplicationController(ApplicationService service) {
        this.service = service;
    }

    @GetMapping
    public List<ApplicationResponse> findAll() {
        return service.findAll().stream()
                .map(ApplicationResponse::from)
                .toList();
    }

    @GetMapping("/{id}")
    public ApplicationResponse findById(@PathVariable Long id) {
        return ApplicationResponse.from(service.findById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApplicationResponse create(@Valid @RequestBody ApplicationRequest request) {
        return ApplicationResponse.from(service.create(request));
    }

    @PutMapping("/{id}")
    public ApplicationResponse update(@PathVariable Long id, @Valid @RequestBody ApplicationRequest request) {
        return ApplicationResponse.from(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}