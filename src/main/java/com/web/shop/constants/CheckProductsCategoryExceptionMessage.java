package com.web.shop.constants;

public final class CheckProductsCategoryExceptionMessage {

    public static final String LEFT_MORE_RIGHT = "The left key is ALWAYS smaller than the right one";
    public static final String COUNT_MIN_MAX = "The smallest left key is ALWAYS equal to 1 AND The largest right key is ALWAYS equal to twice the number of nodes";
    public static final String MOD_RIGHT_LEFT = "The difference between the right and left key is ALWAYS an odd number";
    public static final String MOD_LEFT_LEVEL = "If the node level is an odd number, then the left key is ALWAYS an odd number, the same is true for even numbers";
    public static final String NOT_UNIQUE_NODS = "Keys are ALWAYS unique, regardless of whether it is right or left";


}
