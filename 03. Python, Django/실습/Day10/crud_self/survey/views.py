from django.shortcuts import render, redirect
from .models import Question, Choice

# Create your views here.

#------------------------------------------------------------------------------
# index
#------------------------------------------------------------------------------
def index(request):
    questions = Question.objects.all()
    context = {
        'questions': questions
    }
    return render(request, 'survey/index.html', context)

#------------------------------------------------------------------------------
# new
#------------------------------------------------------------------------------
def new(request):
    if request.method == 'GET':
        return render(request, 'survey/new.html')
    else:
        question = request.POST.get('question')
        q = Question()
        q.question = question
        q.save()

        return redirect("survey:index")

#------------------------------------------------------------------------------
# detail
#------------------------------------------------------------------------------
def detail(request, q_id):
    q = Question.objects.get(id=q_id)
    context = { 'question': q }
        
    return render(request, "survey/detail.html", context)

#------------------------------------------------------------------------------
# update
#------------------------------------------------------------------------------
def update(request, q_id):
    q = Question.objects.get(id=q_id)
    if request.method == 'GET':
        context = { 'question': q}
        return render(request, "survey/update.html", context)
    else:
        q.question = request.POST.get('question')
        q.save()
        return redirect("survey:detail", q_id)

#------------------------------------------------------------------------------
# delete
#------------------------------------------------------------------------------
def delete(request, q_id):
    q = Question.objects.get(id=q_id)
    if request.method == 'GET':
        context = { 'question': q }
        return render(request, "survey/detail.html", context)

    else:
        q = Question.objects.get(id=q_id)
        q.delete()
        return redirect('survey:index')

#------------------------------------------------------------------------------
# new_c
#------------------------------------------------------------------------------
def new_c(request, q_id):
    q = Question.objects.get(id=q_id)
    if request.method == 'GET':
        context = { 'question': q }
        return render(request, "survey/detail.html", context)
    else:
        choice = Choice()
        choice.survey = request.POST.get('survey')
        choice.question = q
        choice.save()
        return redirect("survey:detail", q.id)

#------------------------------------------------------------------------------
# update_c
#------------------------------------------------------------------------------
def update_c(request, q_id, c_id):
    c = Choice.objects.get(id=c_id)
    if request.method == 'GET':
        context = { 'choice': c }
        return render(request, 'survey/update_c.html', context)
    else:
        c.survey = request.POST.get('survey')
        c.save()
        return redirect('survey:detail', q_id)

#------------------------------------------------------------------------------
# delete_c
#------------------------------------------------------------------------------
def delete_c(request, q_id, c_id):
    if request.method == 'POST':
        c = Choice.objects.get(id=c_id)
        c.delete()
 
    return redirect('survey:detail', q_id)

#------------------------------------------------------------------------------
# delete_c
#------------------------------------------------------------------------------
def votes_c(request, q_id, c_id):
    if request.method == 'POST':
        c = Choice.objects.get(id=c_id)
        c.votes += 1
        c.save()
 
    return redirect('survey:detail', q_id)