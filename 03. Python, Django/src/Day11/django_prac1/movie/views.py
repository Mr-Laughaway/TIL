from django.shortcuts import render, redirect
from .models import Movie
import csv, datetime

# Create your views here.
# -----------------------------------------------------------------------------
# index
# -----------------------------------------------------------------------------
def index(request):
    movies = Movie.objects.all()
    context = {
        'movies': movies
    }
    return render(request, 'movie/index.html', context)


# -----------------------------------------------------------------------------
# new
# -----------------------------------------------------------------------------
def new(request):
    if request.method == 'GET':
        return render(request, 'movie/new.html')
    else:
        data = request.POST

        movie = Movie()
        movie.title = data['title']
        movie.title_en = data['title_en']
        movie.audience = data['audience']
        movie.open_date = data['open_date']
        movie.genre = data['genre']
        movie.watch_grade = data['watch_grade']
        movie.score = data['score']
        movie.poster_url = data['poster_url']
        movie.description = data['description']
        movie.save()

        return redirect('movie:index')
    

# -----------------------------------------------------------------------------
# detail
# -----------------------------------------------------------------------------
def detail(request, movie_id):
    movie = Movie.objects.get(id=movie_id)
    context = {
        'movie': movie
    }
    return render(request, 'movie/detail.html', context)


# -----------------------------------------------------------------------------
# edit
# -----------------------------------------------------------------------------
def edit(request, movie_id):
    movie = Movie.objects.get(id=movie_id)
    if request.method == 'GET':
        context = {
            'movie': movie
        }
        return render(request, "movie/edit.html", context)
    else:
        data = request.POST
        movie.title = data['title']
        movie.title_en = data['title_en']
        movie.audience = data['audience']
        movie.open_date = data['open_date']
        movie.genre = data['genre']
        movie.watch_grade = data['watch_grade']
        movie.score = data['score']
        movie.poster_url = data['poster_url']
        movie.description = data['description']
        movie.save()

        return redirect('movie:detail', movie_id)


# -----------------------------------------------------------------------------
# delete
# -----------------------------------------------------------------------------
def delete(request, movie_id):
    if request.method == 'GET':
        return redirect('movie:detail', movie_id)
    else:
         movie = Movie.objects.get(id=movie_id)
         movie.delete()
         return redirect('movie:index')



# -----------------------------------------------------------------------------
# csv2db
# -----------------------------------------------------------------------------
def csv2db(request):
    with open("../misc/data.csv", 'r', encoding='utf-8') as fp:
        csvdata = csv.reader(fp)
        for i, line in enumerate(csvdata):
            if i == 0: continue
            
            movie = Movie()
            movie.title = line[0]
            movie.title_en = line[1]
            movie.audience = int(line[2])
            day = datetime.datetime.strptime(line[3], '%Y%m%d')
            movie.open_date = day
            movie.genre = line[4]
            movie.watch_grade = line[5]
            movie.score = line[6]
            movie.poster_url = line[7]
            movie.description = line[8]
            movie.save()

    return redirect('movie:index')