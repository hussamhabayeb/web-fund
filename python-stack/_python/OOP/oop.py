# def Biggie_Size(s):
#     for i in range(len(s)):
#         if s[i]>0 :
#             s[i]="big"
        
#     return s

# result=Biggie_Size([1,-9,8,-4,9])  
# print(result)
# def Count_Positives(x):
#     count=0
#     for i in range(len(x)):
#         if x[i]>0:
#             count+=1
#     x[len(x)-1]=count     
#     return x
# result=Count_Positives([-1,9,6,6,-9,7])
# print(result)
# def total_function(y):
#     sum=0
#     for i in range (len(y)):
#         sum=y[i]+sum
#     return sum        
# result= total_function([1,3,5,6])  
# print(result)    
# def total_avg_function(y):
#     sum=0
#     avg=0
#     for i in range (len(y)):
#         sum=y[i]+sum
#         avg=sum/2
#     return avg        
# result= total_avg_function([1,3,5,6])  
# print(result)            
# def total_function(y):
#     x=0
#     x=len(y)
        
#     return x       
# result= total_function([1,3,5,6])  
# print(result)            
        
# def Minimum (y):
    
#     if  0 ==len(y) :
#         return False
#     min=y[0]
#     for i in range(len(y)):
        
#         if y[i]<min:
#             min=y[i]
             
#     return min        
        
# result=Minimum([])
# print(result)  
      
# def Maximum  (y):
    
#     if  0 ==len(y) :
#         return False
#     max=y[0]
#     for i in range(len(y)):
        
#         if y[i]>max:
#             max=y[i]
             
#     return max        
        
# result=Maximum([1,8,9,3,5,-6])
# print(result)                
# def Ultimate_Analysis(y):
#     avg=0
#     sum=0
#     min=y[0]
#     max=y[0]
#     e=len(y)
#     for i in range(len(y)):
#         sum=y[i]+sum
#         avg=sum/2
#         if y[i]>max:
#             max=y[i]
#         elif y[i]<min:
#             min=y[i]
         
#     return sum ,avg,min,max,e   
    

# result=Ultimate_Analysis([1,7,6,6,8,4,-9])
# print(result)        
# def  Reverse_List(y):
#     for i in range(int(len(y)/2)):
#      x=y[i]
#      y[i]=y[len(y)-1-i]
#      y[len(y)-1-i]=x
#     return y   
# result=Reverse_List([1,2,8,9,6])
# print(result)    
     
       
     
            
            
       
 