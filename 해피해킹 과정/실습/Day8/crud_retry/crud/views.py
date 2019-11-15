from django.shortcuts import render, redirect
from .models import Article

# Create your views here.

# -----------------------------------------------------------------------------
# index
# -----------------------------------------------------------------------------
def index(request):
    articles = Article.objects.order_by('-id')
    context = {
        'articles': articles
    }

    return render(request, 'crud/index.html', context)


# -----------------------------------------------------------------------------
# new
# -----------------------------------------------------------------------------
def new(request):
    return render(request, 'crud/new.html')


# -----------------------------------------------------------------------------
# create
# -----------------------------------------------------------------------------
def create(request):
    article = Article()
    article.title = request.POST.get('title')
    article.content = request.POST.get('content')
    article.save()

    return redirect('/crud/')


# -----------------------------------------------------------------------------
# detail
# -----------------------------------------------------------------------------
def detail(request, pk):
    article = Article.objects.get(pk=pk)
    context = {
        'article': article
    }

    return render(request, 'crud/detail.html', context)


# -----------------------------------------------------------------------------
# update
# -----------------------------------------------------------------------------
def update(request, pk):
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
    
    return redirect(f"/crud/{article.id}/detail/")


# -----------------------------------------------------------------------------
# delete
# -----------------------------------------------------------------------------
def delete(request, pk):
    articles = Article.objects.filter(pk=pk)
    if len(articles) > 0:
        articles[0].delete()

    return redirect("/crud/")