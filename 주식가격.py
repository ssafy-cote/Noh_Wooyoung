"""
answer배열 input길이만큼 0으로 초기화하여 생성 [0,0,0,0....]

스택에 [가격,인덱스] 쌍으로 저장
ex) 1,2,3 시점에 스택 - [[1,0], [2,1], [3,2]]

1. answer의 저장값을 스택에 들어있는 쌍의 인덱스(위의 경우 0,1,2)에 따라 1씩 증가

2. 스택이 비어있지 않고, 이번에 넣는 숫자(current)가 스택의 top보다 작다면 계속 pop

3. pop끝났으면 [current,index]를 스택에 push
"""
def solution(prices):
    n = len(prices)
    stack = [[prices[0],0]]

    answer = [0] * n


    for i in range(1,n):
        current = prices[i]

        #현재 스택에 들어있는 값들의 인덱스 +1
        for s in stack:
            answer[s[1]] += 1

        #현재값이 스택의 top보다 작으면 pop
        while(len(stack) != 0  and stack[len(stack)-1][0] > current):
            stack.pop()
            
        stack.append([current, i])

    return answer
