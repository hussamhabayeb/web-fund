from django.shortcuts import render,redirect
from.models import*
from django.contrib import messages


def main_page(request):
    return redirect('/shows')



def run_page(request):
    context={
        'allshows':Show.objects.all()
    }
    return render(request,"tv-show.html",context)

def addshow (request):
    
    return render(request,"create_form.html")

def create_form(request):
 
   
    errors = Show.objects.basic_validator(request.POST)
       
    if len(errors) > 0:
        
        for key, value in errors.items():
            messages.error(request, value)
        
        return redirect('/shows/new')
     
       
    
    Show.objects.create(title=request.POST['title'],network=request.POST['network'],release_date=request.POST['date'],
                        Description=request.POST['desc'])
    return redirect ('/shows/' +str(Show.objects.last().id))

def run_show(requset,id):
    Show.objects.get(id=id)
    data = {
        'show' : Show.objects.get(id=id)
        
    }
    return render(requset,"details.html",data)

def run_edit(request,id):
    Show.objects.get(id=id)
    data={
        'edit':Show.objects.get(id=id)
    }
    return render(request,"edit_page.html",data)



def edit_form(request,id):
    
   
    errors = Show.objects.basic_validator(request.POST)
       
    if len(errors) > 0:
        
        for key, value in errors.items():
            messages.error(request, value)
        
        return redirect(f'/shows/{id}/edit')
    else:
    
        c=Show.objects.get(id=id)
        c.title=request.POST['title']
        c.network=request.POST['network']
        c.release_date=request.POST['date']
        c.Description=request.POST['desc']
        c.save()
        messages.success(request, "Blog successfully updated")
        return redirect (f'/shows/{id}') 
    # f('c.id')
def delete_show(request,id):
    c=Show.objects.get(id=id)
    c.delete()
    return redirect ('/shows')








