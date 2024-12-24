'''
Loop examples
'''
words = "this is a short sentence".split()

for w in words:
    if len(w) >=4:
        print(w)

for i in range(len(words)):
    w = words[i]
    if len(w) >=4:
        print(w)

i = 0
while i<len(words):
    w = words[i]
    if len(w)>=4:
        print(w)
    i = i+1
