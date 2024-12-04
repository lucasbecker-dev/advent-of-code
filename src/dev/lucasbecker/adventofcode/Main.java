package dev.lucasbecker.adventofcode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Part 1
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] splitLine = line.split(" {3}");
                left.add(Integer.parseInt(splitLine[0]));
                right.add(Integer.parseInt(splitLine[1]));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Collections.sort(left);
        Collections.sort(right);
        int totalDistance = 0;
        for (int i = 0; i < left.size(); i++) {
            totalDistance += Math.abs(left.get(i) - right.get(i));
        }
        System.out.println("Total distance: " + totalDistance);

        // Part 2
        int similarityScore = 0;
        for (int i = 0; i < left.size(); i++) {
            int numAppearances = 0;
            for (int j = 0; j < right.size(); j++) {
                if (left.get(i).equals(right.get(j))) {
                    numAppearances += 1;
                }
            }
            similarityScore += left.get(i) * numAppearances;
        }
        System.out.println("Similarity Score: " + similarityScore);
    }
}