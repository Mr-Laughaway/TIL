from django.urls import path
from . import views

app_name = "subway"
urlpatterns = [
    path('', views.index, name='index'),
    path('order/', views.order, name='order'),
    # path('order_do/', views.order_do, name='order_do'),
    path('<int:pk>/', views.detail, name='detail'),
    # path('edit/<int:pk>/', views.edit, name='edit'),
    path('update/<int:pk>/', views.update, name='update'),
    path('delete/<int:pk>/', views.delete, name='delete'),

]
