// Bez jokerów
// Input typu 123456789RGBY
// Backtracking
// Tylko czy solvable
#include <bits/stdc++.h>
using namespace std;

const int h = 13;
const int w = 4;
struct Tablica{
    int Arr[h][w];
};
bool ok(int a,int b,int c,int d){
    if(max(max(a,b),max(c,d)) == 2){
        return (a + b + c + d - min(min(a,b),min(c,d)) >= 6);
    }
    if(max(max(a,b),max(c,d)) == 1){
        return (a + b + c + d >= 3);
    }
    return true;
}
bool check(Tablica T) {
    bool done = 1;
    for (int i = 0; i < h; i++){
        if(!ok(T.Arr[i][0],T.Arr[i][1],T.Arr[i][2],T.Arr[i][3]))done = 0;
    }
    if(done){
        return true;
    }
    for (int i = 0; i < 11; i++){
        for (int j = 0; j < 4;j++){
            for (int k = 3; k <= min(5,13 - i);k++){
                bool ok = 1;
                for (int iterator = i; iterator < i + k; iterator++){
                    if(T.Arr[iterator][j] == 0)ok = 0;
                }
                if(ok == 1){
                    Tablica S = T;
                    for (int iterator = i; iterator < i + k; iterator++){
                        S.Arr[iterator][j]--;
                    }
                    if(check(S)){
                        return true;
                    }
                }
            }
        }
    }
    return false;
}


int main(){
    int n;  // Ile na planszy
    cin >> n;

    Tablica M;
    for (int i = 0; i < h;i++){
        for (int j = 0; j < w;j++){
            M.Arr[i][j] = 0;
        }
    }
    for (int i = 0; i < n;i++){
        char kol;
        cin >> kol;

        int a;
        cin >> a;
        M.Arr[a - 1][kol - 'A']++;
    }
    cout << "START..." << '\n';
    bool res = check(M);
    if(res){
        cout << "TAK" << '\n';
    }
    else{
         cout << "NIE" << '\n';
    }


}
