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
    for art in articles:
        art.com_count = len(art.comment_set.all())
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
def detail(request, art_id):
    article = Article.objects.get(id=art_id)
    comments = Comment.objects.filter(article_id=article.id)
    context = {
        'article': article,
        'comments': comments,
        'com_count': len(comments)
    }

    return render(request, 'crud/detail.html', context)


# -----------------------------------------------------------------------------
# update
# -----------------------------------------------------------------------------
def update(request, art_id):
    article = Article.objects.get(id=art_id)

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
def delete(request, art_id):
    article = Article.objects.get(id=art_id)

    if request.method == 'POST':
        article.delete()
        return redirect('crud:index')

    else:
        return redirect('crud:detail', article.id)

    

# -----------------------------------------------------------------------------
# comment
# -----------------------------------------------------------------------------
def comment(request, art_id):
    if request.method == 'POST':
        comment = request.POST.get('comment')

        com = Comment()
        com.comment = comment
        com.article = Article.objects.get(id=art_id)
        com.save()

    return redirect('crud:detail', art_id)
    # return redirect('crud:detal', com.article_id) #도 같음
 

# -----------------------------------------------------------------------------
# comment_edit
# -----------------------------------------------------------------------------
def comment_edit(request, art_id, com_id):
    com = Comment.objects.get(id=com_id)

    if request.method == 'GET':
        context = {
            'comment': com
        }

        return render(request, 'crud/comment_edit.html', context)

    else:
        text = request.POST.get('comment')
        com.comment = text
        com.save()

        return redirect('crud:detail', art_id)


def comment_del(request, art_id, com_id):
    if request.method == 'POST':
        com = Comment.objects.get(id=com_id)
        com.delete()
    
    return redirect('crud:detail', art_id)