package cz.itnetwork.evidencepojisteni;

import java.util.ArrayList;

public class Databaze {
    
private ArrayList<Zaznam> zaznamy;

    /**
     * Třída Databaze představuje databázi pro ukládání pojištěných osob.
    * Umožňuje přidávat, vyhledávat a vypisovat pojištěné osoby.
    */
    
    public Databaze() {
        zaznamy = new ArrayList<>();
    }
    
    //Metoda pro přidání nové osoby do databáze
    public void pridejPojistenouOsobu(Osoba osoba) {
        Zaznam zaznam = new Zaznam(osoba);
        zaznamy.add(zaznam);
    }
    
    //Metoda pro vyhledávání osoby z databáze
    public ArrayList<Zaznam> vyhledejPojisteneOsoby(Osoba osoba) {
        ArrayList<Zaznam> nalezeneZaznamy = new ArrayList<>();
        
        for (Zaznam zaznam : zaznamy) {
            Osoba aktualniOsoba = zaznam.getPojistenaOsoba();
            
            if (aktualniOsoba != null && aktualniOsoba.equals(osoba)) {
                nalezeneZaznamy.add(zaznam);
            }
        }
        
        return nalezeneZaznamy;
    }
    
    //Metoda pro výpis pojištěných osob z databáze
    public void vypisPojisteneOsoby() {
        if (zaznamy.isEmpty()) {
            System.out.println("Žádné pojištěné osoby nenalezeny.");
        } else {
            System.out.println("Pojištěné osoby:");
            for (Zaznam zaznam : zaznamy) {
                Osoba osoba = zaznam.getPojistenaOsoba();
                System.out.println("Křestní jméno: " + osoba.getJmeno());
                System.out.println("Příjmení: " + osoba.getPrijmeni());
                System.out.println("Věk: " + osoba.getVek());
                System.out.println("Číslo: " + osoba.getCislo());
                System.out.println("--------------------");
            }
        }
    }
    
    //Metoda pro výpis hlavního menu
    public void vypisHlavniMenu() {
        System.out.println("--------------------");
        System.out.println("Databáze pojištěných osob");
        System.out.println("--------------------");
        System.out.println("Vyberte akci:");
        System.out.println("1 - Přidat novou pojištěnou osobu");
        System.out.println("2 - Vypsat všechny pojištěné osoby");
        System.out.println("3 - Vyhledat pojištěnou osobu");
        System.out.println("4 - Konec");
    }
}
