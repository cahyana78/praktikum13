package org.d3ifcool.ima13;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTP02 {

    private static final String[] INPUT = {
            "Pak, hari ini saya mau minta izin, soalnya lagi ada keperluan mendadak yang urgent, jadi belum bisa mengikuti mata kuliah Bapak, sebagai gantinya saya harap bisa diberi tugas tambahan untuk mengganti ketidakhadiran saya."
    };
    private static final String[] OUTPUT = {
            "Pk, hr n sy m mnt zn, slny lg d kprln mnddk yng rgnt, jd blm bs mngkt mt klh Bpk, sbg gntny sy hrp bs dbr tgs tmbhn ntk mnggnt ktdkhdrn sy."
    };

    @Test
    public void testTP() {
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;

        for (int i = 0; i < INPUT.length; i++) {
            System.setIn(new ByteArrayInputStream(INPUT[i].getBytes()));
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            System.setOut(new PrintStream(bos));

            TP02.main(null);

            assertEquals(OUTPUT[i] + "\n", bos.toString());
        }

        System.setOut(originalOut);
        System.setIn(originalIn);
    }
}
