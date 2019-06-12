package day2.pantadeusz;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertThrows;

class CountWordsTest {


    CountWords countWords;

    @BeforeEach
    void setUp() {
        countWords = new CountWords();
    }

    @Test
    void readFile() throws IOException {
        List<String> list = countWords.readFile("TestFiles/testFiles.txt");
        Assertions.assertThat(list).contains("Ala ma kota").contains("kot ma Alę").hasSize(2);
    }


    @Test
    void readFile1() {
        assertThrows(FileNotFoundException.class, () -> countWords.readFile("dupa.txt"));
    }

    @Test
    void rhymes() {
        List<String> list = new ArrayList<>();
        Assertions.assertThat(countWords.rhymes(list)).containsKeys("lata_świata").containsValues(2).hasSize(1);
    }

    private List<String> addLines() {
        List<String> list = new ArrayList<>();
        list.add("Takie były zabawy, spory w one lata");
        list.add("Śród cichej wsi litewskiej, kiedy reszta świata");
        list.add("Jak czeladnika, który terminuje lata");
        list.add("Ażeby nabył trochę znajomości świata.");
        return list;
    }

    @Test
    void map(){
    Assertions.assertThat(countWords.someMethod(mapRhymes(), 1)).hasSize(2)
            .containsKeys("dzialka", "cos").doesNotContainKeys("dom").containsValues(2,3).doesNotContainValue(1);
    }

    private Map<String, Integer> mapRhymes() {
        Map<String, Integer> map = new HashMap<>();
        map.put("dom", 1);
        map.put("dzialka", 2);
        map.put("cos", 3);
        return map;
    }

}