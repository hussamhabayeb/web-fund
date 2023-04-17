from django.shortcuts import render,redirect
from app1.models import *

from django.contrib import messages
import bcrypt 
def index(request):
    return render(request,'index.html')

def register(request):
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
       
        return redirect('/paintings/new')######################################################
    
    
def login(request):
    print(request.POST)
    user = User.objects.filter(email=request.POST['email'])
    
    if user: 
        logged_user = user[0] 
        if bcrypt.checkpw(request.POST['pwd'].encode(), logged_user.password.encode()):
            # if we get True after checking the password, we may put the user id in session
           
            request.session['uid']= logged_user.id
            
            # never render on a post, always redirect!
            return redirect('/paintings/new')##############################################
    return redirect("/")

def showproject(request):
    
    
    if 'uid' not in request.session:
        print("login")
        return redirect ('/')
    
    context={
           
           'user_id':User.objects.get(id=request.session['uid']),
       }
    
    return render(request,'test.html',context)   

def logout(request):
    del request.session['uid']
    return redirect ('/')

def addpaint(request):
    errors = Paint.objects.valdiate_addpaint(request.POST)
        
    if len(errors) > 0:
        
        for key, value in errors.items():
            messages.error(request, value)
            
            return redirect('/paintings/new')
    this_user=User.objects.get(id=request.session['uid'])
          
    this_paint=Paint.objects.create(title=request.POST['title'],
                                         description =request.POST['desc'],
                                         price=request.POST['price'], 
                                         user=this_user)    
        
    return redirect('/paintings')

def dashbord(request):
    if 'uid' not in request.session:
        print("login")
    
    
        return redirect ('/')
       
    else:
        target=User.objects.get(id=request.session['uid'])
        
        
        data={
        'this_user':User.objects.all(),
        'user': target.purchesd_paints.all(),  
        'paints':Paint.objects.all()
        }    
        
    return render(request,"addpaint.html",data)
    
def details(request,id):
    
    
    
    data={
        'u':User.objects.get(id=request.session['uid']),
        'p':Paint.objects.get(id=id),
        
    }
    return render(request,"details.html",data)  

def delete_show(request,id):
    c=Paint.objects.get(id=id)
    c.delete()
    return redirect ('/paintings')
  
def edit(request,id):
    
    data={
        'u':User.objects.get(id=request.session['uid']),
        'p':Paint.objects.get(id=id),
    
    }
    
    return render (request,"edit.html",data)

def updated(request,id):
        c=Paint.objects.get(id=id)
        c.title=request.POST['title']
        c.description=request.POST['desc']
        c.price=request.POST['price']
        c.save()
        
        return redirect ('/paintings/'+str(id))
    
    