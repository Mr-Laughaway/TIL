from django.db import models

# Create your models here.
class Subway(models.Model):
    name = models.CharField(max_length=10)
    address = models.CharField(max_length=30)
    phone = models.CharField(max_length=15)
    menu = models.CharField(max_length=20)
    bread = models.CharField(max_length=20)
    vegetable = models.CharField(max_length=20)
    sauce = models.CharField(max_length=40)
    drink = models.CharField(max_length=15)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

    def __str__(self):
        return f"{self.id} {self.name} {self.menu}"
