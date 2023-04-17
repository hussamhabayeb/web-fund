class User:
    def __init__(self,name,email):
        self.name= name
        self.email_addres= email
        self.account_balance= 0
        
        
    def make_deposit(self,amount):
            self.account_balance+=amount
            return self
             
    def make_withdrawal(self,amount):
            self.account_balance-=amount
            return self
    def display_user_balance(self):
            print(f"name :{self.name} ,balacne : {self.account_balance}")  
            return self       
    
        
        
user1=User("hussam","hussam@hussam.com")   
user2=User("sabaha","sabha@sabha.com")  
user3=User("gamal","gamal@gamal.com")  



# print(user1.user.account_balance)  
user1.make_deposit(100).make_deposit(100).make_deposit(100).make_deposit(100).make_withdrawal(200).display_user_balance()

 
user2.make_deposit(100).make_deposit(100).make_withdrawal(200).make_withdrawal(200).display_user_balance()
      

user3.make_deposit(100).make_withdrawal(200).make_withdrawal(200).make_withdrawal(200).display_user_balance()
