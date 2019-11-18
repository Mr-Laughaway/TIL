from django.db import models

# Create your models here.
class Article(models.Model):
    title = models.CharField(max_length=50)
    content = models.TextField()
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

    def __str__(self):
        return f"{self.id} {self.title}"


class Comment(models.Model):
    comment = models.CharField(max_length=200)
    # ForeignKey(어떤 테이블을 참조할지, 테이블이 삭제될 때 어떻게 할지)
    # models.CASCADE: 부모테이블이 삭제시 같이 삭제하는 옵션
    # models.PROTECT: 부모테이블이 삭제 될 때 오류 발생
    # models.SET_NULL: 삭제 되었을 때 부모 참고 값을 NULL 값으로 채움. 단 NOT NULL일 경우 에러
    # models.SET(): 특정 함수를 호출
    # models.DO_NOTHING: 아무것도 안 함.
    article = models.ForeignKey(Article, on_delete=models.CASCADE)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
