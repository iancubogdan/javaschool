package com.db.javaschool.springdata.jdbc;

enum Side { NONE, LEFT, RIGHT }

public class ChainLink {
    private ChainLink left, right;

    public void append(ChainLink rightPart) {
        if (this.right != null)
            throw new IllegalStateException("Link is already connected.");

        this.right = rightPart;
        rightPart.left = this;
    }

    public Side longerSide() {
        int rightSide = 0;
        int leftSide = 0;

        ChainLink link = this.right;
        while (link != null) {
            if (link == this) {
                return Side.NONE;
            }
            rightSide ++;
            link = link.right;
        }

        link = this.left;
        while (link != null) {
            if (link == this) {
                return Side.NONE;
            }
            leftSide++;
            link = link.left;
        }

        if (rightSide == leftSide) {
            return Side.NONE;
        } else if (rightSide > leftSide) {
            return Side.RIGHT;
        } else {
            return Side.LEFT;
        }
    }

    public static void main(String[] args) {
        ChainLink left = new ChainLink();
        ChainLink middle = new ChainLink();
        ChainLink right = new ChainLink();
        left.append(middle);
        middle.append(right);

        System.out.println(left.longerSide());
    }
}