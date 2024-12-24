'''
function demo -- several examples of simple functions
'''
import math
def say_hello():
    print("hello world")
    print("this is my first function")
    print("goodbye")
    print("------")
    
def circle_area():
    radius = float(input("what is the radius? "))
    area = math.pi*radius**2
    print("the area of a circle with radius", radius, "is", area)


'''
this function calculates the heat index H from the temperature T
and the realtive humidity R
'''
def heat_index(T,R):
    H = -42.379 + 2.049*T + 10.143*R - 0.225*T*R - 0.00684*T*T - 0.0548*R*R + 0.00123*T*T*R + 0.000853*T*R*R - 0.00000199*T*T*R*R
    return(H)

    

