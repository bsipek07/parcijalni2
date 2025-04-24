public class Osoba {
    private String ime;
    private String prezime;
    private String OIB;
    private String nazivFakulteta;

    public Osoba(String ime, String prezime, String OIB, String nazivFakulteta) {
        this.ime = ime;
        this.prezime = prezime;
        this.OIB = OIB;
        this.nazivFakulteta=nazivFakulteta;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getOIB() {
        return OIB;
    }

    public void setOIB(String OIB) {
        this.OIB = OIB;
    }

    public String getNazivFakulteta() {
        return nazivFakulteta;
    }

    public void setNazivFakulteta(String nazivFakulteta) {
        this.nazivFakulteta = nazivFakulteta;
    }
}
