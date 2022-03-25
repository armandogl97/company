# Company
Proyecto para capturar empleados, sus horas trabajadas y calcular su salario por hora.

### Pre-requisitos 📋
* [Java 18 sdk]
* [Apache Tomcat/9.0.60]
* [Spring boot]
* [Mysql]
* 


## EndPoints
Ej1:
 Uri: <domain>:<port>/employees/create
 Example request POST:
  {"gender_id": 24,"job_id": 1,"name": "Juan", "last_name": "Pérez","birthdate": "1983-01-01"}
 
Ej2:
 Uri: <domain>:<port>/worked-hours/register
 Example request POST:
 ```
  {"employee_id": 1,"worked_hours": 10,"worked_date": "2019-01-01"}
 ```
 
 
Ej3:
 Uri: <domain>:<port>/jobs/employees-per-job
 Example request GET:
 ```
  <domain>:<port>/jobs/employees-per-job?json=%7B%22job_id%22%3A%201%7D
   ```
   Note: El json va codificado en la url ( json=%7B%22job_id%22%3A%201%7D = json={"job_id": 1} ) 

Ej4:
 Uri: <domain>:<port>/worked-hours/employeeByDate
 Example request GET:
   ```
  <domain>:<port>/worked-hours/employeeByDate?json%3A%7B%0A%22employee_id%22%3A%201%2C%0A%22start_date%22%3A%20%222019-01-01%22%2C%0A%22end_date%22%3A%20%222019-06-30%22%2C%0A%7D
   ```
   Note: El json va codificado en la url ( json%3A%7B%0A%22employee_id%22%3A%201%2C%0A%22start_date%22%3A%20%222019-01-01%22%2C%0A%22end_date%22%3A%20%222019-06-30%22%2C%0A%7D = json:{"employee_id": 1,"start_date": "2019-01-01","end_date": "2019-06-30",} ) 
   Example request POST:
   {"employee_id": 1,"start_date": "2019-01-01","end_date": "2019-06-30"}
   
Ej5:
 Uri: <domain>:<port>/jobs/total-payment-employee
 Example request GET:
   ```
  <domain>:<port>/jobs/total-payment-employee?json%7B%0A%22employee_id%22%3A%201%2C%0A%22start_date%22%3A%20%222019-01-01%22%2C%0A%22end_date%22%3A%20%222019-06-30%22%2C%0A%7D
   ```
   Note: El json va codificado en la url ( %7B%0A%22employee_id%22%3A%201%2C%0A%22start_date%22%3A%20%222019-01-01%22%2C%0A%22end_date%22%3A%20%222019-06-30%22%2C%0A%7D = json:{"employee_id": 1,"start_date": "2019-01-01","end_date": "2019-06-30"} ) 
   Example request POST:
   {"employee_id": 1,"start_date": "2019-01-01","end_date": "2019-06-30",


## Autores ✒️

Armando Gileta
