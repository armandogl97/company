package com.swcompany.company.entities;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

  private Integer id;
  private Gender genderId;
  private Job jobId;
  private String name;
  private String lastName;
  private String birthdate;

  public Employee() { }

  public Employee(Integer id) {
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
  @JoinColumn(name = "GENDER_ID")
  public Gender getGenderId() {
    return genderId;
  }

  public void setGenderId(Gender genderId) {
    this.genderId = genderId;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "JOB_ID")
  public Job getJobId() {
    return jobId;
  }

  public void setJobId(Job jobId) {
    this.jobId = jobId;
  }

  @Column(name = "NAME")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Column(name = "LAST_NAME")
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @Column(name = "BIRTHDATE")
  public String getBirthdate() {
    return birthdate;
  }

  public void setBirthdate(String birthdate) {
    this.birthdate = birthdate;
  }
}