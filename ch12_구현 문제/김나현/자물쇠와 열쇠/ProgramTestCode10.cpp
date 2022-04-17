#include <vector>
using namespace std;

int N, M;  //���� ũ�� N:�ڹ��� ����/ M:���� ����
vector<vector<int>> board; //�ΰ��� ���� ���ϱ� ���� ū �簢�� ����

// ��� ���� ���� üũ
bool check(vector<vector<int>>& key, int y, int x) {
	bool ret = true;

	// �����ǿ� ���� �� ����
	for (int i = y; i < y + M; i++)
		for (int j = x; j < x + M; j++)
			board[i][j] += key[i - y][j - x];

	// �ڹ����� ��� ��ǥ Ȯ��
	for (int i = M; i < M + N; i++) {
		for (int j = M; j < M + N; j++) {
			if (board[i][j] != 1) {
				ret = false;
				break;
			}
		}
		if (!ret) break;
	}

	// �����ǿ� ���� �� ����
	for (int i = y; i < y + M; i++)
		for (int j = x; j < x + M; j++)
			board[i][j] -= key[i - y][j - x];

	return ret;
}

// ���� �ð���� ȸ��
void rotate(vector<vector<int>>& key) {
	vector<vector<int>> temp(M, vector<int>(M));

	for (int i = 0; i < M; i++)
		for (int j = 0; j < M; j++)
			temp[i][j] = key[j][M - i - 1];

	for (int i = 0; i < M; i++)
		for (int j = 0; j < M; j++)
			key[i][j] = temp[i][j];
}

bool solution(vector<vector<int>> key, vector<vector<int>> lock) {
	bool answer = false;

	M = key.size();
	N = lock.size();

	board = vector<vector<int>>(2 * M + N, vector<int>(2 * M + N)); //���� ū �簢���� ũ�⸦ key�� lock ����� ����ؼ� ����

	// �����ǿ� �¹��� �Է�
	for (int i = M; i < M + N; i++)
		for (int j = M; j < M + N; j++)
			board[i][j] = lock[i - M][j - M];

	// �������� ��� ��ǥ���� 4���⿡ ���� ����Ž��
	for (int i = 0; i < N + M; i++) {
		for (int j = 0; j < N + M; j++) {
			for (int k = 0; k < 4; k++) { //4����
				rotate(key);  //���踦 ������ �Լ� �ҷ���
				if (check(key, i, j)) {
					answer = true;
					break;
				}
			}
			if (answer) break;
		}
		if (answer) break;
	}

	return answer;
}