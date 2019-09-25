# 4. 데이터 분석 프로세스

## 4.1. 기본 용어

### 4.1.1. 기초통계(descriptive statistics)

데이터에 대한 통계적 자료분석에 앞서 데이터의 대략적인 통계적 수치를 계산해 봄으로써 데이터에 대한 대략적인 이해와 앞으로 진행될 분석에 대한 insight 얻기 위한 분석방법

### 4.1.2. 변수(variable)

수집된 자료에서 관심의 대상이 되는 특성이나 관측된 결과로서 주어지는 특성

### 4.1.3. 변수의 유형

- 질적변수(Qualitative Variable) 또는 범주형 변수(Categorial Variable)

  - 특성을 범주로 구분해서 나타내는 변수
  - 성별구분(남자:1 , 여자 :2) ,  소득수준 (상, 중, 하)

- 양적변수(Quantative Variable)

  - 연속형 변수(continuous Variable)
  - 이산형 변수(Discrete Variable)
  - 관심대상이 되는 특성을 수치로 나타내는 변수
  - 몸무게, 키, 환자의 나이

- 독립변수

  다른 변수에 영향을 주는 변수 (원인변수, 설명변수, 예측변수)

- 종속변수

  - 다른 변수에 영향을 받는 변수 (결과변수, 피설명변수, 피예측변수)
  - '흡연은 폐암을 유발한다'에서  흡연은 독립변수, 폐암은 종속변수

- 자료의 형태에 따른 분류

  | 구분          | 설명                                                         |
  | ------------- | ------------------------------------------------------------ |
  | 명목척도 자료 | 단지 구분하기 위한 부호로 표현된 자료(성별, 혈액형, 주거형태, 학과) |
  | 서열척도 자료 | 관측되는 개체들에 순서를 갖는 자료 (학년, 선호도, 신용등급)  |
  | 구간척도 자료 | 관측 값의 순서와 순서사이의   간경이   의미가 있는 자료 (성적,   온도 등) |
  | 비율척도 자료 | 두 간격(차이)에   대한 비율이 의미를 갖는 자료(연령,   시간,   거리) |

## 4.2. 분석 절차와 통계지식

### 4.2.1. 빅데이터 분석

> 기존 데이터 규모에서 불가능했던 데이터 집합체를 대상으로 다양한 분석기법을 적용하여 새로운 통찰이나 새로운 가치를 발견하고 예측하는 일련의 과정.
>
> 기존의 사실에 대한 객관적인 근거를 제시하고, 다변화된 현대 사회를 정확하게 예측 및 대응하며, 정치, 사회, 경제, 문화, 과학, 기술 등 전 영역에 거쳐서 인류에게 가치 있는 정보를 제공한다.











```R
# 표본오차 구하기
20세 이상 유권자 1,500명 대상으로 A 후보 대선 출마에 대한 찬성과 반대를 조사하는 설문조사를 시행하였다. 설문조사 결과 95% 신뢰수준에서 찬성이 55%, 반대가 45%가 나왔다. 이때 표본오차는?

Z = 1.96
N = 1500
찬성률 p = 55% = 0.55
반대율 1-p = 45% = 0.45

0.025176656
0.025176656

```

- aslkdfjals;kdjf



## 4.3. Quiz

```R
Q1> 다음 중 가설이 갖추어야 할 요건이 아닌 것은? 4
① 가설은 경험적으로 검증할 수 있어야 한다.
② 가설은 계량적인 형태를 취하든가 계량화 할 수 있어야 한다.
③ 가설의 표현은 간단명료해야 한다.
④ 가설은 동일 분야의 다른 가설과 연관을 가져서는 안된다.

Q2> 다음 중 과학적 연구절차에 기초한 올바른 이론 구축 과정은? 1
① 연구문제 - 개념화 - 가설검정 - 자료수집- 자료분석
② 개념화-연구문제-가설검정- 자료수집- 자료분석
③ 연구문제 -가설검정 -개념화 - 자료수집- 자료분석
④ 개념화 -가설검정 -연구문제 -자료수집- 자료분석

Q3> 가설 검정에 관한 설명으로 옳은 것은? 1
① 검정 통계량은 확률변수이다.
② 대립가설은 사전에 알고 있는 값이다.
③ 유의수준 α를 작게 할수록 좋은 검정법이다.
④ 가설이 틀렸을 때 틀렸다고 판정할 확률을 유의수준이라 한다. 

Q4> '남녀 월급액수에는 차이가 있다'라는 주장을 검증하기 위하여 사회조사를 시행하였다.
조사결과 남자집단의 평균액수는 μ1, 여자집단의 μ2라고 한다면, 귀무가설은? 2
①  μ1 > μ2
②  μ1 = μ2
③  μ1 < μ2
④  μ1 ≠ μ2

Q5> 가설구성 시 고려할 사항이 아닌 것은? 4
① 경험적 검증이 가능하여야 한다.
② 다른 가설 및 이론과의 연관성을 가져야 한다.
③ 두 개 이상의 변수 간의 관계로 서술되어야 한다.
④ 한 가설에 독립변수나 종속변수 수가 많아지도록 한다.

Q6> 가설의 특성이라고 할 수 없는 것은? 4
① 문제를 해결해 줄 수 있어야 한다. 
② 변수로 구성되며, 그들 간의 관계를 나타내고 있어야 하낟.
③ 검증될 수 있어야 한다.
④ 매개변수가 있어야 한다.

Q7> 유의확률(p-value)의 설명이 틀린 것은? 2
①  검정 통계량이 실제 관측된 값보다 대립가설을 지지하는 방항으로 더욱 치우칠 확률로서 귀무가설 하에서 계산된 값이다
② 주어진 데이터와는 직접적으로 관계가 없다.
③ 유의확률이 낮을 수록 반증이 강한 것을 뜻한다.
④ 귀무가설에 대한 반증의 강도에 대하여 기준값을 미리 정해놓고 p-value값을 그 기준값과 비교한다.

Q8> 다음 내용에 대한 가설형태로 옳은 것은? 2
기존의 진통제는 진통효과가 지속되는 시간이 평균 30분이고, 표준편차는 5분이라고 한다. 
새로운 진통제를 개발하였는데, 개발팀은 이 진통제의 진통 효과가 30분 이상이라고 주장한다.
① H0 : μ<30, H1: μ=30
② H0 : μ=30, H1: μ>30
③ H0 : μ>30, H1: μ=30
④ H0 : μ=30, H1: μ≠30

Q9> 모집단의 회귀계수β에 대한 표본 회귀계수가 0.23일 경우, 독립변수가 종속변수에 의미 있는
영향을 미치는지를 알기 위해 모집단 회귀계수에 대한 가설 검정을 하려고 할 떄 귀무가설과 대립가설은? 1
① H0 : β= 0, H1: β≠ 0
② H0 : β≠ 0, H1: β= 0
③ H0 : β= 0.23, H1: β≠ 0.23
④ H0 : β≠ 0.23, H1: β= 0.23

11> 통계적 검증 오류중 제 1종 오류에 해당하는 것은? 1
① 귀무가설이 참임에도 불구하고 이를 기각
② 귀무가설이 참이므로 이를 채택
③ 귀무가설이 거짓이므로 채택
④ 귀무가설이 거짓임에도 이를 기각

12> 통계적 가설의 기각 여부를 판정하는 가설 검정에 대한 설명으로 맞는 것은? 4
① 표본으로부터 확실한 근거에 의하여 입증하고자 하는 가설을 귀무가설이라 한다.
② 유의수준은 제2종 오류를 범할 확률의 최대허용한계이다.
③ 대립가설을 채택하게 하는 검정 통계량의 영역을 채택역이라 한다.
④ 대립가설이 옳은데도 귀무가설을 채택함으로써 범하게 되는 오류를 제2종 오류라 한다.

13> 통계적 가설 검정을 위한 검정 통계값에 대한 유의확률(p-value)이 주어졌을 때, 귀무가설을 유의수준 α 로 기각할 수 있는 경우는? 2
① p-value >  α
② p-value <  α
③ p-value =  α
④ p-value >  2α

14> 정규분포의 특성에 대한 설명으로 틀린 것은? 2
① 평균, 중위수, 최빈수가 모두 일치한다.
② X=μ에 관해 종 모양의 좌우대칭이고, 이 점에서 확률 밀도함수가 최대값 1/0을 갖는다.
③ 분포의 기울어진 방향과 정도를 나타내는 지표는 왜도이다.
④ 분포의 봉우리가 얼마나 뾰족한가를 나타내는 지표 첨도이다.

15> 보험가입액의 모평균이 1억 원이라고 볼 수 있는가를 검정하고자 한다. 이에 대한 t-검정 통계량이 1.201이고, 유의확률이 0.239이었다. 
① '유의확률 > 유의수준'이므로 모평균이 1억 원이라는 가설을 기각하지 못한다.
② '유의확률 > 유의수준'이므로 모평균이 1억 원이라는 가설을 기각한다.
③ '검정 통계량 1.201 >유의수준'이므로 모평균이 1억 원이라는 가설을 기각하지 못한다.
④ '검정 통계량 1.201 >유의수준'이므로 모평균이 1억 원이라는 가설을 기각한다.

16> '표본의 크기가 충분히 크다면, 표본의 평규은 0에 가까워진다.'는 이론은?
중심극한정리(The central limit theorem)

Q17> 표준화 변환을 하면 변환된 자료의 평균과 표준편차의 값은? 1
① 평균 = 0, 표준편차 = 1
② 평균 = 1, 표준편차 = 1
③ 평균 = 1, 표준편차 = 0
④ 평균 = 0, 표준편차 = 0

Q18> 신뢰수준에 대한 설명으로 틀린 것은? 4
① 신뢰구간에 확신하는 정도를 의미한다.
② 신뢰수준은 연구자가 결정한다.
③ 신뢰수준이 95%라는 의미는 표본오차가 ±5%라는 의미이다.
④ 신뢰수준 높이면 신뢰구간은 넓어진다. -> (좁아진다)

Q19> A회사에서 만든 제품의 수명의 표준편차는 50이라고 한다. 새로운 공정
에 의해 제품 100개를 생산하여 실험한 결과 수명의 평균이 280이었다.
모 평균에 대한 95% 오차 한계는? 1
①  9.8
②  12.9
③   98
④  129

Q20> 크기가 n표본으로 신뢰수준 95%를 갖도록 모평균을 추정하였더니 
신뢰구간의 길이가 10이었다. 동일한 조건 아래 표본의 크기만을 1/4로 줄이면
신뢰구간의 길이는? 3
①  1/4로 줄어든다
②  1/2로 줄어든다
③  2배로 늘어난다.
④  4배로 늘어난다.

Q21> 어느 고등학교 1학년 1,000명의 성적분포가 평균 80점, 표준편차 20점인 정규분포로 나타났다.
이경우에 60점 이상 100점 이하의 점수를 얻은 학생은 대략 몇 명인가? 2
①  350
②  680
③  790
④  850
```

## 4.4. 기술 통계 분석

- 기술통계량

  ```R
  data <- read.csv("./data/descriptive.csv", header=T)
  
  # resident - 거주지역
  # gender - 성별(명목 1, 2)
  # age - 연령
  # level - 학력수준(서열 1, 2, 3)
  # cost - 생활비(비율)
  # type - 학교유형(명목 1, 2)
  # survey - 만족도(등간척도 5점)
  # pass - 합격여부(명목 1, 2)
  
  dim(data)
  [1] 300   8
  
  length(data) # 변수 개수(열)
  length(data$servey) # 관측치 개수(행)
  
  fivenum(data) # minimum, lower-hinge, median, upper-hinge, maximum
  summary(data) # 컬럼 단위로 최솟값, 최댓값, 평균, 1and3분위수, 결측치, 중앙값(중위수) 등
  
  
  # 명목척도의 기술 통계량(결측치제거 > 빈도수 > 비율 > 백분율)
  length(data$gender) # 관측치 확인
  summary(dat$gender) # 명목척도는 최솟값, 최댓값, 평균 등 의미가 없음
  # 각 성별의 빈도수
  table(data$gender)
  # 결측치 제거 후 시각화
  data <- subset(data, data$gender == 1 | data$gender == 2)
  x <- table(data$gender) # 빈도수에 따른 분할표
  barplot(x)
  # 비율 계산
  y <- prop.table(x)
  # 백분율로 변환
  round(y*100, 2)
  
  
  # 서열척도의 기술 통계량
  summary(data$level) # 서열척도도 최솟값, 최댓값, 평균 등 의미없음 -> ???
  x1 <- table(data$level)
  barplot(x1)
  y1 <- prop.table(x1)
  round(y1 * 100, 2)
  barplot(y1)
  
  
  # 등간척도의 기술 통계량
  survey <- data$survey
  summary(survey) # 등간척도에서 평균 통계량은 어느 정도 의미가 있다.
     Min. 1st Qu.  Median    Mean 3rd Qu.    Max.    NAs 
     1.00    2.00    3.00    2.61    3.00    5.00     113
  x2 <- table(survey) # 빈도수는 의미 있음
  hist(survey) #등간척도 시각화(히스토그램)
  pie(x2) #빈도수를 이용한 시각화 - 파이 차트
  
  
  # 비율척도의 기술 통계량
  length(data$cost)
  summary(data$cost) # 요약 통계 - 의미 있음
  plot(data$cost)	# 이상치 발견
  boxplot(data$cost) # 이상치 발견
  data2 <- subset(data, data$cost >= 2 & data$cost <= 10)
  x3 <- data2$cost
  mean(x3); median(x3) # 평균이 극단치에 영향을 받는 경우 중위수로 대체하는 것이 더 효과적
  # 예
  A반 성적 = 75, 80, 80, 80, 85 	평균:80 중위수:80
  B반 성적 = 75, 75, 75, 75, 100 평균:80 중위수:75
  # 사분위값
  quantile(x3, 1/4) # 1사분위 수
  quantile(x3, 2/4) # 중앙값과 동일
  quantile(x3, 3/4) #
  quantile(x3, 4/4)
  # 최빈수 - 빈도수가 가장 많은 변량
  x3.t <- table(x3)
  x.max <- sort(x.t, decreasing=T)[1]
  as.numeric(names(x.max)[1])
  # 다른방법
  x3.m <- rbind(x3.t)
  x3.df <- as.data.frame3.m)
  x3.df
  which(x3.df[1,]==18) # 특정 값을 지닌 인덱스를 알려줌
  [1] 25
  names(x3.df[25])
  
  
  # 산포도는 분산과 표준편차를 통계량으로 사용
  
  
  # 비율척도의 빈도 분석 : 비율척도를 범주화(리코딩)
  table(data$cost)
  hist(data$cost)
  plot(data$cost)
  
  
  # 연속형(비율척도) 변수 범주화
  data$cost2[data$cost >=1 & data$cost<=3] <- 1
  data$cost2[data$cost >=4 & data$cost<=6] <- 2
  data$cost2[data$cost >=7 ] <- 3
  table(data$cost2)
  barplot(table(data$cost2))
  pie(table(data$cost2))
  
  
  # 정규분포를 갖는 지 확인 - 왜도, 첨도
  install.packages("moments")
  library(moments)
  cost <- data$cost[!is.na(data$cost)]
  skewness(cost) # 왜도 반환 0보다 크면, 0보다 작으면...
  [1] 2.486237
  hist(cost)
  hist(cost, freq=F) # 히스토그램의 계급을 확률 밀도로 표현
  lines(density(cost), col="blue") #cost의 밀도 분포 곡선
  x <- seq(0, 8, 0.1) # 0~8 범위의 0.1씩 증가하는 데이터 벡터 생성
  curve(dnorm(x, mean(cost), sd(cost)), col='red', add=T)
  
  # attach() /detach()
  #리스트객체$key, dataframe객체$컬럼변수
  #attach()함수는 dataframe객체$컬럼변수로부터  dataframe객체 데이터셋 이름을 생략하고 컬럼변수만으로 관측치에 사용가능
  #detach()함수는  dataframe객체$컬럼변수로 관측치에 접근
  data <- read.csv("./data/descriptive.csv", header=T)
  # 원래 접근 방식
  length(data$survey)
  summary(data$cost)
  # attach 접근 방식
  attach(data)
  length(survey)
  summary(cost)
  # detach
  detach(data)
  length(survey) #오류
  summary(cost) #오류
  
  
  # Hmisc 패키지
  install.packages("Hmisc")
  library(Hmisc)
  describe(data)
  
  # prettyR 패키지
  install.packages("prettyR")
  library(prettyR)
  freq(data)
  
  # Quiz> 거주지역 변수 리코딩 후 비율 계산
  # 1은 특별시, 2~4는 광역시, 5는 시군구
  # 빈도수, 비율, 백분율
  resident <- data$resident[!is.na(data$resident)]
  resident[resident == 1] <- "특별시"
  resident[2 <= resident & resident <= 4 ] <- "광역시"
  resident[resident == 5] <- "시군구"
  freq(resident)
  
  # Quiz> 성별 변수 리코딩 후 비율 계산
  # 범주화 : 1은 남자, 2는 여자
  # 빈도수, 비율, 백분율
  gender <- data$gender[data$gender == 1 | data$gender == 2]
  gender[gender == 1] <- "남자"
  gender[gender == 2] <- "여자"
  freq(gender)
  
  # Quiz> 나이변수 리코딩 후 비율 계산
  # 범주화 : <= 45 중년층, 46~69 장년층, >=60 노년층
  # 빈도수, 비율, 백분율
  age <- data$age[!is.na(data$age)]
  age[age <= 45] <- 1 #문자열로 바꾸니 자동형변환 때문에 귀찮은 일이 생겨서 숫자로
  age[46 <= age & age <= 69] <- 2
  age[age >= 70] <- 3
  
  
  ```

- 표본추출

  ```R
  # 샘플링
  # 80대 20
  # 과적합 (분리하지 않고...)
  
  # 단순 임의 추출
  sample(1:10, 5, replace = T) #복원 추출
  sample(1:10, 5) #비복원 추출
  # 가중치 사용시 prob 파라미터 사용
  
  
  # 층화 임의 추출
  sampling::ska.....
  install.packages("sampling")
  library(sampling)
  head(iris)
  result <- strata(c("Species"), size=c(3, 3, 3), method="srswor", data=iris)
  # srswor: 비복원 단순 임의 추출
  # srswr : 복원 단순 임의 추출
  # poisson : 포아송 추출
  # systematic : 계통 추출
  
  # 계통 추출
  install.packages("doBy")
  library(doBy)
  x <- data.frame(x=1:10)
      x
  1   1
  2   2
  3   3
  4   4
  5   5
  6   6
  7   7
  8   8
  9   9
  10 10
  sampleBy(~1, frac=0.3, data=x, systematic=T)
    [,1] [,2] [,3]
  1    1    4    7
  
  
  # 분할표Contingency Table
  table(c("a", "b", "b", "b", "c", "c", "d"))
  d <- data.frame(x=c("1", "2", "2", "1"),  y=c("A", "B", "A", "B"),   num=c(3, 5, 8, 7))
    x y num
  1 1 A   3
  2 2 B   5
  3 2 A   8
  4 1 B   7
  xtabs(num ~ x + y, data=d)
     y
  x   A B
    1 3 7
    2 8 5
  d2 <- data.frame(x=c("A", "A", "A", "B", "B"))
  xtabs(~ x, d2)
  x
  A B 
  3 2 
  # margin.table 주변?
  xt <- xtabs(num ~ x + y, data = d)
     y
  x   A B
    1 3 7
    2 8 5
  margin.table(xt, 1) #행
  x
   1  2 
  10 13 
  margin.table(xt, 2) #열
  y
   A  B 
  11 12 
  margin.table(xt) # 전체
  [1] 23
  # prop.table : 분할표에 대해서 각각의 비율을 반환해 주는 함수
  prop.table(xt, 1)
     y
  x           A         B
    1 0.3000000 0.7000000
    2 0.6153846 0.3846154
  prop.table(xt, 2)  #  3/11, 7/12
                        8/11, 5/12
  
  prop.table(xt)     #  3/23, 7/23
                        8/23, 5/23
  
  
  ```

