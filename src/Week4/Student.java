package Week4;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

enum Gender{
    MALE,FEMALE
}

@Entity(name = "student")
@Table(name = "students",schema = "schema_1")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false,length = 100,unique = false)
    private String name;

    private LocalDate birthDate;

    @Transient
    private int age;

    @Enumerated(EnumType.STRING)
    private Gender gender;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "address_id",referencedColumnName = "id")
    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Address address;

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    private Set<Grades> grades;

    private boolean deleted=false;


    @ManyToMany
    @JoinTable(
            name = "student_lessons",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "lesson_id")
    )
    private Set<Lesson> registeredLessons;
}

class Grades{
    @Id
    @Column(name = "student_id")
    private int id;

    private String lessonName;
    private LocalDate creationDate;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;


}

@Entity
class Lesson{

    @Id
    @Column(name = "student_id")
    private int id;

    private String name;
    private LocalDate registrationDate;

    @ManyToMany(mappedBy = "registeredLessons",fetch = FetchType.EAGER)
    private Set<Student> students;
}





@Entity
class Address{
    @Id
//    @GeneratedValue
    @Column(name = "student_id")
    private int id;


    private String city;
    private String street;
    private String houseNumber;

//    @OneToOne(mappedBy = "address")
    @OneToOne
    @MapsId
    @JoinColumn(name = "student_id")
    private Student student;










}
