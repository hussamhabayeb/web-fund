# Generated by Django 2.2.4 on 2023-03-27 22:40

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('myapp', '0001_initial'),
    ]

    operations = [
        migrations.CreateModel(
            name='Travel',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('destination', models.CharField(max_length=45)),
                ('desc', models.TextField()),
                ('start_date', models.TimeField()),
                ('end_date', models.TimeField()),
                ('plan', models.TextField()),
                ('created_at', models.DateTimeField(auto_now_add=True)),
                ('updated_at', models.DateTimeField(auto_now=True)),
                ('trip', models.ManyToManyField(related_name='uesrs_trip', to='myapp.User')),
            ],
        ),
    ]
