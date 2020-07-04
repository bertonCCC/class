#include <algorithm>
using namespace std;
struct edge{
	int node1, node2, length;
};
edge edges[100000];

bool cmp(edge edge1, edge edge2){ // when is edge1 < edge2?
	return edge1.length < edge2.length;
}
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
		edges[i] = { node1, node2, length }; // C++ 11
	}
	
	sort(edges, edges + M, cmp);
	
	for(int i = 0; i < M; i++){
		printf("%d %d %d\n", edge[i].node1, edge[i].node2, edge[i].length);
	}
}