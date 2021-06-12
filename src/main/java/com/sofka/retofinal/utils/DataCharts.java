package com.sofka.retofinal.utils;

import com.sofka.retofinal.collections.HistoryOkrEntity;
import com.sofka.retofinal.mapper.MapperUtils;
import com.sofka.retofinal.model.BurnDownDTO;
import com.sofka.retofinal.model.KrDTO;
import com.sofka.retofinal.repository.HistoryOkrRepository;
import com.sofka.retofinal.repository.KrRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DataCharts {

    private final HistoryOkrRepository historyOkrRepository;
    private final KrRepository krRepository;
    private final MapperUtils mapperUtils;


    public DataCharts(HistoryOkrRepository historyOkrRepository, KrRepository krRepository, MapperUtils mapperUtils) {
        this.historyOkrRepository = historyOkrRepository;
        this.krRepository = krRepository;
        this.mapperUtils = mapperUtils;
    }

    private Mono<String> searchHistoryDateMin(String okrId) {
        return krRepository.findAllByOkrId(okrId).map(mapperUtils.krEntityToKrDto())
                .collect(Collectors.minBy(Comparator.comparing(KrDTO::getStartDate)))
                .map(Optional::get).map(krDTO -> krDTO.getStartDate().toString());
    }

    private Mono<String> searchHistoryDateMax(String okrId) {
        return historyOkrRepository.findByOkrId(okrId)
                .map(historyOkrEntity -> LocalDate.parse(historyOkrEntity.getDateUpdate()+"-01"))
                .collect(Collectors.maxBy(Comparator.comparing(o -> o)))
                .map(Optional::orElseThrow).map(LocalDate::toString);
    }

    public Mono<List<Long>> arrayDates(String okrId) {
        var formato = DateTimeFormatter.ofPattern("yyyy-MM");
        return Mono.zip(searchHistoryDateMin(okrId), searchHistoryDateMax(okrId)).flatMap(objects -> {
            var startDate = LocalDate.parse(Objects.requireNonNull(objects.getT1()));
            var endDate = LocalDate.parse(Objects.requireNonNull(objects.getT2()));
            return getListDataProgress(okrId, formato, startDate, endDate);
        });
    }

    private Mono<List<Long>> getListDataProgress(String okrId, DateTimeFormatter formato, LocalDate startDate, LocalDate endDate) {
        return Flux.fromStream(Stream.iterate(startDate, date -> date.plusMonths(1))
                .limit(ChronoUnit.MONTHS.between(startDate, endDate) +2 ))
                .flatMap(localDate -> getProgressOkrUpdate(okrId, formato, localDate))
                .collectList();
    }

    private Mono<Long> getProgressOkrUpdate(String okrId, DateTimeFormatter formato, LocalDate localDate) {
        return historyOkrRepository.findByDateUpdate(localDate.format(formato))
                .filter(historyOkrEntity -> historyOkrEntity.getOkrId().equals(okrId))
                .collect(Collectors.maxBy(Comparator.comparing(HistoryOkrEntity::getProgressOkr)))
                .map(historyOkrEntity -> historyOkrEntity.orElseThrow().getProgressOkr());
    }
}

