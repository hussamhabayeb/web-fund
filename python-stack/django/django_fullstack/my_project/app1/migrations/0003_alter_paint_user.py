# Generated by Django 4.1.7 on 2023-03-30 10:51

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    dependencies = [
        ('app1', '0002_paint'),
    ]

    operations = [
        migrations.AlterField(
            model_name='paint',
            name='user',
            field=models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, related_name='purchesd_paints', to='app1.user'),
        ),
    ]
