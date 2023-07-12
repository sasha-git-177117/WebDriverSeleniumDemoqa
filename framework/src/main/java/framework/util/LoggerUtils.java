package framework.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtils {

    private static final Logger LOGGER = LogManager.getLogger(LoggerUtils.class);
    private static final Integer POSITION_CLASS_IN_STACK_TRACE = 2;

    public static void info(String message) {
        String className = Thread.currentThread().getStackTrace()[POSITION_CLASS_IN_STACK_TRACE].toString();
        LOGGER.info(className + " - " + message);
    }

    public static void debug(String message) {
        String className = Thread.currentThread().getStackTrace()[POSITION_CLASS_IN_STACK_TRACE].toString();
        LOGGER.debug(className + " - " + message);
    }
}
