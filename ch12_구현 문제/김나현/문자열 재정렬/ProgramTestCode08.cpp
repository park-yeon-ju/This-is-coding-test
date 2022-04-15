#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

void main() {
	string str, new_str;
	int sum = 0;

	cin >> str;
	for (int i = 0; i < str.length(); i++) {
		if (str[i] < 65) {  //숫자 일때
			sum += (str[i] - 48);  //현재 문자로 넣어있는 숫자를 정수 형태로
		}
		else{
			new_str += str[i];  //문자를 새로운 스트링에 넣기
		}
	}
    
	sort(new_str.begin(), new_str.end());  //문자열 오름차순으로 정렬 sort 함수 사용

	cout << new_str << sum << '\n'; 

}