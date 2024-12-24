'''
this program takes a string last and returns a tuple of every class that teacher taugh with NO duplicates
'''

import csv
cfile = open('courses-2014-19.tsv','r')
reader = csv.DictReader(cfile,delimiter='\t')
courses = list(reader)

c= courses[10000]
cont = "y"
while(cont == "y"):
    instr = input("Enter the name of the instructor: ")
    ans = {(c['subject'], c['coursenum'], c['title'])
        for c in courses
        if (instr in c['instructor'] and int(c['enrolled']) >= 8)}
    print("here are the courses they taught")
    for x in sorted(ans):
        print(x)
    cont = input("another? (y or n) ")
print("bye")


