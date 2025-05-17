public class IceCreamFinder {
  public static boolean canBuyIceCream(int buget, int[] iceCreamPrices) {
    for (int price : iceCreamPrices) {
      if (price == budget) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    int budget = 30;
    int[] iceCreamPrices = { 25, 30, 50 };

    boolean result = canBuyIceCream(budget, iceCreamPrices);
    System.out.println(result);
  }

}