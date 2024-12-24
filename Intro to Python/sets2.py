'''
this function asks the user for a coursenum and prints out
every course with that course number
'''

import csv
cfile = open('courses-2014-19.tsv','r')
reader = csv.DictReader(cfile,delimiter='\t')
courses = list(reader)

cont = "y"
while(cont == "y"):
    cn = input("Enter a coursenum: ") #cn for coursenum
    ans = { (c['subject'], c['coursenum'], c['title'])
            for c in courses
            if (cn == c['coursenum']) }
    print("here are the courses with that coursenum")
    for a in sorted(ans):
        print(a)
    cont = input("another? (y or n) ")
print("bye")

        
