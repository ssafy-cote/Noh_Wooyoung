n = int(input())
roads = list(map(int, input().split()))
gasPrice = list(map(int, input().split()))

result = 0
minPrice = gasPrice[0]

for i in range(n - 1):
    if gasPrice[i] < minPrice:
        minPrice = gasPrice[i]
    result += minPrice * roads[i]
print(result)
