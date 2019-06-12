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

  

- ㅇㄹㅇㄹ

- ㅇㄹ

- ㅇㄹ

- ㅇㄹ

- 