from django.shortcuts import render,redirect
from .models import *

def index(request):
  context={
         'books':Book.objects.all(),
  }
  return  render(request,'index.html',context)

def index1(request):
  Book.objects.create(title=request.POST['title'],desc=request.POST['description'])
  return redirect('/')


def index2(request,id):
  
  context={
    'bok':Book.objects.get(id=int(id)),
    'aut':Author.objects.all()
  }
  
  return render(request,"bookdet.html",context)
  
def index3(request,id2):
  this_author=Author.objects.get(id=request.POST['authers'])
  this_book=Book.objects.get(id=id2)
  this_book.authors.add(this_author)
  return redirect("/book/"+str(id2))
  
def run_author(request):
  context={
    'ath':Author.objects.all()
  }
  return render(request,"addauthors.html",context)

def create_author(request):
  Author.objects.create(first_name=request.POST['fname'],
                        last_name=request.POST['lname'],)
  return redirect ('/authors')

def run_show_auther (request,id):
 
 data={
  'auther':Author.objects.get(id=int(id) ),
  'books':Book.objects.all() 
 }
 
 return render(request,"show_author.html",data)

def add_book(request,id3):
  this_book=Book.objects.get(id=request.POST['bookauthors'])
  this_author=Author.objects.get(id=id3)
  this_author.books.add(this_book)
  return redirect("/authors/"+str(id3))
  