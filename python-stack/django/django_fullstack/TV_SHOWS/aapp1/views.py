from django.shortcuts import render,redirect
from.models import*


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
    
    Show.objects.create(title=request.POST['title'],network=request.POST['network'],release_date=request.POST['date'])
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
    
    c=Show.objects.get(id=id)
    c.title=request.POST['title']
    c.network=request.POST['network']
    c.release_date=request.POST['date']
    c.Description=request.POST['desc']
   # c.updated_at=
    print(c.title)
    c.save()
    print(c)
    return redirect ('/shows/'+str(id))
    
def delete_show(request,id):
    c=Show.objects.get(id=id)
    c.delete()
    return redirect ('/shows')