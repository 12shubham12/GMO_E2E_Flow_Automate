package utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MessageLogger {

    private static final String path = System.getProperty("user.dir")+"src\\test\\resources\\";
    static{
        System.setProperty("log4j.configurationFile",path+"log4j2.properties");
    }

    private static final Logger Log = LogManager.getLogger();

    public static void info(String message){
        Log.info(message);
    }

    public static void warn(String message){
        Log.warn(message);
    }
    public static void error(String message){
        Log.error(message);
    }
    public static void fatal(String message){
        Log.fatal(message);
    }
    public static void debug(String message){
        Log.debug(message);
    }
}
