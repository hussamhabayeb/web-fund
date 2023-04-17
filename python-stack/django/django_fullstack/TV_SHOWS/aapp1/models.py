from django.db import models

class Show(models.Model):
    title = models.CharField(max_length=45)
    network = models.TextField(max_length=45)
    release_date = models.DateTimeField()
    Description=models.TextField(default="no description")
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
# Create your models here.
