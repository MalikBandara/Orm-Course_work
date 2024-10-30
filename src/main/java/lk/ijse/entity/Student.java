package lk.ijse.entity;

import jakarta.persistence.*;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "registrationDate")
    private Date registrationDate;

    @Column(name = "password", nullable = false)
    private String password;  // Ensure this is encrypted using BCrypt during storage

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "student_program",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "program_id")
    )
    private Set<Program> programs = new HashSet<>();

    // Constructors, Getters, Setters

    public Student() {}

    public Student(String name, String email, String phone, Date registrationDate, String password) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.registrationDate = registrationDate;
        this.password = password;
    }

    // Add getters and setters for each field
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public Date getRegistrationDate() { return registrationDate; }
    public void setRegistrationDate(Date registrationDate) { this.registrationDate = registrationDate; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Set<Program> getPrograms() { return programs; }
    public void setPrograms(Set<Program> programs) { this.programs = programs; }
}