- 교차 분석

  ```R
  #교차분석을 위한 변수 모델링
  data <- read.csv("./data/cleanDescriptive.csv", header=TRUE)
  data
  str(data)
  
  #부모의 학력 수준이 자녀의 대학 진학 여부와 관련이 있는지를 분석하기
  # 학력수준 변수는 독립변수
  # 대학진학 여부 변수는 종속변수
  x <- data$level2
  y <- data$pass2
  result <- data.frame(Level=x, Pass=y)
  dim(result)
  
  #교차분석을 위한
  table(result)
            Pass
  Level      실패 합격
    고졸       40   49
    대졸       27   55
    대학원졸   23   31
  
  install.packages("gmodels")
  library(gmodels)
  library(ggplot2)
  CrossTable(result$Level, result$Pass)
     Cell Contents
  |-------------------------|
  |                       N |
  | Chi-square contribution |
  |           N / Row Total |
  |           N / Col Total |
  |         N / Table Total |
  |-------------------------|
  
   
  Total Observations in Table:  225 
  
   
               | result$Pass 
  result$Level |      실패 |      합격 | Row Total | 
  -------------|-----------|-----------|-----------|
          고졸 |        40 |        49 |        89 |  # 관측치
               |     0.544 |     0.363 |           |  # 카이제곱
               |     0.449 |     0.551 |     0.396 | # 행비율
               |     0.444 |     0.363 |           | # 열비율
               |     0.178 |     0.218 |           | # 전체비율
  -------------|-----------|-----------|-----------|
          대졸 |        27 |        55 |        82 | 
               |     1.026 |     0.684 |           | 
               |     0.329 |     0.671 |     0.364 | 
               |     0.300 |     0.407 |           | 
               |     0.120 |     0.244 |           | 
  -------------|-----------|-----------|-----------|
      대학원졸 |        23 |        31 |        54 | 
               |     0.091 |     0.060 |           | 
               |     0.426 |     0.574 |     0.240 | 
               |     0.256 |     0.230 |           | 
               |     0.102 |     0.138 |           | 
  -------------|-----------|-----------|-----------|
  Column Total |        90 |       135 |       225 | 
               |     0.400 |     0.600 |           | 
  -------------|-----------|-----------|-----------|
  
  # 5만4천개의 다이아몬드 속성 데이터 셋
  # price, carat, cut(커팅품질), color, clarity(선명도:명목)
  CrossTable(x=diamonds$color, y=diamonds$cut)
  
  
  ## 이원 카이제곱 검정(독립성 검증)
  # 부모의 학력수준과 자녀의 진학여부와 관련성이 있는지 독립성 검정
  연구가설(H0): 부모의 학력수준과 자녀의 진학여부는 관련성 없다.
  대립가슬(H1): 부모의 학력수준과 자녀의 진학여부는 관련성이 있다.
  
  # 부모의 학력 수준이 자녀의 대학진학 여부와 관련이 있는지를 분석하기 위
  x <- data$level2
  y <- data$pass2
  result <- data.frame(Level=x, Pass=y)
  CrossTable(result$Level, result$Pass)
  
  chisq.test(x=result$Level, y=result$Pass) #이부분이 중요!!!!!!!!
  
  	Pearson''s Chi-squared test
  
  data:  result$Level and result$Pass
  X-squared = 2.767, df = 2, p-value = 0.2507
  
  해석:
  유의확률(p-value) 0.2507 이 유의수준(α= 0.05) 보다 크므로 귀무가설 채택
  부모의 학력수준과 자녀의 진학여부와 관련성이 없다
  
  카이제곱 검정통계랑 : 2.767, 자유도 : 2
  임계값 : 5.99, 기각값(X^2 >= 5.99) 이면 귀무가설을 기각할 수 있다. -> 그런데 위 예에서는 못해
  
  
  # 일원 카이제곱 검정
  # 일치하는지를 검정하는 적합도 검정(test for goodness of fit)과 선호도 분석에서 주로 이용된다.
  귀무가설: 기대치와 관찰치는 차이가 없다. 예) 스포츠음료에 대한 선호도가 없다.
  대립가설: 기대치와 관찰치는 차이가 있다. 예) 스포츠음료에 대한 선호도가 있다.
  
  data <- textConnection("스포츠음료종류	관측도수
  	1	41
  	2	30
  	3	51
  	4	71
  	5	61
  ")
  x <- read.table(data, header=T)
  chisq.test(x$관측도수)
  data:  x$관측도수
  X-squared = 20.488, df = 4, p-value = 0.0003999
  
  해석: 유의확률(p-value) 0.0003999 이 유의수준(0.05) 보다 작으므로 귀모가설을 기각할 수 있고 연구가설 채택 됨(스포츠음료에 대한 선호도에 차이가 있다).
  카이제곱검정통계량이 20.488이 9.49(검정표값)보다 크므로 귀모가설을 기각할 수 있다.
  
  
  
  # 동질성 검정: 이원 카이제곱검정 중 하나. 두 집단의 분포가 동일한지.
  data <- read.csv("./data/homogenity.csv", header=T)
  head(data)
  str(data)
  #method 방법 1, 2, 3
  #survey 만족도 1:매우만족 ~ 5:매우 불만족
  
  귀무가설(H0): 교육방법에 따라 만족도 차이가 없다.
  대립가설(H1): 교육방법에 따라 만족도 차이가 있다.
  
  data <- subset(data, !is.na(survey), c(method, survey))
  data$method2[data$method==1] <- "방법1"
  data$method2[data$method==2] <- "방법2"
  data$method2[data$method==3] <- "방법3"
  data$survey2[data$survey==1] <- "매우만족"
  data$survey2[data$survey==2] <- "만족"
  data$survey2[data$survey==3] <- "보통"
  data$survey2[data$survey==4] <- "불만족"
  data$survey2[data$survey==5] <- "매우불만족"
  
  table(data$method2, data$survey2) #table(행, 열)
         
          만족 매우만족 매우불만족 보통 불만족
    방법1    8        5          6   15     16 #= 50
    방법2   14        8          6   11     11 #= 50
    방법3    7        8          9   11     15 #= 50
  # 방법1, 방법2, 방법3의 관측치의 개수는 50으로 동일 -> 반드시 각 집단의 개수는 동일해야한다
  # 동질성 검정
  chisq.test(data$method2, data$survey2)
  
  	Pearson''s Chi-squared test
  
  data:  data$method2 and data$survey2
  X-squared = 6.5447, df = 8, p-value = 0.5865
  
  해석:
  유의확률 0.5865가 유의수준(0.05)보다 크므로 귀무가설을 기각할 수 없다. 연구가설(대립가설) 채택
  카이제곱검정값 6.5447이 15.51(검정표값)보다 작으므로 귀무가설을 기각할 수 없다. 연구가설(대립가설) 채택
  
  ############### 실습 연습문제#############################################
  ###Quiz01>
   교육수준(education)과 흡연율(smoking) 간의 관련성을 분석하기 위한 연구가설을 수
  립하고, 각 단계별로 가설을 검정하시오. [독립성 검정]
  귀무가설(H0) : "교육수준과 흡연율은 관련이 없다." 
  연구가설(H1) : "교육수준과 흡연율은 관련이 있다."
   
  smoke <- read.csv("./data/smoke.csv", header=TRUE)
  head(smoke)
  
  education : 1:대졸, 2:고졸, 3:중졸
  smoke : 1:과다흡연, 2:보통흡연, 3:비흡연
  smoke$edu[smoke$education == 1] <- "대졸"
  smoke$edu[smoke$education == 2] <- "고졸"
  smoke$edu[smoke$education == 3] <- "중졸"
  smoke$smk[smoke$smoking == 1] <- "과다흡연" 
  smoke$smk[smoke$smoking == 2] <- "보통흡연" 
  smoke$smk[smoke$smoking == 3] <- "비흡연" 
  
  chisq.test(smoke$edu, smoke$smk)
  
  	Pearson''s Chi-squared test
  
  data:  smoke$edu and smoke$smk
  X-squared = 18.911, df = 4, p-value = 0.0008183
  
  해석:
  유의확률 0.0008183이 유의수준(0.05)보다 작으므로 귀무가설을 기각할 수 있다. 연구가설 채택
  카이제곱검정값 18.911이 9.49(검정표값) 보다 키므로 귀무가설을 기각할 수 있다. 연구가설 채택
  -> 관련 있다.
  
  
  ###Quiz02>
  나이(age3)와 직위(position) 간의 관련성을 단계별로 분석하시오. [독립성 검정]
  
  귀무가설(H0) : "나이와 직위 간에는 관련성이 없다."
  연구가설(H1) : "나이와 직위 간에는 관련성이 있다."
   
  data <- read.csv("./data/cleanData.csv", header=TRUE)
  head(data)
  
  data.sub <- subset(data, !is.na(position), c(age3, position))
  chisq.test(data.sub$age3, data.sub$position)
  
  	Pearson''s Chi-squared test
  
  data:  data.sub$age3 and data.sub$position
  X-squared = 287.9, df = 8, p-value < 2.2e-16 
  
  해석:
  유의확률 2.2e-16이 유의수준(0.05)보다 작으므로 귀무가설을 기각할 수 있다. 연구가설 채택
  카이제곱검장값 287.9가 15.51(검정표값)보다 크므로 귀무가설을 기각할 수 있다. 연구가설 채택.
  -> 관련 있다.
  
  
  ###Quiz03>
  직업유형에 따른 응답정도에 차이가 있는가를 단계별로 검정하시오.[동질성 검정]
  
  귀무가설(H0) : "직업유형에 따라 응답정도에 차이가 없다."
  연구가설(H1) : "직업유형에 따라 응답정도에 차이가 있다."
   
  response <- read.csv("./data/response.csv", header=TRUE)
  head(response) 
  
  job : 1:학생, 2:직장인, 3:주부
  response : 1:무응답, 2:낮음, 3:높음
  
  response$job2[response$job == 1] <- "학생"
  response$job2[response$job == 2] <- "직장인"
  response$job2[response$job == 3] <- "주부"
  response$res2[response$response == 1] <- "무응답"
  response$res2[response$response == 2] <- "낮음"
  response$res2[response$response == 3] <- "높음"
  
  chisq.test(response$job2, response$res2)
  
  	Pearson''s Chi-squared test
  
  data:  response$job2 and response$res2
  X-squared = 58.208, df = 4, p-value = 6.901e-12
  
  해석:
  유의확률(5.901e-12)이 유의수준(0.05)보다 작으므로 귀무가설을 기각할 수 있다. 연구가설 채택.
  카이제곱검정값(58.208)이 검정표값(9.49)보다 크므로 귀무가설을 기각할 수 있다. 연구가설 채택.
  -> 관련 있다.
  
  ```

  ![1568788262542](assets/1568788262542.png)

- 피셔의 정확 검정

  ```R
  #표본 수가 적거나 표본이 분할표의 셀에 매우 치우치게 분포되어 있다면 카이 제곱 검정의 결과가 부정확할 수 있다.
  fisher.test(
      x, # 행렬 형태의 이차원 분할표 또는 팩터
      y = NULL, # 팩터, x가 행렬이면 무시된다.
      alternative="two.sided" #대립가설로 two.sided 양측 검정, less는 작다, greater는 크다
  )
  
  MASS::survey #데이터에서 손글씨를 어느 손으로 쓰는지와 박수를 칠 때 어느 손이 위로 가는지 사이의 경우에 대해 피셔의 정확 검정을 수행
  
  귀무가설 : "손글씨 손과 박수 칠 때 위로 가는 손은 관련이 없다."
  연구가설 : "손글씨 손과 박수 칠 때 위로 가는 손은 관련이 있다."
  survey <- MASS::survey
  
  xtabs(~ W.Hnd + Clap, data=survey)
         Clap
  W.Hnd   Left Neither Right
    Left     9       5     4
    Right   29      45   143
  
  ##
  chisq.test(xtabs(~ W.Hnd + Clap, data=survey))
  
  	Pearson''s Chi-squared test
  
  data:  xtabs(~W.Hnd + Clap, data = survey)
  X-squared = 19.252, df = 2, p-value = 6.598e-05
  
  Warning message:
  In chisq.test(xtabs(~W.Hnd + Clap, data = survey)) :
    카이제곱 approximation은 정확하지 않을수도 있습니다
  
  ##
  fisher.test(xtabs(~ W.Hnd + Clap, data=survey))
  
  	Fisher''s Exact Test for Count Data
  
  data:  xtabs(~W.Hnd + Clap, data = survey)
  p-value = 0.0001413
  alternative hypothesis: two.sided
  ```

- 맥니마 검정

  ```R
  # 벌금을 부과하기 시작한 후 안전벨트 착용자의 수, 선거 유세를 하고 난 뒤 지지율의 변화와 같이 응답자의 성향이 사건 전후에 어떻게 달라지는지를 알아보는 경우
  # 사건 전후에 설문 결과에 응답자 수 변화가 없다면 Test1의 positive와 Test2의 positive가 동일해야...
  
  # 투표권이 있는 나이의 미국인 1,600명에 대해 대통령 지지율을 조사
  # 1차 조사 와 2차 조사 한 달 간격으로 수행
  # Argresti (1990), p.350.
  # Presidenttial Approval Ratings.
  # Approval of the President's performance in office in two
  # surveys, one month apart, for a random sample of 1600
  # voting-age Americans
  
  Performance <- matrix(
      c(794, 86, 150, 570),
      nrow = 2,
      dimnames = list (
          "1st Survey" = c("Approve", "Disapprove"),
          "2st Survey" = c("Approve", "Disapprove")
      )
  )
  
  Performance
  mcnemar.test(Performance)
  ```

  

## 4.5. 추정과 검정

### 4.5.1. 모 평균의 구간 추정

```R
# 전체 표본 크기 n : 10000
# 표본 평균 X : 165.1 cm
# 표본 표준편차(S) : 2 cm

#신뢰구간 구하기
N <- 10000
X <- 165.1
S <- 2
low <- X - 1.96 * S / sqrt(N)
high <- X + 1.96 * S / sqrt(N)
#신뢰구간 165.0608 < 뮤 165.1 < 165.1392 에 평균이 포함

# 신뢰구간으로 표본 오차 구하기
# 표본오차
	# 표본이 모집단의 특성과 정확히 일치하지 않아서 발생하는 확률의 차이
	# 신뢰구간의 하한값에서 평균을 빼고, 상한값에서 평균을 뺀 값을 백분율로 적용
하한값 - 평균신장 , 상한값 - 평균신장
(low-X) * 100 # -3.92
(high-X) * 100 # 3.92

#해석:
우리나라  중학교 2학년 남학생의 평균 신장이 95%신뢰수준에서 표본 오차는 ±3.92 범위에서 
평균 165.1cm로 조사되었다면 실제 평균키는 165.0608 ~165.1392 사이에 나나탈 수 있다
```

### 4.5.2. 모 비율의 구간 추정

```R
# A반도체 회사의 사원을 대상으로 임의 추출한 150명을 조사한 결과 90명이 여자 사원이다.
# 모비율 구간 추정하기
N <- 150
p <- 90/150 # 0.6
# 전체 여자 사원 비율(모비율)
low <- p - 1.96 * sqrt(p*(1-p)/N)
high <- p + 1.96 * sqrt(p*(1-p)/N)
#모집단의 비율 구간은 다음과 같다  
0.5216 ≤ 모비율(P) ≤ 0.6784

```

### 4.5.3. 단일 집단  비율 검정

> 한 개의 집단과 기존 집단과의 비율 차이 검정은 기술 통계량으로 빈도수에 대한 비율에 의미가 있으며, 평군 차이 검정은 표본 평균에 의미가 있다. 단일 집단의 비율이 어떤 특정한 값과 같은지를 검정하는 방법.

```
2016년도 114 전화번호 안내고객을 대상으로 불만을 갖는 고객은 20%였다.
이를 개선하기 위해서 2017년 CS 교육을 실시한 후  150명 고객을 대상으로 조사한 결과 14명이 불만을 가지고 있었다.  기존 20%보다 불만율이 낮아졌다고 할 수 있는가?.


귀무가설(HO) : 기존 2016년도 고객 불만율과 2017년 CS 교육 후 불만율에 차이가 없다.
연구가설(H1) : 기존 2016년도 고객 불만율과 2017년 CS 교육 후 불만율에 차이가 없다.

binom.test()
```

- 실습

  ```R
  1 .데이터 전처리 (이상치와 결측치 제거) -> 
  2. 기술통계량(빈도분석) -> 
  3. binom.test() -> 
  4. 검정통계량 분석
  5. 비율 차이 검정 통계량을 바탕으로 귀무가설의 기각 여부를 결정한다
  
  data <- read.csv("./data/one_sample.csv", header=T)
  x <- data$survey
  
  # 1, 2 진행. 결측치 등 확인.
  length(x)
  table(x) # 0:불만족, 1:만족
  library(prettyR)
  freq(x) # 결측치 확인에 좋음
  
  # 3. 진행
  binom.test(
      x, 			# 성공의 수
      n, 			# 시행 횟수, x의 길이가 2라면 무시
      p = 0.5,	# 성공 확률에 대한 가설
      alternative = c("two.sided", "less", "greater"), #대립가설의 형태. 기본은 양측 검정
      conf.level = 0.95
  )
  binom.test(c(136, 14), p=0.8)
  binom.test(c(136, 14), p=0.8, alternative="two.sided", conf.level = 0.95)
  
  	Exact binomial test
  
  data:  c(136, 14)
  number of successes = 136, number of trials = 150, p-value =
  0.0006735
  alternative hypothesis: true probability of success is not equal to 0.8
  95 percent confidence interval:
   0.8483615 0.9480298
  sample estimates:
  probability of success 
               0.9066667
  
  # 4,5 진행
  #해석:
  p-value 유의확률(0.0006735) 이0.05보다 작기 때문에 기존 만족률(80%)과 차이가 있다!!!
  
  # 그런데, 크다 혹은 작다의 방향성을 제시하지 않으므로 방향성을 갖는 단측 검정을 수행
  binom.test(c(136, 14), p=0.8, alternative="greater", conf.level = 0.95)
  
  	Exact binomial test
  
  data:  c(136, 14)
  number of successes = 136, number of trials = 150, p-value =
  0.0003179
  alternative hypothesis: true probability of success is greater than 0.8
  95 percent confidence interval:
   0.8579426 1.0000000
  sample estimates:
  probability of success 
               0.9066667 
  #해석:
  p-value 유의확률(0.0003179)이 0.05보다 작기 때문에 기존 만족률(80%)과 차이가 있다!!! CS 교육후에 고객의 불만율은 낮아졌다고 할 수 있다(귀무가설 기각, 연구가설 채택). CS 교육에 효과가 있다.
  
  # 불만율로 할 때
  binom.test(c(14, 136), p=0.2)
  binom.test(c(14, 136), p=0.2, alternative="less")
  
  ```

### 4.5.4. 단일 집단 평균 검정

>단일집단의 평균이 어떤 특정한 집단의 평균과 차이가 있는지를 검정하는 방법

```R
국내에서 생산된 노트북 평균 사용시간이 5.2시간으로 파악된 상황에서 A회사에서 생산된 노트북 평균 사용시간과 차이가 있는지를 검정하기 위해서 A 회사 노트북 150대를 랜덤으로 선정하여 검정을 실시한다.

귀무가설(H0) : 국내에서 생산된 노트북과 A회사에서 생산된 노트북의 평균 사용시간에 차이가 없다
연구가설(H1) : 국내에서 생산된 노트북과 A회사에서 생산된 노트북의 평균 사용시간에 차이가 있다.


shapiro.test() #정규분포 검정
	t.test() #정규분포 시
	wilcox.test() #정규분포가 아닐 시
```

- 실습

  ```R
  #단일집단의 평균 검정 (단일표본 T 검정)
  data <- read.csv("./data/one_sample.csv", header=T)
  x <- data$time
  summary(x)
  #결측치 제거 후 평균 구하기
  x <- x[!is.na(x)]; mean(x)
  x1 <- na.omit(x); mean(x1) #5.556881
  mean(x, na.rm=T)
  
  #정규분포 인지
  #정규분포 검정은 stats 패키지에서 제공하는 shapiro.test() 이용
  #검정 결과가 유의수준 0.05보다 큰 경우 정규분포로 본다 .
  shapiro.test(x1)
  
  	Shapiro-Wilk normality test
  
  data:  x1
  W = 0.99137, p-value = 0.7242
  -> 정규 분포
  hist(x1)
  
  #팁
  #stats 패키지에서 정규성 검정 
  #qqnorm(), qqline() 정규분포 시각화
  qqnorm(x1)
  qqline(x1, lty=1, col='blue')
  
  # 모수 검정 : T-검정
  t.test(x1, mu=5.2) #x1 객체와 기존 모집단의 평군 5.2시간 비교
  t.test(x1, mu=5.2, alter="two.side", conf.level=0.95)
  # 해석:
   검정 통계량 p-value 값은 0.0001417 로 유의수준 0.05보다 작기 때문에 국내에서 생산된 노트북과 A회사에서 생산된 노트북의 평균 사용시간에 차이가 있다.
  x1의 평균은 5.55688(점추정)는 신뢰구간에 포함되고 A회사에서 생산된 노트북의 평균 사용시간 5.2는 신뢰구간을 벗어나므로 (신뢰구간은 귀무가설의 채택역의 의미가 있으므로) 귀무가설이 기각된다.
  
  # 방향성을 갖는 단측 검정
  # greater 사용시 연구가설
  t.test(x1, mu=5.2, alter="greater", conf.level=0.95)
  
  	One Sample t-test
  
  data:  x1
  t = 3.9461, df = 108, p-value = 7.083e-05
  alternative hypothesis: true mean is greater than 5.2
  95 percent confidence interval:
   5.406833      Inf
  sample estimates:
  mean of x 
   5.556881
  
  연구가설 : '국내에서 생산된 노트북 평균 사용시간이  A회사에서 생산된 노트북의 평균 사용시간보다 더 길다'
  해석 : 검정 통계량 p-value 값은 7.083e-5로 유의수준 0.05보다 매우 작기 때문에 
  귀무가설 :'A회사에서 생산된 노트북의 평균 사용시간이 국내에서 생산된 노트북 평균 사용시간보다 더 길다'고 할 수 있다.
  
  #귀무가설 임계값 계산 qt(p-value, df)
  귀무가설을 기각할 수 있는 임계값
  qt(7.083e-5, 108)
  [1] -3.946073
  t 값이 3.9461이 -3.946073 이상이므로 귀무가설을 기가할 수있다.
  ```

### 4.5.5. 두 집단 비율 검정

>데이터 전처리 -> 두 집단 subset 생성  -> prop.test() -> 검정통계량 분석
>
>단일표본 이항분포 비율검정은 binom.test() 를 이용
>
>독립표본 이항분포 비율검정은 prop.test()를 이용
>
>비율 차이 검정 통계량을 바탕으로 귀무가설의 기각 여부를 결정

```R
prop.test(
    x, 
    n, 
    p = NULL, 
    alternative = c(“two.sided”, “less”, “greater”),
    conf.level=0.95, correct=TRUE
)

IT 교육센터에서 PT를 이용한 프리젠테이션 교육방법과 실시간 코딩 교육방법을 적용하여 교육을 실시하였다. 2시간 교육방법 중 더 효과적인 교육방법을 조사하기 위해서 교육생 300명을 대상으로 설문을 실시하였다. 

귀무가설(H0) : 두 가지 교육방법에 따라 교육생의 만족률에 차이가 없다.
연구가설(H1) : 두 가지 교육방법에 따라 교육생의 만족률에 차이가 있다.


# 두 집단 비율 차이 검정 실습
data <- read.csv("./data/two_sample.csv", header=T)
str(data) #method 교육방법

x <- data$method
y <- data$survey
# NA 없음
table(x)
table(y)
# 교차 분석을 위한 분할표 생성
table(x, y, useNA="ifany") #결측치까지 출력

# 두 집단의 비율 차이 검정
prop.test('pt교육 만족도와 코딩교육 만족도', '교육방법에 대한 변량 - 시행횟수')
prop.test(c(110, 135), c(150, 150))

	2-sample test for equality of proportions with continuity
	correction

data:  c(110, 135) out of c(150, 150)
X-squared = 12.824, df = 1, p-value = 0.0003422
alternative hypothesis: two.sided
95 percent confidence interval:
 -0.25884941 -0.07448392
sample estimates:
   prop 1    prop 2 
0.7333333 0.9000000 

#해석:
검정 통계량 p-value는 0.0003422로 유의수준 0.05보다 작기 때문에 두 교육방법 간의 만족도 에 차이가 있다.
검정 통계량 X-squared 12.824로 카이제곱검정통계표 3.84보다 크기 때문에 귀무가설을 기각할 수 있다.
```

### 4.5.6. 두 집단 평균 검정

> 두 집단을 대상으로 평균 차이 검정을 통해서 두 집단의 평군이 같은지 또는 다른지를 검정
>
> 데이터 전처리 -> 두집단 subset 작성-> 기술 통계량(평균) ->  동질성분포 (var.test()) -> t.test() 또는 wilcox.text() -> 검정통계량 -> 분석

```R

data <- read.csv("./data/two_sample.cse", header=T)

#두 집단 subset 생성 (NA제거, 필요컬럼 추출)
result <- subset(data, !is.na(score), c(method, score))
str(result)

a <- subset(result, method==1)
b <- subset(result, method==2)

ascore <- a$score
bscore <- b$score

#기술 통계량(평균)
length(ascore) 	# 109
length(bscore) 	# 108
mean(ascore)	# 5.55681
mean(ascore)	# 5.80339

#분산의 동질성 검정
var.test(ascore, bscore)

	F test to compare two variances

data:  ascore and bscore
F = 1.2158, num df = 108, denom df = 117, p-value = 0.3002
alternative hypothesis: true ratio of variances is not equal to 1
95 percent confidence interval:
 0.8394729 1.7656728
sample estimates:
ratio of variances 
          1.215768 
#해석 :
감정 통계량 p-value 값은 0.3002로 유의수준 0.05보다 크기 때문에 두 집단 간의 분포 형태가 동일하다고 볼 수 있다.

# 두 집단 평균 차이 검정
t.test(ascore, bscore)
t.test(ascore, bscore, alter="two.sided", conf.int=TRUE, conf.level=0.95)
두 집단간의 평균에 차이가 있다.

# 단측 가설 검정 (ascore가 기준으로 비교 -> ascore가 b)
t.test(ascore, bscore, alter="greater", conf.int=TRUE, conf.level=0.95)
검정 통계량 p-value 값은 0.9794로 유의수준 0.05보다 크기 때문에 귀무가설을 기각 할 수 없다. "a가 b보다 크지 않다"를 기각 할 수 없다. -> a가 작다.

t.test(ascore, bscore, alter="less", conf.int=TRUE, conf.level=0.95)
검정 통계량 p-value 값은 0.02055로 유의수준 0.05보다 작기 때문에 귀무가설을 기각할 수 있다. "a가 b보다 작지 않다"를 기각. -> a가 작다.


```

### 4.5.7. 대응 두 집단 평균 검정(대응 표본 T검정)

>

```R
data <- read.csv("./data/paired_sample.csv", header=TRUE)

result <- subset(data, !is.na(after), c(before, after))
length(result$after) # 결측치 4개 제외됨

x <- result$before
y <- result$after
mean(x) # 5.16875
mean(y) # 6.220833

# 동질성 검정
var.test(x, y, paired=TRUE)

	F test to compare two variances

data:  x and y
F = 1.0718, num df = 95, denom df = 95, p-value = 0.7361
alternative hypothesis: true ratio of variances is not equal to 1
95 percent confidence interval:
 0.7151477 1.6062992
sample estimates:
ratio of variances 
          1.071793 
# 해석
차이가 없다.

# 평균 차이 검정
t.test(x, y, paired=T, alter="two.sided", conf.int=T, conf.level=0.95)
해석: 
차이가 있다.

t.test(x, y, paired=T, alter="less", conf.int=T, conf.level=0.95)
해석:
x가 작다.
```

### 4.5.8. 세 집단 검정

> 세 집단 비율 차이 검정은 기술 통계량으로 빈도수에 대한 비율에 의미가 있으며, 세 집단의
> 평균 차이 검정은 분산 분석이라고 한다.
>
> 데이터 전처리 > 세 집단  subset  작성-> prop.test() > 검정통계량 분석

```R
# 세 집단 비율 차이 검정
data <- read.csv("./data/three_sample.csv", header=T)

method <- data$method
survey <- data$survey

table(method, useNA="ifany")
table(method, survey, useNA="ifany") #교차분할표
#prop.test((교육방법에 대한 만족 빈도수), (변량의 길이))
prop.test(c(34,37,39), c(50,50,50))
prop.test(c(34,37,39), c(50,50,50), alter="two.sided", conf.level=0.95)
해석:
검정 통계량 p-value 값은 0.5232로 유의수준 0.05보다 세 교육방법 간의 만족도 차이가 없다(귀무가설 채택)
카이제곱검정 통계량 1.2955는 df 2의 기각값 5.991보다 작기 때문에 귀무가설을 기각할 수 없다.
```

### 4.5.9. 분산 분석

> 분산분석(ANOVA  Analysis)-  T 검정과 동일하게 평균에 의한 차이 검정 방법
>
> 두 집단 이상의 평균 차이를 검정
>
> 예) 의학연구 분야에서 개발된 3가지 치료제가 있다고 가정할 때, 이 3가지 치료제의 효과에 차이가 있는지를 검정
>
> 분산분석은 가설 검정을 위해 F 분포를 따른 F 통계량을  검정 통계량으로 사용하기 때문에 F검정이라고 한다.
>
> 데이터 전처리 -> 각 집단 subset 작성 -> 기술 통계량(평균)  ->  동질성분포 (barlett.test()) -> aov() 또는 kruskal.test() -> TukeyHSD()
>
> •분산분석에서 집단 간의 동질성 여부를 검정하기 위해서는 bartlett.test()를 이용
>
> •집단 간의 분포가 동질한 경우 분산분석을 수행하는  aov() 함수를 이용
>
> •비모수 검정 방법인 kruskal.test() 를 이용하여 분석을 수행하고, 
>
> •마지막으로 TukeyHSD() 함수를 이용하여 사후 검정을 수행한다

