from django.shortcuts import render, redirect, get_object_or_404
from .models import Board
from .forms import BoardForm
from IPython import embed
from django.contrib.auth.decorators import login_required

# Create your views here.
# -----------------------------------------------------------------------------
# index
# -----------------------------------------------------------------------------
def index(request):
    boards = Board.objects.all()
    context = {
        'boards': boards
    }
    return render(request, 'boards/index.html', context)


# -----------------------------------------------------------------------------
# new
# -----------------------------------------------------------------------------
@login_required
def new(request):

    if request.method == 'POST':
        form = BoardForm(request.POST)
        if form.is_valid():
            board = form.save(commit=False)
            board.user = request.user
            board.save()
            return redirect('boards:detail', board.id)

    else:
        form = BoardForm()

    context = {
        'form': form
    }

    return render(request, 'boards/new.html', context)


# -----------------------------------------------------------------------------
# detail
# -----------------------------------------------------------------------------
def detail(request, b_id):
    board = get_object_or_404(Board, id=b_id)
    context = {
        'board': board
    }
    return render(request, 'boards/detail.html', context)

    
# -----------------------------------------------------------------------------
# edit
# -----------------------------------------------------------------------------
@login_required
def edit(request, b_id):
    board = get_object_or_404(Board, id=b_id)

    if request.user != board.user:
        return redirect('boards:index')

    if request.method == 'POST':
        form = BoardForm(request.POST, instance=board)
        if form.is_valid():
            board = form.save()
            return redirect('boards:detail', board.id)

    else:
        form = BoardForm(instance=board)

    context = {
        'form' : form
    }

    return render(request, 'boards/edit.html', context)


# -----------------------------------------------------------------------------
# delete
# -----------------------------------------------------------------------------
@login_required
def delete(request, b_id):
    board = get_object_or_404(Board, id=b_id)

    if request.user != board.user:
        return redirect('boards:index')

    if request.method == 'POST':
        board.delete()
        return redirect('boards:index')
    else:
        return redirect('boards:detail', board.id)

