from django.shortcuts import render,redirect
import random
from time import gmtime, strftime


def index(request):
    if 'a' not in request.session:
        request.session['a']=0
    if 'activity' not in request.session:
     request.session['activity']=[]         
    return render(request,"index.html")

def index1(request):
    
    color="green"
    if request.POST['gold'] == 'farm':
        temp=random.randrange(21, 31,1)
    


    elif request.POST['gold'] == 'cave':
        temp=random.randrange(31, 41,1)
    


    elif request.POST['gold'] == 'house':
        temp=random.randrange(20, 41,1)
 


    else:
             
        temp=random.randrange(-50, 50,1)
        if temp < 0 :
            color="red"

    request.session['a']+=temp


    time= strftime("%Y-%m-%d %H:%M %p", gmtime())
    if temp< 0:
        action= f" you entered a {request.POST['gold']} and losed {abs(temp)} gold  ( {time})"
    else: 
        action= f" you entered a {request.POST['gold']} and earnd {abs(temp)} gold  ({time})"
        
    request.session['activity'].append({"action":action,"class":color})

    return redirect ('/')

def destroy (request):
    request.session.clear()
    return redirect('/')
