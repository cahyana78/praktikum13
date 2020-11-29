package org.d3ifcool.ima06;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.io.*;

public class TestJurnal02 {

    private static final String[] INPUT = {
            "4 1 5 7 7 9 9 3 6 1 0",
			"3 5 6 3 8 6 9 5 6 1 9 1 1 4 9 3 2 9 4 3 0"
    };
    private static final String[] OUTPUT = {
            "5.20","4.85"
    };

    @Test
    public void testJurnal() {
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;

        for (int i = 0; i < INPUT.length; i++) {
            System.setIn(new ByteArrayInputStream(INPUT[i].getBytes()));
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            System.setOut(new PrintStream(bos));

            Jurnal02.main(null);

            assertEquals(OUTPUT[i] + "\n", bos.toString());
        }

        System.setOut(originalOut);
        System.setIn(originalIn);
    }
}
