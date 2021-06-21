package com.example.leetode.com.nowcoder.offer.chapter3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import javax.management.Query;

public class Chapter3_19 {
	public class Element<V> {
		public V value;

		public Element(V value) {
			super();
			this.value = value;
		}

	}

	public class UnionFindSet<V> {
		public HashMap<V, Element<V>> elementMap;
		public HashMap<Element<V>, Element<V>> fatherMap;
		public HashMap<Element<V>, Integer> rankMap;

		public UnionFindSet(List<V> list) {
			this.elementMap = new HashMap<>();
			this.fatherMap = new HashMap<>();
			this.rankMap = new HashMap<>();
			for (V value : list) {
				Element<V> element = new Element<V>(value);
				elementMap.put(value, element);
				fatherMap.put(element, element);
				rankMap.put(element, 1);
			}
		}

		private Element<V> findHead(Element<V> element) {
			Stack<Element<V>> path = new Stack<>();
			while (element != fatherMap.get(element)) {
				path.push(element);
				element = fatherMap.get(element);
			}
			while (!path.isEmpty()) {
				fatherMap.put(path.pop(), element);
			}
			return element;
		}

		public V findHead(V value) {
			return elementMap.containsKey(value) ? findHead(elementMap.get(value)).value : null;
		}

		public boolean isSameSet(V a, V b) {
			if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
				return findHead(elementMap.get(a)) == findHead(elementMap.get(b));
			}
			return false;
		}

		public void union(V a, V b) {
			if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
				Element<V> aF = findHead(elementMap.get(a));
				Element<V> bF = findHead(elementMap.get(b));
				if (aF != bF) {
					Element<V> big = rankMap.get(aF) >= rankMap.get(aF) ? aF : bF;
					Element<V> small = big == aF ? bF : aF;
					fatherMap.put(small, big);
					rankMap.put(big, rankMap.get(aF) + rankMap.get(bF));
					rankMap.remove(small);
				}
			}
		}

	}

	public class Query {
		public Node o1;
		public Node o2;

		public Query(Node o1, Node o2) {
			super();
			this.o1 = o1;
			this.o2 = o2;
		}
	}

	public Node[] tarJanQuery(Node head, Query[] queries) {
		HashMap<Node, LinkedList<Node>> queryMap = new HashMap<>();
		HashMap<Node, LinkedList<Integer>> indexMap = new HashMap<>();
		HashMap<Node, Node> ancestorMap = new HashMap<>();
		UnionFindSet<Node> sets = new UnionFindSet<>(getAllNodes(head));
		Node[] ans = new Node[queries.length];
		setQueriesAndSetEasyAnswer(queries, ans, queryMap, indexMap);
		setAnswers(head, ans, queryMap, indexMap, ancestorMap, sets);
		return ans;

	}

	private void setAnswers(Node head, Node[] ans, HashMap<Node, LinkedList<Node>> queryMap,
			HashMap<Node, LinkedList<Integer>> indexMap, HashMap<Node, Node> ancestorMap, UnionFindSet<Node> sets) {
		if (head == null) {
			return;
		}
		setAnswers(head.left, ans, queryMap, indexMap, ancestorMap, sets);
		sets.union(head.left, head);
		ancestorMap.put(sets.findHead(head), head);
		LinkedList<Node> nList = queryMap.get(head);
		LinkedList<Integer> iList = indexMap.get(head);
		Node node = null;
		Node nodeFather = null;
		int index = 0;
		while (nList != null && !nList.isEmpty()) {
			node = nList.poll();
			index = iList.poll();
			nodeFather = sets.findHead(node);
			if (ancestorMap.containsKey(nodeFather)) {
				ans[index] = ancestorMap.get(nodeFather);
			}
		}

	}

	public void setQueriesAndSetEasyAnswer(Query[] ques, Node[] ans, HashMap<Node, LinkedList<Node>> queryMap,
			HashMap<Node, LinkedList<Integer>> indexMap) {
		Node o1 = null;
		Node o2 = null;
		for (int i = 0; i < ans.length; i++) {
			o1 = ques[i].o1;
			o2 = ques[i].o2;
			if (o1 == o2 || o1 == null || o2 == null) {
				ans[i] = o1 != null ? o1 : o2;
			} else {
				if (!queryMap.containsKey(o1)) {
					queryMap.put(o1, new LinkedList<Node>());
					indexMap.put(o1, new LinkedList<Integer>());
				}
				if (!queryMap.containsKey(o2)) {
					queryMap.put(o2, new LinkedList<Node>());
					indexMap.put(o2, new LinkedList<Integer>());
				}
				queryMap.get(o1).add(o2);
				indexMap.get(o1).add(i);
				queryMap.get(o2).add(o1);
				indexMap.get(o2).add(i);
			}
		}

	}

	public List<Node> getAllNodes(Node head) {
		List<Node> res = new ArrayList<Node>();
		process(head, res);
		return res;
	}

	private void process(Node head, List<Node> res) {

		if (head == null) {
			return;
		}
		res.add(head);
		process(head.left, res);
		process(head.right, res);
	}
}
