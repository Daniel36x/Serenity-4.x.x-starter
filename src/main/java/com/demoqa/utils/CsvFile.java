package com.demoqa.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class CsvFile {
    public static List<Map<String,String>> read(String pathCsv) {

        String line;
        List<Map<String,String>> totalData = new ArrayList<>();
        Map<String,String> dataLine = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(pathCsv))) {

            List<String> headers = Arrays.asList(br.readLine().split(";", -1));
            while ((line = br.readLine()) != null) {

                List<String> values = Arrays.asList(line.split(";", -1));
                for (int i = 0; i < values.size(); i++) {

                    dataLine.put(headers.get(i), values.get(i));

                }
                totalData.add(dataLine);
                dataLine = new HashMap<>();

            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return totalData;
    }

    public static Optional<Map<String, String>> filter(List<Map<String,String>> data, String filter){

        Optional<Map<String, String>> filterData = data.stream()
                .filter(s -> s.containsValue(filter))
                .findFirst();

        return filterData;

    }
}
