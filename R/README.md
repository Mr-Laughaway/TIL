<h1>R</h1>



![Statistics](http://zoonek2.free.fr/UNIX/48_R/title.png)



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



## 1.3. 변수

### 1.3.1. 변수 선언

- 첫 문자는 영문자로 시작

- 두 번쨰 둠나부터는 숫자, _, . 사용 가능

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

#### 1.4.1.3. NA - 결측치

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

```R
age <- NULL
class(a)
[1] "NULL"
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

#### 1.4.3.1. as

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

- ex1

  ```R
  x <- c("1", "2", "3")
  result <- x * 3
  result <- as.numeric(x) * 3
  print(result)
  result <- as.integer(x) * 3
  print(result)
  ```

- ex2

  ```R
  z <- 5.3-3i #복소수 자료형 생성
  class(z)
  [1] "complex"
  
  Re(z)	#실수부만 반환
  [1] 5.3
  Im(z)	#허수부만 반환
  [1] -3
  ```

  















