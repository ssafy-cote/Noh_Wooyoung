"""
정수 n 입력 -> 삼각형의 밑변, 높이

높이 마다 1 + 2 + 3 + 4 + ....  -> 총 갯수 (count로 설정해서 사용)
ㅇ
ㅇㅇ
ㅇㅇㅇ
ㅇㅇㅇㅇ ... 직각삼각배열 생성

움직이는 방향 아래, 오른쪽, 좌상향대각 3종류
n 작아질때마다 방향 바꾸기
아래 - (+1,0) 오른쪽 - (0,+1) 좌상향대각(-1,-1)

n 만큼 이동

count == 총합 되면 반복 종료
"""

N = int(input())

snail = []
total = 0

#달팽이 생성
for i in range(1,N+1):
    snail.append([0]*i)
    total += i

#이동 방향 결정
flag = 0

x,y = 0,-1
snail[y][x] = 1
count = 0


for i in range(N+1,0,-1):
    #아래
    if(flag % 3 == 0):
        dy = 1
        dx = 0
        for j in range(1,i):
            count += 1
            x = x + dx
            y = y + dy
            snail[y][x] = count
    #오른쪽
    elif(flag%3 == 1):
        dy = 0
        dx = 1
        for j in range(1,i):
            count += 1
            x = x + dx
            y = y + dy
            snail[y][x] = count
    #왼쪽위
    else:
        dy = -1
        dx = -1
        for j in range(1,i):
            count += 1
            x = x + dx
            y = y + dy
            snail[y][x] = count
    flag += 1

answer = []

for i in range(N):
    for num in snail[i]:
        answer.append(num)
print(answer)
