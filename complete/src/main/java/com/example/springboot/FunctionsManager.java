package com.example.springboot;

import com.example.springboot.dataModel.PostMessage;
import com.example.springboot.dataModel.Statistics;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class FunctionsManager {
    static BlockingQueue<PostMessage> messagesQ = new LinkedBlockingDeque<>();
    List<Process> activeProcesses = new ArrayList<>();
    long numberOfCalls = 0;

    public void newMessage(PostMessage message) {
        messagesQ.add(message);
    }

    public void start() {
        while(!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                return;
            }
            if (messagesQ.size() > 0) {
                new Thread(new FunctionStarter());
            }
        }
    }

    public void persistFunctionCall() {
        numberOfCalls++;
    }

    public Statistics getStatistics() {
        return new Statistics(activeProcesses.size(), numberOfCalls);
    }
}
