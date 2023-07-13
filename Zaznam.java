package cz.itnetwork.evidencepojisteni;

public class Zaznam {
    
/**
* Třída Zaznam představuje záznam o pojištěné osobě.
* Uchovává odkaz na objekt Osoba, který reprezentuje pojištěnou osobu.
*/
    
private Osoba pojistenaOsoba;
    
    public Zaznam(Osoba pojistenaOsoba) {
        this.pojistenaOsoba = pojistenaOsoba;
    }
    
    public Osoba getPojistenaOsoba() {
        return pojistenaOsoba;
    }
}
