#include<iostream>
#include<vector>
#include<algorithm>
#include<string>
#include<queue>
#include<iostream>

using namespace std;

//DFS "스택" : 매번 최상단노드를 기준으로 하여 방문하지 않은 인접 노드가 있으면 그 인접 노드를 스택에 쌓으며 방문을 수행하는 것
//==>수행할 수 없을때까지 반복!

int N, M, K, X;
vector<vector<int>>map(300001);
bool visit[300001];

void bfs(int start){
    int dist = 0;
    queue<int> q;

    q.push(start);
    visit[start] = true;

    while(!q.empty()){
        int q_size = q.size();

        for(int i=0; i<q_size; i++){
            int cur=q.front();
            q.pop();

            for (int j = 0; j < map[cur].size(); j++) {
				int next = map[cur][j];
				if (visit[next])continue;
				visit[next] = true;
				q.push(next);
			}
        }

        dist++;

		if (dist == K && !q.empty()) {
			priority_queue<int, vector<int>, greater<int>>pq;
			while (!q.empty()) {
				pq.push(q.front());
				q.pop();
			}
			while (!pq.empty()) {
				cout << pq.top() << endl;
				pq.pop();
			}
			return;
		}
    }
    cout<<-1;
    return;
}

int main(){

    cin>>N>>M>>K>>X;

    int a, b;

    for(int i=0; i<M; i++){
        cin>>a>>b;
        map[a].push_back(b);
    }

    bfs(X);

    return 0;
}