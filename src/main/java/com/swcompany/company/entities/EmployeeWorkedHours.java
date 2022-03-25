package com.swcompany.company.entities;

import javax.persistence.*;

@Entity
@Table(name = "employee_worked_hours")
public class EmployeeWorkedHours {
    private Integer id;
    private Employee employeeId;
    private Integer workedHours;
    private String workedDate;

    public EmployeeWorkedHours() { }

    public EmployeeWorkedHours(Integer id) {
        this.id = id;
    }

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMPLOYEE_ID")
    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    @Column(name = "WORKED_HOURS")
    public Integer getWorkedHours() {
        return workedHours;
    }

    public void setWorkedHours(Integer workedHours) {
        this.workedHours = workedHours;
    }

    @Column(name = "WORKED_DATE")
    public String getWorkedDate() {
        return workedDate;
    }

    public void setWorkedDate(String workedDate) {
        this.workedDate = workedDate;
    }
}
