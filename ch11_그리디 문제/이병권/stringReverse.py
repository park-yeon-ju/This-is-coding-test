n = list(input())
# print(n)
for i in range(len(n)-1):
    if(n[i] == n[i+1]):
        n[i+1] = ''

print(min(n.count('0'), n.count('1')))
