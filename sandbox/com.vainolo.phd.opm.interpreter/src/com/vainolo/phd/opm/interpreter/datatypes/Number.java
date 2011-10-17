package com.vainolo.phd.opm.interpreter.datatypes;

public class Number {
    private long longNumber;
    private double doubleNumber;
    private boolean isDouble;
    private boolean isNull = true;

    private void setNumber(final long longNumber) {
        this.longNumber = longNumber;
        setDouble(false);
        isNull = false;
    }

    private void setNumber(final double doubleNumber) {
        this.doubleNumber = doubleNumber;
        setDouble(true);
        isNull = false;
    }

    public long getLongNumber() {
        if(isNull()) {
            throw new IllegalStateException("Number is null.");
        } else if(isDouble()) { 
            throw new IllegalStateException("Number is not long.");
        }

        return longNumber;
    }

    public double getDoubleNumber() {
        if(isNull()) {
            throw new IllegalStateException("Number is null.");
        } else if(!isDouble()) {
            throw new IllegalStateException("Number is not double.");
        }
        return doubleNumber;
    }

    public boolean isNull() {
        return isNull;
    }

    public void readNumber(String numberString) {
        try {
            long longNumber = Long.parseLong(numberString);
            setNumber(longNumber);
        } catch(NumberFormatException e1) {
            try {
                double doubleNumber = Double.parseDouble(numberString);
                setNumber(doubleNumber);
            } catch(NumberFormatException e2) {
                isNull = true;
            }
        }
    }

    private boolean isDouble() {
        return isDouble;
    }

    private void setDouble(boolean isDouble) {
        this.isDouble = isDouble;
    }

}
