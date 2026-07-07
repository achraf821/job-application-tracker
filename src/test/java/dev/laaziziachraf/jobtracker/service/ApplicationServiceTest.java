package dev.laaziziachraf.jobtracker.service;

import dev.laaziziachraf.jobtracker.exception.NotFoundException;
import dev.laaziziachraf.jobtracker.model.Application;
import dev.laaziziachraf.jobtracker.repository.ApplicationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ApplicationServiceTest {

    @Mock
    private ApplicationRepository repository;

    @InjectMocks
    private ApplicationService service;

    @Test
    void findById_retourne_la_candidature_quand_elle_existe() {
        // Arrange — préparer le décor
        Application app = new Application("SQLI", "Dev Java");
        when(repository.findById(1L)).thenReturn(Optional.of(app));

        // Act — exécuter ce qu'on teste
        Application result = service.findById(1L);

        // Assert — vérifier le résultat
        assertEquals("SQLI", result.getCompany());
        assertEquals("Dev Java", result.getPosition());
    }

    @Test
    void findById_leve_NotFoundException_quand_id_inexistant() {
        // Arrange
        when(repository.findById(99L)).thenReturn(Optional.empty());

        // Act + Assert
        assertThrows(NotFoundException.class, () -> service.findById(99L));
    }
}