### DFS

> 루트 노드 혹은 임의 노드에서 **다음 브랜치로 넘어가기 전에, 해당 브랜치를 모두 탐색**하는 방법

**스택 or 재귀함수**를 통해 구현한다.

<br>

- 모든 경로를 방문해야 할 경우 사용에 적합

<img src="https://upload.wikimedia.org/wikipedia/commons/7/7f/Depth-First-Search.gif" width="300">

##### 시간 복잡도

- 인접 행렬 : O(V^2)
- 인접 리스트 : O(V+E)

<br>

<br>

### BFS

> 루트 노드 또는 임의 노드에서 **인접한 노드부터 먼저 탐색**하는 방법

**큐**를 통해 구현한다. (해당 노드의 주변부터 탐색해야하기 때문)

<br>

- 최소 비용(즉, 모든 곳을 탐색하는 것보다 최소 비용이 우선일 때)에 적합

<img src="https://upload.wikimedia.org/wikipedia/commons/5/5d/Breadth-First-Search-Algorithm.gif" width="300">

##### 시간 복잡도

- 인접 행렬 : O(V^2)
- 인접 리스트 : O(V+E)
