# Homework: Stein, Schere, Papier
Zu erstellen ist ein textbasiertes "Stein, Schere, Papier"-Spiel (S-S-P-Spiel) gegen das Programm. Beachte hierbei vor allem (Im)Mutability und logging, sowie alles aus EPRO gelernte. 
Schreibe mindestens 5 sinnvolle Unit-Tests!

## Spielbrett
Erstelle eine unveränderliche Klasse GameBoard, die den Zustand eines "S-S-P"-Spielbretts darstellt.
Das Brett ist ein 2x5-Raster, das die folgenden mögliche Werte für jede Zelle enthalten kann: R (Rock), P(Paper), S(Scissors), - (für leere Felder). 
Es soll möglich sein, das Spielbrett zu Spielbeginn aus einer Datei heraus mit einem bestimmten Spielstand zu befüllen. 

Es wird in 5 Runden gespielt. Pro Runde wird angegeben, welches Symbol der:die Spieler:in wählt. Danach wählt das Programm. Sobald dies abgeschlossen ist, werden beide Symbole aufgedeckt.

Gewonnen hat, wer mind. 3 Runden für sich entscheiden konnte. Nach jeder Runde wird der Gewinner ermittelt und angezeigt

Ein Beispielbrett nach 2 Runden sieht in der Ausgabe wie folgt aus
- R x S : Player
- S x P : Computer
- x - : N/A
- x - : N/A
- x - : N/A

Das Spielbrett ist unveränderlich!

Füge eine Methode playMove(Move move) - Move repräsentiert die Wahl des:Der Spieler:in - hinzu, die eine neue GameBoard-Instanz mit dem aktualisierten Zustand nach einem Zug zurückgibt. 
Diese Methode sollte eine Exception werfen, wenn der Zug illegal (kein passendes Symbol gewählt) ist. 
Der:die Spieler:in darf solange probieren, bis ein gültiger Zug gesetzt wurde.

# Spielablauf
Gespielt wird nach den üblichen Schlagregeln: R > S, P > R, S > P

Ab der 3. gespielten Runde wird ermittelt, ob es bereits eine:n Gesamtsieger:in gibt. Das Spiel kann gewonnen, verloren oder in Gleichstand gespielt werden.

## Benutzerinteraktion:

Nach jedem Zug drucke den aktuellen Zustand des Bretts in der oben angeführten Formatierung auf die Console und alle Nachrichten bezüglich eines eventuellen Spielausgangs (Gewinn oder Unentschieden) auszugeben
.
Prüfe, ob ein gültiges Symbol eingegeben wurde.

Nach jedem Zug kann das Spielbrett zur späteren Verwendung abgespeichert werden.

## Speichern und Laden des Brettes
Das Spiel kann nach jedem Zug in eine Textdatei abgespeichert werden. Hier muss keine besondere Formatierung eingehalten werden.

Speichern:
RS
SP
--
--
--


Wichtig ist, dass das abgespeicherte Spielbrett auf Wunsch zu Beginn eines neuen Spiels geladen werden können.

## Sonstige Anfoderungen
* Ziel ist es, Deine GameBoard-Klasse wirklich unveränderlich zu machen: Sobald ein Spielbrettobjekt erstellt wurde, sollte sein Zustand nicht modifizierbar sein.
* Kapsle die Spiellogik innerhalb der Klasse RPSGame, um die Interaktion zwischen dem Spiel und den Spielern klar zu halten.
* Öffentliche Methoden sollten auf die für die Interaktion mit dem Spiel notwendigen beschränkt sein.