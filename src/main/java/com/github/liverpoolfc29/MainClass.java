package com.github.liverpoolfc29;

import com.github.liverpoolfc29.It.Sort;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class MainClass {

    public static void main(String[] args) {
        LocalDate january = LocalDate.of(2023, 1, 1);
        LocalDate february = LocalDate.of(2023, 2, 1);
        LocalDate march = LocalDate.of(2023, 3, 1);
        LocalDate april = LocalDate.of(2023, 4, 1);
        LocalDate may = LocalDate.of(2023, 5, 1);
        LocalDate june = LocalDate.of(2023, 6, 1);
        LocalDate july = LocalDate.of(2023, 7, 1);
        LocalDate august = LocalDate.of(2023, 8, 1);
        LocalDate september = LocalDate.of(2023, 9, 1);
        LocalDate october = LocalDate.of(2023, 10, 1);
        LocalDate november = LocalDate.of(2023, 11, 1);
        LocalDate december = LocalDate.of(2023, 12, 1);

        List<LocalDate> localDateList = new ArrayList<>(Arrays.asList(february, march, january, april, may, june, july, august, september, october, november, december));

        Sort sort = new Sort();
        Collection<LocalDate> localDates = sort.sortDates(localDateList);
        System.out.println(localDates);
    }

}