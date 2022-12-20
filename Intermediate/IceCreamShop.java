package org.example;

import java.util.Scanner;

class ShopItems {
    int totalCount;

    public void  increaseCount( int itemCount) {
            this.totalCount += itemCount;
    }

    public int getCount() {
        return this.totalCount;
    }

    class Nonvegan {
        int iceCreamCount;
        int shakeCount;
        int totalCount;

        /*Nonvegan(int iceCreamCount,int shakeCount,int totalCount) {
            this.iceCreamCount = iceCreamCount;
            this.shakeCount = shakeCount;
            this.totalCount = totalCount;
        }*/

        public void  increaseCount(int type, int itemCount) {
            if (type == 1) {
                this.iceCreamCount += itemCount;
                this.totalCount += itemCount;
                ShopItems ite = new ShopItems();
                ite.increaseCount(itemCount);
            }
            else if(type == 2) {
                this.shakeCount += itemCount;
                this.totalCount += itemCount;
                ShopItems ite = new ShopItems();
                ite.increaseCount(itemCount);
            }
        }
    }

    class Vegan {
        int smoothieCount;
        int slushiCount;
        int totalCount;

        /*Vegan(int smoothieCount ,int slushiCount,int totalCount ) {
            this.smoothieCount = smoothieCount;
            this.slushiCount = slushiCount;
            this.totalCount = totalCount;
        }*/

        public void  increaseCount(int type, int itemCount) {
            if (type == 1) {
                this.smoothieCount += itemCount;
                this.totalCount += itemCount;
                ShopItems ite = new ShopItems();
                ite.increaseCount(itemCount);
            }
            else if(type == 2) {
                this.slushiCount += itemCount;
                this.totalCount += itemCount;
                ShopItems ite = new ShopItems();
                ite.increaseCount(itemCount);
            }
        }

    }

}

public class IceCreamShop {

    public static void main(String[] args) {

        ShopItems items = new ShopItems();
        ShopItems.Nonvegan vegan = items.new Nonvegan();
        ShopItems.Vegan nonvegan = items.new Vegan();


        int orderType = 0;
        Scanner input = new Scanner(System.in);
        int itemCount = 0;
        String itemName;

        System.out.println("Hello! Welcome to the ice cream shop. We are ready to take your order. For ice-cream type 1, for shakes type 2, for smoothies type 3, and for slushies type 4. If you are done ordering type 0.");
        orderType = input.nextInt();

        while(orderType != 0) {
            System.out.println("How many items of this item would you like to order?");
            itemCount = input.nextInt();
            if(orderType == 1){
                itemName = "ice cream";
                nonvegan.increaseCount(1,itemCount);
            } else if(orderType == 2) {
                itemName = "shake";
                nonvegan.increaseCount(2,itemCount);
            } else if(orderType == 3) {
                itemName = "smoothie";
                vegan.increaseCount(1,itemCount);
            } else if(orderType == 4) {
                itemName = "slushie";
                vegan.increaseCount(2,itemCount);
            } else {
                break;
            }

            System.out.println("Adding " + itemCount + " of the item "+ itemName + " to your order!");

            System.out.println("Type a number for the next item in your order:\n1: Ice cream\n2: Shake\n3: Smoothie\n4: Slushie\n");
            orderType = input.nextInt();

            System.out.println("Thank you for your order! Today we have sold " +items.getCount() );
        }
    }



}
