// Implement the class ProductOfNumbers that supports two methods:
//     1. add(int num)
// Adds the number num to the back of the current list of numbers.
//     2. getProduct(int k)
// Returns the product of the last k numbers in the current list.
// You can assume that always the current list has at least k numbers.
// At any time, the product of any contiguous sequence of numbers will fit into 
// a single 32-bit integer without overflowing.
// See: https://leetcode.com/problems/product-of-the-last-k-numbers/
// See: https://leetcode.com/problems/product-of-the-last-k-numbers/discuss/567493/Java-Intuitive-Solution-with-List

package leetcode.others;

import java.util.ArrayList;
import java.util.List;

public class ProductOfTheLastKNumbers {

    class ProductOfNumbers {
        private List<Integer> products;

        public ProductOfNumbers() {
            this.products = new ArrayList<>();
            this.products.add(1);
        }

        public void add(int num) {
            if (num == 0) {
                products = new ArrayList<>();
                products.add(1);
            } else
                products.add(num * products.get(products.size() - 1));
        }

        public int getProduct(int k) {
            if (k >= products.size())
                return 0;

            return products.get(products.size() - 1) / products.get(products.size() - 1 - k);
        }
    }

    public static void main(String[] args) {
        ProductOfTheLastKNumbers sln = new ProductOfTheLastKNumbers();
        ProductOfNumbers prod = sln.new ProductOfNumbers();

        prod.add(3);
        prod.add(0);
        prod.add(2);
        prod.add(5);
        prod.add(4);

        System.out.println(prod.getProduct(2));
        System.out.println(prod.getProduct(3));
        System.out.println(prod.getProduct(4));

        prod.add(8);

        System.out.println(prod.getProduct(2));

    }

}
