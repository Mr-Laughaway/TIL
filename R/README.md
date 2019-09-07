<h1>R</h1>

![Statistics](assets/title.png)

> - 객체지향 프로그래밍 언어
>- 데이터, 함수, 차트 등 모든 데이터는 객체 형태로 관리된다.
>   
>- 통계 분석과 data의 시각화를 지원하는 소프트웨어 환경
> 
>- 컴퓨터 언어이자 다양한 패키지의 집합
> 
>- data의 시각화를 위한 다양한 그래픽 도구를 제공

<br>

# 1. R

## 1.1  설치

### 1.1.1 R 설치

:link:[다운로드](https://www.r-project.org)

- mirror site 설정
- download
- 작동 확인
  - help()
  - demo()
  - q()

### 1.1.2 R Studio 설치

:link:[다운로드](https://www.rstudio.com/products/rstudio/download/)

## 1.2. 기본 동작 확인

### 1.2.1. R 패키지 확인

```R
dim(available.packages())
[1] 14883    17

available.packages()
                              Package                        
A3                            "A3"                           
aaSEA                         "aaSEA"   
...
```

#### 1.2.1.1. 설치된 R 패키지 목록 확인

```R
installed.packages()
```

#### 1.2.1.2. R 패키지 설치

```R
install.packages("패키지명")
```

#### 1.2.1.3. R 패키지 삭제

```R
remove.packasges("패키지명")
```

#### 1.2.1.4. R 패키지 로드

- library()

  ```R
  library("패키지명") 
  ```

- require()

  ```R
  require("패키지명")
  ```

#### 1.2.1.5. 메모리에 로드된 패키지 검색

```R
serach()
[1] ".GlobalEnv"        "package:stringr"  
[3] "tools:rstudio"     "package:stats"    
[5] "package:graphics"  "package:grDevices"
[7] "package:utils"     "package:datasets" 
[9] "package:methods"   "Autoloads"        
[11] "package:base
```

#### 1.2.1.6.  설치된 R 패키지의 저장위치 확인

```R
.libPaths()
[1] "C:/Program Files/R/R-3.6.1/library"
```

### 1.2.2. R 살펴보기 - 맛보기

#### 1.2.2.1. 기본 제공 data set 보기

```R
data()
```

- Nile 이라는 기본 데이터로 histogram 그려보기

  ```R
  hist(Nile)
  ```

  ![1567834872349](assets/1567834872349.png)

- 밀도 기준 histogram

  ```R
  hist(Nile, freq=F)
  ```

- 분포 곡선 그리기

  ```R
  lines(density(Nile))
  ```

  

  ![1567835109816](assets/1567835109816.png)

- plot 영역 설정 및 결과 저장

  ```R
  # 출력 영역 설정
  par(mfrow=c(1,1))
  
  #pdf 형식의 출력 파일 열기
  pdf("c:/workspace_R/sample.pdf")
  
  #정규분포를 따르는 난수 20개 생성해서 히스토그램 생성
  hist(rnorm(20)) 
  
  #출력 파일 닫기
  dev.off()	
  ```

#### 1.2.2.2. R session 정보 확인

사용자가 R 프로그램을 시작한 후 R콘솔 시작 ~종료 까지의 모든 정보를 담고있는 객체이다.

```R
sessionInfo()
```

#### 1.2.2.3. R 기본 함수 사용 예제 보기

```R
exmaple(seq)
```

####  1.2.3.4. R 기본 제공 함수의 파라미터 형식 보기

```R
args(max)
```

#### 1.2.3.5. help

```R
help(mean)
?sum #R document에서 확인
??mean #이건 뭐다? 
```

## 1.3. 변수

### 1.3.1. 변수 선언

- 첫 문자는 영문자 혹은 . 으로 시작

- 첫 문자가 .으로 시작한다면 .뒤에는 숫자가 올 수 없다.

- 두 번 째 문자부터는 숫자, _, . 사용 가능

- 대소문자 구분

- 예약어 사용 불가

- 변수에 저장된 값은 불변

  ```R
  x <- 3
  tracemem(x)
  [1] "<00000000182A0858>"
  
  x <- 'a'
  tracemem(x)
  [1] "<0000000010384628>"
  ```

- R은 변수를 선언할 때 자료형(type)을 선언하지 않는다.

### 1.3.2. 변수 확인

```
ls()
objects()
```

### 1.3.3. 변수 삭제

```
rm(list=ls())
rm(변수)
```

## 1.4. 자료형

### 1.4.1. Scalar 변수

단일 값(하나의 값)을 저장하는 변수

#### 1.4.1.1 numeric

```R
age <- 30 #age 변수는 하나의 값을 저장하고 있는 벡터 타입

class(age)
[1] "numeric"
```

#### 1.4.1.2. logical

```R
age <- TRUE #상수객체(TRUE, FALSE)
class(age)
[1] "logical"

#T 변수에 TRUE저장, F변수에 FALSE 저장
age <- F
class(age)
[1] "logical"

TRUE & TRUE
TRUE & FALSE

c(TRUE, TRUE) & c(TRUE, FALSE)
[1]  TRUE FALSE

#short circuit operator ?
c(TRUE, TRUE) && c(TRUE, FALSE)
[1] TRUE
```

#### 1.4.1.3. NA 

결측치, 즉 값이 빠져 있는 경우를 뜻한다.

```R
age <- NA
> class(a)
[1] "logical"

a <- NA + 10
class(a)
[1] "numeric"

# 옵션을 넣고 결측치를 없애서 결과를 정상적으로 나오게 만들기
sum(10, 20, 30)
[1] 60
> sum(10, 20, 30, NA)
[1] NA
> sum(10, 20, 30, NA, na.rm=T)
[1] 60
```

#### 1.4.1.4. NULL

프로그래밍의 편의를 위해 미정(undefined) 값을 표현하는데 사용.

```R
age <- NULL
class(a)
[1] "NULL"
```

#### 1.4.1.5. character

```R
a <- "hello"
print(a)

a <- 'hello'
print(a)

class(a)
[1] "character"
```

#### 1.4.1.6. 날짜와 시간

- format

  - `%d` 일자를 숫자로 인식
  - `%m` 월을 숫자로 인식
  - `%b` 월을 영어 약어로 인식
  - `%B`월을 전체 이름으로 인식
  - `%y`년도를 숫자 두 자리로 인식
  - `%Y` 년도를 숫자 네 자리로 인식

  ```R
  Sys.date() #날짜만 보여주는 함수
  sys.time() #날짜와 시간을 보여주는 함수
  date() #미국식 날짜와 시간을 출력하는 함수
  as.Date('2017-12-01') #문자형텨의 날짜를 날짜타입으로 변환해주는 함수
  as.Date('2017/07/04')
  as.Date('04-07-2017') #날짜가 이상하게 들어감
  as.Date('04-07-2017', format='%d-%m-%Y') #이렇게 형식을 맞추어 줄 수 있다.
  as.Date(10, origin='2017-12-01') #주어진 날짜 기준으로 10일 후의 날짜
  as.Date(-10, origin='2017-12-01') #주어진 날짜 기준으로 10일 이전의 날짜
  ```

- 로케일이 안 맞는 경우

  ```R
  #Sys.setlocale(category="LC_ALL", locale="언어_국가")
  Sys.setlocale(category="LC_ALL", locale="Korean_Korea")
  Sys.setlocale(category="LC_ALL", locale="English_US")
  ```

- 날짜 산술 연산

  ```R
  as.Date("2017-07-31") - as.Date("2017-07-04")
  Time difference of 27 days
  ```

- POSIX

  - POSIXt 날짜를 년, 월,일로 표시하는 리스트형 클래스
  - POSIXct 날짜를 연속적인 데이터로 인식해서 1970년을 기준으로 초 단위... 회기분석 때에 많이 쓴다.

  ```R
  as.Date("2017-07-04 20:00:00") - as.Date("2017-07-04 18:30")
  Time difference of 0 days
  as.POSIXct("2017-07-04 20:00:00") - as.POSIXct("2017-07-04 18:30")
  Time difference of 1.5 hours
  ```

- lubridate 패키지로 날짜와 시간 제어하기

  ```R
  install.packages("lubridate")
  library(lubridate)
  date <- now() #현재 날짜와 시간 넣기
  date
  year(date) #년도만 출력
  month(date,label=T) #월을 영문으로 출력
  month(date,label=F) #월을 숫자로 출력
  day(date)
  ```

### 1.4.2. 자료형 확인

#### 1.4.2.1. 자료구조의 Type 확인

```R
class(변수)
```

#### 1.4.2.2. 자료의 Type 확인

```R
mode(변수)
```

#### 1.4.2.3. is

```R
is.numeric(변수)
is.logical(변수)
is.character(변수)
is.na(변수)
is.list(변수)
is.data.frame(변수)
is.array(변수)
is.matrix(변수)
```

### 1.4.3. 자료형 형변환

- 기본 변환 방법

  ```R
  as.numeric(변수)
  as.logical(변수)
  as.character(변수)
  as.na(변수)
  as.list(객체)
  as.data.frame(객체)
  as.array(객체)
  as.matrix(객체)
  as.integer(변수)
  as.double(변수)
  as.complex(변수) #복소수
  as.factor(객체)
  as.Date(객체)
  ```

- 사용 예1)

  ```R
  x <- c("1", "2", "3")
  result <- x * 3
  result <- as.numeric(x) * 3
  print(result)
  result <- as.integer(x) * 3
  print(result)
  ```

- 사용 예2)

  ```R
  z <- 5.3-3i #복소수 자료형 생성
  class(z)
  [1] "complex"
  
  Re(z)	#실수부만 반환
  [1] 5.3
  Im(z)	#허수부만 반환
  [1] -3
  ```

