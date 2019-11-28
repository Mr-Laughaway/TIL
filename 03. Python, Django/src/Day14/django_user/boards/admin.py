from django.contrib import admin
from .models import Board, Comment


# Register your models here.
admin.site.register(Board)

class CommentAdmin(admin.ModelAdmin):
    list_display = ['comment']

admin.site.register(Comment, CommentAdmin)

