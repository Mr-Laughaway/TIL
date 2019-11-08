# Happy Hacking 수업 내용

## VSCODE 설치

### Extention 설치

- HTML Snippet
- Open in Browser
- HTML CSS Support

> :point_right:꿀팁!
>
> vscode 첫 줄에서 `!` `tab` 을 하면 기본적인 사항이 적용된다.
>
> snippet의 힘

## HTML

> HTML에 대한 기본적인 사항에 대하여 리마인드 하고 넘어간다.

- Hyper Text Markup Language의 약자
- `<head>`:
- `<body>`:
- attribute
- `DOM` 트리
- 시맨틱 태그
  - header
  - nav
  - aside
  - section
  - article
  - footer

### Tags

> CSS에 대한 기본적인 사항에 대하여 리마인드 하고 넘어간다.

- `h`, `p`, `div`, `span`
- `ol`, `ul`, `li`
- `table`, `tr`, `th`, `td`
- `section`
- `iframe`
- `img`
- `form`, `input`, `select`
  - text, email, password, number
  - radio, check
  - date

## CSS

- em

  em은 배수 단위로 상대 단위이다. 요소에 지정단 사이즈(상속된 사이즈나 디폴트 사이즈)에 상대적인 사이즈를 설정한다

- rem

  rem의 기준은 상속의 영향으로 바뀔 수 있다. 즉, 상황에 따라  1.2em은 각기 다른 값을 가질 수 있따. rem은 최상위 요소의 사이즈를 기준으로 삼는다. rem의 r은 root를 의미

- viewport

  디바이스 마다 다른 크기의 화면을 가지고 있기 때문에 상대적인 단위 viewport를 기준으로 만든 단위

- 색상표현

- box model의 구성

  - border
  - margin
  - padding
  - 크기지정은 shorthand 표현 가능

- display 속성

  - block
    - 항상 새로운 라인에서 시작
    - 100% 차지
    - 컨텐츠 영역 외에는 마진으로 채워진다
    - 정렬에는 margin을 auto로 설정
    - div, table emdemd

  - inline
    - 새로운 라인에서 시작하지 않으며 문자의 중간에 들어갈 수 있다.
    - content의 너비 만큼 지정 가능
    - span, a, strong, img, br, input, select, textarea, button

  - inline-block

    inline과는 다르게 상하좌우 마진 등을 줄 수 있다.

  - none

    해당 요소를 화면에 표현하지 않는다. 공간 조차 사라진다.

    ig. visibility:hidden - 해당 요소를 화면에 표현하지 않지만 공간은 남아 있다.

- 위치

  - static

  - relative(상대위치)

    top, bottom, left, right를 사용하여 위치를 이동

  - absolute(절대위치)

    부모 요소 또는 가장 가까이 있는 조상 요소(static 제외)를 기준으로 좌표 프로퍼티만큼 이동한다.

  - fixed(고정위치)

    부모 요소와 관계없이 브라우저의 viewport를 기준으로 위치를 잡는다.  스크롤 해도 사라지지 않는다.

#### Bootstrap

 https://getbootstrap.com/ 

#### Animate.css

 https://daneden.github.io/animate.css/ 

## Python

> 파이썬 기본 사항에 대하여 간단하게 훑고 지나감.

### flask

- virtualenv 가상 환경 설정

  >  독립적인 파이썬 가상환경 관리에 용이한 패키지

  ```bash
  > pip install virtualenv
  
  > virtualenv venv
  
  # 가상환경으로 들어가기
  > source venv/Scripts/activate
  
  # 빠져나가기
  > deactivate
  ```

- flask 설치

  ```
  pip install flask
  ```

- app.py

  ```python
  from flask import Flask
  import random
  
  app = Flask(__name__)
  
  @app.route("/")
  def hello():
      name = "World!!"
      return f"Hello {name}!"
  
  @app.route("/mulcam")
  def mulcal():
      return "Hello mulcam"
  
  @app.route("/greeting/<string:name>")
  def greeting(name):
      return f"{name}님 안녕하세요."
  
  
  @app.route("/lunch/<int:num>")
  def lunch(num):
      menu = ["짜장면", "짬뽕", "라면", "스파게티", "스테이크"]
      order = random.sample(menu, num)
      return str(order)
  
  @app.route("/lotto/<int:num>")
  def lotto(num):
      base = range(1, 47)
      lotnum = random.sample(base, num)
      return str(lotnum)
  
  
  # app.py 로 바로 실행 시
  if __name__ == "__main__":
      app.run(debug=True, port=8000)
  
  ```