### 1.4.4. Factor

>- 여러번 중복으로 나오는 데이터들을 각 값으로 모아서 대표 값을 출력해 주는 형태
>- stringAsFactors=FALSE 옵션은 대표값으로 정리하지 않고 중복되는 상태 그대로 사용하게 해줌
>- 범주형(Categorical) 데이터(자료)를 표현하기 위한 데이터 타입
>- 범주형 데이터 - 데이터가 사전에 정해진 특정 유형으로만 분류되는 경우
>- 범주형 데이터는 또 다시 명목형(Nominal)과 순서형(Ordinal)으로 구분
>- 명목형 데이터는 값들 간에 크기 비교가 불가능한 경우
>- 순서형 데이터는 대, 중, 소와 같이 값에 순서를 둘 수 있는 경우

#### 1.4.4.1. 기본 사용법

```R
sex <- factor("m", c("m", "f"))
sex
[1] m
Levels: m f

nlevels(sex)
[1] 2

levels(sex)
[1] "m" "f"

levels(sex)[1]
[1] "m"
levels(sex)[2]
[1] "f"

levels(sex) <- c("male", "female") #팩터 변수에서 레벨 값을 직접 수정
sex

#명목형(Norminal)
factor(c("m", "m", "f"), c("m", "f"))

#순서형(Ordinal)
ordered("a", c("a", "b", "c"))
```

#### 1.4.4.2. 명목형 - Norminal

명목형 데이터로 `plot` 그려보기

```R
# charater vector 는 plot 시 error 발생
gender <- c("man", "woman", "woman", "man", "man")
plot(gender) #error

class(gender)
[1] "character"
mode(gender)
[1] "character"

# character vector를 factor로 바꾸면 plot 을 그릴 수 있다.
ngender <- as.factor(gender)
class(ngender)
[1] "factor"
mode(ngender)
[1] "numeric"

is.factor(ngender)
[1] TRUE

ngender #Levels 속성에서 범주를 확인 (알파벳 순서?)
[1] man   woman woman man   man  
Levels: man woman

args(factor) #factor()함수의 매개변수 확인
[1] man   woman woman man   man  
Levels: man woman

table(ngender) # 빈도수 확인
plot(ngender)
```

![img](assets/norminal.jpg)

#### 1.4.4.3. 순서형 - Ordinal

순서형 데이터로 `plot` 그려보기

```R
#1.4.4.1. 이어서
ogender <- factor(gender, levels=c("woman", "man"), ordered=T)
ogender #범주의 순서 확인
[1] man   woman woman man   man  
Levels: woman < man

#저장 준비
jpeg("both.jpg", width=350, height=350)

par(mfrow=c(1,2))
plot(ngender)
plot(ogender)

#저장 완료
dev.off()
```

![img](assets/both.jpg)

### 1.4.5. Vector

>- 동일한 형태의 데이터를 모아서 함께 저장.
>- 1차원 배열과 비슷한 개념, 특정 항목의 요소를 사용하려면 벡터명[색인] 벡터 자체를 연산 할 수 있다.
>- 각 벡터의 요소에 `names()` 함수를 사용해서 이름 지정할 수 있다.
>- `seq()`, `rep()` 함수를 사용해서 벡터에 연속적인 데이터 할당 할 수 있다.
>- `length()` 함수는 벡터의 길이를 리턴
>- `%in%`는 벡터에 특정 문자의 포함 여부를 리턴합니다

#### 1.4.5.1. 접근

- 요소의 접근은 변수[index]로 접근한다. 

- index는 1부터 시작한다.

- 특정 요소만 추출

  ```R
  a <- c(1:20)
   [1]  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19 20
  
  a[3:10]
   [1]  3  4  5  6  7  8  9 10
  
  a[c(3, 10)]
   [1]  3 10
  
  t <- c("Sun", "Mon", "Tue", "Wed", "Thurs", "Fri", "Sat")
  
  t[1]
  [1] "Sun"
  
  t[7]
  [1] "Sat"
  
  t[c(2,3,6)
  [1] "Mon" "Tue" "Fri"
  ```

- 특정 요소만 제외

  벡터의 첨자에 -를 지정하면 해당 위치의 원소는 제외

  ```R
  a[-c(2:18)]
  [1]  1 19 20
  ```

- TRUE / FALSE 로 접근

  ```R
  t <- c("Sun", "Mon", "Tue", "Wed", "Thurs", "Fri", "Sat")
  
  t[c(T, F, F, F, F, T, F)]
  [1] "Sun" "Fri"
  ```
  
- 연속된 인덱스로 접근

  ```R
  t <- c("Sun", "Mon", "Tue", "Wed", "Thurs", "Fri", "Sat")
  
  t[c(0, 0, 0, 0, 0, 0, 1)]
  [1] "Sun"
  
  t[c(1, 2, 3, 1, 2, 3)]
  [1] "Sun" "Mon" "Tue" "Sun" "Mon" "Tue"
  ```

