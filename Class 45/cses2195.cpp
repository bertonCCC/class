#ifdef LOCAL
	#define d(...) fprintf(stderr, __VA_ARGS__), fflush(stderr)
#else
	#define d(...)
#endif
#include <stdio.h>
#include <algorithm>
using namespace std;

typedef long long int lli;
struct point{
	int x, y;
};
const int MN = 2e5+5;
point pt[MN], upper[MN], lower[MN], hull[MN];
int N, LS, US, HS;

point operator - (point a, point b){
	return { a.x - b.x, a.y - b.y };
}

bool operator < (point a, point b){
	if(a.x == b.x) return a.y < b.y;
	return a.x < b.x;
}

lli cross(point a, point b){
	return 1LL * a.x * b.y - 1LL * b.x * a.y;
}

lli cross(point a, point b, point c){
	return cross(b - a, c - a);
}

int main(){
	scanf("%d", &N);
	for(int i = 0; i < N; i++){
		int x, y;
		scanf("%d %d", &x, &y);
		pt[i] = {x, y};
	}

	sort(pt, pt + N);
	point left = pt[0], right = pt[N - 1];

	upper[US++] = left;
	lower[LS++] = left;

	for(int i = 1; i < N; i++){
		lli cp = cross(left, right, pt[i]);
		if(cp >= 0){
			while(US >= 2 && cross(upper[US - 2], upper[US - 1], pt[i]) > 0)
			   --US;
			upper[US++] = pt[i];
		}
		if(cp <= 0){
			while(LS >= 2 && cross(lower[LS - 2], lower[LS - 1], pt[i]) < 0)
				--LS;
			lower[LS++] = pt[i];
		}
	}

	reverse(upper + 1, upper + US - 1);

	for(int i = 0; i < LS; i++)
		hull[HS++] = lower[i];
	for(int i = 1; i < US - 1; i++)
		hull[HS++] = upper[i];

	printf("%d\n", HS);
	for(int i = 0; i < HS; i++)
		printf("%d %d\n", hull[i].x, hull[i].y);
}
