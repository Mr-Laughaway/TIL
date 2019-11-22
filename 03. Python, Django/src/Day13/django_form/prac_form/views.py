from django.shortcuts import render, redirect, get_object_or_404
from .models import Book
from .forms import BookForm
from IPython import embed

# Create your views here.
def index(req):
    books = Book.objects.all()
    ctxt = {
        'books':books
    }
    return render(req, 'prac_form/index.html', ctxt)

def new(req):

    if req.method == 'POST':
        form = BookForm(req.POST)
        if form.is_valid():
            # book = Book()
            # book.name = form.cleaned_data.get('name')
            # book.preface = form.cleaned_data.get('preface')
            # book.save()
            book = form.save()
            return redirect('prac:index')
    else:
        form = BookForm()

    # embed()
    ctxt = {
        'form': form
    }
    return render(req, 'prac_form/new.html', ctxt)


def detail(req, b_id):
    # book = Book.objects.get(id=b_id)
    book = get_object_or_404(Book, id=b_id)
    ctxt = {
        'book': book
    }
    return render(req, 'prac_form/detail.html', ctxt)


def edit(req, b_id):
    book = get_object_or_404(Book, id=b_id)

    if req.method == 'POST':
        form = BookForm(req.POST)
        if form.is_valid():
            book = form.save()
            return redirect(book)
    else:
        form = BookForm(initial=book.__dict__)

    ctxt = {
        'form': form
    }

    return render(req, 'prac_form/new.html', ctxt)


def delete(req, b_id):
    book = get_object_or_404(Book, id=b_id)
    if req.method == 'POST':
        book.delete()
    return redirect("prac:index")