```R
세가지 교육방법을 적용하여 1개월 동안 교육받은 교육생 각 50명씩을 대상으로 실기시험을 실시하였다. 세 집단 간 실기시험의 평균에 차이가 있는지를 검정한다.

귀무가설(H0) : 교육방법에 따른 세 집단 간 실기시험의 평균에 차이가 없다.
연구가설(H1) : 교육방법에 따른 세 집단 간 실기시험의 평균에 차이가 있다.

# 분산 분석 (F 검정) : 세 집단의 평균 차이 분석
data <- read.csv("./data/three_sample.csv", header=TRUE)
data1 <- subset(data, !is.na(score), c(method, score)) #결측치 제거

# 이상치 존재 확인(데이터 분포 현황 분석)
plot(data1$score) # 산점도
barplot(data1$score)
boxplot(data1$score)
mean(data1$score)
length(data1$score) #제거전 91
data2 <- subset(data1, score <= 14) 
length(data2$score) #제거후 88
boxplot(data2$score)

# 명목 데이터로 변경
data2$method2[data2$method==1] <- "방법1"
data2$method2[data2$method==2] <- "방법2"
data2$method2[data2$method==3] <- "방법3"

# 교육방법에 따른 빈도수
mCnt <- table(data2$method)
mAvg  <- tapply(data2$score, data2$method2, mean)

# 데이터 프레임 생성
df <- data.frame(교육방법 = mCnt, 성적=mAvg)
      교육방법.Var1 교육방법.Freq     성적
방법1             1            31 4.187097
방법2             2            27 6.800000
방법3             3            30 5.610000

# 세 집단의 동징설 검정
#  bartlett.test(종속변수~독립변수, data=데이터셋)
bartlett.test(score ~ method2, data=data2)

	Bartlett test of homogeneity of variances

data:  score by method
Bartlett''s K-squared = 3.3157, df = 2, p-value = 0.1905

# 해석:
검정 통계량 p-value 값은 0.1905 로 유의수준 0.05보다 크기때문에 세 집단 간의 분포 형태가 동질하다.

# 세 잡단의 평균 차이 검정: aov()
aov(formula, data = NULL, projections = FALSE, qr = TRUE,
    contrasts = NULL, ...)
result <- aov(score ~ method2, data=data2)
Call:
   aov(formula = score ~ method2, data = data2)

Terms:
                 method2 Residuals
Sum of Squares  99.36805  96.90184
Deg. of Freedom        2        85

Residual standard error: 1.067718
Estimated effects may be unbalanced
#측정된 검정 결과 변수명 확인
names(result)
[1] "coefficients"  "residuals"     "effects"       "rank"         
 [5] "fitted.values" "assign"        "qr"            "df.residual"  
 [9] "contrasts"     "xlevels"       "call"          "terms"        
[13] "model" 
summary(result)
            Df Sum Sq Mean Sq F value   Pr(>F)    
method2      2  99.37   49.68   43.58 9.39e-14 ***
Residuals   85  96.90    1.14                     
---
Signif. codes:  0 ‘***’ 0.001 ‘**’ 0.01 ‘*’ 0.05 ‘.’ 0.1 ‘ ’ 1
# 해석:
검정 통계량 p-value 값은 9.39e-14로 유의수전 0.05보다 작으므로 교육방법에 따른 세 집단 간의 실기시험 평균에 차이가 있다.
검정 통계량 F(43.58)가 -1.96 ~ + 1.96 범위의 귀무가설의 채택역에 해당하지 않으므로 귀무가설을 기각하므로 교육방법에 따른 세 집단 간의 실기시험 평균에 차이가 있다.

# 집단간의 평균의 차에 대한 비교 => 사후 검정 수행
TukeyHSD(result) # 분산분석 결과로 사후 검정
  Tukey multiple comparisons of means
    95% family-wise confidence level

Fit: aov(formula = score ~ method2, data = data2)

$method2
                 diff        lwr        upr     p adj
방법2-방법1  2.612903  1.9424342  3.2833723 0.0000000
방법3-방법1  1.422903  0.7705979  2.0752085 0.0000040
방법3-방법2 -1.190000 -1.8656509 -0.5143491 0.0001911

plot(TukeyHSD(result))

#diff 폭(평균의 차이)의 크기 - 방법2와 방법1의 차이가 가장 큼
#lwr, upr은 신뢰구간의 하한값과 상한값
```

### 4.5.10 연습 문제

```R
####
#연습문제01>
중소기업에서 생산한 HDTV 판매율을 높이기 위해서 프로모션을 진행한 결과 기존 구
매비율 보다 15% 향상되었는지를 각 단계별로 분석을 수행하여 검정하시오.
연구가설(H1) : 기존 구매비율과 차이가 있다.
귀무가설(H0) : 기존 구매비율과 차이가 없다.
조건) 구매여부 변수 : buy (1: 구매하지 않음, 2: 구매)
hdtv <- read.csv("./data/hdtv.csv", header=TRUE)
#빈도수 비율 계산
#가설 검정
table(hdtv$buy)
 1  2 
40 10 

binom.test(c(10,40), p=0.15)

	Exact binomial test

data:  c(10, 40)
number of successes = 10, number of trials = 50, p-value = 0.321
alternative hypothesis: true probability of success is not equal to 0.15
95 percent confidence interval:
 0.1003022 0.3371831
sample estimates:
probability of success 
                   0.2 
#해석:
검정통계량 유의확률 p-value(0.321) 이 0.05보다 작으므로 귀무가설을 기각할 수 없다, 따라서 프로모션 진행후 구매비율에 차이가 없다.


# 모범 답안
# 단계3: 가설검정
binom.test(c(10,40), p=0.15) #15% 비교 -> p-value = 0.321
binom.test(c(10,40), p=0.15, alternative="two.sided", conf.level=0.95)
해설> 귀무가설 채택 : 기존 구매비율(15%)과 차이가 없다.

#  방향성이 있는 단측가설 검정
binom.test(c(10,40), p=0.15, alternative="greater", conf.level=0.95)
#p-value=0.2089
binom.test(c(10,40), p=0.15, alternative="less", conf.level=0.95) #p-value =0.8801
해설> 방향성이 잇는 단측가설은 모두 기각된다.

# 11% 기준 : 방향성이 있는 연구가설 검정
binom.test(c(10,40), p=0.11, alternative="greater", conf.level=0.95)
#p-value=0.04345
해설> 구매비율은 11%을 넘지 못한다.





####
#연습문제02> (두 집단 비율 차이 검정)
우리나라 전체 중학교 2학년 여학생 평균 키가 148.5cm로 알려져 있는 상태에서 A중
학교 2학년 전체 500명을 대상으로 10%인 50명을 표본으로 선정하여 표본평균신장을
계산하고 모집단의 평균과 차이가 있는지를 각 단계별로 분석을 수행하여 검정하시오.
단계1: 데이터셋 가져오기 
read.csv("./data/student_height.csv", header=TRUE)
#기술 통계량 평균을 계산
#정규성 검정
#가설 검정
#t.test(x1, mu=5.2)
#귀무가설 임계값 계산 qt(p-value, df)
data <- read.csv("./data/student_height.csv", header=TRUE)
mean(data$height)
[1] 149.4

 shapiro.test(data$height)

	Shapiro-Wilk normality test

data:  data$height
W = 0.88711, p-value = 0.0001853
-> 정규 분포가 아님 -> 어떡함?

t.test(data$height, mu=148.5)

	One Sample t-test

data:  data$height
t = 1.577, df = 49, p-value = 0.1212
alternative hypothesis: true mean is not equal to 148.5
95 percent confidence interval:
 148.2531 150.5469
sample estimates:
mean of x 
    149.4 

#해석:
검정통계량 유의확률 p-value(0.1212)가 유의수준(0.05) 보다 크므로 귀무가설을 채택. 따라서 모집단과 평균 차이가 없다.

#모범 답안
stheight<- read.csv("./data/student_height.csv", header=TRUE)
stheight
height <- stheight$height
head(height)
# 단계2: 기술 통계량/결측치 확인
length(height) #50
summary(height) # 149.4

x1 # 정제 데이터
mean(x1) # 149.4 : 평균신장
단계3: 정규성 검정
shapiro.test(x1) # p-value = 0.0001853 -> 정규분포 아님
# 정규분포(모수검정) - t.test()
# 비정규분포(비모수검정) - wilcox.test()

단계4: 가설검정 - 양측검정
wilcox.test(x1, mu=148.5) # p-value = 0.067
wilcox.test(x1, mu=148.5, alter="two.side", conf.level=0.95)

	Wilcoxon signed rank test with continuity correction

data:  data$height
V = 826, p-value = 0.067
alternative hypothesis: true location is not equal to 148.5
#해설> 귀무가설을 기각할 수 없다.





####
#연습문제03>
대학에 진학한 남학생과 여학생을 대상으로 진학한 대학에 대해서 만족도에 차이가 있
는가를 검정하시오. 
조건1) 파일명 : two_sample.csv
조건2, 변수명 : gender(1,2), survey(0,1)
#힌트
#prop.test('pt교육 만족도와 교딩교육 만족도', '교육방법에 대한 변량 - 시행횟수')
#prop.test(c(110, 135), c(150, 150))
data <- read.csv("./data/two_sample.csv")
tbl <- table(data$gender, data$survey)
   
      0   1
  1  36 138
  2  19 107
margin.table(tbl, 1)
  1   2 
174 126 
prop.test(c(138, 107), c(174, 126))

	2-sample test for equality of proportions with continuity
	correction

data:  c(138, 107) out of c(174, 126)
X-squared = 1.1845, df = 1, p-value = 0.2765
alternative hypothesis: two.sided
95 percent confidence interval:
 -0.14970179  0.03749599
sample estimates:
   prop 1    prop 2 
0.7931034 0.8492063 

#해석:
검정통계량 유의확률 p-value(0.2765) 가 유의수준 0.05 보다 크므로 귀무가설을 기각할 수 없다. 따라서 두 집단간 만족도의 차이는 없다.






####
#연습문제04>
교육방법에 따라 시험성적에 차이가 있는지 검정하시오. 
조건1) 파일 : twomethod.csv
조건2) 변수 : method(교육방법), score(시험성적)
조건3) 모델 : 교육방법(명목) -> 시험성적(비율)
조건4) 전처리 : 결측치 제거 

data <- read.csv("./data/twomethod.csv") #63 obs.
data1 <- subset(data, !is.na(score), c(method, score)) #57 obs.

a <- subset(data1, method==1)
b <- subset(data1, method==2)

ascore <- a$score
bscore <- b$score

summary(ascore)
   Min. 1st Qu.  Median    Mean 3rd Qu.    Max. 
   5.00    9.00   16.00   16.41   22.50   29.00 
summary(bscore)
   Min. 1st Qu.  Median    Mean 3rd Qu.    Max. 
  15.00   22.50   29.00   29.23   35.00   45.00 

#분산의 동질성 검정
var.test(ascore, bscore)

	F test to compare two variances

data:  ascore and bscore
F = 1.0648, num df = 21, denom df = 34, p-value = 0.8494
alternative hypothesis: true ratio of variances is not equal to 1
95 percent confidence interval:
 0.502791 2.427170
sample estimates:
ratio of variances 
           1.06479 
# 해석
동질성 차이가 없다.

# 평균 차이 검정
t.test(ascore, bscore)

	Welch Two Sample t-test

data:  ascore and bscore
t = -5.6056, df = 43.705, p-value = 1.303e-06
alternative hypothesis: true difference in means is not equal to 0
95 percent confidence interval:
 -17.429294  -8.209667
sample estimates:
mean of x mean of y 
 16.40909  29.22857 
#해석
검정통계량 유의확률 p-value(1.303e-06)이 유의수준 0.05보다 작으므로 귀무가설을 기각할 수 있다. 따라서 두 교육방법에 따라서 성적 차이가 있다고 볼 수 있다.

#모범 답안

edumethod <- read.csv("./data/twomethod.csv", header=TRUE)
head(edumethod) #3개 변수 확인 -> id method score

# 두 집단 subset 작성(데이터 정제, 전처리)
# 데이터 전처리(score의 NA 처리)
result <- subset(edumethod, !is.na(score), c(method, score))
result

# 데이터 분리
# 1) 교육방법별로 분리
a <- subset(result,method==1)
b <- subset(result,method==2)
# 2) 교육방법에서 영업실적 추출
a1 <- a$score
b1 <- b$score
# 3) 기술 통계량
length(a1); # 22
length(b1); # 35

# 분포모양 검정
var.test(a1, b1) # p-value = 0.8494 : 차이가 없다.
해설> 동질성 분포와 차이가 없다. 모수검정 방법 수행

# 가설검정
t.test(a1, b1) # p-value = 1.303e-06
t.test(a1, b1, alter="greater", conf.int=TRUE, conf.level=0.95) # p-value = 1
해설> a1 교육방법과 b1 교육방법 간의 시험성적에 차이가 있다.

t.test(b1, a1, alter="greater", conf.int=TRUE, conf.level=0.95) #
p-value=6.513e-07
해설> b1 교육 방법이 a1 교육방법 보다 시험성적이 더 좋다.

```

## 4.6. 요인 분석

> 변수들의 상관성을 바탕으로 변수를 정제하여 상관관계 분석이나 회귀분석에 설명변수(독립변수)로 사용된다.
>
> 상관 분석: 독립변수 상호 관계 분석
>
> 회귀 분석: 인과관계 분석

### 4.6.1. 공통 요인으로 변수를 정제하는 요인분석

```R
# 6개 과목 (s1~s6)
# 점수벡터 (5점 만점, 척도: 5)
s1 <- c(1, 2, 1, 2, 3, 4, 2, 3, 4, 5) #자연과학
s2 <- c(1, 3, 1, 2, 3, 4, 2, 4, 3, 4) # 물리화학
s3 <- c(2, 3, 2, 3, 2, 3, 5, 3, 4, 2) #인문사회
s4 <- c(2, 4, 2, 3, 2, 3, 5, 3, 4, 1) # 신문방송
s5 <- c(4, 5, 4, 5, 2, 1, 5, 2, 4, 3) #응용수학
s6 <- c(4, 3, 4, 4, 2, 1, 5, 2, 4, 2) # 추론통계
name <-1:10 #각 각 과목의 문제 이름
subject <- data.frame( s1, s2, s3, s4, s5, s6)

help(prcomp)  #주성분 분석 수행 함수
pc <- prcomp(subject) # scale = TRUE
summary(pc)
Importance of components:
                         PC1    PC2     PC3     PC4     PC5     PC6
Standard deviation     2.389 1.5532 0.87727 0.56907 0.19315 0.12434
Proportion of Variance 0.616 0.2603 0.08305 0.03495 0.00403 0.00167
Cumulative Proportion  0.616 0.8763 0.95936 0.99431 0.99833 1.00000
plot(pc)
# 변동량으로 볼때 주성분 요인수는 2개로 가정할 수 있습니다.
```

### 4.6.2. 고유값으로 요인 수 분석

```R
en <- eigen(cor(subject)) # $values : 고유값, $vectors: 고유벡터
names(en)
[1] "values"  "vectors"
en$values
en$vectors
en$values # $values : 고유값(스칼라) 보기 
plot(en$values, type="o") # 고유값을 이용한 시각화 
# 고유값이 급격하게 감소하는 1~3 요인을 주성분으로 삼는다.
```

### 4.6.3. 변수간의 상관관계 분석과 요인분석

> 상관관계 분석 – 변수 간의 상관성으로 공통요인 추출
>
> 요인 회전법 적용 – 요인 해석이 어려운 경우 어느 한 요인을 높게 나타내기 위해서 요인축을 회전하는 방법이 있다. 베리멕스 회전법을 기본으로 사용한다

```R
factanal(dataset, factors="요인수", rotation="요인회전법" )
scores ="요인점수 계산 방법"

#베리맥스요인 회전법
result <- factanal(subject, factors=2, rotation="varimax")

Call:
factanal(x = subject, factors = 2, rotation = "varimax")

Uniquenesses:
   s1    s2    s3    s4    s5    s6 
0.250 0.015 0.005 0.136 0.407 0.107 

Loadings:
   Factor1 Factor2
s1  0.862         
s2  0.988         
s3          0.997 
s4 -0.115   0.923 
s5 -0.692   0.338 
s6 -0.846   0.421 

               Factor1 Factor2
SS loadings      2.928   2.152
Proportion Var   0.488   0.359
Cumulative Var   0.488   0.847

Test of the hypothesis that 2 factors are sufficient.
The chi square statistic is 11.32 on 4 degrees of freedom.
The p-value is 0.0232 

# 3으로 하면?
result <- factanal(subject, factors=3, rotation="varimax")

Call:
factanal(x = subject, factors = 3, rotation = "varimax")

Uniquenesses:
   s1    s2    s3    s4    s5    s6 
0.005 0.056 0.051 0.005 0.240 0.005 

Loadings:
   Factor1 Factor2 Factor3
s1 -0.379           0.923 
s2 -0.710   0.140   0.649 
s3  0.236   0.931   0.166 
s4  0.120   0.983  -0.118 
s5  0.771   0.297  -0.278 
s6  0.900   0.301  -0.307 

               Factor1 Factor2 Factor3
SS loadings      2.122   2.031   1.486
Proportion Var   0.354   0.339   0.248
Cumulative Var   0.354   0.692   0.940

The degrees of freedom for the model is 0 and the fit was 0.7745 
```

### 4.6.4. 요인점수를 이용한 요인적재량 시각화

```R
subject <- data.frame( s1, s2, s3, s4, s5, s6)
result <- factanal(subject, factors=3, rotation="varimax", scores="regression")

result$scores
         Factor1     Factor2     Factor3
 [1,]  0.7357870 -0.98034177 -1.07981805
 [2,] -0.6640013  0.87937769 -0.83543481
 [3,]  0.7357870 -0.98034177 -1.07981805
 [4,]  0.6917075 -0.02812698 -0.27885523
 [5,] -0.7387206 -0.69135360 -0.07138837
 [6,] -1.7858690  0.33608991  0.30957945
 [7,]  1.0449596  1.66369477 -0.11745856
 [8,] -1.0999660  0.22263533 -0.17382007
 [9,]  0.9197524  0.96404108  1.40734566
[10,]  0.1605633 -1.38567464  1.91966803

result$loadings

Loadings:
   Factor1 Factor2 Factor3
s1 -0.379           0.923 
s2 -0.710   0.140   0.649 
s3  0.236   0.931   0.166 
s4  0.120   0.983  -0.118 
s5  0.771   0.297  -0.278 
s6  0.900   0.301  -0.307 

               Factor1 Factor2 Factor3
SS loadings      2.122   2.031   1.486
Proportion Var   0.354   0.339   0.248
Cumulative Var   0.354   0.692   0.940


# 2차원 시각화
plot(result$scores[, c(1:2)], main="Factor1과 Factor2의 요인점수 행렬")
text(result$scores[, 1], result$scores[, 2], labels=name, cex=0.7, pos=3, col="red")
points(result$loadings[, c(1:2)], pch=19, col="blue")
text(result$loadings[, 1], result$loadings[, 2], labels=rownames(result$loadings), cex=0.8, pos=3, col="blue")


# 3차원 시각화
install.packages("scatterplot3d")
library(scatterplot3d)
# scatterplot3d(밑변, 오른쪽 변, 왼쪽 변 , type)

Factor1 <- result$scores[, 1]
Factor2 <- result$scores[, 2]
Factor3 <- result$scores[, 3]

#축 생성
d3 <- scatterplot3d(Factor1, Factor2, Factor3, type="p")
#요인적재량 표시
loadings1 <- result$loadings[, 1]
loadings2 <- result$loadings[, 2]
loadings3 <- result$loadings[, 3]
d3$points3d(loadings1, loadings2, loadings3, bg="red", pch=21, cex=2, type="h")

```

### 4.6.5. 요인 별 변수 묶기

```R
# Factor1 은 응용과학
# Factor2 는 응용수학
# Factor3 는 자연과학

app <- data.frame(subject$s5, subject$s6)
soc <- data.frame(subject$s3, subject$s4)
net <- data.frame(subject$s1, subject$s2)

app_science <- round( (app$subject.s5 + app$subject.s6) / ncol(app), 2)
soc_science <- round( (soc$subject.s3 + soc$subject.s4) / ncol(soc), 2)
net_science <- round( (net$subject.s1 + net$subject.s2) / ncol(net), 2)

# 상관관계 분석
subject_factor_df <- data.frame(app_science, soc_science, net_science)
cor(subject_factor_df)

# 해석 > '응용과학' 기분으로 '사회과학'은 양의 상관성을 나타내고, '자연과학'은 음의 상관성을 나타내고 '사회과학'과 '자연과학'은 상관성이 없음을 나타냄
```

### 4.6.6. 잘못 분류된 요인 제거를 통한 변수 정제

```R
# 욤료수 제품의 11개의 변수(친밀도, 적절성, 만족도 3가지 영역)
# 특정 변수가 묶일 것으로 예상되는 요인이 묶이지 않는 경우, 해당 변수

install.packages("memisc")
library(memisc)
data.spss <- spss.system.file("./data/drinking_water.sav")
# 제품 친밀도(q1:브랜드, q2:친근감, q3:익숙함, q4:편안함)
# 제품 적절성(q5:가격, q6:당도, q7:성분)
# 제품 만족도(q8:목넘김 , q9:맛, q10:향, q11:가격)
drinking_water <- data.spss[1:11]
drinking_water_df <- as.data.frame(data.spss[1:11])

# 요인 분석
result <- factanal(drinking_water_df, factors=3, rotation="varimax")
Uniquenesses:
   q1    q2    q3    q4    q5    q6    q7    q8    q9   q10 
0.321 0.238 0.284 0.447 0.425 0.373 0.403 0.375 0.199 0.227 
  q11 
0.409 

Loadings:
    Factor1 Factor2 Factor3
q1  0.201   0.762   0.240  
q2  0.172   0.813   0.266  
q3  0.141   0.762   0.340  
q4  0.250   0.281   0.641  
q5  0.162   0.488   0.557  
q6  0.224   0.312   0.693  
q7  0.235   0.219   0.703  
q8  0.695   0.225   0.304  
q9  0.873   0.122   0.155  
q10 0.852   0.144   0.161  
q11 0.719   0.152   0.225  

               Factor1 Factor2 Factor3
SS loadings      2.772   2.394   2.133
Proportion Var   0.252   0.218   0.194
Cumulative Var   0.252   0.470   0.664

Test of the hypothesis that 3 factors are sufficient.
The chi square statistic is 40.57 on 25 degrees of freedom.
The p-value is 0.0255 

#Uniqueness

#Loadings
Factor1 : q8~q11
Facotr2 : q1~q3
Factor3 : q4~q7 #q4가 Factor2에 묶였어야 맞는데..

#p-value : 카이제곱검정 결과? 위에 따로 있는 듯
유의확률0.0255이 유의수준0.05보다 작으므로 유인수 선택에 문제가 있다?

dw_df <- drinking_water_df[-4]

s <- data.frame(dw_df$q8, dw_df$q9, dw_df$q10, dw_df$q11) #만족도
c <- data.frame(dw_df$q1, dw_df$q2, dw_df$q3) # 친밀도
p <- data.frame(dw_df$q5, dw_df$q6, dw_df$q7) #적절성

#요인별 산술평균 계산
satisfaction <- round( (dw_df$q8+dw_df$q9+dw_df$q10+dw_df$q11)/ncol(s), 2)
closeness <- round( (dw_df$q1+dw_df$q2+dw_df$q3)/ncol(c), 2)
pertinence <- round( (dw_df$q5+dw_df$q6+dw_df$q7)/ncol(p), 2)

#상관관계 분석
dwf_df <- data.frame(satisfaction, closeness, pertinence)
colnames(dwf_df) <- c("제품 만족도", "제품 친밀도", "제품 적절성")
cor(dwf_df)
            제품 만족도 제품 친밀도 제품 적절성
제품 만족도   1.0000000   0.4047543   0.4825335
제품 친밀도   0.4047543   1.0000000   0.6344751
제품 적절성   0.4825335   0.6344751   1.0000000
```

### 4.6.7  연습문제