- 실행

  ```bash
  # 1번 실행 예: 
  > env FLASK_APP=hello.py flask run
  # 2번 실행 예: 
  > python app.py
  ```

#### render_template

flask 상에서 html 파일을 해석해서 보여줌

- templates 폴더 생성

  이곳에 hi.html 등의 html 파일을 생성한다.

  ```bash
  mkdir templates
  
  # 만약 hi.html을 미리 만들었었다면
  mv hi.html templates/
  ```

  ***hi.html***

  ```html
  <h1>Hi, {{ name }}</h1>
  ```

  ***lunch.html***

  ```html
  <h1>오늘의 개인별 메뉴는!</h1>
  <h3>{{ menu }}</h3>
  
  <ul>
  {% for m in menu %}
      <li>{{ m }}</li>
  {% endfor %}
  </ul>
  ```

- 사용 예

  ```python
  # -----------------------------------------------------------------------------
  # render_template 적용
  # -----------------------------------------------------------------------------
  @app.route("/hi/<string:name>")
  def hi(name):
      return  render_template("hi.html", name=name)
  
  @app.route("/lunch2/<int:num>")
  def lunch2(num):
      menu = ["짜장면", "짬뽕", "라면", "스파게티", "스테이크"]
      order = random.sample(menu, num)
      return render_template("lunch.html", menu=order)
  ```

#### fake 검색엔진

***fake_xxx.html***

```html
<form action="https://search.naver.com/search.naver">
    <input type="text" name="query"/>
    <input type="submit">
</form>

<form action="https://www.google.com/search">
    <input type="text" name="q"/>
    <input type="submit">
</form>
```

***app source***

```python
# -----------------------------------------------------------------------------
# fake 검색엔진
# -----------------------------------------------------------------------------
@app.route("/fake_naver")
def fake_naver():
    return render_template('fake_naver.html')

@app.route("/fake_google")
def fake_google():
    return render_template('fake_google.html')
```

#### send 와 receive

***send.html***

```html
<form action="/receive" method="GET">
    이름: <input type="text" name="name"/><br>
    메세지: <input type="text" name="message"/><br/>
    <input type="submit" value="보내기"/>
</form>
```

***receive.html***

```html
<h1>{{ name }}: {{ msg }}</h1>
```

***indian_s.html***

```html
<form action="/indian_r" method="GET">
    이름을 입력해주세요: <input type="text" name="name"/><br>
    <input type="submit" value="보내기"/>
</form>
```

***indian_r.html***

```html
<h1>{{ name }}님의 인디언식 이름:</h1>
<h2> {{ pre }} {{ mid}}{{suf}} </h2> 
```

***app source***

```python
# -----------------------------------------------------------------------------
#  send와 receive
# -----------------------------------------------------------------------------
@app.route("/send")
def send():
    return render_template("send.html")

@app.route("/receive")
def receive():
    name = request.args.get('name')
    message = request.args.get('message')
    return render_template("receive.html", name=name, msg=message)


@app.route("/indian_s")
def indian_s():
    return render_template("indian_s.html")
    

@app.route("/indian_r")
def indian_r():
    name = request.args.get('name')

    list_1 = [
        "시끄러운, 말 많은", "푸른", "어두운 →적색", "조용한",
        "웅크린", "백색", "지혜로운", "용감한", "날카로운", "욕심 많은"]

    list_2 = [
        "늑대", "태양", "양", "매", "황소", "불꽃", "나무", "달빛", "말",
        "돼지", "하늘", "바람"]

    list_3 = [
        "와(과) 함께 춤을", "의 기상", "은(는) 그림자 속에", "의 환생",
        "의 죽음", "아래에서", "을(를) 보라.", "이(가) 노래하다.",
        "의 그늘 → 그림자", "의 일격", "에게 쫒기는 남자", "의 행진",
        "의 왕", "의 유령", "을 죽인 자.", "은(는) 맨날 잠잔다.",
        "처럼..", "의 고향", "의 전사", "은(는) 나의 친구", "의 노래",
        "의 정령", "의 파수꾼", "의 악마", "와(과) 같은 사나이",
        "의 심판자→을(를) 쓰러뜨린 자", "의 혼", "은(는) 말이 없다"
    ]

    pre = random.sample(list_1, 1)
    mid = random.sample(list_2, 1)
    suf = random.sample(list_3, 1)

    return render_template("indian_r.html", 
        name=name, pre=pre[0], mid=mid[0], suf=suf[0])
```

- 실행결과

![image-20191107153707227](.assets/image-20191107153707227.png)

#### requests 로또 번호 가져와서 맞춰보기

