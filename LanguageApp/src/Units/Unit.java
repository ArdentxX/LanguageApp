package Units;
import Lessons.Lesson;

public class Unit {
    public int UnitProgress;
    public Lesson lesson;
   public Unit() {
       this.lesson = new Lesson();
   }
   public void makeUnit(){
       if(getUnitProgress()<6){
           lesson.MakeLesson();
           if(lesson.Result>=50) {
               UnitProgress++;
               System.out.println("Unit Progress: " + UnitProgress + "/6");
           }
           else{
               System.out.println("Try Again. "+"Unit Progress: " + UnitProgress + "/6");
           }

       }

   }

   public int getUnitProgress() {
       return UnitProgress;
   }
}
