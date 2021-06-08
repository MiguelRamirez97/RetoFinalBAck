package com.sofka.retofinal.usecase;

import com.sofka.retofinal.collections.KrEntity;
import com.sofka.retofinal.collections.OkrEntity;
import com.sofka.retofinal.model.KrDTO;
import com.sofka.retofinal.model.OkrDTO;
import com.sofka.retofinal.repository.KrRepository;
import com.sofka.retofinal.repository.OkrRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CreateOkrTest {

    @MockBean
    OkrRepository okrRepository;

    @MockBean
    KrRepository krRepository;

    @SpyBean
    CreateOkr createOkr;

    @Test
    void CreateOkrTest(){

        var okrEntity = new OkrEntity();
        okrEntity.setId("00001");
        okrEntity.setUserId("0001");
        okrEntity.setTitle("primer okr");
        okrEntity.setObjective("objetivo 1");
        okrEntity.setResponName("pepito perez");
        okrEntity.setResponEmail("pepito@sofka.com");
        okrEntity.setVertical("arquitectura y desarrollo");
        okrEntity.setDescription("descripcion 1");


        var krEntity1 =  new KrEntity("001","00001","key 1","pepito2","coreeo2@sofka.com"
                ,"realizar key1",20, 0,LocalDate.of(2021,8,21)
                ,LocalDate.of(2021,8,24));

        var krEntity2 =  new KrEntity("002","00001","key 2","pepito3","coreeo2@sofka.com"
                ,"realizar key2",80,0, LocalDate.of(2021,8,21)
                ,LocalDate.of(2021,8,23));

        List<KrEntity> krsEntity =new ArrayList<KrEntity>();
        krsEntity.add(krEntity1);
        krsEntity.add(krEntity2);



        var krDTO1 =  new KrDTO("00001","001","key 1","pepito2","coreeo2@sofka.com"
                ,"realizar key1",20, LocalDate.of(2021,8,21)
                ,LocalDate.of(2021,8,24),0);

        var krDTO2 =  new KrDTO("00001","002","key 2","pepito3","coreeo2@sofka.com"
                ,"realizar key2",80, LocalDate.of(2021,8,21)
                ,LocalDate.of(2021,8,23),0);

        List<KrDTO> krsDTO =  new ArrayList<KrDTO>();
        krsDTO.add(krDTO1);
        krsDTO.add(krDTO2);


        var okrDTOtest = new OkrDTO();
        okrDTOtest.setId("00001");
        okrDTOtest.setUserId("0001");
        okrDTOtest.setTitle("primer okr");
        okrDTOtest.setObjective("objetivo 1");
        okrDTOtest.setResponName("pepito perez");
        okrDTOtest.setResponEmail("pepito@sofka.com");
        okrDTOtest.setVertical("arquitectura y desarrollo");
        okrDTOtest.setDescription("descripcion 1");
        okrDTOtest.setKrs(krsDTO);

        var krDTO3 =  new KrDTO("00001","001","key 1","pepito2","coreeo2@sofka.com"
                ,"realizar key1",20, LocalDate.of(2021,8,21)
                ,LocalDate.of(2021,8,24),0);

        var krDTO4 =  new KrDTO("00001","002","key 2","pepito3","coreeo2@sofka.com"
                ,"realizar key2",40, LocalDate.of(2021,8,21)
                ,LocalDate.of(2021,8,23),0);

        List<KrDTO> krsFailDTO =  new ArrayList<KrDTO>();
        krsFailDTO.add(krDTO3);
        krsFailDTO.add(krDTO4);


        var okrDTOtestFail = new OkrDTO();
        okrDTOtestFail.setId("00001");
        okrDTOtestFail.setUserId("0001");
        okrDTOtestFail.setTitle("primer okr");
        okrDTOtestFail.setObjective("objetivo 1");
        okrDTOtestFail.setResponName("pepito perez");
        okrDTOtestFail.setResponEmail("pepito@sofka.com");
        okrDTOtestFail.setVertical("arquitectura y desarrollo");
        okrDTOtestFail.setDescription("descripcion 1");
        okrDTOtestFail.setKrs(krsFailDTO);


        Mockito.when(okrRepository.save(Mockito.any(OkrEntity.class))).thenReturn(Mono.just(okrEntity));

        Mockito.when(krRepository.saveAll(Mockito.anyList())).thenReturn(Flux.fromIterable(krsEntity));

        Mono<String> response = createOkr.apply(okrDTOtest);
        Mono<String>  response2= createOkr.apply(okrDTOtestFail);

        StepVerifier.create(response).expectNext("00001").verifyComplete();
        StepVerifier.create(response2).expectErrorMessage("el total de pesos % debe ser igual a 100%").verify();













    }





}