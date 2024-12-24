'''
this formula calulates the monthly payment p for a loan
'''
import math

P = float(input("enter Principal P: "))
r = float(input("enter your annual interest: "))
t = float(input("enter number of years: "))
n = float(input("enter number of payments per year: "))

rate = r/100
a = n*t
p = (rate*P)/((n)*(1-(1+(rate/n))**-a))

print("Amoritzation Calculator")
print("Principal, P =", P)
print("Annual Interest Rate (e.g. 0.1 for 10%), r =", rate)
print("Number of years, t =", t)
print("Number of payments per year, e.g. 12, n =", n)
print("The monthly payment will be p =", p)
