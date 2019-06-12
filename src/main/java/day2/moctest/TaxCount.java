package day2.moctest;

public class TaxCount {
    EmployeeDAO employeeDAO = new EmployeeDAOImp();

    public TaxCount() {
    }

    TaxCount(EmployeeDAO employeeDAO) {
        try {
            this.employeeDAO = employeeDAO;
        } catch (NullPointerException e) {
            throw e;
        }
    }

    public double getTax(int empId) {

        Employee e = employeeDAO.getEmployee(empId);
        if (e == null) {
            throw new NullPointerException("dostałeś nulla ");
        }
        double salary = e.getSalary();
        return salary * 0.19;
    }

    public String toUpperCase(int id) {
        Employee e = employeeDAO.getEmployee(id);
        if (e == null) {
            throw new NullPointerException("dostałeś nulla");
        }
        return e.getName().toUpperCase();
    }

}
