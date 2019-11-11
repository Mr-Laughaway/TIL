from django.shortcuts import render
from django.http import HttpResponse

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
        calc = "+"
    elif calc.lower() == 'minus':
        sol = a - b
        calc = "-"
    elif calc.lower() == 'multi':
        sol = a * b
        calc = "*"
    else:
        sol = a / b
        calc = "/"

    return render(req, 'calc.html', {
        'calc' : calc,
        'a' : a,
        'b' : b,
        'sol' : sol
    })