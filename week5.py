import random
letters=['A','B','C','D','a','b','c','d']
symbols=['!','@','#','$','%']
numbers=['1','2','3','4','5','6','7','8','9']
print("Welome to the pypassword Generator!")
let=int(input("How many letters would you like in your password\n"))
sym=int(input("How many symbols would you like ?\n"))
num=int(input("How many numbers would ypo like?\n"))
passward_list=[]
for char in range(1,let+1):
    passward_list+=random.choice(letters)
for char in range(1,sym+1):
    passward_list+=random.choice(symbols)
for char in range(1,num+1):
    passward_list+=random.choice(numbers)
print(passward_list)
random.shuffle(passward_list)
print(passward_list)
passward=""
for char in passward_list:
    passward+=char
print(f"Your passward is{passward}")
    

