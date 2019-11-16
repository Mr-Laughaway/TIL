from django.shortcuts import render
from django.http import HttpResponse
import random
from faker import Faker
from datetime import datetime

# Create your views here.


def index(req):
    return render(req, 'index.html')


def age(req, age):
    return render(req, 'age.html', {'age' : age})



def square(req, num):
    return render(req, 'square.html', {
        'num' : num,
        'sol' : num**2
    })


def calc(req, calc, a, b):
    if calc.lower() == 'plus':
        sol = a + b
        calc = '+'
    elif calc.lower() == 'minus':
        sol = a - b
        calc = '-'
    elif calc.lower() == 'multi':
        sol = a * b
        calc = '*'
    else:
        sol = a / b
        calc = '/'

    return render(req, 'calc.html', {
        'calc' : calc,
        'a' : a,
        'b' : b,
        'sol' : sol
    })


def profile(req, name, age):
    list_1 = [
        '시끄러운, 말 많은', '푸른', '어두운 →적색', '조용한',
        '웅크린', '백색', '지혜로운', '용감한', '날카로운', 
        '욕심 많은'
    ]

    list_2 = [
        '늑대', '태양', '양', '매', '황소', '불꽃', '나무', '달빛',
            '말', '돼지', '하늘', '바람'
    ]

    list_3 = [
        '와(과) 함께 춤을', '의 기상', '은(는) 그림자 속에', '의 환생',
        '의 죽음', '아래에서', '을(를) 보라.', '이(가) 노래하다.',
        '의 그늘 → 그림자', '의 일격', '에게 쫒기는 남자', '의 행진',
        '의 왕', '의 유령', '을 죽인 자.', '은(는) 맨날 잠잔다.',
        '처럼..', '의 고향', '의 전사', '은(는) 나의 친구', '의 노래',
        '의 정령', '의 파수꾼', '의 악마', '와(과) 같은 사나이',
        '의 심판자→을(를) 쓰러뜨린 자', '의 혼', '은(는) 말이 없다'
    ]

    indian = f'{random.choice(list_1)} ' + \
        f'{random.choice(list_2)}{random.choice(list_3)}'
    lotto = str(sorted(random.sample(range(1, 47), 6)))[1:-1]

    return render(req, 'profile.html', {
        'intro' : f'{random.choice(list_1)}',
        'name' : name,
        'age' : age,
        'indian' : indian,
        'lotto' : lotto
    })


def b4life(req, name):
    fake = Faker('ko_KR')
    b4job = fake.job()
    print(b4job)

    return render(req, 'b4life.html', {
        'name' : name,
        'b4job' : b4job 
    })


def image(req):
    num = random.choice(range(1, 1000))
    url = f'https://picsum.photos/id/{num}/320/320'
    return render(req, 'image.html', {
        'url' : url
    })


def dtl(req):
    foods = ['짜장면', '탕수육', '짬뽕', '양장피', '군만두', 
        '고추잡채', '볶음밥']
    my_sentence = 'life is short, you need python.'
    messages = ['apple', 'banana', 'cucumber', 'mango']
    datetimenow = datetime.now() #현재 시각
    empty_list = []
    
    context = {
        'foods' : foods,
        'my_sentence': my_sentence,
        'messages': messages,
        'timenow': datetimenow,
        'empty_list' : empty_list
    }

    return render(req, 'dtl.html', context)


def isityourbirth(req):
    today = datetime.now()
    print(today)
    if today.month == 3 and today.date == 22:
        res = True
    else:
        res = False

    birth = datetime(2020, 3, 22)
    d_day = (birth - today).days

    return render(req, 'isityourbirth.html', {
        'res' : res,
        'd_day' : d_day
    })