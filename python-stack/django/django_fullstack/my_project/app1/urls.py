
from django.urls import path
from.import views

urlpatterns = [
    path('',views.index),
    path('registration',views.register),
    path('login',views.login),
    path('logout',views.logout),
    path('paintings/new',views.showproject),
    path('addpaint',views.addpaint),
    path('paintings',views.dashbord),
    path('paintings/<int:id>',views.details),
    path('paintings/<int:id>/edit',views.edit),
    path('edit/<int:id>',views.updated),
    path('delete/<int:id>',views.delete_show),
    
    
]
