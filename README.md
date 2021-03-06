# collmex-api

collmex-api is a Java API for German Collmex Accounting software. To make the API simpler to understand
it uses the German terminology from the Collmex API.

:information_source: collmex-api is far from complete API support, currently it just support creating Angebot 
(quotes). Next steps would be: Support querying data records, support additional datatypes, and write tests.

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

## Additional Information

### Users

[![K15t Software GmbH](https://www.k15t.com/_/5BFA73E90151AA28368C3B0C11447E09/1454422141025/img/common/logo_k15t.png)](http://www.k15t.com)

### Links & Resources

* Collmex Documenation: [Collmex API](http://www.collmex.de/cgi-bin/cgi.exe?1005,1,help,api)
* Collmex Documenation: [Daten importieren](http://www.collmex.de/cgi-bin/cgi.exe?1005,1,help,daten_importieren)

### Building and Developing

collmex-api can be easily build with Java 7 and Maven 3. 

To add additional data types please check out [createDatensatz.js](./createDatensatz.js), which 
is essential to turn the data record documentation into Java files.                                     

## License

Licensed under The MIT License (MIT).
