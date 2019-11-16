from django.urls import path
from . import views

urlpatterns = [
    path('dokdo/', views.dokdo),
]
