package com.company;
import java.util.List;

class RomanArabConvert {

    public static void arabicToRoman(int number) {
        if ((number <= 0) || (number > 100)) {
            System.out.println(number + " число вне допустимых значений (0,100]");
            throw new IllegalArgumentException();
        }

        List<RomArabNumerals> romanNumerals = RomArabNumerals.getReverseSortedValues();

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while (number > 0 && i < romanNumerals.size()) {
            RomArabNumerals currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() <= number) {
                sb.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            } else {
                i++;
            }
        }

        System.out.println(sb.toString());
    }
}