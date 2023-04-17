from django.urls import path
from . import views
urlpatterns = [
    path('',views.form),
    path('registration',views.reg),
    path('login',views.login),
    path('books',views.showbook),
    path('destroy',views.logout),
    path('add',views.addbook),
    path('books/<int:book_id>',views.details),
    path('books/<int:book_id>/favorite',views.fav),
    path('bookedit/<int:book_id>',views.edit)
    
]
