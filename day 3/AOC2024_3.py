import re

list = []
def FilePath():
    try:
        f = open("C:\\Users\\nikla\\Dokument\\Advent Of Code 2024\\day 3\\data.txt", "r")
        for x in f:
            pattern = r"mul\(\d+,\d+\)"
            tempList = re.findall(pattern, x)
            list.extend(tempList)
        f.close()
    except:
        print("Check the path")

products = []
def calculate():
    for mul in list:
        m = re.match(r"mul\((\d+),(\d+)\)", mul)
        if m:
            nbr1, nbr2 = map(int, m.groups())
            products.append(nbr1 * nbr2)

FilePath()
calculate()

total = 0
for num in products:
    total += num
print(total)