Github 특강 - 2

[bit.do/openb](http://bit.do/openb)

| Github 정보      |                                                              |
| ---------------- | ------------------------------------------------------------ |
| 기술 면접 가이드 | https://github.com/JaeYeopHan/Interview_Question_for_Beginner |
| 채용 관련 가이드 | https://github.com/jojoldu/junior-recruit-scheduler          |



# Git

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



## 3. 원격저장소(remote) 활용하기

### 1. 기초

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

### 2. Push - Pull

1. 원격 저장소로 보내기(push)

   ```bash
   $ git push origin master
   ```

2. 원격 저장소로부터 가져오기(pull)

   ```bash
   $ git pull origin master
   ```

   

3. 난 멀캠에서 넣어봄

4. 1

5. 1

6. 1

7. 1



