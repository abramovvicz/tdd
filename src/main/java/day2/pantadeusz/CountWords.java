package day2.pantadeusz;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CountWords {
    Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
//        CountWords countWords = new CountWords();
//        Map<String, Integer> mapa = countWords.rhymes();
//
//        int a = mapa.values().stream().collect(Collectors.maxBy((x, y) -> x - y)).get();// to nam daje od najmniejszej do największej
//        for (Map.Entry<String, Integer> m : mapa.entrySet()) {
//            if (m.getValue() == a) {
//                System.out.println("pokazuje wartość " + m.getKey() + " : " + m.getValue());
//            }
//        }
    }

    public int getHero(String name) {
        return map.get(name);
    }


    public List<String> readFile(String fileName) throws IOException {
        List<String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        while (reader.ready()) {
            list.add(reader.readLine());
        }
        reader.close();
        return list;
    }

    public int findWord(String name) {
        return map.get(name);
    }

    public Map<String, Integer> rhymes(List<String> list) {
        Map<String, Integer> countRhymes = new HashMap<>();
        String temp = "   ";
        int numberOfLetters = 3;
        for (String s : list) {
            String[] words = s.trim().split("[,.\\s!?()\\-_;:*<<>>»«=\\...]+");
            if (words.length < 1) {
                continue;
            }
            String last = words[words.length - 1].toLowerCase();
            if (last.length() < numberOfLetters) {
                continue;
            }
            if (last.substring(last.length() - numberOfLetters).equals(temp.substring(temp.length() - numberOfLetters))) {
                String key;
                if (temp.compareTo(last) < 0) {
                    key = temp + "_" + last;
                } else {
                    key = last + "_" + temp;
                }
                countRhymes.put(key, countRhymes.get(key) == null ? 1 : countRhymes.get(key) + 1);

            }
            temp = last;
        }
        return countRhymes;
    }


    public Map<String, Integer> someMethod(Map<String, Integer> map, int minRhymes) {
        Map<String, Integer> endMap = new HashMap<>();
        for (Map.Entry<String, Integer> m : map.entrySet()) {
            if (m.getValue() > minRhymes) {
                endMap.put(m.getKey(), m.getValue());
            }
        }
        return endMap;
    }

    public Map<String, Integer> readFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("pan-tadeusz.txt"))) { // porpawny skrócony zapis
            int numberOfLetters = 3;
            while (reader.ready()) {
                String[] line = reader.readLine().trim().split("[,.\\s!?()\\-_;:*<<>>»«=\\...]+");
                for (String s : line) {
                    if (s.length() > numberOfLetters) {
                        s = s.toLowerCase();
                        map.put(s, map.get(s) == null ? 1 : map.get(s) + 1);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        }
        List<Integer> values = new ArrayList<>(map.values());
        Collections.sort(values, (x, y) -> y - x);
        int numberOfMostPopularWords = 5;
        Map<String, Integer> result = new TreeMap<>();
        int uniqWords = 0;
        for (Map.Entry<String, Integer> m : map.entrySet()) {
            if (m.getValue() == 1) {
                uniqWords++; //zlicza ile słów wystepuje jeden raz
            }
        }
        System.out.println("ilośc słów występujący jeden raz to: " + uniqWords);
        for (int i = 0; i < numberOfMostPopularWords; i++) {
            for (String s : map.keySet()) {
//                keySet() = zwwraca wszystkie klucze
                if (map.get(s) == values.get(i)) {
                    result.put(s, values.get(i));
                    if (result.size() >= numberOfMostPopularWords) {
                        return result;
                    }
                }
            }
        }
        return result;
    }
}
