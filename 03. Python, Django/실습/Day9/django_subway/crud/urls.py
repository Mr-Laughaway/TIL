from django.urls import path
from . import views

app_name = "crud"
urlpatterns = [
    path('', views.index, name="index"),
    path('new/', views.new, name="new"),
    # path('create/', views.create, name="create"),
    path('<int:pk>/', views.detail, name="detail"),
    path('<int:pk>/update/', views.update, name="update"),
    # path('<int:pk>/revise/', views.revise, name="revise"),
    path('<int:pk>/delete/', views.delete, name="delete"),
]

