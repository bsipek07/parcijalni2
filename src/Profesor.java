public class Profesor extends Osoba{

    private String JMBAG;



    public Profesor(String ime, String prezime, String OIB, String nazivFakulteta, String JMBAG) {
        super(ime, prezime, OIB, nazivFakulteta);
        this.JMBAG = JMBAG;
    }

    public String getJMBAG() {
        return JMBAG;
    }

    public void setJMBAG(String JMBAG) {
        this.JMBAG = JMBAG;
    }
}
