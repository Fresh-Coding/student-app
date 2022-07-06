package in.app.student.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "student_fee")
public class StudentFee implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private Student student;
    private Double fee;
    private Date feePaidTimestamp;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studentId")
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Column(name = "fee")
    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    //https://xdsoft.net/jqplugins/datetimepicker/
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "feePaidTimestamp")
    public Date getFeePaidTimestamp() {
        return feePaidTimestamp;
    }

    public void setFeePaidTimestamp(Date feePaidTimestamp) {
        this.feePaidTimestamp = feePaidTimestamp;
    }
}
