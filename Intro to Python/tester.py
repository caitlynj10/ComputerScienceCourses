import math
def fToC(temp):
    c = (temp - 32)*(5/9)
    return c

def distance(speed,time):
    d = speed*time
    return d

def mph2fps(speed):
    "this method takes a speed from miles per hour to feet per second"
    new_speed = (speed*5280)/3600
    return new_speed

def triangleArea(a,b,c):
    s = (a+b+c)/2
    area = math.sqrt(s*(s-a)*(s-b)*(s-c))
    return area

def boiling_point(altitude):
    '''
    this method takes an altitude and returns its boiling point
    '''
    altbase = 1 - 0.0000068753 *altitude
    pressure = 29.921 * altbase**5.2559
    bp = 49.161 * math.log(pressure) + 44.932
    print(bp)



    


    
