package com.sm;

import org.junit.jupiter.api.extension.*;

import java.util.Optional;

public class TestResultLogger implements TestWatcher, BeforeTestExecutionCallback {

    @Override
    public void beforeTestExecution(ExtensionContext context) {
        System.out.printf("STARTING: %s%n", context.getDisplayName());
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        System.out.printf("PASSED: %s%n", context.getDisplayName());
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        System.out.printf("FAILED: %s - %s%n", context.getDisplayName(), cause.getMessage());
    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        System.out.printf("SKIPPED: %s - Reason: %s%n", context.getDisplayName(), reason.orElse("No reason provided"));
    }
}
