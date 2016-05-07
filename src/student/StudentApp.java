package student;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.time.LocalDate;
import java.util.Collections.*;

/**
 * Display reminders of students having a birthday soon.
 * @author you
 */
public class StudentApp {

	/**
	 * Print the names (and birthdays) of students having a birthday in the
	 * specified month.
	 * @param students List of students
	 * @param filter Filter student that have birthday in the specific month
	 * @param action Print out information about student
	 * @param sortBy Sort the list by specific method
	 */
	public void filterAndPrint( List<Student> students, Predicate<Student> filter, Consumer<Student> action, Comparator<Student> sortBy ) {
		
		students.stream().filter(filter).sorted(sortBy).forEach(action);
	}
	
	public static void main(String[] args) {
		List<Student> students = Registrar.getInstance().getStudents();
		
		LocalDate localDate = LocalDate.now();
		Predicate<Student> bday = (s) -> s.getBirthdate().getMonthValue() == localDate.getMonthValue();
		Consumer<Student> action = (s) -> System.out.printf("%s %s will have birthday on %d %s\n", s.getFirstname(), s.getLastname(), s.getBirthdate().getDayOfMonth(),
				s.getBirthdate().getMonth().toString());
		
		Comparator<Student> byName = (a, b) -> a.getFirstname().charAt(0) - b.getFirstname().charAt(0);
		Comparator<Student> byBirthdate = (a, b ) -> a.getBirthdate().getDayOfMonth() - b.getBirthdate().getDayOfMonth();
		
		
		StudentApp app = new StudentApp();
		
		app.filterAndPrint(students, bday, action, byBirthdate);
		
	}
}
