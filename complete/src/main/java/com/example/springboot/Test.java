package com.example.springboot;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {


        final String EXEC_ARGUMENT
                = new StringBuilder().
                append(java.lang.System.getProperty("java.home")).
                append(java.io.File.separator).
                append("bin").
                append(java.io.File.separator).
                append("java").
                append(" ").
                append(new java.io.File(".").getAbsolutePath()).
                append(java.io.File.separator).
                append("FunctionProcess").
                toString();

        try {
            Runtime.getRuntime().exec(EXEC_ARGUMENT);

        } catch (
                final Exception EXCEPTION) {

            System.err.println(EXCEPTION.getStackTrace());
        }
    }

}
