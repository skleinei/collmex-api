# collmex-api

collmex-api is a Java API for German Collmex Accounting software. To make the API simpler to understand
it uses the German terminology from the Collmex API.

:information_source: collmex-api is far from complete API support, currently it just support creating Angebot 
(quotes). Next steps would be: Support querying data records, support additional datatypes, and write tests
(especially for the screen scraping part).

## Getting Started

The central part of the API is the `Collmex` class. Create an instance programmatically or
via Spring and use it to create, read, update or delete objects in Collmex.

```java
Collmex collmex = new Collmex("128733", "username", "password", 1, true);

Angebot angebot = Angebot.create(-1)
        .kundenNr(10000)
        .addPosition(
                Position.create(10)
                        .positionstyp(Position.Typ.NORMAL_POSITION)
                        .produktnummer(produktnummer)
                        .produktbeschreibung(positionstext)
                        .einzelpreis(111.20)
                        .menge(1.0)
                        .kosten(11.1)
        )
collmex.save(angebot);
```

## Features
                                                                                        
### Fluent API

As seen above the API has a nice fluent API.

### Extended API via Screen Scraping

Some fields such as "Kosten manuell" can not be updated via the Collmex API. Therefore collmex-api
does some screen scraping to update those fields as well.

## Additional Information

### Users

[![K15t Software GmbH](https://www.k15t.com/_/5BFA73E9014B6A2875A0459873CB3E3D/1423415211446/images/header_logo.png)](http://www.k15t.com)

### Links & Resources

* Collmex: Collmex API,\\URL: http://www.collmex.de/cgi-bin/cgi.exe?1005,1,help,api
* Collmex: Daten importieren,\\URL: http://www.collmex.de/cgi-bin/cgi.exe?1005,1,help,daten_importieren

### Building and Developing

collmex-api can be easily build with Java 7 and Maven 3. There are a few dependencies most
notable HTMLUnit which is used for screen scraping.

To add additional data types please check out [createDatensatz.js](./createDatensatz.js), which 
is essential to turn the data record documentation into Java files.                                     

## License

Licensed under the Apache License, Version 2.0
