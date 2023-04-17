from django.urls import path
from . import views

urlpatterns = [
    path('', views.main_page),
    path('shows', views.run_page),
    path('shows/new', views.addshow),
    path('addshow', views.create_form),
    path('shows/<int:id>', views.run_show),
    path('shows/<int:id>/edit', views.run_edit),
    path('edit_show/<int:id>', views.edit_form),
    path('shows/<int:id>/delete', views.delete_show),
    
]
