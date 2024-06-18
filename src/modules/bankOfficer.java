package modules;

import static utils.input.newIn;

public class bankOfficer {
    public static void officer() {
        System.out.println(
                "1-Get Customer \n" +
                "2-Get Specific Customers \n" +
                "3.Get GiftCards \n" +
                "4.Get Specific Giftcards \n"
        );
        int action = newIn.nextInt();
    }
}
