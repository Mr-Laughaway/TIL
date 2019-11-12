from django.urls import path
from . import views

urlpatterns = [
    path('throw/', views.throw),
    path('catch/', views.catch),
    path('lotto/', views.lotto),
    path('lotto_result/', views.lotto_result),
    path('artii/', views.artii),
    path('artii_result/', views.artii_result),
    path('user_new/', views.user_new),
    path('user_create/', views.user_create),
    path('subway_form/', views.subway_form),
    path('subway_result/', views.subway_result),
    path('static_example/', views.static_example),
    path('index/', views.index)
]