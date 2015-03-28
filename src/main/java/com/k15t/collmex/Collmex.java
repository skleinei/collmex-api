package com.k15t.collmex;

import com.k15t.collmex.model.Angebot;
import com.k15t.collmex.model.Datensatz;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;

import java.io.IOException;


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
