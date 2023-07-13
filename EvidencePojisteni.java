package cz.itnetwork.evidencepojisteni;



import java.util.ArrayList;
import java.util.Scanner;

public class EvidencePojisteni {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Databaze osobniDatabaze = new Databaze();
        String volba = "";
        
        //Hlavní cyklus programu
        do {
            osobniDatabaze.vypisHlavniMenu();
            volba = scanner.nextLine();
            System.out.println();

            switch (volba) {
                case "1":
                    
                    //Ověření délky jména
                    String jmeno;
                    do {
                        System.out.println("Zadej křestní jméno pojištěné osoby:");
                        jmeno = scanner.nextLine();
                        if (jmeno.length() < 3 || jmeno.length() > 10) {
                            System.out.println("Zadal jsi chybné jméno (3-10 znaků).");
                            } 
                    } while (jmeno.length() < 3 || jmeno.length() > 10);
                    
                    //Ověření délky příjmení
                    String prijmeni;
                    do {
                        System.out.println("Zadej příjmení pojištěné osoby:");
                        prijmeni = scanner.nextLine();
                        if (prijmeni.length() < 3 || prijmeni.length() > 20){
                            System.out.println("Zadal jsi chybné příjmení (3-20 znaků)");
                        }  
                    } while (prijmeni.length() < 3 || prijmeni.length() > 20);
                    
                    //Ověření věku
                    int vek;
                    do {
                        System.out.println("Zadej věk pojištěné osoby");
                        vek = Integer.parseInt(scanner.nextLine());
                        if (vek < 1 || vek > 99){
                            System.out.println("Zadal jsi neplatný věk");
                        }
                    } while (vek < 1 || vek > 99);
                    
                    //Ověření telefonního čísla
                    int cislo;
                    do {
                       System.out.println("Zadej telefonní číslo pojištěné osoby");
                       cislo = Integer.parseInt(scanner.nextLine());
                       String cisloString = String.valueOf(cislo);
                       if (cisloString.length() != 9){
                           System.out.println("Zadal jsi chybné telefonní číslo");
                       }
                    } while (String.valueOf(cislo).length() != 9);
                    
                    osobniDatabaze.pridejPojistenouOsobu(new Osoba(jmeno, prijmeni, vek, cislo));
                    break;
                case "2":
                    osobniDatabaze.vypisPojisteneOsoby();
                    break;
                case "3":
                    System.out.println("Zadej křestní jméno pojištěné osoby k vyhledávání­:");
                    String hledaneJmeno = scanner.nextLine();

                    System.out.println("Zadej příjmení pojištěné osoby k vyhledávání­:");
                    String hledanePrijmeni = scanner.nextLine();

                    Osoba hledanaOsoba = new Osoba(hledaneJmeno, hledanePrijmeni, 0, 0);
                    ArrayList<Zaznam> nalezeneZaznamy = osobniDatabaze.vyhledejPojisteneOsoby(hledanaOsoba);
                    if (nalezeneZaznamy.isEmpty()) {
                        System.out.println("pojištěná osoba nenalezena.");
                    } else {
                        System.out.println("Nalezeny pojištěné osoby:");
                        for (Zaznam zaznam : nalezeneZaznamy) {
                            Osoba nalezenaOsoba = zaznam.getPojistenaOsoba();
                            System.out.println("Křestní jméno: " + nalezenaOsoba.getJmeno());
                            System.out.println("Příjmení­: " + nalezenaOsoba.getPrijmeni());
                            System.out.println("Věk: " + nalezenaOsoba.getVek());
                            System.out.println("Číslo: " + nalezenaOsoba.getCislo());
                            System.out.println("--------------------");
                        }
                    }
                    break;
                case "4":
                    break;
                default:
                    System.out.println("Neplatná volba");
                    break;
            }
        } while (!volba.equals("4"));
    }
}