- 요소 반복

  연산 대상 벡터 요소 갯수가 가장 긴쪽에 맞춰서 싸이클링 된다.

  ```R
  v1 <- c(3, 8, 4, 5, 0, 11)
  v2 <- c(4, 11)
  
  v1 + v2
  [1]  7 19  8 16  4 22
  ```

- 조건 부 추출

  ```R
  nums <- c(3/2, 3%/%2, 5%%3, 2^10, 2**10)
  [1]    1.5    1.0    2.0 1024.0 1024.0
  
  #문> nums 벡터 요소 중 10보타 큰 요소만 출력(>, >=, ==, !=, <, <=)
  nums[nums > 10]
  [1] 1024 1024
  
  #문> nums 벡터 요소 중 짝수인 요소만 출력
  nums[nums %% 2 == 0]
  [1]    2 1024 1024
  ```
  
- 이름으로 접근

  ```R
  loc <- c("02", "031", "062", "052")
  names(loc) <- c("서울", "경기", "광주", "부산")
  print(loc["경기"]) #이름으로 벡터 요소 접근 가능
   경기 
  "031" 
  str(loc)
   Named chr [1:4] "02" "031" "062" "052"
   - attr(*, "names")= chr [1:4] "서울" "경기" "광주" "부산"
  ```

#### 1.4.5.2. 벡터 생성 함수

- c()

  combines

  ```R
  c(1:20)
  1:20
  c(1,1,2,3,3,3,4,5,5,5,5)
  ```

- seq()

  sequences

  ```R
  seq(1, 20)
  seq(1, 20, 2) #순차적으로 값을 증감시켜서 벡터 자료 구조 생성
  ```

- rep()

  replicates
  
  ```R
  rep(1:3, 3)
  [1] 1 2 3 1 2 3 1 2 3
  
  rep(1:3, each=3)
  [1] 1 1 1 2 2 2 3 3 3
  ```

#### 1.4.5.3. 벡터에 요소 추가

- append()

  ```R
  print(nums)
  [1]    1.5    1.0    2.0 1024.0 1024.0
  
  newValue <-append(nums, 99, after=3) #data가 추가된 벡터를 리턴함
  
  print(newValue)
  [1]    1.5    1.0    2.0   99.0 1024.0 1024.0
  ```

#### 1.4.5.4. 벡터 집합 연산자

- union()

  ```R
  a <- c(1:5)
  [1] 1 2 3 4 5
  
  b <- rep(1:3, 3)
  [1] 1 2 3 1 2 3 1 2 3
  
  union(a, b)
  [1] 1 2 3 4 5
  ```

- setdiff()

  ```R
  setdiff(a, b)
  [1] 4 5
  ```

- intersect()

  ```R
  intersect(a, b)
  [1] 1 2 3
  ```

- setequal

  순서는 일치 하지 않아도 요소들만 일치하면 TRUE 를 리턴
  
  ```R
  vec1 <- c(1, 2, 3, 4, 5)
  vec2 <- c(1, 2, 3, 4, 5)
  vec3 <- c(5, 4, 3, 2, 1)
  
  setequal(vec1, vec2)
  [1] TRUE
  setequal(vec1, vec3)
  [1] TRUE					#주의
  ```
  
- identical

  요소 뿐 아니라 순서도 일치해야 TRUE 를 리턴

  ```R
  identical(vec1, vec2)
  [1] TRUE
  identical(vec1, vec3)
  [1] FALSE					#주의
  ```

#### 1.4.5.5. 자동 형 변환

벡터는 같은 자료만 담을 수 있기때문에 큰 타입으로 자동 형변환 된다.

```R
f <- c(33, -5, "4", 5:9) 
[1] "33" "-5" "4"  "5"  "6"  "7"  "8"  "9"  #문자열로 변환 됨
class(f)
[1] "character"
mode(f)
[1] "character"
```

#### 1.4.5.6. 벡터의 정렬

```R
v <- c(3, 8, 4, 5, 0, 11, -9, 304)
[1]   3   8   4   5   0  11  -9 304

sort(v)
[1]  -9   0   3   4   5   8  11 304

sort(v, decreasing=TRUE)
[1] 304  11   8   5   4   3   0  -9

v <- c("Red", "Blue", "Yellow", "Violet")
[1] "Red"    "Blue"   "Yellow" "Violet"

sort(v)
[1] "Blue"   "Red"    "Violet" "Yellow"
```

### 1.4.6. Matrix

> - 벡터를 여러 개 합친 형태, 2차원으로 데이터를 저장
> - 동일한 데이터 유형만 저장
> - `rbind()`로 행을 추가할 수 있다.
> - `cbind()`로 컬럼을 추가할 수 있다.
> - 컬럼 이름을 지정, 조회하려면 colnames() 사용
> - 행이름 지정, 조회하려면 rownames() 사용

```R
#Matrix 생성 함수
matrix(
    data,
    nrow = 1,			#default: 1
    ncol = 1,			#default: 1
    byrow = FALSE,		#default: FALSE - 한 행씩 데이터를 넣으려면 TRUE로 
    dimnames = NULL		#형렬의 각 차원에 부여할 이름
)
```

#### 1.4.6.1. Matrix 생성

- 기본 생성

  ```R
  M <- matrix(c(3:14))
  print(M)
        [,1]
   [1,]    3
   [2,]    4
   [3,]    5
   [4,]    6
   [5,]    7
   [6,]    8
   [7,]    9
   [8,]   10
   [9,]   11
  [10,]   12
  [11,]   13
  [12,]   14
  str(M)
   int [1:12, 1] 3 4 5 6 7 8 9 10 11 12 ...
  ```

- 행 갯수를 지정하여 생성

  ```R
  M1 <- matrix(c(3:14), nrow=3)
  print(M1)
       [,1] [,2] [,3] [,4]
  [1,]    3    6    9   12
  [2,]    4    7   10   13
  [3,]    5    8   11   14
  str(M1)
   int [1:3, 1:4] 3 4 5 6 7 8 9 10 11 12 ...
  ```

- 데이터는 한 행씩 채우도록 생성

  ```R
  M2 <- matrix(c(3:14), nrow=4, byrow=TRUE)
  print(M2)
       [,1] [,2] [,3]
  [1,]    3    4    5
  [2,]    6    7    8
  [3,]    9   10   11
  [4,]   12   13   14
  str(M2)
   int [1:4, 1:3] 3 6 9 12 4 7 10 13 5 8 ...
  ```

- rbind()를 이용하여 생성

  ```R
  x1 <- c(5, 40, 50:52)
  x2 <- c(30, 5, 6:8)
  M3 <- rbind(x1, x2)
  print(M3)
     [,1] [,2] [,3] [,4] [,5]
  x1    5   40   50   51   52
  x2   30    5    6    7    8
  str(M3)
   num [1:2, 1:5] 5 30 40 5 50 6 51 7 52 8
   - attr(*, "dimnames")=List of 2
    ..$ : chr [1:2] "x1" "x2"
    ..$ : NULL
  ```

- 요소 자동 채움

  행과 열의 수가 일치하지 않으면 오류가 발생하며, 모자라는 데이터는 처음 요소부터 다신 반복하여 채운다.

  ```R
  M <- matrix(10:20, 2)
  Warning message:
  In matrix(10:20, 2) :
    data length [11] is not a sub-multiple or multiple of the number of rows [2]
  print(M)
       [,1] [,2] [,3] [,4] [,5] [,6]
  [1,]   10   12   14   16   18   20
  [2,]   11   13   15   17   19   10
  ```

  

