# 있슈왔슈(IssueWhatShow) 다이어리

## 1일차(2019/09/30)

오늘은 전체적인 서버 아키텍쳐에 대해 토의하였고, 본격적인 개발에 앞서 형태소 분석기에 대한 조사와 테스트 코드 등을 작성을 시작하였다.

## 2일차(2019/10/01)

오늘은 취업특강이 있는 날로 휴가를 내어 집에서 작업을 진행하였다.

- Github 팀 프로젝트 방법 및 브랜치 전략 스터디

- 형태소 분석기 테스트 작업

  - OpenKoreanText 완료

  - Khaiii 완료(Linux, Python)

    - CentOS 에 Python 3.x 설치 및 alias 변경

    - cmake 설치

    - gcc, gcc-c++ 설치

    - devtoolset-4 repo 업데이트 및 gcc 버전 업그레이드(4.9 이상 필요)

      ```bash
      sudo yum install -y centos-release-scl-rh
      sudo yum install -y devtoolset-4-gcc devtoolset-4-gcc-c++
      
      scl enable devtoolset-4 bash #활성화 시
      ```



