from django.shortcuts import render ,HttpResponse,redirect

def counter(request):
    
    if 'num'  not in request.session:
         request.session['num']=1
         print("key 'key_name' does NOT exist")
         
    
    
    else:
        
        
      request.session['num']+=1
         
      print('key exists!')
    
    
    return render(request,"show.html")
    

def destroy(request):
    request.session.clear()
    return redirect("/")