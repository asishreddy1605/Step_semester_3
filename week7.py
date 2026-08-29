import random
stages=[
'''
  +---+
  |   |
  O   |
 /|\  |
 /    |
      |
=========
''',
'''
  +---+
  |   |
  O   |
 /|\  |
 /    |
      |
=========
''',
'''
+---+
  |   |
  O   |
 /|\  |
      |
      |
=========
''',
'''
  +---+
  |   |
  O   |
 /|   |
      |
      |
=========
''',
'''
  +---+
  |   |
  O   |
  |   |
      |
      |
=========
''',
'''
  +---+
  |   |
  O   |
      |
      |
      |
=========
''',
'''
  +---+
  |   |
      |
      |
      |
      |
=========
'''
]
words=["asish","hasika","amullu","ajay","krishnaveni"]
choosen_word=random.choice(words)
length=len(choosen_word)
line=""
for l in range(length):
    line+=" _ "
print("word to guss " + line)
game_over=False
correct_letter=[]
lifes=6
while not game_over:
    guss=input("guss the word ").lower()
    display=""
    for letter in choosen_word:
        if guss==letter:
            display+=letter
            if letter not in correct_letter:
                correct_letter.append(letter)
        elif letter in correct_letter:
            display+=letter
        else:
            display+="_"
    print(display)
    if guss not in choosen_word:
        lifes-=1
        if lifes==0:
            game_over=True
            print("============================== you loss! ==============================")
    if "_" not in display:
        game_over=True
        print("============================ you win! =========================")
    print(stages[lifes])
    