from django.db import models

# Create your models here.
class Movie(models.Model):
    title = models.CharField(max_length=30)
    title_en = models.CharField(max_length=30)
    audience = models.IntegerField(default=0)
    open_date = models.DateTimeField()
    genre = models.CharField(max_length=15)
    watch_grade = models.CharField(max_length=15)
    score = models.FloatField(default=0.0)
    poster_url = models.TextField()
    description = models.TextField()

    def __str__(self):
        return f"{self.id} | {self.title} | {self.title_en}"