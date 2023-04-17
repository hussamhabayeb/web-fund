
class Queue:

 
 
    def __init__(self):
        self.qe=[]    
        
 
    def enqueue(self,data):
        
        self.qe.append(data)
    
    def dequeue(self):
        if len(self.qe) < 1:
            return None
        return self.qe.pop(0)
    
   
   
qu1=Queue()
qu1.enqueue(1)
qu1.enqueue(2)

print(qu1.qe)   
qu1.dequeue()
print(qu1.qe) 
qu1.dequeue()
print(qu1.qe) 