from sys import stdin
n, m = map(int, input().split())
li = list(map(int, stdin.readline().rstrip().split()))

# print(li)
cnt = 0
for i in range(n):
    for j in range(i, n):
        if(li[i] != li[j]):
            cnt += 1

print(cnt)
