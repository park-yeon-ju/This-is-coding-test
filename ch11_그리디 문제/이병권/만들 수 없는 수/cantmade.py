from sys import stdin

n = int(input())
li = sorted(list(map(int, stdin.readline().split())))

# print(li)
result = 1
# print(li)
for x in li:
    print(f"result = {result}, x= {x}")
    if(result < x):
        break

    result += x

print(result)

# N-1까지 존재할 때 N을 만들 수 있으려면 x가 N이 되어야 만들 수 있다.

# 따라서 result를 증가시켜 가면서 만약 result 가 x 보다 크다면 그 전까지는 다 만들 수 있는 수기 때문에

# x보다 작아질때를 찾으면 그 상황에서 멈춰야 만들 수 없는 수가 된다.

# 생각보다 어려웠음.
# 화폐단위가 누적합 보다 클 경우, 그 사이에 갭이 존재한다는 뜻
