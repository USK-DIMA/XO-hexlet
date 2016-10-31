package io.hexlet.xo.system;

/**
 * Created by Dmitry on 31.10.2016.
 */
public interface Logger {
    void info(String message);
    void warning(String message);
    void error(String message);
}
