<h1>Insight 특강 2</h1>

# 목차

- [프로젝트 관리](#프로젝트-관리)
  - [프로젝트](#1-프로젝트)
  - [프로젝트 발주 및 제안 프로세스](#2-프로젝트-발주-및-제안 프로세스)
  - [IT 프로젝트](#3-it-프로젝트)
    - [SI(System Integration) / SM(System Management)](#31-sisystem-integration--smsystem-management)
    - [IT 프로젝트 규모](#32-it-프로젝트-규모)
    - [프로젝트 현실 (IT 프로젝트의 특징)](#33-프로젝트-현실-it-프로젝트의-특징)
  - [프로젝트 관리 필요성](#4-프로젝트-관리-필요성)
  - [프로젝트 관리 영역](#5-프로젝트-관리-영역)
  - [프로젝트 관리 핵심 요소](#6-프로젝트-관리-핵심-요소)
  - [프로젝트 수행 방법론](#7-프로젝트-수행-방법론)
    - [방법론(Methodology)의 개념](#71-방법론methodology의-개념)
    - [개발 방법론과 관리 방법론](#72-개발-방법론과-관리-방법론)
      - [Waterfall 모델](#waterfall-모델)
      - [Agile 방법론](#722-agile-방법론)
  - [프로젝트 착수 단계](#8-프로젝트-착수-단계)
  - [프로젝트 계획 단계](#9-프로젝트-계획-단계)
  - [프로젝트 설계 단계](#10-프로젝트-설계-단계)
    - [산출물](#산출물)
  - [프로젝트 실행 단계](#11-프로젝트-실행-단계)
    - [협업](#111-협업)
    - [갈등 관리](#112-갈등-관리)
    - [형상 관리](#113-형상-관리)
    - [일정 체크](#114-일정-체크)
    - [프로젝트 완료(결과) 보고서](#115-프로젝트-완료결과-보고서)

<br>

<br>

# 프로젝트 관리

## 1. 프로젝트

- 유니크한 제품, 서비스, 결과 등을 만들기 위하여 한시적으로 수행되는 작업. 
- ***한정된 기간과 비용 내에서 정해진 자원을 활용하여 완수하고자 하는 과제*** .

- 전세계 GDP 23% 정도가 프로젝트를 통하여 파생되고 있는 것으로 파악(ISO, 2013)
- 수주업 - 고객이 발주한 사업을 타 회상들과의 경쟁을 통해 획득하고 이를 수행하는 business를 영위하는 업종



![How to write a business proposal in response to a government RFP](https://7yugk36h4nq3mz5fj3hizpfh-wpengine.netdna-ssl.com/wp-content/uploads/2015/05/request-for-proposal.jpg)



## 2. 프로젝트 발주 및 제안 프로세스

- 사업 참여의사 결정

- 현실적인 수주 확도는 어느 정도인가

- 성공적인 수행이 가능한가?

- 매출 규모와 이익율은 어느 정도인가? 

  보통 20~30% 남아야 함.

  국내 IT는 10%이하

- 고객과의 관계유지를 위해 전략적으로 필요한가?

<br>

## 3. IT 프로젝트

>  IT 프로젝트 유형은 크게 ***컨설팅***, ***시스템 구축(System Integration)***, ***운영 및 유지보수(IT Outsourcing)**으로 구분됨

### 3.1. SI(System Integration) / SM(System Management)

|           | SI (신규 개발) | SM(유지보수) |
| :-------: | :------------: | :----------: |
| 업무 광도 |       강       |    중 /약    |
| 기술스펙  |       ↑        |      -       |

![img](http://www.neodream.co.kr/default/img/business/sism.jpg)

### 3.2. IT 프로젝트 규모

프로젝트 규모가 작을 수록 성공확률은 높아지며, 규모가 커질수록 성공확률이 현저하게 낮아짐

- 소형 프로젝트

  0명 이내 수행인원. 수행기간 6개월이내.

- 중형 프로젝트

  00명 이내 수행인원. 수행기간 12개월 ?

- 대형 프로젝트

  000명 이내 수행. 수행기간 수 년.

### 3.3. 프로젝트 현실 (IT 프로젝트의 특징)

- IT 프로젝트(특히 SW개발)는 ***진행상황이 가시적으로 눈에 보이지 않고 개발자 의존도가 높은 속성이 존재***하기 때문에 타 업종 프로젝트보다 훨씬 관리하기가 ***어려움***

- ***초기에 사용자 요구사항을 명확히 정의하기 여렵고*** 요구사항 변경에 따라 설정된 ***개발 범위가 프로젝트 진행 중 지속적으로 변경***되고 추가되는 특징이 있음

- 전세계 IT 프로젝터의 28%는 중도 하차하며, 오직 26%만이 예산과 기한 내에 완료된다.

  >  미국의 1450개 대기업을 대상으로 조사한 결과 IT 프로젝트의 ***성공확률은 30% 미만***이며 완료된 프로젝트의 ***50% 이상이 책정된 예산의 189% 이상을 지출***한다. 특히, 1년 이상 장기 프로젝트의 경우 ***35% 이상이 계획된 일정의 2배 이상***의 기간이 소요되었다. - STANDISH GROUP 

- IT 프로젝트 주요 실패 요인

  | 국내 주요 실패 요인            | 해외 주요 실패 요인       |
  | ------------------------------ | ------------------------- |
  | *고객의 잦은 요구 변경*        | *불완전한 요구사항*       |
  | ***기술, 경험 부족***          | ***사용자 참여 부족***    |
  | ***부정확한 기간, 비용 예측*** | 자원 부족                 |
  | ***고객, 현업의 참여 부족***   | 비현실적인 기대감         |
  | 영업 부서의 과욕               | 경영층의 지원 부족        |
  | 고객, 현업과의 인간관계 부실   | *요구사항 및 사양의 변경* |
  | 스케쥴 관리 미흡               | ***프로젝트 계획 부족***  |
  | ...                            | ..                        |

- Crunch Mode

  - 크런치 모드(Crunch Mode)는 프로젝트의 마감일(Deadline)을 앞두고 일정을 맞추기위해 팀원들이 수면, 영양, 사회 생활, 위생 문제 등을 포기한 채 고강도 근무체제를 유지하는 방식을 의미하는 용어
  - 게임 업계를 통해 알려졌지만 과거 IT 업계 전체에 만연해 있었떤 프로젝트 수행 방식으로 현재 이를 개선하기 위한 사회적 분위기 조성과 노력이 지속되고 있음(ex. 주 52시간 근무제도) - 84% 경험

- 동/서양 프로젝트 차이

  ![img](https://t1.daumcdn.net/cfile/tistory/246D1344525FDB9507)

  - 서양의 문화는 가업 목표라는 객체 중심으로 프로젝트를 인식하여 계약을 체결하고 프로젝트 수행 중 발생하는 계약 범위 밖의 요구사항은 쉽게 거절할 수 있기 때문에 수행 및 관리가 비교적 용이함
  - 동양(ex. 우리나라)에서는 초기에 설정한 계약상의 프로젝트 목표도 중요하지만 고객과의 관계 유지가 더 중요하기 때문에 고객의 요구에 따라 목표와 범위가 수시로 변동되어 수행 및 관리가 매우 어려움


​	<br>

## 4. 프로젝트 관리 필요성

점점 복잡해지고 많은 이슈를 내재하고 있는 프로젝트의 성공적인 수행을 위해서는 체계적인 프로젝트 관리가 필수 사항임

<br>

## 5. 프로젝트 관리 영역

프로젝트 관리 영역은 총 10개의 영역으로 구성되어 있음

범위, 일정, 원가, 품질 .....

![img](https://t1.daumcdn.net/cfile/tistory/19641B3F51551E391B)

<br>

## 6. 프로젝트 관리 핵심 요소

***과제 성격의 소규모 프로젝트에서는 범위, 일정, 품질에 촛점을 맞추어야 함***. (**Scope, Cost, Time** -> Quality)

<br>

## 7. 프로젝트 수행 방법론

### 7.1. 방법론(Methodology)의 개념

> Methodology = Method + Knowledge
>
> ***방법론이란 지식을 기반으로 일을 수행하는 절차, 방법 원칙 등을 정의한 것***

<br>

### 7.2. 개발 방법론과 관리 방법론

![ê°ë° ë°©ë²ë¡ ê³¼ ê´ë¦¬ ë°©ë²ë¡ ì ëí ì´ë¯¸ì§ ê²ìê²°ê³¼](http://cfs4.blog.daum.net/upload_control/download.blog?fhandle=MDh0dFhAZnM0LmJsb2cuZGF1bS5uZXQ6L0lNQUdFLzAvMTAuSlBHLnRodW1i&filename=10.JPG)

#### 7.2.1. Waterfall 모델

![waterfall modelì ëí ì´ë¯¸ì§ ê²ìê²°ê³¼](https://i2.wp.com/s3.amazonaws.com/production-wordpress-assets/blog/wp-content/uploads/2016/12/08151155/waterfall-model.png?fit=604%2C270&ssl=1)

- 현장의 거의 대부분의 프로젝트는 초기에 상세 개발 계획을 모두 수립하고 요구분석-> 설계 -> 코딩 -> 테스트 등 순차적으로 개발을 진행하고 산출물 중심으로 관리하는 Waterfall 모델을 사용함
- Waterfall 모델을 활용할 경우 시스템이 구현되어 시각적으로 확인되기 전까지 고객은 자신들이 요구했던 사항들의 실체를 알기 어려운 단점이 있어 잦은 변경이 발생됨

<br>

#### 7.2.2. Agile 방법론

​	![Agileì ëí ì´ë¯¸ì§ ê²ìê²°ê³¼](https://www.sam-solutions.com/blog/wp-content/uploads/2018/07/AGILE@2x.png)

- 애자일 방법론은 Waterfall 모델과 달리 뒤 단계를 미리 예측하여 개발하지 않고, 일정한 반복주기를 가지고 끊임없이 프로토타입을 만들어 내며 피요할 때마다 요구사항을 더하고 수정하여 커다란 소프트웨어를 개발해 나가는 방식임
- 이 과정 각각에 이해관계자를 참여시켜 요구사항 수집과 결과 검증을 모두 거쳐갈 수 있는 장점이 있음
- 반복주기(Spring)  - 2~4주 (일정)에서 S1 -> S2 -> S3 -> S4 각각이 분석, 설계, 개발, 테스트, 검증을 포함한다.

***애자일 방법론을 적용하여 개발할 경우 반드시 고려해야 할 사항은?***

- 국내에서 쉽지 않다.. 왜?
  - 개발자들이 오랫동안 일해 온 방식을 바꿔야 함
  - 고객이 불편해 함

<br>

## 8. 프로젝트 착수 단계

- 조직 구성
- 팀 내 협의 하에 프로젝트 Ground Rule(기본규칙) 설정
  - 근무시간
  - 일하는 방식
  - 회의
  - 기타

<br>

## 9. 프로젝트 계획 단계

- 요구사항(SPEC)을 분석하여 최대한 명확화하도록 노력

  - 기능 구현 요구사항
  - 품질관련 요구사항
  - 기타 요구사항

  -> **프로젝트 공식 과업범위 결정**

- 요구사항(SPEC)이 불분명한 경우

  ![ê°ë° ê·¸ë¤ì ëí ì´ë¯¸ì§ ê²ìê²°ê³¼](https://miro.medium.com/max/1838/1*DYLGTNodpq9Fal-prB2rHg.png)

- 유구사항(SPEC) 이 자주 변경되면

  ***프로젝트 후반으로 갈 수록 노력은 더하지만 효과(품질)는 떨어짐***

<br>

## 10. 프로젝트 설계 단계

### 산출물

- 요구사항 정의서(명세서)

  ![ìêµ¬ì¬í­ ì ììì ëí ì´ë¯¸ì§ ê²ìê²°ê³¼](https://www.itlab.co.kr/v7/files/2016/08/29/c9fd6243628fe5441d99f1835ffbac93050727.jpg)

- Use case 명세서

  ***요구사항에 대하여 액터와 시스템 활동 및 상호간의 활동에 대하여 순서화된 시나리오를 기술하고 연관관계를 도식화한 다이어그램***

  ![ê´ë ¨ ì´ë¯¸ì§](http://mblogthumb1.phinf.naver.net/20150102_180/whatclouds_1420138165269yXCbe_PNG/%BD%BA%C5%A9%B8%B0%BC%A6_2015-01-02_%BF%C0%C0%FC_3.48.45.png?type=w420)

- 요구사항 추적표

  - 요구사항 대비 단계별 산출물이 일관성을 가지는지를 프로젝트 전반에 걸쳐 추적하고 관리
  - 프로젝트 수행 과정에서 요구사항이 추가 혹은 변경될 경우 영향력 평가에도 활용

  ![img](https://t1.daumcdn.net/cfile/tistory/2362603556FA3F050E)

- WBS(Work Breakdown Structure)

  **업무 분업 구조**(work-breakdown structure, WBS)[[2\]](https://ko.wikipedia.org/wiki/업무_분업_구조#cite_note-2), **작업 분해 구조**, **작업 분류 체계**, **작업 분할 구조**, **작업 분할 구도**는 [프로젝트 관리](https://ko.wikipedia.org/wiki/프로젝트_관리)와 [시스템 공학](https://ko.wikipedia.org/wiki/시스템_공학) 분야에서 프로젝트의 더 작은 요소로 분해시킨 [딜리버러블](https://ko.wikipedia.org/w/index.php?title=딜리버러블&action=edit&redlink=1) 지향 분업 구조이다. 업무 분업 구조는 팀의 작업을 관리 가능한 부분들로 조직화해놓은 주된 제품 딜리버러블이다. [프로젝트 관리 지식 체계](https://ko.wikipedia.org/wiki/프로젝트_관리_지식_체계) (PMBOK 5)는 업무 분업 구조를 "[프로젝트 팀](https://ko.wikipedia.org/w/index.php?title=프로젝트_팀&action=edit&redlink=1)이 프로젝트 목표를 달성하고 필요한 딜리버러블을 만들기 위한 총 업무 범위의 계층적 분해"로 정의한다.

  업무 분업 구조 요소는 [상품](https://ko.wikipedia.org/wiki/상품), [데이터](https://ko.wikipedia.org/wiki/자료), [서비스](https://ko.wikipedia.org/wiki/서비스), 또 이들 간의 어떠한 결합이 될 수 있다. WBS는 또한 스케줄 개발 및 통제를 위한 지침 제공과 더불어 세세한 비용 예측 및 통제에 필요한 프레임워크를 제공한다.[[](https://ko.wikipedia.org/wiki/업무_분업_구조#cite_note-BAH-3)

  ![WBSì ëí ì´ë¯¸ì§ ê²ìê²°ê³¼](https://m6n6j6i4.stackpathcdn.com/wp-content/uploads/2017/09/Primavera-P6-WBS-Summary-Activity-and-Deliverable-Completion-Dates-WBS-Summary-Activity-and-Deliverable-Completion-Dates-Fig-1.jpg)
  - 프로젝트 일정계획 수립 시 고려해야 될 사항은...

    - 개발 내역에 대한 기술적인 낭이도를 사전에 평가해야 하고...

    - 업무를 담당하는 팀원 각각의 능력을 고려하되...

    - 개발 과정에서 예상치 못한 이슈가 발생하는 경우가 많기 때문에 이슈를 해결할 버퍼를 고려해서 일정을 계획하는 것이 바람직함

      ***Critical Chain Method***

  - 프로젝트 설계가 중요한 이유

    - 기능, 데이터, UI, 아키텍쳐 요구사항 등을 고려한 체계적인 설계를 통해...
    - 불필요한 코드를 줄이고 테스트와 재작업이 쉬운 코드를 만들어내며...
    - 개발 과정에서 무한 수정/변경 등의 삽질을 방지할 수 있을 뿐만 아니라...
    - 향후 수정 및 유지보수가 용이하여 운영 생산성이 향살될 수 있음

    > ***부실한 설계는 프로젝트에서 공정 지연과 품질 저하를 야기시키는 요인임***

- 클래스 설계서

- 사용자 인터페이스 설계서

  시스템이 제공하는 사용자 인터페이스의 전체 구조와 메뉴 형식, 화면 목록과 화면의 상세 설계 내역을 기술(화면 정의서, 화면 설계서, 메뉴 구성도 등)

- 시스템 인터페이스 설계서

  시스템의 내/외부 인터페이스를 식별하고 인터페이스의 상세 명세를 기술

- 아키텍쳐 설계서

  시스템의 품질을 확보하기 위하여 전체 시스템에 대한 청사진으로서의 아키텍쳐를 작성하고 관련된 아키텍처 요구사항 및 구현방안을 기술***(시스템 구성도)***

- 엔티티 관계 모형 설계서

  시스템의 교구사항을 만족하기 위한 주요 엔티티 및 엔티티간의 관계를 표현하고 인티티에 대한 명세를 기술***(데이터 모형 설계서)***

- 데이터베이스 설계서 



## 11. 프로젝트 실행 단계

### 11.1. 협업

각자가 맡은 일을 완수하되 서로의 업무를 돕는...

> 현장에서 개발 능력만큼 중요하게 보는 것이 바로 동료와의 협업 능력임

### 11.2. 갈등 관리 

*프로젝트 수행 중 갈등은 필연적으로 발생하는데...* 

- 개인별 이기주의를 최대한 자제
- 팀원간 상호 배려 및 존중이 필수
- 자신의 일에 대한 책임감을 가지는 자세
- 함께 이슈를 해결해나가려는 노력

### 11.3. 형상 관리

> 체계적인 변경통제와 형상관리가 필수

버전, 이슈, 배포, 빌드, 릴리즈

- 다양한 운영체제 환경에서 여러가지 언어로 서로 다른 종류의 개발 도구를 통해 다수의 개발자들이 함께 작업하는 IT 프로젝트의 특성상 복잡한 개발 과정과 산출물을 체계적이고 효율적으로 관리하기 위해 형상관리는 필수임
- 형상관리를 통해 버전(변경이력) 관리, 소스코드 재사용 및 이전 버전의 롤백이 가능해져 문제 해결 시간이 단축되고, 소스통합 자동화 및 별렬 개발을 통해 개발 생상성 및 품질 향상을 도모할 수 있음(ex. CVS, SVN, Github 등)

### 11.4. 일정 체크

- 일정 지연은 주로 계획, 기술, 및 인력부족, 실행 과정 중 괸리부족으로 발생한다
  - 일정 추정이 비현실적인 경우
  - 과업범위에 비해 인력이 부족
  - 기술 구현능력이나 경험 부족
  - ***타이트한 진척관리 부족*** (관리가능)
  - ***변경 및 형상관리가 제대로 이루어지지 않은 경우*** (관리가능)

- 프로젝트 일정 지연의 심리적 요인

  - ***"학생 증후군(Student Syndrome)"***

  - ***"파킨슨의 법칙(Parkinson's law)"***

    사람(팀원)들은 일을 할 때 대게 주어진 기간을 다 사용하려는 습관이 있다는 법칙

  - ***"자기 방어(Self-Protection)"***

    자신에게 배정된 작업을 일찍 완료하면 오히려 관리자에 의해 추가적인 작업이 할당되어 일만 늘어나게 됨

    또한 일을 신속하게 잘한다는 선입관이 생겨 다음 번에는 더 짧은 납기를 요구하므로 작업 완료를 철저히 숨기게 됨

- 일정 지연을 해결하는 법

  계획대비 실적을 평가하여 일정이 지연될 경우 적절한 대응

  - 계획 -> 변경요청 (사례: 일정연기, 거의 불가능)
  - 실적 -> 변경요청 (사례: 야근, 주말근무)
  - 병행 작업

  ***Fast Tracking & Crashing***



### 11.5. 프로젝트 완료(결과) 보고서

***착수 할 때 기획하고 진행 중 작성하며 종료할 때 완료하는 것***



