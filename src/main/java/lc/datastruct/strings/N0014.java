package lc.datastruct.strings;

import lc.DisplayUtil;

import javax.management.MXBean;

/**
 * @Author: h2linlin
 *
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 *
 * 示例 1：
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 *
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *
 *
 * 提示：
 *
 * 0 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 *
 */
public class N0014 {
	public static void main(String[] args) {
		// 输入
		String[] in = {"cir","car"};
		int target = 4;
		DisplayUtil.display(in);

		// 计算
		String out = solution2(in);

		// 输出
		DisplayUtil.display(out);
	}

	// 解法1：暴力法：简单逐次查找。
	// 找出第1、2字符串的最大前缀，再用该前缀和第3个字符串找，以此类推。如果最大前缀为空，则可立即返回。
	public static String solution1(String[] strs) {
		// 校验
		if (strs == null || strs.length == 0) {
			return "";
		}

		StringBuilder maxPreSb = new StringBuilder();
		String maxPre = strs[0];

		A:for (int i = 1; i < strs.length; i++) {
			int minLength = Math.min(maxPre.length(), strs[i].length());
			for (int j = 0; j < minLength; j++) {
				if (maxPre.charAt(j) == strs[i].charAt(j)) {
					maxPreSb.append(maxPre.charAt(j));
				} else {
					// 存储当前最大公共前缀
					maxPre = maxPreSb.toString();
					// 清空缓存
					maxPreSb.delete(0, maxPreSb.length());
					continue A;
				}
			}

			// 存储当前最大公共前缀
			maxPre = maxPreSb.toString();
			// 清空缓存
			maxPreSb.delete(0, maxPreSb.length());

			if ("".equals(maxPre)) {
				return maxPre;
			}
		}

		return maxPre;
	}

	// 解法2：暴力法：纵向查找。
	// 想象把所有字符装入2维数组，从前往后一列一列走，直到不相同的地方即可。
	public static String solution2(String[] strs) {
		// 校验
		if (strs == null || strs.length == 0) {
			return "";
		}

		int index = 0;

		int xLen = strs.length;
		int yLen = strs[0].length();

		A:for (int i = 0; i < yLen; i++) {
			char sameChar = strs[0].charAt(i);
			for (int j = 0; j < xLen; j++) {
				if (strs[j].length() < i + 1 || strs[j].charAt(i) != sameChar) {
					break A;
				}
			}

			index ++;
		}

		return strs[0].substring(0, index);
	}

	// 获取公共子串
	private String getCommonStr(String str1, String str2) {
		int index = 0;
		int len = Math.max(str1.length(), str2.length());

		for (int j = 0; j < len; j++) {
			if (str1.charAt(j) != str2.charAt(j)) {
				break;
			}
			index ++;
		}

		return str1.substring(0, index);
	}

	// 解法3：分治法

	// 解法4：二分查找

	// 解法5：先把所有字符串各自排序，然后比较头尾即可。。。
}
