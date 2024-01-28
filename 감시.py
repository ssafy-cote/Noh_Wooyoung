n,m = map(int,input().split())

dy = [-1,1,0,0]
dx = [0,0,-1,1]


room = []
for i in range(n):
    room.append(input().split())

for i in range(n):
    print(room[i])

#current == 현재 cctv 번호
for current in range(5,0,-1):
    for i in range(n):
        for j in range(m):
            pass 

# def cctv_5(y,x,room):
#     #상
#     upY = y
#     downY = y
#     upX = x
#     downX = x
#     while upY > 0 and room[upY][x] != '6':
#         upY = y - 1
#         if room[upY][x] == '0':
#             room[upY][x] = '#'
#     #하
#     while downY < n-1 and room[downY][x] != '6':
#         downY = y + 1
#         if room[downY][x] == '0':
#             room[downY][x] = '#'    
#     #좌
#     while upX > 0 and room[y][upX] != '6':
#         upX = x -1
#         if room[y][upX] == '0':
#             room[y][upX] = '#'
#     #우
#     while downX < n-1 and room[y][downX] != '6':
#         downX = x + 1
#         if room[y][downX] == '0':
#             room[y][downX] = '#' 
def cctv_5(y,x,room):
    for i in range(4):
        ny = y
        nx = x
        while ny < n-1 and ny > 0 and nx < m-1 and nx > 0 and room[ny][nx] != '6':
            ny = ny + dy[0]
            nx = nx + dx[0]
            if room[ny][nx] == '0':
                room[ny][nx] = '#'

def cctv_4(y,x,room):
    u,d = y,y
    l,r = x,x
    while(1):
        if u > 0 and room[u][x] != '6':
            