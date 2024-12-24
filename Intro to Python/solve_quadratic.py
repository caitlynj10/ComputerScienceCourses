'''
this should solve using the quadratic formula
'''
import math
a = float(input("Enter a:"))
b = float(input("Enter b:"))
c = float(input("Enter c:"))
d = b**2 -4*a*c
if(d <0):
    print("no solutions")
elif(d==0):
    x = (-b/(2*a))
    print("there is one solution; x=",x)
else:
    z = (-b + math.sqrt(d))/(2*a)
    w = (-b - math.sqrt(d))/(2*a)
    print("there are two solutions")
    print("x1=",z)
    print("x2=",w)
    
    
