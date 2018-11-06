package HrManagement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HrTest {
	public static void main(String[] args) {
		List<Student> students = new ArrayList<Student>();
		students.add(new Student("Anh","Pham",10));
		students.add(new Student("Huy","Tran",1));
		students.add(new Student("Thuy","Huynh",3));
		students.add(new Student("Hong","Nguyen",2));
		students.add(new Student("Long","Luong",6));
		students.add(new Student("Nghia","Le",8));
		students.add(new Student("Quynh","Luu",9));
		students.add(new Student("Huyen","Nguyen",5));
		students.add(new Student("Dong","Tran",7));
		students.add(new Student("Cong","Le",4));
		Collections.sort(students);
//		for (Student student : students) {
//			System.out.println(student.toString());
//		}
		List<Worker> workers = new ArrayList<Worker>();
		workers.add(new Worker("Huy","Pham",700000,8));
		workers.add(new Worker("Huyen","Tran",600000,10));
		workers.add(new Worker("Bao","Nguyen",100000,8));
		workers.add(new Worker("Anh","Nguyen",999000,12));
		workers.add(new Worker("Anh","Truong",200000,2));
		workers.add(new Worker("Kiet","Nguyen",700000,9));
		workers.add(new Worker("Phi","Ho",700000,12));
		workers.add(new Worker("Kim","Nguyen",700000,15));
		workers.add(new Worker("Chi","Nguyen",100000,1));
		workers.add(new Worker("Ngan","Duong",700000,9));
		Collections.sort(workers);
		for (Worker worker : workers) {
			System.out.println(worker);
		}
	}

}
