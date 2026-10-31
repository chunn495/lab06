package it.unibo.generics.graph.impl;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import it.unibo.generics.graph.api.Graph;

public class GraphImpl<N> implements Graph<N> {

    private final Map<N, Set<N>> graph = new LinkedHashMap<>();

    @Override
    public void addNode(final N node) {
        if (node != null) {
            this.graph.putIfAbsent(node, new LinkedHashSet<>());
        }
    }

    @Override
    public void addEdge(final N source, final N target) {
        if (source != null && target != null && this.graph.containsKey(source) && this.graph.containsKey(target)) {
            this.graph.get(source).add(target);
        }
    }

    @Override
    public Set<N> nodeSet() {
        return new LinkedHashSet<>(this.graph.keySet());
    }

    @Override
    public Set<N> linkedNodes(final N node) {
        final Set<N> neighbors = this.graph.get(node);
        if (neighbors != null) {
            return new LinkedHashSet<>(neighbors);
        }
        return Collections.emptySet();
    }

    @Override
    public List<N> getPath(final N source, final N target) {
        if (source == null || target == null || !this.graph.containsKey(source) || !this.graph.containsKey(target)) {
            return Collections.emptyList();
        }

        final Queue<N> toVisit = new ArrayDeque<>();
        final Map<N, N> parentMap = new HashMap<>();
        final Set<N> visited = new HashSet<>();

        toVisit.add(source);
        visited.add(source);

        while (!toVisit.isEmpty()) {
            final N currentNode = toVisit.poll();

            if (currentNode.equals(target)) {
                final List<N> path = new ArrayList<>();
                N curr = target;
                while (curr != null) {
                    path.add(curr);
                    curr = parentMap.get(curr);
                }
                Collections.reverse(path); 
                return path;
            }

            for (final N n : linkedNodes(currentNode)) {
                if (!visited.contains(n)) { 
                    parentMap.put(n, currentNode);
                    toVisit.add(n);
                }
            }
        }

        return Collections.emptyList();
    }
}