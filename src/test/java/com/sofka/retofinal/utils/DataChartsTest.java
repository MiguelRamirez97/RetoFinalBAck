package com.sofka.retofinal.utils;

import com.sofka.retofinal.collections.HistoryOkrEntity;
import com.sofka.retofinal.collections.KrEntity;
import com.sofka.retofinal.repository.HistoryOkrRepository;
import com.sofka.retofinal.repository.KrRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import reactor.core.publisher.Flux;

import java.time.LocalDate;

@SpringBootTest
class DataChartsTest {

    @MockBean
    KrRepository krRepository;

    @MockBean
    HistoryOkrRepository historyOkrRepository;

    @SpyBean
    DataCharts dataCharts;

    @Test
    void DataKrTest2 (){

        var krTestOne = new KrEntity("123","1234","keyResul1","brian1","bria@h.com","description1",30,40, LocalDate.now(),LocalDate.now());
        Mockito.when(krRepository.findAllByOkrId(Mockito.anyString())).thenReturn(Flux.just(krTestOne));

        //System.out.println(dataKrs.searchHistoryDateMax(krTestOne.getOkrId()).block());

        var history = new HistoryOkrEntity("1234", 20L, "2021-06");
        var history2 = new HistoryOkrEntity("1234", 10L, "2021-07");
        Mockito.when(historyOkrRepository.findByDateUpdate(Mockito.anyString())).thenReturn(Flux.just(history, history2));
        Mockito.when(historyOkrRepository.findByOkrId(Mockito.anyString())).thenReturn(Flux.just(history, history2));

        dataCharts.arrayDates(krTestOne.getOkrId()).block().forEach(System.out::println);

    }


}