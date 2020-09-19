#include <stdio.h>

const int MAXN = 2e5+1;
int arr[MAXN];
long long fen[MAXN];

void update(int n, int v){
	int diff = v - arr[n];
	for(int i = n; i < MAXN; i += i & -i){
		fen[i] += diff;
	}
	arr[n] = v;
}

long long prefix(int n){
	long long sum = 0;
	for(int i = n; i > 0; i -= i & -i){
		sum += fen[i];
	}
	return sum;
}

long long query(int l, int r){
	return prefix(r) - prefix(l - 1);
}

int main(){
	int N, Q;
	scanf("%d %d", &N, &Q);

	for(int i = 1; i <= N; i++){
		int v;
		scanf("%d", &v);
		update(i, v);
	}

	for(int i = 0; i < Q; i++){
		int q, a, b;
		scanf("%d %d %d", &q, &a, &b);

		if(q == 1) update(a, b);
		else printf("%lld\n", query(a, b));
	}
}
