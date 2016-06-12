/*
 * Created by ttdevs at 16-6-12 下午3:37.
 * E-mail:ttdevs@gmail.com
 * https://github.com/ttdevs
 * Copyright (c) 2016 ttdevs
 */

package com.ttdevs.circleview.utils;

import android.graphics.Paint;

public class Utils {

    /**
     * 计算圆弧长度
     *
     * @param radius 圆半径
     * @param angle  夹角度数（非弧度）
     * @return
     */
    public static float getCirclePathLength(int radius, int angle) {
        angle = Utils.changeAngleToSingle(angle);
        return (float) (Math.PI * radius * angle / 180);
    }

    /**
     * 将度数转换成0～360之间的值
     *
     * @param angle
     * @return
     */
    public static int changeAngleToSingle(int angle) {
        while (angle >= 360) {
            angle -= 360;
        }
        while (angle < 0) {
            angle += 360;
        }
        return angle;
    }

    /**
     * 获取文字的宽度
     *
     * @param paint
     * @param str
     * @return
     */
    public static int getTextWidth(Paint paint, String str) {
        int iRet = 0;
        if (str != null && str.length() > 0) {
            int len = str.length();
            float[] widths = new float[len];
            paint.getTextWidths(str, widths);
            for (int j = 0; j < len; j++) {
                iRet += (int) Math.ceil(widths[j]);
            }
        }
        return iRet;
    }

    /**
     * 计算文字的高度
     *
     * @param paint
     * @return
     */
    public static int getTextHeight(Paint paint) {
        Paint.FontMetrics fm = paint.getFontMetrics();
        return (int) Math.ceil(fm.descent - fm.ascent);
    }
}
