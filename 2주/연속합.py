"""
누적합 배열 생성
시작 인덱스, 끝 인덱스 브루트포스
끝 - 시작 = 시작~끝까지 연속합
반복하면서 최댓값 구하기
"""

"""
시간 초과 

n = int(input())
numbers = list(map(int,input().split()))

sum = 0

board = []
for i in range(n):
    sum += numbers[i]
    board.append(sum)
# print(board)

result = max(board)

for start in range(n-1): #0~n-2
    for end in range(start+1,n): #1~n-1
        if(board[end] - board[start] > result):
            # print("start :",start,"end :",end )
            result = board[end] - board[start]
print(result)
"""


n = int(input())
numbers = list(map(int,input().split()))

for i in range(1,n):
    numbers[i] = max(numbers[i], numbers[i-1] + numbers[i])

print(max(numbers))