<h1>R</h1>



![Statistics](assets/title.png)

> - 객체지향 프로그래밍 언어
>   데이터, 함수, 차트 등 모든 데이터는 객체 형태로 관리된다.
>
> - 통계 분석과 data의 시각화를 지원하는 소프트웨어 환경
>
> - 컴퓨터 언어이자 다양한 패키지의 집합
>
> - data의 시각화를 위한 다양한 그래픽 도구를 제공



# 1. R

## 1.1  설치

### 1.1.1 R 설치

[r-project.org](https://www.r-project.org)

- mirror site 설정
- download
- 작동 확인
  - help()
  - demo()
  - q()

### 1.1.2 R Studio 설치

[rstudio.com](https://www.rstudio.com/products/rstudio/download/)

## 1.2. 기본 동작 확인

- R 패키지 확인

  ```R
  dim(available.packages())
  
  available.packages()
  ```

- R session

  사용자가 R 프로그램을 시작한 후 R콘솔 시작 ~종료 까지의 모든 정보를 담고있는 객체이다.

  ```R
  sessioninfo()
  ```

- 설치된 R 패키지 목록 확인

  ```R
  installed.packages()
  ```

- R 패키지 설치

  ```R
  install.packages({"패키지명"})
  ```

- R 패키지 삭제

  ```R
  remove.packasges({"패키지명"})
  ```

- 패키지 load

  - library()

    ```R
    library(stringr)
    ```

  - require()

    ```R
    require(stringr)
    ```

- 메모리에 load 된 패키지 검색 search

  ```R
  serach()
  [1] ".GlobalEnv"        "package:stringr"  
  [3] "tools:rstudio"     "package:stats"    
  [5] "package:graphics"  "package:grDevices"
  [7] "package:utils"     "package:datasets" 
  [9] "package:methods"   "Autoloads"        
  [11] "package:base
  ```

- 기본 데이터 셋 보기

  R에서 제공해주는 기본 데이터 셋

  ```R
  data()
  ```

- 히스토그램

  - 빈도수 히스토그램

    ```R
    hist(Nile)
    ```

  - 밀도 기준 히스토그램

    ```R
    hist(Nile, freq=F)
    ```

  - 분포곡선 그리기

    ```R
    lines(density(Nile))
    ```

  - plots 영역에 표시할 그래프 갯수 설정

    ```R
    par(mfrow=c(1,1))
    ```

  - 파일 출력 경로

    ```R
    pdf("c:/workspace_R/sample.pdf")
    
    #정규분포를 따르는 난수 20개 생성해서 히스토그램 생성
    hist(rnorm(20)) 
    
    #출력 파일 닫기
    dev.off()
    ```

- R에서 제공하는 기본 함수 사용 예제 보기

  ```R
  exmaple(seq)
  ```

- R에서 제공하는 함수의 파라미터 형식 보기

  ```R
  args(max)
  ```

- help

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
age <- 30
# age 변수는 하나의 값을 저장하고 있는 벡터 타입

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

#### 1.4.1.5. 문자열

```R
a <- "hello"
print(a)

a <- 'hello'
print(a)
```

#### 1.4.1.6. 진리값

```R
TRUE & TRUE
TRUE & FALSE

c(TRUE, TRUE) & c(TRUE, FALSE)
[1]  TRUE FALSE

#short circuit operator ?
c(TRUE, TRUE) && c(TRUE, FALSE)
[1] TRUE
```

#### 1.4.1.7. 날짜와 시간

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
  as.Date('04-07-2017') #오류 날짜가 이상하게 들어감
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
  date<-now() #현재 날짜와 시간 넣기
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

### 1.4.3. 자료형 변환

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

### 1.4.4. Factor 형

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
ordered("a", c("a", "b", "c")))
```

#### 1.4.4.2. 명목형 - Norminal

명목형 데이터로 `plot` 그려보기

```R
gender <- c("man", "woman", "woman", "man", "man")
plot(gender) #error

class(gender)
[1] "character"
mode(gender)
[1] "character"

ngender <- as.factor(gender)
class(ngender)
[1] "factor"
mode(ngender)
[1] "numeric"

table(ngender) # 빈도수 반환
plot(ngender)

is.factor(ngender)
[1] TRUE

ngender #Levels 속성에서 범주를 확인 (알파벳 순서?)
[1] man   woman woman man   man  
Levels: man woman

args(factor) #factor()함수의 매개변수 확인
[1] man   woman woman man   man  
Levels: man woman
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
jpeg("both.jpg", width = 350, height = 350)

par(mfrow=c(1,2))
plot(ngender)
plot(ogender)

#저장 완료
dev.off()
```

![img](assets/both.jpg)

### 1.4.5. Vector 형

>- 동일한 형태의 데이터를 모아서 함께 저장.
>- 1차원 배열과 비슷한 개념, 특정 항목의 요소를 사용하려면 벡터명[색인] 벡터 자체를 연산 할 수 있다.
>- 각 벡터의 요소에 names() 함수를 사용해서 이름 지정할 수 있다.
>- seq(), rep() 함수를 사용해서 벡터에 연속적인 데이터 할당 할 수 있다.
>- length() 함수는 벡터의 길이를 리턴
>- %in%는 벡터에 특정 문자의 포함 여부를 리턴합니다

#### 1.4.5.1. 접근

- 요소의 접근은 변수[index]로 접근한다. 
- index는 1부터 시작한다.

```R
a <- c(1:20)
a[3:10]
[1]  3  4  5  6  7  8  9 10

a[c(3, 10)]
[1]  3 10

a[-c(2:18)] # 벡터의 첨자에 -를 지정하면 해당 위치의 원소는 제외
[1]  1 19 20
```

#### 1.4.5.2. 벡터 생성 힘수

- c()

  ```R
  c(1:20)
  1:20
  c(1,1,2,3,3,3,4,5,5,5,5)
  ```

- seq()

  ```R
  seq(1, 20)
  seq(1, 20, 2) #순차적으로 값을 증감시켜서 벡터 자료 구조 생성
  ```

- rep()

  ```R
  rep(1:3, 3)
  [1] 1 2 3 1 2 3 1 2 3
  
  rep(1:3, each=3)
  [1] 1 1 1 2 2 2 3 3 3
  ```

#### 1.4.5.3. 벡터 자료 처리 함수

- union()

  ```R
  a <- c(1:5)
  b <- a + 1
  c <- a * 2
  
  d <- rep(1:3, 3)
  union(a, d)
  [1] 1 2 3 4 5
  ```

- setdiff()

  ```R
  setdiff(a, d)
  [1] 4 5
  ```

- intersect()

  ```R
  intersect(a, d)
  [1] 1 2 3
  ```

#### 1.4.5.4. 자동 형 변환

벡터는 같은 자료만 담을 수 있기때문에 큰 타입으로 자동 형변환 된다.

```R
f <- c(33, -5, "4", 5:9) 
f
[1] "33" "-5" "4"  "5"  "6"  "7"  "8"  "9"  #문자열로 변환 됨
class(f)
[1] "character"
mode(f)
[1] "character"
```

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











