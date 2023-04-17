from django.db import models
from django.contrib import messages
import bcrypt
import re

class UserManager(models.Manager):
    def basic_validator(self, postData):
        errors = {}
        if len(postData['fname']) <= 0:
            errors["fname"] = "Must enter a first name!"
        elif len(postData['fname']) < 2:
            errors["fname"] = "First name should be at least 2 characters!"
        if len(postData['lname']) <= 0:
            errors["lname"] = "Must enter a last name!"
        elif len(postData['lname']) < 2:
            errors["lname"] = "Last name should be at least 2 characters!"
        if len(postData['pwd']) <= 0:
            errors["pwd"] = "Password is required!"
        if len(postData['pwd']) < 8:
            errors['pwd1'] = "Password must be at least 8 characters!"
        EMAIL_REGEX = re.compile (r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')
        if not EMAIL_REGEX.match(postData['email']):
            errors['email']="invalid email address!"
        if len(postData['email']) <= 0:
            errors["email"] = "Email is required!"
        if User.objects.filter(email = postData['email']).exists():
            errors['email'] = "Email already exists."
    
        if postData['cpwd'] != postData['pwd']:
            errors['cpwd'] = "Confirmation password does not match password!"
        return errors

class User(models.Model):
    fname = models.CharField(max_length=45)
    lname = models.CharField(max_length=45)
    email=models.CharField(unique=True,max_length=255)
    password=models.CharField(max_length=200)
    created_at = models.DateTimeField(auto_now_add = True)
    updated_at = models.DateTimeField(auto_now = True)
    objects =UserManager()



class PaintManager(models.Manager):
    def valdiate_addpaint(self, postData):
        errors = {}
        
        
        if len(postData['desc']) < 10:
            errors["desc"] = "description should be at least 10 characters!" 

        if int(postData['price']) < 0:
            errors["price"] = "price should be greater than zero !" 
            
        if len(postData['title']) <= 2:
            errors['title'] = "Must enter a first name!"    
            
            
        return errors
    
        
class Paint(models.Model):
    title = models.CharField(max_length=45)
    description = models.CharField(max_length=45)
    price=models.FloatField()
    user=models.ForeignKey(User,related_name="purchesd_paints",on_delete=models.CASCADE)
    created_at = models.DateTimeField(auto_now_add = True)
    updated_at = models.DateTimeField(auto_now = True)
    objects =PaintManager()