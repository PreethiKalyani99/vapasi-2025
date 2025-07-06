package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ExpenseParserTest {
    @TempDir
    Path tempDir;

    @Test
    void shouldParseInputFileAndReturnExpenses () throws IOException {
        String content = "A spent 100 for Snacks for B, C, D";
        Path file = Files.writeString(tempDir.resolve("input.txt"), content);

        List<Expense> expenses = ExpenseParser.parseFile(file.toString());
        assertEquals(1, expenses.size());

        Expense e = expenses.getFirst();
        assertEquals("A", e.getSpender());
        assertEquals(100, e.getAmount());
        assertArrayEquals(new String[]{"B", "C", "D"}, e.getReceivers());
    }

    @Test
    void shouldThrowExceptionWhenInputIsInvalid () throws IOException {
        String content = "A spent 100 spent Snacks for B, C, D";
        Path file = Files.writeString(tempDir.resolve("input.txt"), content);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ExpenseParser.parseFile(file.toString());
        });

        assertTrue(exception.getMessage().contains("Invalid input: A spent 100 spent Snacks for B, C, D"));
    }

    @Test
    void shouldThrowExceptionWhenFileNotFound () {
        String invalidPath = tempDir.resolve("nonexistent.txt").toString();

        Exception exception = assertThrows(RuntimeException.class, () -> {
            ExpenseParser.parseFile(invalidPath);
        });

        assertTrue(exception.getMessage().contains("Failed to read file:"));
    }
}
