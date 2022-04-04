n = list(input())
# print(n)
cnt = 0
for i in range(len(n)-1):
    if(n[i] != n[i+1]):
        cnt += 1

print((cnt + 1) // 2)

# 0001100
# 010 으로 생각
# 길이가 3일 때 => 1번만 뒤집으면 됨
# 길이가 4일 때 => 0101 > 2번
# 따라서 규칙이 존재.
