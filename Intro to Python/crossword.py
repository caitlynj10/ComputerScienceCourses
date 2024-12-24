'''
this program asks the user for a pattern based on the key and prints out every
word that contains that pattern
'''
import csv

cfile = open('wlist_match8.tsv','r')
wordlist = cfile.readlines()
cfile.close()


vowel_list = 'aieou' #string of vowels
cons_list = 'bcdfghjklmnpqrstvwxyz' #string of consonants
find_more = "y"

allowed_characters = "abcdefghijklmnopqrstuvwxyz.CV" #string of the only characters allowed in the pattern
def valid_pattern(pattern): #checks if the pattern is valid before continuing
    wrong_char = " "
    for p in pattern:
        if p not in allowed_characters: #checks if character is in the list of allowed characters
            return False
    return True
        
    
def matches(word,pattern):
    
    if(len(word) == len(pattern)):
        i = 0
        while(i < len(pattern)):
            if( word[i] in vowel_list and pattern[i] == "V"):
               if pattern[i] == word[i]:
                return True
            elif(word[i] in cons_list and pattern[i] == "C"):
                if pattern[i] == word[i]:
                  return True
            elif( pattern[i] == "."):
                if(word[i] in vowel_list or word[i] in cons_list):
                    return True
            else:
                wrong_char = pattern[i]
                return False
            i+= 1
        print(wrong_char, "not allowed in patterns")
    return False
                
               
    
        

def search_for_words():
    total_matches = 0 
    pat = input("enter a pattern with . for unknown lowercase letters C for consonants and V for vowels > ")
    for word in wordlist:
        if (valid_pattern(pat) == True):
            if(matches(word,pat) == True):
                total_matches+= 1
                print(word)
    print(total_matches, " were matches found")
    global find_more
    find_more = input("more? (y or n): ")
  

def word_search_loop():
    global find_more
    while(find_more == "y"):
        search_for_words()
    print("bye")
        
        
def find_words():
    search_for_words()
    word_search_loop()
    
       
