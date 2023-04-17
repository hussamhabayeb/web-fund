from django.urls import path
from . import views
urlpatterns = [
    path('', views.index1),
    path('usr', views.displayuser),
    path('show', views.allusers),
]
