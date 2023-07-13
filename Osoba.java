package cz.itnetwork.evidencepojisteni;


import java.util.Objects;


public class Osoba {
    
 /**
 * Třída Osoba představuje objekt reprezentující pojištěnou osobu.
 * Obsahuje atributy pro jméno, příjmení, věk a číslo osoby.
 * Poskytuje metody pro přístup k těmto atributům.
 */
    
private String jmeno;
    private String prijmeni;
    private int vek;
    private int cislo;
    
    
    public Osoba(String jmeno, String prijmeni, int vek, int cislo) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.vek = vek;
        this.cislo = cislo;
    }
    
    public String getJmeno() {
        return jmeno;
    }
    
    public String getPrijmeni() {
        return prijmeni;
    }
    
    public int getVek() {
        return vek;
    }
    
    public int getCislo() {
        return cislo;
    }

    

    @Override
    public boolean equals(Object obj) {
        
        // Porovnání objektů na základě atributů jméno a příjmení
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Osoba other = (Osoba) obj;
        if (!Objects.equals(this.jmeno, other.jmeno)) {
            return false;
        }
        return Objects.equals(this.prijmeni, other.prijmeni);
    } 
}