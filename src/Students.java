public class Students extends Person{
    protected String course;

    public Students(String name, int id, String course) {
        super(name, id);
        this.course = course;
    }

    @Override
    public String displayInfo() {
        return("Student - Name: " + name + ", ID: " + id + ", Course: " + course);
    }
}
