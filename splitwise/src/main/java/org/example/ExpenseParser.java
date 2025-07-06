package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExpenseParser {

    public ExpenseParser() {}

    public static List<Expense> parseFile(String location) {
        String payerName = "([A-Za-z ]+)";
        String amountSpent = "(\\d+(?:\\.\\d+)?)\\s";
        String description = "(.+?)\\s";
        String receivers = "((?:[A-Za-z ]+\\s*,\\s*)*[A-Za-z ]+)";

        String regex = "^"
                + payerName
                + "\\s+spent\\s+"
                + amountSpent
                + "+for\\s+"
                + description
                + "+for\\s+"
                + receivers
                + "$";
        Pattern pattern = Pattern.compile(regex);

        try {
            Stream<String> lines = Files.lines(Paths.get(location));

            return lines.map(line -> {
                Matcher matcher = pattern.matcher(line);

                if (!matcher.matches()) {
                    throw new IllegalArgumentException("Invalid input: " + line);
                }

                String payer = matcher.group(1).trim();
                double amount = Double.parseDouble(matcher.group(2));
                String[] payees = matcher.group(4).split("\\s*,\\s*");

                return new Expense(payer, amount, payees);
            }).collect(Collectors.toList());
        }
        catch (IOException e) {
            throw new RuntimeException("Failed to read file: " + location, e);
        }
    }

}
