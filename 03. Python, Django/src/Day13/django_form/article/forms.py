from django import forms
from .models import Author

check_box = [
    ('one', "하나"),
    ('two', "둘"),
    ('three', "셋")
]

MONTH_EN = {
    1:('JAN'), 2:('FEB'), 3:('MAR'), 4:('APR'),
    5:('MAY'), 6:('JUN'), 7:('JUL'), 8:('AUG'),
    9:('SEP'), 10:('OCT'), 11:('NOV'), 12:('DEC')
}

class ArticleForm(forms.Form):
    title = forms.CharField(
        max_length=20,
        widget=forms.TextInput(
            attrs={
                'class': 'form-control'
            }
        )
    )
    # content = forms.CharField(max_length=5, help_text="5자리만 입력하세요.")
    content = forms.CharField(
        widget=forms.Textarea(
            attrs={
                'class':'form-control'
            }
        )
    )

    # title = forms.CharField(
    #     widget=forms.TextInput(
    #         attrs={
    #             'class':"form-controm"
    #         }
    #     )
    # )


    # # 체크 박스
    # content = forms.MultipleChoiceField(
    #     widget=forms.CheckboxSelectMultiple,
    #     choices=check_box
    # )


    # # 라이오 버튼
    # content = forms.ChoiceField(
    #     widget=forms.RadioSelect,
    #     choices=check_box
    # )

    # # 드랍 다운
    # content = forms.ChoiceField(
    #     widget=forms.Select,
    #     choices=check_box
    # )

    # # 날짜
    # content = forms.DateField(
    #     widget=forms.SelectDateWidget(
    #         years=range(1990, 2020),
    #         months=MONTH_EN
    #     )
    # )


class AuthorForm(forms.ModelForm):
    class Meta:
        model = Author
        fields = ['name', 'company']