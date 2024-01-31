package xyz.komas19.komas19lib.log;

import java.io.PrintStream;

public class Logging {

    private String msg;
    public PrintStream high(String msg) {
        return System.out.printf("[komas19lib]: HIGH ERROR: " + msg);
    }

    public PrintStream low(String msg) {
        return System.out.printf("[komas19lib]: LOW ERROR: " + msg);
    }

    public PrintStream warn(String msg) {
        return System.out.printf("[komas19lib]: WARNING: " + msg);
    }

    public PrintStream medium(String msg) {
        return System.out.printf("[komas19lib]: MEDIUM ERROR: " + msg);
    }

    public PrintStream log(String msg) {
        return System.out.printf("[komas19lib] : " + msg);
    }
}