```R
#다음은 drinkig_water_example.sav 파일의 데이터 셋이 구성된 테이블이다. 전체 2개의 요 인에 의해서 7개의 변수로 구성되어 있다. 아래에서 제시된 각 단계에 맞게 요인분석을 수행하시오

#요인 1001 (q1:브랜드, q2:친근감, q3: 익숙함)
#제품 만족도 (q4:음료의 목 넘기, q5:음료의 맛, q6:음료의 향 , q7:가격)
data <- spss.system.file("./data/drinking_water_example.sav")
data.df <- as.data.frame(data.spss[1:7])

#베리멕스 회전법, 요인수 2, 요인점수 회귀분석 방법을 적용하여 요인분석 하시오
result <- factanal(data.df, factors=2, rotation="varimax")

a <- data.frame(data.df$q1, data.df$q2, data.df$q3)
b <- data.frame(data.df$q4, data.df$q5, data.df$q6, data.df$q7)

closeness <- round( (data.df$q1 + data.df$q2 + data.df$q3)/ncol(a), 2)
satisfaction <- round( (data.df$q4 + data.df$q5 + data.df$q6 + data.df$q7)/ncol(b), 2)

#요인적재량 행렬의 칼럼명 변경하시오 ("제품친밀도","제품만족도")
data.df2 <- data.frame(closeness, satisfaction)
colnames(data.df2) <-  c("제품친밀도", "제품만족도")


요인점수를 이용한 요인적재량 시각화하시오

요인별 변수로  묶기

생성된 두 개의 요인을 데이터프레임으로 생성한 후 이를 이용하여 두 요인 간
의 상관관계 계수를 제시하시오


#상관관계 분석
dwf_df <- data.frame(satisfaction, closeness, pertinence)
colnames(dwf_df) <- c("제품 만족도", "제품 친밀도", "제품 적절성")
cor(dwf_df)
            제품 만족도 제품 친밀도 제품 적절성
제품 만족도   1.0000000   0.4047543   0.4825335
제품 친밀도   0.4047543   1.0000000   0.6344751
제품 적절성   0.4825335   0.6344751   1.0000000
```



## 4.7. 상관관계 분석

> 변수 간의 관련성을 분석하기 위해 사용하는 분석방법. 하나의 변수가 다른 변수와 관련성이 있는지, 있다면 어느 정도의 관련성이 있는지를 개관할 수 있는 분석기법.
>
> 예)  브랜드 인지도의 관련성광고비와 매출액 사이의 관련성 등을 분석하는데 이용한다
>
> - 회귀분석에서 변수 간의 인과관계를 분석하기 전에 변수 간의 관련성을 분석하는 선행자료(가설 검정 전 수행)로 이용한다.
>
> - 변수 간의 관련성은 상관계수인 피어슨(Pearson) R 계수를 이용해 관련성의 유무와 정도를 파악한다.
>
> - 상관관계 분석의 척도인 피어슨 상관계수 R과 상관관계 정도

```R
cor( x, y=NULL, use=“everything”, method=c(“pearson”, “kendall”, “spearman”))

#corrgram() 은 상관계수와 상관계수에 따라서 색의 농도로 시각화해 준다.
#대상 변수가 등간척도 또는 비율척도일 때 피어슨(Pearson) 상관계수를 적용할 수 있다
#서열척도로 구성된 변수에 대해서 상관계수를 구하기 위해서는 spearman을 적용할 수 있다.
```

### 4.7.1. 기본 사용법 및 시각화

```R
result <- read.csv("./data/product.csv", header=TRUE)
#요약 summary, descrive, freq
summary(result)
sd(result$제품_친밀도);sd(result$제품_적절성);sd(result$제품_만족도);
[1] 0.9703446
[1] 0.8596574
[1] 0.8287436

cor(result, method="pearson")
            제품_친밀도 제품_적절성 제품_만족도
제품_친밀도   1.0000000   0.4992086   0.4671450
제품_적절성   0.4992086   1.0000000   0.7668527
제품_만족도   0.4671450   0.7668527   1.0000000

install.packages("corrgram")
library(corrgram)

corrgram(result, upper.panel=panel.conf)
corrgram(result, lower.panel=panel.conf)

```

![1568945854189](assets/1568945854189.png)



### 4.7.2. 상관성, 밀도곡선, 유의확률 시각화

```R
install.packages("PerformanceAnalytics")
library(PerformanceAnalytics)

# 상관성, p값(*), 정규분포 시각화
chart.Correlation(result, histogram=result, pch="+")
```

![1568946082234](assets/1568946082234.png)

## 4.8. 예측 분석 지도학습

### 기계학습

> 알고리즘을 통해서 기계(컴퓨터, 로봇 등)에게 학습을 시킨 후 새로운 데이터가 들어오는 경우 해당 데이터의 결과를 예측하는 학문 분야
>
> 인간과 로봇과의 상호작용, 포털 사이트에서 검색어 자동 완성 기능, 악성 코드 탐지, 문자인식, 기계 오작동으로 인한 사고 발생 가능성 등을 예측하는 분야에서 이용된다.
>
> 데이터를 통해서 반복 학습으로 만들어진 모델을 바탕으로 최적의 판단이나 예측을 가능하게 해주는 것을 목표로 한다
>
> - 지도학습 – 사전에 입력과 출력에 대한 정보를 가지고 있는 상태에서 입력이 들어오는 경우 해당 출력이 나타나는 규칙을 발견(알고리즘 이용) 하고, 만들어진 모델(model)에 의해서 새로운 데이터를 추정 및 예측한다.
>
> - 비지도학습 – 최종적인 정보가 없는 상태에서 컴퓨터 스스로 공통점과 차이점 등의 패턴을 이용해서 규칙을 생성하고, 규칙을 통해서 분석 결과를 도출하는 방식. 비지도학습은 유사한 데이터를 그룹화해주는 군집화와 군집 내의 특성을 나태내는 연관분석 방법에 주로 이용된다  .

### 4.8.1. 단순 회귀분석

> 독립변수와 종속변수가 각각 한 개일 경우 독립변수가 종속변수에 미치는 인과관계 등을 분석하고자 할 때 이용하는 분석 방법.

```R
product <- read.csv("./data/product.csv", header=TRUE)

y <- product$제품_만족도 # 종속 변수
x <- product$제품_적절성 # 독립 변수
df <- data.frame(x, y)

# 단순 선형회귀 모델 생성
result.lm <- lm(y ~ x, data = df)
Coefficients:
(Intercept)            x  
     0.7789       0.7393  
# Y = 0.7789 + 0.7393 * X

# 모델 요약
summary(result.lm)

Call:
lm(formula = y ~ x, data = df)

Residuals:
     Min       1Q   Median       3Q      Max 
-1.99669 -0.25741  0.00331  0.26404  1.26404 

Coefficients:
            Estimate Std. Error t value Pr(>|t|)    
(Intercept)  0.77886    0.12416   6.273 1.45e-09 ***
x            0.73928    0.03823  19.340  < 2e-16 ***
---
Signif. codes:  0 ‘***’ 0.001 ‘**’ 0.01 ‘*’ 0.05 ‘.’ 0.1 ‘ ’ 1

Residual standard error: 0.5329 on 262 degrees of freedom
Multiple R-squared:  0.5881,	Adjusted R-squared:  0.5865 
F-statistic:   374 on 1 and 262 DF,  p-value: < 2.2e-16

# 모델 내부 변수
names(result.lm)
 [1] "coefficients"  "residuals"     "effects"      
 [4] "rank"          "fitted.values" "assign"       
 [7] "qr"            "df.residual"   "xlevels"      
[10] "call"          "terms"         "model"  

fitted.values(result.lm)[1:2]
       1        2 
3.735963 2.996687 

# Y 값 예측
Y <- result.lm$coefficients[1] + result.lm$coefficients[2] * x[1]
3.735963
result.lm$fitted.values[1]
       1 
3.735963

# 오차는 관측값-적합값
3 - 3.735963     #-0.735963

residuals(result.lm)[1:2]  #-0.7359630, -0.9966869


# 관측값 = 잔차(오차)+ 적합값
-0.7359630 + 3.735963    #3

# 선형회귀분석 모델 시각화
#plot(formula= y~x, data=result)
plot(y, result.lm$fitted.values)
abline(result.lm, col="red") #회귀선

# Multiple R-squared:  0.5881 는 독립변수에 의해서 종속변수가 얼마만큼 설명되었는가 (회귀모델의 설명력)
# Multiple R-squared 값은 독립변수와 종속변수 간의 상관관계를 나타내는 결정계수 
# 설명력이 1에 가까울수록 설명변수(독립변수)가 설명을 잘한다고 판단할 수 있습니다. => 변수의 모델링이 잘 되었다는 의미
# Adjusted R-squared:  0.5865은 오차를 감안하여 조정된 R 값으로 (실제 분석은 이 값을 적용합니다.)
# F-statistic:   374 회귀모델의 적합성을 나타내며    
# p-value: < 2.2e-16 
# F-statistic와 p-value를 이용하여 회귀모델 자체를 신뢰할 수 있는지 판단
# p-value가 0.05보다 매우 작기 때문에 회귀선이 모델에 적합하다고 볼 수 있습니다.

# 연구가설 "제품의 가격과 품질을 결정하는 제품 적절성(독립변수)은 제품 만족도(종속변수)에 양의 영향을 미친다" 채택.

```

### 4.8.2. 다중 회귀분석

> 여러 개의 독립변수가 동시에 한 개의 종속변수에 미치는 영향을 분석할 때 이용하는 분석방법.
>
> 다수의 독립변수가 투입되기 때문에 한 독립변수가 다른 독립변수들에 의해서 설명되지 않은 부분을 의미하는 **공차한계(Tolerance)**와 공차한계의 역수로 표시되는 **분산팽창요인(VIF)**으로 다중 공선성에 문제가 없는지를 확인해야 한다.
>
> :point_right: **다중공선성(Multicollinearity) 문제**
>  한 독립변수의 값이 증가할 때 다른 독립변수의 값이 이와 관련하여 증가하거나 감소하는 현상. 대부분 다중회귀분석에서 독립변수들은 어느 정도 상관관계를 보이고 있기 때문에 다중 공선성은 존재하지만, 독립변수들이 강한 상관관계를 보이는 경우는 회귀분석의 결과를 신뢰하기가 어렵다. 상관관계가 높은 독립변수 중 하나 혹은 일부를 제거하거나 변수를 변형시켜서 해결한다.

- 다중 공선성이 없는 예

  ```R
  귀무가설(H0) : 제품의 적절성과 제품의 친밀도는 제품 만족도에 정(正)의 영향을 미치치 않는다
  연구가설(H1) : 제품의 적절성과 제품의 친밀도는 제품 만족도에 정(正)의 영향을 미친다.
  
  product <- read.csv("./data/product.csv", header=TRUE)
  
  y <- product$제품_만족도	 	# 종속변수
  x1 <- product$제품_적절성 	# 독립변수1
  x2 <- product$제품_친밀도	# 독립변수2
  df <- data.frame(x1, x2, y)
  
  # 다중 회귀 분석
  result.lm <-lm(formula= y~x1+x2, data=df)
  
  Call:
  lm(formula = y ~ x1 + x2, data = df)
  
  Coefficients:
  (Intercept)           x1           x2  
      0.66731      0.68522      0.09593  
  
  # 다중 공선성문제 확인
  install.packages("car")
  library(car)
  vif(result.lm)			#분산팽창요인(VIF) - 결과값이 10 이상인 경우에는 다중 공선성 문제를 의심해 볼 수 있다.
        x1       x2 
  1.331929 1.331929 
  -> 없다고 볼 수 있다.
  
  # 다중 회귀 분석 결과 보기
  summary(result.lm)
  
  Call:
  lm(formula = y ~ x1 + x2, data = df)
  
  Residuals:
       Min       1Q   Median       3Q      Max 
  -2.01076 -0.22961 -0.01076  0.20809  1.20809 
  
  Coefficients:
              Estimate Std. Error t value Pr(>|t|)    
  (Intercept)  0.66731    0.13094   5.096 6.65e-07 ***
  x1           0.68522    0.04369  15.684  < 2e-16 ***
  x2           0.09593    0.03871   2.478   0.0138 *  
  ---
  Signif. codes:  0 ‘***’ 0.001 ‘**’ 0.01 ‘*’ 0.05 ‘.’ 0.1 ‘ ’ 1
  
  Residual standard error: 0.5278 on 261 degrees of freedom
  Multiple R-squared:  0.5975,	Adjusted R-squared:  0.5945 
  F-statistic: 193.8 on 2 and 261 DF,  p-value: < 2.2e-16
  
  #해석
  - x1은 제품의 적절성이 제품 만족도에 미치는 영향 t검정통계량 15.684
  - x2는 제품의 친밀도가 제품 만족도에 미치는 영향 t검정통계량 2.478
  - x1, x2의 유의 확률은 0.05보다 작기때문에 제품 만족도에 양의 영향을 미친다는 연구가설을 채택한다.
  - 상관계수(결정계수) 0.5975 다소 높은 상관관계를 나타냄. 설명력윽 59.45%
  - 회귀모델의 적합성 f검정통계량 193.8, p-value < 2.2e-16 : 리즈너블한 모델
  
  ```

- 다중 공선성이 있는 예

  ```R
  # 학습데이터와 검정데이터를 7:3 비율로 샘플링
  # 표본 추출
  # 다중 공선성 문제 해결 – 강한 상관관계를 갖는 독립변수를 제거하여 해결
  # 학습 데이터로부터 회귀모델 생성
  # 검정 통계량 분석하여 가설 검정
  # 검정 데이터를 이용하여 모델의 예측치 생성 – stats패키지의 predict() 
  # 회귀 모델 성능을 평가 – 상관계수를 이용 , 모델의 예측치(pred)와 검정데이터의 종속변수(y)를 이용하여 상관계수(r) 를 구하여 모델의 분류정확도를 평가한다
  
  # 
  iris의 Sepal.Length(꽃받침 길이)를 종속변수로 지정하고 Sepal.Width, Petal.Length, Petal.Width을 독립변수로 ...
  
  # 모델 생성
  fit.o <- lm(formula=Sepal.Length ~ Sepal.Width + Petal.Length + Petal.Width, data=iris)
  
  # 다중공선성 문제 확인
  vif(fit)
   Sepal.Width Petal.Length  Petal.Width 
      1.270815    15.097572    14.234335 
  -> Petal.Length 와 Petal.Width 변수는 강한 상관관계로 인해서 다중공선성 문제가 의심된다.
  
  # 다중공선성 문제가 의심되는 변수의 상관계수 확인
  cor(iris[, -5])
  
  # 학습데이터와 검정 데이터를 7:3 으로 표본 추출
  x <- sample(1:nrow(iris), 0.7*nrow(iris)) #70% 표본 추출, 행번호추출
  train <- iris[x, ] #학습데이터
  test <- iris[-x,] #검정데이터
  
  # Petal.Width 변수를 제거한 후 학습 데이터로부터 회귀모델 생성
  model <- lm(formula=Sepal.Length ~ Sepal.Width + Petal.Length, data=train)
  
  Call:
  lm(formula = Sepal.Length ~ Sepal.Width + Petal.Length, data = train)
  
  Residuals:
      Min      1Q  Median      3Q     Max 
  -0.9659 -0.2175  0.0129  0.2017  0.7257 
  
  Coefficients:
               Estimate Std. Error t value Pr(>|t|)    
  (Intercept)   2.02653    0.29810   6.798 7.31e-10 ***
  Sepal.Width   0.66022    0.08473   7.792 5.75e-12 ***
  Petal.Length  0.48641    0.02007  24.231  < 2e-16 ***
  ---
  Signif. codes:  0 ‘***’ 0.001 ‘**’ 0.01 ‘*’ 0.05 ‘.’ 0.1 ‘ ’ 1
  
  Residual standard error: 0.3264 on 102 degrees of freedom
  Multiple R-squared:  0.8545,	Adjusted R-squared:  0.8517 
  F-statistic: 299.5 on 2 and 102 DF,  p-value: < 2.2e-16
  
  # 해석
  꽃받침의 너비가 꽃받침의 길이에 영향을 미친다.
  꽃잎의 길이가 꽃받침의 길이에 영향을 준다.
  
  
  # 검정데이터에 회귀모델을 적용하여 예측값 생성 후 모델 평가
  head(train, 1) 
  #6.7         3.3          5.7         2.1 virginica 
  #회귀방정식
  Y=2.2491 +  0.5955*3.3 +  0.4719 *5.7
  Y    #회귀모델로부터 계산된 예측값 6.90408
  # 오차 = 예측값 - 관측값 (6.90408 - 6.7 ) 0.20408
  #stats::predict(model, data)
  pred <- predict(model, test) # 예측값 생성
  #모델 평가는 상관계수를 이용하여 모델의 정확도를 평가합니다.
  cor(pred, test$Sepal.Length) 
  [1] 0.8957076
  # 예측치와 실제 관측치는 상관계수가 0.8957076 이므로 매우 높은 상관관계를 보인다고 할 수 있으며 모델의 정확도가 아주 높다고 볼 수 있습니다.
  
  ```

#### 4.8.2.1 회귀분석 연습문제

- 문제 1

  ```R
  #product.csv 파일의 데이터를 이용하여 다음과 같은 단계로 다중회귀분석을 수행하시오.
  product <- read.csv("./data/product2.csv", header=TRUE)
    제품_친밀도 제품_적절성 제품_만족도
  1           3           4           3
  2           3           3           2
  3           4           4           4
  4           2           2           2
  5           2           2           2
  6           3           3           3
  
  단계1 : 학습데이터(train), 검정데이터(test)를 7 : 3 비율로 샘플링
  
  단계2 : 학습데이터 이용 회귀모델 생성
  변수 모델링) y변수 : 제품_만족도, x변수 : 제품_적절성, 제품_친밀도
  
  단계3 : 검정데이터 이용 모델 예측치 생성
  
  단계4 : 모델 평가 : cor() 함수 이용
  
  vif(lm(제품_만족도 ~ 제품_친밀도 + 제품_적절성, data=product))
  제품_친밀도 제품_적절성 
     1.331929    1.331929 
  -> 다중공선성 괜춘
  # 1
  x <- sample(1:nrow(product), 0.7*nrow(product))
  train <- product[x,] #184
  test <- product[-x,] #80
  
  # 2
  model <- lm(제품_만족도 ~ 제품_친밀도 + 제품_적절성, data=train)
  summary(model)
  
  Call:
  lm(formula = 제품_만족도 ~ 제품_친밀도 + 제품_적절성, data = train)
  
  Residuals:
       Min       1Q   Median       3Q      Max 
  -2.01704 -0.23718 -0.01704  0.20309  1.23003 
  
  Coefficients:
              Estimate Std. Error t value Pr(>|t|)    
  (Intercept)  0.67745    0.16199   4.182  4.5e-05 ***
  제품_친밀도  0.12354    0.04950   2.496   0.0135 *  
  제품_적절성  0.65633    0.05587  11.746  < 2e-16 ***
  ---
  Signif. codes:  0 ‘***’ 0.001 ‘**’ 0.01 ‘*’ 0.05 ‘.’ 0.1 ‘ ’ 1
  
  Residual standard error: 0.5518 on 181 degrees of freedom
  Multiple R-squared:  0.5726,	Adjusted R-squared:  0.5678 
  F-statistic: 121.2 on 2 and 181 DF,  p-value: < 2.2e-16
  
  # 3
  pred <- predict(model, test)
  cor(pred, test$제품_만족도)
  [1] 0.8099135
  ```

- 문제 2

  ```R
  02] ggplot2패키지에서 제공하는 diamonds 데이터 셋을 대상으로 carat, table, depth 변수 중 다이아몬드의 가격(price)에 영향을 미치는 관계를 다중회귀 분석을 이용하여 예측하시오.
  조건1) 다이아몬드 가격 결정에 가장 큰 영향을 미치는 변수는?
  조건2) 다중회귀 분석 결과를 양(+)과 음(-) 관계로 해설
  
  #
  diamonds <- ggplot2::diamonds
  dia <- subset(diamonds,T, c(carat, table, depth, price))
  
  fit <- lm(price~carat+table+depth, data=dia)
  vif(fit)
     carat    table    depth 
  1.042039 1.141032 1.104275 
  -> 다중공선성 괜춘
  summary(fit)
  
  Call:
  lm(formula = price ~ carat + table + depth, data = dia)
  
  Residuals:
       Min       1Q   Median       3Q      Max 
  -18288.0   -785.9    -33.2    527.2  12486.7 
  
  Coefficients:
               Estimate Std. Error t value Pr(>|t|)    
  (Intercept) 13003.441    390.918   33.26   <2e-16 ***
  carat        7858.771     14.151  555.36   <2e-16 ***
  table        -104.473      3.141  -33.26   <2e-16 ***
  depth        -151.236      4.820  -31.38   <2e-16 ***
  ---
  Signif. codes:  0 ‘***’ 0.001 ‘**’ 0.01 ‘*’ 0.05 ‘.’ 0.1 ‘ ’ 1
  
  Residual standard error: 1526 on 53936 degrees of freedom
  Multiple R-squared:  0.8537,	Adjusted R-squared:  0.8537 
  F-statistic: 1.049e+05 on 3 and 53936 DF,  p-value: < 2.2e-16
  
  조건1 > carat
  조건2 > carat(양), table(음), depth(음)
  ```

### 4.8.3. 로지스틱 회귀분석

> 종속변수와 독립변수 간의 관계를 예측모델로 생성. 독립변수(x)에 의해서 종속변수(y)의 범주로 분류하는 분류분석 방법.
>
> - 분석 목적 : 종속변수와 독립변수 간의 관계를 통해서 예측모델을 생성 
>
> - 회귀분석과의 차이점 : 종속변수는 반드시 범주형 변수이어야 한다.  (이산형: Yes/No, 다항형: iris의 species 컬럼)
>
> - 정규성 : 정규분포 대신에 이항분포를 따른다.
>
> - 로짓 변환 : 종속변수의 출력범위를 0과 1로 조정하는 과정을 의미한다. (예: 혈액형 A인 경우 -> [1,  0, 0, 0]
>
> - 활용분야 : 의료, 통신, 날씨 등 다양한 분야에서 활용

```R
glm(y ~x, data, family) 

# family의 ‘binormial’은 y변수가 이항형인 경우 지정
# x 변수의 유의성 검정을 제공하지만, F 검정 통계량과 모델의 설명력은 제공되지 않는다
```

- 사용예

  ```R
  weather <- read.csv("./data/weather.csv", stringsAsFactors=F)
  dim(weather)
  [1] 366  15
  
  weather_df <- weather[, c(-1, -6, -8, -14)]
  
  #y 변수(RainTomorrow)의 로짓변환: (0, 1)로 생성
  weather_df$RainTomorrow[weather_df$RainTomorrow == 'Yes'] <- 1
  weather_df$RainTomorrow[weather_df$RainTomorrow == 'No'] <- 0
  weather_df$RainTomorrow <- as.numeric(weather_df$RainTomorrow)
  
  # 학습 데이터와 검정데이터 생성(7:3)
  idx <- sample(1:nrow(weather_df), nrow(weather_df)*0.7)
  train <- weather_df[idx, ] #[1] 256
  test <- weather_df[-idx, ] #[1] 110
  
  # 학습 데이터로부터 로지스틱 회귀모델 생성
  weather_model <- glm(RainTomorrow ~ ., data=train, family='binomial')
  summary(weather_model)
  
  Call:
  glm(formula = RainTomorrow ~ ., family = "binomial", data = train)
  
  Deviance Residuals: 
       Min        1Q    Median        3Q       Max  
  -2.05179  -0.43237  -0.23596  -0.09585   2.63968  
  
  Coefficients:
                 Estimate Std. Error z value Pr(>|z|)   
  (Intercept)   123.73064   48.30788   2.561  0.01043 * 
  MinTemp        -0.16704    0.07911  -2.112  0.03472 * 
  MaxTemp         0.08878    0.22481   0.395  0.69290   
  Rainfall       -0.00644    0.04801  -0.134  0.89329   
  Sunshine       -0.28328    0.11607  -2.441  0.01466 * 
  WindGustSpeed   0.08178    0.02780   2.942  0.00326 **
  WindSpeed      -0.06399    0.03727  -1.717  0.08600 . 
  Humidity        0.07458    0.02865   2.604  0.00922 **
  Pressure       -0.13172    0.04673  -2.819  0.00482 **
  Cloud           0.17518    0.12478   1.404  0.16034   
  Temp            0.17242    0.24169   0.713  0.47561   
  ---
  Signif. codes:  0 ‘***’ 0.001 ‘**’ 0.01 ‘*’ 0.05 ‘.’ 0.1 ‘ ’ 1
  
  (Dispersion parameter for binomial family taken to be 1)
  
      Null deviance: 248.27  on 251  degrees of freedom
  Residual deviance: 138.52  on 241  degrees of freedom
    (4 observations deleted due to missingness)
  AIC: 160.52
  
  Number of Fisher Scoring iterations: 6
   
  # 로지스틱 회귀모델 예측치 생성
  pred <- predict(weather_model, newdata=test, type="response")  
  #response는 예측결과를 0~1사이의 확률값으로 예측치를 반환
   
  pred    # 예측치가 1에 가까울수록 비율 확률이 높다고 할 수 있다
  #예측치를 이항형으로 변환 : 0.5이상이면 1, 0.5미만이면 0
  result_pred <- ifelse(pred >=0.5, 1, 0)
  table(result_pred)
  table(result_pred, test$RainTomorrow)
              
  result_pred  0  1
            0 81  9
            1  5 12
  #분류 정확도
    (81+12) / (81+12+9+5)
  [1] 0.8691589
  ```

- ROC Curve 를 이용한 모델 평가

  ```R
  install.packages("ROCR")
  library(ROCR)
  
  pr <- prediction(pred, test$RainTomorrow)
  prf <- performance(pr, measure="tpr", x.measure="fpr")
  plot(prf)
  
  #왼쪽 상단의 계단모양의 빈 공백만큼이 분류 정확도에서 오분류(missing)를 나타낸다.
  ```

 ![1568966436705](assets/1568966436705.png)

### 4.8.4. 분류 분석

>다수의 변수를 갖는 데이터 셋을 대상으로 특정 변수의 값을 조건으로 지정하여 데이터를 분류하고 트리 형태의 모델을 생성하는 분석 방법. 고객을 분류하는 변수, 규칙, 특성을 찾아내고 이를 토대로 미래 잠재 고객의 행동이나 반응을 예측하거나 유도하는데 활용된다.
>
>- 의사결정트리(Decision Tree)
>
>- 랜덤 포레스트(Random Forest)
>
>- 인공신경망(Artificial Neural Network)
>
>예) 대출 은행에서 기존 고객들의 데이터를 활용하여 신용상태의 분류모델을 생성한 후 새로운 고객에 대하여 향후 신용상태를 예측하는 데 이용한다( 분류 모델 생성 규칙 : 기존 체납횟수, 대출금과 현재 고객의 수입 비율, 대출 사유 등).
>
>예) 과거의 환자들에 대한 종양 검사의 결과를 바탕으로 종양의 악성 또는 양성 여부를 분류하는 모델을 생성하여 새로운 환자에 대한 암을 진단하는데 이용( 분류 조건 : 종양의 크기, 모양, 색깔).

