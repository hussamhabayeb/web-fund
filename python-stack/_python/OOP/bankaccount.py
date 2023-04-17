class BankAccount:
    def __init__(self, int_rate, balance):
        self.balance =0
        self.int_rate =0.01

    def deposit(self, amount):
        self.balance += amount
        return self

    def withdraw(self, amount):
        if self.balance < amount:
            print("Insufficient funds: Charging a $5 fee")
            self.balance -= 5
        else:
            self.balance -= amount
        return self

    def display_account_info(self):
        print(f"Balance: ${self.balance}")
        return self

    def yield_interest(self):
        self.balance += self.balance * self.int_rate
        return self

account1 = BankAccount(int_rate=0.01, balance=1000)


account1.deposit(100).deposit(200).deposit(50).withdraw(300).yield_interest().display_account_info()


account2 = BankAccount(int_rate=0.02, balance=500)


account2.deposit(200).deposit(100).withdraw(50).withdraw(75).withdraw(100).withdraw(50).yield_interest().display_account_info()

		
