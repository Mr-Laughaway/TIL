from django.shortcuts import render

# Create your views here.

def dokdo(request):
    return render(request, 'fontapp/dokdo.html')