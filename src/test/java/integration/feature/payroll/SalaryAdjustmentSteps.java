package integration.feature.payroll;

import com.mycompany.payroll.Employee;
import com.mycompany.payroll.PayrollManager;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.List;

/**
 * Created by pandian on 5/26/15.
 */
public class SalaryAdjustmentSteps {

    PayrollManager payrollManager;
    String testDate;

    @Given("^the payroll management system is initialized with the following data$")
    public void the_payroll_management_system_is_initialized_with_the_following_data(final List<Employee> employees) {
        payrollManager = new PayrollManager(employees);
    }

    @When("^lucas increases the salary for the employee with id '(\\d+)' by '(.*)'%$")
    public void lucas_increases_the_salary_for_the_employee_with_id_by(final int id, final int adjustmentPercentage) {
        payrollManager.salaryAdjustment(id, adjustmentPercentage);
    }

    @Then("^the payroll for the employee with id '(\\d+)' should display a salary of '(\\d+)'$")
    public void the_payroll_for_the_employee_with_id_should_display_a_salary_of(final int id, final float adjustedSalary) {
        Employee employee = payrollManager.findEmployee(id);
        Assert.assertEquals(employee.getSalary(), adjustedSalary, 0.00);
    }

    @When("^the date is '(\\d+)/(\\d+)/(\\d+)'$")
    public void the_date_is(int month, int day, int year) throws Throwable {
        testDate = month + "/" + day + "/" + year;
    }

    @Then("^manager need to be notified with employee id '(\\d+)'$")
    public void manager_need_to_be_notified_with_employee_id(int id) throws Throwable {
        Assert.assertEquals(id, payrollManager.findEmployee(testDate));
    }

}