- 분류분석의 특징

  - Y 변수 존재 : 설명변수(x 변수)와 반응변수(y 변수)가 존재한다.

  - 의사결정트리 : 분류 예측모델에 의해서 의사결정트리 형태로 데이터가 분류된다.

  - 비모수 검정 : 선형성, 정규성, 등분산성 가정이 필요 없다

  - 추론 기능 : 유의수준 판단 기준이 없다(추론 기능 없음)

  - 활용분야 : 이탈고객과 지속고객 분류, 신용상태의 좋고, 나쁨, 번호이동고객과 지속 고객 분류 등

- 분류분석 절차

  1. 학습 데이터 생성
  2. 분류 알고리즘을 통해 예측 모델 생성
  3. 검정 데이터를 통해 분류규칙의 모델 평가(모형 평가)
  4. 새로운 데이터에 적용하여 결과 예측

:point_right: 모형평가

>어떤 모형이 random하게 예측하는 모형보다 예측력이 우수한지, 고려된 여러 모형 중 어느 모형이 가장 좋은 예측력을 보유하고 있는지를 비교/분석하는 과정.

#### 4.8.4.1. 의사결정 트리(Decision Tree)

> 나무(Tree) 구조 형태로 분류결과를 도출. 입력변수 중 가장 영향력 있는 변수를 기준으로 이진분류하여 분류 결과를 나무 구조 형태로 시각화한다. 비교적 모델 생성이 쉽고, 단순, 명료하여 현업에서 많이 사용되는 지도학습 모델.
>
> 의사결정규칙을 도표화 하여 분류와 예측을 수행하는 분석방법
>
> - `party` 패키지 `ctree()`
>
> - `rpart` 패키지`rpart()`

```
install.packages("party")
library(party)
library(datasets)

# ctree() 결과 해석
- 첫번째 번호는 반응변수(종속변수)에 대해서 설명변수(독립변수)가 영향을 미치는 중요 변수의 척도를 나타내는 수치로서 수치가 작을 수록 영향을 미치는 정도가 높고, 순서는 분기되는 순서를 의미한다.
- 두번째는 의사결정 트리의 노드명 (노드 번호 뒤에 * 기호가 오면 해당 노드가 마지막 노드를 의미)
- 노드명 뒤에 해당 변수의 임계값이 조건식으로 온다
- 세번째는 노드의 분기 기준(criterion)이 되는 수치
- 네번째는 반응변수(종속변수)의 통계량(statistic)이 표시된다. 

```

- `ctree()`

  ```R
   1)  Ozone <= 37; criterion= 1, statistic=56.086
  ```

  > 첫번째 번호는 반응변수(종속변수)에 대해서 설명변수(독립변수)가 영향을 미치는 중요 변수의 척도를 나타내는 수치로서 수치가 작을 수록 영향을 미치는 정도가 높고, 순서는 분기되는 순서를 의미한다.
  >
  > 두번째는 의사결정 트리의 노드명(노드 번호 뒤에 * 기호가 오면 해당 노드가 마지막 노드를 의미),  노드명 뒤에 해당 변수의 임계값이 조건식으로 온다.
  >
  > 세번째는 노드의 분기 기준(criterion)이 되는 수치.
  >
  > 네번째는 반응변수(종속변수)의 통계량(statistic)이 표시된다. 

  ```R
  # 뉴욕의 대기 질을 측정한 데이터 셋
  str(airquality)
  # 온도에 영향을 미치는 변수를 알아보기
  formula <- Temp~Solar.R+Wind+Ozone
  # 분류모델 생성
  air_ctree <- ctree(formula, data=airquality)
  plot(air_ctree)
  #온도에 가장 큰 영향을 미치는 첫번째 영향변수는 Ozone
  # 두번째 영향변수는 Wind
  # 오존량 37이하이면서 바람의 양이 15.5이상이면 평균온도는 63정도에 해당
  #바람의 양이 15.5이하인 경우 평균 온도는 70이상으로 나타남
  #태양광은 온도에 영향을 미치지 않는 것으로 분석됨
  ```

  ![1569199213661](assets/1569199213661.png)

- iris  데이터 셋으로 분류 분석 수행

  ```R
  set.seed(1234) # 시드 값을 적용하면 랜덤 값이 동일하게 생성
  idx <- sample(1:nrow(iris), nrow(iris)*0.7)
  train <- iris[idx, ] # 학습 데이터
  test <- iris[-idx, ] # 검정 데이터
  
  # 종속 변수는 Species, 독립 변수는 나머지...
  formula <- Species ~ Sepal.Length + Sepal.Width + Petal.Length + Petal.Width
  iris_ctree <- ctree(formula, data=train)
  plot(iris_ctree, type="simple")
  plot(iris_ctree)
  ```

  ![1569199991449](assets/1569199991449.png)

  ![1569199891335](assets/1569199891335.png)

  ```R
  # 분류모델 평가 - 예측치 생성, 혼돈 매트릭스 생성
  pred <- predict(iris_ctree, test)
  table(pred, test$Species)
  
  pred         setosa versicolor virginica
    setosa         12          0         0
    versicolor      0         18         1
    virginica       0          1        13
  
  # 분류 정확도
  (12 + 18 + 13) / ((12 + 18 + 13) + 1 + 1)
  [1] 0.9555556
  ```

- `rpart()`

  > 재귀분할(recursive partitioning). 2수준 요인으로 분산분석을 실행한 결과를 트리 형태로 제공하여 모형을 단순화. 전체적인 분류기준을 쉽게 분석할 수 있는 장점이 있다

  ```R
  install.packages("rpart")
  library()
  
  iris.rpart <- rpart(Species ~ ., data=iris)
  plot(iris.rpart)
  text(iris.rpart, use.n=T, cex=0.6)
  post(iris.rpart, file="")
  ```
```
  
  ![1569206931627](assets/1569206931627.png)

#### 4.8.4.2. k겹 교차 검증(k-fold cross validataion)

> 테스트를 더 정확하게 설정할수록 세상으로 나왔을 때 더 잘 작동한다고 할 수 있다. 딥러닝 혹은 머신러닝 작업을 할 때 늘 어려운 문제 중 하나는 알고리즘을 충분히 테스트하였어도 데이터가 충분치 않으면 좋은 결과를 내기가 어렵다.
>
> 데이터의 약 70%를 학습셋으로 써야 했으므로 테스트셋은 겨우 전체 데이터의 30%에 그쳤습니다. 이 정도 테스트만으로는 실제로 얼마나 잘 작동하는지 확신하기는 쉽지 않습니다.
>
> k겹 교차 검증(k-fold cross validation)  - 테스트 데이터 충분하지 않을 경우  단점을 보완하고자 만든 방법.
>
> k겹 교차 검증이란 데이터셋을 여러 개로 나누어 하나씩 테스트셋으로 사용하고 나머지를 모두 합해서 학습셋으로 사용하는 방법입니다. 이렇게 하면 가지고 있는 데이터의 100%를 테스트셋으로 사용할 수 있다.

​```R
install.packages("cvTools")
library(cvTools)
```

- 사용법

  ```R
  # 3겹, 2회 반복을 위한 샘플링
  cross <- cvFolds(nrow(iris), K=3, R=2)
  str(cross)
  List of 5
   $ n      : num 150
   $ K      : num 3
   $ R      : num 2
   $ subsets: int [1:150, 1:2] 58 146 130 36 78 79 30 57 14 42 ...
   $ which  : int [1:150] 1 2 3 1 2 3 1 2 3 1 ...
   - attr(*, "class")= chr "cvFolds"
  
  cross # 교차검정 데이터 확인
  length(cross$which)
  dim(cross$subsets)
  table(cross$which)
  
  R <- 1:2				#2회 반복
  K <- 1:3				#3겹
  CNT <- 0				#카운트 변수
  ACC <- numeric()		#정확도 저장
  for(r in R) {
      cat("\n R=", r, "\n")
      for(k in  K) {
          datas_idx <- cross$subsets[cross$which == k, r]
          test <- iris[datas_idx, ] 	#테스트 데이터 생성
          cat("test: ", nrow(test), "\n")
          
          formula <- Species ~ .
          train <- iris[-datas_idx, ] #훈련 데이터 생성
          cat("train: " , nrow(train), "\n")
          
          model <- ctree(formula, data=train)
          pred <- predict(model, test)
          t <- table(pred, test$Species)
          print(t)	#혼돈 매트릭스
          CNT <- CNT+1
          ACC[CNT] <- (t[1,1] + t[2,2] + t[3,3]) / sum(t)
      }
  }
  
   R= 1 
  test:  50 
  train:  100 
              
  pred         setosa versicolor virginica
    setosa         16          0         0
    versicolor      1         13         3
    virginica       0          0        17
  test:  50 
  train:  100 
              
  pred         setosa versicolor virginica
    setosa         12          0         0
    versicolor      0         16         0
    virginica       0          5        17
  test:  50 
  train:  100 
              
  pred         setosa versicolor virginica
    setosa         21          0         0
    versicolor      0         16         2
    virginica       0          0        11
  
   R= 2 
  test:  50 
  train:  100 
              
  pred         setosa versicolor virginica
    setosa         22          0         0
    versicolor      0         11         2
    virginica       0          1        14
  test:  50 
  train:  100 
              
  pred         setosa versicolor virginica
    setosa         12          0         0
    versicolor      2         18         1
    virginica       0          1        16
  test:  50 
  train:  100 
              
  pred         setosa versicolor virginica
    setosa         14          0         0
    versicolor      0         19         1
    virginica       0          0        16
  ```

- 

#### 4.8.4.2. 랜덤 포레스트(Random Forest)

> 의사결정트리에서 파생된 앙상블 학습기법을 적용한 모델.
>
> :point_right: **앙상블 학습 기법** – 새로운 데이터에 대해서 여러 개의 트리(Forest)로 학습을 수행한 후 학습 결과들을 종합해서 예측하는 모델
>
> 기존의 의사결정트리 방식에 비해서 많은 데이터를 이용하여 학습을 수행하기 때문에 비교적 예측력이 뛰어나고, 과적합(overfitting)문제를 해결할 수 있다.
>
> :point_right: **과적합 문제** – 작은 데이터 셋은 높은 정확도가 나타나지만 큰 데이터셋에서는 정확도가 떨어지는 현상을 의미

```R
install.packages("randomForest")
library(randomForest)

randomForest(formula, data, ntree, mtry, na.action, importance)
# formula : y~x 형식으로 반응변수와 설명변수 식
# data : 모델 생성에 사용될 데이터 셋
# ntree :  복원추출하여 생성할 트리 수 지정
# mtry : 자식 노드를 분류할 변수 수 지정
# na.action :  결측치를 제거할 함수 지정
# importance : 분류모델 생성과정에서 중요 변수 정보 제공 여부
```

- 사용법

  ```R
  model <- randomForest(Species ~ ., data=iris)
  
  Call:
   randomForest(formula = Species ~ ., data = iris) 
                 Type of random forest: classification
                       Number of trees: 500
  No. of variables tried at each split: 2
  
          OOB estimate of  error rate: 4%
  Confusion matrix:
             setosa versicolor virginica class.error
  setosa         50          0         0        0.00
  versicolor      0         47         3        0.06
  virginica       0          3        47        0.06
  
  #Number of trees는 학습 데이터(Forest)로 복원 추출 방식으로 500개 생성했다는 의미
  #No. of variables tried at each split 는 두 개의 변수를 이용하여 트리의 자식노드가 분류되었다는 의미 (ntree:500, mtry:2)
  #error.rate 는 모델의 분류정확도 오차 비율을 의미
  #Confusion matrix (혼돈 매트릭스)..
  #분류정확도는 96%
  
  model2 <- randomForest(Species ~ ., ntree=300, mtry=4, na.action=na.omit, data=iris)
  #기타 상세 내용은 달랐지만 분류 정확도는 같았다...(운 좋네)
  
  #importance 지정
  model3 <- randomForest(Species ~ ., data=iris, importance=T, na.action=na.omit)
  importance(model3)
  #MeanDecreaseAccuradcy - 뷴류정확도를 개선하는데 기여한 변수를 수치로 제공
                  setosa versicolor virginica MeanDecreaseAccuracy
  Sepal.Length  6.972097  8.6546112 10.085917            12.296991
  Sepal.Width   4.512992  0.7818947  5.658765             5.893971
  Petal.Length 22.326427 33.9283299 28.806875            34.388893
  Petal.Width  22.119868 31.5914369 30.029549            33.386348
               MeanDecreaseGini
  Sepal.Length        11.220174
  Sepal.Width          2.681371
  Petal.Length        42.283659
  Petal.Width         43.087845
  
  #최적의 ntree, mtry 수치값 찾아내기
  ntree <- c(400, 500, 600)
  mtry <- c(2:4)
  param <- data.frame(n=ntree, m=mtry)
  
  for(i in param$n) {
      cat("ntree=", i, "\n")
      for(j in param$m) {
          cat("\tmtry=", j, "\n")
          model_iris <- randomForest(Species ~., data=iris, ntree=i, mtry=j, na.action=na.omit)
          cat("\t\t",  mean(model_iris$err.rate), "\n")
          #print(model_iris)
      }
  }
  
  ```

#### 4.8.4.3. 분류분석 연습문제

- 1번

  ```R
  # ggplot2::mpg 데이터 셋
  mpg <- ggplot2::mpg
  mpg$drv <- factor(mpg$drv)
  # model(모델), displ(엔진 크기), cyl(실린더 수), drv(구동 방식)
  # 종속변수 : 고속도로 주행거리(hwy)
  idx <- sample(1:nrow(mpg), nrow(mpg)*0.7)
  train <- mpg[idx, ]
  test <- mpg[-idx, ]
  
  formula <- hwy ~ displ + cyl + drv
  mpg_ctree <- ctree(formula, data=train)
  pred <- predict(mpg_ctree, test)
  plot(mpg_ctree)
  
  #분석 결과 : 엔진 크기가 작으면서 전륜구동(f)이나 후륜(r) 구동 방식인 경우 고속도로 주행거리가 가장 좋고, 
  #엔진 크기가 크고, 사륜구동 방식이면 실린더 수가 많은 경우 고속도로 주행거리가 적은 것으로 분석된다.
  ```

- 2번

  ```R
  install.packages("arules")
  library(arules)
  data("AdultUCI")
  #성인 대상 인구 소득에 관한 설문 조사 데이터
  #48,842 관측치와 15개변수
  #age, workclass(직업 :4개), education(교육수준: 16개), marital-status(결혼상태: 6개), occupation(직업:12개), relationship(관계: 6개), race(인종:아시아계, 백인), sex(성별), capital-gain(자본이득), capital-loss(자본손실), fnlwgt(미지의 변수), hours-per-week(주당 근무시간), native-country(국가), income(소득)
  
  idx <- sample(nrow(AdultUCI), 10000)
  adt <- AdultUCI[idx, c("capital-gain", "hours-per-week", "education-num", "race", "age", "income")]
  adt <- adt[!is.na(adt$income), ]
  colnames(adt)[1] <- "capital"
  
  formula <- capital ~ .
  income.ctree <- ctree(formula, data=adt)
  plot(income.ctree)
  
  #분석결과 : 자본이득(capital)에 가장 큰 영향을 미치는 변수는 income이고, 두번째는 education 변수이다. 수입이 많고 교육수준이 높을수록 자본이득이 많은 것으로 분석된다.
  
  #추가
  #분류 모델의 조건에 맞는 subset 생성
  adultResult <- subset(adult_df, adult_df$income=='large' &  adult_df$education > 14)
  length(adultResult$education)
  summary(adultResult$capital) 
  boxplot(adultResult$capital)
  
  #income이 large이고 education이 14를 초과한 경우, 
  자본이득 평균은 7,170
  
  ```

- 3번

  ```R
  weather <- read.csv("./data/weather.csv", header=T)
  #RainTomorrow 컬럼을 종속변수로
  #날씨 요인과 관련없는 Date와 RainToday컬럼을 제외한 나머지 변수를 x변수로 지정하여 분류 모델 생성하고
  # 
  
  weather$Date <- NULL
  weather$RainToday <- NULL
  idx <- sample(1:nrow(weather), 0.7*nrow(weather))
  train <- weather[idx, ]
  test <- weather[-idx, ]
  
  w.ctree <- ctree(RainTomorrow ~ ., data=train)
  w.rpart <- rpart(RainTomorrow ~ ., data=train)
  
  # ctree 결과 확인
  plot(w.ctree)
  # rpart 결과 확인
  plot(w.rpart)
  text(w.rpart, use.n=T, cex=0.6)
  post(w.rpart, file="")
  
  # 모범 답안
  weather.df <- rpart(RainTomorrow ~ ., data=weather[, c(-1, -14)], cp=0.01) 
  X11()
  plot(weather.df)
  text(weather.df, use.n=T, cex=0.7)
  #분석 결과 : 분기조건이 True이면 왼쪽으로 분류되고, False
  이면 오른쪽으로 분류된다.
  #rpart()함수의 cp속성값을 높이면 가지 수가 적어지고, 낮추면 가지 수가 많아진다. cp 기본값은 0.01
  
  weather_pred <- predict(weather.df , weather)
  weather_pred
  
  #y의 범주로 코딩 변환 : Yes(0.5이상), No(0.5미만)
  #rpart의 분류모델 예측치는 비 유무를 0~1사이의 확률값으로 예측하다 
  # 혼돈매트릭스를 이용하여 분류정확도를 구하기 위해 범주화 코딩 변경
  weather_pred2 <- ifelse(weather_pred[,2] >= 0.5, 'Yes', 'No')
  table(weather_pred2, weather$RainTomorrow)
               
  weather_pred2  No Yes
            No  278  13
            Yes  22  53
  (278 + 53) / sum(table(weather_pred2))
  [1] 0.9043716
  ```

  ![1569212684808](assets/1569212684808.png)

- 4번

  ```R
  # mpg 데이터 셋을 대상으로 7:3 비율로 학습데이터와 검정데이터로 각각 샘플링한 후
  각 단계별로 분류분석을 수행하시오.
  조건) 변수모델링 : x변수(displ + cyl + year), y변수(cty)
  
  단계1 : 학습데이터와 검증데이터 샘플링
  단계2 : formula 생성
  단계3 : 학습데이터에 분류모델 적용
  단계4 : 검정데이터에 분류모델 적용 
  단계5 : 분류분석 결과 시각화 
  단계6 : 분류분석 결과 해설 
  
  
  mpg <- ggplot2::mpg
  idx <- sample(1:nrow(mpg), nrow(mpg) * 0.7)
  train <- mpg[idx, ]
  test <- mpg[-idx, ]
  
  formula <- cty ~ displ + cyl + year
  mpg_ctree <- ctree(formula, data=train)
  mpg_pred <- predict(mpg_ctree, test)
  plot(mpg_pred, test$cty)
  
  #실린더 수가 적고, 엔진크기가 작으면서 1999년형 이전모델이 시내 연비가 좋다.
  
  ### 모법 답안
  단계1 : 학습데이터와 검정 데이터 생성
  idx <- sample(1: nrow(mpg), nrow(mpg) * 0.7)
  train <- mpg[idx, ] # 학습데이터
  dim(train)
  test <- mpg[-idx, ] # 검정데이터
  dim(test)
  
  단계2 : formula 생성
  # 도시 주행마일수 <- 실린더, 엔진크기, 제조년도 
  formula <- cty ~ displ + cyl + year
  
  단계3 : 학습데이터에 분류모델 적용
  mpg_train <- ctree(formula, data=train)
  
  단계4 : 검정데이터에 분류모델 적용
  mpg_test <- ctree(formula, data=test)
  
  단계5 : 분류분석 결과 시각화
  plot(mpg_test)
  
  단계6 : 분류분석 결과 해설
  실린더가 5이하이면 엔진크기에 의해서 23개가 분류되고, 실린더가 5이상이고,
  6이하이면 27개가 분류되고, 6을 초과한 경우 21개가 분류된다.
  ```

  ![1569222357995](assets/1569222357995.png)

- 5번

  ```R
  weather 데이터를 이용하여 다음과 같은 단계별로 분류분석을 수행하시오.
  조건1) rpart() 함수 이용 분류모델 생성
  조건2) 변수 모델링 :
  y변수(RainTomorrow), x변수(Date와 RainToday 변수 제외한 나머지 변수)
  조건3) 비가 올 확률이 50% 이상이면 ‘Yes Rain’, 50% 미만이면 ‘No Rain’으로 범주화
  
  단계1 : 데이터 가져오기
  library(rpart)
  weather = read.csv("./data/weather.csv", header=TRUE)
  단계2 : 데이터 샘플링 
  단계3 : 분류모델 생성 
  단계4 : 예측치 생성 : 검정데이터 이용 
  단계5 : 예측 확률 범주화('Yes Rain', 'No Rain')
  단계6 : 혼돈 행렬(confusion matrix) 생성 및 분류정확도 구하기 
  
  # 맞는지는 모르겠지만...
  weather$Date <- NULL
  weather$RainToday <- NULL
  idx <- sample(1:nrow(weather), 0.7*nrow(weather))
  train <- weather[idx, ]
  test <- weather[-idx, ]
  
  w.rpart <- rpart(RainTomorrow ~ ., data=train)
  w.pred <- predict(w.rpart, test)
  w.pred.rain<- ifelse(w.pred[, 2] >= 0.5, "yes", "no")
  chaos.t <- table(w.pred.rain, test$RainTomorrow)
  chaos.t          
  w.pred.rain No Yes
          no  83  16
          yes  6   5
  #분류 정확도
  (82 + 11) / sum(chaos.t)
  [1] 0.8454545
  # 84.54%
  
  ### 모범 답안
  단계1 : 데이터 가져오기
  library(rpart)
  weather = read.csv("./data/weather.csv", header=TRUE)
  
  단계2 : 데이터 샘플링
  weather.df <- weather[, c(-1,-14)]
  nrow(weather.df)
  idx <- sample(1:nrow(weather.df), nrow(weather.df)*0.7)
  weather_train <- weather.df[idx, ]
  weather_test <- weather.df[-idx, ]
  
  단계3 : 분류모델 생성
  weather_model <- rpart(RainTomorrow ~ ., data = weather.df)
  weather_model # Humidity 중요변수
  
  단계4 : 예측치 생성 : 검정데이터 이용
  weater_pred <- predict(weather_model, weather_test)
  weater_pred
  
  단계5 : 예측 확률 범주화('Yes Rain', 'No Rain')
  weater_class <- ifelse(weater_pred[,1] >=0.5, 'No Rain', 'Rain')
  
  단계6 : 혼돈 행렬(confusion matrix) 생성 및 분류정확도 구하기
  table(weater_class, weather_test$RainTomorrow)
  
  weater_class No Yes
  No Rain 83 6
  Rain 2 19
  (83 + 19) / nrow(weather_test)
  [1] 0.9272727
  ```
### 4.8.5. 인공신경망(Artificial Neural Network)

> 인간의 두뇌 신경(뉴런)들이 상호작용하여 경험과 학습을 통해서 패턴을 발견하고,  발견된 패턴을 통해서 특정 사건을 일반화하거나 데이터를 분류하는데 이용되는 기계학습 방법
>
> 인간의 개입 없이 컴퓨터가 스스로 인지하고 추론, 판단하여 사물을 구분하거나 특정 상황의 미래를 예측하는데 이용될 수 있는 기계학습 방법
>
> 문자, 음성, 이미지 인식, 증권시장 예측, 날씨 예보 등 다양한 분야에서 활용
>
> 예) 구글의 알파고(딥러닝)

:point_right: :link: [모두의 딥러닝](https://thebook.io/006958/)

#### 4.8.5.1. `nnet`

```R
install.packages("nnet")
library(nnet)
```

- 사용법

  ```R
  # x1, x2 는 입력변수, y는 출력변수로 사용할 데이터 프레임 생성
  df <- data.frame(x2 = c(1:6), x1=c(6:1), y=factor(c("no", "no", "no", "yes", "yes", "yes")))
    x2 x1   y
  1  1  6  no
  2  2  5  no
  3  3  4  no
  4  4  3 yes
  5  5  2 yes
  6  6  1 yes
  
  # 인공신경망 모델 생성
  model_net <- nnet(y ~ ., df, size=1)
  #weights:  5
  initial  value 4.269373 
  iter  10 value 0.013520
  final  value 0.000091 
  
  # 모델 내용 확인
  model_net
  a 2-1-1 network with 5 weights
  inputs: x2 x1 
  output(s): y 
  options were - entropy fitting 
  #신경망 2-1-1 입력변수-은닉층-출력변수 형태로 5개의 가중치
  
  # 요약 확인
  summary(model_net)
  a 2-1-1 network with 5 weights
  options were - entropy fitting 
   b->h1 i1->h1 i2->h1 
    0.12 -15.34  14.47 
    b->o  h1->o 
   10.64 -22.60 
  #입력층의 경계값(b) 1개와 입력변수(i1,i2) 2개가 은닉층(h1)으로 연결
  #은닉층 경계값(b) 1개와 은닉층의 결과값 1개가 출력층으로 연결되는 구조.
  
  # 분류 모델의 적합값
  model_net$fitted.values
            [,1]
  1 6.396889e-06
  2 6.396889e-06
  3 6.397806e-06
  4 9.999762e-01
  5 9.999762e-01
  6 9.999762e-01
  
  # 분류 모델의 예측치 생성, 정확도 확인
  # type="class"는 예측 결과를 출력변수 y의 범주에 해당하는('no', 'yes')루 분류
  p <- predict(model_net, df, type="class")
  table(p, df$y)
       
  p     no yes
    no   3   0
    yes  0   3
  #졸라 좋음
  ```

- iris 데이터로 성능 테스트

  ```R
  idx <- sample(1:nrow(iris), nrow(iris)*0.7)
  train <- iris[idx, ] # 학습 데이터
  test <- iris[-idx, ] # 검정 데이터
  
  model_net_iris <- nnet(Species ~ ., train, size=1)
  #은닉층 1개, 11개의 가중치, 출력값 1(범주 3)
  
  model_net_iris3 <- nnet(Species ~ ., train, size=10)
  #은닉층 3개, 27개의 가중치, 출력값 1(범주 3)
  
  # 입력변수의 값들이 일정하지 않으면 과적합(overfitting)을 피하기 위해 정규화 과정을 거쳐야 한다. -> 나중에 해보자
  
  #가중치 확인
  summary(model_net_iris)
  summary(model_net_iris3)
  
  #분류모델의 정확도 평가
  pred1 <- predict(model_net_iris, test, type="class")
  table(pred1, test$Species)
  (20 + 13 + 8) / sum(table(pred1, test$Species))
  
  pred3<- predict(model_net_iris3, test, type="class")
  table(pred3, test$Species)
  (20 + 13 + 8) / sum(table(pred1, test$Species))
  ```

#### 4.8.5.2. `neuralnet`

> neuralnet 패키지는 역전파(Backpropagation) 알고리즘을 적용할 수 있고, 가중치 망을 시각화하는 기능도 제공.
>
> 출력변수(y)는 ‘yes’, ‘no’ 형태의 문자열이 아닌 1과 0의 수치형 이여야 한다.

```R
install.packages("neuralnet")
library(neuralnet)

