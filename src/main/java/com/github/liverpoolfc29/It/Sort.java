package com.github.liverpoolfc29.It;

import com.github.liverpoolfc29.It.Data.IDateSorter;

import java.time.LocalDate;
import java.util.*;

public class Sort implements IDateSorter {
    private List<LocalDate> tempListWithLetterR;
    private List<LocalDate> tempListWithoutLetterR;
    private final List<LocalDate> localDates;

    public Sort(List<LocalDate> localDateList) {
        localDates = new ArrayList<>(localDateList.size());
    }

    @Override
    public Collection<LocalDate> sortDates(List<LocalDate> unsortedDates) {
        sortMonthWithLetter(unsortedDates);
        sortByMonthAscend(tempListWithLetterR);
        sortByMonthDescend(tempListWithoutLetterR);

        return localDates;
    }

    private void sortMonthWithLetter(List<LocalDate> unsortList) {
        tempListWithoutLetterR = new ArrayList<>();
        tempListWithLetterR = new ArrayList<>();
        for (LocalDate localDate : unsortList) {
            String monthName = localDate.getMonth().toString().toLowerCase();
            if (monthName.contains("r")) {
                tempListWithLetterR.add(localDate);
            } else {
                tempListWithoutLetterR.add(localDate);
            }
        }
    }

    private void sortByMonthAscend(List<LocalDate> list) {
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

    private void sortByMonthDescend(List<LocalDate> list) {
        LocalDate templocalDate;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 1; j < (list.size() - i); j++) {
                if (list.get(j - 1).getMonth().getValue() < list.get(j).getMonth().getValue()) {
                    templocalDate = list.get(j - 1);
                    list.set(j - 1, list.get(j));
                    list.set(j, templocalDate);
                }
            }
        }
    }

}