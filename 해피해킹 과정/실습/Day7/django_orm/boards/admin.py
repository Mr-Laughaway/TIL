from django.contrib import admin
from .models import Board, Subway

# Customizing
class BoardAdmin(admin.ModelAdmin):
    fields = ['content', 'title']
    list_display = ['id', 'title', 'updated_at', 'created_at']
    list_filter = ['updated_at']
    search_fields = ['title', 'content']
    

# Register your models here.
admin.site.register(Board, BoardAdmin)
admin.site.register(Subway)

