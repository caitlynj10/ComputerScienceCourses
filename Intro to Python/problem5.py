'''
this program should calculate the sum of the values after the email
address and print the results in a table
'''
import csv
csvfile = open('problem5.csv','r')
lines = csvfile.readlines()
csvfile.close()
print("Mastery for the students in the class")
for line in lines[1:]:
    vals = line.split(',')
    email = vals[0]
    total = int(vals[1]) + int(vals[2]) + int(vals[3]) + int(vals[4])
    print(total,email)

    
