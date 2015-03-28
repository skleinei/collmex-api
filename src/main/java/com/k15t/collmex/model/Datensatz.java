package com.k15t.collmex.model;

import org.joda.time.DateTime;

import java.util.Locale;


public abstract class Datensatz {

    protected enum Typ {
        C, I, N, D, M, T
    }

    public abstract String toCsv();


    protected String field(String name, Typ typ, Integer max) {
        return field(name, typ, max, null);
    }


    protected String field(String name, Typ typ, Integer max, Object value) {
        switch (typ) {
            case C:
                return (value != null ? "\""+ String.valueOf(value) + "\"" : "") + ";";
            case I:
                return (value != null ? String.valueOf(value) : "") + ";";
            case N:
                return (value != null ? String.valueOf(value) + "\"" : "") + ";";
            case D:
                return (value != null ? ((DateTime) value).toString("yyyyMMdd", Locale.GERMAN) : "") + ";";
            case M:
                return (value != null ? String.valueOf(value) + "\"" : "") + ";";
            case T:
                throw new IllegalArgumentException("Data type 'T' is not yet implemented");
            default:
                throw new RuntimeException();
        }
    }

}
