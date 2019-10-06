# Github 특강 - 1

## 목차

- [Github 특강](#github-특강)
  - [마크다운 기초](#i-마크다운-기초)
  - [마크다운 문법](#ii-마크다운-문법)
  - [코드 블락](#iii-코드-블락)
  - [Github First!!!](#iv-github-first)

## Github 특강

### I. 마크다운 기초

가족마크다운 문법

- `#`은 대제목
  - ex) `# 대제목`
    - `tab` 들여쓰기
- `##`은 중제목
- `###`은 소제목

<br>

### II. 마크다운 문법

 `*`,  `**`,  `***`

1. 강조: **이게 강조된 구문**
2. 기울임: *이게 기울여진 구문*
3. ***이게 강조된 기울여진 구문***

> 와 이거는 이용문을 쓸 때 쓰면 되겠네 :

 ### III. 코드 블락

코드블락을 쓸 때는 ```을 활용한다.

```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello world");
    }
}

```

```python
class Person:
    def __init__(self, name):
        self.name = name
```

 ### IV. Github First!!!

Github에 가입하고 설치하고 이 파일을 올려보자!

1. 가입: Mr-Laughaway , mr.laughaway@gmail.com 으로 가입하였다.
2. <https://git-scm.com/> 에 접속해서 download
3. `Git bash` 실행
4. `TIL/190523/` 생성후 `Github.md` 파일을 해당 위치로 카피 (cd, mkdir, md 등 커맨드 사용)
5. `TIL/` 에서 `git init` -> `.git/` 가 생김
6. `git status` 해보면 변경됐으나 적용되지 않은 사항이 보임
7. `git add .` 으로 변경사항을 적용
8. `git commit` 해보면 e-mail / name 등을 설정 하라고 나옴
9. `git config --global user.email "mr.laughaway@gmail.com"`
10. `git config --global user.name "Jaehyun Kim"`
11. `git commit -m "first"` : first라는 msg를 남기며 commit`
12. `git remote add origin https://github.com/LaughawayKim/TIL.git` 만든 repository추가?
13. `git push -u origin master`
14. 변경 확인



