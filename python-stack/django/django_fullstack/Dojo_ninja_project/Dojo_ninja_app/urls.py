from django.urls import path
from . import views

urlpatterns = [
    path('', views.index),
    path('hub', views.index1),
    # path('show', views.index3),
    path('run', views.index2),
]