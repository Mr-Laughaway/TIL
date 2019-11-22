from django.urls import path
from . import views

urlpatterns = [
    path('', views.index),
    path('order/', views.order),
    path('order_result/', views.order_result),
    path('order_list/', views.order_list),
    path('order/<int:id>/', views.order_id),
]
