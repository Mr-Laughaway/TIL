### JDBC 종합실습 - 성적 관리 시스템 구축

- 테이블 준비

  ```sql
  create table student (
      studentNO varchar(5) constraint student_pk primary key,
      studentName varchar2(15) not null,
      c number(3),
      linux number(3),
      java number(3),
      careerYears number(2),
      internYN    char(10) check (internYn in ('Y', 'N'))
  );
  
  alter table student add (
      average number(5,2),
      pass char(1) check (pass in ('Y', 'N'))
  );
  
  alter table student rename column averdfage to average;
  
  alter table student modify (
      c number(3) default 0,
      linux number(3) default 0,
      java number(3) default 0
  );
  
  desc student;
  
  --전체 학생 목록 검색
  --합격 학생 검색
  --학생정보 추가
  --과목 점수 수정
  --학생 정보 삭제
  
  ```

  

- CommonUtil.java

  ```java
  package lab.jdbc.grade.util;
  
  import java.util.Scanner;
  
  public class CommonUtil {
  	
  	 public static String getUerInput() {
  		   Scanner input = new Scanner(System.in);
  		   return input.nextLine();
  	   }
  	   public static void printHead() {
  		   System.out.println("=======================================================================================");
  		   System.out.println("사번       이름   신입/경력  인턴여부  경력년수           C   Linux   Java        총점   평균   합격여부");;
  		   System.out.println("=======================================================================================");
  	   }  
  	   public static void printTail() {
  		   System.out.println("=======================================================================================");
  	   }
  }
  
  ```

  

  

- Student.java

  ```java
  package lab.jdbc.grade.entity;
  
  public class Student {
  	private String studentNo;
  	private String studentName;
  	private int c;
  	private int linux;
  	private int java;
  	private int careerYears;
  	private String internYn;
  	private double average;
  	private String pass;
  	
  	public Student() {
  		super();
  	}
  	
  	
  
  	public Student(String studentNo, String studentName, int c, int linux, int java, String internYn) {
  		super();
  		this.studentNo = studentNo;
  		this.studentName = studentName;
  		this.c = c;
  		this.linux = linux;
  		this.java = java;
  		this.internYn = internYn;
  	}
  	
  	
  
  
  
  	public String getStudentNo() {
  		return studentNo;
  	}
  
  	public void setStudentNo(String studentNo) {
  		this.studentNo = studentNo;
  	}
  
  	public String getStudentName() {
  		return studentName;
  	}
  
  	public void setStudentName(String studentName) {
  		this.studentName = studentName;
  	}
  
  	public int getC() {
  		return c;
  	}
  
  	public void setC(int c) {
  		this.c = c;
  	}
  
  	public int getLinux() {
  		return linux;
  	}
  
  	public void setLinux(int linux) {
  		this.linux = linux;
  	}
  
  	public int getJava() {
  		return java;
  	}
  
  	public void setJava(int java) {
  		this.java = java;
  	}
  
  	public int getCareerYears() {
  		return careerYears;
  	}
  
  	public void setCareerYears(int careerYears) {
  		this.careerYears = careerYears;
  	}
  
  	public String getInternYn() {
  		return internYn;
  	}
  
  	public void setInternYn(String internYn) {
  		this.internYn = internYn;
  	}
  
  
  
  	public double getAverage() {
  		return average;
  	}
  
  
  
  	public void setAverage(double average) {
  		this.average = average;
  	}
  
  
  
  	public String getPass() {
  		return pass;
  	}
  
  
  
  	public void setPass(String pass) {
  		this.pass = pass;
  	}
  
  
  
  	@Override
  	public String toString() {
  		String st = String.format("%s\t%s\t%s\t%s\t%s\t%d\t%d\t%d\t%d\t%.1f\t%s", 
  			studentNo,
  			studentName,
  			studentNo.startsWith("1") ? "신입" : "경력",
  			studentNo.startsWith("1") ? internYn.trim() : " ",
  			studentNo.startsWith("1") ? " " : String.valueOf(careerYears),
  			c,
  			linux,
  			java,
  			c + linux + java,
  			average,
  			pass
  		);
  		
  		return st;
  	}
  }
  
  ```

  

