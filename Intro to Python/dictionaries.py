'''
this program collects data from a dictionary of classes
'''
import csv
import math
cfile = open('courses-2014-19.tsv','r')
reader = csv.DictReader(cfile,delimiter='\t')
courses = list(reader)

instructor = input("Enter the name of an instructor in the form Last, First: ")
total_courses = 0
total_students = 0
average_students = 0
average_class = 0
for c in courses:
    if(c['instructor'] == instructor and int(c['enrolled']) >= 8):
        total_courses += 1
        total_students += int(c['enrolled'] )
        average_class = total_students/total_courses

print(instructor, 'taught', total_courses, 'courses with at least 8 students')
print("they taught", total_students, 'students total (with double counting)')
print("their average class size was", average_class)
cont = input("continue with another instructor?")
while(cont == 'y'):
    instructor = input("Enter the name of an instructor in the form Last, First: ")
    total_courses = 0
    total_students = 0
    average_students = 0
    average_class = 0
    for c in courses:
        if(c['instructor'] == instructor and int(c['enrolled']) >= 8):
            total_courses += 1
            total_students += int(c['enrolled'] )
            average_class = total_students/total_courses

    print(instructor, 'taught', total_courses, 'courses with at least 8 students')
    print("they taught", total_students, 'students total (with double counting)')
    print("their average class size was", average_class)
    cont = input("continue with another instructor?")
print("bye")
