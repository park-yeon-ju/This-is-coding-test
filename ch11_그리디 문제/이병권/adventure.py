# 오름차순으로 접근해서 공포도가 낮은 얘들부터 카운트 하는 방식으로 접근

from sys import stdin
n = int(input())

li = sorted(list(map(int, stdin.readline().split())))

result = 0  # 편성이 완료된 그룹
groupCount = 0  # 지금 만드는중인 그룹 안에 속해있는 인원
for i in li:
    groupCount += 1  # 처음 i가 들어가면 그룹안에 1명 추가됨.
    if groupCount >= i:  # 만약에 그룹의 인원이 현재 들어온 공포도보다 크거나 같으면
        groupCount = 0  # 편성이 완료되었으니 카운트 0으로 초기화
        result += 1  # 편성완료된 그룹 1 증가

print(result)
