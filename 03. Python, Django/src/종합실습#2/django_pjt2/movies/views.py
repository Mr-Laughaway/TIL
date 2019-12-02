from django.shortcuts import render, redirect, get_object_or_404
from django.contrib.auth.decorators import login_required
from django.views.decorators.http import require_POST
from .models import *
from .forms import *
from IPython import embed

# Create your views here.

# -----------------------------------------------------------------------------
# index
# -----------------------------------------------------------------------------
def index(request):
    movies = Movie.objects.all()

    for movie in movies:
        ratings = Rating.objects.filter(movie=movie)
        if len(ratings) > 0:
            score_list = list(map(lambda rate: rate.score, ratings))
            score = sum(score_list) / len(score_list)
            movie.score = score
        else:
            movie.score = "아직 평점이 없습니다."

    context = {
        'movies': movies,
    }
    return render(request, 'movies/index.html', context)


# -----------------------------------------------------------------------------
# new
# -----------------------------------------------------------------------------
@login_required
def new(request):
    if request.method == 'POST':
        form = MovieForm(request.POST)
        if form.is_valid():
            movie = form.save(commit=False)
            movie.user = request.user
            movie.poster = request.FILES.get('poster')
            movie.save()
            return redirect('movies:detail', movie.id)

    else:
        form = MovieForm()

    context = {
        'title': "새 영화 등록",
        'form': form,
        'btn': '등록'
    }

    return render(request, 'movies/form.html', context)
    

# -----------------------------------------------------------------------------
# detail
# -----------------------------------------------------------------------------
def detail(request, m_id):
    movie = get_object_or_404(Movie, id=m_id)
    ratings = Rating.objects.filter(movie=movie)
    context = {
        'movie': movie,
        'ratings': ratings
    }
    
    return render(request, 'movies/detail.html', context)


# -----------------------------------------------------------------------------
# edit
# -----------------------------------------------------------------------------
@login_required
def edit(request, m_id):
    movie = get_object_or_404(Movie, id=m_id)
    
    if request.method == 'POST':
        form = MovieForm(request.POST)
        if form.is_valid:
            movie.title = request.POST.get('title')
            movie.description = request.POST.get('description')
            img = request.FILES.get('poster')
            if img != None:
                movie.poster = img
            movie.save()
            
            return redirect('movies:detail', m_id)

    else:
        
        if movie.user != request.user:
            return redirect('movies:detail', m_id)

        form = MovieForm(instance=movie)
        context = {
            'title': "영화 수정",
            'form': form,
            'btn': '수정'
        }

    return render(request, 'movies/form.html', context)


@login_required
@require_POST
# -----------------------------------------------------------------------------
# delete
# -----------------------------------------------------------------------------
def delete(request, m_id):
    movie = get_object_or_404(Movie, id=m_id)

    if movie.user != request.user:
        return redirect('movies:detail', m_id)

    movie.delete()

    return redirect('movies:index')


# -----------------------------------------------------------------------------
# rating new
# -----------------------------------------------------------------------------
@login_required
def new_rating(request, m_id):
    if request.method == 'POST':
        form = RatingForm(request.POST)
        if form.is_valid():
            rating = form.save(commit=False)
            rating.user = request.user
            rating.movie = get_object_or_404(Movie, id=m_id)
            rating.save()
            return redirect('movies:detail', m_id)

    else:
        form = RatingForm()

    context = {
        'title': "평점 등록",
        'form': form,
        'btn': '등록'
    }

    return render(request, 'movies/form.html', context)


@login_required
@require_POST
# -----------------------------------------------------------------------------
# delete
# -----------------------------------------------------------------------------
def delete_rating(request, m_id, r_id):
    rating = get_object_or_404(Rating, id=r_id)

    if rating.user != request.user:
        return redirect('movies:detail', m_id)

    rating.delete()

    return redirect('movies:index')

