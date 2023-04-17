from django.db import models


class ShowManager(models.Manager):
    def basic_validator(self, postData):
        errors = {}
    
        if len(postData['title']) < 2:
            errors["title"] = "Blog name should be at least 2 characters"
        if len(postData['network']) < 3:
            errors["network"] = "the show network should be at least 3 characters"
        if len(postData['desc']) < 10:
            errors["desc"] = "the show description should be at least 10 characters"    
        
        return errors


class Show(models.Model):
    title = models.CharField(max_length=45)
    network = models.TextField(max_length=45)
    release_date = models.DateTimeField()
    Description=models.TextField(default="no description")
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    objects = ShowManager()   