- GradeManager.java

  ```java
  package lab.jdbc.grade.biz;
  
  import java.io.FileInputStream;
  import java.sql.Connection;
  import java.sql.DriverManager;
  import java.sql.PreparedStatement;
  import java.sql.ResultSet;
  import java.sql.Statement;
  import java.util.ArrayList;
  import java.util.Properties;
  
  import lab.jdbc.grade.entity.Student;
  
  public class GradeManager {
  	
  	public Connection dbCon() {
  		Connection con = null;
  		try {
  			Properties prop = new Properties();
  			prop.load(new FileInputStream("C:/workspace/day13/src/dbinfo.properties"));
  			
  			Class.forName(prop.getProperty("driver"));
  //			System.out.println("Driver loading 성공");
  			con = DriverManager.getConnection(
  					prop.getProperty("url"), 
  					prop.getProperty("user"), 
  					prop.getProperty("pwd")
  			);
  //			System.out.println("db connect 성공");
  			
  			
  			
  		} catch (Exception e) {
  			e.printStackTrace();
  		}
  		
  		return con;
  	}
  	
  	public void dbClose(Connection con, Statement stat, ResultSet rs) {
  		try {
  			if(rs != null) rs.close();
  			if(stat != null) stat.close();
  			if(con != null) con.close();
  		}catch(Exception e) {
  			e.printStackTrace();
  		}
  	}
  	
  	
  	public ArrayList<Student> getAllStudent() {
  		Connection con = null;
  		Statement stat = null;
  		String sql = "SELECT  * FROM student ORDER BY studentno";
  		ResultSet rs = null;
  		ArrayList<Student> students = new ArrayList<Student>();
  		try {
  			con = dbCon();
  			stat = con.createStatement();
  			rs = stat.executeQuery(sql);
  			while(rs.next()) {
  				Student st = new Student();
  				st.setStudentNo(rs.getString("studentNo"));
  				st.setStudentName(rs.getString("studentName"));
  				st.setC(rs.getInt("c"));
  				st.setLinux(rs.getInt("linux"));
  				st.setJava(rs.getInt("java"));
  				st.setInternYn(rs.getString("internYN"));
  				st.setCareerYears(rs.getInt("careerYears"));
  				st.setAverage(rs.getDouble("average"));
  				st.setPass(rs.getString("pass"));
  				
  				students.add(st);
  			}
  			
  		}catch(Exception e) {
  			e.printStackTrace();
  		}
  		finally {
  			dbClose(con, stat, rs);
  		}
  		
  		return students;
  	}
  	
  	public ArrayList<Student> getPassStudent() {
  		Connection con = null;
  		PreparedStatement stat = null;
  		String sql = "SELECT * FROM student WHERE pass = ? ORDER BY studentno";
  		ResultSet rs = null;
  		ArrayList<Student> students = new ArrayList<Student>();
  		try {
  			con = dbCon();
  			stat = con.prepareStatement(sql);
  			stat.setString(1,  "Y");
  			rs = stat.executeQuery();
  			while(rs.next()) {
  				Student st = new Student();
  				st.setStudentNo(rs.getString("studentNo"));
  				st.setStudentName(rs.getString("studentName"));
  				st.setC(rs.getInt("c"));
  				st.setLinux(rs.getInt("linux"));
  				st.setJava(rs.getInt("java"));
  				st.setInternYn(rs.getString("internYN"));
  				st.setCareerYears(rs.getInt("careerYears"));
  				st.setAverage(rs.getDouble("average"));
  				st.setPass(rs.getString("pass"));
  				
  				students.add(st);
  			}
  			
  		}catch(Exception e) {
  			e.printStackTrace();
  		}
  		finally {
  			dbClose(con, stat, rs);
  		}
  		
  		return students;
  		
  	}
  	
  	public ArrayList<Student> getFailStudent() {
  		Connection con = null;
  		PreparedStatement stat = null;
  		String sql = "SELECT * FROM student WHERE pass = ? ORDER BY studentno";
  		ResultSet rs = null;
  		ArrayList<Student> students = new ArrayList<Student>();
  		try {
  			con = dbCon();
  			stat = con.prepareStatement(sql);
  			stat.setString(1,  "N");
  			rs = stat.executeQuery();
  			while(rs.next()) {
  				Student st = new Student();
  				st.setStudentNo(rs.getString("studentNo"));
  				st.setStudentName(rs.getString("studentName"));
  				st.setC(rs.getInt("c"));
  				st.setLinux(rs.getInt("linux"));
  				st.setJava(rs.getInt("java"));
  				st.setInternYn(rs.getString("internYN"));
  				st.setCareerYears(rs.getInt("careerYears"));
  				st.setAverage(rs.getDouble("average"));
  				st.setPass(rs.getString("pass"));
  				
  				students.add(st);
  			}
  			
  		}catch(Exception e) {
  			e.printStackTrace();
  		}
  		finally {
  			dbClose(con, stat, rs);
  		}
  		
  		return students;
  	}
  	
  	public int insertStudent(Student s) {
  		Connection con = null;
  		PreparedStatement stat = null;
  		int nRows = 0;
  		String careerSt = 
  				"INSERT INTO student ("
  					+ "studentNo, studentName, c, linux, java, careerYears, internYN, average, pass) "
  					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
  		try {
  			con = dbCon();
  			stat = con.prepareStatement(careerSt);
  
  			stat.setString(1, s.getStudentNo());
  			stat.setString(2, s.getStudentName());
  			stat.setInt(3,  s.getC());
  			stat.setInt(4,  s.getLinux());
  			stat.setInt(5,  s.getJava());
  			stat.setInt(6,  s.getCareerYears());
  			stat.setNString(7, s.getInternYn());
  			double avg = (s.getC() + s.getLinux() + s.getJava()) / 3.0;
  			stat.setDouble(8, Double.parseDouble(String.format("%.2f", avg)));
  			String pass = s.getStudentNo().startsWith("1") ?
  					(avg >= 70 ? "Y" : "N")	: (avg >= 80 ? "Y" : "N");
  			stat.setString(9, pass);
  			nRows = stat.executeUpdate();
  		}catch(Exception e) {
  			e.printStackTrace();
  		}
  		finally {
  			dbClose(con, stat, null);
  		}
  		
  		return nRows;
  	}
  	
  	public int updateStudent(Student s) {
  		Connection con = null;
  		PreparedStatement stat = null;
  		int nRows = 0;
  		String sql = 
  				"UPDATE student SET c = ?, java = ?, linux = ?, "
  				+ "careerYears = ?, internYn = ?, "
  				+ "average = ?, pass = ? "
  				+ "WHERE studentNo = ? ";
  		try {
  			con = dbCon();
  			con.setAutoCommit(false);
  			stat = con.prepareStatement(sql);
  			stat.setString(8, s.getStudentNo());
  			stat.setInt(1,  s.getC());
  			stat.setInt(2,  s.getLinux());
  			stat.setInt(3,  s.getJava());
  			stat.setInt(4,  s.getCareerYears());
  			stat.setString(5, s.getInternYn());
  			double avg = (s.getC() + s.getLinux() + s.getJava()) / 3.0;
  			stat.setDouble(6, Double.parseDouble(String.format("%.2f", avg)));
  			String pass = s.getStudentNo().startsWith("1") ?
  					(avg >= 70 ? "Y" : "N")	: (avg >= 80 ? "Y" : "N");
  			stat.setString(7,  pass);
  		
  			nRows = stat.executeUpdate();
  			
  			con.commit();
  			
  		}catch(Exception e) {
  			e.printStackTrace();
  		}
  		finally {
  			dbClose(con, stat, null);
  		}
  		
  		return nRows;
  	}
  	
  	public int deleteStudent(String sno) {
  		Connection con = null;
  		PreparedStatement stat = null;
  		String sql = "DELETE FROM student WHERE studentNo = ?";
  		int nRows = 0;
  		try {
  			con = dbCon();
  			stat = con.prepareStatement(sql);
  			stat.setString(1, sno);
  			nRows = stat.executeUpdate();
  			
  		}catch(Exception e) {
  			e.printStackTrace();
  		}
  		finally {
  			dbClose(con, stat, null);
  		}
  		
  		return nRows;
  	}
  	
  	public ArrayList<Student> searchStudent(String sno) {
  		Connection con = null;
  		PreparedStatement stat = null;
  		String sql = "SELECT * FROM student WHERE studentNo = ?";
  		ResultSet rs = null;
  		ArrayList<Student> students = new ArrayList<Student>();
  		try {
  			con = dbCon();
  			stat = con.prepareStatement(sql);
  			stat.setString(1,  sno);
  			rs = stat.executeQuery();
  			while(rs.next()) {
  				Student st = new Student();
  				st.setStudentNo(rs.getString("studentNo"));
  				st.setStudentName(rs.getString("studentName"));
  				st.setC(rs.getInt("c"));
  				st.setLinux(rs.getInt("linux"));
  				st.setJava(rs.getInt("java"));
  				st.setInternYn(rs.getString("internYN"));
  				st.setCareerYears(rs.getInt("careerYears"));
  				st.setAverage(rs.getDouble("average"));
  				st.setPass(rs.getString("pass"));
  				
  				students.add(st);
  			}
  		}catch(Exception e) {
  			e.printStackTrace();
  		}
  		finally {
  			dbClose(con, stat, null);
  		}
  		
  		return students;
  	}
  	
  	
  	
  	public GradeManager() {
  		super();
  	}
  
  }
  ```

  

