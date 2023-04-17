from django.urls import path
from . import views

urlpatterns = [
    path('',views.index),
    path('addbook',views.index1),
    path('book/<int:id>',views.index2),
    path('addaot/<int:id2>',views.index3),
    path('authors',views.run_author),
    path('addar',views.create_author),
    path('authors/<int:id>',views.run_show_auther),
    path('addauth/<int:id3>',views.add_book),
    
]
