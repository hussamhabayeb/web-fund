from django.shortcuts import render,redirect
from .models import Dojo
from .models import Ninja



def index(request):
      context={
           'dojos':Dojo.objects.all()
           }
      
      
      return render (request,"index.html",context)
 
 
def index1 (request):
     Dojo.objects.create(name=request.POST['d-name'],city=request.POST['d-city'],state=request.POST['d-state'])
     return redirect('/')


def index2 (request):
     Ninja.objects.create(first_name=request.POST['fName'],
                         last_name=request.POST['lname'],dojo=Dojo.objects.get(id=request.POST['dojos']))
     return redirect('/')

def index3 (request):
     
     Dojo.objects.all()
     print('dojo.ninja.first_name')
     return render(request,"index.html")