"""
N 킬로그램 배달
봉지 - 3,5키로 존재
최대한 적은 봉지수
첫째줄에 N
N킬로 만들수 있으면 숫자, 만들 수 없으면 -1
"""

n = int(input())
i = 0
five_mok = n//5 #5로 나눈 몫
result = -1 #아래 반복문에서 안바뀌면 5,3으로 만들 수 없음

#5 개수 많을때가 최소 봉지수 -> 5개수 줄여가면서 3으로 나눠 떨어지는지 확인
for i in range(five_mok,-1,-1):
    cnt = 0
    cnt += i #5봉지 개수
    remains = n - 5*i #전체에서 5봉지 빼고 남은 나머지

    if(remains%3 == 0):  #3으로 나눠지면
        cnt += remains // 3
        result = cnt #결과로 사용
        break
print(result)

