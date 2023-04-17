import bcrypt
from django.contrib import messages
from django.shortcuts import render, redirect
from .models import *


def index(request):

    return render(request, "login_registration.html")


def reg_user(request):
    errors = User.objects.basic_validator(request.POST)
    if len(errors) > 0:
        for key, value in errors.items():
            messages.error(request, value)

            return redirect('/')

    else:
        passward = request.POST['pwd']
        hashed = bcrypt.hashpw(passward.encode(), bcrypt.gensalt()).decode()
        User.objects.create(first_name=request.POST['fname'],
                            last_name=request.POST['lname'],
                            email=request.POST['Email'],
                            passward=hashed)
        request.session['fname'] = request.POST['fname']
        return redirect('/sucsess')


def log_user(request):
    user1 = User.objects.filter(email=request.POST['Email'])
    print("assigned user1 to user email")
    if user1:
        print("user1 have value")

        if bcrypt.checkpw(request.POST['pwd'].encode(), user1[0].passward.encode()):
            print("password check done")
            request.session['newuser'] = user1[0].first_name
            return redirect("/sucsess")
        else:
            print("wrong password")
            messages.error(request, "invaliad credentials ! ")

            return redirect('/')
    else:
        print("email not in database")
        messages.error(request, "invaliad credentials ! ")
        return redirect('/')


def sucsess(request):
    try:
        if request.session['newuser']:
            return render(request, "sucsess.html")
    except:
        return redirect('/')
def log_out(request):
    print('test message')
    del request.session['newuser']
    return redirect('/')
    