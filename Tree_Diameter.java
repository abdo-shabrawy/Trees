static ArrayList<Integer> adjList [];
	static int f[]; // f[i] is The maximum height of the tree rooted at i + 1 (current node);
	static int g[]; // is the sum of the maximum two heights of the tree rooted at i + 1 (current node);
	static int diameter;
	static void dfs (int V , int pV) { // ans is max(dp1[1] , dp2[1])
		ArrayList<Integer> fValues = new ArrayList<>();
		for (int v : adjList[V]) {
			if (v == pV) continue;
			dfs (v , V);
			fValues.add(f[v]);
		}
		
		Collections.sort(fValues);
		
		f[V] = 1;
		if (!fValues.isEmpty()) f[V] += fValues.get(fValues.size() - 1);
		
		if (fValues.size() >= 2)
			g[V] = 1 + fValues.get(fValues.size() - 1) + fValues.get(fValues.size() - 2);
		
		diameter = Math.max(diameter, Math.max(f[V], g[V]));
	}
