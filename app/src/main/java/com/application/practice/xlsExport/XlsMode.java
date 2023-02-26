package com.application.practice.xlsExport;

/**
 * Created by Charles Raj I on 26/02/23.
 *
 * @author Charles Raj I
 */
public class XlsMode {

    private String studentId;
    private String studentName;
    private String studentClass;
    private String studentBench;
    private String studentAge;
    private String studentGender;
    private String studentGrade;

    public XlsMode(String studentId, String studentName,
                   String studentClass, String studentBench,
                   String studentAge, String studentGender,
                   String studentGrade) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentClass = studentClass;
        this.studentBench = studentBench;
        this.studentAge = studentAge;
        this.studentGender = studentGender;
        this.studentGrade = studentGrade;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getStudentBench() {
        return studentBench;
    }

    public void setStudentBench(String studentBench) {
        this.studentBench = studentBench;
    }

    public String getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(String studentAge) {
        this.studentAge = studentAge;
    }

    public String getStudentGender() {
        return studentGender;
    }

    public void setStudentGender(String studentGender) {
        this.studentGender = studentGender;
    }

    public String getStudentGrade() {
        return studentGrade;
    }

    public void setStudentGrade(String studentGrade) {
        this.studentGrade = studentGrade;
    }
}
