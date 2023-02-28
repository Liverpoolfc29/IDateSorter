package com.github.liverpoolfc29.It;

import com.github.liverpoolfc29.It.Data.IDateSorter;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class Sort implements IDateSorter {

    @Override
    public Collection<LocalDate> sortDates(List<LocalDate> unsortedDates) {
        List<LocalDate> localDatesWithLetterR = sortMonthWithLetterR(unsortedDates);
        List<LocalDate> localDateListWithoutLetterR = sortMonthWithoutLetterR(unsortedDates);
        sortByMonth(localDatesWithLetterR);

        return localDatesWithLetterR;
    }

    private List<LocalDate> sortMonthWithLetterR(List<LocalDate> unsortList) {
        List<LocalDate> tempListWithLetterR = new ArrayList<>();
        for (LocalDate localDate : unsortList) {
            String monthName = localDate.getMonth().toString().toLowerCase();
            if (monthName.contains("r")) {
                tempListWithLetterR.add(localDate);
            }
        }
        return tempListWithLetterR;
    }

    private List<LocalDate> sortMonthWithoutLetterR(List<LocalDate> unsortList) {
        List<LocalDate> tempListWithoutLetterR = new ArrayList<>();
        for (LocalDate localDate : unsortList) {
            String monthName = localDate.getMonth().toString().toLowerCase();
            if (!monthName.contains("r")) {
                tempListWithoutLetterR.add(localDate);
            }
        }
        return tempListWithoutLetterR;
    }

    private void sortByMonth(List<LocalDate> list) {
        LocalDate templocalDate;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 1; j < (list.size() - i); j++) {
                if (list.get(j - 1).getMonth().getValue() > list.get(j).getMonth().getValue()) {
                    templocalDate = list.get(j - 1);
                    list.set(j - 1, list.get(j));
                    list.set(j, templocalDate);
                }
            }
        }
    }

}
