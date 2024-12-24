'''
this program plays the game NIM against a user
'''
import random
nim_state = {'a':10, 'b':10, 'c':10}

def play_nim(): #main function that contains for the execution of the game
    print("Let's play NIM!")
    print("NIM_State {a:10 b:10 c:10")
    winner = ""
    print("")
    while nim_state['a'] != 0 or nim_state['b'] != 0 or nim_state['c'] !=0:
        user_move()
        print("")
        if nim_state['a'] != 0 or nim_state['b'] != 0 or nim_state['c'] !=0:
            computer_move()
        else:
            print("You lose. Computer wins!")
            winner = "computer"
    if winner != "computer":
        print("You win! Computer loses.")


def user_move(): #changes nim based on player move
    print("")
    move = input("your move: ")
    num_remove = move.split()
    print("removing", num_remove[1],"from", num_remove[0], "gives")
    new_nim(num_remove[0],int(num_remove[1]))

def new_nim(letter,value): #subtracts the move from the nim and produces a new nim
    old_nim = nim_state[letter]
    nim_state[letter] = old_nim - value
    print("NIM State {a:", nim_state["a"], ", b:", nim_state["b"],
          ", c:", nim_state["c"], "}")

def computer_move(): #changes nim based on computer move
    choices = ['a','b','c']
    computer = random.choice(choices)
    while nim_state[computer] == 0:
        computer = random.choice(choices)
    num = random.randint(1, nim_state[computer])
    print("computer move: ", computer, num)
    print("removing", num, "from", computer, "gives")
    new_nim(computer, num)

play_nim()

    
    
