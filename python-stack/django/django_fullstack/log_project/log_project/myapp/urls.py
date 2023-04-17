from django.urls import path
from . import views
urlpatterns = [
    path('',views.form),
    path('registration',views.reg),
    path('login',views.login),
    path('success',views.success),
    path('travels',views.showtravel),
    path('travels/add/<int:id>',views.addingtrip),
    path('addtrip',views.totravel)
    
]
