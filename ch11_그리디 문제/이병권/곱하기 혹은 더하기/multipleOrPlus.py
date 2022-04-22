n = list(map(int, list(input())))
# print(n)

total = 0
for x in n:
    if x == 0 or x == 1 or total == 0:
        total = total + x  # 0일때는
    else:
        total = max(total + x, total * x)  # 만약 123 이 있다면 1*2보다 1+2가 더 큼

print(total)
