#include <iostream>
#include<string>
using namespace std;

void main() {
	string num;
	int leSum, riSum;

	cin >> num;
	if (num.length() % 2 != 0) {
		cout << "�ڸ����� ¦���� �Է����ּ���." << '\n';
	}
	else {
		//���� ������ ���� ����
		leSum = 0;
		for (int i = 0; i < num.length() / 2; i++) {
			leSum += num[i];
		}
		riSum = 0;
		for (int j = num.length() / 2; j < num.length(); j++) {
			riSum += num[j];
		}

		//�� �� �� ��� ���
		if (leSum == riSum) {
			cout << "LUCKY" << '\n';
		}
		else {
			cout << "READY" << '\n';
		}
	}

}