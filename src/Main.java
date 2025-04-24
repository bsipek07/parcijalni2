import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args)throws IOException {
        Student s1= new Student("Marko","Markic","227788999777","FER");
        Student s2= new Student("Ivan","Ivankoivc","445588779933","FER");
        Profesor p1= new Profesor("Drago","Mihocinec","44558846456","FER","44887799");

        Ocijena o1= new Ocijena(p1,s1,3);
        Ocijena o2 = new Ocijena(p1,s2,5);
        Ocijena o3= new Ocijena(p1,s1,4);

        Imenik imenik= new Imenik();

        imenik.dodajOcijenu(o1);
        imenik.dodajOcijenu(o2);
        //imenik.dodajOcijenu(o3);
        imenik.spremi();


        File izvor = new File("C:/Users/PC/Downloads/imenik.txt");

        imenik.ucitaj(izvor);

    }
}
