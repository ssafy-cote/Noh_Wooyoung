"""
절반 길이가 1될때까지 재귀 (2*2)
1,2,3,4 네 개로 나눠 생각

ex) 
2*2에서 위치 0,1,2,3 존재

왼 위 - 1
우 위 - 2
왼 아래 - 3
우 아래 - 4

왼 위 = 0 + (0,1,2,3)
우 위 =  절반^2 + (0,1,2,3)
왼 아래 = 절반^2 * 2 + (0,1,2,3)
우 아래 = 절반^2 * 3 + (0,1,2,3)
"""

def Z(n, y, x):
    if n == 0:
        return 0
    half = 2 ** (n - 1)
    
    if y < half and x < half:
        return Z(n - 1, y, x)
    elif y < half and x >= half:
        return half * half + Z(n - 1, y, x - half)
    elif y >= half and x < half:
        return 2 * half * half + Z(n - 1, y - half, x)
    elif y >= half and x >= half:
        return 3 * half * half + Z(n - 1, y - half, x - half)

n,y,x = map(int,input().split())

result = Z(n,y,x)
print(result)
    