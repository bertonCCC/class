#include <algorithm>
#include <tuple>
using namespace std;
typedef edge tuple<int, int, int>;
edge edges[100000];
/*
Input might look like
5 5
1 4 3
1 2 2
1 5 1
2 3 5
4 5 2
*/
int main(){
	scanf("%d %d", &N, &M);
	for(int i = 0; i < M; i++){
		int node1, node2, length;
		scanf("%d %d %d", &node1, &node2, &length);
		edges[i] = { length, node1, node2 }; // C++ 11
	}
	
	sort(edges, edges + M);
	
	for(int i = 0; i < M; i++){
		int node1, node2, length;
		tie(node1, node2, length) = edges[i];
		printf("%d %d %d\n", node1, node2, length);
	}
}