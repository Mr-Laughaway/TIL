##### 게시판의 유스케이스

- 게시물 작성

  - 포함기능

    - 비밀번호 설정

  - 확장기능

    - 사진파일 첨부

    

- 게시물 목록



- 게시물 보기

  - 포함기능
  - 확장기능
    - 댓글

  

- 게시물 수정

  - 포함기능
    - 비밀번호 체크
  - 확장기능

  

- 게시물 삭제

  - 포함기능
    - 비밀번호 체크
  - 확장기능



- 댓글작성
- 댓글수정
- 댓글삭제





##### 게시글의 데이터

- 제목
- 내용
- 작성자
- 작성일
- 조회수
- 글번호
- 첨부파일(multi?)
- 비밀번호



##### 댓글의 데이터

- 글번호
- 게시글번호
- 작성자
- 내용
- 비밀번호



// 전체 게시물 수와 페이지 크기를 가지고 전체 페이지 개수를 계산한다.
// 소수점에 따라 계산 상의 오류가 없도록 두 가지 중 한 가지를 이용한다.
방법 1 : pageCount = totalCount / PAGE_SIZE;
방법 2 :pageCount = (int)Math.ceil(totalCount / (PAGE_SIZE+0.0));

if((totalCount % PAGE_SIZE) !=0)
pageCount++;

// 현재 그룹 설정
int curGroup = (curPage-1) / GROUP_SIZE;









```
DECLARE
      vn_base_num NUMBER := 3;
    BEGIN
       FOR i IN 1..9
       LOOP
          DBMS_OUTPUT.PUT_LINE (vn_base_num || '*' || i || '= ' || vn_base_num * i);
       END LOOP;
    END;

# DBMS_RANDOM.VALUE
- 랜덤한 숫자를 생성한다.
- Syntax : DBMS_RANDOM.VALUE(low IN NUMBER, high IN NUMBER)
- 파라미터 low는: 최소 범위, high는: 최대 범위 값이다.

SELECT DBMS_RANDOM.VALUE(1000, 10000) rand FROM DUAL;

SELECT CEIL(DBMS_RANDOM.VALUE(1000, 10000)) rand 
FROM DUAL
CONNECT BY LEVEL <= 10;


# DBMS_RANDOM.STRING
- 랜덤한 문자열을 생성한다.
- Syntax : DBMS_RANDOM.STRING opt IN CHAR, len IN NUMBER)
- opt (옵션)은 아래와 같다.
'u', 'U' : 대문자
'l', 'L' : 소문자
'a', 'A' : 대소문자 구분없는 영문자
'x', 'X' : 영문자와 숫자 혼합
'p', 'P' : 문자 혼합


    SELECT DBMS_RANDOM.STRING('U',  10) rand FROM DUAL -- 대문자
    UNION ALL
    SELECT DBMS_RANDOM.STRING('L',  10) rand  FROM DUAL -- 소문자
    UNION ALL
    SELECT DBMS_RANDOM.STRING('A',  10) rand  FROM DUAL -- 영문자
    UNION ALL
    SELECT DBMS_RANDOM.STRING('X',  10) rand FROM DUAL -- 영숫자
    UNION ALL
    SELECT DBMS_RANDOM.STRING('P',  10) rand FROM DUAL  --문자혼합
)
SELECT * FROM t;


# DBMS_RANDOM.RANDOM
- DBMS_RANDOM.RANDOM은 랜덤 한 숫자를 생성해 준다.
- 한번 실행해 보자 SELECT DBMS_RANDOM.RANDOM FROM DUAL
- DBMS_RANDOM.RANDOM 함수를 이용하면 데이터를 랜덤한 순서로 정렬 할 수 있다.

SELECT * 
  FROM
     (SELECT * 
        FROM emp 
       ORDER BY DBMS_RANDOM.RANDOM()) 
 WHERE ROWNUM <= 3;

   
   
 DECLARE       
    BEGIN
       FOR i IN 1..35
       LOOP
           insert into emaillist values (DBMS_RANDOM.STRING('L',  10), concat(DBMS_RANDOM.STRING('L',  5), '@korea.com'), emaillist_seq.nextval);
       END LOOP;
       commit;
    END;  
    /
    
    
    
// 전체 게시물 수와 페이지 크기를 가지고 전체 페이지 개수를 계산한다.
// 소수점에 따라 계산 상의 오류가 없도록 두 가지 중 한 가지를 이용한다.
방법 1 : pageCount = totalCount / PAGE_SIZE;
방법 2 :pageCount = (int)Math.ceil(totalCount / (PAGE_SIZE+0.0));

if((totalCount % PAGE_SIZE) !=0)
pageCount++;

// 현재 그룹 설정
int curGroup = (curPage-1) / GROUP_SIZE;


drop table bbs purge;

create table bbs(
bid  number(6)  primary key,  --글번호
subject 	varchar2(100),    --제목
writer 		varchar2(20),     ---작성자
password 	varchar2(15),     --비밀번호
idate		date,             --작성일
contents        varchar2(2000),  --글내용
email           varchar2(50), --이메일
ip		varchar2(30), --작성자 pc ip
fileYN		char(1)   default 'N' check( fileYN in('Y','N')) ,   --file첨부 여부
rcount		number(5)  default 0,   --조회수 
vcount 		number (5)  default 0  --추천
);

drop sequence bbs_seq;
create sequence bbs_seq nocache;


create table bbs_comment (
cmid    number(6)  primary key, 
rbid   number(6), 
writer varchar2(20), 
idate  date, 
contents  varchar2(1000), 
password   varchar2(15), 
ip      varchar2(30)
);

drop sequence comment_seq;
create sequence comment_seq nocache;


insert into bbs (bid, subject, writer, idate, contents, password, ip)
values (bbs_seq.nextval, '테스트', '게시판지기', sysdate, 
'게시판 테스트입니다', '1234', '70.12.50.130');

insert into bbs_comment (cmid, rbid, writer, idate, contents, password, ip
) values (comment_seq.nextval, -1, '관리자', sysdate, 
'댓글 테스트입니다', '1234', '70.12.50.131');
commit;

create table bbs_file (
    fid   number primary key,
    rbid   number ,
    filename  varchar2(50),
    filetype   varchar2(15)
);
 
create sequence bbsfile_seq nocache;
commit;

select * from bbs;
select * from bbs_comment;
select * from bbs_file;





```