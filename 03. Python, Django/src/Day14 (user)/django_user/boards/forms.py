from django import forms
from .models import Board, Comment

class BoardForm(forms.ModelForm):
    
    class Meta:
        model = Board
        fields = ['title', 'content']


class CommentForm(forms.ModelForm):

    class Meta:
        model = Comment
        fields = ['comment'] # ('comment', ) # 튜플로 만들 때는 comma를 꼭 붙여줘야한다


    def __init__(self, *args, **kwargs):
        super().__init__(*args, **kwargs)

        self.fields['comment'].widget.attrs.update(
            {'class':'form-control-sm', 'id':'abcdef'})