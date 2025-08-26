package com.example.util;

import com.opencsv.CSVReader;
import com.example.model.*;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSVParser {
    public List<Furniture> parseFurniture(String filename) throws Exception {
        List<Furniture> furniture = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(filename))) {

            // Пропускаем заголовок
            reader.readNext();

            String[] line;
            while ((line = reader.readNext()) != null) {
                String type = line[0];
                String name = line[1];
                double price = Double.parseDouble(line[2]);
                String material = line[3];

                if (type.equalsIgnoreCase("диван")) {
                    int seatingCapacity = Integer.parseInt(line[4]);
                    furniture.add(new Sofa(name, price, material, seatingCapacity));
                } else if (type.equalsIgnoreCase("кровать")) {
                    String size = line[4];
                    furniture.add(new Bed(name, price, material, size));
                }
            }
        }
        return furniture;
    }
}