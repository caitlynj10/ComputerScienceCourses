'''
this script compares the relative speeds of two sorting algorithms
'''
import math
print("This script compares the speeds of two sorting algorithms")
length = float(input("Enter the length of a list to be sorted:"))
merge_sort = length*math.log(length)/1000000000
bubble_sort = length**2/1000000000
print("quicksort would take",merge_sort,"seconds to sort the list")
print("bubblesort would take",bubble_sort,"seconds to sort the list")
