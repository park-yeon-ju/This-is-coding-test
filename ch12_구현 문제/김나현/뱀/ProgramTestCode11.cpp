#include <iostream> 
#include <vector> 
#include <string> 
#include <deque> 
using namespace std;

const int MAX = 100; 

typedef struct { 

	int y, x; 

}Dir; 

Dir moveDir[4] = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} }; //E S W N 

int N, K, L; 
bool visited[MAX][MAX]; 
bool apple[MAX][MAX];

int main(void) {

	ios_base::sync_with_stdio(0); 
	cin.tie(0); 
	cin >> N; 
	
	cin >> K; 
	for (int k = 0; k < K; k++) { 

		int y, x; 
		cin >> y >> x; 
		apple[y - 1][x - 1] = true; 
	} 
	
	cin >> L; 
	deque<pair<int, char>> turn; 
	for (int l = 0; l < L; l++) { 

		int X; 
		char C; 
		cin >> X >> C; 
		turn.push_back({ X, C }); 
	} 
	
	int sec = 0; 
	int idx = 0; //�ʱ� ������ 
	deque<pair<int, int>> snake; 
	snake.push_back({ 0, 0 }); //�ʱ� ��ġ 
	visited[0][0] = true;
	
	while (1) { 

		sec++; 
		pair<int, int> before = snake.back(); 
		pair<int, int> cur = { before.first + moveDir[idx].y, before.second + moveDir[idx].x }; 

		//���� �Ӹ��� ���� �ε����ų�, ������ ��� ���
		if (visited[cur.first][cur.second] || !(0 <= cur.first && cur.first < N && 0 <= cur.second && cur.second < N)) {
			cout << sec << "\n"; 
			break; 
		} 
		
		visited[cur.first][cur.second] = true; 
		snake.push_back(cur); 

		//����� �ִ� ��ġ�� ���� �״�� 
		if (apple[cur.first][cur.second]) apple[cur.first][cur.second] = false; //��� ������ ������ �ִ� ĭ�� ����� 
		else { 

			pair<int, int> tail = snake.front(); 
			visited[tail.first][tail.second] = false; 
			snake.pop_front(); 
		} 

		//�������� ���� ��ȯ 
		if (turn.size() && turn.front().first == sec) { 

			if (turn.front().second == 'L') idx = (idx + 3) % 4;
			else idx = (idx + 1) % 4; turn.pop_front(); 
		} 
	} 
	return 0; 
}
