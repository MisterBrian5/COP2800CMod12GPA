// Brian Sosa Colman
// COP2800C
// Module 12 GPA
// 11/22/2026

package edu.fscj.cop2800c.penguin;

import edu.fscj.cop2800c.util.DataWrapper;
import java.util.ArrayList;

public class PalmerPenguins {
    public static void main(String[] args) {
        int numPenguins = 0;

        // Create an instance of PenguinAnalyzer
        PenguinAnalyzer analyzer = new PenguinAnalyzer();

        // Read CSV data
        numPenguins = analyzer.readPenguins();

        // Check if any penguins were read, exit if none
        if (numPenguins == 0) {
            System.err.println(
                "Error: No penguins were read from the file. Exiting program.");
            System.exit(1);
        }

        if (numPenguins > 1) {
            // Test the compareTo method
            System.out.println("Testing compareTo method:");

            Penguin p1 = analyzer.getPenguinBySampleNum(1);
            Penguin p2 = analyzer.getPenguinBySampleNum(2);

            if (p1 != null && p2 != null) {
                int comparisonResult = p1.compareTo(p2);
                System.out.println(
                    "Comparison result between first two penguins: "
                    + comparisonResult);

                // Test compareTo for equality
                int selfComparison = p1.compareTo(p1);
                System.out.println(
                    "Comparison result of p1 to itself (should be 0): "
                    + selfComparison);
            } else {
                System.out.println(
                    "Could not find both penguins for comparison.");
            }
        } else {
            System.out.println("Not enough penguins to test compareTo.");
        }

        // Test the toString methods
        analyzer.showRawData();

        // Print formatted output
        analyzer.printPenguins();

        // Save results to a file
        analyzer.writePenguins();

        // Test the custom exception
        System.out.println("Testing Custom Exception");

        // Iterate over sample numbers and call various tests
        for (int sample = 0; sample < 7; sample++) {
            try {
                switch (sample) {
                    case 0:
                        // Negative sample number
                        Penguin pNegSample = new Penguin(
                            -1, "Adelie", 1.0, 1.0, 1.0, "Male", 1.0);
                        break;
                    case 1:
                        // Empty species
                        Penguin pEmptySpecies = new Penguin(
                            1000 + sample, "", 1.0, 1.0, 1.0, "Male", 1.0);
                        break;
                    case 2:
                        // Null species
                        Penguin pNullSpecies = new Penguin(
                            1000 + sample, null, 1.0, 1.0, 1.0, "Male", 1.0);
                        break;
                    case 3:
                        // Negative flipper value
                        Penguin pNegFlipper = new Penguin(
                            1000 + sample, "Adelie", 1.0, 1.0, 1.0,
                            "Male", -1.0);
                        break;
                    case 4:
                        // Empty sex
                        Penguin pEmptySex = new Penguin(
                            1000 + sample, "Adelie", 1.0, 1.0, 1.0, "", 1.0);
                        break;
                    case 5:
                        // Null sex
                        Penguin pNullSex = new Penguin(
                            1000 + sample, "Adelie", 1.0, 1.0, 1.0,
                            null, 1.0);
                        break;
                    case 6:
                        // Negative culmen length
                        Penguin pNegCulmenLen = new Penguin(
                            1000 + sample, "Adelie", -1.0, 1.0, 1.0,
                            null, 1.0);
                        break;
                }
            } catch (InvalidBirdDataException e) {
                System.out.println(e + ": sample = " + sample);
            }
        }

        // Test the generic DataWrapper class
        System.out.println("Data Wrapper List:");

        ArrayList<DataWrapper<Penguin>> wrappedPenguins =
            new ArrayList<>();

        for (int sampleNum = 1; sampleNum <= 8; ++sampleNum) {
            Penguin penguin =
                analyzer.getPenguinBySampleNum(sampleNum);
            wrappedPenguins.add(new DataWrapper<>(penguin));
        }

        if (!wrappedPenguins.isEmpty()) {
            DataWrapper.displayList(wrappedPenguins);
        }
    }
}