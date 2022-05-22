package com.company;

    import java.util.Scanner;

    public class Main {
        private static final int[] arabNum = {1,2,3,4,5,6,7,8,9,10};
        private static final String [] romeNum = {"I", "II","III","IV", "V", "VI", "VII", "VIII", "IX", "X"};

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Calculator calculator = new Calculator();
            String text = "";

            try {
                System.out.println("������� �������������� ���������");
                String num = scanner.nextLine();
                text = num.replaceAll("\\s","");
                String[] blocks = text.split("[\\Q^*/+-%\\E]");
                int roman = 0;
                char sign = checkSign(text);

                for(int i = 0; i <= 9; i++) {
                    if (romeNum[i].equals(blocks[0])) {
                        blocks[0] = Integer.toString(arabNum[i]);
                        roman++;
                    }
                    if (romeNum[i].equals(blocks[1])) {
                        blocks[1] = Integer.toString(arabNum[i]);
                        roman++;
                    }
                }
                int  result;
                if (isNumber(Integer.parseInt(blocks[0])) && isNumber(Integer.parseInt(blocks[1]))) {
                    result = calculator.calculate(Integer.parseInt(blocks[0]), Integer.parseInt (blocks[1]), sign);
                } else {
                    System.out.println("��������� ����� ������ ������� � �������� �� 1 �� 10");
                    throw new IllegalArgumentException();
                }

                if(roman == 1) {
                    System.out.println("����������� �������� ������ � ��������� � �������� �������");
                    throw new IllegalArgumentException();
                }

                if(roman == 2) {
                    RomanArabConvert.arabicToRoman(result);
                } else {
                    System.out.println(result);
                }
            } catch (RuntimeException e) {
                System.out.println("�������� ������ ������");
            }
        }

        private static char checkSign(String text) {
            if (text.contains("+")) {
                return '+';
            } else if (text.contains("-")) {
                return '-';
            } else if (text.contains("*")) {
                return '*';
            } else if (text.contains("/")) {
                return  '/';
            } else {
                System.out.println("�������������� ���� ������ �������. ���������� ����� +,-,*,/");
                throw new IllegalArgumentException();
            }
        }

        private static boolean isNumber (int num) {
            return (num >= 1 && num <= 10);
        }
    }