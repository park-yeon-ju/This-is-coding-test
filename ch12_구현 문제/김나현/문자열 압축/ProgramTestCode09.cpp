#include <string>
#include <vector>
using namespace std;

int solution(string n) {   //문자열이 n으로 들어옴
	int len = n.size();  //문자열 길이를 len에 넣음
	int answer = len;    //정답을 문자열 길이로 초기 세팅

	int num = len / 2;   //단위로 나누면 문자열 길이 최대1/2만 필요


	//i개 단위로 잘라서 압축
	for (int i = 1; i <= num; i++) {

		//i개 단위로 잘라서 압축한뒤 만들어지는 문자열
		string result = "";

		//자를 문자열 단위
		string str = n.substr(0, i);

		int cnt = 1;

		//앞에서 자른 문자열 단위를 제외한 뒷부분(j번 문자부터) 문자열을 검사한다.
		for (int j = i; j <= len; j += i) {
			//j번 부터 i개 만큼이 기존에 잘라놓은 문자열과 같은 경우 cnt 증가
			if (str == n.substr(j, i)) {
				cnt ++;
			}
			else {
				//다른 경우 중 cnt가 1이면 result에 그대로 ss를 붙인다.
				if (cnt == 1) {
					result += str;
				}
				else {
					//cnt가 1보다 크다면 그 문자열이 하나가 아니라는 뜻이니
					//cnt를 문자 단위로 문자열에 붙여서 result에 붙임
					result += (to_string(cnt) + str);
				}

				//문자열 단위를 j번부터 i개로 변경 
				str = n.substr(j, i);
				//cnt값 다시 1로 초기화
				cnt = 1;
			}

		}

		//문자열이 i로 나누어 떨어지지 않는다면 result에 나머지 부분을 붙인다.
		if ((len%i) != 0) {
			result += n.substr((len / i)*i);
		}

		//최솟값을 answer에 저장
		if (answer > result.size()) answer = result.size(); 
		//처음 answer에 총 길이를 넣었으니 위의 압축 과정이 이루어지면 answer은 현재 압축된 내용이 들어가게 될 것임.
	}


	return answer;
}
