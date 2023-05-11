package dev.java.slf4j.loggingcontext;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;

public class ParentAndChildLoggerDemo {

    public static void main(String[] args) {

        Logger ancestorLogger = (ch.qos.logback.classic.Logger)LoggerFactory.getLogger("dev.java");
        Logger parentLogger   = (ch.qos.logback.classic.Logger)LoggerFactory.getLogger("dev.java.slf4j.loggingcontext");
        Logger childLogger    = (ch.qos.logback.classic.Logger)LoggerFactory.getLogger("dev.java.slf4j.loggingcontext.ParentAndChildLoggerDemo");

        // Ancestor Logger Will Print Only ERROR Log
        ancestorLogger.setLevel(Level.ERROR);

        //Parent Logger Will Print All Logs from TRACE to ERROR
        //Child Logger will inherit level from Parent Logger
        parentLogger.setLevel(Level.TRACE);


        printSampleLogs(ancestorLogger);
        printSampleLogs(parentLogger);
        printSampleLogs(childLogger);
    }

    public static void printSampleLogs(Logger logger){
        logger.trace("1. TRACE MESSAGE");
        logger.debug("2. DEBUG MESSAGE");
        logger.info ("3. INFO  MESSAGE");
        logger.warn ("4. WARN  MESSAGE");
        logger.error("5. ERROR MESSAGE");
    }


}
