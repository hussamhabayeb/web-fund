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
    email=models.CharField(max_length=255)
    password=models.CharField(max_length=200)
    created_at = models.DateTimeField(auto_now_add = True)
    updated_at = models.DateTimeField(auto_now = True)
    objects =UserManager()
 
 
 
class bookManager(models.Manager):
    def basic_validator(self, postData):
        errors = {}
        if len(postData['title']) <= 0:
            errors["title"] = "Must enter a first name!"
        
        elif len(postData['desc']) < 2:
            errors["desc"] = "description should be at least 2 characters!" 
 
        return errors

    
class book(models.Model):
    title=models.CharField(max_length=45)
    dece=models.TextField()
    up_loaded_by=models.ForeignKey(User,related_name="books_uploaded",on_delete=models.CASCADE)
    users_who_like =models.ManyToManyField(User,related_name="liked_books")
    created_at = models.DateTimeField(auto_now_add = True)
    updated_at = models.DateTimeField(auto_now = True)
    objects =bookManager()    