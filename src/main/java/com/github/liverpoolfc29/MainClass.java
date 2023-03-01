package com.github.liverpoolfc29;

import com.github.liverpoolfc29.It.Sort;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class MainClass {

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

        List<LocalDate> localDateList = new ArrayList<>(Arrays.asList(february, march, january, april, may, june, july, august, september, october, november, december));
        List<LocalDate> localDateList1 = new ArrayList<>(Arrays.asList(may,august, january, february, october, november));
        List<LocalDate> localDateList2 = new ArrayList<>(Arrays.asList(may, june, october, december));

        Sort sort = new Sort();

        System.out.println(localDateList);

        Collection<LocalDate> localDates = sort.sortDates(localDateList);
        System.out.println(localDates);
    }

}