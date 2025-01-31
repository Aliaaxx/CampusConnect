import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagementSystemGUI {
    private JFrame mainFrame;
    private JTextField textFieldId;
    private JTextField textFieldName;
    private JTextField textFieldSpecializationCourseRole;
    private static ArrayList<Person> persons = new ArrayList<>();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                ManagementSystemGUI window = new ManagementSystemGUI();
                window.mainFrame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public ManagementSystemGUI() {
        initializeMain();
    }

    private void initializeMain() {
        mainFrame = new JFrame();
        mainFrame.setBounds(100, 100, 210, 300);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.getContentPane().setLayout(null);

        //Main Menu

        JButton btnAddPerson = new JButton("Add Person");
        btnAddPerson.setBounds(20, 20, 150, 30);
        mainFrame.getContentPane().add(btnAddPerson);
        btnAddPerson.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openAddPersonWindow();
            }
        });

        JButton btnDisplayAllPersons = new JButton("Display All Persons");
        btnDisplayAllPersons.setBounds(20, 70, 150, 30);
        mainFrame.getContentPane().add(btnDisplayAllPersons);
        btnDisplayAllPersons.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayAllPersons();
            }
        });

        JButton btnDeletePerson = new JButton("Delete Person");
        btnDeletePerson.setBounds(20, 120, 150, 30);
        mainFrame.getContentPane().add(btnDeletePerson);
        btnDeletePerson.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openDeletePersonWindow();
            }
        });

        JButton btnEditPersons = new JButton("Edit Persons");
        btnEditPersons.setBounds(20, 170, 150, 30);
        mainFrame.getContentPane().add(btnEditPersons);
        btnEditPersons.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openEditPersonsWindow();
            }
        });

        JButton btnExit = new JButton("Exit");
        btnExit.setBounds(20, 220, 150, 30);
        mainFrame.getContentPane().add(btnExit);
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void openAddPersonWindow() {
        JFrame addPersonFrame = new JFrame();
        addPersonFrame.setBounds(100, 100, 315, 100);
        addPersonFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addPersonFrame.getContentPane().setLayout(null);

        JButton btnDoctor = new JButton("Doctor");
        btnDoctor.setBounds(20, 20, 80, 30);
        addPersonFrame.getContentPane().add(btnDoctor);
        btnDoctor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openPersonDetailsWindow("Doctor");
                addPersonFrame.dispose();
            }
        });

        JButton btnStaff = new JButton("Staff");
        btnStaff.setBounds(110, 20, 80, 30);
        addPersonFrame.getContentPane().add(btnStaff);
        btnStaff.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openPersonDetailsWindow("Staff");
                addPersonFrame.dispose();
            }
        });

        JButton btnStudent = new JButton("Student");
        btnStudent.setBounds(200, 20, 80, 30);
        addPersonFrame.getContentPane().add(btnStudent);
        btnStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openPersonDetailsWindow("Student");
                addPersonFrame.dispose();
            }
        });

        addPersonFrame.setVisible(true);
    }

    private void openPersonDetailsWindow(String personType) {
        JFrame personDetailsFrame = new JFrame();
        personDetailsFrame.setBounds(100, 100, 400, 200);
        personDetailsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        personDetailsFrame.getContentPane().setLayout(null);

        JLabel lblName = new JLabel("Name:");
        lblName.setBounds(20, 20, 80, 20);
        personDetailsFrame.getContentPane().add(lblName);

        textFieldName = new JTextField();
        textFieldName.setBounds(120, 20, 150, 20);
        personDetailsFrame.getContentPane().add(textFieldName);
        textFieldName.setColumns(10);

        JLabel lblId = new JLabel("ID:");
        lblId.setBounds(20, 50, 80, 20);
        personDetailsFrame.getContentPane().add(lblId);

        textFieldId = new JTextField();
        textFieldId.setBounds(120, 50, 150, 20);
        personDetailsFrame.getContentPane().add(textFieldId);
        textFieldId.setColumns(10);

        JLabel lblSpecializationCourseRole = new JLabel("Specialization/Course/Role:");
        lblSpecializationCourseRole.setBounds(20, 80, 180, 20);
        personDetailsFrame.getContentPane().add(lblSpecializationCourseRole);

        textFieldSpecializationCourseRole = new JTextField();
        textFieldSpecializationCourseRole.setBounds(200, 80, 150, 20);
        personDetailsFrame.getContentPane().add(textFieldSpecializationCourseRole);
        textFieldSpecializationCourseRole.setColumns(10);

        JButton btnSave = new JButton("Save");
        btnSave.setBounds(120, 120, 130, 30);
        personDetailsFrame.getContentPane().add(btnSave);
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                savePerson(personType);
                personDetailsFrame.dispose();
            }
        });

        personDetailsFrame.setVisible(true);
    }

    private void openDeletePersonWindow() {
        JFrame deletePersonFrame = new JFrame();
        deletePersonFrame.setBounds(100, 100, 315, 100);
        deletePersonFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        deletePersonFrame.getContentPane().setLayout(null);

        JButton btnDoctor = new JButton("Doctor");
        btnDoctor.setBounds(20, 20, 80, 30);
        deletePersonFrame.getContentPane().add(btnDoctor);
        btnDoctor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openDeleteDetailsWindow("Doctor");
                deletePersonFrame.dispose();
            }
        });

        JButton btnStaff = new JButton("Staff");
        btnStaff.setBounds(110, 20, 80, 30);
        deletePersonFrame.getContentPane().add(btnStaff);
        btnStaff.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openDeleteDetailsWindow("Staff");
                deletePersonFrame.dispose();
            }
        });

        JButton btnStudent = new JButton("Student");
        btnStudent.setBounds(200, 20, 80, 30);
        deletePersonFrame.getContentPane().add(btnStudent);
        btnStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openDeleteDetailsWindow("Student");
                deletePersonFrame.dispose();
            }
        });

        deletePersonFrame.setVisible(true);
    }

    private void openDeleteDetailsWindow(String personType) {
        JFrame deleteDetailsFrame = new JFrame();
        deleteDetailsFrame.setBounds(100, 100, 310, 130);
        deleteDetailsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        deleteDetailsFrame.getContentPane().setLayout(null);

        JLabel lblId = new JLabel("Enter ID to delete:");
        lblId.setBounds(20, 20, 150, 20);
        deleteDetailsFrame.getContentPane().add(lblId);

        JTextField textFieldDeleteId = new JTextField();
        textFieldDeleteId.setBounds(180, 20, 100, 20);
        deleteDetailsFrame.getContentPane().add(textFieldDeleteId);

        JButton btnDelete = new JButton("Delete");
        btnDelete.setBounds(120, 50, 80, 30);
        deleteDetailsFrame.getContentPane().add(btnDelete);
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deletePersonById(personType, textFieldDeleteId.getText());
                deleteDetailsFrame.dispose();
            }
        });

        deleteDetailsFrame.setVisible(true);
    }

    private void openEditPersonsWindow() {
        JFrame editPersonsFrame = new JFrame();
        editPersonsFrame.setBounds(100, 100, 315, 100);
        editPersonsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        editPersonsFrame.getContentPane().setLayout(null);

        JButton btnDoctor = new JButton("Doctor");
        btnDoctor.setBounds(20, 20, 80, 30);
        editPersonsFrame.getContentPane().add(btnDoctor);
        btnDoctor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openEditDetailsWindow("Doctor");
                editPersonsFrame.dispose();
            }
        });

        JButton btnStaff = new JButton("Staff");
        btnStaff.setBounds(110, 20, 80, 30);
        editPersonsFrame.getContentPane().add(btnStaff);
        btnStaff.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openEditDetailsWindow("Staff");
                editPersonsFrame.dispose();
            }
        });

        JButton btnStudent = new JButton("Student");
        btnStudent.setBounds(200, 20, 80, 30);
        editPersonsFrame.getContentPane().add(btnStudent);
        btnStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openEditDetailsWindow("Student");
                editPersonsFrame.dispose();
            }
        });

        editPersonsFrame.setVisible(true);
    }

    private void openEditDetailsWindow(String personType) {
        JFrame editDetailsFrame = new JFrame();
        editDetailsFrame.setBounds(100, 100, 350, 200);
        editDetailsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        editDetailsFrame.getContentPane().setLayout(null);

        JLabel lblId = new JLabel("Enter ID to edit:");
        lblId.setBounds(20, 20, 150, 20);
        editDetailsFrame.getContentPane().add(lblId);

        JTextField textFieldEditId = new JTextField();
        textFieldEditId.setBounds(120, 20, 100, 20);
        editDetailsFrame.getContentPane().add(textFieldEditId);

        JLabel lblName = new JLabel("New Name:");
        lblName.setBounds(20, 50, 80, 20);
        editDetailsFrame.getContentPane().add(lblName);

        JTextField textFieldEditName = new JTextField();
        textFieldEditName.setBounds(120, 50, 100, 20);
        editDetailsFrame.getContentPane().add(textFieldEditName);

        JLabel lblSpecializationCourseRole = new JLabel("New Specialization/Course/Role:");
        lblSpecializationCourseRole.setBounds(20, 80, 250, 20);
        editDetailsFrame.getContentPane().add(lblSpecializationCourseRole);

        JTextField textFieldEditSpecializationCourseRole = new JTextField();
        textFieldEditSpecializationCourseRole.setBounds(220, 80, 100, 20);
        editDetailsFrame.getContentPane().add(textFieldEditSpecializationCourseRole);

        JButton btnEdit = new JButton("Edit");
        btnEdit.setBounds(120, 120, 80, 30);
        editDetailsFrame.getContentPane().add(btnEdit);
        btnEdit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editPersonById(personType, textFieldEditId.getText(), textFieldEditName.getText(), textFieldEditSpecializationCourseRole.getText());
                editDetailsFrame.dispose();
            }
        });

        editDetailsFrame.setVisible(true);
    }

    private void savePerson(String personType) {
        String name = textFieldName.getText();
        int id = Integer.parseInt(textFieldId.getText());
        String specializationCourseRole = textFieldSpecializationCourseRole.getText();

        switch (personType) {
            case "Doctor":
                persons.add(new Doctors(name, id, specializationCourseRole));
                break;
            case "Staff":
                persons.add(new Staff(name, id, specializationCourseRole));
                break;
            case "Student":
                persons.add(new Students(name, id, specializationCourseRole));
                break;
            default:
                System.out.println("Invalid person type.");
        }

        System.out.println("Person added successfully!");
    }

    private void displayAllPersons() {
        JFrame displayAllFrame = new JFrame();
        displayAllFrame.setBounds(100, 100, 300, 200);
        displayAllFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        displayAllFrame.getContentPane().setLayout(null);

        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(20, 20, 250, 120);
        displayAllFrame.getContentPane().add(scrollPane);

        if (!persons.isEmpty()) {
            for (Person person : persons) textArea.append(person.displayInfo());
        } else {
            textArea.append("No persons to display.");
        }

        displayAllFrame.setVisible(true);
    }

    private void deletePersonById(String personType, String id) {
        int personId = Integer.parseInt(id);
        for (Person person : persons) {
            if (person.id == personId) {
                persons.remove(person);
                System.out.println("Person with ID " + personId + " deleted successfully!");
                return;
            }
        }
        System.out.println("Person with ID " + personId + " not found.");
    }

    private void editPersonById(String personType, String id, String newName, String newSpecializationCourseRole) {
        int personId = Integer.parseInt(id);
        for (Person person : persons) {
            if (person.id == personId) {
                person.name = newName;
                if (person instanceof Doctors) {
                    ((Doctors) person).specialization = newSpecializationCourseRole;
                } else if (person instanceof Staff) {
                    ((Staff) person).role = newSpecializationCourseRole;
                } else if (person instanceof Students) {
                    ((Students) person).course = newSpecializationCourseRole;
                }
                System.out.println("Person with ID " + personId + " edited successfully!");
                return;
            }
        }
        System.out.println("Person with ID " + personId + " not found.");
    }
}
