"""
랭킹 리스트 앞부터가 1등
같은 점수일경우 가장 높은 등수
리스트 점수 개수 P
리스트에 있는 점수 N개 역오름차순
 10 <= P <= 50 / 0 <= N <= P

삽입정렬?

N, 새 점수, P

길이가 p일 경우 배열 초기 상태의 마지막 원소와 새로 넣는 숫자가 같으면 -1

배열 내에 새로 넣는 숫자와 같은 숫자가 있는지 확인

있으면 그 원소가 마지막 원소와 같은지 확인
    있으면 -1
없으면 배열에 새로운 숫자 넣은 뒤 다시 역정렬
배열에서 들어간 숫자가 몇 번째 자리인지 확인

"""

# N, newScore, P = map(int, input().split())
# cnt = 0

# if N == 0:
#     cnt = 0
# else:
#     scores = list(map(int,input().split()))
# #등수표 마지막 자리가 넣는 점수와 같은지 확인
#     if scores[-1] == newScore: 
#         cnt = -1; #있으면 -1이 정답
#     else: #없으면
#         scores.append(newScore)
#         scores.sort(reverse=True)
#         for i in range(P):
#             if scores[i] == newScore:
#                 cnt = i + 1
#                 break;
#             else:
#                 cnt = -1

# print(cnt)

#등수표가 다 안채워져 있으면

N, newScore, P = map(int, input().split())
cnt = 0
if N > 0:
    scores = list(map(int,input().split()))
    if scores[-1] >= newScore and len(scores) == P:
        cnt = -1
    else:
        scores.append(newScore)
        scores.sort(reverse=True)
        if newScore in scores:
            if scores.index(newScore) < P:
                cnt = scores.index(newScore) + 1
            else:
                cnt = -1
        else:
            cnt = -1
else:
    cnt = 1
print(cnt)