- GradeTest.java

  ```java
  package lab.jdbc.grade.test;
  
  import java.util.ArrayList;
  
  import lab.jdbc.grade.biz.GradeManager;
  import lab.jdbc.grade.entity.Student;
  import lab.jdbc.grade.util.CommonUtil;
  
  public class GradeTest {
  
  	public static void main(String[] args) {
  		
  		ArrayList<Student> students;
  		GradeManager mgr = new GradeManager();
  		 
  		while (true) {
  			printMenu();
  			System.out.print("## 메뉴 입력:");
  			String menu = CommonUtil.getUerInput();
  			if (menu.equals("9")) {
  				System.out.println("------------------------");
  				System.out.println("프로그램을 종료합니다. Bye~");
  				System.out.println("------------------------");
  				break;
  			}
  			switch (menu) {
  			case "1":
  				students = mgr.getAllStudent();
  				CommonUtil.printHead();
  				for( Student s : students) {
  					System.out.println(s);
  				}
  				CommonUtil.printTail();
  				break;
  				
  			case "2":
  				students = mgr.getPassStudent();
  				CommonUtil.printHead();
  				for( Student s : students) {
  					System.out.println(s);
  				}
  				CommonUtil.printTail();
  				break;
  				
  			case "3":
  				students = mgr.getFailStudent();
  				CommonUtil.printHead();
  				for( Student s : students) {
  					System.out.println(s);
  				}
  				CommonUtil.printTail();
  				 
  				break;
  			case "4":
  				Student newS = new Student();
  				System.out.print("> 사번 입력하세요: ");
  				newS.setStudentNo(CommonUtil.getUerInput());
  				
  				System.out.print("> 이름 을 입력하세요: ");
  				newS.setStudentName(CommonUtil.getUerInput());
  				
  				if(newS.getStudentNo().startsWith("1")) {
  					System.out.print("> 인턴겸험 여부를 입력하세요: ");
  					newS.setInternYn(CommonUtil.getUerInput());
  				}
  				else {
  					System.out.print("> 경력년수를 입력하세요: ");
  					newS.setCareerYears(Integer.parseInt(CommonUtil.getUerInput()));
  				}
  				
  				System.out.print("> C 점수를 입력하세요: ");
  				newS.setC(Integer.parseInt(CommonUtil.getUerInput()));
  				
  				System.out.print("> Linux 점수를 입력하세요: ");
  				newS.setLinux(Integer.parseInt(CommonUtil.getUerInput()));
  				
  				System.out.print("> Java 점수를 입력하세요: ");
  				newS.setJava(Integer.parseInt(CommonUtil.getUerInput()));
  				
  				newS.setAverage((newS.getC() + newS.getJava() + newS.getLinux()) / 3.0);
  				
  				if(mgr.insertStudent(newS) > 0) {
  					System.out.println("OOO 사원 추가 완료 OOO");
  				}
  				else {
  					System.out.println("XXX 사원 추가 실패 XXX");
  				}
  				break; 
  				 
  			case "5":
  				Student modS = new Student();
  				System.out.print("> 변경할 사원의 사번 입력하세요: ");
  				modS.setStudentNo(CommonUtil.getUerInput());
  				
  				System.out.print("> C 점수를 입력하세요: ");
  				modS.setC(Integer.parseInt(CommonUtil.getUerInput()));
  				
  				System.out.print("> Linux 점수를 입력하세요: ");
  				modS.setLinux(Integer.parseInt(CommonUtil.getUerInput()));
  				
  				System.out.print("> Java 점수를 입력하세요: ");
  				modS.setJava(Integer.parseInt(CommonUtil.getUerInput()));
  				
  				
  				if(modS.getStudentNo().startsWith("1")) {
  					System.out.print("> 인턴겸험 여부를 입력하세요: ");
  					modS.setInternYn(CommonUtil.getUerInput());
  				}
  				else {
  					System.out.print("> 경력년수를 입력하세요: ");
  					modS.setCareerYears(Integer.parseInt(CommonUtil.getUerInput()));
  				}
  				
  				modS.setAverage((modS.getC() + modS.getJava() + modS.getLinux()) / 3.0);
  				
  				
  				if(mgr.updateStudent(modS) > 0) {
  					System.out.println("OOO 사원 변경 완료 OOO");
  				}
  				else {
  					System.out.println("XXX 사원 변경 실패 XXX");
  				}
  				
  				 
  				break;
  			case "6":
  				
  				System.out.print("> 삭제할 사원의 사번 입력하세요: ");
  				String delS = CommonUtil.getUerInput();
  				if(mgr.deleteStudent(delS) > 0) {
  					System.out.println("OOO 사원 삭제 완료 OOO");
  				}
  				else {
  					System.out.println("XXX 사원 삭제 실패 XXX");
  				}
  				
  				 
  				break;
  			case "7": //학번으로 검색... 귀찮아... 안 해..
  				System.out.print("> 변경할 사원의 사번 입력하세요: ");
  				String sno = CommonUtil.getUerInput();
  				ArrayList<Student> searchedSt = mgr.searchStudent(sno);
  				
  				CommonUtil.printHead();
  				if(searchedSt != null) {
  					for( Student s : searchedSt) {
  						System.out.println(s);
  					}
  				}
  				else
  					System.out.println("해당 사원이 없습니다.");
  					
  				CommonUtil.printTail();
  						
  				break;
  			}// switch end
  		} // while end
  
  	}
  
  	public static void printMenu() {
  		System.out.println("===<< 성적관리 시스템 메뉴 >>===");
  		System.out.println("1. 전체 수강생 조회");
  		System.out.println("2. 합격 수강생 조회");
  		System.out.println("3. 불합격 수강생 조회");
  		System.out.println("4. 수강생 정보 추가");
  		System.out.println("5. 수강생 정보 수정");
  		System.out.println("6. 수강생 정보 삭제");
  		System.out.println("7. 학번으로 수강생 정보 조회");		 
  		System.out.println("9. 시스템 종료");
  		System.out.println("===============================");
  
  	}
  
  }
  
  ```






