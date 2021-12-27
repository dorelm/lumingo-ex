package com.example.springboot;

import com.example.springboot.dataModel.PostMessage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FunctionStarter implements Runnable {
    @Override
    public void run() {
        try {
            List<PostMessage> messages = new ArrayList<>();
            FunctionsManager.messagesQ.drainTo(messages);
            Application.functionsManager.persistFunctionCall();
            startNewFunction(messages);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void startNewFunction(List<PostMessage> messages) throws IOException, InterruptedException {
        Process process = Runtime.getRuntime().exec("");
        Application.functionsManager.activeProcesses.add(process);
        process.waitFor();
        Application.functionsManager.activeProcesses.remove(process);
    }
}
