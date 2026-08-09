
import random
rock='''
   _______
---'   ____)
      (_____)
      (_____)
      (____)
---.__(___)
'''
paper='''
    _______
---'   ____)____
          ______)
          _______)
         _______)
---.__________)
'''
seccior='''
    _______
---'   ____)____
          ______)
       __________)
      (____)
---.__(___)
'''
images=[rock,paper,seccior]
your_choose=int(input("What do we choose ?Type 0 for rock,1 for paper and 2 for seccior\n"))
if your_choose>=0 and your_choose<3:
    print(images[your_choose])
computer_choose=random.randint(0,2)
print("computer choose")
print(images[computer_choose])
if your_choose>=3 and your_choose<0:
    print("Invalid")
elif your_choose==0 and computer_choose==2:
    print("You win")
elif computer_choose==0 and your_choose==2:
    print("You loose")
elif your_choose==0 and computer_choose==1:
    print("You loose")
elif your_choose==1 and computer_choose==0:
    print("You win")
elif your_choose==2 and computer_choose==1:
    print("You win")
elif your_choose==1 and computer_choose==2:
    print("You loose")
elif your_choose== computer_choose:
    print("Draw")


    