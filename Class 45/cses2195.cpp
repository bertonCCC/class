// NOT CORRECT RIGHT NOW

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

const int MN = 2e5+5;
int N;
Point pts[MN], hull[MN];

int main(){
    scanf("%d", &N);
    for(int i = 0; i < N; i++){
        int x, y;
        scanf("%d %d", &x, &y);
        pts[i] = {x, y};
    }

    for(int i = 1; i < N; i++){
        if(pts[i].x < pts[0].x)
            swap(pts[i], pts[0]);
    }

    sort(pts + 1, pts + N, [] (Point a, Point b){
        return cross(pts[0], a, b) > 0;
    });

    int H = 1;
    hull[0] = pts[0];
    for(int i = 1; i < N; i++){
        while(H >= 2 && cross(hull[H - 2], hull[H - 1], pts[i]) < 0)
            --H;
        hull[H] = pts[i];
        H += 1;
    }

    printf("%d\n", H);
    for(int i = 0; i < H; i++)
        printf("%d %d\n", hull[i].x, hull[i].y);
}
