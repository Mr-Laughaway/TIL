from django.urls import path, include
from . import views

app_name = "survey"
urlpatterns = [
    path('', views.index, name="index"),
    path('new/', views.new, name="new"),
    path('<int:q_id>/', views.detail, name="detail"),
    path('<int:q_id>/update/', views.update, name="update"),
    path('<int:q_id>/delete/', views.delete, name="delete"),
    path('<int:q_id>/new_c/', views.new_c, name="new_c"),
    path('<int:q_id>/update_c/<int:c_id>/', views.update_c, name="update_c"),
    path('<int:q_id>/delete_c/<int:c_id>/', views.delete_c, name="delete_c"),
    path('<int:q_id>/votes_c/<int:c_id>/', views.votes_c, name="votes_c"),

]