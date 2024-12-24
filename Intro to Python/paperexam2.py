'''
this file goes through a list of words and counts the number of words
that have length 1,2,3,... all the way to 20
'''

import csv
import math

user_file = input("filename: ")
with open(user_file, 'r') as file:
    words_list = file.read().split()
one_counter = 0
one_counter = 0
two_counter = 0
three_counter = 0
four_counter = 0
five_counter = 0
six_counter = 0
seven_counter = 0
eight_counter = 0
nine_counter = 0
ten_counter = 0
eleven_counter = 0
twelve_counter = 0
thirteen_counter = 0
fourteen_counter = 0
fifteen_counter = 0
sixteen_counter = 0
seventeen_counter = 0
eighteen_counter = 0
nineteen_counter = 0
twenty_counter = 0
counter = 0

for word in words_list:
    if(len(word) == 1):
        one_counter += 1
    elif(len(word) == 2):
        two_counter += 1
    elif(len(word) == 3):
        three_counter += 1
    elif(len(word) == 4):
        four_counter += 1
    elif(len(word) == 5):
        five_counter += 1
    elif(len(word) == 6):
        six_counter += 1
    elif(len(word) == 7):
        seven_counter += 1
    elif(len(word) == 8):
        eight_counter += 1
    elif(len(word) == 9):
        nine_counter += 1
    elif(len(word) == 10):
        ten_counter += 1
    elif(len(word) == 11):
        eleven_counter += 1
    elif(len(word) == 12):
        twelve_counter += 1
    elif(len(word) == 13):
        thirteen_counter += 1
    elif(len(word) == 14):
        fourteen_counter += 1
    elif(len(word) == 15):
        fifteen_counter += 1
    elif(len(word) == 16):
        sixteen_counter += 1
    elif(len(word) == 17):
        seventeen_counter += 1
    elif(len(word) == 18):
        eighteen_counter += 1
    elif(len(word) == 19):
        nineteen_counter += 1
    elif(len(word) == 20):
        twenty_counter += 1
    else:
        counter += 1

print("there are ", one_counter, " words with a length of 1")
print("there are ", two_counter, " words with a length of 2")
print("there are ", three_counter, " words with a length of 3")
print("there are ", four_counter, " words with a length of 4")
print("there are ", five_counter, " words with a length of 5")
print("there are ", six_counter, " words with a length of 6")
print("there are ", seven_counter, " words with a length of 7")
print("there are ", eight_counter, " words with a length of 8")
print("there are ", nine_counter, " words with a length of 9")
print("there are ", ten_counter, " words with a length of 10")
print("there are ", eleven_counter, " words with a length of 11")
print("there are ", twelve_counter, " words with a length of 12")
print("there are ", thirteen_counter, " words with a length of 13")
print("there are ", fourteen_counter, " words with a length of 14")
print("there are ", fifteen_counter, " words with a length of 15")
print("there are ", sixteen_counter, " words with a length of 16")
print("there are ", seventeen_counter, " words with a length of 17")
print("there are ", eighteen_counter, " words with a length of 18")
print("there are ", nineteen_counter, " words with a length of 19")
print("there are ", twenty_counter, " words with a length of 20")
print("there are ", counter, " words with a length > 20")
        



