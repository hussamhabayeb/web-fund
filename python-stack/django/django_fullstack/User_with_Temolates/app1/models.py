from django.db import models
    
class Users(models.Model):
 Name = models.CharField(max_length=45)
 Email = models.CharField(max_length=45)
 Age= models.IntegerField()
 created_at = models.DateTimeField(auto_now_add=True)
 updated_at = models.DateTimeField(auto_now=True)


