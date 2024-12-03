import re

list = []
def FilePath():
    try:
        f = open("data.txt", "r")
        extend_mul = False
        for x in f:
            if "don't()" in x:
                extend_mul = False
            elif "do()" in x:
                extend_mul = True
            
            if extend_mul:
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

print(sum(products))

