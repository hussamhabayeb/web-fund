from django.urls import path
from . import views
urlpatterns = [
    path('',views.index),
    path('registration',views.reg_user),
    path('login',views.log_user),
    path('sucsess',views.sucsess),
    path('logout',views.log_out),
]
