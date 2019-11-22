from django.shortcuts import render, redirect, get_object_or_404
from .models import Article
from .forms import ArticleForm, AuthorForm
from IPython import embed

# Create your views here.
def index(request):
    # embed()
    articles = Article.objects.all()
    context = {
        'articles': articles
    }
    return render(request, 'article/index.html', context)

def new(request):
    if request.method == 'POST':
        # title = request.POST.get('title')
        # content = request.POST.get('content')
        # article = Article()
        # article.title = title
        # article.content = content
        # article.save()
        
        # 바인딩
        form = ArticleForm(request.POST)
        # form = AuthorForm(request.POST)

        # embed()
        # 유효성 체크
        if form.is_valid():
            # form.cleaned_data
            # form 에서 불필요한 내용을 제거하고 dictionary로 만들어준다
            title = form.cleaned_data.get('title')
            content = form.cleaned_data.get('content')
            article = Article.objects.create(title=title, content=content)
            # author = form.save()

            # return redirect(article)
            return redirect('article:index')

    else:
        form = ArticleForm()
        # form = AuthorForm()

    context = {
        'form': form
    }
    return render(request, 'article/new.html', context)


def detail(request, a_id):
    # article = Article.objects.get(id=a_id)
    article = get_object_or_404(Article, id=a_id)
    context = {
        'article': article
    }
    
    return render(request, 'article/detail.html', context)


def edit(request, a_id):
    # article = Article.objects.get(id=a_id)
    article = get_object_or_404(Article, id=a_id)
    
    if request.method == 'POST':
        form = ArticleForm(request.POST)
        if form.is_valid():
            article.title = form.cleaned_data.get('title')
            article.content = form.cleaned_data.get('content')
            article.save()
            return redirect(article)
    else:
        form = ArticleForm(initial=article.__dict__)
        # embed()

    context = {
        'form': form
    }

    return render(request, 'article/new.html', context)


def delete(request, a_id):
    # article = Article.objects.get(id=a_id)
    article = get_object_or_404(Article, id=a_id)
    if request.method == 'POST':
        
        article.delete()

    return redirect('article:index')
