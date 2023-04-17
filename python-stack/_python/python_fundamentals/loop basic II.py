class User:
    def __init__(self,name,email):
        self.name= name
        self.email_addres= email
        self.account_balance= 0
        
        
    def make_deposit(self,amount):
            self.account_balance+=amount
             
    def make_withdrawal(self,amount):
            self.account_balance-=amount
    def display_user_balance(self):
            print(f"name :{self.name} ,balacne : {self.account_balance}")         
    
        
        
user1=User("hussam","hussam@hussam.com")   
user2=User("sabaha","sabha@sabha.com")  
user3=User("gamal","gamal@gamal.com")  

user1.make_deposit(100)          
user1.make_deposit(100)       
user1.make_deposit(100)               
user1.make_withdrawal(200)
user1.display_user_balance()  
# print(user1.user.account_balance)  
     
user2.make_deposit(100)          
user2.make_deposit(400)       
user2.make_withdrawal(100)               
user2.make_withdrawal(200)
user2.display_user_balance()  
      
user3.make_deposit(1000)          
user3.make_withdrawal(100)       
user3.make_withdrawal(100)               
user3.make_withdrawal(200)
user3.display_user_balance() 