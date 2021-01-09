#include <stdio.h>
#include <algorithm>
using namespace std;

struct Point{
    int x, y;
};

Point operator - (Point a, Point b){
    return {a.x - b.x, a.y - b.y};
}

long long cross(Point a, Point b){
    return 1LL * a.x * b.y - 1LL * b.x * a.y;
}

// AB x AC
long long cross(Point a, Point b, Point c){
    return cross(b - a, c - a);
}

bool intersect(int a, int b, int c, int d){
    if(a > b) swap(a, b);
    if(c > d) swap(c, d);
    return max(a, c) <= min(b, d);
}

int sign(long long n){
    return clamp(n, -1, 1);
}

int T;

void solve(){
    int x1, y1, x2, y2, x3, y3, x4, y4;
    scanf("%d %d %d %d %d %d %d %d", &x1, &y1, &x2, &y2, &x3, &y3, &x4, &y4);
    Point A{x1, y1}, B{x2, y2}, C{x3, y3}, D{x4, y4};

    bool ans;
    if(cross(A, B, C) == 0 && cross(A, B, D) == 0)
        ans = intersect(A.x, B.x, C.x, D.x) && (A.y, B.y, C.y, D.y);
    else
        ans = sign(cross(A, B, C)) != sign(cross(A, B, D))
        && sign(cross(C, D, A)) != sign(cross(C, D, B));
}

int main(){
    scanf("%d", &T);
    for(int i = 0; i < T; i++) solve();
}
