#include <vector>
#include <algorithm>
using namespace std;

int solution(int n, vector<int> weak, vector<int> dist) {
	int answer = 1e9;
	int W = weak.size();

	// ������ ���� weak �迭 ����
	weak.resize(2 * W);
	for (int i = W; i < weak.size(); i++)
		weak[i] = weak[i - W] + n;

	sort(dist.begin(), dist.end()); // ���� ����� ���� ����

	do {
		for (int i = 0; i < W; i++) {
			int start = weak[i]; // �˻� ���� ����
			int finish = weak[i + W - 1]; // �˻� ���� ���� ����
			for (int j = 0; j < dist.size(); j++) {
				start += dist[j];
				if (start >= finish) { // ��� ���� �湮 �Ϸ� �� Ż��
					answer = min(answer, j + 1);
					break;
				}
				// ���� �˻� ���� ���� ���ϱ�
				// => �������� �湮�� �������� ū weak ���� �� ���� ���� ����
				int next = upper_bound(weak.begin(), weak.end(), start) - weak.begin();
				start = weak[next];
			}
		}
	} while (next_permutation(dist.begin(), dist.end())); // ��� ������ ���� Ž��

	if (answer == 1e9) return -1;

	return answer;
}