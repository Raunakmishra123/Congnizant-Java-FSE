package com.cognizant.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// SLF4J is a logging library that is better than System.out.println() because:
//   - You can turn logs ON or OFF without changing code
//   - Different log levels help you control what gets printed
//   - Logs can be saved to a file, sent to a server, etc.
//
// Log levels (from least to most serious):
//   TRACE - very detailed, like debugging every single step
//   DEBUG - useful info for developers while debugging
//   INFO  - general app flow messages
//   WARN  - something unexpected happened but the app still works
//   ERROR - something went wrong, needs attention

public class LoggingExample {

    // Create a logger for this class - always use the class name
    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {
        logger.trace("App is starting up");
        logger.debug("Loading configuration...");
        logger.info("Application started successfully");
        logger.warn("Disk space is running low");
        logger.error("Failed to connect to database", new RuntimeException("Connection refused"));
    }

    // Parameterized logging is preferred over string concatenation.
    // This way the string is only built if that log level is active.
    public static void logUserActivity(String username, int userId) {
        logger.debug("User '{}' with ID {} logged in", username, userId);
        logger.info("Processing request for user: {}", username);
    }

    public static void logResult(String operation, boolean success) {
        if (success) {
            logger.info("Operation '{}' completed successfully", operation);
        } else {
            logger.warn("Operation '{}' failed - will retry", operation);
        }
    }
}