```R


##
rownames = c("row1", "row2", "row3", "row4")
colnames = c("col1", "col2", "col3")
M5 <- matrix(c(3:14) nrow=5, byrow = TRUE, dimnames = list(rownames, colnames))
print(M5)
     col1 col2 col3
row1    3    4    5
row2    6    7    8
row3    9   10   11
row4   12   13   14


####
P1 <- cbind(M5, c(13, 14, 15, 16)) #cbind()는 컬럼을 추가
print(p1)
     col1 col2 col3   
row1    3    4    5 13
row2    6    7    8 14
row3    9   10   11 15
row4   12   13   14 16

P2 <- rbind(M5, c(13, 14, 15)) #rbind()는 행을 추가
print(P2)
    col1 col2 col3
row1    3    4    5
row2    6    7    8
row3    9   10   11
row4   12   13   14
       13   14   15

print(M5 + P1) #열 갯수가 달라서 error 발생
Error in M5 + P1 : non-conformable arrays
print(M5 + P2) #행 갯수가 달라서 error 발생
Error in M5 + P2 : non-conformable arrays


```

#### 1.4.6.2. Matrix 접근

```R
#Matrix 요소에 접근 - 변수[첨자, 첨자]
#특정 행이나 특정 열만 접근하는 경우 변수명[행첨자, ] 변수명[, 열첨자]
print(M5[1, 3])
print(M5[2, ]) #2행 전체 요소에 접근
print(M5[, 3]) #3열 전체 요소에 접근
print(M5["row1", ]) #"row1"행 전체 요소에 접근
print(M5[, "col3"]) #"col3"열 전체 요소에 접근
```

#### 1.4.6.3. Matrix 연산

```R
#Matrix 연산
matrix1 <- matrix(c(3, 9, -1, 4, 2, 6), nrow=2)
     [,1] [,2] [,3]
[1,]    3   -1    2
[2,]    9    4    6
matrix2 <- matrix(c(5, 2, 0, 9, 3, 4), nrow=2)
     [,1] [,2] [,3]
[1,]    5    0    3
[2,]    2    9    4

result <- matrix1 + matrix2
     [,1] [,2] [,3]
[1,]    8   -1    5
[2,]   11   13   10

###
result <- matrix1 + 10
print(result)
     [,1] [,2] [,3]
[1,]   13    9   12
[2,]   19   14   16
print(length(result))
[1] 6
print(nrow(result))
[1] 2
print(ncol(result))
[1] 3


#Base패키지의 apply함수
#apply(행렬객체, margin(1:행, 2:열), function)
     [,1] [,2] [,3]
[1,]    3   -1    2
[2,]    9    4    6

f <- function(x) {
    x * c(1, 2, 3)
}

result <- apply(matrix1, 1, f)
print(result)
     [,1] [,2]
[1,]    3    9
[2,]   -2    8
[3,]    6   18

result <- apply(matrix(1:9, ncol=3), 2, f)
print(result)
     [,1] [,2] [,3]
[1,]    1    4    7
[2,]    4   10   16
[3,]    9   18   27



#####
print(dim(M5)) # matrix의 차원 리턴
[1] 4 3


####
m1 <- matrix(c(1:9), ncol=3, byrow=TRUE)
print(m1)
     [,1] [,2] [,3]
[1,]    1    2    3
[2,]    4    5    6
[3,]    7    8    9
print(t(m1)) #전치행렬 리턴 함수
     [,1] [,2] [,3]
[1,]    1    4    7
[2,]    2    5    8
[3,]    3    6    9

### 행렬의 곱 연산
m2 <- matrix(rep(1:3, times=3), nrow=3)
print(m2)
     [,1] [,2] [,3]
[1,]    1    1    1
[2,]    2    2    2
[3,]    3    3    3
print(m1 %*% m2)
     [,1] [,2] [,3]
[1,]   14   14   14
[2,]   32   32   32
[3,]   50   50   50



#문 P2 matrix객체에서 2행과 4행을 제외하고 출력
P2[-c(2,4), ]

#문 P2 matrix객체에서 1열과 3열을 제외하고 출력
P2[, -c(1, 3)]


##!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
####
print(m1)
     [,1] [,2] [,3]
[1,]    1    2    3
[2,]    4    5    6
[3,]    7    8    9
m3 <- m1[, -c(1,3)] #matrix에서 하나의 열을 남겨놓고, 모든 열을 제거하면, 벡터가 됨.
print(m3)
[1] 2 5 8
str(m3)
int [1:3] 2 5 8

m3 <- m1[, -c(1, 3), drop=FALSE] #벡터로 변환되지 않도록 matrix의 구조를 유지
print(m3)
     [,1]
[1,]    2
[2,]    5
[3,]    8
str(m3)
 int [1:3, 1] 2 5 8


#####
rownames(M5)
colnames(M5)

#문> 행이름과 열이름 제거
rownames(M5)  NULL


###역행렬
m4 <- matrix(c(1,2,3,4,5,4,3,2,1), ncol=3)
     [,1] [,2] [,3]
[1,]    1    4    3
[2,]    2    5    2
[3,]    3    4    1
result <- solve(m4) #역형렬 결과 리턴
print(result)
       [,1] [,2]   [,3]
[1,]  0.375   -1  0.875
[2,] -0.500    1 -0.500
[3,]  0.875   -1  0.375


```

### 1.4.7. Array

동일한 자료형을 갖는 다차원 배열 구조

행, 열, 면의 3차원 배열 형태의 객체를 생성

첨자로 접근

다른 자료구조에 비해 상대적으로 활용도가 낮음

#### 1.4.7.1. Array 생성

```R
vector1 <- c(5, 9, 3)
vector2 <- c(10, 11, 12, 13, 14, 15)

result <- array(c(vector1, vector2), dim=(3, 3, 2)) #row, col, layer
print(result)
, , 1

     [,1] [,2] [,3]
[1,]    5   10   13
[2,]    9   11   14
[3,]    3   12   15

, , 2

     [,1] [,2] [,3]
[1,]    5   10   13
[2,]    9   11   14
[3,]    3   12   15
str(result)
 num [1:3, 1:3, 1:2] 5 9 3 10 11 12 13 14 15 5 ..


```

#### 1.4.7.2. Array 요소에 접근

```R
#2 Layer의 3행 모든 데이터 접근 [] 3 12 15
print(result[3, ,2])
[1]  3 12 15

#1 Layer의 1행의 3열 데이터 접근 13
print(result[1, 3, 1])
[1] 13

print(result[, , 2])
     [,1] [,2] [,3]
[1,]    5   10   13
[2,]    9   11   14
[3,]    3   12   15
```

#### 1.4.7.3. Matrix로 변환

```R
vector3 <- c(9, 1, 0)
vector4 <- c(6, 0, 11, 3, 14, 1, 2, 6, 9)
array2 <- array(c(vector3, vector4), dim = c(3, 3, 2))
print(array2)

matrix1 <- result[, , 2]
matrix2 <- array2[, , 2]
print(matrix1 + matrix2)
     [,1] [,2] [,3]
[1,]    7   19   19
[2,]   15   12   14
[3,]   12   12   26
```

#### 1.4.7.4. Apply

```R
, , 1
	 [,1] [,2] [,3]
[1,]    9    6    3
[2,]    1    0   14
[3,]    0   11    1

, , 2
     [,1] [,2] [,3]
[1,]    2    9    6
[2,]    6    1    0
[3,]    9    0   11

rs1 <- apply(array2, c(1), sum)
print(rs1)
[1] 35 22 32 #9+6+3 + 2+9+6, 1+0+14 + 6+1+0, 0+11+1 + 9+0+11

```

