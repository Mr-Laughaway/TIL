from django.shortcuts import render
import random
import requests
import urllib

# Create your views here.


# -----------------------------------------------------------------------------
# GET Method 데이터 주고 받기 1
# -----------------------------------------------------------------------------
def throw(request):
    return render(request, 'throw.html')

def catch(request):
    # print(request)
    # print(request.path)
    # print(request.method)
    # print(request.META)
    print(request.GET)

    message = request.GET.get('message')
    message2 = request.GET.get('message2')
    context = {
        'msg': message,
        'msg2': message2
    }

    return render(request, 'catch.html', context)


# -----------------------------------------------------------------------------
# GET Method 데이터 주고 받기 2
# -----------------------------------------------------------------------------
def lotto(request):
    return render(request, 'lotto.html')

def lotto_result(request):
    count = int(request.GET.get('count'))
   
    lotto_num = [ sorted(random.sample(range(1, 47), 6))
        for i in range(count) ]

    context = {
        'count': count,
        'lotto_num': lotto_num
    }

    return render(request, 'lotto_result.html', context)


# -----------------------------------------------------------------------------
# Artii API 이용해보기 
# -----------------------------------------------------------------------------
def artii(request):
    return render(request, 'artii.html')

def artii_result(request):
    sent = request.GET.get('sent')
    sent = urllib.parse.quote(sent)

    font_url = "http://artii.herokuapp.com/fonts_list"
    font_list = requests.get(font_url).text.split("\n")
    font = random.choice(font_list)

    url = "http://artii.herokuapp.com/make?text=" + sent \
        + "&font=" + font
    res_text = requests.get(url).text

    return render(request, 'artii_result.html', {
        'result': res_text 
    })

# -----------------------------------------------------------------------------
# POST Method 데이터 주고 받기 1
# -----------------------------------------------------------------------------
def user_new(request):
    return render(request, 'user_new.html')

def user_create(request):
    username = request.POST.get('name')
    pw = request.POST.get('pw')
    
    context = {
        'username': username,
        'pw': pw
    }

    return render(request, 'user_create.html', context)


# -----------------------------------------------------------------------------
# POST Method 데이터 주고 받기 2 (SUBWAY)
# -----------------------------------------------------------------------------
def subway_form(request):
    return render(request, 'subway_form.html')

def subway_result(request):
    data = request.POST
    print(data)
    print(data.getlist('etc'))

    context = {
        'name': data['name'],
        'date': data['date'],
        'sandwich': data['sandwich'],
        'bread': data['bread'],
        'size': data['size'],
        'etc': str(data.getlist('etc')),
    }

    return render(request, 'subway_result.html', context)