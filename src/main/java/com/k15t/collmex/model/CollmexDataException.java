package com.k15t.collmex.model;


public class CollmexDataException extends RuntimeException {

    private String meldungstyp;
    private String meldungsnummer;
    private String meldungstext;
    private Integer zeile;


    public CollmexDataException(String meldungstyp, String meldungsnummer, String meldungstext, Integer zeile) {
        super("Zeile " + zeile + ": " + meldungstext + " (#" + meldungsnummer + ")");
        this.meldungstyp = meldungstyp;
        this.meldungsnummer = meldungsnummer;
        this.meldungstext = meldungstext;
        this.zeile = zeile;
    }
}
