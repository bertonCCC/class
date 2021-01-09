#include <stdio.h>

struct Point{
    int x, y;
};

Point operator - (Point a, Point b){
    return {a.x - b.x, a.y - b.y};
}

long long cross(Point a, Point b){
    return 1LL * a.x * b.y - 1LL * b.x * a.y;
}

int T;

void solve(){
    int x1, y1, x2, y2, x3, y3;
    scanf("%d %d %d %d %d %d", &x1, &y1, &x2, &y2, &x3, &y3);
    Point p1{x1, y1}, p2{x2, y2}, p3{x3, y3};
    long long cp = cross(p2 - p1, p3 - p1);

    if(cp > 0) printf("LEFT\n");
    else if(cp < 0) printf("RIGHT\n");
    else printf("TOUCH\n");
}

int main(){
    scanf("%d", &T);
    for(int i = 0; i < T; i++) solve();
}