### Exercise4.docx

```sql
--subquery
--1
select *
from employees
where department_id = (
    select department_id from employees 
    where last_name = 'Zlotkey')
    and last_name != 'Zlotkey';
    
--2
select employee_id, last_name, salary
from employees
where salary > (
    select avg(salary) from employees)
order by salary asc;

--3
select employee_id, last_name
from employees
where department_id in (
    select department_id
    from employees
    where last_name like '%u%'
    );
    
--4
select last_name, department_id, job_id
from employees
where department_id in (
    select distinct department_id 
    from departments
    where location_id = 1700
)
order by department_id asc;

--5
select last_name, salary
from employees
where manager_id = (
    select employee_id
    from employees
    where last_name = 'King'
);
    
--6
select department_id, last_name, job_id
from employees
where department_id = (
    select department_id
    from departments
    where department_name = 'Executive'
    );

--7
select 
    employee_id, last_name, salary
from 
    employees
where 
    department_id in (
        select distinct department_id
        from employees
        where last_name like '%u%'
    )
    and
    salary > (
        select avg(salary)
        from employees
    );
    
    
--set operators
--1
select distinct department_id
from employees
MINUS
select distinct department_id
from employees
where job_id = 'ST_CLERK';

--2
select 
    country_id as "CO", country_name
from 
    countries
MINUS 
select 
    distinct country_id, country_name
from 
    locations left join countries using (country_id);

--3
select distinct job_id, department_id
from employees
where department_id = 10
UNION ALL
select * from (
    select distinct job_id, department_id
    from employees
    where department_id = 50
    order by job_id asc
)
UNION ALL
select distinct job_id, department_id
from employees
where department_id = 20;

--4
select employee_id, job_id
from employees
INTERSECT
select distinct employee_id, job_id
from job_history;

--5
select last_name, department_id, to_char(null)
from employees
UNION
select to_char(null), department_id, department_name
from departments;

```

