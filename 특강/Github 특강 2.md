Github 특강 - 2

[bit.do/openb](http://bit.do/openb)

| Github 정보      |                                                              |
| ---------------- | ------------------------------------------------------------ |
| 기술 면접 가이드 | https://github.com/JaeYeopHan/Interview_Question_for_Beginner |
| 채용 관련 가이드 | https://github.com/jojoldu/junior-recruit-scheduler          |
| 치트시트!        | http://ndpsoftware.com/git-cheatsheet.html                   |
| .gitignore 헬퍼  | http://gitignore.io/                                         |

<br>

# 목차

- Git
- Github Pages
- Branch

<br>

<br>

# I. Git

> Git 은 분산버전관리시스템(DVCS)이다.
>
> 소스코드의 이력을 관리한다.

- 참고 문서
  - [Git scm](https://git-scm.com/book/ko/v2)
  - [Git 입문](https://backlog.com/git-tutorial/kr/)

## 1. git 설정

git 커밋을 하기 위해서는 초기에 작성자(author) 설정을 반드시 하여야 한다.

```bash
$ git config --global user.name {'사용자이름'}
$ git config --global user.email {'사용자 이메일'}
```

현재 global로 설정된 환경설정을 확인하기 위해서는 아래의 명령어를 작성한다.

```bash
$ git config --global --list
user.email=mr.laughaway@gmail.com
user.name=Mr-Laughaway
```

<br>

## 2. git 활용 기초

1. 로컬 git 저장소 설정

   ```bash
   $ git init
   Initialized empty Git repository in C:/Users/student/test/.git/
   student@M50320 MINGW64 ~/test (master)
   $
   ```

   - 해당 디렉토리에 ```.git/``` 폴더가 생성된다.
   - 항상  `git init` 하기 전에는 해당 폴더가 이미 로컬 저장소인지((master) 여부)를 확인하여야 한다.

2. add

   ```bash
   $ git add .
   $ git add README.md a.txt
   $ git add folder/
   $ git status
   On branch master
   
   No commits yet
   
   Untracked files:
     (use "git add <file>..." to include in what will be committed)
   
           README.md
   
   nothing added to commit but untracked files present (use "git add" to track)
   ```

   - ```add``` 명령어를 통해서 `Working Directory`에서 `INDEX(staging area)`로 특정 파일들을 이동시킨다.
   - 커밋할 목록을 쌓는 것이다.

3.  commit

   ```bash
   $ git commit -m '커밋메시지'
   $ git commit
   [master (root-commit) 4becf23] Add README.md
    1 file changed, 0 insertions(+), 0 deletions(-)
    create mode 100644 README.md
   $ git log
   ```

4. 커밋 히스토리 확인하기(log)

   ```bash
   $ git log
   $ git log -2
   $ git log --oneline
   ```

5. 현재 git 상태 알아보기(status) **중요! 자주 입력해서 확인하자!**

   ```bash
   $ git status
   ```

<br>

## 3. 원격저장소(remote) 활용하기

### i. 기초

1. remote 저장소 등록

   ```bash
   $ git remote add origin {github URL}
   ```

   - 원격 저장소를 origin 이라는 이름으로 `URL`을 등록한다.

2. remote 저장소 확인

   ```bash
   $ git remote -v
   ```

3. remote 저장소 삭제

   ```bash
   $ git remote rm {저장소 이름}
   ```

### ii. Push-Pull

1. 원격 저장소로 보내기(push)

   ```bash
   $ git push origin master
   ```

2. 원격 저장소로부터 가져오기(pull)

   ```bash
   $ git pull origin master
   ```

### iii. Push-Pull 시나리오

> Local A, Local B, Github 로 활용하는 경우 원격저장소 이력과 달라져서 충돌이 발생할 수 있다. 따라서, 항상 작업을 시작하기전에 pull을 받고, 작업을 완료한 이후에 push 를 진행하면 충돌 사항이 발생하지 않는다.

1. auto-merge

   동일한 파일을 수정하지 않은 경우 자동으로 merge commit 이 발생한다.

   ```
   1. Local A에서 작업 후 Push
   2. Local B에서 작업 시 pull을 받지 않음
   3. Local B에서 다른 파일 작업 후 commit -> push
   4. 오류 발생(~~git pull~~)
   5. Local B에서 git pull
   6. 자동으로 vim commit 할 수 있도록 뜸
   7. 저장하면 merge commit 발생
   8. Local B에서 git push!
   ```

2. merge conflict

   - 다른 이력(커밋)으로 동일한 파일이 수정되는 경우 merge conflict 발생
   - 직접 충돌 파일을 해결해야 한다.

   ```
   1. Local A에서 작업 후 Push
   2. Local B에서 작업 시 pull을 받지 않음
   3. Local B에서 동일 파일 작업 후 commit -> push
   4. 오류 발생(~~git pull~~)
   5. Local B에서 git pull
   6. 충돌 발생(merge conflict)
   7. 직접 오류 수정 및 add, commit
   8. Local B에서 git push
   ```

   - ```git status``` 명령어를 통해 어느 파일에서 충돌이 발생하였는지 확인 가능

   - 실제 파일 예시

     ```markdown
     <<<<<<<< HEAD
     Local B작업
     =======
     원격 저장소에 기록된 작업
     >>>>>>>> aslkdfjasdaslkkdfks11283lsfskdf
     ```

<br>

## 4. 되돌리기

1. staging area 에서 `unstage`

   ```bash
   $ git status
   $ git reset HEAD b.txt
   ```

2. `commit` 메시지 수정하기

   ```bash
   $ git commit --ament
   ```

   - 커밋 메시지를 수정하게 되면 해시값이 변경되어 이력이 변화하게 된다.
   - 따라서 원격 저장소에 push된 이력이라면 절대 변경하면 안된다!
   - 커밋하는 과정에서 파일을 빠뜨렸다면, 위의 명령어를 통해서 수정할 수도 있다.

   ```bash
   $ git add omit_file.txt
   $ git commit --amend
   ```

3. working directory 변경사항 버리기

   ```bash
   $ git checkout -- 파일명
   ```

   변경사항이 모두 삭제되고, 해당 파일의 이전 커밋 상태로 변화한다.

4. 기타 꿀팁

   ```bash
   # 팁
   # 커밋된 사항이면 어떤 것이든 복구가 가능하다
   # 아래는 여러가지 상황을 알 수 있는 유용한 command
   $ git reflog
   $ git diff
   
   # 한번에 add + commit 하기
   $ git commit -a -m '한번에 한다'
   ```


<br>

# II. Github Pages

## 1. Github에 page repository 생성

> github에서 new repository를 통하여 `{github id}.github.io` 라는 이름의 레포지토리를 생성한다.

## 2. Bootstrap start templet의 RESUME 

- 다운로드 [링크](https://startbootstrap.com/themes/resume/)

- 원하는 만큼 수정 후 `push`

  ```bash
  $ git init
  Initialized empty Git repository in C:/Users/student/Desktop/startbootstrap-resume-gh-pages/.git/
  
  $ git add .
  $ git commit -m 'Github Pages 테스트'
  $ git push -u origin master
  ```

- https://mr-laughaway.github.io/ 페이지 확인

## 3. 기타

- 블로그 관리 도구

  [지킬](https://jekyllrb-ko.github.io/), [갯츠비](https://www.gatsbyjs.org/)


<br>

# III. Branch

## 1. fast-forward

> (master)가 그대로인 상황에서 다른 브랜치의 내용을 merge 하는 경우 ```fast-forward``` 방식으로 자동 merge 가 이루어 진다.

```bash
$ git branch {브랜치명} #브랜치 생성
$ git checkout {브랜치명} #브랜치 이동
$ git branch -d {브랜치명} #브랜치 삭제
```

```bash
$ git checkout -b {브랜치명} #브랜치 생성 및 이동
```

```bash
$ git merge {브랜치명} #브랜치명을 지금 브랜치로 병합
(master) $ git merge feature/index #feathre/index 브랜치를 master로 병합
```

**시나리오**

```bash
(master) $ git branch -b feature/test
(feature/test) $ touch test.html
(feature/test) $ git add .
(feature/test) $ git commit -m 'test commit'
(feature/test) $ git checkou master
(master) $ git merge feature/test
Updating 8c1308b..7a7cb08
Fast-forward
 test.html | 0
 1 file changed, 0 insertions(+), 0 deletions(-)
 create mode 100644 test.html
(master) $ git branch -d feature/test #브랜치 삭제
Deleted branch feature/test (was 7a7cb08).
```

## 2. merget commit recursive

> (master)에서 변경이 발생하고 다른 브랜치에서 **다른** 파일 을 수정하여 변경이 발생한 상태에서 merge를 시도할 경우 `recursive` 전략으로 머지가 발생한다.

**시나리오**

```bash
(master) $ git branch -b feature/signin #브랜치 생성과 동시에 이동(checkout)
(feature/signin) $ touch singin.html
(feature/signin) $ git add .
(feature/signin) $ git commit -m 'Complete Signin'
(feature/signin) $ git checkout master
(master) $ #index.html 수정
(master) $ git add .
(master) $ git commit -m 'index.html 수정'
# conflict가 있음을 알리는 창이 뜬다
# 저장하고 빠져나오기

(master) $ git merge feature/signin
Merge made by the 'recursive' strategy.
 siginin.html | 0
 signin.css   | 0
 2 files changed, 0 insertions(+), 0 deletions(-)
 create mode 100644 siginin.html
 create mode 100644 signin.css
 
(master) $ git log --oneline --graph
*   8c1308b (HEAD -> master) Merge branch 'feature/signin'
|\
| * 242d53e (feature/signin) Complete signin
* | 0d8b097 index.html 수정
|/
* 15e9860 Complete Index page
* 08fe688 Init index.html
```

