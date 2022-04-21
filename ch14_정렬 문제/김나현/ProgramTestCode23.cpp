#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

/* Ǭ ���� �� ���� ����*/
/*  1. �л� ���� �ִ�� �����°� ū ���ڰ� �� �л� �� ������ ������ ���� > ���� ��� �ʿ�
    2. ���� �����̶� �̸����� ���͸� ����� ��. �ڵ尡 ������������ ���ϱ� �������. sort�� ����ؼ� ���Ϸ���
	�ϴٺ��� ����ü �������� ���Ϳ� ���� ���� ���� �� ����.
	3. ���ͷ� �Է� �޾ƿ��� �� ���� �Ϸ�. ������ �� �Լ� ����.
	4. compare �Լ��� �� �л��� ���ؼ� ����

	> �� ������ �迭�� �̿��ؼ� 3���� �迭�� �ϱ⿣ �л� ���� ������ �ʹ� ŭ. ���� ���͸� ����ϴ� ����.
	������ ���� �Ϸ��� algorithm���� �����ϴ� sort �Լ��� ���͸� ���ϸ� ���� �� ����.
	���ϴ� �Լ��� �پ��� ������� �� ����. �ؿ� ���� �� ��� �ܿ� �ٸ� ����� ���� �͵� �ּ����� �߰���.
*/

//����ü ���·� �л��� �������� ����
struct score
{
	int kor, eng, math;
	string name;
};

bool compare(score a, score b) {
	if (a.kor == b.kor) {
		if (a.eng == b.eng) {
			if (a.math == b.math) {
				return a.name < b.name; //���� �� �����ϴ� ������ ����
			}
			else return a.math > b.math; //���� ������ �����ϴ� ������ ����
		}
		else return a.eng < b.eng; //���� ������ �����ϴ� ������ ����
	}
	else {
		return a.kor > b.kor; //���� ������ �����ϴ� ������ ����
	}

	/* �̷��� �ڿ������� ���ϴ� ��ĵ� �ִ�. �����ؼ� ��������� ÷��
	if (a.kor == b.kor && a.eng == b.eng && a.math == b.math) return a.name < b.name;
	if (a.kor == b.kor && a.eng == b.eng) return a.math > b.math;
	if (a.kor == b.kor) return a.eng < b.eng;
	return a.kor > b.kor;
	*/
}

int main() {
	int N;
	cin >> N;

	vector<score> arr(N);
	for (int i = 0; i < N; i++) {
		cin >> arr[i].name >> arr[i].kor >> arr[i].eng >> arr[i].math;
	}
	sort(arr.begin(), arr.end(), compare); //sort(ù��°�ּ�, �������ּ�, ��������)
	//ù��°�ּ��� ������ ������ �ּ��� �������� ������ ���·� ������ �Լ��� ���� �����ض�

	for (int j = 0; j < N; j++) {
		cout << arr[j].name << '\n';
	}
}