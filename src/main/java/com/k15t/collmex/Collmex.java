package com.k15t.collmex;

import com.k15t.collmex.model.Angebot;
import com.k15t.collmex.model.CollmexDataException;
import com.k15t.collmex.model.Datensatz;
import com.opencsv.CSVReader;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;


public class Collmex {

    private String collmexKundenNr;
    private String user;
    private String password;

    private Integer firmaNr;


    public Collmex(String collmexKundenNr, String user, String password, Integer firmaNr) {
        this.collmexKundenNr = collmexKundenNr;
        this.user = user;
        this.password = password;
        this.firmaNr = firmaNr;
    }


    public <T> List<T> find(Class<T> c) {
        return new ArrayList<T>();
    }


    public void create(Datensatz... datensaetze) throws IOException {
        String csvInput = createLoginDatensatz();

        for (Datensatz datensatz : datensaetze) {
            csvInput += datensatz.toCsv();
        }

        System.out.println(csvInput);

        String csvOutput = Request.Post(getUrl())
                .bodyString(csvInput, ContentType.create("text/csv", "ISO-8859-1"))
                .execute()
                .returnContent()
                .asString();

        System.out.println(csvOutput);
        checkOutput(csvOutput);
    }


    private void checkOutput(String csvOutput) throws IOException {
        CSVReader csvReader = new CSVReader(new StringReader(csvOutput), ';');
        String[] firstLine = csvReader.readNext();

        if ("E".equals(firstLine[1]) || "W".equals(firstLine[1])) {
            throw new CollmexDataException(firstLine[1], firstLine[2], firstLine[3],
                    NumberUtils.createInteger(firstLine[4]));
        }
    }


    private String createLoginDatensatz() {
        return "LOGIN;" + user + ";" + password + "\n";
    }


    private String getUrl() {
        return "https://www.collmex.de/cgi-bin/cgi.exe?" + collmexKundenNr + ",0,data_exchange";
    }


    public Integer getFirmaNr() {
        return firmaNr;
    }


    public Angebot neuesAngebot() {
        return new Angebot(this);
    }

}
