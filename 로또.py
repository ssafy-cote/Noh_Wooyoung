"""
kC6 조합 모두 구하기, 중복 없이

input
7 1 2 3 4 5 6 7     첫 숫자 - k(6이상), 나머지는 S의 숫자들

output
1 2 3 4 5 6
1 2 3 4 5 7
1 2 3 4 6 7
1 2 3 5 6 7
1 2 4 5 6 7
1 3 4 5 6 7
2 3 4 5 6 7

44ms
"""



def Recursive(cnt,start):
    if(cnt == 6): #숫자 6개 채웠으면 출력하고 리턴
        print(" ".join(map(str, result)))
        return
    
    for i in range(start,len(S)):
        result[cnt] = S[i]
        Recursive(cnt+1,i+1)


while(1):
    S = list(map(int, input().split()))
    if(S == [0]): #입력이 0들어오기 전까지 반복
        breakpoint

    k = S[0] #들어온 입력의 첫 번쨰 숫자를 k로 사용
    S = S[1:] #인덱스 1~끝까지를 떼어내어 가능한 숫자 목록으로 사용
    result = [0] * 6
    

    Recursive(0,0)
    print("")








