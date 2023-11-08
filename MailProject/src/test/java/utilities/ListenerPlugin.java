package utilities;

import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.*;

import java.time.LocalDateTime;

    public class ListenerPlugin implements ConcurrentEventListener {

        public void onTestCaseStarted(TestCaseStarted testCaseStarted) {
            System.out.println("TEST CASE STARTED: " + testCaseStarted.getTestCase().getName());
        }


        public void onTestRunFinished(TestRunFinished testRunFinished) {
            System.out.println("TEST RUN FINISHED AT: " + LocalDateTime.now().toString());
        }

        @Override
        public void setEventPublisher(EventPublisher eventPublisher) {
            eventPublisher.registerHandlerFor(TestRunFinished.class, this::onTestRunFinished);
            eventPublisher.registerHandlerFor(TestCaseStarted.class, this::onTestCaseStarted);
        }
    }

