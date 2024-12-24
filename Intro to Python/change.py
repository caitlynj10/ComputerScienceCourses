n = int(input("How much change do you have "))
print("converting",n,"into change gives")
quarters = n//25
if(quarters >0):
    print(quarters, "quarters")
d = n%25 #this is how much we have left
dimes = d//10
if(dimes>0):
    print(dimes, "dimes")
pennies = dimes%10 #this is how much we have left
nickels = nick//5
if(nickles >0):
    print(nick, "nickles")
pennies = n
if(pennies >0):
    print(pennies, "pennies")
