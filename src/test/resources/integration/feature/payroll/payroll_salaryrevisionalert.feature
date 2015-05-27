Feature: Salary revision alert

  Scenario: Generate an alert
    Given the payroll management system is initialized with the following data
      | id  | firstName | salary   | joinDate |
      | 1   | vader     | 99999.0  | 1/1/2010 |
      | 2   | yoda      | 90000.0  | 2/1/2010 |
      | 3   | boba      | 50000.0  | 3/3/2010 |
      | 4   | han       | 80000.0  | 4/4/2010 |
      | 5   | leia      | 71000.0  | 5/5/2010 |
      | 6   | obi-wan   | 52000.0  | 6/6/2011 |
      | 7   | luke      | 61000.0  | 7/7/2012 |
      | 8   | jabba     | 73500.0  | 8/8/2013 |
    When the date is '3/3/2015'
    Then manager need to be notified with employee id '3'
    When the date is '7/7/2015'
    Then manager need to be notified with employee id '7'

