from django.shortcuts import render, redirect
from .models import Subway

# Create your views here.
def index(requests):
    context = {
        'subways': Subway.objects.order_by('-id')
    }

    return render(requests, 'subway/index.html', context )


def order(request):
    if request.method == 'GET':
        return render(request, 'subway/order.html')
    else:
        data = request.POST
        print(data)

        subway = Subway()
        subway.name = data['name']
        subway.address = data['address']
        subway.phone = data['phone']
        subway.menu = data['menu']
        subway.bread = data['bread']
        subway.vegetable = ", ".join(data.getlist('vegetable'))
        subway.sauce = data['sauce']
        subway.drink = data['drink']
        subway.save()

        return redirect('subway:index')

"""
def order_do(requests):
    data = requests.POST
    print(data)

    subway = Subway()
    subway.name = data['name']
    subway.address = data['address']
    subway.phone = data['phone']
    subway.menu = data['menu']
    subway.bread = data['bread']
    subway.vegetable = ", ".join(data.getlist('vegetable'))
    subway.sauce = data['sauce']
    subway.drink = data['drink']
    subway.save()

    return redirect('subway:index')
"""

def detail(request, pk):
    context = {
        'subway': Subway.objects.get(pk=pk)
    }
    return render(request, 'subway/detail.html', context)

"""
def edit(request, pk):
    context = {
        'subway': Subway.objects.get(pk=pk)
    }
    return render(request, 'subway/edit.html', context)
"""

def update(request, pk):
    subway = Subway.objects.get(pk=pk)
    if request.method == 'GET':
        context = {
            'subway': subway
        }
        return render(request, 'subway/update.html', context)
    else:
        data = request.POST
        print(data)

        subway = Subway.objects.get(pk=pk)
        subway.name = data['name']
        subway.address = data['address']
        subway.phone = data['phone']
        subway.menu = data['menu']
        subway.bread = data['bread']
        subway.vegetable = ", ".join(data.getlist('vegetable'))
        subway.sauce = data['sauce']
        subway.drink = data['drink']
        subway.save()

        # return redirect(f"/detail/{pk}/")
        return redirect('subway:detail', pk)


def delete(request, pk):
    subway = Subway.objects.get(pk=pk)
    if request.method == 'POST':
        subway.delete()
        return redirect('subway:index')
    else:
        return redirect('subway:detail', subway.id)