### 1.4.8. List

>- List - 서로 다른 자료구조(벡터, 행렬, 리스트, 데이터프레임 등)을 객체로 구성
>- 키(key)와 값(value)의 한쌍으로 저장
>- c언어의 구조체, python의 dict 자료구조, java의 map컬렉션 구조와 유사
>- key를 통해 value 접근
>- value에 저장되는 자료구조는 벡터, 행렬, 리스트, 데이터프레임 등 대부분의 R객체 저장 가능
>- 함수 내에서 여러 값을 하나의 키로 묶어서 반환하는 경우 유용
>- list() - 생성자 함수
>- list(key =value1, key2=value2, ...)

#### 1.4.8.1. List 생성

```R
#key가 생략된 부분은 [[n]]형식으로 출력되고 , 
#해당 key에 저장된 value는 [n]형식으로 출력되며, 
#한 개의 값이 Vector 형식으로 저장
list1 <- list("lee", "이순신", 95)
print(list1)
[[1]]
[1] "lee"

[[2]]
[1] "이순신"

[[3]]
[1] 95
List of 3
 $ : chr "lee"
 $ : chr "이순신"
 $ : num 95

emp1 <-  list(name="kim", address="seoul", age=30, hiredate=as.Date("2017-01-30"))
print(emp1)
str(emp1)


#####
list_data <- list("Red", "Green", c(21, 32, 11), TRUE, 51.23, 119.1)
print(list_data)
[[1]]
[1] "Red"

[[2]]
[1] "Green"

[[3]]
[1] 21 32 11

[[4]]
[1] TRUE

[[5]]
[1] 51.23

[[6]]
[1] 119.1
str(list_data)
List of 6
 $ : chr "Red"
 $ : chr "Green"
 $ : num [1:3] 21 32 11
 $ : logi TRUE
 $ : num 51.2
 $ : num 119





```



#### 1.4.8.2. List 요소 접근

```R
print(emp1[1:2]) #색인으로 데이터 값 access
print(emp1$age) #key로 데이터 값 access


#문] 아래 list_data리스트의 요소중에서 k3에 저장된 세번 째요소만 출력
list_data <- list(k1="Red", k2="Green", k3=c(21,32,11),
                  k4=TRUE, k5=51.23, k6=119.1 )

 ist_data$k3[3]
[1] 11

## 불변 객체??

tracemem(emp1)
[1] "<000000001222CAF0>"
emp1$deptno <- 10
tracemem(emp1)
[1] "<0000000013659818>"

newValue <-append(nums, 99, after=3) #data가 추가된 벡터를 리턴함
print(nums)
print(newValue)
 

#리스트 요소 제거
emp1$age <- NULL
str(emp1)
List of 4
 $ name    : chr "kim"
 $ address : chr "seout"
 $ hiredate: Date[1:1], format: "2017-01-30"
 $ deptno  : num 10

# 리스트내에 값의 타입을 리스트로 저장 가능
lst2 <- list(
    cost=list(val=c(100, 150, 200)),
    price=list(val=c(200, 250, 300))
)
str(lst2)
List of 2
 $ cont :List of 1
  ..$ val: num [1:3] 100 150 200
 $ price:List of 1
  ..$ val: num [1:3] 200 250 300
print(lst2)
$cost
$cost$val
[1] 100 150 200

$price
$price$val
[1] 200 250 30

#cost 키의 두 번째 요소를 출력
print(lst2$cost$val[2])
[1] 150
#price 키의 세 번째 요소를 출력
print(lst2$price$val[3])
[1] 300

####
lst <- list()
str(lst)
lst[[1]] <- 0.5 #list에 키 없이 첫 번째 data 저장
lst[[2]] <- c("a", "c", "f") #list에 키 없이 두 번째 data 저장
str(lst)
$ : num 0.5
 $ : chr [1:3] "a" "c" "f"

lst[["price"]] <- c(100, 200, 300)
str(lst)


#unlist 함수 : 기본적인 통계 함수들은 벡터에서는 동작하지만 리스트에는 동작하지 않는 경우, 리스트 구조를 제거하고, 벡터로 만들어주는 함수
#서로 다른 데이터 타입의 값들이 chracter로 변환되어 named 벡터로 생성됨
vec_emp1 <- unlist(emp1)  
str(vec_emp1)

#문> exam1<- list(1,0, 2,0, -3, 4, -5, 6, 7, -8, 9, 10)
#exam1로부터 음수를 제거한 리스트 출력
exam1[exam1 >= 0]

#exam1로부터 0를 제거한 리스트 출력
exam1[exam1 != 0]

```

#### 1.4.8.3. 다차원 중첩 리스트

```R
#다차원(중첩) 리스트 - 리스트 자료구조에 다른 리스트가 중첩된 자료구조
multi_list <- list(
    c1 = list(1, 2, 3),
    c2 = list(10, 20, 30),
    c3 = list(100, 200, 300)
)
print(multi_list)
$c1
$c1[[1]]
[1] 1

$c1[[2]]
[1] 2

$c1[[3]]
[1] 3


$c2
$c2[[1]]
[1] 10

$c2[[2]]
[1] 20

$c2[[3]]
[1] 30


$c3
$c3[[1]]
[1] 100

$c3[[2]]
[1] 200

$c3[[3]]
[1] 300


#다차원 리스트를 열단위로 바인딩
do.call(cbind, multi_list)
     c1 c2 c3 
[1,] 1  10 100
[2,] 2  20 200
[3,] 3  30 300
```

#### 1.4.8.4. lapply

데이터 객체에 함수를 적용한 결과를 리스트 형으로 반환

```R
a <- list(c(1:5))
b <- list(6:10)
result <- lapply(c(a, b), max)
print(result)
[[1]]
[1] 5

[[2]]
[1] 10
str(result)
List of 2
 $ : int 5
 $ : int 10
```

#### 1.4.8.5. sapply

데이터 객체함수를 적용한 결과를 벡터 형으로 반환

```R
result <- sapply(c(a, b), max)
print(result)
[1]  5 10
str(result)
 int [1:2] 5 10
```

### 1.4.9. Dataframe

>- DataFrame - 데이터베이스의 테이블 구조와 유사
>- R에서 가장 많이 사용하는 자료구조
>- 컬럼 단위로 서로 다른 데이터 유형(type)을 저장 가능
>- 리스트와 벡터의 혼합형으로 컬럼은 리스트, 컬럼 내의 데이터는 벡터 자료구조를 갖는다
>- DataFrame 생성함수 - `data.frame()`, `read.table()`, `read.csv()`
>- txt, excel, csv 파일로부터 DataFrame 생성
>- data.frame(컬럼1=자료, 컬럼2=자료, ...컬럼n=자료)
>- 여러 개의 벡터 객체를 이용하여 데이터프레임을 생성할 수 있다. 
>- 이때 모든 컬럼은 길이가 같아야 한다. 컬럼의 길이가 서로 다르면 오류가 발생한다.

#### 1.4.9.1 Dataframe 생성

