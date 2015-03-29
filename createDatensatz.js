// This code create the implementation code for Datensatz implementations
// of the Collmex API, and saves it in the clipboard. To use this, open a
// description in the Collmex API documentation, fiddle with the "datansatz"
// variable in the script and execute in the Chrome Dev Tools.
//
// The following manual clean up needs to be done afterwards:
// * Check for compiler errors (obviously)
// * Check which fields are read- or export-only and remove the setters.
// * Remove setter for satzart, define a constant in com.k15t.collmex.model.Satzart,
//   and us in getter for satzart.
// * Check if certain fields should be made writable through screen scrapers.


var datensatz = {
    'className': 'Angebot',
    'isMember': function (rawName) {
        return (rawName !== 'Satzart');
    },
    'isSetter': function (rawName) {
        return (rawName !== 'Satzart') &&
            (rawName !== 'Angebotsart') &&
            (rawName !== 'Firma Nr') &&
            (rawName !== 'Status') &&
            (rawName !== 'Reserviert') &&
            (rawName !== 'Positionswert') &&
            (rawName !== 'Erlösart') &&
            (rawName !== 'Umsatz') &&
            (rawName !== 'Kosten') &&
            (rawName !== 'Rohertrag') &&
            (rawName !== 'Marge') &&
            (rawName.indexOf('Kunde-') != 0);
    },
    'isGetter': function (rawName) {
        return true;
    }
};


// === don't change below here =======

window.copyJavaToClipboard = function () {
    var $ = window.jQuery;

    var typeMap = {
        'C': 'String',
        'I': 'Integer',
        'N': 'Double',
        'D': 'DateTime',
        'M': 'Double',
        'T': 'DateTime'
    };


    function prepareName(nameRaw) {
        var name = nameRaw;

        name = name.charAt(0).toLowerCase() + nameRaw.slice(1);
        name = name.replace(/\./gi, '');
        name = name.replace(/\-/gi, '');
        name = name.replace(/\(/gi, '');
        name = name.replace(/\)/gi, '');
        name = name.replace(/\//gi, '');
        name = name.replace(/ /gi, '');

        name = name.replace(/ä/gi, 'ae');
        name = name.replace(/ö/gi, 'oe');
        name = name.replace(/ü/gi, 'ue');

        return name;
    }

    function prepareMax(maxRaw) {
        var max = maxRaw;

        max = max.replace(/\./gi, '');

        return max;
    }

    var fields = $('table.help td.help:nth-child(2)');

    var text = "";

    $(fields).each(function generateMembers() {
        var nameRaw = $(this).text();
        var name = prepareName(nameRaw);
        var typeRaw = $(this).next().text().trim();
        var type = typeMap[typeRaw];
        var maxRaw = $(this).next().next().text().trim();
        var max = prepareMax(maxRaw);

        if (datensatz.isMember(nameRaw)) {
            text += '    private ' + type + ' ' + name + ';\n';
        }
    });

    text += '\n\n';

    $(fields).each(function generateGetterAndSetter() {
        var nameRaw = $(this).text();
        var name = prepareName(nameRaw);
        var typeRaw = $(this).next().text();
        var type = typeMap[typeRaw];
        var maxRaw = $(this).next().next().text().trim();
        var max = prepareMax(maxRaw);
        var description = $(this).next().next().next().html().trim();

        if (datensatz.isSetter(nameRaw)) {
            text += '    public ' + datensatz.className + ' ' + name + '(' + type + ' ' + name + ') {\n';
            text += '        validate("' + name + '", Datentyp.' + typeRaw + ', ' + max + ', ' + name + ');\n';
            text += '        this.' + name + ' = ' + name + ';\n';
            text += '        return this;\n';
            text += '    }\n';
            text += '\n';
            text += '\n';
        }

        if (datensatz.isGetter(nameRaw)) {
            text += '    /**\n';
            text += '     * ' + nameRaw + '<br/>\n';
            text += '     * ' + description + '\n';
            text += '     */\n';
            text += '    public ' + type + ' ' + name + '() {\n';
            text += '        return this.' + name + ';\n';
            text += '    }\n';
            text += '\n';
            text += '\n';
        }
    });


    //text += '    private ' + type + ' ' + name + ';\n';
    text += '    @Override\n';
    text += '    public String toCsv() {\n';
    text += '        String csv = "";\n';

    $(fields).each(function generateToCsv() {
        var nameRaw = $(this).text();
        var name = prepareName(nameRaw);
        var typeRaw = $(this).next().text().trim();
        var type = typeMap[typeRaw];
        var maxRaw = $(this).next().next().text().trim();
        var max = prepareMax(maxRaw);

        if (datensatz.isMember(nameRaw)) {
            text += '        csv += toCsvField("' + nameRaw + '", Datentyp.' + typeRaw + ', ' + name + '());\n';
        }
    });

    text += '        csv += "\\n";\n';
    text += '        return csv;\n';
    text += '    }\n';
    text += '\n';

    copy(text);

};


if (typeof(jQuery) === 'undefined') {
    var script = document.createElement('script');
    script.setAttribute('src', 'https://code.jquery.com/jquery.js');
    document.getElementsByTagName('body')[0].appendChild(script);
    script.onload = window.copyJavaToClipboard;
} else {
    window.copyJavaToClipboard();
}
