package com.example.springboot;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.charset.StandardCharsets;

public class FunctionProcess {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("messages.txt", true);
        FileChannel channel = fileOutputStream.getChannel();
        FileLock lock = channel.lock();
        for (int i = 0; i < args.length; i++) {
            fileOutputStream.write(args[i].getBytes(StandardCharsets.UTF_8));
        }
        lock.release();
    }
}
