#include <string>
#include <vector>
using namespace std;

int solution(string n) {   //���ڿ��� n���� ����
	int len = n.size();  //���ڿ� ���̸� len�� ����
	int answer = len;    //������ ���ڿ� ���̷� �ʱ� ����

	int num = len / 2;   //������ ������ ���ڿ� ���� �ִ�1/2�� �ʿ�


	//i�� ������ �߶� ����
	for (int i = 1; i <= num; i++) {

		//i�� ������ �߶� �����ѵ� ��������� ���ڿ�
		string result = "";

		//�ڸ� ���ڿ� ����
		string str = n.substr(0, i);

		int cnt = 1;

		//�տ��� �ڸ� ���ڿ� ������ ������ �޺κ�(j�� ���ں���) ���ڿ��� �˻��Ѵ�.
		for (int j = i; j <= len; j += i) {
			//j�� ���� i�� ��ŭ�� ������ �߶���� ���ڿ��� ���� ��� cnt ����
			if (str == n.substr(j, i)) {
				cnt ++;
			}
			else {
				//�ٸ� ��� �� cnt�� 1�̸� result�� �״�� ss�� ���δ�.
				if (cnt == 1) {
					result += str;
				}
				else {
					//cnt�� 1���� ũ�ٸ� �� ���ڿ��� �ϳ��� �ƴ϶�� ���̴�
					//cnt�� ���� ������ ���ڿ��� �ٿ��� result�� ����
					result += (to_string(cnt) + str);
				}

				//���ڿ� ������ j������ i���� ���� 
				str = n.substr(j, i);
				//cnt�� �ٽ� 1�� �ʱ�ȭ
				cnt = 1;
			}

		}

		//���ڿ��� i�� ������ �������� �ʴ´ٸ� result�� ������ �κ��� ���δ�.
		if ((len%i) != 0) {
			result += n.substr((len / i)*i);
		}

		//�ּڰ��� answer�� ����
		if (answer > result.size()) answer = result.size(); 
		//ó�� answer�� �� ���̸� �־����� ���� ���� ������ �̷������ answer�� ���� ����� ������ ���� �� ����.
	}


	return answer;
}
