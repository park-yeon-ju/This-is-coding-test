#include <iostream>
#include <queue>
#include <algorithm>
 #include <vector>

using namespace std;

// int N, M;
// vector<vector<int>>map(N*M);
// bool virus_available[N*M];
 
// int dx[] = {-1,1,0,0};
// int dy[] = {0,0,-1,1};
// int n,m;
// int c=0;
// int map[8][8];
 
int map[8][8];
int origin[8][8];
int visit[8][8];
vector<pair<int,int>>zeros;
vector<int>temp;//조합을 위한것, 전체에서 3개를 1로만들기
int m, n;
int ans;
int dx[4] = { -1,1,0,0 };
int dy[4] = { 0,0,-1,1 };

void bfs(int i, int j){
    queue<pair<int, int>>q;
    q.push(make_pair(i, j));
    visit[i][j]=true;

    while(!q.empty()){
        int x = q.front().first;
        int y = q.front().second;
        q.pop();
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(-1<nx && nx<m && -1<ny && ny<n && !visit[nx][ny] && map[nx][ny]==0){
                q.push(make_pair(nx,ny));
                map[nx][ny] = 2;
                visit[nx][ny] = true; //빈방 바이러스가 퍼진 방으로 바꿔주기
            }
        }
    }
    return;
}

int spread(vector<int>temp){
    int cnt=0;

    //3개의 벽 세우기
    for(int i=0; i<temp.size(); i++){
        if(temp[i] == 1) {
            int x = zeros[i].first;
            int y = zeros[i].second;
            map[x][y] = 1;
        }
    }

    //맨처음 바이러스가 있던 자리를 찾아 bfs로 바이러스 퍼뜨린다.
    for(int i=0; i<m; i++){
        for(int j=0; j<n; j++){
            if(map[i][j] == 2 && !visit[i][j]) {
                bfs(i, j);
            }
        }
    }

    //안전지대 카운트한 후 리턴(0의 갯수)
    for(int i=0; i<m; i++){
        for(int j=0; j<n; j++){
            if(map[i][j] == 0){
                cnt++;
            }
        }
    }

    return cnt;
}

int main(){

    cin >> m >> n;

	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) {
			cin >>origin[i][j];
			map[i][j] = origin[i][j];
			if (origin[i][j] == 0) {
				zeros.push_back(make_pair(i, j));//0인애들 위치저장
			}
		}
	}


	for (int i = 0; i < zeros.size()-3; i++)
		temp.push_back(0);
	for (int i = 0; i < 3; i++)
		temp.push_back(1);

	do {
		int result = spread(temp);
		//퍼뜨린 결과로 답 수정
		ans = max(result, ans);
		//되돌리기(방문체크랑 map고치기)
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = origin[i][j];
				visit[i][j] = false;
			}
		}
	} while (next_permutation(temp.begin(), temp.end()));

	cout << ans;
	return 0;
}