- lotto_get.html

  ```html
  <form action="/lotto_num" method="GET">
      원하시는 회차: <input type="text" name="num"/>
      <input type="submit" value="확인"/>
  </form>
  ```

- lotto_result.html

  ```html
  <div>
      회차: {{ num }}<br/>
      당첨번호: {{ winNum}}<br/>
      응모번호: {{ myNum}}<br/>
      결과: {{ msg }}<br/>
  </div>
  ```

- app source

  ```python
  # -----------------------------------------------------------------------------
  #  lotto 맞춰보기
  # -----------------------------------------------------------------------------
  # https://dhlottery.co.kr/common.do?method=getLottoNumber&drwNo=882
  
  @app.route("/lotto_get")
  def lotto_get():
      return render_template("lotto_get.html")
  
  @app.route('/lotto_num')
  def lotto_num():
      num = request.args.get('num')
      url= f"https://dhlottery.co.kr/common.do?method=getLottoNumber&drwNo={num}"
      res = requests.get(url).json()
      # pprint(res)
  
      base = range(1, 47)
      myNum = sorted(random.sample(base, 6))
  
      # list comprehention
      # [ 받는변수 for 받는변수 in 범위로된데이터 ]
      winNum = [ res[f"drwtNo{i}"] for i in range(1, 7) ]
  
      match = list(set(myNum) & set(winNum))
      hit = len(match)
      
      print(match)
  
      if hit == 6:
          rank = "1등입니다."
      elif hit == 5:
          rank = "2등입니다. "
      elif hit == 4:
          rank = "3등"
      elif hit == 3:
          rank = "4등"
      else:
          rank = "꽝 다음 기회에..."
  
      return render_template("lotto_result.html",
          num=num, winNum=winNum, myNum=myNum, msg=rank)
  
  ```

## Chat bot 만들기

### 준비작업

- Telegram 가입

- @BotFather 친추

- `/newbot` 으로 bot 생성 및 필수 사항 입력

- TOKEN 받기

- 기능 확인

  ```
  # 상태 확인
  https://api.telegram.org/botxxxxooxoxoxooxooOXOOXOXOxoxoxoxoxoxo/getMe
  
  # 업데이트 된 내용 확인 (chat_id 도 확인 가능)
  https://api.telegram.org/botxxxxooxoxoxooxooOXOOXOXOxoxoxoxoxoxo/getUpdates
  
  # 위에서 확인한 chat_id로 message 보내보기
  https://api.telegram.org/botxxxxooxoxoxooxooOXOOXOXOxoxoxoxoxoxosendMessage?chat_id=936561044&text=%EC%9C%BC%ED%95%98%ED%95%98%ED%95%98%ED%95%98%ED%95%98
  ```

### 코드 작성

- `.env` 에 TOKEN 설정
- `pip install python-decouple`

**app.py**

```python
from flask import Flask, request, render_template
from decouple import config
from pprint import pprint
import requests
import random

app = Flask(__name__)

token = config('TOKEN')
base_url = f"https://api.telegram.org/bot{token}"


# -----------------------------------------------------------------------------
# 로또 번호 보내보기
# -----------------------------------------------------------------------------
@app.route('/telegram')
def telegram(): 
    # telegram 서버에 data 요청
    # .json() 이 없으면 응답코드만 받음
    res = requests.get(f"{base_url}/getUpdates").json()
    pprint(res)

    # chat id 추출 (sendMessage 할 때 필요하기 때문)
    chat_id = res['result'][0]['message']['chat']['id']
    print(chat_id)

    lotNum = str(random.sample(range(1, 47), 6))
    res = requests.get(
        f"{base_url}/sendMessage?chat_id={chat_id}&text={lotNum}")

    return f"Message have sent: {lotNum}"


# -----------------------------------------------------------------------------
# View 를 이용하여 메시지 보내보기
# -----------------------------------------------------------------------------
@app.route('/chat')
def chat():
    return render_template("chat.html")
   

@app.route('/send_msg')
def send_message():
    req = request.args.get('chat')

    res = requests.get(f"{base_url}/getUpdates").json()
    chat_id = res['result'][0]['message']['chat']['id']

    send_url = f"/sendMessage?chat_id={chat_id}&text={req}"
    response = requests.get(base_url + send_url)

    return "보내기 완료"
# -----------------------------------------------------------------------------
# main process 로 실행 시
# -----------------------------------------------------------------------------
if __name__ == "__main__":
    app.run(debug=True)

```

### webHook 설정

> webHook을 설정하면 getUpdates 메서드는 더이상 작동하지 않게 된다. webHook으로 설정한 route로 테스트 필요.

**set_webhook.py**

