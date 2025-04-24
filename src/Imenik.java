import java.io.*;
import java.util.ArrayList;

public class Imenik {

    private ArrayList<Ocijena> listaOcijena = new ArrayList<>();

    public Imenik() {
        listaOcijena = new ArrayList<>();
    }

    public void dodajOcijenu(Ocijena ocijena) {
        listaOcijena.add(ocijena);
    }

    public void spremi() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:/Users/PC/Downloads/imenik.txt"))) {
            for (Ocijena ocijena : listaOcijena) {
                writer.write(ocijena.toString());
            }
        } catch (IOException e) {
            System.out.println("Greška pri pisanju: " + e.getMessage());
        }

    }

    public void ucitaj(File fajl) {
        try (BufferedReader br = new BufferedReader(new FileReader(fajl))) {
            String linija;
            while ((linija = br.readLine()) != null) {
                if (linija.startsWith("Ocijena{")) {

                    int profesorIndex = linija.indexOf("profesor=");
                    int prezimeProfIndex = linija.indexOf(",prezime:");
                    int oibProfIndex = linija.indexOf(",OIB:");
                    int fakultetProfIndex = linija.indexOf(",Fakultet:");
                    int jmbagProfIndex = linija.indexOf(",JMBAG:");

                    if (profesorIndex != -1 && prezimeProfIndex != -1 && oibProfIndex != -1 && fakultetProfIndex != -1 && jmbagProfIndex != -1) {

                        String profesorData = linija.substring(profesorIndex + 9, prezimeProfIndex);
                        String prezimeProf = linija.substring(prezimeProfIndex + 9, oibProfIndex);
                        String oibProf = linija.substring(oibProfIndex + 5, fakultetProfIndex);
                        String fakultetProf = linija.substring(fakultetProfIndex + 10, jmbagProfIndex);
                        String jmbagProf = linija.substring(jmbagProfIndex + 7, linija.indexOf(",student="));


                        int studentIndex = linija.indexOf("student=");
                        int prezimeStudIndex = linija.indexOf(",prezime:", studentIndex);
                        int oibStudIndex = linija.indexOf(",OIB:", studentIndex);
                        int fakultetStudIndex = linija.indexOf(",Fakultet:", studentIndex);

                        if (studentIndex != -1 && prezimeStudIndex != -1 && oibStudIndex != -1 && fakultetStudIndex != -1) {
                            String studentData = linija.substring(studentIndex + 8, prezimeStudIndex);
                            String prezimeStud = linija.substring(prezimeStudIndex + 8, oibStudIndex);
                            String oibStud = linija.substring(oibStudIndex + 4, fakultetStudIndex);
                            String fakultetStud = linija.substring(fakultetStudIndex + 10, linija.indexOf(",ocijena"));


                            String ocjenaString = linija.substring(linija.indexOf("ocijena") + 7, linija.indexOf("}"));
                            int ocjena = Integer.parseInt(ocjenaString.trim());


                            Profesor profesor = new Profesor(profesorData, prezimeProf, oibProf, fakultetProf, jmbagProf);
                            Student student = new Student(studentData, prezimeStud, oibStud, fakultetStud);

                           // System.out.println(fakultetProf);
                           // System.out.println(fakultetStud);
                            Ocijena o = new Ocijena(profesor, student, ocjena);

                            listaOcijena.add(o);
                        } else {
                            System.out.println("Greška pri parsiranju studenta: " + linija);
                        }
                    } else {
                        System.out.println("Greška pri parsiranju profesora: " + linija);
                    }
                }
            }


            System.out.println("Učitane ocjene:");
            for (Ocijena o :listaOcijena) {
                System.out.println(o);
            }
            } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
