from django.shortcuts import render, redirect, get_object_or_404
from django.contrib.auth.forms import UserCreationForm, AuthenticationForm, UserChangeForm, PasswordChangeForm
from django.contrib.auth import login as auth_login
from django.contrib.auth import logout as auth_logout
from django.contrib.auth import update_session_auth_hash
from django.contrib.auth import get_user_model
from django.contrib.auth.decorators import login_required

# Create your views here.
# -----------------------------------------------------------------------------
# signup
# -----------------------------------------------------------------------------
def signup(request):
    if request.user.is_authenticated:
        return redirect('movies:index')

    if request.method == 'POST':
        form = UserCreationForm(request.POST)
        if form.is_valid():
            user = form.save()
            auth_login(request, user)
            return redirect('movies:index')
    else:
        form = UserCreationForm()

    context = {
        'form': form,
        'label': '회원가입'
    }
    return render(request, 'accounts/signup.html', context)



# -----------------------------------------------------------------------------
# login
# -----------------------------------------------------------------------------
def login(request):
    if request.user.is_authenticated:
        return redirect('movies:index')

    if request.method == 'POST':
        form = AuthenticationForm(request, request.POST)
        if form.is_valid():
            auth_login(request, form.get_user())
            return redirect(request.GET.get('next') or 'movies:index')
    else:
        form = AuthenticationForm()

    context = {
        'form': form,
        'label': '로그인'
    }

    # return render(request, 'accounts/auth_form.html', context)
    return render(request, 'accounts/login.html', context)


# -----------------------------------------------------------------------------
# logout
# -----------------------------------------------------------------------------
@login_required
def logout(request):
    if request.method == 'POST':
        auth_logout(request)

    return redirect('movies:index')