neuralnet(formula, data, hidden=1, threshold=0.01, stepmax=1e+05, rep=1, startweights = NULL, learnningrate=NULL, algorithm=“rprop+”)
```

- iris 데이터에 적용해보기

  ```R
  idx <- sample(1:nrow(iris), 0.7*nrow(iris))
  training <- iris[idx, ]
  testing <- iris[-idx, ]
  
  #범주형을 수치형으로 바꾼다
  training$Species2[training$Species=="setosa"] <- 1
  training$Species2[training$Species=="versicolor"] <- 2
  training$Species2[training$Species=="virginica"] <- 3
  testing$Species2[testing$Species=="setosa"] <- 1
  testing$Species2[testing$Species=="versicolor"] <- 2
  testing$Species2[testing$Species=="virginica"] <- 3
  
  training$Species <- NULL
  testing$Species <- NULL
  
  # 정규화 함수를 이용하여 학습데이터와 검정데이터를 정규화
  normal <- function(x) {
      return ( x-min(x) ) / ( max(x)-min(x) )
  }
  training_nor <- as.data.frame(lapply(training, normal))
  summary(training_nor)
  
  testing_nor <- as.data.frame(lapply(testing, normal))
  summary(testing_nor)
  
  # 인공신경망 분류 모델 생성
  model_net <- neuralnet(Species2 ~ Sepal.Length + Sepal.Width + Petal.Length + Petal.Width, data= training_nor, hidden=1)
  model_net
  plot(model_net)
  
  #분류모델 정확도(성능) 평가
  model_result <- compute(model_net, testing_nor[c(1:4)])
  model_result$net.result
  
  #상관관계분석: 상관계수로 두 변수 간의 선형관계의 강도 측정
  #예측된 꼭 종류와 실제 관측치 사이의 상관관계 측정
  cor(model_result$net.result, testing_nor$Species2)
  
  #은닉층 2개
  model_net2 <-neuralnet(Species2 ~ Sepal.Length + Sepal.Width + Petal.Length + Petal.Width, data= training_nor, hidden=2)
  model_net2
  plot(model_net2)
  
  #분류모델 정확도(성능) 평가
  model_result2 <- compute(model_net, testing_nor[c(1:4)])
  model_result2$net.result
  cor(model_result2$net.result, testing_nor$Species2)
  ```
  
  ![1569220737986](assets/1569220737986.png)

## 4.9. 비지도학습(unSupervised Learning)

> 데이터에 의한 학습을 통해 최적의 판단이나 예측을 가능하게 해주는 기계학습 방법의 하나로 어떤 입력에 대해서 어떤 결과가 출력되는지 사전지식이 없는 상태에서 컴퓨터 스스로 공통점과 차이점 등의 패턴을 찾아서 규칙(rule)을 생성하고, 분석 결과를 도출해내는 방식.
>
> Y 변수(종속변수, 정답)가 없기 때문에 검정 데이터를 이용하여 모델을 평가할 수 없다
>
> 군집분석, 연관분석 등이 이에 해당한다.

### 4.9.1. 군집분석(Cluster Analysis)

> 데이터 간의 유사도를 정의하고 그 유사도에 가까운 것부터 순서대로 합쳐 가는 방법으로 그룹(군집)을 형성한 후 각 그룹의 성격을 파악하거나 그룹 간의 비교분석을 통해서 데이터 전체의 구조에 대한 이해를 돕고자 하는 탐색적 분석 방법.
>
> 유사도 거리(distance)를 이용 – 유클리디안(Euclidean) 거리도 측정한 거리정보를 이용해서 분석 대상을 몇 개의 집단으로 분류한다. 
>
> 군집분석에 의해서 그룹화된 군집은 변수의 특성이 그룹 내적으로는 동일하고, 외적으로는 이질적인 특성을 갖는다.
>
> 용도 – 고객의 충성도에 따라서 몇 개의 그룹으로 분류하고, 그룹별로 맞춤형 마케팅 및 프로모션 전략을 수립하는데 활용된다.
>
> - 군집화를 위해서 거리 측정에 사용되는 변인은 **비율척도**나 **등간척도**이어야 한다.
> - 군집분석에 사용되는 입력 자료는 변수의 측정단위와 관계없이 그 차이에 따라 일정하게 거리를 측정하기 때문에 변수의 **표준화**를 요구한다.
> - 군집화 방법에 따라 **계층적 군집분석**과 **비계층적 군집분석**으로 분류된다.
> - 최단 연결법, 최장 연결법 , 평균 연결법, 와드 연결법



:point_right: 유클리디안 거리(Euclidean distance)

> 두 점 사이의 거리를 계산하는 방법. 관측대상 p와 q의 대응하는 변량 값의 차가 작으면, 두 관측대상은 유사하다고 정의하는 식. 유클리디안 거리 계산식은 관측대상 와 의대응하는 변량 값의 차의 제곱의 합에 제곱근을 적용한 결과이다

![1569226378236](assets/1569226378236.png)

```R
dist( x, method=“euclidean”)

#유클리디안 거리 계산
x <- matrix(1:9, nrow=3, by=T)
     [,1] [,2] [,3]
[1,]    1    2    3
[2,]    4    5    6
[3,]    7    8    9
x.dist <- dist(x, method="euclidean")
          1         2
2  5.196152          
3 10.392305  5.196152
#1과 2, 2와 3은 유클리디안 거리가 1과 3의 거리보다는 가깝다.

s <- sum((x[1, ] - x[2, ])^2) 	# 1행과 2행의 변량의 차를 제곱하여 더함
sqrt(s)
[1] 5.196152
s<- sum((x[1, ] - x[3, ])^2)  	# 1행과 3행의 변량의 차의 제곱의 합
sqrt(s) 
[1] 10.3923

```

#### 4.9.1.1. 유클리디안 계층적 군집 분석

- 사용예 1

  ```R
  install.packages("cluster")
  library(cluster)
  
  x <- matrix(1:9, nrow=3, by=T)
  
  #유클리드 거리 matrix를 이용한 군집화
  dist <- dist(x, method="euclidean")
  #클러스터링 적용
  hc <- hclust(dist)
  plot(hc)
  ```

- 사용예 2

  ```R
  interview <- read.csv("./data/interview.csv", header=T)
  interview_df <- interview[, c(2:7)]
  i.dist <- dist(interview_df)
  [1]  3.464102 11.445523  2.449490 15.524175  3.741657 14.142136
  
  hc <- hclust(i.dist)
  plot(hc, hang=-1) #hang=-1은 덴드로그램에서 음수값을 제거
  rect.hclust(hc, k=3, border="red")

  #유사한 데이터끼리 그룹화한 결과, 3개 그룹 (8, 10, 7, 12, 15), (2, 1, 4, 6, 13), (5, 14, 9, 3, 11) 으로 나뉘었다.
  ```
  
  ![1569227747894](assets/1569227747894.png)
  
  ```R
  #군집별 특성을 보기위해서 군집별 subset 생성
  g1 <- interview[hc$order[1:5], ]
  g2 <- interview[hc$order[6:10], ]
  g3 <- interview[hc$order[11:15], ]
  summary(g1)
  summary(g2)
  summary(g3)
  ```

#### 4.9.1.2. 사용자 정의 군집수 설정(자르기)

> 위 예제에서 일일이 인덱스를  확인하여 수동으로 군집을 잘라왔는데 아래 방법을 쓰면 잘 잘라올 수 있다.

```R

#stats::cutree()
library(stats)
library(cluster)

idist <- dist(iris[1:4])
hc <- hclust(idist)
plot(hc, hang=-1)
rect.hclust(hc, k=4, border="red")

ghc <- cutree(hc, k=3)
ghc #군집을 의미하는 1~3의 숫자로 출력

iris$ghc <- ghc
table(iris$ghc)

#각 군집별로 내적 특성, 다른 군집과의 차이에 해당하는 외적 특성 확인
g1 <- subset(iris, ghc==1)
summary(g1[1:4])
g2 <- subset(iris, ghc==2)
summary(g2[1:4])
g3 <- subset(iris, ghc==3)
summary(g3[1:4])
```

#### 4.9.1.3. 최단연결법(Single Linkage Method)

> 군집에 속하는 두 개체(데이터) 사이의 최단 거리를 이용 가장 유사성이 큰 개체들을 군집으로 묶어 나가는 방법.
>
> 빠르고, 자료에 대한 단조 변환에 대하여 Tree 구조가 불변하기 때문에 `순서적 의미`를 갖는 자료에 대해서 좋은 결과를 제공함.
>
> 고린된 군집을 찾는데 유용하다.

```R
a <- c(1, 5)
b <- c(2, 3)
c <- c(5, 7)
d <- c(3, 5)
e <- c(5, 2)
data <- data.frame(a, b, c, d, e)
data <- t(data)
m1 <- hclust(dist(data)^2, method="single")
plot(m1)
```

#### 4.9.1.4. 최장연결법(Complete Linkage Method)

>군집들의 응집성을 찾는데 유용

```R
m2 <- hclust(dist(data)^2, method="complete")
plot(m2)
```

#### 4.9.1.5. 와드연결법(Ward's Method)

>새로운 군집으로 인하여 파생되는 ESS(오차 제곱의 합)의 증가량을

```R
m3 <- hclust(dist(data)^2, method="ward.D2")
plot(m3)
```

#### 4.9.1.6. 평균 연결법(Average Linkage Method)

>두 군집 사이의 거리를 각 군집에 속하는 모든 개체들의 평균거리로 정의하여 가장 유사성이 큰 개체들을 군집으로 묶어 가는 방법.

```R
m4 <- hclust(dist(data)^2, method="average")
plot(m4)
```

#### 4.9.1.7. 비계층적 군집 분석

> 군집의 수가 정해진 상태에서 군집의 중심에서 가장 가까운 개체를 하나씩 포함해 나가는 방법.
>
> 군집수를 미리 알고 있는 경우 군집 대상의 분포에 따라 군집의 초기값을 설정해 주면, 초기값에 가장 가까운 거리에 있는 대상을 하나씩 더해 가는 방식으로 군집화를 수행.
>
> 계층적 군집분석을 통해 대략적인 군집의 수를 파악하고 이를 초기 군집 수로 설정하여 비계층적 군집분석을 수행하는 것이 효과적.
>
> K-means clustering  (stats::kmeans())

```R
library(ggplot2)
data(diamonds)
t <- sample(1:nrow(diamonds), 1000)
test <- diamonds[t, ] # 표본으로 검정 데이터 생성
names(test)

data <- test[c("price", "carat", "depth", "table")]
head(data)

#계층적 군집분석
result <- hclust(dist(data), method="ave")
result
plot(result, hang=-1)

#3개의 군집수를 적용하여 비계층적 군집분석 수행
result2 <- kmeans(data, 3)
names(result2)
result2$cluster #각 개체가 속하는 군집수 확인

data$cluster <- result2$cluster

#price에 가장 큰 영향을 주는 변수들 확인
cor(data[, -5], method="pearson")
plot(data[, -5])
library(corrgram) #상관계수를 색상으로 시각화
corrgram(data[, -5], upper.panel=panel.conf) #상관계수 수치 추가

#비계층분석 결과 price에 가장 영향을 주는... 군집수 2의 시각화
plot(data$carat, data$price, col=data$cluster)
#중심점 추가
points(result2$centers[, c("carat", "price")], col=c(1, 2, 3), pch=8, cex=5)
```

- iris 데이터셋 비계층적 군집 분석

  ```R
  data <- iris
  data$Species <- NULL
  m <- kmeans(data, 3)
  
  table(iris$Species, m$cluster)
  plot(data[c("Sepal.Length", "Sepal.Width")], main="kmeans", col=m$cluster)
  
  m2 <- kmeans(data, 4)
  table(iris$Species, m2$cluster)
  plot(data[c("Sepal.Length", "Sepal.Width")], main="kmeans", col=m2$cluster)
  ```

### 4.9.2. 연관분석(Association Analysis)

>하나의 거래나 사건에 포함된 항목 간의 관련성을 파악하여 둘 이상의 항목들로 구성된 연관성 규칙을 도출하는 탐색적인 분석방법
>
>군집분석에 의해서 생성된 군집(cluster)의 특성을 분석하는 장바구니 분석
>
>예) 트랜잭션(상품 거래 정보)을 대상으로 트랜잭션 내의 연관성을 분석하여 상품 거래의 규칙이나 패턴을 통해서 상품 간의 연관성을 도출해내는 분석 방법
>
>거래나 사건으로부터 연관성을 찾아내기 위해서는 각각 연관성을 비교할 수 있는 규칙(지지도support, 신뢰도confidence, 향상도lift)을 평가 척도로 사용한다

```R
install.packages("arules")
library(arules)

#arules::read.transactions(), apriori()
```

- 사용 예

  ```R
  tran <- read.transactions("./data/tran.txt", format="basket", sep=",")
  #거래 data는 6개
  inspect(tran) #항목(품목) 확인
      items           
  [1] {라면,맥주,우유}
  [2] {고기,라면,우유}
  [3] {고기,과일,라면}
  [4] {고기,맥주,우유}
  [5] {고기,라면,우유}
  [6] {과일,우유}    
  
  rule <- apriori(tran, parameter=list(supp=0.3, conf=0.1))
  Apriori
  
  Parameter specification:
   confidence minval smax arem  aval originalSupport maxtime support minlen
          0.1    0.1    1 none FALSE            TRUE       5     0.3      1
   maxlen target   ext
       10  rules FALSE
  
  Algorithmic control:
   filter tree heap memopt load sort verbose
      0.1 TRUE TRUE  FALSE TRUE    2    TRUE
  
  Absolute minimum support count: 1 
  
  set item appearances ...[0 item(s)] done [0.00s].
  set transactions ...[5 item(s), 6 transaction(s)] done [0.00s].
  sorting and recoding items ... [5 item(s)] done [0.00s].
  creating transaction tree ... done [0.00s].
  checking subsets of size 1 2 3 done [0.00s].
  writing ... [16 rule(s)] done [0.00s].
  creating S4 object  ... done [0.00s].
  #맥주를 구매한 사람은 대체로 고기를 사지 않는다
  #{라면, 맥주} => {우유}는 향상도가 1.2이므로 두 상품간의 상관성이 높습니다.
  
  #규칙 생성
  rule2 <- apriori(tran, parameter=list(supp=0.1, conf=0.1))
  
  # 다른 파일로 테스트
  stran <- read.transactions("./data/demo_single", format="single", cols=c(1,2))
  inspect(stran)
  
  stran2 <- read.transactions("./data/single_format.csv", format="single", sep=",", cols=c(1,2), rm.duplicates=T)
  stran2      #트랜잭션 248, 항목은 68
  summary(stran2)
  
  #규칙 생성 (연관규칙 생성을 위한 평가척도 기본값 supp=0.1, conf=0.8)
  astran2 <- apriori(stran2)
  #규칙 확인
  inspect(astran2)
  #상위 5개만 향상도 기준 내림차순)
  inspect(head(sort(astran2, by="lift"), 5))
  ```

- 연관규칙을 네트워크 형태로 시각화하기

  ```R
  
  # 연관규칙 생성, 네트워크 형태로 시각화
  data(Adult)
  str(a)
  #성인 대상 인구 소득에 관한 설문 조사 데이터
  #AdultUCI 데이터 셋을 트랜잭션 객체로 변환한 데이터셋
  #관측치 48,842, 변수 15개
  #w종속변수(Class)에 의해서 연간 개인 수입이 $5만 이상인지를 예측하는데이터셋
  
  attributes(Adult) #transaction의 변수와 범주
  names(AdultUCI) #15개의 변수(컬럼)명
  
  adult <- as(Adult, "data.frame")
  head(adult)
  str(adult)
  summary(adult)
  
  #규칙 생성
  ar <- apriori(Adult, parameter=list(supp=0.1, conf=0.8))
  #규칙이 너무 많아서 옵션 변경
  ar2 <- apriori(Adult, parameter=list(supp=0.3, conf=0.95))
  ar3 <- apriori(Adult, parameter=list(supp=0.35, conf=0.95))
  ar4 <- apriori(Adult, parameter=list(supp=0.4, conf=0.95))
  
  #상위 6개 규칙
  inspect(head(ar4))
  #신뢰도 기준 내림차순 정렬 상위 6개
  inspect(head(sort(ar4, decreasing=T, by="confidence")))
  #향상도 기준 내림차순 정렬 상위 6개
  inspect(head(sort(ar4, decreasing=T, by="lift")))
  
  install.packages("arulesViz")
  library(arulesViz)
  plot(ar3, method="graph", control=list(type="items"))
  plot(ar4, method="graph", control=list(type="items"))
  # 5만 달러 이상의 연봉 수령자와 관련된 연관어 :
  풀타임 근무
  인종은 백인
  국가는 미국
  자본손실 없을 것
  직업은 자영업
  나이는 중년
  교육수준...
  결혼여부 기혼
  ```

- Groceries 데이터 셋 연관분석

  ```R
  data("Groceries")
  Groceries
  #1개월 동안 실제 로컬 식품점 매장에서 판매되는 트랜잭션 데이터
  #transactions 은 9835, item 은 169
  g_df <- as(Groceries, "data.frame")
  
  rules <- apriori(Groceries, parameter=list(supp=0.001, conf=0.8))
  rules2 <- apriori(Groceries, parameter=list(supp=0.002, conf=0.8))
  inspect(rules2)
  
  par(mfrow=c(2, 1))
  plot(rules, method="grouped")
  plot(rules2, method="grouped")
  
  #빈도수가 가장 높은 상품
  규칙이 A상품 -> B상품 형태로 표현. 왼쪽에 있는 A상품LHS표현, 오른쪽 RHS
  #최대 길이 3(LHS와 RHS의 길이를 합이 3) 이하 규칙 생성
  rules <- apriori(Groceries, parameter=list(supp=0.001, conf=0.8, maxlen=3))  # rules  29
  inspect(rules)
  
  rules <- sort(rules, decreasing=T, by="confidence")
  inspect(rules)
  plot(rules, method="graph", control=list(type="items"))
  
  #특성 상품 서브셋 생성하여 시각화하기
  wmilk <- subset(rules, rhs %in% 'whole milk')
  inspect(wmilk)
  plot(wmilk, method="graph")
  
  aveg <- subset(rules, rhs %in% 'other vegetables')
  aveg
  inspect(aveg)
  plot(aveg, method="graph")
  ```

- 연습문제

  ```R
  #연관성 규칙은 상품 호은 서비스 간의 관계를 살펴보고 이로부터 유용한 규칙을 찾아내고자 할 때 이용될 수 있는 기법이다.
  #데이터들의 빈도수와 동시발생 확률을 이용하여 한 항목들의 그룹과 다른 항목들의 그룹 사이에 강한 연관성이 있음을 밝혀주는 기법이다.
  
  #예제 데이터 : B 마트에서 판매된 트랜잭션 데이터 파일
  mybasket.csv
  
  #변수 : 의류, 냉동식품, 주류, 야채, 제과, 육류, 과자, 생활장식, 우유
  
  #분석문제 :
  1. 전체 트랜잭션 개수와 상품아이템 유형은 몇개인가? #786, 10
  2. 가장  발생빈도가 높은 상품아이템은 무엇인가? # clothes
  3. 지지도를 10%로 설정했을 때의 생성되는 규칙의 가짓수는? #2
  4. 상품 아이템 중에서 가장 발생확률이 높은 아이템과 낮은 아이템은 무엇인가? #clothes, milk
  5. 가장 발생가능성이 높은 <2개 상품간>의 연관규칙은 무엇인가? # {bakery}                 => {clothes}
  6. 가장 발생가능성이 높은 <2개 상품이상에서> <제 3의 상품으로>의 연관규칙은 무엇인가?  #{deco,frozen}            => {bakery}
  
  basket <- read.transactions("./data/mybasket.csv", format="basket", sep=",")
  
  rules <- apriori(basket, parameter=list(supp=0.1, conf=0.1))
  
  rules <- apriori(basket, parameter=list(supp=0.05, conf=0.1))
  
  inspect(sort(rules, decreasing=T, by="support"))
  
  plot(rules, method="grouped")
  
  #모범 답안
  result <- read.transactions("./data/mybasket.csv", format="basket", sep=",")
  result
  summary(result)
  image(result)
  as(result, "data.frame")
  rules <- apriori(result, parameter=list(supp=0.1, conf=0.1))
  inspect(rules)
  
  inspect(sort(rules, decreasing=T, by="support"))
  
  library(arulesViz)
  plot(rules)
  plot(rules, method="grouped")  #lhs가로축 조건과 rhs세로축-결과로 구성한 메트릭스 그래프
  plot(rules, method="graph", control=list(type="items"))
  plot(rules, method="graph", interactive=TRUE , control=list(type="items"))
  ```

- Twitter SNS 연관어 분석 단계

  ```R
  단계 1] Twitter 로그인  -  https://twitter.com
  단계 2] Twitter 앱 만들기  - https://apps.twitter.com/ko
  앱 이름, 앱에 대한 설명문 10자 이상 입력, 웹사이트는 운영중인 사이트나 블러그 등 주소 입력
  페이지 아래 라이센스 동의
  ※ Request token URL, Authorize URL, Access token URL  (앱 인증 요청시 필요함)
   
  단계 3] Twitter 앱 설정
  단계 4] Twitter 앱 키와 접근 토큰 생성
  
  단계 5] Twitter 앱에 관한 사용자의 권한 설정
  단계 6] Twitter 앱 토큰 생성
  ※ Access Token과 Access Token Secret 생성
  
  
  #######Twitter 앱 인증 
  #twitteR 패키지 로딩 ? twitter 인증 관련 함수 제공
  #ROAuth  패키지 로딩 ? OAuthFactory 객체 제공
  #Base64enc 패키지 로딩 ? enc2utf8()  함수 제공
  install.packages("twitteR")
  install.packages("ROAuth")
  install.packages("base64enc")
  library(twitteR)
  library(ROAuth)
  library(Base64enc)
  
  
  #  Twitter 앱 요청 URL과 API 설정
  # [Details] - 3개 url 변수 생성
  reqURL <- "https://api.twitter.com/oauth/request_token"
  authURL <- "https://api.twitter.com/oauth/authorize"
  accessURL <- "https://api.twitter.com/oauth/access_token"
  
  # [Keys and Access Tokens] - 4개 변수 : ##Site에서 받아온다.
  apiKey <-  "bINvDLa0dsPbo2la8PiscuUqC" 
  apiSecret <- "PKNHc2ls7cnuFPbD0eWYxqXi7QMK2WCucWjYLWShZMQPu77SNS" 
  accessToken="632641860-hADhYcejnc2AlMFxFKy7E2BwLmsLsZGiMjaStMcm"
  accessTokenSecret="D4m5xjaihndouW4FLg3LxVxBUitRmSjKJBephvmkRL8x5"
  
  # Twitter 앱 인증 요청
  twitCred <- OAuthFactory$new(
    consumerKey = apiKey, 
    consumerSecret = apiSecret,
    requestURL = reqURL,
    accessURL = accessURL, 
    authURL = authURL
  )
  
  
  # Twitter 앱 인증 수행
  twitCred$handshake(
    cainfo = system.file("CurlSSL", "cacert.pem", package = "RCurl")
  )
  
  # Twitter 앱 인증을 위한 PIN 받기
  setup_twitter_oauth(apiKey, 
                      apiSecret,
                      accessToken,
                      accessTokenSecret)
  
  # 따로 테스트
  # 함수 실행 -> 선택: 1(1: Yes)
  
  
  ##Twitter 앱에 접근하여 데이터 가져오기
  
  # 단계 1 : 검색어 입력과 검색 결과 받기 
  keyword <- enc2utf8("빅데이터") # UTF-8 인코딩 방식 지정 - base 패키지 
  test <- searchTwitter(keyword, n=300) # twitteR 패키지 제공 
  test
  class(test) # [1] "list"
  
  # 단계 2 :  list 자료구조를 vector 자료구조로 변경
  test_vec <- vector() # vector 객체 생성 
  n <- 1: length(test)
  
  for(i in n){
    test_vec[i] <- test[[i]]$getText()
  }
  test_vec
  
  # data type과 구조보기 
  class(test_vec); str(test_vec)
  
  #파일 저장 및 가져오기
  write.csv(test_vec, "c:/workspace_R/output/test.txt", quote = FALSE, row.names = FALSE)
  test_txt <- file("C:/workspace_R/output/test.txt")
  twitter <- readLines(test_txt)
  str(twitter)
  
  
  ## Twitter 검색 데이터 대상 연관어 분석
  
  # 단계 1 : 한글 처리를 위한 패키지 설치
  library(rJava) # 아래와 같은 Error 발생 시 Sys.setenv()함수로 java 경로 지정
  library(KoNLP) # rJava 라이브러리가 필요함
  
  # 단계 2 :  줄 단위 단어 추출
  lword <- Map(extractNoun, twitter) 
  length(lword) 
  lword <- unique(lword) # 중복제거1(전체 대상)
  length(lword) 
  lword <- sapply(lword, unique) # 중복제거2(줄 단위 대상) 
  length(lword) 
  lword # 추출 단어 확인
  
  # 단계 3 :  데이터 전처리
  # (1) 길이가 2~4 사이의 단어 필터링 함수 정의
  filter1 <- function(x){
    nchar(x) <= 4 && nchar(x) >= 2 && is.hangul(x)
  }
  # (2) Filter(f,x) -> filter1() 함수를 적용하여 x 벡터 단위 필터링 
  filter2 <- function(x){
    Filter(filter1, x)
  }
  
  # (3) 줄 단어 대상 필터링
  lword <- sapply(lword, filter2)
  lword # 추출 단어 확인(길이 1개 단어 삭제됨)
  
  #  트랜잭션 생성 : 연관분석을 위해서 단어를 트랜잭션으로 변환
  library(arules) 
  wordtran <- as(lword, "transactions") # lword에 중복데이터가 있으면 error발생
  wordtran 
  inspect(wordtran)  # 트랜잭션 내용 보기
  
  # 단어 간 연관규칙 산출
  tranrules <- apriori(wordtran, parameter=list(supp=0.02, conf=0.4))  # 54 rule(s)
  inspect(tranrules) # 연관규칙 생성 결과(23개) 보기
  
  # 연관어 시각화 
  # (1) 데이터 구조 변경 : 연관규칙 결과 -> 행렬구조 변경(matrix 또는 data.frame) 
  rules <- labels(tranrules, ruleSep=" ") # 연관규칙 레이블을 " "으로 구분하여 변경   
  rules # 예) 59 {경영,마케팅}   => {자금} -> 59 "{경영,마케팅} {자금}"
  class(rules)
  
  rules <- sapply(rules, strsplit, " ",  USE.NAMES=F) 
  rules
  class(rules) 
  
  # 행 단위로 묶어서 matrix로 반환
  rulemat <- do.call("rbind", rules)
  rulemat
  class(rulemat)
  
  # (2) 연관어 시각화를 위한 igraph 패키지 설치
  library(igraph)   
  
  # (3) edgelist보기 - 연관단어를 정점 형태의 목록 제공 
  ruleg <- graph.edgelist(rulemat[c(1:54),], directed=F) 
  
  # (4) edgelist 시각화
  X11()
  plot.igraph(ruleg, vertex.label=V(ruleg)$name,
              vertex.label.cex=1.0, vertex.label.color='black', 
              vertex.size=20, vertex.color='green', vertex.frame.color='blue')
  ```

## 4.10 시계열 분석

>시계열 분석은 어떤 현상에 대해서 시간의 변화량을 기록한 시계열 자료를 대상으로 미래의 변화에 대한 추세를 분석하는 방법. 시간의 경과에 따른 관측값의 변화’를 패턴으로 인식하여 시계열 모형을 추정, 이 모형을 통해서 미래의 변화를 추정하는 분석 방법.
>
>시계열 분석은  어떤 시간의 변화에 따라 현재 시점(t)의 자료와 이전 시점(t-1)의 자료 간의 상관성을 토대로 분석한다. 시간을 축으로 변화하는 통계량의 현상을 파악하여 가까운 미래를 추정하는 도구로 적합하다. 
>
>먼 미래를 예측하는 도구로 사용될 경우 실패할 확률이 높다 – 시간의 경과에 따라 오차가 중첩되기 때문에 분산이 증가하여 예측력이 떨어진다.

### 4.10.1. 비정상 시계열 자료를 정상 시계열 자료로 변환하기

```R
data(AirPassengers)

