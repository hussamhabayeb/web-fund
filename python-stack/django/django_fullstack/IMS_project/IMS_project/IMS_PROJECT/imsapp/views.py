from django.shortcuts import render,redirect
from imsapp.models import *
from django.contrib import messages

def log_in(request):
    return render(request,'login.html')
def relogin(request):
    return redirect('/')
def login(request):
    errors = User.objects.log_validation(request.POST)
    if len(errors) > 0:
        for key, value in errors.items():
            messages.error(request, value)
        return redirect('/')
    user = User.objects.filter(email=request.POST['email'])

    if user:
        if bcrypt.checkpw(request.POST['pwd'].encode(), user[0].password.encode()):
            request.session['user']=user[0].id

            return redirect('/home')
def sign_up(request):
    
    return render(request,'register.html')
def signup(request):
    errors = User.objects.register_validator(request.POST)
    if len(errors) > 0:
        for key, value in errors.items():
            messages.error(request, value)
        return redirect('/sign_up')
    else:
        password = request.POST['pwd']
        pw_hash = bcrypt.hashpw(password.encode(), bcrypt.gensalt()).decode()
        user=User.objects.create(first_name=request.POST['first_name'],
                            last_name=request.POST['last_name'],
                            email=request.POST['email'],
                            password=pw_hash)
        request.session['userid']=user.id
        return redirect('/home')
def home(request):
        if 'user'not in request.session:
            return redirect('/')
        data={
        'user':User.objects.all(),
        'userid':User.objects.get(id=request.session['user']),
        }
        return render(request,'home.html',data)
def log_out(request):
    request.session.clear()
    return redirect('/')
def show_inventory(request):
    data={
        'product':Product.objects.all(),
    }
    return render(request,'inventory.html',data)
def go_to_add_products(request):
    data={
        'c':Catogrey.objects.all()
    }
    return render(request,'addproduct.html',data)
def add_product(request):
    p_name=request.POST['p_name']
    price=request.POST['price']
    quantity=request.POST['quantity']
    desc=request.POST['desc']
    this_category=Catogrey.objects.get(type=request.POST['category'])
    this_product=Product.objects.create(name=p_name,
                        price=price,
                        quantity=quantity,
                        description=desc
                        )
    this_product.categoies.add(this_category)
    return redirect('/inventory')
    
def delete_product(request,id_porduct):
    this_product=Product.objects.get(id=id_porduct)
    this_product.delete()
    return redirect ('/inventory')   
def showedit_product(request,id_porduct):
    data={
        'product':Product.objects.get(id=id_porduct),
        'c':Catogrey.objects.all()
    }
    return render(request,'edit.html',data)
def edit_product(request,id_porduct):
    edit_name=request.POST['p_name']
    edit_price=request.POST['price']
    edit_quantity=request.POST['quantity']
    edit_desc=request.POST['desc']
    this_product=Product.objects.get(id=id_porduct)
    this_product.name=edit_name
    this_product.price=edit_price
    this_product.quantity=edit_quantity
    this_product.description=edit_desc
    this_product.save()
    return redirect('/inventory')
def info_product(request,id_product):
    product_data={
        'all_products':Product.objects.get(id=id_product),
        
    }
    return render(request,'details.html',product_data)
def add_quntity(request,all_products_id):
    sum =request.POST['quntity']
    num=Product.objects.get(id=all_products_id)
    
    num.quantity=float(sum)+num.quantity
    num.save()
    return redirect('/inventory')

   
    