import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

class CustomLogger {
    private static final Logger LOGGER = Logger.getLogger(CustomLogger.class.getName());
    private static FileHandler fileHandler;

    static {
        try {
            fileHandler = new FileHandler("logger.txt", true);
            fileHandler.setFormatter(new SimpleFormatter() {
                private static final String format = "%1$tb-%1$td-%1$ty %1$tT - %2$s%n";

                @Override
                public synchronized String format(java.util.logging.LogRecord lr) {
                    String message = lr.getMessage();
                    return String.format(format,
                            new java.util.Date(lr.getMillis()),
                            message
                    );
                }
            });
            LOGGER.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void log(String message) {
        LOGGER.log(Level.INFO, message);
    }
}

