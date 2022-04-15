#include <iostream>
#include<string>
using namespace std;

void main() {
	string num;
	int leSum, riSum;

	cin >> num;
	if (num.length() % 2 != 0) {
		cout << "자릿수를 짝수로 입력해주세요." << '\n';
	}
	else {
		//왼쪽 오른쪽 합을 구함
		leSum = 0;
		for (int i = 0; i < num.length() / 2; i++) {
			leSum += num[i];
		}
		riSum = 0;
		for (int j = num.length() / 2; j < num.length(); j++) {
			riSum += num[j];
		}

		//합 비교 후 결과 출력
		if (leSum == riSum) {
			cout << "LUCKY" << '\n';
		}
		else {
			cout << "READY" << '\n';
		}
	}

}