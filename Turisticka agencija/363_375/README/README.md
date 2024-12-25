# WebTA - Spring Boot Projekt

WebTA je Spring Boot aplikacija koja omogućava korisnicima da izaberu destinacije za putovanja i pohrane ih u bazu podataka.
Aplikacija koristi Thymeleaf za prikaz web stranica, Spring Security za autentifikaciju i PostgreSQL bazu podataka za čuvanje podataka korisnika i destinacija.

## Tehnologije

- **Spring Boot**: Framework za brzo razvijanje Java aplikacija.
- **Spring Security**: Za autentifikaciju i autorizaciju korisnika.
- **Thymeleaf**: Java templating engine za kreiranje HTML stranica.
- **JPA/Hibernate**: Za pristup bazi podataka.
- **PostgreSQL**: Relacijska baza podataka.
- **Lombok**: Za automatsko generisanje getter/setter metoda i drugih korisnih metoda.
- **Maven**: Alat za upravljanje zavisnostima i izgradnju projekta.

## Preduslovi

Prije nego što pokreneš projekat, potrebno je da imaš instalirane sljedeće alate:

1. **Java 23** ili novija verzija (Java Development Kit - JDK).
2. **Maven** za upravljanje zavisnostima i izgradnju projekta.
3. **PostgreSQL** baza podataka.
4. **IDE** (npr. IntelliJ IDEA ili Eclipse).

## Instalacija

Preuzeti zip file raspakovati i otvoriti u Intallij IDEA.

2. Konfiguriši PostgreSQL bazu podataka
 U application.properties fajlu (koji se nalazi u src/main/java/resources direktorijumu), postavi parametre za konekciju sa bazom podataka:
properties
Copy code
spring.datasource.url=jdbc:postgresql://localhost:5432/webta
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

Zamjeni your_username i your_password sa stvarnim kredencijalima tvoje PostgreSQL baze.
3. Pokreni aplikaciju
Pokretanje iz IDE:
Ako koristiš IDE kao što je IntelliJ IDEA ili Eclipse, možeš jednostavno kliknuti na Run dugme za pokretanje Spring Boot aplikacije.
4. Pristup aplikaciji
Nakon što pokreneš aplikaciju, možeš pristupiti web aplikaciji na sledećem URL-u:
http://localhost:8081

5. Registracija i logovanje korisnika
Na početnoj stranici ćeš moći da se registruješ kao novi korisnik i loguješ se. Ulogovani korisnici će moći da odaberu destinaciju za putovanje i pohrane je u bazu podataka.
Struktura projekta
src/main/java/projekat/webTA - Glavni Java kod.
Controllers: Paket koji sadrži kontrolere za obradu HTTP zahteva.
Models: Paket sa modelima (korisnici, destinacije).
Services: Paket za logiku servisa.
src/main/resources:
templates: Thymeleaf šabloni za generisanje HTML stranica.
static: Staticke datoteke poput slika i CSS fajlova.
application.properties: Konfiguracija aplikacije.
Kako aplikacija funkcioniše
Registracija korisnika: Novi korisnici se mogu registrovati sa korisničkim imenom, lozinkom i ulogom.
Logovanje korisnika: Korisnici se mogu logovati koristeći svoje korisničko ime i lozinku.
Odabir destinacije: Nakon logovanja, korisnici mogu odabrati destinaciju (Pariz, Rim, Santorini, Istanbul, Oslo, Prag) i pohraniti je u bazu.
Prikaz destinacija: Svi korisnici mogu videti listu dostupnih destinacija na sajtu.
Dodaci
Postavljanje korisničke uloge: U aplikaciji je implementirano postavljanje uloge za korisnike (USER, ADMIN).
Baza destinacija: Destinacije (kao što su Pariz, Rim, Santorini, itd.) su inicijalizovane u bazi prilikom pokretanja aplikacije.
Problemi i rešenja
Greška u povezivanju sa bazom: Uveri se da je PostgreSQL ispravno postavljen i da su korisnički podaci tačni.
Greške pri pokretanju aplikacije: Proveri da li su svi zavisni paketi pravilno dodati u pom.xml.


