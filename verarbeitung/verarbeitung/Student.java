package verarbeitung;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Student extends Kunde {
    private String universitaet;
    private String studienfach;
    private List<Semester> bescheinigungen;

    public Student(String vorname, String nachname, String adresse, LocalDate gebdat, String universitaet, String studienfach) {
        super(vorname, nachname, adresse, gebdat);
        this.studienfach = studienfach;
        this.universitaet = universitaet;
        this.bescheinigungen = new ArrayList<>();
    }

    public Student(String vorname, String nachname, String adresse, String gebdat, String universitaet, String studienfach) {
        super(vorname, nachname, adresse, gebdat);
        this.studienfach = studienfach;
        this.universitaet = universitaet;
        this.bescheinigungen = new ArrayList<>();
    }

    public String getUniversitaet() {
        return universitaet;
    }

    public void setUniversitaet(String universitaet) {
        this.universitaet = universitaet;
    }

    public String getStudienfach() {
        return studienfach;
    }

    public void setStudienfach(String studienfach) {
        this.studienfach = studienfach;
    }

    public boolean studienbescheinigungEinreichen(String jahr, Semester.Zeitraum zeitraum) {
        Semester semester = new Semester(zeitraum, jahr);
        return studienbescheinigungEinreichen(semester);
    }

    public boolean studienbescheinigungEinreichen(Semester semester) {
        if (!bescheinigungen.contains(semester)) {
            bescheinigungen.add(semester);
            return true;
        } else return false;
    }

    public boolean studienbescheinigungLoeschen(String jahr, Semester.Zeitraum zeitraum) {
        Semester semester = new Semester(zeitraum, jahr);
        return studienbescheinigungLoeschen(semester);
    }

    public boolean studienbescheinigungLoeschen(Semester semester) {
        if (bescheinigungen.contains(semester)) {
            bescheinigungen.remove(semester);
            return true;
        } else return false;
    }

    public boolean hatStudienbescheinigung(String jahr, Semester.Zeitraum zeitraum) {
        Semester semester = new Semester(zeitraum, jahr);
        return hatStudienbescheinigung(semester);
    }

    public boolean hatStudienbescheinigung(Semester semester) {
        return bescheinigungen.contains(semester);
    }

    @Override
    public String toString() {
        StringBuilder ausgabe = new StringBuilder(super.toString());
        ausgabe.append(this.studienfach).append(System.getProperty("line.separator"));
        ausgabe.append(this.universitaet).append(System.getProperty("line.separator"));
        ausgabe.append("Liste der Semester, fuer die eine Studienbescheinigung vorliegt: ").append(System.getProperty("line.separator"));
        for (Semester tempSemester : bescheinigungen) {
            switch (tempSemester.getZeitraum()) {

                case SOMMERSEMESTER: {
                    ausgabe.append("Sommersemester ").append(tempSemester.getJahr()).append(System.getProperty("line.separator"));
                }
                break;
                case WINTERSEMESTER: {
                    ausgabe.append("Wintersemester ").append(tempSemester.getJahr()).append(System.getProperty("line.separator"));
                }
                break;
            }

        }
        ausgabe.append("Ende der Liste der Studienbescheinigungen");
        return ausgabe.toString();
    }

    public static class Semester {


        public enum Zeitraum {
            SOMMERSEMESTER,
            WINTERSEMESTER
        }

        private Zeitraum zeitraum;
        private String jahr;

        public Semester(Zeitraum zeitraum, String jahr) {
            this.zeitraum = zeitraum;
            this.jahr = jahr;
        }

        public Zeitraum getZeitraum() {
            return zeitraum;
        }

        public String getJahr() {
            return jahr;
        }
    }


}
