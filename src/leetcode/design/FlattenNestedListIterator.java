// Given a nested list of integers, implement an iterator to flatten it.
// Each element is either an integer, or a list -- whose elements may also be integers or other lists.
// See: https://leetcode.com/problems/flatten-nested-list-iterator/

package leetcode.design;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FlattenNestedListIterator {

    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a
        // nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a
        // single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested
        // list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    // Implementation used for testing
    class NestedIteratorImpl implements NestedInteger {
        Integer intValue;
        List<NestedInteger> listValue;

        public NestedIteratorImpl(Integer intValue) {
            this.intValue = intValue;
        }

        public NestedIteratorImpl(List<NestedInteger> listValue) {
            this.listValue = listValue;
        }

        @Override
        public boolean isInteger() {
            return this.intValue != null ? true : false;
        }

        @Override
        public Integer getInteger() {
            return this.intValue;
        }

        @Override
        public List<NestedInteger> getList() {
            return this.listValue;
        }
    }

    // Actual solution
    // TODO: Add iterative solution with Stack
    public class NestedIterator implements Iterator<Integer> {
        private List<NestedInteger> result = new ArrayList<>();
        private Iterator<NestedInteger> iterator;

        public NestedIterator(List<NestedInteger> nestedList) {
            flatten(nestedList.iterator());
            iterator = result.iterator();
        }
        
        private void flatten(Iterator<NestedInteger> it) {
            if (!it.hasNext()) 
                return;
            
            while (it.hasNext()) {
                NestedInteger curr = it.next();
                if (curr.isInteger())
                    result.add(curr);
                else 
                    flatten(curr.getList().iterator());;
            }
        }

        @Override
        public Integer next() {
            return this.iterator.next().getInteger();
        }

        @Override
        public boolean hasNext() {
            return this.iterator.hasNext();
        }
    }

    public static void main(String[] args) {
        FlattenNestedListIterator sln = new FlattenNestedListIterator();

//        NestedInteger i1 = sln.new NestedIteratorImpl(1); // 1
//        NestedInteger i4 = sln.new NestedIteratorImpl(4); // 4
//        NestedInteger i6 = sln.new NestedIteratorImpl(6); // 6
//
//        List<NestedInteger> i6List = new ArrayList<>();
//        i6List.add(i6);
//        NestedInteger i6Nested = sln.new NestedIteratorImpl(i6List);
//
//        List<NestedInteger> i46List = new ArrayList<>();
//        i46List.add(i4);
//        i46List.add(i6Nested);
//
//        NestedInteger i4Nested = sln.new NestedIteratorImpl(i46List);
//
//        List<NestedInteger> all = new ArrayList<>();
//        all.add(i1);
//        all.add(i4Nested);

        NestedInteger i1 = sln.new NestedIteratorImpl(1); // 1
        NestedInteger i11 = sln.new NestedIteratorImpl(1); // 1
        NestedInteger i2 = sln.new NestedIteratorImpl(2); // 2
        NestedInteger i111 = sln.new NestedIteratorImpl(1); // 1
        NestedInteger i1111 = sln.new NestedIteratorImpl(1); // 1

        List<NestedInteger> l1 = new ArrayList<>();
        l1.add(i1);
        l1.add(i11);

        List<NestedInteger> l2 = new ArrayList<>();
        l2.add(i111);
        l2.add(i1111);

        NestedInteger n1 = sln.new NestedIteratorImpl(l1);
        NestedInteger n2 = sln.new NestedIteratorImpl(l2);

        List<NestedInteger> all = new ArrayList<>();
        all.add(n1);
        all.add(i2);
        all.add(n2);

        @SuppressWarnings("unused")
        NestedIterator ni = sln.new NestedIterator(all);
    }

}
