import re

sum = 0

f = open("data.txt").read()
regex = re.findall("mul\(\d+,\d+\)|don't\(\)|do\(\)", f)
extend_mul = True
for x in regex:
    pattern = re.findall(r'\D+|\d+', x)
    if len(pattern) == 1:
        if pattern[0] == "don't()":
            extend_mul = False
        elif pattern[0] == "do()":
            extend_mul = True
    
    if extend_mul:
        tmp_sum = 1
        for num in pattern:
            if num.isdigit():
                tmp_sum *= int(num)
        if tmp_sum != 1:
            sum += tmp_sum

print(sum)