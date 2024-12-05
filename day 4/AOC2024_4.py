import re

def count(grid, words):
    count = 0
    for row in grid:
        for word in words:
            count += len(re.findall(word, row))
    
    for col in range(len(grid[0])): 
        column = ''.join([row[col] for row in grid])
        for word in words:
            count += len(re.findall(word, column))

    for r in range(len(grid)):
        for c in range(len(grid[0])):
            diag = ''
            for i in range(min(len(grid) - r, len(grid[0]) - c)):
                diag += grid[r + i][c + i]
            for word in words:
                count += len(re.findall(word, diag))
            
            diag = ''
            for i in range(min(len(grid) - r, c + 1)):
                diag += grid[r + i][c - i]
            for word in words:
                count += len(re.findall(word, diag))
    
    return count
            
def readFile_ToGrid(filepath):
    with open(filepath, 'r') as f:
        lines = [line.strip() for line in f.readlines()]
    return lines

filepath = "data.txt"

word = ["XMAS", "SAMX"]
grid = readFile_ToGrid(filepath)


print(count(grid, word))

