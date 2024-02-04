"""
상 - 다음 알파벳
하 - 이전 알파벳
좌 - [0]에서 누르면 마지막 인덱스로 이동
우 - [N]에서 누르면 첫 인덱스로 이동

1. 오른쪽으로 쭉
2. 왼쪽으로 쭉  (1==2)
3. 오른쪽 갔다 왼쪽
4. 왼쪽 갔다 오른쪽
->경우의 수 3개
"""
name = list(input())

num = [] #아스키 코드로 변환한 name배열
cnt = 0

# 아스키 코드로 변환
for c in name:
    num.append(ord(c) - 65)

# 알파벳 중간 이상(14~26)은 내리는게 더 좋음 -> 26 - num[i]로 변경
for i in range(0, len(num)):
    if num[i] > 13:
        num[i] = 26 - num[i]

#가장 긴 A의 왼쪽, 오른쪽 인덱스 구하기
A_left,A_right = 0,0
A_cnt = 0
for l in range(0,len(name)):
    tempCnt = 0
    for r in range(l,len(name)):
        if num[r] == 0:
            tempCnt += 1
            if tempCnt >= A_cnt:
                A_cnt = tempCnt
                A_left = l
                A_right = r
        else:
            break;

leftNum = A_left #가장 긴 A문자열 기준 왼쪽의 문자 개수
rightNum = len(num) - 1 - A_right #오른쪽의 문자 개수

#0 없으면 그냥 쭉
if 0 not in num:
    cnt = sum(num) + len(num) - 1
#있으면
elif A_left-1 <= len(num)-1 - A_right: #왼쪽이 더 짧으면
    cnt = sum(num) + (leftNum-1)*2 + rightNum
else: #오른쪽이 더 짧으면
    cnt = sum(num) + leftNum + rightNum*2 -1
print("leftNum : ",leftNum, "rightNum : ",rightNum)
print(cnt)



# def solution(name):
#     name = list(name)

#     num = [] #아스키 코드로 변환한 name배열
#     cnt = 0

#     # 아스키 코드로 변환
#     for c in name:
#         num.append(ord(c) - 65)

#     # 알파벳 중간 이상(14~26)은 내리는게 더 좋음 -> 26 - num[i]로 변경
#     for i in range(0, len(num)):
#         if num[i] > 13:
#             num[i] = 26 - num[i]

#     #가장 긴 A의 왼쪽, 오른쪽 인덱스 구하기
#     A_left,A_right = 0,0
#     A_cnt = 0
#     for l in range(0,len(name)):
#         tempCnt = 0
#         for r in range(l,len(name)):
#             if num[r] == 0:
#                 tempCnt += 1
#                 if tempCnt >= A_cnt:
#                     A_cnt = tempCnt
#                     A_left = l
#                     A_right = r
#             else:
#                 break;

#     leftNum = A_left #가장 긴 A문자열 기준 왼쪽의 문자 개수
#     rightNum = len(num) - 1 - A_right #오른쪽의 문자 개수

#     #0 없으면 그냥 쭉
#     if 0 not in num:
#         cnt = sum(num) + len(num) - 1
#     #있으면
#     elif A_left-1 <= len(num)-1 - A_right: #왼쪽이 더 짧으면
#         cnt = sum(num) + (leftNum-1)*2 + rightNum
#     else: #오른쪽이 더 짧으면
#         cnt = sum(num) + leftNum + rightNum*2 -1
#     return cnt



