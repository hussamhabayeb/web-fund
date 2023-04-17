from django.shortcuts import render, HttpResponse



def display(request):
    return render(request,"index.html")

def show_info(request):
    context={
              'x':request.POST['username'],
              'y':request.POST['location'],
              'z':request.POST['languege'],
              'v':request.POST['message']
              
    }
    
    return render(request, "info.html",context)

