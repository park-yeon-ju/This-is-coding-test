#include<iostream>
#include<vector>
#include<algorithm>
#include<string>
#include<cstdlib> //절대값 함수

using namespace std;

int main(){

    //값 입력
    int n, distance=0, min=100001;
    cin>>n;
    int home[n];
    for(int i = 0; i<n; i++){
        cin>>home[i];
    }

    //풀이
    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            distance = distance + abs(home[i] - home[j]);
        }

        if(distance<min){
            min = distance;
        }
        distance=0;
    }

    //결과 출력
    cout<<min;

    return 0;
}