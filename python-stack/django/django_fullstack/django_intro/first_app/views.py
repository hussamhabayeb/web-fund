from django.shortcuts import render
from django.shortcuts import render, HttpResponse




def first_view(request):
    return HttpResponse("this method is the first viewin app_one")


    
def index(request):
    context = {
    	"name": "Noelle",
    	"favorite_color": "turquoise",
    	"pets": ["Bruce", "Fitz", "Georgie"]
     
    } 
    
    return render(request, "index.html", context)


def secand_view(request):
    return HttpResponse("this method is the secand view in app_secand")

# Create your views here.