- 기본 생성

  ```R
  d1 <- data.frame(
      no = c(1, 2, 3, 4, 5),
      name = c('kim', 'park', 'lee', 'song', 'hong'),
      gender = c('F', 'F', 'M', 'F', 'M')
  )
  str(d1)
  'data.frame':	5 obs. of  3 variables:
   $ no    : num  1 2 3 4 5
   $ name  : Factor w/ 5 levels "hong","kim","lee",..: 2 4 3 5 1
   $ gender: Factor w/ 2 levels "F","M": 1 1 2 1 2
  print(d1)
    no name gender
  1  1  kim      F
  2  2 park      F
  3  3  lee      M
  4  4 song      F
  5  5 hong      M
  ```

- 데이터로부터 생성

  ```R
  no <- c(1, 2, 3)
  name <- c('hong', 'lee', 'kim')
  pay <- c(150, 250, 300)
  vemp <- data.frame(NO=no, Name=name, Pay=pay) #컬럼명 지정
  str(vemp)
  print(vemp)
    NO Name Pay
  1  1 hong 150
  2  2  lee 250
  3  3  kim 300
  
  
  ###########################
  sales1 <- matrix(
      c(
          1, 'Apple', 500, 5,
          2, 'Peach', 200, 2,
          3, 'Banana', 100, 4,
          4, 'Graph', 50, 7
      ),
      nrow =4,
      byrow = T
  )
  str(sales1)
  df1 <- data.frame(sales1)
  print(df1)
    X1     X2  X3 X4
  1  1  Apple 500  5
  2  2  Peach 200  2
  3  3 Banana 100  4
  4  4  Graph  50  7
  
  
  str(df1) # 각 컬럼의 데이터 타입은? 컬럼 이름은?
  'data.frame':	4 obs. of  4 variables:
   $ X1: Factor w/ 4 levels "1","2","3","4": 1 2 3 4
   $ X2: Factor w/ 4 levels "Apple","Banana",..: 1 4 2 3
   $ X3: Factor w/ 4 levels "100","200","50",..: 4 2 1 3
   $ X4: Factor w/ 4 levels "2","4","5","7": 3 1 2 4
  
  df1 <- data.frame(sales1, stringsAsFactors=FALSE)
  str(df1)
  'data.frame':	4 obs. of  4 variables:
   $ X1: chr  "1" "2" "3" "4"
   $ X2: chr  "Apple" "Peach" "Banana" "Graph"
   $ X3: chr  "500" "200" "100" "50"
   $ X4: chr  "5" "2" "4" "7"
  names(df1) <- c('No', 'Fruit', 'Price', 'Qty')
  str(df1)
  'data.frame':	4 obs. of  4 variables:
   $ No   : chr  "1" "2" "3" "4"
   $ Fruit: chr  "Apple" "Peach" "Banana" "Graph"
   $ Price: chr  "500" "200" "100" "50"
   $ Qty  : chr  "5" "2" "4" "7"
  
  
  #as.numeric() 함수는 numeric변환
  df1$Qty <- as.numeric(df1$Qty)
  df1$Price <- as.numeric(df1$Price)
  str(df1)
  'data.frame':	4 obs. of  4 variables:
   $ No   : chr  "1" "2" "3" "4"
   $ Fruit: chr  "Apple" "Peach" "Banana" "Graph"
   $ Price: num  500 200 100 50
   $ Qty  : num  5 2 4 7
  
  #######################
  ```

#### 1.4.9.2. Dataframe 요소 접근

- 변수명$컬럼명 형식으로 요소 접근, 결과는 벡터로 반환.

  ```R
  #컬럼 이름으로 data.frame의 특정 컬럼 데이터 모두 access
  print(df1$Fruit)
  [1] "Apple"  "Peach"  "Banana" "Graph" 
  ```

- 조건에 맞는 요소에 접근 

  subset(데이터프레임 객체, 조건)

  ```R
  #df1 데이터 프레임에서 수량이 5보다 큰 추출 출력
  subset.df1 <- subset(df1, Qty > 5)
  print(subset.df1)
    No Fruit Price Qty
  4  4 Graph    50   7
  str(subset.df1)
  'data.frame':	1 obs. of  4 variables:
   $ No   : chr "4"
   $ Fruit: chr "Graph"
   $ Price: num 50
   $ Qty  : num 7
  
  #문> df1 데이터 프레임에서 가격이 150보다 작은 데이터들 출력
  
  df1[df1$Price < 150, ]
    No  Fruit Price Qty
  3  3 Banana   100   4
  4  4  Graph    50   7
  #문> df2 데이터 프레임에서 과일명이 바나나인 것만 data.frame, 구조로 출력
  df1[df1$Fruit == 'Banana',]
    No  Fruit Price Qty
  3  3 Banana   100   4
  
  df2 <- data.frame(
      x = c(1:5),
      y = seq(2, 10, 2),
      z = c('a', 'b', 'c', 'd', 'e')
  )
  #문> df2 데이터 프레임객체의 x컬럼의 값이 2 이상이고 y컬럼은 6 이하인
  df2[df2$x >=2 & df2$y <= 6,]
    x y z
  2 2 4 b
  3 3 6 c
  
  #문> df2 데이터 프레임객체의 x컬럼의 값이 2 이상 또는 y컬럼은 6 이하인
  df2[df2$x >=2 | df2$y <= 6, ]
    x  y z
  1 1  2 a
  2 2  4 b
  3 3  6 c
  4 4  8 d
  5 5 10 e
  
  
  
  #데이터 프레임에서 특정 컬럼만 추출해서 새로운 형태의 데이터 프레임 생성
  df5 <- subset(df1, select=c(Fruit, Price, Qty))
  str(df5)
  'data.frame':	4 obs. of  3 variables:
   $ Fruit: chr  "Apple" "Peach" "Banana" "Graph"
   $ Price: num  500 200 100 50
   $ Qty  : num  5 2 4 7
  print(df5)
     Fruit Price Qty
  1  Apple   500   5
  2  Peach   200   2
  3 Banana   100   4
  4  Graph    50   7
  
  df6 <- subset(df1, select=-No)
  str(df6)
  'data.frame':	4 obs. of  3 variables:
   $ Fruit: chr  "Apple" "Peach" "Banana" "Graph"
   $ Price: num  500 200 100 50
   $ Qty  : num  5 2 4 7
  print(df6)
     Fruit Price Qty
  1  Apple   500   5
  2  Peach   200   2
  3 Banana   100   4
  4  Graph    50   7
  
  
  
  ####
  emp.data <- data.frame(
     emp_id = c(1:5), 
     emp_name = c("Rick","Dan","Michelle","Ryan","Gary"),
     salary = c(623.3,515.2,611.0,729.0,843.25), 
     
     start_date = as.Date(c("2012-01-01", "2013-09-23", "2014-11-15", "2014-05-11",
        "2015-03-27")),
     stringsAsFactors = FALSE
  )
  print(emp.data) 
  str(emp.data)
  
  #문> emp.data객체에서  3행, 5행의 2열과 4열의 데이터만 추출해서 출력
  emp.data[c(3, 5), c(2, 4)]
    emp_name start_date
  3 Michelle 2014-11-15
  5     Gary 2015-03-27
  
  
  
  #summary()는 데이터프레임 객체의 데이터를 대상으로 최솟값, 최댓값, 중위수, 평균, 사분위수 값을 요약하여 결과로 리턴
  summary(df2)
         x           y      z    
   Min.   :1   Min.   : 2   a:1  
   1st Qu.:2   1st Qu.: 4   b:1  
   Median :3   Median : 6   c:1  
   Mean   :3   Mean   : 6   d:1  
   3rd Qu.:4   3rd Qu.: 8   e:1  
   Max.   :5   Max.   :10  
  apply(df2[, c(1,2)], 2, sum)
   x  y 
  15 30 
  
  
  df4 <- data.frame(
      name = c('apple', 'banana', 'cherry'),
      price = c(300, 200, 100)
  )
  df5 <- data.frame(
      name = c('apple', 'banana', 'berry'),
      qty = c(10, 20, 30)
  )
  
  #두 데이터프레임 객체의 요소를 병합
  result1 <- merge(df4, df5)
  #첫번재 열 데이터 기준으로 일치하는 데이터의 열 결합
  print(result1)
      name price qty
  1  apple   300  10
  2 banana   200  20
  str(result1)
  
  result2 <- merge(df4, df5, all=T)
  #첫 번째 열 데이터 기준으로 모든 데이터의 열 결합
  #Data가 없으면 NA
  print(result2)
      name price qty
  1  apple   300  10
  2 banana   200  20
  3 cherry   100  NA
  4  berry    NA  30
  str(result2)
  
  
  
  ######유용한 함수
  str(mtcars)
  head(mtcars) # 1~6 개만
  head(mtcars, 20)
  tail(mtcars) # last-5 ~ last 행까지 출력해줌
  data(mtcars)
  view(mtcars)
  summary(mtcars)
  summary(emp.data)
  ```

  

