# En lille tour igennem "modernere" Java

Her er et eksempel på en gang rodet "old school" Java, ikke eksemplarisk og dogmatisk, men
det er der så meget kode, der ikke er.

Originalen ligger i branchen 'main'. Lad os se om vi kan rette lidt op på det.

TLDR; Kig i de andre branches.

# Hvad er der sket i Java-sproget siden Java 8?

<table border="1" style="border: 1px solid black; border-collapse: collapse;" cellpadding="4">
<tr><th>Feature</th><th>Forklaring</th><th>Version</th></tr>
<tr><td>

[JDK-modularisering](https://openjdk.java.net/jeps/200)
+
[JMPS](https://openjdk.java.net/projects/jigsaw/spec/)

</td>
<td>Opdeling af JDK'et i moduler. Nå, ja, også et modulsystem.</td>
<td>9</td></tr>
<tr><td>

[JShell](https://openjdk.java.net/projects/jigsaw/spec/)

</td>
<td>En REPL for Java (ok, det er ikke sproget som sådan...)</td>
<td>9</td></tr>
<tr><td>

[Lokal typeinferens (i lambda)](https://openjdk.java.net/jeps/286)

</td>
<td>Nu kan man skrive<br> 

    var x = 42;

</td>
<td>10</td></tr>
<tr><td>

[Lokal typeinferens (i lambda)](https://openjdk.java.net/jeps/323)

</td>
<td>Nu kan man skrive:<br>

    Consumer<Long> = (var a) -> whatevs(a);

</td>
<td>11</td></tr>
<tr><td>

[Switch expressions](https://openjdk.java.net/jeps/361)

</td>
<td>Nu kan man skrive:<br>
<pre>
	LocalDate d = whatever();
	var antalDage = switch(d.getMonth()) {
	   case JANUARY, MARCH, MAY, JULY,
	        AUGUST, OCTOBER, DECEMBER -> 31;
	   case FEBRUARY -> {
	      if (d.getYear() % 4 == 0) yield 29;
	      yield 28;
	   }
	   default -> 30;
	};
    // Hvem spotter fejlen?
</pre>
</td>
<td>14</td></tr>
<tr><td>


[Tekstblokke](https://openjdk.java.net/jeps/378)

</td>
<td>Indenterede multilinjestrengkonstanter:<br>

    var s = """
            <?xml version="1.0"?>
            <root>
                <element attribute="value"/>
            </root>
            """;

</td>
<td>15</td></tr>
<tr><td>

[Records](https://openjdk.java.net/jeps/395)

</td>
<td>De bliver kaldt "Nominelle tupler" for at give dem et funktionelt vibe, men det er
syntaktisk sukker for `final` klasser med lidt special sauce.<br>

    record Single(String kunstner, String titel) { }

</td>
<td>16</td></tr>
<tr><td>

["Pattern matching"](https://openjdk.java.net/jeps/394)

</td>
<td>Der er meget fede citationstegn om det begreb (indtil videre).<br>

    if (obj instanceof String s) {
        return s.getLength();
    } else {
        return 42;
    }

</td>
<td>16</td></tr>
<tr><td>

[Sealed classes](https://openjdk.java.net/jeps/409)

</td>
<td>Begrænsning af hvilke klasser, der kan implementere et interface eller udvide en klasse.<br>
Et skridt på vej imod bedre pattern matching.
</td>
<td>17</td></tr>
</table>

## Links til Java versioner

OpenJDKs [versionsoversigt siden version 9](https://openjdk.java.net/projects/jdk/), herunder:

* [Java 9](https://openjdk.java.net/projects/jdk9/) (2017-09-17)
* [Java 10](https://openjdk.java.net/projects/jdk/10/) (2018-03-20)
* [Java 11](https://openjdk.java.net/projects/jdk/11/) (2018-09-25)
* [Java 12](https://openjdk.java.net/projects/jdk/12/) (2019-03-19)
* [Java 13](https://openjdk.java.net/projects/jdk/13/) (2019-09-17)
* [Java 14](https://openjdk.java.net/projects/jdk/14/) (2020-03-17)
* [Java 15](https://openjdk.java.net/projects/jdk/15/) (2020-09-15)
* [Java 16](https://openjdk.java.net/projects/jdk/16/) (2021-03-16)
* [Java 17](https://openjdk.java.net/projects/jdk/17/) (snart)

Oracle har også nogle [virkelig detaljerede release notes](https://www.oracle.com/java/technologies/javase/jdk-relnotes-index.html).

## Se endvidere

[Tobi Ajilas præsentation på DEVOXX 2019, der fik mig interesseret i Valhalla](https://www.youtube.com/watch?v=Xf22I16jVyE)

[Mark Reinhold forklarer om sammenhængen imellem Amber, Loom, Panama and Valhalla, på Devoxx UK](https://youtu.be/kpio9jFhpD8)

