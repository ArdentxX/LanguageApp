//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.loginui.Units;

import com.example.loginui.Lessons.Lesson;

public class Unit {
    public int UnitProgress = 0;
    public Lesson lesson = new Lesson();

    public Unit() {
    }

    public void makeUnit() {
        if (this.getUnitProgress() < 6) {
            this.lesson.MakeLesson();
            if (this.lesson.Result >= 50) {
                ++this.UnitProgress;
                System.out.println("Unit Progress: " + this.UnitProgress + "/6");
            } else {
                System.out.println("Try Again. Unit Progress: " + this.UnitProgress + "/6");
            }
        }

    }

    public int getUnitProgress() {
        return this.UnitProgress;
    }
}
