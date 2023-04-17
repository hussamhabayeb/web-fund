from django.db import models
import re



class UserManager(models.Manager):
    def basic_validator(self, postData):
        errors = {}
        
        if len(postData['fname']) < 5:
            errors["fname"] = "first name should be at least 5 characters"
            
        if len(postData['lname']) < 5:
            errors["lname"] = "last name  should be at least 5 characters"
            
            
        EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')
        if not EMAIL_REGEX.match(postData['Email']):          
            errors['Email'] = "Invalid email address!"
            
        if len(postData['pwd']) < 8:
            errors['pwd'] = "passward should be at least 8 characters"    
            
        if postData['pwd'] != postData['con-pwd']:
            errors['con-pwd']="passward dose not match !"
            
        return errors


class User(models.Model):
    first_name = models.CharField(max_length=45)
    last_name = models.CharField(max_length=45)
    email = models.CharField(max_length=255)
    passward=models.CharField(max_length=45)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    objects = UserManager()

# Create your models here.
