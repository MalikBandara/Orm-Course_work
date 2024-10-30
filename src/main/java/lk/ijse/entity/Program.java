package lk.ijse.entity;

import jakarta.persistence.*;


import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "program")
public class Program {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "programName", nullable = false)
    private String programName;

    @Column(name = "duration")
    private String duration;

    @Column(name = "fee")
    private double fee;

    @ManyToMany(mappedBy = "programs")
    private Set<Student> students = new HashSet<>();

    // Constructors, Getters, Setters

    public Program() {}

    public Program(String programName, String duration, double fee) {
        this.programName = programName;
        this.duration = duration;
        this.fee = fee;
    }

    // Add getters and setters for each field
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getProgramName() { return programName; }
    public void setProgramName(String programName) { this.programName = programName; }

    public String getDuration() { return duration; }
    public void setDuration(String duration) { this.duration = duration; }

    public double getFee() { return fee; }
    public void setFee(double fee) { this.fee = fee; }

    public Set<Student> getStudents() { return students; }
    public void setStudents(Set<Student> students) { this.students = students; }
}
