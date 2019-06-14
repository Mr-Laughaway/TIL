### SQL/JDBC 수행평가

#### SQL

```sql
--[SQL]
--1.
desc emp;


--2.
select distinct deptno from emp;


--3.
select to_char(sysdate, 'YYYY"년" MM"년" DD"일"') "Today"
from dual;


--4.
select deptno, count(empno) as "사원수", avg(sal) as "급여평균"
from emp
group by deptno
order by deptno asc;


--5.
select deptno, job, avg(sal)
from emp
group by rollup(deptno, job);

s
--6.
select ename, deptno, dname, loc
from emp full outer join dept using (deptno);


--7.
select 
    a.employee_id "사번",
    a.first_name "사원 이름",
    a.manager_id "매니저 사번",
    b.first_name "매니저 이름"
from
    employees a,  employees b 
where 
    a.manager_id = b.employee_id
    and
    a.department_id is null;


--8.
select mon as "입사월", to_char(max(salary), '9,999,999')  || '원' as "최고급여"
from (
    select
        to_number(to_char(hire_date, 'MM')) || '월' as mon,
        salary
    from  employees
)
group by mon
having max(salary) >= 10000
order by max(salary) desc, mon;


--9.
select 
    hireyear as "입사년도",
    count(employee_id) as "조건에 맞는 직원수"
from (
        select 
            to_char(hire_date, 'YY') as hireyear,
            employee_id
        from employees
        where salary between 5000 and 10000
)
group by hireyear
having count(employee_id) >= 7
order by hireyear;


```



#### JDBC

```java
package lab.jdbc.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JdbcExam {

	public static void main(String[] args) {
		
		System.out.print("FIRST_NAME 첫 글자를 입력하세요 : ");
		Scanner input = new Scanner(System.in);
		String inputSt = input.nextLine();
		inputSt = inputSt.toUpperCase();
		
		search(inputSt);
		
	}//main end
	
	
	
	public static void search(String inputSt) {
		Connection con = null; 
		PreparedStatement stat = null;
		String sql = "select * from employees where first_name like (? || '%') order by salary";
		ResultSet rs = null;
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl", 
					"hr", 
					"oracle"
			);
			
			stat = con.prepareStatement(sql);		
			stat.setString(1, inputSt);
			rs = stat.executeQuery();
			while(rs.next()) {
				int nSal = rs.getInt("salary");
				System.out.println(
						rs.getString("first_name") + "(" 
						+ rs.getString("last_name") + ") "
						+ nSal/1000 + "," + String.format("%03d", nSal%1000) + "원" 
						
				);
			}
	
		}
		catch(ClassNotFoundException e) {
			System.out.println("Driver 없음");
		}
		catch(SQLException e) {
			System.out.println( "DB연동 오류 발생 : " + e.getMessage());
		}
		finally {
			try {
				if(rs != null) rs.close();
				if(stat != null) stat.close();
				if(con != null) con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}//finally end
	}

}//class end


```

