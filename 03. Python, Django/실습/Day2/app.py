from flask import Flask, render_template, request
import random
import requests
from pprint import pprint


app = Flask(__name__)


# -----------------------------------------------------------------------------
# 기본 라우트 설정
# -----------------------------------------------------------------------------
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

@app.route("/html")
def html():
    multiline = """
        <h1> This is H1 Tag </h1>
        <p> This is P Tag </p>
    """

    return multiline

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


# -----------------------------------------------------------------------------
# fake 검색엔진
# -----------------------------------------------------------------------------
@app.route("/fake_naver")
def fake_naver():
    return render_template('fake_naver.html')

@app.route("/fake_google")
def fake_google():
    return render_template('fake_google.html')



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
        "웅크린", "백색", "지혜로운", "용감한", "날카로운", "욕심 많은"
    ]

    list_2 = [
        "늑대", "태양", "양", "매", "황소", "불꽃", "나무", "달빛", "말",
        "돼지", "하늘", "바람"
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

    pre = random.sample(list_1, 1)
    mid = random.sample(list_2, 1)
    suf = random.sample(list_3, 1)

    return render_template("indian_r.html", 
        name=name, pre=pre[0], mid=mid[0], suf=suf[0])


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




# -----------------------------------------------------------------------------
# app.py 로 바로 실행 시
# -----------------------------------------------------------------------------
if __name__ == "__main__":
    app.run(debug=True, port=8000)
