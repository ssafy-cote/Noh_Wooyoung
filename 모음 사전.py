"""
총 개수 = 5 + 5**1 + 5**2 + 5**3 + 5**4 + 5**5 = 3910 -> 완탐 할만한 개수
"""

def solution(word):
    word = list(word)
    aeiou = ['A','E','I','O','U']
    words = []
    #길이 1 문자열
    for a in range(5):
        words.append(list(aeiou[a]))
    #길이 2 문자열
    for a in range(5):
        for b in range(5):
            words.append(list(aeiou[a] + aeiou[b]))
    #길이 3 문자열
    for a in range(5):
        for b in range(5):
            for c in range(5):
                words.append(list(aeiou[a] + aeiou[b] + aeiou[c]))
    #길이 4 문자열
    for a in range(5):
        for b in range(5):
            for c in range(5):
                for d in range(5):
                    words.append(list(aeiou[a] + aeiou[b] + aeiou[c] + aeiou[d]))
    #길이 5 문자열
    for a in range(5):
        for b in range(5):
            for c in range(5):
                for d in range(5):
                    for e in range(5):
                        words.append(list(aeiou[a] + aeiou[b] + aeiou[c] + aeiou[d] + aeiou[e]))

    answer = 0
    words.sort()

    for i in range(len(words)):
        if words[i] == word:
            answer = i+1 #인덱스는 0부터니까 1 더한게 결과
            break;

    return answer