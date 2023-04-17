from django.shortcuts import render 
import datetime
from time import gmtime, strftime 
    
def display(request):
    context = {
        "time": datetime.datetime.now()
    }
    return render(request,'index.html', context)


    