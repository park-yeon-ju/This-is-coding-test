#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

void main() {
	string str, new_str;
	int sum = 0;

	cin >> str;
	for (int i = 0; i < str.length(); i++) {
		if (str[i] < 65) {  //���� �϶�
			sum += (str[i] - 48);  //���� ���ڷ� �־��ִ� ���ڸ� ���� ���·�
		}
		else{
			new_str += str[i];  //���ڸ� ���ο� ��Ʈ���� �ֱ�
		}
	}
    
	sort(new_str.begin(), new_str.end());  //���ڿ� ������������ ���� sort �Լ� ���

	cout << new_str << sum << '\n'; 

}