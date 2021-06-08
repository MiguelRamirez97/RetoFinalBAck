package com.sofka.retofinal.usecase;

import com.sofka.retofinal.collections.KrEntity;
import com.sofka.retofinal.collections.OkrEntity;
import com.sofka.retofinal.mapper.MapperUtils;
import com.sofka.retofinal.model.KrDTO;
import com.sofka.retofinal.model.OkrDTO;
import com.sofka.retofinal.repository.KrRepository;
import com.sofka.retofinal.repository.OkrRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AllOkrByUserTest {

    @Autowired
    AllOkrByUser useCase;

    @MockBean
    OkrRepository okrRepository;

    @MockBean
    KrRepository krRepository;

    @Test
    void allOkrByUserTest(){

        var userId = "12de43322f";
        var okrTestOne = new OkrEntity("123","12de43322f","title1","objective1","pepe","pepe@pepe.com","DESARROLLO","anydescription");
        var okrTestTwo = new OkrEntity("1234","12de43322f","title2","objective2","pepe","pepe@pepe.com","DESARROLLO","anydescription");


        Mockito.when(okrRepository.findByUserId(Mockito.anyString()))
                .thenReturn(Flux.just(okrTestOne,okrTestTwo));

        Mockito.when(krRepository.findAllByOkrId(Mockito.anyString()))
                .thenReturn(Flux.empty());

        Flux<OkrDTO> response = useCase.apply(userId);
        StepVerifier.create(response)
                .expectNextMatches(okrDTO -> okrDTO.getId().equalsIgnoreCase("123"))
                .expectNextMatches(okrDTO -> okrDTO.getId().equalsIgnoreCase("1234"))
                .verifyComplete();
    }

    @Test
    void joinOkrWithKr(){

        var okrDTOTest = new OkrDTO("123","1234Userid","title1","","brian1","bria@h.com","desarrollo","anything description");

        var krTestOne = new KrEntity("123","1234","keyResul1","brian1","bria@h.com","description1",30,40, LocalDate.now(),LocalDate.now());
        var krTestTwo = new KrEntity("1234","1234","keyResul2","brian2","brianOl@h.com","description2",40,60, LocalDate.now(),LocalDate.now());

        Mockito.when(krRepository.findAllByOkrId(Mockito.anyString()))
                .thenReturn(Flux.just(krTestOne,krTestTwo));

        Mono<OkrDTO> response = useCase.joinOkrWithKr().apply(okrDTOTest);
        StepVerifier.create(response)
                .expectNextMatches(okrDTO -> okrDTO.getKrs().size() == 2)
                .verifyComplete();
    }
}