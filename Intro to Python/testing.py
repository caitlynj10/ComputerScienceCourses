'''
L10 -- demos for Lesson 10
'''

def average_script():
    print("Enter a sequence of numbers and we will find the average")

    n = float(input("Enter your first number: "))
    sum = n
    num_values = 1

    more = input("enter more numbers? (y or n) ")
    while more == "y":
        n = float(input("Enter a number: "))
        sum = sum+n
        num_values = num_values+1
        more = input("enter more numbers? (y or n)" )

    mean = sum/num_values
    print("the average of the", num_values, "numbers is", mean)
    print("goodbye")
    
