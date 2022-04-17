#include <algorithm>
#include <cmath>
#include <iostream>
#include <vector>
using namespace std;

struct Pos
{
	int x, y;
};
int N, M;
int MIN = 987654321; // ����� ������ ġŲ �Ÿ� �ּڰ�
bool selected[13];
vector<Pos> house_pos;
vector<Pos> chicken_pos;
vector<Pos> picked;

int Distance(Pos a, Pos b)
{
	return abs(a.x - b.x) + abs(a.y - b.y);
}

void Find_Min_Dist()
{
	int result = 0;
	for (int i = 0; i < house_pos.size(); i++) // �� �����κ���
	{
		int min_dist = 987654321;
		for (int j = 0; j < picked.size(); j++) // ��� �� ġŲ���� ����
		{
			min_dist = min(min_dist, Distance(house_pos[i], picked[j])); // �ּ� ġŲ�Ÿ� ã��
		}
		result += min_dist; // �ּ� ������ ġŲ�Ÿ� ����
	}
	MIN = min(MIN, result);
}

void Find_M_Combination(int x, int m)
{
	if (m == M)
	{ // M�� �� ������� �� �����κ��� ������ ġŲ�Ÿ��� �ּ��� ġŲ�� ã��
		Find_Min_Dist();
	}

	// ġŲ�� M�� ����
	for (int i = x; i < chicken_pos.size(); i++)
	{
		if (selected[i] == true)
			continue; // �̹� Ȯ���ȰŸ� �н�

		selected[i] = true;
		picked.push_back({ chicken_pos[i].x, chicken_pos[i].y });
		Find_M_Combination(i, m + 1);
		selected[i] = false;
		picked.pop_back();
	}
}

int main()
{
	// �Է�
	cin >> N >> M;
	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < N; j++)
		{
			int tmp;
			cin >> tmp;
			if (tmp == 1)
				house_pos.push_back({ i, j });
			else if (tmp == 2)
				chicken_pos.push_back({ i, j });
		}
	}
	Find_M_Combination(0, 0);
	cout << MIN << endl;
	return 0;
}