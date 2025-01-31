public class Staff extends Person{
    protected String role;

    public Staff(String name, int id, String role) {
        super(name, id);
        this.role = role;
    }

    @Override
    public String displayInfo() {
        return("Staff - Name: " + name + ", ID: " + id + ", Role: " + role);
    }
}
