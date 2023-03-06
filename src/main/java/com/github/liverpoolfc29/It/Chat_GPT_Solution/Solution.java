package com.github.liverpoolfc29.It.Chat_GPT_Solution;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

/**
 * Решение от чата GPT, спустя полтора часа подробного и поэтапного расписывания ему данной задачи по частям. Очень хотелось увидеть его метод решения.
 */
public class Solution {

    public static void main(String[] args) {
        LocalDate january = LocalDate.of(2023, Month.JANUARY, 2);
        LocalDate february = LocalDate.of(2023, Month.FEBRUARY, 3);
        LocalDate march = LocalDate.of(2023, Month.MARCH, 4);
        LocalDate april = LocalDate.of(2023, Month.APRIL, 5);
        LocalDate may = LocalDate.of(2023, Month.MAY, 6);
        LocalDate june = LocalDate.of(2023, Month.JUNE, 7);
        LocalDate july = LocalDate.of(2023, Month.JULY, 8);
        LocalDate august = LocalDate.of(2023, Month.AUGUST, 9);
        LocalDate september = LocalDate.of(2023, Month.SEPTEMBER, 10);
        LocalDate october = LocalDate.of(2023, Month.OCTOBER, 11);
        LocalDate november = LocalDate.of(2023, Month.NOVEMBER, 12);
        LocalDate december = LocalDate.of(2023, Month.DECEMBER, 13);

        List<LocalDate> dates = new ArrayList<>(Arrays.asList(january, february, march, april, may, june, july,
                august, september, october, november, december));

        List<LocalDate> dates_1 = new ArrayList<>(Arrays.asList(january, march, april, may, june,
                august, september, october, december));

        List<LocalDate> dates_2 = new ArrayList<>(Arrays.asList(january, april, june,
                august, september, december));

        DateSorter sorter = new DateSorter();
        Collection<LocalDate> localDates = sorter.sortDates(dates_2);

        System.out.println(localDates);
    }
}

class DateSorter {
    public Collection<LocalDate> sortDates(List<LocalDate> unsortedDates) {
        List<LocalDate> rDates = new ArrayList<>();
        List<LocalDate> nonRDates = new ArrayList<>();

        // Разделение месяцев на две группы
        for (LocalDate date : unsortedDates) {
            String monthName = date.getMonth().toString().toLowerCase();
            if (monthName.contains("r")) {
                rDates.add(date);
            } else {
                nonRDates.add(date);
            }
        }

        // Сортировка массивов месяцев
        Collections.sort(rDates);
        Collections.sort(nonRDates, Collections.reverseOrder());

        // Объединение массивов месяцев
        List<LocalDate> sortedDates = new ArrayList<>();
        int rIndex = 0;
        int nonRIndex = 0;

        while (rIndex < rDates.size() && nonRIndex < nonRDates.size()) {
            // Добавление месяцев с буквой "r" в названии в порядке возрастания
            if (rDates.get(rIndex).getMonthValue() < nonRDates.get(nonRIndex).getMonthValue()) {
                sortedDates.add(rDates.get(rIndex));
                rIndex++;
            }
            // Добавление месяцев без буквы "r" в названии в порядке убывания
            else {
                sortedDates.add(nonRDates.get(nonRIndex));
                nonRIndex++;
            }
        }

        // Добавление оставшихся месяцев с буквой "r" в названии
        while (rIndex < rDates.size()) {
            sortedDates.add(rDates.get(rIndex));
            rIndex++;
        }

        // Возвращение отсортированного списка месяцев
        return sortedDates;
    }

}