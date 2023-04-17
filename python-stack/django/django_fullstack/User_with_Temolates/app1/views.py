from django.shortcuts import render, HttpResponse,redirect
from.models import Users
def index1(request):
    
    return render(request,"index1.html")


def displayuser(request):
    Users.objects.create(Name=request.POST['Fname']+request.POST['Lname'],Email=request.POST['Email'],Age=request.POST['Age'])
    return redirect("/show")

def allusers(request):
    context={
        'allusers':Users.objects.all(),
        
    }
    return render(request,"index1.html",context)