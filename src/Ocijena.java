import java.util.Objects;

public class Ocijena {

    private Profesor profesor;
    private Student student;
    private int ocijena;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Ocijena ocijena1 = (Ocijena) o;
        return ocijena == ocijena1.ocijena && Objects.equals(profesor, ocijena1.profesor) && Objects.equals(student, ocijena1.student);
    }

    @Override
    public int hashCode() {
        return Objects.hash(profesor, student, ocijena);
    }

    public Ocijena(Profesor profesor, Student student, int ocijena)throws IllegalArgumentException {
        this.profesor = profesor;
        this.student = student;

        if(!profesor.getNazivFakulteta().equals(student.getNazivFakulteta())){
            throw new IllegalArgumentException("Profesor i student moraju biti sa istog fakulteta.");
        }
        if(ocijena<=0 || ocijena>5){
            throw new IllegalArgumentException("Ocijena ne može biti manja od 0 ili veća od 5.");
        }else {
            this.ocijena = ocijena;
        }

    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getOcijena() {
        return ocijena;
    }

    public void setOcijena(int ocijena) {
        this.ocijena = ocijena;
    }

    @Override
    public String toString() {
        return "Ocijena{" +
                "profesor=" + profesor.getIme() + ",prezime:"+profesor.getPrezime()+",OIB:"+profesor.getOIB()+",Fakultet:"+profesor.getNazivFakulteta()+",JMBAG:"+profesor.getJMBAG()
               +",student="+student.getIme()+",prezime:"+student.getPrezime()+",OIB:"+student.getOIB()+",Fakultet:"+student.getNazivFakulteta()+",ocijena"+ocijena+"}";
    }
}
