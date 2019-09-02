package details.employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Employee {
	int eno;
	String ename;
	int salary;
	String desg;
	String dept;

	static Scanner sc = new Scanner(System.in);

	static void sorting(String field, String order, Employee[] emp) {
		if (field.equals("name") && order.equals("asc")) {

			Arrays.sort(emp, new Comparator<Employee>() {

				@Override
				public int compare(Employee e1, Employee e2) {

					return e1.ename.compareTo(e2.ename);
				}

			});
			for (Employee employee : emp) {
				System.out.println(employee.eno + " " + employee.ename + " " + employee.salary + " " + employee.desg
						+ " " + employee.dept);

			}

		} else if (field.equals("salary") && order.equals("asc")) {
			Arrays.sort(emp, new Comparator<Employee>() {

				@Override
				public int compare(Employee e1, Employee e2) {

					return e1.salary - e2.salary;
				}

			});
			for (Employee employee : emp) {
				System.out.println(employee.eno + " " + employee.ename + " " + employee.salary + " " + employee.desg
						+ " " + employee.dept);

			}

		} else if (field.equals("salary") && order.equals("desc")) {
			Arrays.sort(emp, new Comparator<Employee>() {

				@Override
				public int compare(Employee e1, Employee e2) {

					return e2.salary - e1.salary;
				}

			});
			for (Employee employee : emp) {
				System.out.println(employee.eno);

			}
		}

		else if (field.equals("name") && order.equals("desc")) {
			Arrays.sort(emp, new Comparator<Employee>() {

				@Override
				public int compare(Employee e1, Employee e2) {

					return e2.ename.compareTo(e1.ename);
				}

			});
			for (Employee employee : emp) {
				System.out.println(employee.eno + " " + employee.ename + " " + employee.salary + " " + employee.desg
						+ " " + employee.dept);

			}

		}

	}

	public void addEmp() {

		System.out.println("Enter  emp no");
		eno = sc.nextInt();
		System.out.println("Enter  emp name");
		ename = sc.next();
		System.out.println("Enter  emp salary");
		salary = sc.nextInt();
		System.out.println("Enter  emp designation");
		desg = sc.next();
		System.out.println("Enter  emp Dept");
		dept = sc.next();

	}

	public static void main(String... sd) {
		// ArrayList<Employee> al = new ArrayList<>();
		HashMap<Integer, Employee> hm = new HashMap<>();
		outer: while (true) {
			System.out.println(
					"1. Add Emp \n 2.View All Emp \n 3.Remove Emp \n 4. Clear Data \n 5. Change Sal \n 6.Search Emp \n 7. View dept Wise \n 8. View Sorted Employees");
			int option = sc.nextInt();
			switch (option) {
			case 1:
				Employee e = new Employee();
				e.addEmp();
				// al.add(e);
				hm.put(e.eno, e);

				break;
			case 2:
				for (Employee e1 : hm.values()) {
					System.out.println(e1.eno + " " + e1.ename + " " + e1.salary + " " + e1.desg + " " + e1.dept);

				}
				break;
			case 3:
				for (Employee e1 : hm.values()) {
					System.out.println(e1.eno + " " + e1.ename + " " + e1.salary + " " + e1.desg + " " + e1.dept);

				}
				System.out.println("Enter Eno from above table to delete emp");
				int del = sc.nextInt();
				hm.remove(del);
				for (Employee e1 : hm.values()) {
					System.out.println(e1.eno + " " + e1.ename + " " + e1.salary + " " + e1.desg + " " + e1.dept);

				}
				break;
			case 4:
				Set<Integer> s = hm.keySet();
				for (int i : s) {
					hm.remove(i);

				}
				for (Employee e1 : hm.values()) {
					System.out.println(e1.eno + " " + e1.ename + " " + e1.salary + " " + e1.desg + " " + e1.dept);

				}
				break;
			case 5:
				for (Employee e1 : hm.values()) {
					System.out.println(e1.eno + " " + e1.ename + " " + e1.salary + " " + e1.desg + " " + e1.dept);

				}
				System.out.println("enter eno to update salary");
				int empno = sc.nextInt();
				System.out.println("enter new salary");
				int sal = sc.nextInt();
				Employee e2 = hm.get(empno);
				e2.salary = sal;
				hm.put(empno, e2);
				for (Employee e1 : hm.values()) {
					System.out.println(e1.eno + " " + e1.ename + " " + e1.salary + " " + e1.desg + " " + e1.dept);

				}

				break;
			case 6:
				System.out.println("enter eno to search");
				int empno1 = sc.nextInt();

				Employee e3 = hm.get(empno1);
				System.out.println(e3.eno + " " + e3.ename + " " + e3.salary + " " + e3.desg + " " + e3.dept);
				break;
			case 7:

				System.out.println("enter dept to search all employee");
				String deptSearch = sc.next();
				for (Employee empl : hm.values()) {
					if (empl.dept.equals(deptSearch)) {
						System.out.println(
								empl.eno + " " + empl.ename + " " + empl.salary + " " + empl.desg + " " + empl.dept);

					}

				}
				break;

			case 8:
				Employee emp[] = new Employee[hm.size()];
				int i = 0;
				for (Employee employee : hm.values()) {
					emp[i++] = employee;

				}

				System.out.println("Enter sorting order : salary or name or default(on emp no)");
				String field = sc.next();
				System.out.println("Enter asc or desc ");
				String order = sc.next();
				if (!field.equals("default"))
					sorting(field, order, emp);
				else {

					Arrays.sort(emp, new Comparator<Employee>() {

						@Override
						public int compare(Employee e1, Employee e2) {

							return e2.eno - e1.eno;
						}

					});
					for (Employee employee : emp) {
						System.out.println(employee.eno+ " " +employee.ename+" "+employee.salary +" "+employee.desg + " "+employee.dept  );

					}
				}

				break outer;

			}

		}

	}

}
