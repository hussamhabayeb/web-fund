# x = [ [5,2,3], [10,8,9] ] 
# students = [
#      {'first_name':  'Michael', 'last_name' : 'Jordan'},
#      {'first_name' : 'John', 'last_name' : 'Rosales'}
# ]
# sports_directory = {
#     'basketball' : ['Kobe', 'Jordan', 'James', 'Curry'],
#     'soccer' : ['Messi', 'Ronaldo', 'Rooney']
# }
# z = [ {'x': 10, 'y': 20} ]

# # access the integer 2 in the first sublist of x
# print(x[0][1])

# # access the last name of the second student in students
# print(students[1]['last_name'])

# # access the list of basketball players in sports_directory
# print(sports_directory['basketball'])
# sports_directory['basketball'][3] = 'hussam'

# # access the integer 20 in the dictionary in z
# print(z[0]['y'])



# x[1][0]=15
# print(x)
# students[0]['last_name'] = 'Johnson'

# print(students)

#######################################################

students = [
         {'first_name':  'Michael', 'last_name' : 'Jordan'},
         {'first_name' : 'John', 'last_name' : 'Rosales'},
         {'first_name' : 'Mark', 'last_name' : 'Guillen'},
         {'first_name' : 'KB', 'last_name' : 'Tonel'}
    ]


for key, val in students.items():
        print(key, " - ", val)
 





