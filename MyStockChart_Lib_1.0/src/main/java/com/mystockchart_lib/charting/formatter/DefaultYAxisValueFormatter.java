package com.mystockchart_lib.charting.formatter;


import com.mystockchart_lib.charting.components.YAxis;

import java.text.DecimalFormat;

/**
 * Default formatter used for formatting labels of the YAxis. Uses a DecimalFormat with
 * pre-calculated number of digits (depending on max and min value).
 */
public class DefaultYAxisValueFormatter implements YAxisValueFormatter {

    /** decimalformat for formatting */
    private DecimalFormat mFormat;

    /**
     * Constructor that specifies to how many digits the value should be
     * formatted.
     *
     * @param digits
     */
    public DefaultYAxisValueFormatter(int digits) {

        StringBuilder b = new StringBuilder();
        for (int i = 0; i < digits; i++) {
            if (i == 0)
                b.append(".");
            b.append("0");
        }

        mFormat = new DecimalFormat("###,###,###,##0" + b.toString());
    }

    @Override
    public String getFormattedValue(float value, YAxis yAxis) {
        // avoid memory allocations here (for performance)
        return mFormat.format(value);
    }
}