package net.tao.rhb.dd.commons.ibg;

import java.util.List;

public class EntryHashingCalculator {
    private static final int[] POSITION_WEIGHT = new int[]{3, 5, 1, 7};

    /**
     * Calculate the squared sum of IBG entry by using Routing Number,
     * Payer's Account Number and Amount (in cents).
     *
     * @param routingNumber 8 bytes routing number, excluding check digit
     * @param accountNo     Payer's account number
     * @param amountInCents transaction amount in cents
     * @return the squared sum of the IBG entry
     */
    public int calculateSquaredSum(String routingNumber, String accountNo, String amountInCents) {
        if (routingNumber == null) {
            routingNumber = "";
        }
        
        if (accountNo == null) {
            accountNo = "";
        }
        
        if (amountInCents == null) {
            amountInCents = "";
        }
        
        // 8 digit Routing Number (right zero filled)
        // 17 digit A/C number (right zero filled)
        // 10 digit Amount (left zero filled)
        String formattedValue = String.format("%1$-8s%2$-17s%3$10s",
                routingNumber,
                accountNo,
                amountInCents).replace(' ', '0');

        int weightedSum = calculateWeightedSum(formattedValue);

        return weightedSum * weightedSum;
    }

    /**
     * Calculate the control value by using the provided list of squared sum(s).
     *
     * @param listOfSquaredSum list of squared sum of IBG entry
     * @return the 3-digit control value
     */
    public int calculateControlValue(int[] listOfSquaredSum) {
        long batchControlSum = 0L;
        for (int squaredSum : listOfSquaredSum) {
            batchControlSum += squaredSum;
        }

        // safe to downcast as it takes last 2 digit only
        return 1000 - (int) (batchControlSum % 100);
    }


    private int calculateWeightedSum(String formattedValue) {
        int weightedSum = 0;

        for (int i = 0; i < formattedValue.length(); i++) {
            int lth = formattedValue.length() + 1;
            int leftPos = i + 1;
            int rightPos = lth - i;
            int charValue = toInt(formattedValue.charAt(i), leftPos);
            weightedSum += weightedValue(charValue, rightPos);
        }

        if (weightedSum == 0) {
            throw new RuntimeException(
                    String.format("Failed to calculate. Invalid value: '%s'", formattedValue));
        }

        return weightedSum;
    }

    private int toInt(char character, int leftPos) {
        if (Character.isDigit(character)) {
            return Character.getNumericValue(character);
        }
        throw new RuntimeException("Invalid Character["
                                   + leftPos + "] = '" + character + "'");
    }

    private int weightedValue(int charValue, int rightPos) {
        int weight = POSITION_WEIGHT[rightPos % 4];
        return charValue * weight;
    }
}
