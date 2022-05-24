package bean;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Charon
 * @date 2020/7/15
 **/
public class Cart {

    //private Integer totalCount;
    //private BigDecimal totalPrice;
    private Map<Integer, CartItem> items = new LinkedHashMap<Integer, CartItem>();

    /**
     * 添加商品
     *
     * @param cartItem 商品项
     */
    public void addItem(CartItem cartItem) {

        CartItem item = items.get(cartItem.getId());

        if (item == null) {
            items.put(cartItem.getId(), cartItem);
        } else {
            item.setCount(item.getCount() + 1);
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
        }

    }

    /**
     * 修改商品数量
     *
     * @param id    商品项id
     * @param count 修改的商品数量
     */
    public void updateCount(Integer id, Integer count) {

        CartItem cartItem = items.get(id);
        if (cartItem != null) {
            cartItem.setCount(count);// 修改商品数量
            cartItem.setTotalPrice(cartItem.getPrice().multiply(new BigDecimal(cartItem.getCount()))); // 更新总金额
        }

    }

    /**
     * 删除某一个物品
     *
     * @param id 商品项id
     */
    public void deleteItem(Integer id) {

        items.remove(id);

    }

    /**
     * 清空购物车
     */
    public void clear() {
        items.clear();
    }

    public Cart() {
    }


    public Integer getTotalCount() {
        Integer totalCount = 0;

        Set<Map.Entry<Integer, CartItem>> entries = items.entrySet();
        for (Map.Entry<Integer, CartItem> entry : entries) {
            totalCount += entry.getValue().getCount();
        }

        return totalCount;
    }

    /*由加入购物车的物品计算得到，不能进行设置
    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }*/

    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);
        Set<Map.Entry<Integer, CartItem>> entries = items.entrySet();
        for (Map.Entry<Integer, CartItem> entry : entries) {
            totalPrice = totalPrice.add(entry.getValue().getTotalPrice());
        }
        return totalPrice;
    }

    /*由加入购物车的物品计算得到，不能进行设置
    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }*/

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }
}
