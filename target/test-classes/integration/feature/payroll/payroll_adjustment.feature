Feature: Payroll Management

  Scenario: Modify an employee's salary
    Given the payroll management system is initialized with the following data
      | id  | firstName | salary   |
      | 1   | vader     | 99999.0  |
      | 2   | yoda      | 90000.0  |
      | 3   | boba      | 50000.0  |
      | 4   | han       | 80000.0  |
      | 5   | leia      | 71000.0  |
      | 6   | obi-wan   | 52000.0  |
      | 7   | luke      | 61000.0  |
      | 8   | jabba     | 73500.0  |
    When lucas increases the salary for the employee with id '3' by '5'%
    Then the payroll for the employee with id '3' should display a salary of '52500'
    When lucas increases the salary for the employee with id '4' by '2'%
    Then the payroll for the employee with id '4' should display a salary of '81600'
    When lucas increases the salary for the employee with id '5' by '-1'%
    Then the payroll for the employee with id '5' should display a salary of '70290'

