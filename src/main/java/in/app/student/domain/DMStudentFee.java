package in.app.student.domain;

public class DMStudentFee {
    private Integer studentId;
    private Double studentFee;
    private String paymentDate;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Double getStudentFee() {
        return studentFee;
    }

    public void setStudentFee(Double studentFee) {
        this.studentFee = studentFee;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }
}
