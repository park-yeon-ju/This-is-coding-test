#include <vector>
#include <algorithm>

using namespace std;

bool board[101][101][2]; // x, y, type
int boardSize;

bool funcSet(int x, int y, int type) {
	// 기둥 일 때
	if (type == 0) {
		// 바닥 위에 있거나
		if (y == 0) return true;

		// 보의 오른쪽 끝 위
		if (x > 0 &&  board[x - 1][y][1])
			return true;

		// 보의 왼쪽 끝 위
		if (y < boardSize && board[x][y][1])
			return true;

		// 또는 다른 기둥 위에 있어야 합니다
		if (y > 0  &&  board[x][y - 1][0])
			return true;
	}

	// 보 일때
	else {
		// 왼쪽 끝 부분이 기둥 위에 있거나
		if (y > 0  && board[x][y - 1][0])
			return true;

		//오른쪽 끝 부분이 기둥 위에 있거나
		if (x < boardSize && y > 0 && board[x + 1][y - 1][0])
			return true;

		//양쪽 끝이 다른 보에 닿거나
		if (x < 0 && x > boardSize && board[x - 1][y][1] && board[x + 1][y][1])
			return true;

	}
	//둘 다 해당 X
	return false;
}

bool funcRemove(int x, int y, int type) {
	board[x][y][type] = 0;

	if (type == 0) { // 기둥 삭제
		// 위에 기둥 있을 때, 설치 가능?
		if (y < boardSize && board[x][y + 1][0] && !funcSet(x, y + 1, 0)) return false;

		// 위에 보 있을 때, 설치 가능?
		if (y < boardSize && board[x][y + 1][1] && !funcSet(x, y + 1, 1)) return false;
		if (x > 0 && y < boardSize && board[x - 1][y + 1][1] && !funcSet(x - 1, y + 1, 1)) return false;
	}
	else {
		// 위에 기둥 있을 때, 설치 가능?
		if (board[x][y][0] && !funcSet(x, y, 0)) return false;
		if (x < boardSize && board[x + 1][y][0] && !funcSet(x + 1, y, 0)) return false;

		// 다른 보와 연결되어 있을 때, 설치 가능?
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
		// x,y는 좌표
		// a = 구조물의 종류 (0은 기둥, 1은 보)
		// b = 구조물을 설치할지 삭제할지 (0은 삭제, 1은 설치)
		int x, y, a, b;
		x = build_frame[i][0];
		y = build_frame[i][1];
		a = build_frame[i][2];
		b = build_frame[i][3];

		if(b == 0){  //삭제
			if (!funcRemove(x, y, a))  //삭제이면
				board[x][y][a] = 1;
		}
		else{ //설치
			if (funcSet(x, y, a))  //설치이면
				board[x][y][a] = 1;
		}
	}

	//최종 answer
	for (int i = 0; i <= n; ++i) {
		for (int j = 0; j <= n; ++j) {
			if (board[i][j][0]) answer.push_back({ i, j, 0 }); //기둥의 경우를 넣음
			if (board[i][j][1]) answer.push_back({ i, j, 1 });  //보의 경우를 넣음
		}
	}

	return answer;
}