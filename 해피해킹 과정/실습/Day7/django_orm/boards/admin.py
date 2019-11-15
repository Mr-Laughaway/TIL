from django.contrib import admin
from .models import Board, Subway

# Customizing
class BoardAdmin(admin.ModelAdmin):
    fields = ['content', 'title']
    list_display = ['id', 'title', 'updated_at', 'created_at']
    list_filter = ['updated_at']
    search_fields = ['title', 'content']

class SubwayAdmin(admin.ModelAdmin):
    fields = ['name', 'date', 'sandwich', 'size', 'bread']
    list_display = ['id', 'name', 'date', 'sandwich', 'size', 'bread']
    list_filter = ['id', 'name']
    search_fields = ['name', 'sandwich', 'bread']
    

# Register your models here.
admin.site.register(Board, BoardAdmin)
admin.site.register(Subway, SubwayAdmin)

