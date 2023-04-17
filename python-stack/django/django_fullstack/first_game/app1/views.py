from django.shortcuts import render, HttpResponse,redirect
import random
 


# for render the page from path ' ' to (index) method

def index(request):
    
    request.session['x']=random.randrange(1, 100,1)
    print(request.session['x'])
    return render(request,"index.html")



# for action the form  from the path '/action'  to ( rand_num )  method


def rand_num(request):
 
    if int(request.POST['guess']) == int(request.session['x']):
        
       
        return render(request,"index2.html")
    
    elif int(request.POST['guess'])>int(request.session['x']): 
        
        print(request.session['x'])
        print(request.POST['guess'])
        context={
            
            'y': "Too High"
        }
        
        return render(request,"index3.html",context)
     
    elif int(request.POST['guess'])<int(request.session['x']): 
        
        print(request.session['x'])
        print(request.POST['guess'])
        context={
            
            'y': "Too low"
        }
        
        return render(request,"index3.html",context)
        
