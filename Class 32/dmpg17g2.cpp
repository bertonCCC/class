#include <stdio.h>
#include <algorithm>
using namespace std;

typedef long long int lli;
const int MN = 1e5+5;
const lli INF = 1e18;
struct node{
	lli max, pre, suf, sum;
};
int N, Q, arr[MN];
node seg[MN * 4];

node operator + (node a, node b){
	return {
		max(max(a.max, b.max), a.suf + b.pre),
		max(a.pre, a.sum + b.pre),
		max(b.suf, a.suf + b.sum),
		a.sum + b.sum
	};
}

node make(int n){
	return { n, n, n, n };
}

void build(int left, int right, int index){
	if(left == right) seg[index] = make(arr[left]);
	else{
		int mid = (left + right) / 2;
		build(left, mid, index * 2);
		build(mid + 1, right, index * 2 + 1);
		seg[index] = seg[index * 2] + seg[index * 2 + 1];
	}
}

void update(int uindex, long value, int left, int right, int index){
	if(left == right) seg[index] = make(value);
	else{
		int mid = (left + right) / 2;
		if(uindex <= mid) update(uindex, value, left, mid, index * 2);
		else update(uindex, value, mid + 1, right, index * 2 + 1);
		seg[index] = seg[index * 2] + seg[index * 2 + 1];
	}
}

node query(int qleft, int qright, int left, int right, int index){
	if(left > qright || right < qleft) return { -INF, -INF, -INF, 0 };
	else if(left >= qleft && right <= qright) return seg[index];
	else{
		int mid = (left + right) / 2;
		return query(qleft, qright, left, mid, index * 2) + query(qleft, qright, mid + 1, right, index * 2 + 1);
	}
}

int main(){
	char q;
	int n, v, l, r;

	scanf("%d %d", &N, &Q);
	for(int i = 0; i < N; i++)
		scanf("%d", &arr[i + 1]);
	build(1, N, 1);

	for(int i = 0; i < Q; i++){
		scanf(" %c", &q);
		if(q == 'S'){
			scanf("%d %d", &n, &v);
			update(n, v, 1, N, 1);
		}
		else{
			scanf("%d %d", &l, &r);
			printf("%lld\n", query(l, r, 1, N, 1).max);
		}
	}
}
