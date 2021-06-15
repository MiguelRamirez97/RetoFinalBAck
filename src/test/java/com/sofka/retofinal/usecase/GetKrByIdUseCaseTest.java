package com.sofka.retofinal.usecase;

import com.sofka.retofinal.collections.KrEntity;
import com.sofka.retofinal.model.KrDTO;
import com.sofka.retofinal.repository.KrRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class GetKrByIdUseCaseTest {

    @Autowired
    GetKrByIdUseCase getKrByIdUseCase;
    @MockBean
    KrRepository krRepository;

    @Test
    void getKrByIdUseCaseTest(){

        var krOneTest = new KrEntity("1",
                "01",
                "test 1",
                "Adriana",
                "a@gmail.com",
                "prueba a caso de uso",
                50,
                100,
                LocalDate.of(2022,03,01),
                LocalDate.of(2022,03,05));

        Mockito.when(krRepository.findById(Mockito.anyString()))
                .thenReturn(Mono.just(krOneTest));

        var response = getKrByIdUseCase.apply(krOneTest.getId());
        StepVerifier.create(response)
                .expectNextMatches(krDTO -> krDTO.getKrId().equalsIgnoreCase("1") &&
                        krDTO.getResponEmail().equalsIgnoreCase("a@gmail.com") &&
                        krDTO.getStartDate().equals(LocalDate.of(2022,03,01)))
                .verifyComplete();

//        var response = getKrByIdUseCase.apply(krOneTest.getId()).block();
//        Assertions.assertEquals(response.getKrId(), krOneTest.getId());
//        Assertions.assertEquals(response.getResponEmail(), krOneTest.getResponEmail());
    }

}