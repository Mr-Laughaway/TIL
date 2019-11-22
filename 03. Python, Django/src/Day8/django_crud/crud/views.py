from django.shortcuts import render, redirect
from .models import Article

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
def new(reuqest):
    return render(reuqest, 'crud/new.html', )


# -----------------------------------------------------------------------------
# create
# -----------------------------------------------------------------------------
def create(request):
    title = request.POST.get('title')
    content = request.POST.get('content')

    # DB에 저장
    article = Article()
    article.title = title
    article.content = content
    article.save()

    return render(request, 'crud/created.html')


# -----------------------------------------------------------------------------
# detail
# -----------------------------------------------------------------------------
def detail(request, pk):
    #(pk=pk)가 (id__exact=pk)와 같음
    article = Article.objects.get(pk=pk)
    context = {
        'article': article
    }

    return render(request, 'crud/detail.html', context)


# -----------------------------------------------------------------------------
# update
# -----------------------------------------------------------------------------
def update(request, pk):
    #(pk=pk) 가(id__exact=pk)
    article = Article.objects.get(pk=pk)
    context = {
        'article': article
    }

    return render(request, 'crud/update.html', context)


# -----------------------------------------------------------------------------
# update
# -----------------------------------------------------------------------------
def revise(request, pk):
    article = Article.objects.get(pk=pk)

    article.title = request.POST.get('title')
    article.content = request.POST.get('content')
    article.save()

    context = {
        'article': article
    }

    return redirect(f"/crud/{article.id}/article/")


# -----------------------------------------------------------------------------
# delete
# -----------------------------------------------------------------------------
def delete(request, pk):
    article = Article.objects.get(pk=pk)
    article.delete()

    return redirect("/crud/")