#차분을 이용한 평균에 대한 정상화
par(mfrow=c(1,2))
ts.plot(AirPassengers)   #시계열 시각화
diff <- diff(AirPassengers)  #차분 수행
plot(diff)   #평균 정상화
dev.off()

#로그를 이용한 분산에 대한 정상화
par(mfrow=c(1,2))
plot(AirPassengers)
log <-diff(log(AirPassengers))  #로그 + 차분 
plot(log)
dev.off()
```

### 4.10.2. 시계열 자료로부터 추세선 시각화 - `ts.plot()`

```R
data(WWWusage)
str(WWWusage)

ts.plot(WWWusage, type="l", col="red") #가로축:t 세로축:시계열 데이터 값

#다중 시계열 자료의 추세선 시각화
data(EuStockMarkets) #유럽 주요 주식의 주가시주 일일 마감 가격
str(euStockMarkets) #DAX:독일, SMI:스위스, CAC:프랑스, FISE:영국
EuStock <- data.frame(EuStockMarkets)
X11()
plot(EuStock$DAX[1:1000], type="l", col="red")
plot(EuStock$DAX[1:1000], EuStock$SMI[1:1000], main="주가지수 추세", col="red")
```

### 4.10.3. 시계열 요소 분해 시각화 - `stl()`

```R
#데이터를 시계열 타입으로 변환
# ts(데이터셋, start=c("시작년", "시작일"), frequency=주기)
data <- c(45, 56, 45, 43, 69, 75, 58, 59, 66, 64, 62, 65, 
          55, 49, 67, 55, 71, 78, 71, 65, 69, 43, 70, 75, 
          56, 56, 65, 55, 82, 85, 75, 77, 77, 69, 79, 89)
length(data)# 36
tsdata <- ts(data, start=c(2016, 1), frequency=12)
tsdata # 2016 ~ 2018


#추세선 확인
par(mfrow=c(1,1))
ts.plot(tsdata) #각 요인(추세, 순환, 계절, 불규칙)을 시각적 확인

#시계열 분해 - stl
#잔차는 회귀식에 의해 추정된 값과 실제 값의 차이 - 계절과 추세 적합 결과에 의해서 나타남
plot(stl(tsdata, "periodic")) #주기적
```

![1569371050733](assets/1569371050733.png)

```R
#시계열 분해, 변동요인 제거
m <- decompose(tsdata)
attributes(m)

par(mfrow=c(2, 2))
plot(m, dev="extent")
plot(tsdata - m$seasonal)
plot(tsdata - m$trend)
plot(tsdata - m$seasonal - m$trend)
```

![1569371679094](assets/1569371679094.png)

### 4.10.4. 자기/부분 상관 함수 시각화 - `packf()`

>자기 상관성은 자기 상관계수가 유의미한가를 나타내는 특성이다.
>
>자기 상관계수 - 시계열 자료(Yt)에서 시차(lag)를 일정하게 주는 경우 얻어지는 상관계수. 한 계로 시차 1의 자기 상관계수는 Yt와 Yt-1 간의 상관계수를 의미한다. 자기 상관계수는 서로 이웃한 시점 간의 상관계수를 찾는 데 이용된다.
>
>부분 자기 상관계수 -  다른 시차들의 시계열 자료가 미치는 영향을 제거한 후에 주어진 시차에 대한 시계열 간의 상관계수.
>
>자기 상관 함수와 부분 자기 상관 함수는 시계열의 모형을 식별하는 수단으로 이용된다.

```R
input <- c(3180,3000,3200,3100,3300,3200,3400,3550,3200,3400,3300,3700) 
tsdata <- ts(input, c(2015,2), frequency=12)

#추세선 시각화
#점진적으로 증가하는 추세의 선형 형태 확인
plot(tsdata, type="l", col="red")

#자기 상관 함수 시각화
acf(na.omit(tsdata), main="자기상관함수", col="red")
#파란점선은 유의미한 자기 상관관계에 대한 임계값을 의미. 모든 시차(Lag)가 파란 점선 안에 있기 때문에 서로 이웃한 시점 간의 자기 상관성은 없는 것으로 해석
```

![1569372172053](assets/1569372172053.png)

```R
#부분 자기 상관 함수 시각화
pacf(na.omit(tsdata), main="부분자기상관함수", col="red") 
#주기 생성에 어떤 종류의 시간 간격이 영향을 미치는지 보여줌
#간격 0.5에서 가장 작은 값(-0.5)를 나타냄
#모든 시차가 파란 점선 안쪽에 있기 때문에 주어진 시점 간의 자기 상관성은 없는 것으로 해석
```

![1569372461449](assets/1569372461449.png)

```R 
#차분 시각화
plot(diff(tsdata, differences=1))
#평균을 중심으로 일정한 폭을 나타내고 있음

#결론:
"추세의 패턴은 선형으로 판단됨"
```

### 4.10.5. 시계열 분석  기법

> - 평활법, 시계열요소분해법 – 시각적인 측면에서 직관성을 제공
>
> - 회귀분석법, ARIMA 모형법 – 수학적 이론을 배경으로 1개 이상의 다변량 시계열 데이터를 대상으로 분석하는 방법
>
> - 일반 회귀모형 – 시계열 자료에서 시간 t를 설명변수로 시계열 자료를 반응변수로 지정한 회귀모형
>
> - 계량경제모형 – Yt와 Yt-1 사이의 시계열 자료를 대상으로 회귀분석을 수행하는 모형. 경제변수 간의 경제적 관계에 대한 정량적, 수치적 분석과 측정을 위한 모형인 계량경제모형은 인플레이션이 환율에 미치는 요인, 엔/달러 환율이 물가에 미치는 영향 등을 분석하는데 이용된다.

| 분석기법            | 직관적 방법 | 수학/통계적   방법 | 시계열 기간 | 변수의 길이      |
| ------------------- | ----------- | ------------------ | ----------- | ---------------- |
| 시계열요소분해법    | O           | X                  | 단기 예측   | 1개(일변량)      |
| 평활법              | O           | X                  | 단기 예측   | 1개(일변랑)      |
| ARIMA 모형          | X           | O                  | 단기 예측   | 1개 이상(다변량) |
| 회귀 모형(계량정제) | X           | O                  | 단기 예측   | 1개(일변량)      |
|                     | X           | O                  | 장기 예측   | 1개 이상(다변량) |

#### 4.10.5.1. 이동평균(Moving Average) 평활법 - `SMA()`

```R
install.packages("TTR")
library(TTR)
```

- 사용 예

  ```R
  data <- c(45, 56, 45, 43, 69, 75, 58, 59, 66, 64, 62, 65, 
            55, 49, 67, 55, 71, 78, 71, 65, 69, 43, 70, 75, 
            56, 56, 65, 55, 82, 85, 75, 77, 77, 69, 79, 89)
  tsdata <- ts(data, start=c(2016, 1), frequency=12) 
  tsdata    # 2016~2018
  
  #이동 평균법으로 평활 및 시각화
  par(mfrow=c(2,2))
  plot(tsdata, main="원 시계열 자료") # 시계을 자료 시각화
  plot(SMA(tsdata, n=1), main="1개월 단위 이동평균법으로 평활")
  plot(SMA(tsdata, n=2), main="2개월 단위 이동평균법으로 평활")
  plot(SMA(tsdata, n=3), main="3개월 단위 이동평균법으로 평활")
  
  #가장 평탄한 형태로 분포된 결과를 선정하여 추세를 예측하는데 사용
  #평균으로 평활한 결과가 가장 평탄한 값으로 나타나는 값은 3개월 단위
  ```

  ![1569374541792](assets/1569374541792.png)

#### 4.10.5.2. ARIMA 모형(자동회귀통합이동평균 모형 ?)

> ARIMA(Auto-regressive Integrated Moving Average) 모형은 시계열 데이터 기반 분석 기법으로 과거지식이나 경험을 바탕으로 한 행동에 따라 경제가 움직이고 있음을 기초로 한다. 시계열 분석은 주가 전망이나 수요 예측 등에 사용되며 매우 다양한 기법으로 발전하였으나, 계량경제모델이 점점 대형화되면서 오히려 경제의 본질적인 부문을 제대로 설명하기 어려워졌다. 이러한 상황을 극복하기 위해 소수의 시계열 데이터만을 이용한 단순 모델로 경제 분석 및 예측을 시도하는 움직임이 최근 활발히 진행되고 있다. 
>
> ARIMA 모형은 과거의 관측 값과 오차를 사용해서 현재의 시계열 값을 설명하는 ARMA(Auto-regressive Moving Average) 모델을 일반화 한 것으로, 분기/반기/연간 단위로 다음 지표를 예측한다거나 주간/월간 단위로 지표를 리뷰하며 트렌드에 이상치가 없는지를 모니터링 하는 데 사용되는 분석 기법이다. ARMA 모델이 안정적 시계열(Stationary Series)에만 적용 가능한 것에 비해, 분석 대상이 다소 비안정적인 시계열(Non Stationary Series)의 특징을 보여도 적용이 가능하다.

```R
install.packages("forecast")
library(forecast)

auto.arima()
arima()

tsdiag(model) #자기 상관 함수에 의한 모형 진단
Box.test() #잔차항 모형 진단, 모형의 잔차를 이용하여 카이제곱검정 방법으로 시계열 모형이 통계적으로 적절한지를 검정하는 방법으로 p-value가 0.05이상이면 모형이 통계적으로 적절하다고 볼 수 있다 
forecast::forecast() #시계열의 예측치를 제공하는 함수
```

- 절차 
  1. 시계열 자료 특성분석(정상성/비정상성)
  2. 정상성 시계열 반환
  3. 모형 식별과 추정  - forecast::auto.arima() 
  4. 모형 생성
  5. 모형 진단(모형 타당성 검정) -  자기 상관 함수의 결과가 유의미한 시차가 없는 경우, 오차 간에 상관관계가 존재하는지를 검정하는 방법인 Box-Ljung 검정에서 p 값이 0.05 이상인 경우
  6. 미래 예측(업무 적용)

- 정상성 시계열의 ARIMA 모델 분석

  ```R
  input <- c(3180,3000,3200,3100,3300,3200,3400,3550,3200,3400,3300,3700) 
  tsdata <- ts(input, c(2015,2), frequency=12)
  
  #추세선 시각화
  #점진적으로 증가하는 추세의 선형 형태 확인
  plot(tsdata, type="l", col="red")
  diff <- diff(tsdata)
  plot(tsdata, type="l", col="red")
  
  
  #모형 식별과 추정
  #auto.arima: 시계열 모형을 식별하는 알고리즘에 의해서 최적의 모형
  arima <- auto.arima(tsdata) # 시계열 데이터 이용
  
  Series: tsdata 
  ARIMA(1,0,0) with zero mean 
  
  Coefficients:
            ar1
        -0.6891
  s.e.   0.2451
  
  sigma^2 estimated as 31643:  log likelihood=-72.4
  AIC=148.8   AICc=150.3   BIC=149.59
  #AIC: 이론적 예측력(모형의 적합도 지수로 값이 ㅈ거은 모형을)
  
  
  #모형 생성
  #arima(1, 1, 0) # 자기 회귀 모형 차수 1, 차분 차수 1, 이동평균모형 차수 0
  #1번 차분한 결과가 정상성 시계열 ARMA(1, 0) 모형으로 나타남
  #d=0 이면, ARMA(p, q) 모형이며, 정상성을 만족합니다.
  #p=0 이면, IMA(d, q) 모형이며, d번 차분하면 MA(q)모형을 따른다
  #q=0 이면, IRA(p,d) 모형이며, d번 차분하면 AR(p) 모형을 따른다
  model <- arima(tsdata, order=c(1, 1, 0))
  
  Call:
  arima(x = tsdata, order = c(1, 1, 0))
  
  Coefficients:
            ar1
        -0.8293
  s.e.   0.1660
  
  sigma^2 estimated as 49169:  log likelihood = -68.79,  aic = 141.57
  #모형의 계수 값과 표준 오차를 확인
  
  #모형 진단(모형 타당정 검정)
  # (1) 자기상관함수에 의한 모형 진단
  tsdiag(model)
  
  # (2) Box-Ljung에 의한 잔차항 모형 진단
  # p-value가 0.05이상이면 모형이 통계적으로 적절하다고 볼 수 있다.
  Box.test(model$residuals, lag=1, type = "Ljung")
  
  	Box-Ljung test
  
  data:  model$residuals
  X-squared = 0.12353, df = 1, p-value = 0.7252
  ```

  ![1569376424387](assets/1569376424387.png)

  ```R
  #미래 예측(업무 적용)
  fore <- forecast(model) #향후 2년 예측
  fore
  
  par(mfrow=c(1,2))
  plot(fore) # 향후 24개월 예측치 시각화 
  model2 <- forecast(model, h=6) # 향후 6개월 예측치 시각화 
  plot(model2)
  ```

  ![1569376676282](assets/1569376676282.png)

- 계절성이 있는 데이터의 정상성시계열 ARIMA 모델 분석

  ```R
  data <- c(45, 56, 45, 43, 69, 75, 58, 59, 66, 64, 62, 65, 
            55, 49, 67, 55, 71, 78, 71, 65, 69, 43, 70, 75, 
            56, 56, 65, 55, 82, 85, 75, 77, 77, 69, 79, 89)
  
  #시계열 자료 생성
  tsdata <- ts(data, start=c(2016, 1), end=c(2018, 10), frequency=12)
  head(tsdata)
  tail(tsdata)
  
  #시계열 요소 분해 시각화
  ts_feature <- stl(tsdata, s.window="periodic")
  plot(ts_feature)
  
  #단계2: 정상성 시계열 변환
  par(mfrow=c(1,2))
  ts.plot(tsdata)
  diff <- diff(tsdata)
  plot(diff) #차분 시각화
  
  #단계3: 모형 식별과 추정
  ts_model2 <- auto.arima(diff)
  
  # ARIMA(2,1,0) - 자기 회귀 모형 차수 2, 차분 차수 1
  # 1번 차분한 결과가 정상성 시계열 ARMA(2, 0) 모형으로 나타남
  # ARIMA 두번째 파라미터 (1, 0, 0)는 계절성을 갖는 자기회귀(AR) 모형 차수가 1로 나타남 =>계절성을 갖는 시계열이라는 의미
  # [12]는 계절의 차수가 12개월임을 의미함
  # 계수(Coefficients)는 자기회귀 모형의 차수 2(ar1, ar2)와 계절성 자기회귀 차수(sar1)에 대한 계수값임을 나타냄
  
  #단계4: 모형 생성
  model <- arima(tsdata, c(2, 1, 0))
  model #모형의 계수값과 표준 오차를 확인
  
  # 단계5 : 모형 진단(모형 타당성 검정)
  # (1) 자기상관함수에 의한 모형 진단
  tsdiag(model)
  #잔차의 ACF에서 자기 상관이 발견되지 않고, p value값이 0 이상으로 분포되어 있으므로 ARIMA 모형은 매우 양호한 시계열 모형이라고 진단할 수 있다
  
  
  # (2)Box-Ljung에 의한 잔차항 모형 진단
  Box.test(model$residuals, lag=1, type = "Ljung")  #0.593
  
  	Box-Ljung test
  
  data:  model$residuals
  X-squared = 0.0034142, df = 1, p-value = 0.9534
  #  p-value가 0.05이상이면 모형이 통계적으로 적절하다고 볼 수 있다 
  
  
  # 단계6 : 미래 예측
  par(mfrow=c(1,2))
  fore <- forecast(model, h=24) # 2년 예측 
  plot(fore)
  fore2 <- forecast(model, h=6) # 6개월 예측 
  plot(fore2)
  
  
  ```

#### 4.10.5.3. 시계열 분석 연습문제

- 연습문제 1

  ```R
  ##########시계열 분석 연습문제 1 #####################
  시계열 자료를 대상으로 다음 단계별로 시계열 모형을 생성하고, 미래를 예측하시오.
  <데이터 셋 준비>
  data(EuStockMarkets)
  head(EuStockMarkets)
  EuStock<- data.frame(EuStockMarkets)
  head(EuStock)
  Second <- c(1:500) # 초단 단위로 벡터 생성
  DAX <- EuStock$DAX[1001:1500] # DAX 칼럼으로 백터 생성
  EuStock.df <- data.frame(Second, DAX) # 데이터프레임 생성
  
  #단계1 : 시계열자료 생성 : EuStock.df$DAX 칼럼을 대상으로 2001년1월 단위
  eus <- as.vector(EuStock.df$DAX)
  eus.ts <- ts(eus, start=c(2001, 1), frequency=12)
  #단계2 : 시계열 자료 분해
  #(1) stl() 함수 이용 분해 시각화
  plot(stl(eus.ts, s.window="periodic"))
  #(2) decompose() 함수 이용 분해 시각화, 불규칙요인만 시각화
  eus.decomp <- decompose(eus.ts)
  attributes(eus.decomp)
  plot(eus.decomp)
  plot(tsdata - eus.decomp$trend - eus.decomp$seasonal)
  #(3) 계절요인추세요인 제거 그래프-불규칙요인만 출력
  plot(tsdata - eus.decomp$seasonal)
  #단계3 : ARIMA 시계열 모형 생성
  eus.diff <- diff(eus.ts)
  model.auto <- auto.arima(eus.diff)
  
  Series: eus.diff 
  ARIMA(2,0,2)(1,0,2)[12] with non-zero mean 
  
  Coefficients:
            ar1      ar2     ma1     ma2     sar1    sma1
        -1.2998  -0.9743  1.2667  0.9729  -0.5776  0.6155
  s.e.   0.0209   0.0243  0.0222  0.0299   0.1407  0.1410
           sma2    mean
        -0.1153  2.7550
  s.e.   0.0542  0.8165
  
  sigma^2 estimated as 379.7:  log likelihood=-2186.91
  AIC=4391.82   AICc=4392.19   BIC=4429.73
  
  model <- arima(eus.ts, c(2,1,2))
  
  Call:
  arima(x = eus.ts, order = c(2, 1, 2))
  
  Coefficients:
           ar1      ar2      ma1     ma2
        1.3944  -0.9293  -1.4361  1.0000
  s.e.  0.0199   0.0179   0.0083  0.0093
  
  sigma^2 estimated as 384.8:  log likelihood = -2195.59,  aic = 4401.18
  
  tsdiag(model)
  Box.test(model$residuals, lag=1, type = "Ljung")  #0.5148
  
  #단계4 : 향후 3년의 미래를 90%와 95% 신뢰수준으로 각각 예측 및 시각화
  eus.fore <- forecast(model, h=36) 
  plot(eus.fore)
  
  
  # 모범답안
  시계열 자료를 대상으로 다음 단계별로 시계열 모형을 생성하고, 미래를 예측하시오.
  <데이터 셋 준비>
  data(EuStockMarkets)
  head(EuStockMarkets)
  EuStock<- data.frame(EuStockMarkets)
  head(EuStock)
  Second <- c(1:500) # 초단 단위로 벡터 생성
  DAX <- EuStock$DAX[1001:1500] # DAX 칼럼으로 백터 생성
  EuStock.df <- data.frame(Second, DAX) # 데이터프레임 생성
  
  #단계1 : 시계열자료 생성 : EuStock.df$DAX 칼럼을 대상으로 2001년1월 단위
  tsdata <- ts(EuStock.df$DAX, start=c(2001, 1), frequency=12)
  
  #단계2 : 시계열 자료 분해
  #(1) stl() 함수 이용 분해 시각화
  #(2) decompose() 함수 이용 분해 시각화, 불규칙요인만 시각화
  plot(stl(tsdata, "periodic")) # 주기적인
  m <- decompose(tsdata)
  # 추세요인, 계절요인, 불규칙요인이 포함된 그래프
  plot(m)
  #(3) 계절요인추세요인 제거 그래프-불규칙요인만 출력
  plot(tsdata - m$seasonal - m$trend)
  
  #단계3 : ARIMA 시계열 모형 생성
  library(forecast)
  auto.arima(tsdata) # 자동으로 최적의 ARIMA모형 제공
  model<- auto.arima(tsdata)
  
  단계4 : 향후 3년의 미래를 90%와 95% 신뢰수준으로 각각 예측 및 시각화
  fore <- forecast(model, level=c(90, 95), h=36) # 향후 36개월(3년) 예측
  plot(fore) # 시각화
  ```

  ![1569395798994](assets/1569395798994.png)

- 연습문제 2

  ``` R
  ##########시계열 분석 연습문제 2 #####################
  #Sales.csv 파일을 대상으로 시계열 자료를 생성하고, 각 단계별로 시계열 모형을 생성하여예측하시오.
   
  goods <- read.csv("./data/Sales.csv", header = TRUE)
  
  #단계1 : 시계열 자료 생성 : goods$Goods 칼럼으로 2015년 1월 기준 12개월 단위
  goods.ts <- ts(goods$Goods, c(2015,1), frequency=12 )
  plot(goods.ts)
  plot(diff(goods.ts))
  #단계2 : 시계열모형 추정과 모형 생성
  goods.auto <- auto.arima(diff(goods.ts))
  model <- arima(goods.ts, c(0, 1, 0))
  
  Call:
  arima(x = goods.ts, order = c(0, 1, 0))
  sigma^2 estimated as 2494162:  log likelihood = -351.35,  aic = 704.69
  #단계3 : 시계열모형 진단 : Box-Ljung 검정 이용
  Box.test(model$residuals, lag=1, type = "Ljung") 
  
  	Box-Ljung test
  
  data:  model$residuals
  X-squared = 16.9, df = 1, p-value = 3.94e-05
  #단계4 : 향후 7개월 예측
  goods.fore <- forecast(model, h=7) 
  # 80% 신뢰구간(Lo 80~Hi80), 95% 신뢰구간(Lo 95 ~ Hi 95)
  #단계5 : 향후 7개월 예측결과 시각화
  
  #모범 답안
  #Sales.csv 파일을 대상으로 시계열 자료를 생성하고, 각 단계별로 시계열 모형을 생성하여 예측하시오.
   
  goods <- read.csv("./data/Sales.csv", header = TRUE)
  
  tsGoods <- ts(goods$Goods, start=c(2015, 1), frequency=12)
  tsGoods # 2015.01 ~ 2018.05
  
  #단계2 : 시계열모형 추정과 모형 생성
  model <- auto.arima(tsGoods) # 시계열 예측모형 추정
  model
  
  #단계3 : 시계열모형 진단 : Box-Ljung 검정 이용
  Box.test(model$residuals, lag=1, type = "Ljung")
  
  #단계4 : 향후 7개월 예측
  fore <- forecast(model, level=c(80, 95), h=7)
  
  # 80% 신뢰구간(Lo 80~Hi80), 95% 신뢰구간(Lo 95 ~ Hi 95)
  단계5 : 향후 7개월 예측결과 시각화
  plot(fore)
  ```
  
  ![1569395745620](assets/1569395745620.png)



<br>

<br>

<br>

<br>

<br>

<br>

# 5. R Shiny

쉽고, 빠르게 상호작용이 가능한 반응형 웹 애플리케이션을 개발할 수 있도록 프레임워크 형태로 지원. R의 분석 결과를 반응형 웹으로 개발할 수 있도록 Rstudio에서 지원.

## 기본 예제

```R
#
# This is a Shiny web application. You can run the application by clicking
# the 'Run App' button above.
#
# Find out more about building applications with Shiny here:
#
#    http://shiny.rstudio.com/
#

