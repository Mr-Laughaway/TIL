<h1>Github 특강 - 2</h1>
<br>

# 목차

- [Git](#1-git)
  - [기본 사용법](#11-기본-사용법)
    - [git 설정](#111-git-설정)
    - [git 활용 기초](#112-git-활용-기초)
    - [원격저장소(remote) 활용하기](#113-원격저장소remote-활용하기)
      - [저장소 등록](#1-저장소-등록)
      - [push-pull](#2-push-pull)
      - [push-pull 시나리오](#3-push-pull-시나리오)
    - [되돌리기](#114-되돌리기)
  - [Github Pages](#12-github-pages)
    - [Github에 page repository 생성](#121-github에-page-repository-생성)
    - [Bootstrap start templet의 RESUME](#122-bootstrap-start-templet의-resume)
    - [기타](#123-기타)
  - [Branch](#13-branch)
    - [Branch 기본](#131-branch-기본)
    - [fast-forward](#132-fast-forward-strategy)
    - [merge commit recursive](#133-recursive-strategy)
    - [충돌 및 직접해결](#134-충돌-및-직접해결)
    - [stash - 임시 공간](#135-stash---임시-공간)
  - [Reset vs. Revert](#14-reset-vs-revert)
    - [Reset](#141-reset)
    - [Revert](#142-revert)
    - [reflog](#143-reflog)
  - [Github Flow](#15-github-flow)
  - [용용한 github 관련 페이지](#16-유용한-github-관련-페이지)
- [Python 입문](#2-Python-입문)
  - [Papago NMT 사용해보기](#21-papago-nmt-사용해보기)
  - [텔레그램 봇 만들기](#22-텔레그램-봇-만들기)
  - [HEROKU에 배포](#23-heroku에-배포)

<br>

<br>

# 1. Git

![github log](.assets/what-is-github-1-1.png)

> Git 은 분산버전관리시스템(DVCS)이다.
>
> 소스코드의 이력을 관리한다.

- 참고 문서
  - [Git scm](https://git-scm.com/book/ko/v2)
  - [Git 입문](https://backlog.com/git-tutorial/kr/)

<br>

## 1.1 기본 사용법

### 1.1.1. git 설정

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

### 1.1.2. git 활용 기초

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

3. commit

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

###  1.1.3. 원격저장소(remote) 활용하기

#### (1) 저장소 등록

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

#### (2) Push-Pull

1. 원격 저장소로 보내기(push)

   ```bash
   $ git push origin master
   ```

2. 원격 저장소로부터 가져오기(pull)

   ```bash
   $ git pull origin master
   ```

#### (3) Push-Pull 시나리오

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

### 1.1.4. 되돌리기

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

<br>

## 1.2. Github Pages

### 1.2.1. Github에 page repository 생성

> github에서 new repository를 통하여 `{github id}.github.io` 라는 이름의 레포지토리를 생성한다.

<br>

### 1.2.2. Bootstrap start templet의 RESUME 

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

### 1.2.3. 기타

- 블로그 관리 도구

  [지킬](https://jekyllrb-ko.github.io/), [갯츠비](https://www.gatsbyjs.org/)


<br>

<br>

## 1.3. Branch

### 1.3.1. Branch 기본

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

<br>

### 1.3.2. fast-forward strategy

> (master)가 그대로인 상황에서 다른 브랜치의 내용을 merge 하는 경우 ```fast-forward``` 방식으로 자동 merge 가 이루어 진다.

**시나리오**

```bash
(master) $ git checkout -b feature/test
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

<br>

### 1.3.3. recursive strategy

> (master)에서 변경이 발생하고 다른 브랜치에서 **다른** 파일 을 수정하여 변경이 발생한 상태에서 merge를 시도할 경우 `recursive` 전략으로 머지가 발생한다.

**시나리오**

```bash
(master) $ git checkout -b feature/signin #브랜치 생성과 동시에 이동(checkout)
(feature/signin) $ touch singin.html
(feature/signin) $ git add .
(feature/signin) $ git commit -m 'Complete Signin'
(feature/signin) $ git checkout master
```

```bash
(master) $ #index.html 수정
(master) $ git add .
(master) $ git commit -m 'index.html 수정'
# conflict가 있음을 알리는 창이 뜬다
#--------------------------------------
Merge branch 'feature/signout'

# Please enter a commit message to explain why this merge is necessary,
# especially if it merges an updated upstream into a topic branch.
#
# Lines starting with '#' will be ignored, and an empty message aborts
# the commit.
#--------------------------------------
# 저장하고 빠져나오기
```

```bash
(master) $ git merge feature/signin
Merge made by the 'recursive' strategy.
 siginin.html | 0
 signin.css   | 0
 2 files changed, 0 insertions(+), 0 deletions(-)
 create mode 100644 siginin.html
 create mode 100644 signin.css
 
(master) $ git log --oneline --graph #오 이거 재밌네
*   8c1308b (HEAD -> master) Merge branch 'feature/signin'
|\
| * 242d53e (feature/signin) Complete signin
* | 0d8b097 index.html 수정
|/
* 15e9860 Complete Index page
* 08fe688 Init index.html
```

<br>

### 1.3.4. 충돌 및 직접해결

> (master)와 (다른 브랜치)에서 같은 파일을 수정하고 commit 한 뒤 ```merge```를 수행한 경우 충돌이 발생한다.

```bash
#사전 작업
(master) $ git touch .gitignore
(master) $ git add .
(master) $ git commit -m 'add .gitignore'
```

```bash
#브랜치 생성 후 파일 수정
(master) $ git checkout -b feature/conflict
(feature/conflict) $ vi .gitignore #vi 로 수정
(feature/conflict) $ git add .
(feature/conflict) $ git commit -m 'sub branch에서 수정'
(feature/conflict) $ git checkout master #master branch로 이동
```

```bash
(master) $ vi .gitignore #vi 로 같은 파일 수정
(master) $ git add .
(master) $ git commit -m 'master branch에서 수정'

#merge 시도 -> 충돌 발생
(master) $ git merge feature/conflict
Auto-merging .gitignore
CONFLICT (content): Merge conflict in .gitignore
Automatic merge failed; fix conflicts and then commit the result.

##충돌 확인
(master|MERGING) $ vi .gitignore
#-------------------------------------
<<<<<<< HEAD
*.txt
=======
*.xlsx
>>>>>>> feature/conflict
#-------------------------------------

# 다음과 같이 수정후 :wq
#-------------------------------------
*.txt
*.xlsx
#-------------------------------------

(master|MERGING) $ git add .
(master|MERGING) $ git commit
# vim 창이 뜨고 메시지 수정 가능 -> :wq
[master 91e2938] Merge branch 'feature/conflict'
(master) $ git log --oneline --graph
*   91e2938 (HEAD -> master) Merge branch 'feature/conflict'
|\
| * b335d81 (feature/conflict) sub branch에서 수정
* | 1a56236 master branch에서 수정
|/
* 0784fa4 clean
```

<br>

### 1.3.5. stash - 임시 공간

> 작업 중에 작업이 완료되지 않아서 커밋을 하기 애매한 상황일 경우 임시적으로 현재의 변경사항을 저장할 수 있는 공간이 있다.

1. 현재 작업 파일 stash로 이동

   working directory 작업 이력을 `stash`로 이동시킨다

   ```bash
   $ git stash
   ```

2. working directory에 반영

   다시 작업 이력을 불러온다.

   ```bash
   $ git stash pop #apply + drop
   
   ```

   위 명령어는 아래의 두 개의 명령어를 실행시키는 것과 동일하다.

   ```bash
   $ git stash apply #불러오기
   $ git stash drop #삭제하기
   ```

<br>

<br>

## 1.4. Reset vs Revert

### 1.4.1. Reset

> 특정 시점의 이력으로 되돌릴 수 있다.

1.  특정 시점  + 변경사항을 staging area

   ```bash
   $ git reset {커밋해시코드}
   ```

2. 특정 시점 (기존의 변경사항을 남겨주지 않음!)

   ```bash
   $ git reset --hard {커밋해시코드}
   ```

<br>

### 1.4.2. Revert

> 특정 시점의 이력으로 돌아갔다는 커밋과 함께 되돌릴 수 있다.

```bash
$ git revert {커밋해시코드}
```

<br>

### 1.4.3. reflog

> `git rebase` 또는 `git reset` 등으로 커밋이 삭제될 수 있다. 하지만, git 이력은 보관되고 있는데 이러한 이력을 볼 수 있는 명령어가 `git reflog` 이다. `reflog` 이력을 통해 확인한 hashcode 들로 여러 복구 작업을 할 수 있다.

<br>

<br>

## 1.5. Github Flow

![github-flow](.assets/github-flow.png)

>`release` 브런치가 명확하지 않은 시스템에서 사용에 맞게 되어있다.
>
>여기에는 GitHub의 서비스 특성상. 릴리즈라는 개념이 없는 서비스를 진행하고 있어서 그런 것으로 보이며, 웹 서비스들이 릴리즈라는 개념이 없이지고 있으니 사용하기 편할 것으로 보인다.
>
>`hotfix`와 가장 작은 기능을 구분하지 않는다. 어차피 둘 다 개발자가 수정해야 되는 일중에 하나이다. 단지 우선순위가 어디가 높냐라는 단계이다.

<br>

<br>

## 1.6. 유용한 github 관련 페이지 

| Github 정보      |                                                              |
| ---------------- | ------------------------------------------------------------ |
| 기술 면접 가이드 | https://github.com/JaeYeopHan/Interview_Question_for_Beginner |
| 채용 관련 가이드 | https://github.com/jojoldu/junior-recruit-scheduler          |
| 치트시트!        | http://ndpsoftware.com/git-cheatsheet.html                   |
| .gitignore 헬퍼  | http://gitignore.io/                                         |

<br>

<br>

<br>

# 2. Python 입문

## 2.1. Papago NMT 사용해보기

1. 파이썬 설치

2. 사용할 라이브러리 설치

   ```bash
   > pip install requests
   > pip install python-decouple # 환경변수 설정 라이브러리
   ```

3. Naver 개발자 센터에서 API 사용 준비 작업

4. 코딩

   *.env*

   ```properties
   NAVER_CLIENT_ID="***************************"
   NAVER_CLIENT_SECRET="***********"
   ```

   *.gitignore*

   ```
   .env
   ```

   *papago.py*

   ```python
   import requests
   import pprint
   from decouple import config
   
   #1. 환경변수 설정
   naver_client_id = config('NAVER_CLIENT_ID')
   naver_client_secret = config('NAVER_CLIENT_SECRET')
   
   #2. URL 설정
   url = "https://openapi.naver.com/v1/papago/n2mt"
   
   #3. 헤더 및 환경변수 설정
   headers = {
       'X-Naver-Client-Id' : naver_client_id,
       'X-Naver-Client-Secret' : naver_client_secret,
   }
   
   data = {
       'source' : 'ko',
       'target' : 'en',
       'text' : '댕댕이'
   }
   
   #4. 요청
   #url에 헤더와 데이터를 포함해서 POST 요청을 보내고
   #그 결과(json)을 파싱
   response = requests.post(url, headers=headers, data=data).json()
   pprint.pprint(response)
   print(response['message']['result']['translatedText'])
   ```

5. 결과 확인

   ```
   $ python papago.py
   {'message': {'@service': 'naverservice.nmt.proxy',
                '@type': 'response',
                '@version': '1.0.0',
                'result': {'srcLangType': 'ko',
                           'tarLangType': 'en',
                           'translatedText': 'cIog'}}}
   cIog
   
   ```

<br>

## 2.2. 텔레그램 봇 만들기

1. @botfather 에게 말해서 챗봇 만들기.

   ```
   Done! Congratulations on your new bot. You will find it at t.me/fromlyra0xff_bot. You can now add a description, about section and profile picture for your bot, see /help for a list of commands. By the way, when you've finished creating your cool bot, ping our Bot Support if you want a better username for it. Just make sure the bot is fully operational before you do this.
   
   Use this token to access the HTTP API:
   **************************************
   Keep your token secure and store it safely, it can be used by anyone to control your bot.
   
   For a description of the Bot API, see this page: https://core.telegram.org/bots/api
   ```

2. Web browser에서 아래 API 들이 작동하는지 확인

   - ```https://api.telegram.org/bot******************/getMe```

   - ```https://api.telegram.org/bot******************/getUpdates```
   
     ***id : 936561044*** 확인해 놓는다.
   
3. 메시지 보내 보기 (*chat_id는 update에서 확인한 것을 사용*)

   ```
   https://api.telegram.org/bot********************************************/sendMessage?chat_id=936561044&text=안녕
   ```

<br>

## 2.3. HEROKU에 배포

1. [heroku](https://www.heroku.com/) 가입

2. [heroku cli](https://devcenter.heroku.com/articles/heroku-cli) 다운로드 -> 설치

3. 프로젝트 폴더 및 설정 파일들 작성

   *Procfile*

   ```bash
   #아무것도 안 씀...
   ```

   *runtime.txt* (*내 환경이 아니라 heroku에 지시하는 설정*)

   ```
   python-3.7.2
   ```

4. 기타 설정 저장(*optional*)

   ```bash
   # 현재 라이브러리를  저장
   pip freeze > requirements.txt
   # 다음에 일관 인스톨 하려면?
   pip install -l requirements.txt
   ```

   *requirements.txt*

   ```properties
   astroid==2.2.5
   certifi==2019.6.16
   chardet==3.0.4
   colorama==0.4.1
   idna==2.8
   isort==4.3.21
   lazy-object-proxy==1.4.2
   mccabe==0.6.1
   pylint==2.3.1
   python-decouple==3.1
   requests==2.22.0
   six==1.12.0
   typed-ast==1.4.0
   urllib3==1.25.3
   wrapt==1.11.2
   
   ```

5. 소스코드 작성(*로또 번호 생성기*)

   *.env*

   ```properties
   TELEGRAM_TOKEN=********************************
   ```

   *lotto-bot.py*

   ```python
   import requests
   from decouple import config
   
   # 0
   import random
   numbers = range(1, 46) # 1 이상 46 미만
   text = sorted(random.sample(numbers, 6))
   
   # 1. 토큰 값 설정
   token = config('TELEGRAM_TOKEN')
   
   # 2. url 설정
   # chat_id, text 요청 변수 설정!
   # string interpolation - 문자열 내에 변수 값 삽입(f-string)
   base_url = f'https://api.telegram.org/bot{token}'
   chat_id = '936561044'
   #text = '안녕'
   url = f'{base_url}/sendMessage?chat_id={chat_id}&text={text}'
   
   # 3. 메시지보내기
   requests.get(url)
   ```

6. Heroku에 `push`

   작업 디렉토리에서 정식 *git bash* 를 연다(*vscode*에서 안 되는 듯?)

   ```bash
   $ heroku login
   heroku: Press any key to open up the browser to login or q to exit:
   Opening browser to https://cli-auth.heroku.com/auth/browser/15c343c8-81e0-4547-aef3-028de9c53a5d
   heroku: Waiting for login...
   Logging in... done
   Logged in as mr.laughaway@gmail.com
   ^C▒ϰ▒ ▒۾▒▒▒ ▒▒▒▒▒ðڽ▒▒ϱ▒ (Y/N)? y
   
   $ heroku create fromlyra0xff-bot #fromlyra0xff-bot은 프로젝트명이다 
   Creating fromlyra0xff-bot... done
   https://fromlyra0xff-bot.herokuapp.com/ | https://git.heroku.com/fromlyra0xff-bot.git
   
   $ git push heroku master
   remote: Verifying deploy... done.
   To https://git.heroku.com/fromlyra0xff-bot.git
    * [new branch]      master -> master
   
   ```

7. [heroku site](https://dashboard.heroku.com/apps/fromlyra0xff-bot)에서 환경설정

   {project} > settings > Config Vars > Reveal ...

   ```
   KEY : TELEGRAM_TOKEN
   VALUE: 어쩌구어쩌구어쩌구어쩌구어쩌구키
   ```

   overview > Configure Add-ons > **Heroku Scheduler** 설치

   ```
   Heroku Scheduler > Add Job > 스케쥴 설정
   ```

8.  기다렸다가 텔레그램 확인

















