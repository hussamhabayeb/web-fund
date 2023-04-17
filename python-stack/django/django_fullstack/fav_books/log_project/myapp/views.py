from django.shortcuts import render,redirect
from myapp.models import *

from django.contrib import messages
import bcrypt 
def form(request):
    return render(request,'form.html')

def reg(request):
    errors = User.objects.basic_validator(request.POST)
        
    if len(errors) > 0:
        
        for key, value in errors.items():
            messages.error(request, value)
            return redirect('/')
    else :
        fname=request.POST['fname']
        lname=request.POST['lname']
        email=request.POST['email']
        password=request.POST['pwd']
        pw_hash = bcrypt.hashpw(password.encode(), bcrypt.gensalt()).decode()
        password=pw_hash
        User.objects.create(fname=fname,lname=lname,email=email,password=pw_hash)
        newUser=User.objects.last()
        
        request.session['fname'] =newUser.fname
        request.session['uid'] =newUser.id
        print(request.session['userid'])
        return redirect('/books')
    
    
def login(request):
    user = User.objects.filter(email=request.POST['email'])
    if user: 
        logged_user = user[0] 
        if bcrypt.checkpw(request.POST['pwd'].encode(), logged_user.password.encode()):
            # if we get True after checking the password, we may put the user id in session
           
            request.session['uid']= logged_user.id
            
            # never render on a post, always redirect!
            return redirect('/books')
    return redirect("/")


def showbook(request):
    if 'uid' not in request.session:
        print("login")
        return redirect ('/')
    else:
        context={
            'userid':User.objects.get(id=request.session['uid']),
            'allbooks':book.objects.all()
        }
        print("hukkk")
        return render(request,'book.html',context)    
def logout(request):
    del request.session['uid']
    return redirect ('/')

def addbook(request):
    errors = book.objects.basic_validator(request.POST)
        
    if len(errors) > 0:
        
        for key, value in errors.items():
            messages.error(request, value)
            return redirect('/books')
    else :
        this_user=User.objects.get(id=request.session['uid'])
          
        this_book=book.objects.create(title=request.POST['title'],
                                        dece=request.POST['desc'],
                                        up_loaded_by=this_user)    
        this_user.liked_books.add(this_book) 
    return redirect('/books')


def details(request,book_id):
    if 'uid' not in request.session:
        return redirect('/')
    
    else:
        
        data={
            'u':User.objects.get(id=request.session['uid']),
            'book':book.objects.get(id=book_id),
            
        }
        
        return render(request,'details.html',data)
    
def fav (request,book_id):
    this_user=User.objects.get(id=request.session['uid'])
    this_book=book.objects.get(id=book_id)
    this_book. users_who_like.add(this_user)
    return redirect('/books') 

def edit(request,book_id):
   
        c=book.objects.get(id=book_id)
        c.title=request.POST['title']
        c.dece=request.POST['desc']
        c.save()
        
        
        return redirect('/books/'+str(book_id))
    


#c=Show.objects.get(id=id)
#     c.title=request.POST['title']
#     c.network=request.POST['network']
#     c.release_date=request.POST['date']
#     c.Description=request.POST['desc']
#    # c.updated_at=
#     print(c.title)
#     c.save()