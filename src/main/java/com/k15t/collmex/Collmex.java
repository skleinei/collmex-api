package com.k15t.collmex;

import com.opencsv.CSVReader;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Collmex {

    private static final Logger logger = LoggerFactory.getLogger(Collmex.class);

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


    public void save(Datensatz... datensaetze) throws IOException {
        String csvInput = createLoginDatensatz();

        for (Datensatz datensatz : datensaetze) {
            datensatz.firmaNr(firmaNr);
            csvInput += datensatz.toCsv();
        }

        logger.debug(csvInput);

        logger.info("Sending CSV to Collmex.");
        String csvOutput = Request.Post(getBaseUrl() + ",0,data_exchange")
                .bodyString(csvInput, ContentType.create("text/csv", "ISO-8859-1"))
                .execute()
                .returnContent()
                .asString();

        logger.debug(csvOutput);

        checkOutputAndUpdateIds(csvOutput, datensaetze);
    }


    private void checkOutputAndUpdateIds(String csvOutput, Datensatz... datensaetze) throws IOException {
        Map<Integer, Integer> temp2RealIdMap = new HashMap<Integer, Integer>();

        CSVReader reader = new CSVReader(new StringReader(csvOutput), ';');

        String [] csvLine;
        while ((csvLine = reader.readNext()) != null) {
            if (Satzart.MESSAGE.equals(csvLine[0])) {
                if ("E".equals(csvLine[1]) || "W".equals(csvLine[1])) {
                    throw new CollmexDataException(csvLine[1], csvLine[2], csvLine[3], NumberUtils.createInteger(csvLine[4]));
                } else {
                    logger.info("SUCCESS ({}): {}", csvLine[3], csvLine[2]);
                }
            } else if (Satzart.NEW_OBJECT_ID.equals(csvLine[0])) {
                temp2RealIdMap.put(NumberUtils.createInteger(csvLine[2]), NumberUtils.createInteger(csvLine[1]));
            }
        }

        for (Datensatz datensatz : datensaetze) {
            datensatz.id(temp2RealIdMap.get(datensatz.id()));
        }

    }


    private String createLoginDatensatz() {
        return "LOGIN;" + user + ";" + password + "\n";
    }


    public String getBaseUrl() {
        return "https://www.collmex.de/cgi-bin/cgi.exe?" + collmexKundenNr;
    }


    public String getUser() {
        return user;
    }


    public String getPassword() {
        return password;
    }
}
