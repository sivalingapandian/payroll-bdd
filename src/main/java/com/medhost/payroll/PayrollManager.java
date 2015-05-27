package com.medhost.payroll;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by pandian on 5/26/15.
 */
public class PayrollManager {

    private Map<Integer, Employee> employees = new HashMap<Integer, Employee>();

    public PayrollManager(final List<Employee> employees) {
        this.employees = employees.stream().collect(Collectors.toMap(p -> p.getId(), p -> p));
    }

    public void salaryAdjustment(final Integer id, final int changePercentage) {
        Employee employee = employees.get(id);
        employee.setSalary(employee.getSalary() + employee.getSalary() * changePercentage / 100);
    }

    public Employee findEmployee(final int id) {
        return employees.get(id);
    }

    public int findEmployee(final String date) throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");

        Calendar calendarForSource = Calendar.getInstance();
        calendarForSource.setTime(format.parse(date));

        Calendar calendarForEmployee = Calendar.getInstance();

        for( int id : employees.keySet()) {
            calendarForEmployee.setTime(format.parse(employees.get(id).getJoinDate()));
            if( calendarForEmployee.get(Calendar.MONTH) == calendarForSource.get(Calendar.MONTH)) {
                return employees.get(id).getId();
            }
        }
        return -1;
    }

}