```python
from decouple import config
import requests
from pprint import pprint

token = config('TOKEN')
base_url = f"https://api.telegram.org/bot{token}"
url = "https://1287d0fb.ngrok.io"
setweb_url = f"/setWebhook?url={url}"

req = requests.get(base_url + setweb_url).json()

pprint(req)
```

**ngrok 실행**

```bash
./ngrok.exe http 5000
```

**app.py** 내용 추가

```python
# -----------------------------------------------------------------------------
# 실시간 반응 Web hoc - ngrok.exe 이용
# -----------------------------------------------------------------------------
@app.route('/', methods=['POST'])
def tel_web():
    req = request.get_json().get('message')
    # pprint(req)

    # 방법 1
    print(req['chat']['id'], req['text'])

    # 방법 2
    if req is not None:
        chat_id = req.get('chat').get('id')
        text = req.get('text')
    print(chat_id, text)

    if re.search(r'로또', text):
        msg = str(random.sample(range(1, 47), 6))
    else:
        msg = text

    send_url = f"/sendMessage?chat_id={chat_id}&text={msg}"
    response = requests.get(base_url + send_url)
    
    return '', 200

```

### 인디언 이름 보내보기

**app.py 내용 추가**

```python
elif "/인디안" in text:
            name = text[text.index(" "):]
             
            list_1 = [
                "시끄러운, 말 많은", "푸른", "어두운 →적색", "조용한",
                "웅크린", "백색", "지혜로운", "용감한", "날카로운", 
                "욕심 많은"
            ]

            list_2 = [
                "늑대", "태양", "양", "매", "황소", "불꽃", "나무", "달빛",
                 "말", "돼지", "하늘", "바람"
            ]

            list_3 = [
                "와(과) 함께 춤을", "의 기상", "은(는) 그림자 속에", "의 환생",
                "의 죽음", "아래에서", "을(를) 보라.", "이(가) 노래하다.",
                "의 그늘 → 그림자", "의 일격", "에게 쫒기는 남자", "의 행진",
                "의 왕", "의 유령", "을 죽인 자.", "은(는) 맨날 잠잔다.",
                "처럼..", "의 고향", "의 전사", "은(는) 나의 친구", "의 노래",
                "의 정령", "의 파수꾼", "의 악마", "와(과) 같은 사나이",
                "의 심판자→을(를) 쓰러뜨린 자", "의 혼", "은(는) 말이 없다"
            ]

            pre = random.choice(list_1)
            mid = random.choice(list_2)
            suf = random.choice(list_3)

            msg = f"{name} : {pre} {mid}{suf}"
```

### Papago 번역 붙여보기

#### 사전준비

- NAVER 개발자 센터 App에  NMT 번역 API 설정
- `localhost` 등록
- .env에 키 설정 및 app.py에 headers 등록

#### 단독으로 붙여보기

```python
# -----------------------------------------------------------------------------
# 파파고 NMT 번역
# -----------------------------------------------------------------------------
@app.route('/papago')
def papago():
    C_ID = config('C_ID')
    C_SC = config('C_SC')
    url = "	https://openapi.naver.com/v1/papago/n2mt"

    headers = {
        'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8',
        'X-Naver-Client-Id': C_ID,
        'X-Naver-Client-Secret': C_SC
    }

    data = {
        'source': 'ko',
        'target': 'en',
        'text': "안녕하세요"
    }

    req = requests.post(url, headers=headers, data=data).json()
    pprint(req['message']['result']['translatedText'])

    return "Finish"
```

#### 텔레그램과 붙여보기 내용 추가

```python
elif "/번역" in text:
            req_text = text[text.index(" "):]
            data = {
                'source': 'ko',
                'target': 'en',
                'text': req_text
            }

            res = requests.post(url, headers=headers, data=data).json()
            msg = "번역 결과: " + res['message']['result']['translatedText']
```

### Python Anywhere 설정

#### 사전 준비

WEB > Add New Webapp > Files > my site > flask_app.py > 코드 복사 붙여넣기 > .env 업로드 > open bash > `pip3 install --user python-decouple`

#### 텔레그램 봇 webHook 재설정

> 텔레그램의 webHook 주소를 Python Anywhere로 설정하면 이제부터 계속 사용 가능하다.

**set_webhook.py**

```python
from decouple import config
import requests
from pprint import pprint

token = config('TOKEN')
base_url = f"https://api.telegram.org/bot{token}"
# url = "85bacf34.ngrok.io"
url = "CodeOrChord.pythonanywhere.com"
setweb_url = f"/setWebhook?url={url}"

req = requests.get(base_url + setweb_url).json()

pprint(req)
```

