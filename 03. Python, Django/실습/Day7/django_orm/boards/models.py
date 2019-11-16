from django.db import models

# Create your models here.
class Board(models.Model):
    title = models.CharField(max_length=10)
    content = models.TextField()
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    
    def __str__(self):
        return f"{self.id} : {self.title}"


class Subway(models.Model):
    name = models.CharField(max_length=10)
    date = models.DateTimeField()
    sandwich =  models.CharField(max_length=20)
    size = models.IntegerField()
    bread = models.CharField(max_length=20)
    source = models.TextField()

    def __str__(self):
        return f"{self.name}, {self.date}, {self.sandwich}," +\
            f"{self.size}, {self.bread}"

