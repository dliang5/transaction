import random
with open("data.csv", 'w') as file:
    names = ['Anonymous_Billy', 'Black_Sheep', 'Froggy', 'Bruh', 'Random', 'Hello']
    months = ['01','02','03']
    year = 2019
    day = list(range(10, 28))
    amount = list(range(50, 1000))

    for i in range(100):
        monthIndex = 0
        if i < 30:
            monthIndex = 0
        elif i >= 30 and i < 70:
            monthIndex = 1
        else:
            monthIndex = 2

        date = "{}-{}-{}".format(year, months[monthIndex], day[random.randrange(len(day))])
        file.write("{},{},{},{}\n".format(
            names[random.randrange(len(names))], 
            i,
            amount[random.randrange(len(amount))], 
            date))
            
with open("data.csv", 'r') as file, open("query.txt", 'w') as wfile:
    command = "insert into transactions (user_id, transaction_id, transaction_amount, transaction_date) values "
    for line in file:
        a = line.strip().split(',')
        entry = "('{}', {}, {}, '{}'),".format(a[0], a[1], a[2], a[3])
        print(entry)
        command += entry
    
    command = command[:-1]
    wfile.write(command)
