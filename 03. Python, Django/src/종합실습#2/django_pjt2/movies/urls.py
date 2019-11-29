from django.urls import path
from django.conf import settings
from . import views

app_name = "movies"
urlpatterns = [
    path('', views.index, name="index"),
    path('new/', views.new, name="new"),
    path('<int:m_id>/', views.detail, name="detail"),
    path('edit/<int:m_id>/', views.edit, name="edit"),
    path('delete/<int:m_id>/', views.delete, name="delete"),
    path('<int:m_id>/ratings/new', views.new_rating, name="new_rating"),
    path('<int:m_id>/ratings/<int:r_id>/delete/', views.delete_rating, name="delete_rating"),
]
