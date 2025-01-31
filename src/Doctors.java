public class Doctors extends Person{
    protected String specialization;

    public Doctors(String name, int id, String specialization) {
        super(name, id);
        this.specialization = specialization;
    }

    @Override
    public String displayInfo() {
        return("Doctor - Name: " + name + ", ID: " + id + ", Specialization: " + specialization);
    }
}
