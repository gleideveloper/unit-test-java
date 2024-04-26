package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.dto.CadastroPetDto;
import br.com.alura.adopet.api.model.Abrigo;
import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.repository.PetRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class PetServiceTest {

    @InjectMocks
    private PetService service;

    @Mock
    private PetRepository repository;

    @Mock
    private CadastroPetDto dto;

    @Mock
    private Abrigo abrigo;

    @Test
    void testBuscarPetsDisponiveis() {
        //Arrange
        var pet = new Pet(dto, abrigo);
        //Act
        service.cadastrarPet(abrigo, dto);
        //Assert
        then(repository).should().save(pet);
    }

    @Test
    void testCadastrarPet() {
        //Arrange
        var pet = new Pet(dto, abrigo);
        //Act
        service.cadastrarPet(abrigo, dto);
        //Assert
        then(repository).should().save(pet);
    }
}