```R

```

#### 1.4.9.3. Dtaframe 에 새로운 열 추가

```R
df1$new <- c(10, 20, 30 ,40)
str(df1)
```

#### 1.4.9.4. 

## 1.5. 기타 기본 명령어

### 1.5.1. 작업 디렉토리

#### 1.5.1.1. getwd

```R
getwd()
[1] "C:/workspace_R"
```

#### 1.5.1.2. setwd

```R
setwd("C:/workspace_R")
```

### 1.5.2. 출력

#### 1.5.2.1. print

한번에 한 가지만

```R
print(result)
[1] 3 6 9
```

#### 1.5.2.2. cat

연속된 값 출력

```R
cat(result)
3 6 9
```

### 1.5.3. 산술연산자

- / - 나누기(실수 가능)
- %/% - 정수 나누기
- %% - 나머지 구하기
- ^, ** - 승수 구하기

## 1.6. 데이터 입출력

### 1.6.1 scan

- 키보드로부터 데이터 입력을 받기위해 사용
- 입력할 데이터가 없으면 엔터키만 누르면 종료됨
- 문자열로 입력받으려면 waht=character()옵션 사용

#### 1.6.1.1. 키보드로 숫자 입력받기

```R
num <- scan()
print(num)

sum(num)
```

#### 1.6.1.2. 키보드로 문자 입력받기

```R
name <- scan(what=character())
print(name)



```

#### 1.6.1.3. 공백 delim

```R
input1 <- scan(what="") #korea seoul chongro-gu 입력하기
print(input1)
str(input1) #공백으로 분리해서 단어별로 item으로 저장

```

### 1.6.2. edit

- 데이터 입력을 돕기 위해 표 형식의 데이터 편집기 제공

```R
df <- data.frame()
df <- edit(df) #데이터 편집기
print(df)
  var1   var2 var3 var4 var5
1 학번   이름 국어 영어 수학
2    1 홍길동   80   80   90
3    2 이순신   95   90   95
4    3 강감찬   95   95  100
5    4 유관순   85   85   85
```

### 1.6.3. readline

한 라인의 입력 data를 문자열로 입력 받음

```R
address <- readline()
print(address)
str(address)
```

안내 표시

```R
address <- readline("Input Your Address: ")
```



### 1.6.4. 파일로부터 데이터 입력받기

지원되는 파일 유형:  text, csv, xml, html, json, db, excel, bigdata 저장소

#### 1.6.4.1. 파일 목록 보기

```R
setwd("c:/workspace_R")

print(list.files(recursive=T))
...         
[17] "depth1/depth2/detph2.file.txt"
[18] "depth1/detph1.file.txt"       
...

print(list.files(recursive=T, all.files=T))
...
  [1] ".Rhistory"                    
...
```

#### 1.5.3.2. 파일 읽어오기

##### 1.5.3.2.1. csv file

```R
read.csv(file="경로/파일명" [,sep=","][,header=TRUE])
```

```R
data1 <- read.csv("./data/emp.csv")
print(data1)
   no   name pay
1 101 홍길동 150
2 102 이순신 450
3 103 강감찬 500
4 104 유관순 350
5 105 김유신 400
str(data1)
'data.frame':	5 obs. of  3 variables:
 $ no  : int  101 102 103 104 105
 $ name: Factor w/ 5 levels "강감찬","김유신",..: 5 4 1 3 2
 $ pay : int  150 450 500 350 400

#사원 데이터에서 최대 급여를 출력
max_sal <- max(data1$pay)
print(max_sal)

#최대 급여를 받는 레코드(행)만 출력
person1 <- subset(data1, pay == max(pay))
#data1[data1$pay == max(data1$pay), ] 도 된다.
print(person1)
   no   name pay
3 103 강감찬 500

###################
  id     name salary  startdate       dept
1  1     Rick 623.30 2012-01-01         IT
2  2      Dan 515.20 2013-09-23 Operations
3  3 Michelle 611.00 2014-11-15         IT
4  4     Ryan 729.00 2014-11-05         HR
5  5     Gary 843.25 2015-03-27    Finance
6  6     Nina 578.00  5/21/2013         IT
#문) emp3.csv파일의 데이터를 data.frame객체에 저장한 후에 IT부서에서 굽여가 600이상인 사원추출
emp3 <- read.csv("./data/emp3.csv")
person1 <- emp3[emp3$dept =='IT' & emp3$salary >= 600, ]
  id     name salary  startdate dept
1  1     Rick  623.3 2012-01-01   IT
3  3 Michelle  611.0 2014-11-15   IT

#문) emp3.csv파일의 데이터를 data.frame객체에 저장한 후에 입사날짜가 2014년 7월 01일 이후인 사원 추울
person2 <- emp3[as.Date(emp3$startdate) >= as.Date("2014-07-01"), ]
   id     name salary  startdate    dept
3   3 Michelle 611.00 2014-11-15      IT
4   4     Ryan 729.00 2014-11-05      HR
5   5     Gary 843.25 2015-03-27 Finance
NA NA     <NA>     NA       <NA>    <NA>


#IT 부서 사원만 추출해서 csv 파일에 저장
itperson <- subset(emp3, dept == "IT")
print(itperson)
write.csv(itperson, "./output/itperson.csv", row.names=FALSE)
list.files("./output/")
newdata <- read.csv("./output/itperson.csv")
print(newdata)
  id     name salary  startdate dept
1  1     Rick  623.3 2012-01-01   IT
2  3 Michelle  611.0 2014-11-15   IT
3  6     Nina  578.0  5/21/2013   IT

```

##### 1.5.3.2.2. xlsx file

>read.xlsx() 엑셀 파일로부터 데이터 읽기
>xlsx 패키지가 필요하면 의존하고 있는 rJava패키지를 먼저 로드해야 합니다.
>sheetIndex=1은 선택한 엑셀 파일에서 첫 번째 시트 탭을 지정

