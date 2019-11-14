from django.shortcuts import render
from .models import Board, Subway
import datetime

# Create your views here.


def index(request):
    return render(request, "boards/index.html")


def order(request):
    return render(request, "boards/order.html")

def order_result(request):
    data = request.POST
    print(data)

    subway = Subway()
    subway.name = data['name']
    subway.date = data['date']
    subway.sandwich = data['sandwich']
    subway.bread = data['bread']
    subway.size = data['size']
    subway.source = ", ".join(data.getlist('source'))
    subway.save()

    subways = Subway.objects.all()

    print(subways)

    context = {
        'subways': subways
    }

    return render(request, "boards/order_result.html", context)

def order_list(request):
    subways = Subway.objects.all()
    context = {
        'subways': subways
    }

    return render(request, "boards/order_list.html", context)

def order_id(request, id):
    print(id)

    subway = Subway.objects.filter(id=id)
    hit = True if len(subway) > 0 else False

    if hit:
        context = { 
            'id': id,
            'result': subway[0] 
        }
    else:
        context = { 
            'id': id,
            'result': {'id': "해당 ID 정보가 없습니다."}
        }

    return render(request, "boards/order_id.html", context)
