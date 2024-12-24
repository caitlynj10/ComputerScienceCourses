'''
this program produces a randomly generated arithmetic quiz
'''

import math
import random


num_correct = 0 #number of answers correct
num_total = 0 #total number of questions
cont = 'y'

def one_round_of_quiz():
    '''
    this function holds the mechanics for the full quiz
    '''
    A = random.randint(-10,100)
    B = random.randint(-10,100)
    all_signs = ['+', '-', '*', '/'] #create a string that holds each arithmetic sign
    random_sign = random.choice(all_signs) #pick each sign at random
    equation = str(A) + " " +  random_sign + " " + str(B)
    user_ans = int(input(("What is {fequ}: ".format(fequ = equation)))) #.format is used to have more than one parameter in an input statement
    answer = compute_equation(A,B,random_sign)
    global num_correct
    global num_total
    '''
    global allows for num_correct and num_total to be tracked properly AND used in this function
    '''
    is_correct(user_ans,answer)
    quiz_grade = str(num_correct) + ' out of ' + str(num_total)
    print("")
    global cont
    cont = input("you have correctly answered {fqg}. continue? (y or n): ".format(fqg = quiz_grade))
    print(" ")


def compute_equation(num1, num2, str):
    '''
    this function computes the answer for the given A, B, and sign value
    '''
    if str == '+':
        return(num1+num2)
    elif str == '-':
        return(num1-num2)
    elif str == '*':
       return(num1*num2)
    else:
        return(int(num1/num2))

def quiz():
    '''
    lets player play contiuously 
    '''
    one_round_of_quiz()
    global cont
    while(cont == 'y'):
        one_round_of_quiz()
    print("bye")

def is_correct(num3, num4):
    '''
    this method checks to if the answer the player inputs is the right answer to the quiz
    '''
    global num_correct
    global num_total
    if(num3 == num4):
        num_correct+=1
        num_total+= 1
        print("correct!")
    else:
        num_total+=1
        print("Sorry the correct answer is",num4)
    
