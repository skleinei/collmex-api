package com.k15t.collmex;

import org.joda.time.DateTime;

import java.text.NumberFormat;
import java.util.Locale;


public abstract class Datensatz {


    public enum Datentyp {
        C, I, N, D, M, T
    }


    private final String satzart;
    private Integer firmaNr;


    public Datensatz(String satzart) {
        this.satzart = satzart;
    }


    /**
     * @return the fix String that identifies the satzart (record type) in the CSV file.
     */
    public String satzart() {
        return satzart;
    }


    public abstract Datensatz firmaNr(Integer firmaNr);


    public abstract void id(Integer id);


    public abstract Integer id();


    public abstract String toCsv();


    public static void validate(String name, Datentyp datentyp, Integer max, Object value) {
        // TODO validation
    }


    protected String toCsvField(String name, Datentyp datentyp, Object value) {
        switch (datentyp) {
            case C:
                return (value != null ? "\"" + String.valueOf(value) + "\"" : "") + ";";
            case I:
                return (value != null ? String.valueOf(value) : "") + ";";
            case N:
                return (value != null ? NumberFormat.getInstance(Locale.GERMAN).format(value) : "") + ";";
            case D:
                return (value != null ? ((DateTime) value).toString("yyyyMMdd", Locale.GERMAN) : "") + ";";
            case M:
                return (value != null ? NumberFormat.getInstance(Locale.GERMAN).format(value) : "") + ";";
            case T:
                throw new IllegalArgumentException("Data type 'T' is not yet implemented");
            default:
                throw new RuntimeException();
        }
    }

}
