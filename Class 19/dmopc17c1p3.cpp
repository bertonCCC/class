#include <stdio.h>
#include <vector>
#include <queue>
using namespace std;
const int MN = 1e5+5, INF = 1e6;

struct Distance{
    int dang, total;
};

struct NodeAndDist{
    int node;
    Distance dist;
};

vector<NodeAndDist> adj[MN];
Distance dist[MN];

bool operator < (Distance a, Distance b){
    if(a.dang == b.dang) return a.total < b.total;
    return a.dang < b.dang;
}

bool operator > (Distance a, Distance b){
    if(a.dang == b.dang) return a.total > b.total;
    return a.dang > b.dang;
}

Distance operator + (Distance a, Distance b){
    return { a.dang + b.dang, a.total + b.total };
}

bool operator > (NodeAndDist a, NodeAndDist b){
    return a.dist > b.dist;
}

int main(){
    int N, M;
    scanf("%d %d", &N, &M);

    for(int i = 0; i < M; i++){
        int u, v, d;
        scanf("%d %d %d", &u, &v, &d);
        adj[u].push_back({v, {d, 1}});
        adj[v].push_back({u, {d, 1}});
    }

    priority_queue<NodeAndDist, vector<NodeAndDist>, greater<NodeAndDist>> heap;
    for(int i = 2; i <= N; i++)
        dist[i] = {INF, INF};
    dist[1] = {0, 0};

    heap.push({1, dist[1]});
    while(!heap.empty()){
        NodeAndDist lowest = heap.top();
        heap.pop();

        int current = lowest.node;

        for(NodeAndDist to : adj[current]){
            int neighbour = to.node;
            Distance weight = to.dist;

            if(dist[current] + weight < dist[neighbour]){
                dist[neighbour] = dist[current] + weight;
                heap.push({neighbour, dist[neighbour]});
            }
        }
    }

    if(dist[N].total == INF)
        printf("-1\n");
    else
        printf("%d %d\n", dist[N].dang, dist[N].total);
}
