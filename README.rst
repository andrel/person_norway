Norwegian "Fødselsnummer" representation and validation.
========================================================

"Fødselsnummer" is a the norwegian National Identification number.

It consists of a date of birth, an individual number and two check digits.

This project aims to provide basic utility methods for validating and extracting information about these numbers.

For definition, see `Forskrift om folkeregistrering`_


Example use
-----------

Validate a string-representation.

::

    boolean isValid = Fodselsnummer.isValid("12345678912");


Create an object representing a fødselsnummer.

::

    Fodselsnummer fNr = Fodselsnummer.valueOf("12345678912");


Access properties of a fødselsnummer.

::

    fNr.isMale();
    fNr.toString();
    fNr.getBirthYear4Digit();
    fNr.getBirthYear2Digit();
    fNr.getMonth();
    fNr.getDay();


.. _Forskrift om folkeregistrering: http://www.lovdata.no/cgi-wift/wiftldles?doc=/usr/www/lovdata/for/sf/fd/td-20071109-1268-002.html#2-2