```R
install.packages("xlsx")   # xlsx 패키지 설치 
install.packages("rJava")   # rJava 패키지 설치 
#Sys.setenv(JAVA_HOME='C:\\Program Files\\Java\\jre1.8.0_151')

library(rJava)
library(xlsx)

studentex <- read.xlsx(
    file.choose(),
    sheetIndex=1,
    encoding="UTF-8"
)
print(studentex)
  NA. 학번   이름 성적 평가
1   1  101 홍길동   80    B
2   2  102 이순신   95   A+
3   3  103 강감찬   78   C+
4   4  104 유관순   85   B+
5   5  105 김유신   65   D+

itperson <- subset(emp3, dept == "IT")
print(itperson)
write.xlsx(itperson, "./output/itperson.xlsx", sheetName="IT",
           row.names=FALSE, col.names=FALSE)
list.files("./output/")
newdata <- read.xlsx("./output/itperson.xlsx", sheetIndex=1, header=FALSE)
print(newdata)
  X1     Rick X623.3 X2012.01.01 IT
1  3 Michelle    611  2014-11-15 IT
2  6     Nina    578   5/21/2013 IT

```

##### 1.5.3.2.3. txt file

```
readLines("경로")
read.table("경로")
```

```R
# 텍스트 파일 읽기, 라인 단위를 문자열로 로딩, 라인단위로 저장되는 벡터 객체로 생성함
file1 <- readLines("./data/fruits.txt")
print(file1)
[1] "no  name  price   qty" "1   apple   500     5"
[3] "2   banana  200     2" "3   peach   200     7"
[5] "4   berry    50     9"
str(file1)
 chr [1:5] "no  name  price   qty" "1   apple   500     5" ...

#텍스트 파일의 내용을 읽어서 data.frame객체로 생성함
fruits1 <- read.table("./data/fruits.txt" ) 
print(fruits1)
  V1     V2    V3  V4
1 no   name price qty
2  1  apple   500   5
3  2 banana   200   2
4  3  peach   200   7
5  4  berry    50   9
str(fruits1)
'data.frame':	5 obs. of  4 variables:
 $ V1: Factor w/ 5 levels "1","2","3","4",..: 5 1 2 3 4
 $ V2: Factor w/ 5 levels "apple","banana",..: 4 1 2 5 3
 $ V3: Factor w/ 4 levels "200","50","500",..: 4 3 1 1 2
 $ V4: Factor w/ 5 levels "2","5","7","9",..: 5 2 1 3 4

# hearer 포함
fruits1 <- read.table("./data/fruits.txt", header=T)
print(fruits1)
  no   name price qty
1  1  apple   500   5
2  2 banana   200   2
3  3  peach   200   7
4  4  berry    50   9
str(fruits1) 
'data.frame':	4 obs. of  4 variables:
 $ no   : int  1 2 3 4
 $ name : Factor w/ 4 levels "apple","banana",..: 1 2 4 3
 $ price: int  500 200 200 50
 $ qty  : int  5 2 7 9

# 문자열 그대로 읽어오기
fruits1 <- read.table("./data/fruits.txt", header=T, stringsAsFactor=FALSE)
print(fruits1)
  no   name price qty
1  1  apple   500   5
2  2 banana   200   2
3  3  peach   200   7
4  4  berry    50   9
str(fruits1)
'data.frame':	4 obs. of  4 variables:
 $ no   : int  1 2 3 4
 $ name : chr  "apple" "banana" "peach" "berry"
 $ price: int  500 200 200 50
 $ qty  : int  5 2 7 9


# 를 제외한 레코드 2개 skip(제외)하고, 2개의 record만 읽어옴
fruits2 <- read.table("./data/fruits.txt", header=T, skip=2, nrows=2)
print(fruit2)
  X2 banana X200 X2.1
1  3  peach  200    7
2  4  berry   50    9


#벡터의 데이터를 텍스트 파일로 저장
cat(
    "My Sales", 
    file1, 
    file="./output/mySales.txt", sep="\n", append=T
)

#파일로 저장하는 다른 방법
sink("패스")
cat("내용1")
cat("내용2")
sink() #저장 완료됨





```





# 나중에 분류

## 나중에 분류 1

```R
install.packages("stringr")

str_length()
str_c(), # str concatenate
str_join()
str_sub(), str_split()
str_replace()
str_extract() #정규표현식을 사용하여 문자열 추출
str_extract_all() #정규표현식을 사용하여 문자열 모두 추출
str_locate() #특정 문자열 패턴의 첫 번째 위치 찾기
str_locate_all()
...

fruits <- c('apple', 'banana', 'pineapple', 'berry', 'APPLE')
#패턴을 포함한 요소에서 패턴 출현 횟수 리턴
print(str_count(fruits, "a"))
[1] 1 3 1 0 0

#문자열을 결합하는 기본 R 함수
rs1 <- paste('hello', '~R')
print(rs1)
[1] "hello ~R"

print(str_c('hello', '~R'))
print(str_c(fruits, " name is " , fruits))
print(str_c(fruits, collapse=" "))
print(str_c(fruits, collapse="-"))

print(str_detect(fruits, 'A')) #dataset 객체의 요소별로 'A'포함 여부를
[1] FALSE FALSE FALSE FALSE  TRUE
print(str_detect(fruits, '^a')) #정규표현식의 형식문자^는 시작을 의미
[1]  TRUE FALSE FALSE FALSE FALSE
print(str_detect(fruits, 'a$')) # $는 끝을 의미
[1] FALSE  TRUE FALSE FALSE FALSE
print(str_detect(fruits, '^[aA]'))
[1]  TRUE FALSE FALSE FALSE  TRUE
print(str_detect(fruits, '[^a]'))  #[]안의 ^는 not을 의미
[1] TRUE TRUE TRUE TRUE TRUE

print(str_sub(fruits, start=1, end=3)) #부분추출
[1] "app" "ban" "pin" "ber" "APP"
print(str_sub(fruits, start=6, end=9))
[1] ""     "a"    "pple" 
print(str_sub(fruits, start=-5))
[1] "apple" "anana" "apple" "berry" "APPLE"
   
             
str_length("  apple   banana  ")
str_length(str_trim("   apple   banana   ")) #앞 뒤 공백 제거 trim()

#dataset 객체의 요소 문자열의 길이를 벡터로 리턴
print(str_length(fruits))
[1] 5 6 9 5 5
print(str_dup(fruits, 3))
[1] "appleappleapple"             "bananabananabanana"         
[3] "pineapplepineapplepineapple" "berryberryberry"            
[5] "APPLEAPPLEAPPLE"

#리스트로 반환하네?
str_extract("홍길동35이순신45유관순25", "[1-9]{2}")
[1] "35"
str_extract_all("홍길동35이순신45유관순25", "[1-9]{2}")
[[1]]
[1] "35" "45" "25"
str_extract_all("honggil305koreaseoul1004you25"), 
str_extract_all("honggil305koreaseoul1004you25"), 

str1 <- "korea123456-1234567seoul"
#문) str1 객채에 저장된 문자열로부터 주민번호만 추출
str_extract(str1, "[0-9]{6}-[0-9]{7}")
[1] "123456-1234567"
str_extract(str1, "[0-9]{6}-[1234]{1}[0-9]{6}")
[1] "123456-1234567"


str2 <- "홍길동1357,이순신,유관순1012"
#문) str2 객체에 저장된 문자열로부터 7글자 이상의 단어만 추출
str_extract_all(str2, "\\w{7,}")
[[1]]
[1] "홍길동1357" "유관순1012"

#str_to_upper()
#str_to_lower()
```





## 나중에 분류 2