library(shiny)

# Define UI for application that draws a histogram
ui <- fluidPage(

    # Application title
    titlePanel("Hello, R Shiny."),

    # Sidebar with a slider input for number of bins 
    sidebarLayout(
        sidebarPanel(
            selectInput(
                inputId="xAxis", 
                "Choose X axis",
                choices = c("mpg", "disp", "hp", "drat", "wt")
            ),
            selectInput(
                inputId="yAxis", 
                "Choose Y axis",
                choices = c("wt", "drat", "hp", "disp", "mpg")
            ),
            selectInput(
                inputId="pch", 
                "Choose shape",
                choices = c("circle-1"=1, "circle-2"=16, "square"=22)
            ),
            sliderInput(
                inputId="cex",
                "point size",
                min=0.1, max=3, value=1
            )
            
        ),

        # Show a plot of the generated distribution
        mainPanel(
           plotOutput(outputId="mtcarsPlot")
        )
    )
)

# Define server logic required to draw a histogram
server <- function(input, output) {
    
    output$mtcarsPlot <- renderPlot({
        title <- paste(input$xAxis, " VS ", input$yAxis)
        plot(
            mtcars[, c(input$xAxis, input$yAxis)],
            main=title,
            pch=as.numeric(input$pch),
            cex=input$cex
        )
    })
}

# Run the application 
shinyApp(ui = ui, server = server)
```

## 배포하기

:link:[shinyapps.io](https://www.shinyapps.io/)  접속하여 계정 생성후 절차 따르기.

```R
install.packages("rsconnect")
library(rsconnect)

#수동 배포
setAccountInfo(name='laughaway',
+                token='<TOKEN>',
+                secret='<SECRET>')

rsconnect::deployApp('c:/workspace_R/shiny-01')

#하거나 source edit 창에서 눈 모양을 버튼을 눌러서 배포도 가능하다
```

![1569392552909](assets/1569392552909.png)

<br>

# 복습

- 표본 추출해서 비율의 차이 비교 - 단일 집단 비율검점

  ```R
  binom.test()
  ```

- 단일 집단을 평균이 어떤 특정한 집단의 평균과의 차이를 검정 - 단일 집단 평균 검정

  ```R
  # 정규분포 검정
  shapiro.test()
  # 정규분포시
  t.test()
  # 정규분포가 아닐 시
  wilcox.test()
  ```

- 독립표본 이항 분포 비율 검정

  ```R
  prop.test()
  ```

- 독립표본 이항 분포 평균 검정

  ```R
  # 동질성 검정
  var.test()
  # 분산이 동질할 경우 
  t.test()
  # 분산이 동질하지 않을 경우
  wilcox.test()
  ```

- 대응 두 집단 (사건 전, 사건 후)

  ```R
  # 동질성 검정
  var.test()
  # 분산이 동질할 경우
  t.test(x, y, paired=T,...)
  # 분산이 동질하지 않을 경우
  wilcox.test()
  ```

- 세 집단 검정 검정

  ```R
  # 비율 검정 - prop.test()
  # 평군 검정 - 분산분석, F검정
  
  # 정균분포 검정 (동질성 검정 - bartlett.test)
  # 정규분포를 따르는 경우 aov()
  # 따르지 않는 경우 kruskal.test()
  ```

- 요인 분석

  > 다수의 변수를 대상으로 변수간의 관계를 분석하여 결과를 이용하여 상관분석이나 회귀분석의 설명변수(독립변수)로 활용하기 위해 수행하는 분석.

  - 주 성분 분석 - ```prcomp()```

  - 고유값(변수의 상관계수 행렬에서 얼마나 관련성이 있는지에 관한 실수값)으로 요인수 분석 - `eigen()`

  - 상관관계 분석 - 변수들간의 상관성을 이용해서 공통요인 추출 

    ```R
    factanal(데이터 셋, factors=요인 갯수, rotation=회전방법(varimax등), scores=점수 계산 방식)
    
    #요인분석결과에서 만약 p-value 값이 0.05 미만이면 요인수가 부족하다는 의미로 요인수를 늘려서 다시 분석을 수행해야 한다.
    
    #Uniqueness항목은 유효성을 판단하여 제시한 값으로 통상 0.5이하이면 유효한 것으로 본다
    
    # Loading 항목은 요인 적재값(Loadings)를 보여주는 항목으로 각 변수와 해당 요인 간의 상관관계계수를 제시한다. 요인 적재값(요인 부하량)이 통상 +0.4 이상이면 유의하다고 볼 수 있다.+0.4 미만이면 설명력이 부족한 요인(중요도가 낮은 변수)으로 판단할 수 있다
    
    # SS loadings 항목은 각 요인 적재값의 제곱의 합을 제시한 값으로 각 요인의 설명력을 보여준다.
    
    # Proportion Var 항목은 설명된 요인의 분산 비율로 각 요인이 차지하는 설명력의 비율이다.
    
    # Cumulative Var 항목은 누적 분산 비율로 요인의 분산 비율을 누적하여 제시한 값으로 정보손실이 너무 크면 요인분석의 의미가 없어진다.
    
             
    ```

- 고급 시각화

  - 시각화 주요 패키지: graphics, lattice, ggplot2, ggmap

  - 이산변수 시각화

    - barplot()
    - dotchart()
    - pie()

  - 연속변수 시각화

    - boxplot()
    - hist()
    - plot()

  - lattice 패키지

    > 서로 상관잇는 확률적 종속변수의 시각화에 사용. 특정 변수가 갖는 범주별로 독립된 패널을 격차(lattice)처럼 배치하여 여러 개의 변수에 대한 범주를 세부적으로 시각화 해주는 도구를 제공

    - histogram()
    - densityplot() - 연속형 변수 밀도 그래프
    - barchart()
    - dotplot() - 점 그래프
    - xyplot() - 교차 그래프
    - equal.count() - 데이터셋에 지정된 영역만큼 범주화
    - coplot() - 조건 변수와 관련 조건 그래프
    - cloud() - 3차원 산점도

    ```R
    install.packages("lattice")
    library(lattice)
    
    install.packages("mlmRev")
    library(mlmRev)
    
    #학생 대상 화확 점수를 기록한 데이터 셋
    data(Chem97)
    str(Chem97)  # data.frame':  31022 obs. of  8 variables:
    #gcsescore : gcse개인평균성적
    #lea : 지방교육청
    table(Chem97$score)
    head(Chem97,30) # 앞쪽 30개 레코드 
    
    #  히스토그램 
    histogram( ~ gcsescore, data=Chem97) 
    # gcsescore변수를 대상으로 백분율 적용 히스토그램
    
    # histogram(~x축 | 조건, dataframe)
    table(Chem97$score) #  0  2  4   6  8  10 <- 빈도수
    # score 변수를 조건으로 지정 
    histogram(~gcsescore | score, data=Chem97) # score 단위 
    histogram(~gcsescore | factor(score), data=Chem97) # score 요인 단위
    
    #  밀도 그래프 
    densityplot(~gcsescore | factor(score), data=Chem97, 
                groups = gender, plot.points=T, auto.key = T) 
    # 밀도 점 : plot.points=F
    # 범례: auto.key=T
    # 성별 단위(그룹화)로 GCSE점수를 밀도로 플로팅   
    
    
    
    ####막대 그래프 
    
    # 1) 데이터셋 가져오기
    data(VADeaths)  #사망연령대, 도시출신, 남녀
    VADeaths
    str(VADeaths)
    
    # 2) 데이터셋 구조보기
    mode(VADeaths) # numeric
    class(VADeaths) # matrix
    
    # 3) 데이터 리모델링
    # (1) matrix -> data.frame 변환
    df <- as.data.frame(VADeaths)
    str(df) # 'data.frame':	5 obs. of  4 variables:
    class(df) # "data.frame"
    df 
    
    # (2) matrix -> data.table 변환
    dft <- as.data.frame.table(VADeaths)
    str(dft) # 'data.frame':  20 obs. of  3 variables:
    class(dft) # "data.frame"
    dft # Var1  Var2 Freq -> 1열 기준으로 data.table 생성
    
    # 막대 그래프 그리기 
    barchart(Var1 ~ Freq | Var2, data=dft, layout=c(4,1))
    # Var2변수 단위(그룹화)로 x축-Freq, y축-Var1으로 막대차트 플로팅
    
    # 막대 그래프 그리기(origin 속성 사용)
    barchart(Var1 ~ Freq | Var2, data=dft, layout=c(4,1), origin=0)
    
    
    dotplot(Var1 ~ Freq | Var2 , dft) 
    
    dotplot(Var1 ~ Freq | Var2 , dft, layout=c(4,1)) 
    
    #Var2변수 단위로 그룹화하여 점을 연결하여 플로팅  
    dotplot(Var1 ~ Freq, data=dft, groups=Var2, type="o", 
            auto.key=list(space="right", points=T, lines=T)) 
    
    
    ######################### 산점도 그래프 ####################
    library(datasets)
    str(airquality) # datasets의 airqulity 테이터셋 로드
    
    airquality # Ozone Solar.R Wind Temp Month(5~9) Day
    
    # airquality의 Ozone(y),Wind(x) 산점도 플로팅
    xyplot(Ozone ~ Wind, data=airquality) 
    range(airquality$Ozone,na.rm=T)
    xyplot(Ozone ~ Wind | Month, data=airquality) # 2행3컬럼 
    xyplot(Ozone ~ Wind | factor(Month), data=airquality, layout=c(5,1))
    
    # airquality 데이터셋의 Month 타입변경(factor)
    convert <- transform(airquality, Month=factor(Month))
    str(convert) # Month 변수의 Factor값 확인
    # $ Month  : Factor w/ 5 levels "5","6","7","8"
    
    convert # Ozone Solar.R Wind Temp Month Day
    xyplot(Ozone ~ Wind | Month, data=convert, layout=c(5,1))
    # 컬럼 제목 : Month 값으로 출력
    
    
    #  quakes 데이터 셋으로 산점도 그래프 그리기 
    head(quakes)
    str(quakes) # 'data.frame':  1000 obs. of  5 variables:
    range(quakes$stations)
    
    # 지진발생 위치(위도와 경로) 
    xyplot(lat~long, data=quakes, pch=".") 
    # 그래프를 변수에 저장
    tplot <- xyplot(lat~long, data=quakes, pch=".")
    # 그래프에 제목 추가
    tplot2<-update(tplot,
                   main="1964년 이후 태평양에서 발생한 지진위치")
    2
    
    
    ################# 산점도 그래프 그리기 ####################
    # 1. depth 이산형 변수 범위 확인 
    range(quakes$depth)# depth 범위
    
    # 2. depth 변수 리코딩 : 6개의 범주(100단위)로 코딩 변경
    quakes$depth2[quakes$depth >=40 & quakes$depth <=150] <- 1
    quakes$depth2[quakes$depth >=151 & quakes$depth <=250] <- 2
    quakes$depth2[quakes$depth >=251 & quakes$depth <=350] <- 3
    quakes$depth2[quakes$depth >=351 & quakes$depth <=450] <- 4
    quakes$depth2[quakes$depth >=451 & quakes$depth <=550] <- 5
    quakes$depth2[quakes$depth >=551 & quakes$depth <=680] <- 6
    
    # 3. 리코딩 변수(depth2)를 조건으로 산점도 그래프 그리기
    convert <- transform(quakes, depth2=factor(depth2))
    xyplot(lat~long | depth2, data=convert)
    
    
    # 동일한 패널에 2개의 y축에 값을 표현
    xyplot(Ozone + Solar.R ~ Wind | factor(Month), data=airquality,
           col=c("blue","red"),layout=c(5,1))
    
    ######equal.count() 함수 이용 이산형 변수 범주화 #########
    # equal.count(data, number=n, overlang=0)
    
    # (1) 1~150을 대상으로 겹치지 않게 4개 영역으로 범주화
    numgroup<- equal.count(1:150, number=4, overlap=0)
    numgroup
    
    # (2) 지진의 깊이를 5개 영역으로 범주화
    depthgroup<-equal.count(quakes$depth, number=5, overlap=0)
    depthgroup
    
    #범주화된 변수(depthgroup)를 조건으로 산점도 그래프 그리기 
    xyplot(lat ~ long | depthgroup, data=quakes,
           main="Fiji Earthquakes(depthgruop)",
           ylab="latitude", xlab="longitude", pch="@",col='red' )
    
    #수심과 리히터규모 변수를 동시에 적용하여 산점도 그래프 그리기 
    magnitudegroup<-equal.count(quakes$mag, number=2, overlap=0)
    magnitudegroup
    
    # magnitudegroup변수 기준으로 플로팅
    xyplot(lat ~ long | magnitudegroup, data=quakes,
           main="Fiji Earthquakes(magjitude)",
           ylab="latitude", xlab="longitude", pch="@", col='blue')
    
    
    # 수심과 리히터 규모를 동시에 표현(2행 5열 패널 구조)
    xyplot(lat ~ long | depthgroup*magnitudegroup, data=quakes,
           main="Fiji Earthquakes",
           ylab="latitude", xlab="longitude",
           pch="@",col=c("red","blue"))
    
    
    # 이산형 변수로 리코딩한 뒤에 factor 형으로 변환하여 산점도 그래프 그리기 
    quakes$depth3[quakes$depth >= 39.5 & quakes$depth <= 80.5] <- 'd1' 
    quakes$depth3[quakes$depth >= 79.5 & quakes$depth <= 186.5] <- 'd2' 
    quakes$depth3[quakes$depth >= 185.5 & quakes$depth <= 397.5] <- 'd3' 
    quakes$depth3[quakes$depth >= 396.5 & quakes$depth <= 562.5] <- 'd4' 
    quakes$depth3[quakes$depth >= 562.5 & quakes$depth <= 680.5] <- 'd5'
    
    quakes$mag3[quakes$mag >= 3.95 & quakes$mag <= 4.65] <- 'm1' 
    quakes$mag3[quakes$mag >= 4.55 & quakes$mag <= 6.45] <- 'm2'
    
    convert <- transform(quakes, depth3=factor(depth3), mag3=factor(mag3))
    
    xyplot(lat ~ long | depth3*mag3, data=convert, 
                        main="Fiji Earthquakes", ylab="latitude", 
                        xlab="longitude", pch="@", col=c("red", "blue"))
    
    
    ################# 조건 그래프 #################
    coplot(lat~long | depth, data=quakes) # 2행3열, 0.5, 사이간격 6
    coplot(lat~long | depth, data=quakes, overlap=0.1) # 겹치는 구간 : 0.1
    coplot(lat~long | depth, data=quakes, number=5, row=1) # 사이간격 5, 1행 5열
    
    #  패널과 조건 막대에 색 적용 후 조건 그래프 그리기 
    coplot(lat~long | depth, data=quakes, number=5, row=1, panel=panel.smooth)
    coplot(lat~long | depth, data=quakes, number=5, row=1, 
           col='blue',bar.bg=c(num='green')) # 패널과 조건 막대 색 
    
    
    # 3차원 산점도 그래프 
    #  위도, 경도, 깊이를 이용하여 3차원 산점도 그래프 그리기 
    cloud(depth ~ lat * long , data=quakes,
          zlim=rev(range(quakes$depth)), 
          xlab="경도", ylab="위도", zlab="깊이")
    
    #   테두리와 회전 속성을 추가하여 3차원 산점도 그래프 그리기 
    cloud(depth ~ lat * long , data=quakes,
          zlim=rev(range(quakes$depth)), 
          panel.aspect=0.9,
          screen=list(z=45,x=-25),
          xlab="경도", ylab="위도", zlab="깊이")
    ```

  - ggplot2 패키지

    > 기하학적 객체들(점, 선, 막대 등)에 미적특성(색상, 모양, 크기)을 적용하여 시각화하는 방법을제공

  - ggmap 패키지

    > 지도를 기반으로 위치, 영역, 시각과 공간에 따른 차이 및 변화를 다루는 공간시각화에 적합

    - geocode() - 리주소 또는 장소 이름을 이용하여 지도 정보(위도, 경도) 얻을 수 있음
    - get_goolemap() - 구글 지도서비스 API에 접근하여 정적 지도 다운로드 지원과 지도에 마커(maker)등을 삽입하고 자신이 원하는 줌 레벨과 중심점을 지정하여 지도 정보 생성
    - get_map() - 지도 서비스 관련 서버(GoogleMaps, OpenStreetMap, StamenMapsor, Naver Map)에 관련된 질의어를 지능형으로 인식하여 지도 정보 생성
    - get_navermap() - 네이버 지도서비스 API에 접근하여 정적 지도 다운로드 지원
    - ggimage() - ggplot2 패키지의 이미지와 동등한 수준으로 지도 이미지 생성
    - ggmap() 과 ggmapplot() - get_map()에 의해서 생성된 픽셀 객체를 지도 이미지로 시각화
    - qmap() - ggmap()과 get_map() 통합 기능
    - qmplot() - ggplot2 패키지의 qplot()과 동등한 수준으로 빠르게 지도 이미지 시각화

    ```R
    #get_googlemap(center, zoom, size, scale, format, maptype, language, sensor, color, markers, path)
    #get_map(location, zoom, scale, maptype, source, color, language, api_key)
    
    ########### 4.1 Google Static Maps API 이용 
    remove.packages("ggmap")
    remove.packages("tibble")
    #install.packages('devtools')
    library('devtools')
    install_github('dkahle/ggmap', ref="tidyup")
    library('ggmap')
    
    #구글에 로그인하여 https://cloud.google.com/maps-platform/#get-started 에 접속 
    
    register_google(key='발급받은키') # 부여받은 키 등록
    names <- c("용두암","성산일출봉","정방폭포",
                "중문관광단지","한라산1100고지","차귀도")
    addr <- c("제주시 용두암길 15",
               "서귀포시 성산읍 성산리",
               "서귀포시 동홍동 299-3",
               "서귀포시 중문동 2624-1",
               "서귀포시 색달동 산1-2",
               "제주시 한경면 고산리 125")
    gc <- geocode(enc2utf8(addr))
     
    # 지도위치정보 가져오기
    gc <- geocode("seoul")
    center <- as.numeric(gc)
    center # 위도,경도
    
    # 지도 정보 생성하기
    map <- get_googlemap(center = center, language="ko-KR", color = "bw", scale = 2 )
    
    # 지도 이미지 그리기
    ggmap(map, extent = 'device')
    
    # 지도 위에 marker 삽입하기 
    df <- round(data.frame(x=jitter(rep(-95.36, 25), amount=.3), 
                  y=jitter(rep(29.76, 25), amount=.3) ), digits=2)
    
    map <- get_googlemap('houston', markers=df, path=df, scale=2)
    
    ggmap(map, extent = 'device')
    
    
    
    ###############종합지도 서비스 관련 API 이용  
    
    # roadmap 타입으로 지도 그리기
    map <- get_map(location ="london", zoom=14, maptype='roadmap', scale=2)
    # get_map("중심지역", 확대비율, 지도유형) : ggmap에서 제공하는 함수 
    ggmap(map, size=c(600,600), extent='device')
    
    # watercolor 타입으로 지도 그리기
    map <- get_map(location ="seoul", zoom=8, maptype='watercolor', scale=2)
    ggmap(map, size=c(600,600), extent='device')
    
    
    
    
    ######## 지도 이미지에 레이어 적용  
    
    # 서울지역 4년제 대학교 위치 표시 
    university <- read.csv("./data/university.csv",header=T)
    university # # 학교명","LAT","LON"
    
    # 레이어1 : 정적 지도 생성 
    kor <- get_map('seoul', zoom = 11, maptype = 'watercolor')
    ggmap(kor)
    
    # 레이어2 : 지도위에 포인트 추가 
    ggmap(kor)+geom_point(data=university, aes(x=LON, y=LAT,color=factor(학교명)),size=3)
    kor.map <- ggmap(kor)+geom_point(data=university, aes(x=LON, y=LAT,color=factor(학교명)),size=3)
    
    # 레이어3 : 지도위에 텍스트 추가
    kor.map + geom_text(data=university, aes(x=LON+0.01, y=LAT+0.01,label=학교명),size=5)
    
    
    # 지도 저장하기
    ggsave("./otuput/university1.png",width=10.24,height=7.68)
    # 밀도 적용 파일 저장
    ggsave("./otuput/university2.png",dpi=1000) # 9.21 x 7.68 in image
    ```

    

  