import java.util.Comparator;
import java.util.Optional;

public class Main {

    //ORM Object-relational mapping or ORMis the programming
    // technique to map application domain model objects to the
    // relational database tables. Hibernate is a Java-based ORM tool
    // that provides a framework for mapping application domain objects to relational tables.
    // JPA
    // Hibernate, EclipseLinks,
    // Hibernate : SessionFactory :
    /*
     *SessionFactory* is an interface that provides methods to create and manage Hibernate

     *Session* objects. It is a thread-safe and immutable object that provides
     *  a cache of immutable objects, which is used to create new *Session* objects.
     */
    // Hibernate: Session
    /*
    The Session is an interface that represents a single unit
    of work with the database. It is responsible for managing the persistence of
    objects and providing transactional support for the persistence operations.
    The Session interface provides methods for querying, saving, updating, and deleting objects in the database.
Behind the scenes, the Hibernate Session wraps a JDBC java.sql.Connection and acts as a factory for org.hibernate.Transaction instances.
     */
    // Hibernate: Transaction
    /*
    The Transaction is an interface that represents a database transaction.
    It provides methods to control the transaction, such as commit(),rollback(), and begin().
    The Transaction interface also provides methods to set the transaction isolation level and check the status of the transaction.
     */

    public static void main(String[] args) {
        EmployeeDAO dao = new EmployeeDAO();
        Employee employee1 = new Employee("john","Doe","john.doe@example.com");
        Employee employee2 = new Employee("Roshni","Smith","Roshni.doe@example.com");
        Employee employee3 = new Employee("Ashton","Kris","Ashton.kris@example.com");
        Employee employee4 = new Employee("Chris","Smith","Chris.smith@example.com");
        Employee employee5 = new Employee("Frank","Mike","Frank.mike@example.com");
         dao.addEmployee(employee1);
        dao.addEmployee(employee2);
        dao.addEmployee(employee3);
        dao.addEmployee(employee4);
        dao.addEmployee(employee5);
        dao.deleteEmployee(employee1);
        Optional<Employee> employee = dao.getEmployeeById(1);

        if (employee.isPresent()) {
            System.out.println("Employee found: " + employee.get());
        } else {
            System.out.println("Employee not found");
        }
        System.out.println("+++++++ List of All Employees +++++++++");

        dao.updateEmployeeById(2,new Employee("Roshni","Khan","roshani.khan@example.com"));
        dao.getAllEmployees().stream()
                .sorted(Comparator.comparing(Employee::getName))
                .forEach(System.out::println);

    }
}
