package com.karltech.android.everydaybudget;

/**
 * Created by Angela on 7/1/18.
 */

public class AmountPerDay {

    //class to calculate the amount of money a person receives each day
    private int amountPerDay;
    private int income;
    private int expenses;
    private int savings;

    public int getAmountPerDay() {
        return amountPerDay;
    }

    public void setAmountPerDay(int amountPerDay) {
        this.amountPerDay = amountPerDay;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public int getExpenses() {
        return expenses;
    }

    public void setExpenses(int expenses) {
        this.expenses = expenses;
    }

    public int getSavings() {
        return savings;
    }

    public void setSavings(int savings) {
        this.savings = savings;
    }

    public int calculateAmountPerDay(int income, int expenses, int savings){
        amountPerDay = income - expenses - savings;
        return amountPerDay;
    }
}
