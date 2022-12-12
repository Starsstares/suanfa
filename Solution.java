package com.bipower.SumMeiNi;

/**
 * 一个字符串的 美丽值 定义为：出现频率最高字符与出现频率最低字符的出现次数之差。
 *
 * 比方说，"abaacc" 的美丽值为 3 - 1 = 2 。
 * 给你一个字符串 s ，请你返回它所有子字符串的 美丽值 之和。
 */
class Solution {
    public int beautySum(String s) {
        //应有一个i和一个j
        //i用于控制字符串的起始位置
        //j用于控制字符串的子字符串的遍历,求各个子字符串的美丽值
        //有两个for循环嵌套

        //用result标记最终结果
        int result=0;

        //这个for循环用于控制子字符串的开头位置
        for(int i=0;i<s.length();i++){
            //注意 在这里要new一个数组,把字符串中相同的字母放在一个下标里,每放一次,数组值++
            //因为有26个英文字母 所以数组长度为26 把相同字母的次数存在数组的同一个下标里
            int[] arr=new int[26];
            int max=0;
            //第二次for开始
            //注意 这里各个子字符串开始遍历
            for(int j=i;j<s.length();j++){
                //先得到相同字母的小标
                //用当前位置的字符和a相减可得到下标
                //个人认为这个数组下标的运用是本题的关键

                //美丽数是出现的最大值减去出现的最小值
                //出现的次数存在了数组中
                //定义最大小两个变量

            int min=s.length();
            arr[s.charAt(j)-'a']++;
            //得到最大值
              // max= max>arr[s.charAt(j)-'a']?max:arr[s.charAt(j)-'a'];
                max=Math.max(max,arr[s.charAt(j)-'a']);
             // 遍历得到最小值
                for (int k = 0; k < arr.length; k++) {
                    if(arr[k]>0){
                        min=Math.min(min,arr[k]);
                    }
                }
                // 用result得到差值结果总数
                result +=max-min;

            }



        }








        return result;
    }
}