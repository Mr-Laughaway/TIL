from django.urls import path, include
from . import views

app_name = 'movie'
urlpatterns = [
    path('', views.index, name='index'),
    path('new/', views.new, name='new'),
    path('<int:movie_id>/', views.detail, name='detail'),
    path('<int:movie_id>/edit/', views.edit, name='edit'),
    path('<int:movie_id>/delete/', views.delete, name='delete'),
    path('csv2db/', views.csv2db, name='csv2db'),
]