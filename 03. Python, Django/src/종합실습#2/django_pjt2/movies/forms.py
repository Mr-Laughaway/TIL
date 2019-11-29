from django import forms
from .models import Movie, Rating

class MovieForm(forms.ModelForm):

    class Meta:
        model = Movie
        fields = ['title', 'description', 'poster']


class RatingForm(forms.ModelForm):

    class Meta:
        model = Rating
        fields = ['score', 'content']

    def __init__(self, *args, **kwargs):
        super().__init__(*args, **kwargs)
        self.fields['score'].widget.attrs['min'] = 0.0
        self.fields['score'].widget.attrs['max'] = 10.0





