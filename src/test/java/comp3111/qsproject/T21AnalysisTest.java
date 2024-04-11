package comp3111.qsproject;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class T21AnalysisTest {

    @Test
    void sortUniversityYears() {
        List<String> input = List.of("2017", "2020", "2010", "2014");
        List<String> expected = List.of("2010", "2014", "2017", "2020");
        List<String> actual = T21Analysis.sortUniversityYears(input);

        assertEquals(expected, actual);
    }

    @Test
    void sortUniversityYears2() {
        List<String> input = List.of("2030", "1990", "2001", "2014", "2018");
        List<String> expected = List.of("1990", "2001", "2014", "2018", "2030");
        List<String> actual = T21Analysis.sortUniversityYears(input);

        assertEquals(expected, actual);
    }
}