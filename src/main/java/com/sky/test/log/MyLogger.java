package com.sky.test.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyLogger {

    public static Logger getLogger(){
        return LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    }
}
