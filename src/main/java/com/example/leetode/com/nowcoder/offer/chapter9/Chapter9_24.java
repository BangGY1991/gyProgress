package com.example.leetode.com.nowcoder.offer.chapter9;

/**
 * @Author guoyu
 * @Date 2021/12/4 11:42
 * @Version 1.0
 */
public class Chapter9_24 {
    //数字的英文表达和中文表达

        //*************************中文表达************************************
        public static String num1To9(int num) {
            if (num < 1 || num > 9) {
                return "";
            }
            String[] names = { "一", "二", "三", "四", "五", "六", "七", "八", "九" };
            return names[num - 1];
        }

        public static String num1To99(int num, boolean hasBai) {
            if (num < 1 || num > 99) {
                return "";
            }
            if (num < 10) {
                return num1To9(num);
            }
            int shi = num / 10;
            if (shi == 1 && (!hasBai)) {
                return "十" + num1To9(num % 10);
            } else {
                return num1To9(shi) + "十" + num1To9(num % 10);
            }
        }

        public static String num1To999(int num) {
            if (num < 1 || num > 999) {
                return "";
            }
            if (num < 100) {
                return num1To99(num, false);
            }
            String res = num1To9(num / 100) + "百";
            int rest = num % 100;
            if (rest == 0) {
                return res;
            } else if (rest >= 10) {
                res += num1To99(rest, true);
            } else {
                res += "零" + num1To9(rest);
            }
            return res;
        }

        public static String num1To9999(int num) {
            if (num < 1 || num > 9999) {
                return "";
            }
            if (num < 1000) {
                return num1To999(num);
            }
            String res = num1To9(num / 1000) + "千";
            int rest = num % 1000;
            if (rest == 0) {
                return res;
            } else if (rest >= 100) {
                res += num1To999(rest);
            } else {
                res += "零" + num1To99(rest, false);
            }
            return res;
        }

        public static String num1To99999999(int num) {
            if (num < 1 || num > 99999999) {
                return "";
            }
            int wan = num / 10000;
            int rest = num % 10000;
            if (wan == 0) {
                return num1To9999(rest);
            }
            String res = num1To9999(wan) + "万";
            if (rest == 0) {
                return res;
            } else {
                if (rest < 1000) {
                    return res + "零" + num1To999(rest);
                } else {
                    return res + num1To9999(rest);
                }
            }
        }

        public static String getNumChiExp(int num) {
            if (num == 0) {
                return "零";
            }
            String res = num < 0 ? "负" : "";
            int yi = Math.abs(num / 100000000);
            int rest = Math.abs((num % 100000000));
            if (yi == 0) {
                return res + num1To99999999(rest);
            }
            res += num1To9999(yi) + "亿";
            if (rest == 0) {
                return res;
            } else {
                if (rest < 10000000) {
                    return res + "零" + num1To99999999(rest);
                } else {
                    return res + num1To99999999(rest);
                }
            }
        }


        //*****************************************************

        //***********************英文表达**********************
        public static String num1To19(int num) {
            if (num < 1 || num > 19) {
                return "";
            }
            String[] names = { "One ", "Two ", "Three ", "Four ", "Five ", "Six ",
                    "Seven ", "Eight ", "Nine ", "Ten ", "Eleven ", "Twelve ",
                    "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Sixteen ",
                    "Eighteen ", "Nineteen " };
            return names[num - 1];
        }

        public static String num1To99(int num) {
            if (num < 1 || num > 99) {
                return "";
            }
            if (num < 20) {
                return num1To19(num);
            }
            int high = num / 10;
            String[] tyNames = { "Twenty ", "Thirty ", "Forty ", "Fifty ",
                    "Sixty ", "Seventy ", "Eighty ", "Ninety " };
            return tyNames[high - 2] + num1To19(num % 10);
        }

        public static String num1ToE999(int num) {
            if (num < 1 || num > 999) {
                return "";
            }
            if (num < 100) {
                return num1To99(num);
            }
            int high = num / 100;
            return num1To19(high) + "Hundred " + num1To99(num % 100);
        }
        //获得英文的表达式
        public static String getNumEngExp(int num) {
            if (num == 0) {
                return "Zero";
            }
            String res = "";
            if (num < 0) {
                res = "Negative, ";
            }
            if (num == Integer.MIN_VALUE) {
                res += "Two Billion, ";
                num %= -2000000000;
            }
            num = Math.abs(num);
            int high = 1000000000;
            int highIndex = 0;
            String[] names = { "Billion", "Million", "Thousand", "" };
            while (num != 0) {
                int cur = num / high;
                num %= high;
                if (cur != 0) {
                    res += num1ToE999(cur);
                    res += names[highIndex] + (num == 0 ? " " : ", ");
                }
                high /= 1000;
                highIndex++;
            }
            return res;
        }

        //*****************************************************
        // for test
        public static int generateRandomNum() {
            boolean isNeg = Math.random() > 0.5 ? false : true;
            int value = (int) (Math.random() * Integer.MIN_VALUE);
            return isNeg ? value : -value;
        }
        public static void main(String[]args)
        {

            System.out.println(0);
            System.out.println(getNumChiExp(0));

            System.out.println(Integer.MAX_VALUE);
            System.out.println(getNumChiExp(Integer.MAX_VALUE));

            System.out.println(Integer.MIN_VALUE);
            System.out.println(getNumChiExp(Integer.MIN_VALUE));

            int num = generateRandomNum();
            System.out.println(num);
            System.out.println(getNumChiExp(num));

            num = generateRandomNum();
            System.out.println(num);
            System.out.println(getNumChiExp(num));

            num = generateRandomNum();
            System.out.println(num);
            System.out.println(getNumChiExp(num));

            num = generateRandomNum();
            System.out.println(num);
            System.out.println(getNumChiExp(num));

            System.out.println(getNumChiExp(10));
            System.out.println(getNumChiExp(110));
            System.out.println(getNumChiExp(1010));
            System.out.println(getNumChiExp(10010));
            System.out.println(getNumChiExp(1900000000));
            System.out.println(getNumChiExp(1000000010));
            System.out.println(getNumChiExp(1010100010));

            //******************************************
            System.out.println(getNumEngExp(0));
            System.out.println(getNumEngExp(Integer.MAX_VALUE));
            System.out.println(getNumEngExp(Integer.MIN_VALUE));
            int num2 = generateRandomNum();
            System.out.println(num2);
            System.out.println(getNumEngExp(num2));



        }

}
