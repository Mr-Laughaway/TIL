from django.db import models

# Create your models here.
class Question(models.Model):
    question = models.CharField(max_length=50)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

    def __str__(self):
        return f"{self.id} {self.question}"


class Choice(models.Model):
    survey = models.CharField(max_length=30)
    question = models.ForeignKey(Question, on_delete=models.CASCADE)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    votes = models.IntegerField(default=0)

    def __str__(self):
        return f"{self.id} {self.survey}"
