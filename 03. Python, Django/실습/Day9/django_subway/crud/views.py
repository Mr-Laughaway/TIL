from django.shortcuts import render, redirect
from .models import Article, Comment

# Create your views here.

# -----------------------------------------------------------------------------
# Index
# -----------------------------------------------------------------------------
def index(request):
    # python 에서 역순 정렬
    # articles = Article.objects.all()[::-1]

    # ORM 으로 정렬
    articles = Article.objects.order_by('-id')
    context = {
        'articles': articles
    }
    return render(request, 'crud/index.html', context)


# -----------------------------------------------------------------------------
# new
# -----------------------------------------------------------------------------
def new(request):
    if request.method == 'POST':
        title = request.POST.get('title')
        content = request.POST.get('content')

        # DB에 저장
        article = Article()
        article.title = title
        article.content = content
        article.save()

        return render(request, 'crud/created.html')

    else:
        return render(request, 'crud/new.html')


# -----------------------------------------------------------------------------
# create
# -----------------------------------------------------------------------------
"""
def create(request):
    title = request.POST.get('title')
    content = request.POST.get('content')

    # DB에 저장
    article = Article()
    article.title = title
    article.content = content
    article.save()

    return render(request, 'crud/created.html')
"""

# -----------------------------------------------------------------------------
# detail
# -----------------------------------------------------------------------------
def detail(request, pk):
    article = Article.objects.get(pk=pk)
    comments = Comment.objects.filter(article_id=article.id)
    context = {
        'article': article,
        'comments': comments
    }

    return render(request, 'crud/detail.html', context)


# -----------------------------------------------------------------------------
# update
# -----------------------------------------------------------------------------
def update(request, pk):
    article = Article.objects.get(pk=pk)

    if request.method == 'POST':
        article.title = request.POST.get('title')
        article.content = request.POST.get('content')
        article.save()

        context = {
            'article': article
        }

        return redirect('crud:detail', article.id)

    else:
        context = {
            'article': article
        }

        return render(request, 'crud/update.html', context)


# -----------------------------------------------------------------------------
# update
# -----------------------------------------------------------------------------
"""
def revise(request, pk):
    article = Article.objects.get(pk=pk)

    article.title = request.POST.get('title')
    article.content = request.POST.get('content')
    article.save()

    context = {
        'article': article
    }

    return redirect('crud:detail', article.id)
"""


# -----------------------------------------------------------------------------
# delete
# -----------------------------------------------------------------------------
def delete(request, pk):
    article = Article.objects.get(pk=pk)

    if request.method == 'POST':
        article.delete()
        return redirect('crud:index')

    else:
        return redirect('crud:detail', article.id)

    