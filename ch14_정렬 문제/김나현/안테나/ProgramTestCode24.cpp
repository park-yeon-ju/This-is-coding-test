#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

/* 
  �߰��� ���ϴ� ����.
  �߰������� �־��� ���� ���� Ŀ���ٴ� ���� �� �� ����.
  �̷� ����� �������� �⺻ ������ ���� ������. �ܿ����� ���� ���� �� ��.
 */

int main() {
	//�ٸ� ��� �ڵ� ������ ���� �ð� ���� �ִ��� �ϱ� ���ؼ� �Ʒ��ڵ嵵 �߰���.
	//ios_base::sync_with_stdio(false);
	//cin.tie(NULL);
	//cout.tie(NULL);

	int N;
	cin >> N;
	
	vector<int>house(N);
	for (int i = 0; i < N; i++) cin >> house[i];

	sort(house.begin(), house.end());

	cout << house[(N - 1) / 2];
}