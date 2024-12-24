'''
here is rock, paper, scissors
'''
import math
import random
print("Let's play rock, paper, scissors!")
print('choose one of rock, paper, or scissors after the prompt')
player_response = input("user > ")
answers = ['rock','paper', 'scissors']
computer_response = random.choice(answers)
print("computer >", computer_response)
while(player_response == computer_response):
    print("Tie, let's play again")
    player_response = input("user > ")
    answers = ['rock','paper', 'scissors']
    computer_response = random.choice(answers)
    print("computer >", computer_response)

if(player_response == "rock" and computer_response == "paper"):
    print("computer wins!")
elif(player_response == "paper" and computer_response == "scissors"):
    print("computer wins!")
elif(player_response == "scissors" and computer_response == "rock"):
    print("computer wins!")
else:
    print("you won!!")

player_continue = input("continue? (y or n): ")
while(player_continue == "y"):
    print("Let's play rock, paper, scissors!")
    print('choose one of rock, paper, or scissors after the prompt')
    player_response = input("user > ")
    answers = ['rock','paper', 'scissors']
    computer_response = random.choice(answers)
    print("computer >", computer_response)
    while(player_response == computer_response):
        print("Tie, let's play again")
        player_response = input("user > ")
        answers = ['rock','paper', 'scissors']
        computer_response = random.choice(answers)
        print("computer >", computer_response)

    if(player_response == "rock" and computer_response == "paper"):
        print("computer wins!")
    elif(player_response == "paper" and computer_response == "scissors"):
        print("computer wins!")
    elif(player_response == "scissors" and computer_response == "rock"):
        print("computer wins!")
    else:
        print("you won!!")
    player_continue = input("continue? (y or n): ")

print("bye")

    
