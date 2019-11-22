from django.db import models
from imagekit.models import ProcessedImageField, ImageSpecField
from imagekit.processors import ResizeToFill, ResizeToFit, Thumbnail

# Create your models here.
def board_img_path(instance, filename):
    return f"boards/{instance.pk}번글/{filename}"
# DB에 저장이 된 뒤에야 ID 가 생기는데 그전에 참조하여
# None 으로 뜸. 수정하면 정상적으로 됨


class Board(models.Model):
    title = models.CharField(max_length=20)
    content = models.TextField()
    updated = models.DateTimeField(auto_now=True)
    created = models.DateTimeField(auto_now_add=True)

    # # Resize To Fill Ver.1
    # image = ProcessedImageField(
    #     upload_to = 'boards/img',
    #     processors = [
    #         ResizeToFill(300, 300)
    #     ],
    #     format = "JPEG",
    #     options = {
    #         'quality': 90
    #     }
    # )

    # # Resize To Fit Ver.1
    # image = ProcessedImageField(
    #     upload_to = 'boards/img',
    #     processors = [
    #         ResizeToFit(300, 300)
    #     ],
    #     format = "JPEG",
    #     options = {
    #         'quality': 90
    #     }
    # )

    # # Thumbnail Ver.1
    # image = ProcessedImageField(
    #     upload_to = 'boards/img',
    #     processors = [
    #         Thumbnail(100, 100)
    #     ],
    #     format = "JPEG",
    #     options = {
    #         'quality': 90
    #     }
    # )
    
    # # thumbnail 원본 저장하고 썸네일은 캐쉬형태로 Ver.2
    # image = models.ImageField(blank=True)
    # image_thumb = ImageSpecField(
    #     source = 'image',
    #     processors = [
    #         Thumbnail(100, 100)
    #     ],
    #     format = "JPEG",
    #     options = {
    #         'quality': 90
    #     }
    # )


    image = models.ImageField(
        blank = True,
        # upload_to = "boards/%Y/%m/%d"
        upload_to = board_img_path
    )
    image_thumb = ImageSpecField(
        source = 'image',
        processors = [Thumbnail(100, 100)],
        format = "JPEG",
        options = {
            'quality': 90
        }
    )


