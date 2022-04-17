#include <vector>
#include <algorithm>

using namespace std;

bool board[101][101][2]; // x, y, type
int boardSize;

bool funcSet(int x, int y, int type) {
	// ��� �� ��
	if (type == 0) {
		// �ٴ� ���� �ְų�
		if (y == 0) return true;

		// ���� ������ �� ��
		if (x > 0 &&  board[x - 1][y][1])
			return true;

		// ���� ���� �� ��
		if (y < boardSize && board[x][y][1])
			return true;

		// �Ǵ� �ٸ� ��� ���� �־�� �մϴ�
		if (y > 0  &&  board[x][y - 1][0])
			return true;
	}

	// �� �϶�
	else {
		// ���� �� �κ��� ��� ���� �ְų�
		if (y > 0  && board[x][y - 1][0])
			return true;

		//������ �� �κ��� ��� ���� �ְų�
		if (x < boardSize && y > 0 && board[x + 1][y - 1][0])
			return true;

		//���� ���� �ٸ� ���� ��ų�
		if (x < 0 && x > boardSize && board[x - 1][y][1] && board[x + 1][y][1])
			return true;

	}
	//�� �� �ش� X
	return false;
}

bool funcRemove(int x, int y, int type) {
	board[x][y][type] = 0;

	if (type == 0) { // ��� ����
		// ���� ��� ���� ��, ��ġ ����?
		if (y < boardSize && board[x][y + 1][0] && !funcSet(x, y + 1, 0)) return false;

		// ���� �� ���� ��, ��ġ ����?
		if (y < boardSize && board[x][y + 1][1] && !funcSet(x, y + 1, 1)) return false;
		if (x > 0 && y < boardSize && board[x - 1][y + 1][1] && !funcSet(x - 1, y + 1, 1)) return false;
	}
	else {
		// ���� ��� ���� ��, ��ġ ����?
		if (board[x][y][0] && !funcSet(x, y, 0)) return false;
		if (x < boardSize && board[x + 1][y][0] && !funcSet(x + 1, y, 0)) return false;

		// �ٸ� ���� ����Ǿ� ���� ��, ��ġ ����?
		if (x > 0 && board[x - 1][y][1] && !funcSet(x - 1, y, 1)) return false;
		if (x < boardSize && board[x + 1][y][1] && !funcSet(x + 1, y, 1)) return false;
	}

	return true;
}

vector<vector<int>> solution(int n, vector<vector<int>> build_frame) {
	vector<vector<int>> answer;
	boardSize = n;

	for (int i = 0; i < build_frame.size(); i++) {
		// [x, y, a, b]
		// x,y�� ��ǥ
		// a = �������� ���� (0�� ���, 1�� ��)
		// b = �������� ��ġ���� �������� (0�� ����, 1�� ��ġ)
		int x, y, a, b;
		x = build_frame[i][0];
		y = build_frame[i][1];
		a = build_frame[i][2];
		b = build_frame[i][3];

		if(b == 0){  //����
			if (!funcRemove(x, y, a))  //�����̸�
				board[x][y][a] = 1;
		}
		else{ //��ġ
			if (funcSet(x, y, a))  //��ġ�̸�
				board[x][y][a] = 1;
		}
	}

	//���� answer
	for (int i = 0; i <= n; ++i) {
		for (int j = 0; j <= n; ++j) {
			if (board[i][j][0]) answer.push_back({ i, j, 0 }); //����� ��츦 ����
			if (board[i][j][1]) answer.push_back({ i, j, 1 });  //���� ��츦 ����
		}
	}

	return answer;
}