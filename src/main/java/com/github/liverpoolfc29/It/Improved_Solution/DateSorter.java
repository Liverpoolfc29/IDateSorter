package com.github.liverpoolfc29.It.Improved_Solution;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DateSorter {

    public static List<LocalDate> sortDates(List<LocalDate> unsortedDates) {
        List<LocalDate> rDates = unsortedDates.stream()
                .filter(date -> date.getMonth().toString().contains("r"))
                .sorted(Comparator.comparingInt(date -> date.getMonth().getValue()))
                .collect(Collectors.toList());

        List<LocalDate> nonRDates = unsortedDates.stream()
                .filter(date -> !date.getMonth().toString().contains("r"))
                .sorted(Comparator.comparingInt(date -> -date.getMonth().getValue()))
                .collect(Collectors.toList());

        return Stream.concat(
                rDates.stream().limit(4).sorted(),
                Stream.concat(
                        nonRDates.stream(),
                        rDates.stream().skip(4).sorted()
                )
        ).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        LocalDate january = LocalDate.of(2023, 1, 2);
        LocalDate february = LocalDate.of(2023, 2, 3);
        LocalDate march = LocalDate.of(2023, 3, 4);
        LocalDate april = LocalDate.of(2023, 4, 5);
        LocalDate may = LocalDate.of(2023, 5, 6);
        LocalDate june = LocalDate.of(2023, 6, 7);
        LocalDate july = LocalDate.of(2023, 7, 8);
        LocalDate august = LocalDate.of(2023, 8, 9);
        LocalDate september = LocalDate.of(2023, 9, 10);
        LocalDate october = LocalDate.of(2023, 10, 11);
        LocalDate november = LocalDate.of(2023, 11, 12);
        LocalDate december = LocalDate.of(2023, 12, 13);

        List<LocalDate> dates = new ArrayList<>(Arrays.asList(january, february, march, april, may, june, july,
                august, september, october, november, december));

        System.out.println(sortDates(dates));
    }

}