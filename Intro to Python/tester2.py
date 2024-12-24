'''
this formula calulates the monthly payment p for a loan
'''
import math

def amortization_calculator():
    print("Amoritzation Calculator")
    P = float(input("enter Principal P: "))
    r = float(input("enter your annual interest: "))
    t = float(input("enter number of years: "))
    n = float(input("enter number of payments per year: "))

    rate = r/100
    a = n*t
    p = (rate*P)/((n)*(1-(1+(rate/n))**-a))

    print("Principal, P =", P)
    print("Annual Interest Rate (e.g. 0.1 for 10%), r =", rate)
    print("Number of years, t =", t)
    print("Number of payments per year, e.g. 12, n =", n)
    print("The monthly payment will be p =", p)

def windchill(temp,vel):
    '''
    this program calculates the wind chill in terms of the temperature and the wind velocity
    '''
    wc = 35.74 + (0.6215*temp) - (35.75*(vel**0.16)) + (0.4275*temp*(vel**0.16))
    print(wc)

import math

def change_counter():
    '''
    This script will calculate the total value of the change
    as well as the number of each coin and the total value from those coins.
    '''

    print("Change Counter")
    print("Enter your coins after the prompt '>' where")
    print("p=penny = 1 cent")
    print("n=nickle = 5 cents")
    print("d=dime = 10 cents")
    print("q=quarter = 25 cents")
    print("x=no more coins")
    print("This script will calulate the total value")
    p = 1
    pc = 0 #penny counter
    n = 5
    nc = 0 #nickle counter
    d = 10
    dc = 0 #dime counter
    q = 25
    qc = 0 #quarter counter
    x = 0
    total = 0
    c = input(">")

    while (c != 'x'):
        if (c == 'p'):
            total = total + p
            pc = pc + 1
            print("you have",total, "cents so far")
            c = input(">")
        elif (c=='n'):
            total = total + n
            nc = nc + 1
            print("you have",total, "cents so far")
            c = input(">")
        elif (c=='d'):
            total = total + d
            dc = dc + 1
            print("you have",total, "cents so far")
            c = input(">")
        else:
            total = total + q
            qc = qc + 1
            print("you have",total, "cents so far")
            c = input(">")

    
    print("the total is",total,"cents")
    print(pc,"pennies for",pc,"cents")
    print(nc,"nickels for", nc*5, "cents")
    print(dc,"dimes for", dc*10, "cents")
    print(qc, "quarters for", qc*25,"cents")
    
        
            

            

            

            
            


    
                    
