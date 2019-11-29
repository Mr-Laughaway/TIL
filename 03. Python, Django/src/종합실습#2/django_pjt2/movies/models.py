from django.db import models
from django.conf import settings

def board_img_path(instance, filename):
    return f"movies/img/{filename}"

# Create your models here.
class Movie(models.Model):
    title  = models.CharField(max_length=50)
    description = models.TextField()
    poster = models.ImageField(
        blank=True,
        upload_to=board_img_path
    )
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    user = models.ForeignKey(
        settings.AUTH_USER_MODEL, on_delete=models.CASCADE)
    
    def __str__(self):
        return self.title
    
    

class Rating(models.Model):
    score = models.FloatField(default=0.0)
    content = models.CharField(max_length=50)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    movie = models.ForeignKey(Movie, on_delete=models.CASCADE)
    user = models.ForeignKey(settings.AUTH_USER_MODEL, on_delete=models.CASCADE)

    def __str__(self):
        return self.content