
def filter_long_words(words,n):
    answer = []
    a = words.split("")
    for w in a:
        if len(w) >= n:
            answer.append(w)
    return(answer)
    