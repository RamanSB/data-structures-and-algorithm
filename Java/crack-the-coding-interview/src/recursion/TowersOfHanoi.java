package recursion;

import java.util.Stack;

/**
 * 3 towers, N disks of different sizes which can slide on to any tower.
 *
 *   O
 *  OO
 * OOO
 *  A    B   C
 *
 *  Constraints:
 *  - Only 1 disk can be moved at a time
 *  - A disc can only be placed on top of a larger disk
 *  - Discs must move from the top of 1 tower to another.
 *
 *  1) We can move all disks but the largest FROM A to B
 *  2) Move the largest disk from A to C
 *  3) Move all disks from B to C.
 *
 *  If we have 3 (N) Disks:
 *  1) we will move the 2 (N-1) top disks to tower B
 *  2) then move the last disk to tower C.
 *  3) We then move the 2 (N-1) disks from Tower B to Tower C.
    *
 *
 */
public class TowersOfHanoi {

    class Disk {
        int radius;
        Disk(int value){
            this.radius = value;
        }
        public String toString(){
            return this.radius+"";
        }
    }

    Stack<Disk> towerA = new Stack<>();
    Stack<Disk> towerB = new Stack<>();
    Stack<Disk> towerC = new Stack<>();

    public void setUpTowers(int noOfDisks){
        for(int i=noOfDisks; i>0; i--){
            towerA.push(new Disk(i));
        }
    }

    int count = 0;
    //Here we will provide 3 stacks: FROM, INTERMEDIATE & DESTINATION
    public void towersOfHanoi(Stack<Disk> from, Stack<Disk> intermediate, Stack<Disk> destination, int noOfDisks){
        count++;
        if(noOfDisks==1){
            //step 2 on doc string
            Disk disk = from.pop(); //Move bottom most disk to destination
            destination.push(disk);
        }else{
            //Step 1 in doc string
            towersOfHanoi(from, destination, intermediate, noOfDisks-1); //Move (top N-1) disks from origin to intermediate (recurses until 1 disk left)
            Disk disk = from.pop();
            intermediate.push(disk);
            //step 3 in doc string
            towersOfHanoi(intermediate, from, destination, noOfDisks-1); //Move (top N-1) disks from intermediate to destination. (recurses until 1 disk lef)
            disk = intermediate.pop();
            destination.push(disk);
        }
    }


    public static void main(String[] args){
        int noOfDisks = 3;
        TowersOfHanoi towersOfHanoi = new TowersOfHanoi();
        towersOfHanoi.setUpTowers(noOfDisks);
        System.out.println("Tower A:" + towersOfHanoi.towerA);
        System.out.println("Tower B:" + towersOfHanoi.towerB);
        System.out.println("Tower C:" + towersOfHanoi.towerC);

        /*
        The below invocation states we want to move 3 (N) disks [from Tower A to Tower C via Tower B]
         */
        towersOfHanoi.towersOfHanoi(towersOfHanoi.towerA, towersOfHanoi.towerB, towersOfHanoi.towerC, noOfDisks);

        System.out.println("Tower A:" + towersOfHanoi.towerA);
        System.out.println("Tower B:" + towersOfHanoi.towerB);
        System.out.println("Tower C:" + towersOfHanoi.towerC);

        System.out.println("Iterations: " + towersOfHanoi.count);
    }
}
